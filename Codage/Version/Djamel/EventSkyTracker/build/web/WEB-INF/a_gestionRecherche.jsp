<%-- 
    Document    : a_gestionRecherche
    Description : Recherche une personne dans les utilisateurs
--%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.persistence.Utils"%>
<%@page import="com.persistence.User"%>
<%@page import="com.metier.ESTSession"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="fr">
    <head>
        <title>Recherche : <%=request.getParameter("recherche")%></title>
        <%@include file="../includes/a_head.jspf"%>
    </head>

    <body>
    <div class="page" data-role="page" id="infoUserPage">
        <div class="header" data-role="header" data-id="main-header" data-tap-toggle="false" 
                    data-theme="b" data-position="fixed" data-fullscreen="true">
            <h1>Recherche : <%=request.getParameter("recherche")%></h1>
            <%@include file="../includes/session.jspf" %>
            <%@include file="../includes/a_user.jspf" %>
        </div>
        <div role="main" id="mainInfoUser" class="ui-content">
            <br/><br/><br/>
            <div>
                <%
                    if(!maSession.isModeExpert()){
                        request.getRequestDispatcher("eventSkyTracker.jsp?action=pbAdminMode").forward(request, response);
                    }
                %>
            </div>
            <%
                User uRecherche;
                int nbrUser;
                int size = User.sizeRecherche(con, request.getParameter("recherche"));
                String nUser = request.getParameter("nbrUser");
                if(nUser==null){
                    nbrUser=1;
                }
                else{
                    nbrUser = Integer.parseInt(nUser);
                }
                if(request.getParameter("recherche")!=null){
                    if(User.findByPseudo(con,nbrUser ,request.getParameter("recherche"))==null){
                        uRecherche = User.find(con, nbrUser);
                        size = User.size(con);
                        %>
                        <h3 style="color:red;">Aucun utilisateur ne correspond a : <strong><%=request.getParameter("recherche")%></strong></h3>
                        <p>Liste des utilisateurs :</p>
                    <%}
                    else{
                        uRecherche = User.findByPseudo(con,nbrUser ,request.getParameter("recherche"));
                        %>
                        <p>Liste des utilisateurs similaires à <strong><%=request.getParameter("recherche")%></strong> :</p>
                        <%
                    }
                }
                else{
                    uRecherche = User.find(con, nbrUser);
                }
            %>
            <div style="padding:8px; padding-left:6px; border:1px dotted; margin: 6px; ">
                <h3>Informations sur le compte :</h3>
                <table style="margin-left:5%">
                        <tr>
                            <td><strong>Pseudo :</strong></td><td>&emsp;&emsp;<%= uRecherche.getPseudo() %></td>
                        </tr>
                        <tr>
                            <td><strong>Nom :</strong></td><td>&emsp;&emsp;<%= uRecherche.getUsername() %></td>
                        </tr>
                        <tr>
                            <td><strong>EMail :</strong></td><td>&emsp;&emsp;<%= uRecherche.getEmail() %></td>
                        </tr>
                        <tr>
                            <td><strong>Grade :</strong></td><td>&emsp;&emsp;<%= uRecherche.getGrade() %></td>
                        </tr>
                        <tr>
                            <td><strong>Première Visite : </strong></td><td>&emsp;&emsp;<%=new SimpleDateFormat("EEEEEEEE dd MMMMMMMMM yyyy à HH:mm").format(uRecherche.getRegisterDate())%></td>
                        </tr>
                        <tr>
                            <td><strong>Dernière Visite : </strong></td><td>&emsp;&emsp;<%=new SimpleDateFormat("EEEEEEEE dd MMMMMMMMM yyyy à HH:mm").format(uRecherche.getLastVisitDate())%></td>
                        </tr>
                        <tr>
                            <td><strong>Nombre total de connexions :</strong></td><td>&emsp;&emsp;<%= uRecherche.getNbConnexions() %></td>
                        </tr>
                        <tr>
                            <td><strong>Nombre de candidates : </strong></td><td>&emsp;&emsp;<%= uRecherche.getNbQualifications()%></td>
                        </tr>                
                </table>
            </div>
            <a href="eventSkyTracker.jsp?action=a_gestionCompte&pseudo=<%=uRecherche.getPseudo()%>" class="ui-btn ui-shadow ui-corner-all ui-btn-a">
                Modifier
            </a>
            <hr/>
            <div class="ui-grid-d">
                <div class="ui-block-a">
                    <div class="ui-grid-a">
                        <div class="ui-block-a"></div>
                        <div class="ui-block-b"><a data-transition="fade" class="ui-btn ui-corner-all ui-shadow" href="eventSkyTracker.jsp?action=a_gestionRecherche&recherche=<%=request.getParameter("recherche")%>&nbrUser=1">|<<</a></div>
                    </div>
                </div>
                <div class="ui-block-b">
                <div class="ui-grid-a">
                    <div class="ui-block-a"><a data-transition="fade" class="ui-btn ui-corner-all ui-shadow" href="#"><<</a></div>
                    <%            
                    if(nbrUser>1){%>
                        <div class="ui-block-b"><a data-transition="fade" class="ui-btn ui-corner-all ui-shadow" href="eventSkyTracker.jsp?action=a_gestionRecherche&recherche=<%=request.getParameter("recherche")%>&nbrUser=<%=nbrUser-1%>"><</a></div>
                    <%}
                    else{%>
                        <div class="ui-block-b"><a data-transition="fade" class="ui-btn ui-corner-all ui-shadow" href="#"><</a></div>
                    <%}
                    %>
                </div>
                </div>
                <div class="ui-block-c">
                    <div class="ui-block-a"></div>
                    <div class="ui-block-b"></div>            
                </div>
                <div class="ui-block-d">
                <div class="ui-grid-a">
                    <%            
                    if(nbrUser<size){%>
                        <div class="ui-block-a"><a data-transition="fade" class="ui-btn ui-corner-all ui-shadow" href="eventSkyTracker.jsp?action=a_gestionRecherche&recherche=<%=request.getParameter("recherche")%>&nbrUser=<%=nbrUser+1%>">></a></div>
                    <%}
                    else{%>
                        <div class="ui-block-b"><a data-transition="fade" class="ui-btn ui-corner-all ui-shadow" href="#">></a></div>
                    <%}
                    %>
                    <div class="ui-block-b"><a data-transition="fade" class="ui-btn ui-corner-all ui-shadow" href="#">>></a></div>
                </div>
                </div>
                <div class="ui-block-e">
                <div class="ui-grid-a">
                    <div class="ui-block-a"><a data-transition="fade" class="ui-btn ui-corner-all ui-shadow" href="eventSkyTracker.jsp?action=a_gestionRecherche&recherche=<%=request.getParameter("recherche")%>&nbrUser=<%=size%>">>>|</a></div>
                    <div class="ui-block-b"></div>
                </div>
                </div>
            </div>
        </div>
        <%@include file="../includes/a_footer.jspf" %>
        </div>
    </body>
</html>