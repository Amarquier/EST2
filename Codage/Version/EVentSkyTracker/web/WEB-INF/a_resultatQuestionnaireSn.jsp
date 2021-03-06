 <%-- 
    Document   : a_can.jsp
    Created on : 05 Mai 2014, 16:54:26
    Author     : 
--%>
<%@page import="java.awt.image.BufferedImage"%>
<%@page import="javax.imageio.ImageIO"%>
<%@page import="java.io.File"%>
<%@page import="java.io.File"%>
<%@page import="java.text.SimpleDateFormat"%>
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
        <div class="page" data-role="page" id="discoPage" data-theme="a">
            <div class="header" data-role="header" data-id="main-header" data-tap-toggle="false" 
                data-theme="b" data-position="fixed" data-fullscreen="true">
                <h1>Valider</h1>
                <%@include file="../includes/session.jspf" %>
                <%@include file="../includes/a_user.jspf" %>
            </div>
        

        <div role="main" class="ui-content ">
            <script type="text/javascript" src="js/a_candidates.js"></script>
            <%
                int i=1;
                User userDisco = null;
                int totalSize = 0; 
                        
                String idMove = request.getParameter("idMove");
                if (idMove != null) {
                    i = Integer.parseInt(idMove);
                }
                CandidateSN can = CandidateSN.find(con, i);
                if (can == null) {
            %>
            <%@include file="../includes/espace.jspf" %>
            <div>Pas de candidate</div>
            <br>
            <br>
            <center> Pas de candidate </center>
        </div>
        <%@include file="../includes/a_footer.jspf" %>
            <%
                }
                else {
                    userDisco = User.getByPseudo(con, can.getUserPseudo());
                    totalSize = CandidateSN.size(con);
            %>
            
            
            <input type="hidden" id="i" value="<%=i%>"/>
            <input type="hidden" id="cX" value="<%=can.getX()%>"/>
            <input type="hidden" id="cY" value="<%=can.getY()%>"/>
            <input type="hidden" id="nomGal" value="<%=can.getNomImage()%>"/>
            <% String tabTele[] = can.getChemin().split("/");%>
            <input type="hidden" id="nomTele" value="<%=tabTele[2]%>"/>
            <br/><br/><br/>
            <div class="mesImages" align="center">
                <canvas style="position:absolute;" id="canvasObs" ></canvas>
                <img name="imgobs" id="imgobs" alt="erreur:image absente" src="<%=can.getChemin()+can.getNomImage()%>.jpg">
                <img id="imgref" alt=".... aucune référence ...." src="/jpeg/images_SN/refgal/<%=can.getNomImage()%>.jpg">
            </div>
            <table class="infosTable">
                <td class="texteCentre" id="dateImages"><%=can.getDateDisco()%></td> 
                <td class="texteCentre" id="numImages" >(<%=i%>/<%=can.size(con)%>)</td>
                <td class="texteCentre" id="nomGalaxie"><%=can.getNomImage()%></td>
            </table>
            <table class="infosTable">
                <td class="texteCentre" id="certitude">Degré de certitude : <%=can.getCertitude()%>/5</td>
            </table>
            
            <div align="center">
                <div class="ui-grid-a">
                    <div class="ui-block-a">
                        <%
                        if(i>1){
                        %>
                        <a href="discovery.jsp?action=a_can&idMove=<%=i-1%>" data-ajax="false" 
                           id="btnPcdt" data-icon="arrow-l" data-iconpos="left" data-role="button">
                            Précédent
                        </a>
                        <%}
                        else{%>
                        <a href="#" id="btnPcdt" data-icon="arrow-l" data-iconpos="left" 
                           class="ui-state-disabled" data-role="button">
                            Précédent
                        </a>  
                        <%}%>
                    </div>
                    <div class="ui-block-b">
                        <%
                        if (i+1 > totalSize) { %>
                        <a href="#" id="btnSvt" data-icon="arrow-r" data-iconpos="right" 
                             class="ui-state-disabled" data-role="button">
                            Suivant
                        </a>
                        <%}
                        else{%>
                        <a href="discovery.jsp?action=a_can&idMove=<%=i+1%>" data-ajax="false" id="btnSvt" data-icon="arrow-r" data-iconpos="right" 
                             data-role="button">
                            Suivant
                        </a>
                        <%}
                        %>
                    </div>
                </div>
            </div>
            <div class="ui-grid-a">
                <div class="ui-block-a">
                    <a onclick="afficheHisto()" href="#popupHisto" id="btnHisto" data-rel="popup" data-position-to="window" 
                    class="ui-btn ui-corner-all ui-shadow">
                        Histo
                    </a>
                </div>   
                <div class="ui-block-b">
                    <a onclick="afficheInfos()" href="#popupInfos" id="btnInfos" data-rel="popup" data-position-to="window" 
                    class="ui-btn ui-corner-all ui-shadow">
                        Infos
                    </a>
                </div>
            </div>
            <div class="ui-grid-b">
                    <div class="ui-block-a" style="text-align:center;">
                        Proposé par : <%=can.getUserPseudo()%>
                    </div>
                    <div class="ui-block-b" style="text-align:center;">
                    <%
                        for (int nb = 1; nb <= user.getGrade(); nb++) {
                        out.print(" <img src='images/star.gif'>");
                        }
                    %>
                    </div>
                    <div class="ui-block-c" style="text-align:center;">
                        Le : <%
                            SimpleDateFormat type = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                            java.util.Date date = type.parse(can.getDateDecouverte());
                            SimpleDateFormat convert = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                            String dateDisco = convert.format(date).toString();
                        %>    
                        <%=dateDisco%>
                    </div>
            </div>
            <br/>
            <center>

            </center> 
            <br/>
            <div class="ui-grid-a">
                <div class="ui-block-a">               
                    <a href="#popupValider" data-rel="popup" data-position-to="window"
                   data-role="button"  data-transition="pop">
                        Valider
                    </a>
                </div>
                <div class="ui-block-b">
                    <a href="#popupRefuser" data-rel="popup" data-position-to="window"
                   data-role="button"  data-transition="pop">
                        Refuser
                    </a>
                </div>
            </div>
        </div>
        <%@include file="../includes/a_footer.jspf" %>

        <!-- POP UP-->

        <!-- popup infos -->
        <div id="popupInfos" data-role="popup" data-theme="a" data-overlay-theme="b"
             class="ui-corner-all ui-alt-icon" data-corners="true" data-position-to="window">
            <a href="#" data-rel="back" class="ui-btn ui-corner-all ui-shadow 
                 ui-btn-a ui-icon-delete ui-btn-icon-notext ui-btn-right">
                Fermer
            </a>
            <div class="mesPopups">
                <h3 id="nomInfos">Nom:</h3>
                <label id="catInfos">Catégorie:</label>
                <label id="textInfos">Informations:</label>
                <label id="nbNovInfos">Supernovae découvertes:</label>
                <label id="adrInfos">Ascension droite (degré):</label>
                <label id="decInfos">Déclinaison (degré):</label>
                <label id="distInfos">Distance (mal):</label>
                <label id="magInfos">Magnitude:</label>
            </div>
        </div>

        <!-- popup blink -->
        <div id="popupBlink" data-role="popup" data-theme="a" data-overlay-theme="b"
               class="ui-corner-all ui-alt-icon" data-corners="true" data-position-to="window">
            <a href="#" data-rel="back" class="ui-btn ui-corner-all ui-shadow 
                 ui-btn-a ui-icon-delete ui-btn-icon-notext ui-btn-right">
                Fermer
            </a>
            <div class="mesPopups">
                <h3 id="nomBlink"></h3>
                <div>
                    <img id="imgBlink" src="images/black.jpg"/>
                </div>
                <br/>
            </div>
        </div>

        <!-- popup Historique -->
        <div id="popupHisto" data-role="popup" data-theme="a"
               class="ui-corner-all ui-alt-icon" data-corners="true" data-position-to="window">
            <a href="#" data-rel="back" class="ui-btn ui-corner-all ui-shadow 
                 ui-btn-a ui-icon-delete ui-btn-icon-notext ui-btn-right">
                Fermer
            </a>
            <div>
                <h3 id="nomHisto"></h3>
                <div id="imgHisto">
                    <div>
                        <img id="imgHisto1" src="images/black.jpg"/>
                        <img id="imgHisto2" src="images/black.jpg"/>
                    </div>
                    <div>
                        <img id="imgHisto3" src="images/black.jpg"/>
                        <img id="imgHisto4" src="images/black.jpg"/>
                    </div>
                    <div>
                        <img id="imgHisto5" src="images/black.jpg"/>
                        <img id="imgHisto6" src="images/black.jpg"/>
                    </div>
                </div>
            </div>
        </div>

        <!-- popup valider -->
        <div id="popupValider" data-role="popup" data-theme="a" data-overlay-theme="b"
             class="ui-corner-all" data-corners="true" data-position-to="window">
            <a href="#" data-rel="back" class="ui-btn ui-corner-all ui-shadow
               ui-btn-a ui-icon-delete ui-btn-icon-notext ui-btn-right" style="background-color:black;">
                Fermer
            </a>
            <div class="mesPopups"> 
                <center>
                    <%@include file="../includes/espace.jspf" %>
                    <p><br/>Voulez-vous valider cette supernova ?<br/><strong>Cette action est irréversible</strong></p>
                </center>
                <form id="formValider" method="post" action="discovery.jsp?action=a_canValider_req">
                    <input type="hidden" name="userDisco" id="userDisco" value="<%=userDisco.getPseudo()%>"/>
                    <input type="hidden" name="nomImage" id="nomImage" value="<%=can.getNomImage()%>"/>
                    <input type="hidden" name="chemin" id="chemin" value="<%=can.getChemin()%>"/>
                    <input type="hidden" name="certitude" id="certitude" value="<%=can.getCertitude()%>"/>
                    <input type="hidden" name="x" id="x" value="<%=can.getX()%>"/>
                    <input type="hidden" name="y" id="y" value="<%=can.getY()%>"/>
                    <input type="hidden" name="dateDecouverte" id="dateDecouverte" value="<%=can.getDateDecouverte()%>"/>
                    <div>
                        Changer le grade de l'utilisateur
                            <input type="range" name="grade" id="grade" value="<%=userDisco.getGrade()%>" min="1" max="5" step="1" data-highlight="true" />
                    </div>
                    <br/>
                    Envoyer un mail à l'utilisateur
                    <br/><br/>
                    <strong>Objet:</strong>
                        <strong><textarea style="FONT-FAMILY: Verdana" rows=1 name="objet" id="objet" placeholder="">
Votre proposition du supernova a été validée !</textarea>
                    <br>
                    <strong>Contenu:</strong>
                        <textarea style="FONT-FAMILY: Verdana" rows=5 name="contenu" id="contenu" placeholder="">Bonjour,

Félicitation vous êtes le premier a trouver cette supernova.
                        </textarea>
                    <div class="ui-grid-a">
                        <div class="ui-block-a">
                            <button id="btnConfirmCandidat" class="ui-btn ui-corner-all">Valider</button>
                   </div>
                </form>         
                        <div class="ui-block-b">
                            <a href="#" id="btnNon" data-rel="back" data-position-to="window" 
                               class="ui-btn ui-corner-all ui-shadow" data-transition="pop">
                                Annuler
                            </a>
                        </div>
                    </div>
            </div>
        </div>

        <!-- popup refuser-->
        <div id="popupRefuser" data-role="popup" data-theme="a" data-overlay-theme="b"
             class="ui-corner-all" data-corners="true" data-position-to="window">
            <a href="#" data-rel="back" class="ui-btn ui-corner-all ui-shadow
               ui-btn-a ui-icon-delete ui-btn-icon-notext ui-btn-right" style="background-color:black;">
                Fermer
            </a>
            <div class="mesPopups">
                <%@include file="../includes/espace.jspf" %>
                <form id="formRefuser" method="post" action="discovery.jsp?action=a_canRefuser_req">
                    <input type="hidden" name="userDisco" id="userDisco" value="<%=userDisco.getPseudo()%>"/>
                    <input type="hidden" name="nomImage" id="nomImage" value="<%=can.getNomImage()%>"/>
                    <input type="hidden" name="chemin" id="chemin" value="<%=can.getChemin()%>"/>
                    <input type="hidden" name="dateDecouverte" id="dateDecouverte" value="<%=can.getDateDecouverte()%>"/>
                    <input type="hidden" name="certitude" id="certitude" value="<%=can.getCertitude()%>"/>
                    <center>
                        <p><br/>Voulez-vous refuser cette supernova ? <br/><strong>Cette action est irréversible</strong></p>
                    </center>
                    <br/>Envoyer un mail à l'utilisateur<br/><br/>
                    <strong>Objet:</strong>
                    <strong><textarea style="FONT-FAMILY: Verdana" rows=1 name="objet" id="objet" placeholder="">Votre proposition du supernova a été refusée !</textarea>
                    <br>Contenu: 
                    <textarea style="FONT-FAMILY: Verdana" rows=5 name="contenu" id="contenu" placeholder="">Bonjour, désolé mais votre proposition de supernova n'est pas correcte. En effet...</textarea>
                    <div class="ui-grid-a">
                        <div class="ui-block-a">
                            <button id="btnRefuserCandidat" class="ui-btn ui-corner-all">Valider</button>
                        </div>     
                        <div class="ui-block-b">
                            <!--  a vérifier ??? -->
                            <a href="#" id="btnNon" data-rel="back" data-position-to="window" 
                                        class="ui-btn ui-corner-all ui-shadow" data-transition="pop">
                                Annuler
                            </a>
                        </div>
                    </div>   
                </form>
            </div>
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
        <%
            }
        %>
        </div>
    </body>
</html>
