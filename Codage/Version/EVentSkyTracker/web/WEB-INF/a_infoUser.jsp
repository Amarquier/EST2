<%-- 
    Document    : a_infoUser
    Description : Affiche les informations d'un utilisateur
--%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.persistence.Utils"%>
<%@page import="com.persistence.User"%>
<%@page import="com.metier.ESTSession"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="fr">
<head>
    <title>Infos</title>
    <%@include file="../includes/a_head.jspf"%>
</head>

<body>
<div class="page" data-role="page" id="infoUserPage">
    <div class="header" data-role="header" data-id="main-header" data-tap-toggle="false" 
        data-theme="b" data-position="fixed" data-fullscreen="true">
        <h1>Compte</h1>
        <%@include file="../includes/session.jspf" %>
        <%@include file="../includes/a_user.jspf" %>
        <%
            if(!maSession.isModeExpert()){
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        %>
    </div>
    
    <div role="main" id="mainInfoUser" class="ui-content">
        <br/><br/>
        <br/>
                <div>
            <%
                if(!maSession.isModeExpert()){
                    request.getRequestDispatcher("eventSkyTracker.jsp?action=pbAdminMode").forward(request, response);
                }
                String message = request.getParameter("message");
                if (message != null) {
                    if (message.equalsIgnoreCase("pbAdmin")) {
                        out.print("Vous ne pouvez pas accéder au mode administrateur !");
                    }
                    if (message.equalsIgnoreCase("pbAdminMode")) {
                        out.print("Vous n'êtes pas en mode administrateur ! Seules les personnes en mode administrateur peuvent accéder a cette page.");
                    }
                }
            %>
        </div>
        <h4>Bienvenue dans le mode administrateur.</h4>
        <h3>Informations sur votre compte :</h3>
        <div>
            <table style="margin-left:5%">
                    <tr>
                        <td><strong>Pseudo :</strong></td><td>&emsp;&emsp;<%= user.getPseudo() %></td>
                    </tr>
                    <tr>
                        <td><strong>Nom :</strong></td><td>&emsp;&emsp;<%= user.getUsername() %></td>
                    </tr>
                    <tr>
                        <td><strong>EMail :</strong></td><td>&emsp;&emsp;<%= user.getEmail() %></td>
                    </tr>
                    <tr>
                        <td><strong>Grade :</strong></td><td>&emsp;&emsp;<%= user.getGrade() %></td>
                    </tr>
                    <tr>
                        <td><strong>Première Visite : </strong></td><td>&emsp;&emsp;<%=new SimpleDateFormat("EEEEEEEE dd MMMMMMMMM yyyy à HH:mm").format(user.getRegisterDate())%></td>
                    </tr>
                    <tr>
                        <td><strong>Dernière Visite : </strong></td><td>&emsp;&emsp;<%=new SimpleDateFormat("EEEEEEEE dd MMMMMMMMM yyyy à HH:mm").format(maSessionA.getLastVisitDate())%></td>
                    </tr>
                    <tr>
                        <td><strong>Nombre total de connexions :</strong></td><td>&emsp;&emsp;<%= user.getNbConnexions() %></td>
                    </tr>
                    <tr>
                        <td><strong>Nombre de qualification : </strong></td><td>&emsp;&emsp;<%= user.getNbQualifications() %></td>
                    </tr>                
                    <tr>
            </table>
        </div>
                    <br/>
        <%
        if(user.getGrade()==5){
        %>
                <a href="eventSkyTracker.jsp?action=decoadmin"
                       data-ajax="false" class="ui-btn ui-shadow ui-corner-all ui-btn-a">
                    Sortir du mode administrateur !
                </a><br/>
        <% 
        }
        %>
        <a href="eventSkyTracker.jsp?action=deconnexion"
               class="ui-btn ui-shadow ui-corner-all ui-btn-a">
            Déconnexion
        </a>
    </div>

    <%@include file="../includes/a_footer.jspf" %>
</div>
</body>
</html>
