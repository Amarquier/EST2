<%-- 
    Document   : a_ref.jsp
    Created on : 05 Mai 2016, 16:54:26
    Description : Affiche les demandes de validation de nouvelles images de Ref
    Author     : 
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Date"%>
<%@page import="com.metier.*"%>
<%@page import="com.persistence.*"%>

<!DOCTYPE html>
<html lang="fr">
<head>
    <title>Images</title>
    <%@include file="../includes/a_head.jspf" %>
</head>

<body>
    <div class="page" data-role="page" id="a_Ref_page" data-theme="b"> 
        <%-- le script pour s'exécuter doit être dans la page data-role --%>
        <script type="text/javascript" src="js/a_references.js"></script>

        <div class="header" data-role="header" data-id="main-header" data-tap-toggle="false" 
            data-theme="b" data-position="fixed" data-fullscreen="true">
            <h1>Référence</h1>
            <%@include file="../includes/session.jspf" %>
            <%@include file="../includes/a_user.jspf" %>
        </div>

        <%
            // ici il y a au moins 1 demande en attente
            int i = 1;
            int nbCanRef = CanReference.size(con);
            CanReference can = null;

            String idMove = request.getParameter("idMove");
            // il en a plusieurs, on passe à un autre
            if (idMove != null) {
                i = Integer.parseInt(idMove);
            }
            // il peut y en avoir plusieurs, mais il y en a au moins 1
            can = CanReference.find(con, i);
            String _nom = can.getGalaxieNom();
        %>
        <div role="main" class="ui-content ">
            <br/><br/><br/>
            <div class="mesImages" align="center">
                <a href="#a_ref_popupZoomLeft" id="a_ref_clicZoomLeft" data-rel="popup" class="ui-link">
                    <img id="a_ref_imgobs" alt="erreur:image absente" src="<%=can.getChemin()%>">
                </a>
                <a href="#a_ref_popupZoomRight" id="a_ref_clicZoomRight" data-rel="popup" class="ui-link">
                    <img id="a_ref_imgref" alt=".... aucune référence ...." src="/jpeg/images_SN/refgal/<%=can.getGalaxieRef()%>.jpg">
                </a>
            </div>
            <center>
                <h3>Nouvelle image de référence proposée par : 
                    <strong><div id="a_ref_pseudo"><%=can.getUserPseudo()%></div>
                    </strong>
                </h3>
            </center>
            <table class="a_ref_infosTable">
                <td class="texteCentre" id="a_ref_dateImages"><%=can.getDateDecouverte()%></td>
                <td class="texteCentre" id="a_ref_numImages" >(<%=i%>/<%=CanReference.size(con)%>)</td>
                <td class="texteCentre" id="a_ref_nomGalaxie"><%=can.getGalaxieNom()%></td>
            </table>
            <div align="center">
                <div class="ui-grid-a">
                    <div class="ui-block-a">
                    <%
                        if (i > 1) {
                    %>
                            <a href="discovery.jsp?action=a_ref&idMove=<%=i-1%>" 
                               data-ajax="false" id="a_ref_btnPcdt" data-icon="arrow-l" 
                               data-iconpos="left" data-role="button">
                               Précédent
                            </a>
                    <%
                        }
                        else { 
                    %>
                            <a href="#" id="a_ref_btnPcdt" data-icon="arrow-l" data-iconpos="left" 
                               class="ui-state-disabled" data-role="button">
                                Précédent
                            </a> 
                    <%
                        }
                    %>
                    </div>
                    <div class="ui-block-b">
                    <%
                        if  (i+1 > nbCanRef) { 
                    %>
                            <a href="#" id="a_ref_btnSvt" data-icon="arrow-r" data-iconpos="right" 
                                 class="ui-state-disabled" data-role="button">
                                Suivant
                            </a>
                    <%
                        }
                        else { 
                    %>
                            <a href="discovery.jsp?action=a_ref&idMove=<%=i+1%>" 
                               data-ajax="false" id="a_ref_btnSvt" data-icon="arrow-r" 
                               data-iconpos="right" data-role="button">
                                Suivant
                            </a>
                    <%
                        }
                    %>
                    </div>
                </div>
            </div>
            <div class="ui-grid-a">
                <div class="ui-block-b">
                    <a href="#" id="a_ref_btnValider" data-rel="button"
                       class="ui-btn ui-corner-all ui-shadow">Valider</a>
                </div>
                <div class="ui-block-b">
                    <a href="#" id="a_ref_btnRefuser" data-rel="button"
                       class="ui-btn ui-corner-all ui-shadow">Refuser</a>
                </div>
            </div>
        </div>
        <%@include file="../includes/a_footer.jspf" %>
    </div>
                    
    <!-- popup message en mode modal-->
    <div id="popupMsg" data-role="popup" data-theme="a" data-overlay-theme="b"
         class="ui-corner-all ui-alt-icon" data-corners="true" data-position-to="window">
        <div class="mesPopups" align="center">
            <br/>
            <h3 id="popupTextMsg">Attendez, je gère votre demande !</h3>
            <div class="progressBar"><div></div></div>
            <br/>
        </div>
    </div>
</body>
</html>
