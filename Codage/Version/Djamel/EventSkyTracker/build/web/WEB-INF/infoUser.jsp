<<%-- 
    Document    : infoUser
    Description : Affiche les informations de l'utilisateur connecté
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
    <%@include file="../includes/head.jspf"%>
</head>

<body>
<div class="page" data-role="page" id="infoUserPage">
    
    <div class="header" data-role="header" data-id="main-header" data-tap-toggle="false" 
        data-theme="a" data-position="fixed" data-fullscreen="true">
        <h1>Compte</h1>
        <%@include file="../includes/session.jspf" %>
        <%@include file="../includes/user.jspf" %>
    </div>
    
    <div role="main" id="mainInfoUser" class="ui-content">
        <br/><br/>
        <br/>
                <div>
            <%
                String message = request.getParameter("message");
                if (message != null) {
                    if (message.equalsIgnoreCase("pbAdmin")) {
                        out.print("Vous ne pouvez pas accéder au mode administrateur !");
                    }
                }
            %>
        </div>
        <%
            maSession = (ESTSession)session.getAttribute("maSession");
            user = maSession.getUser();
        %>
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
                        <td><strong>Dernière Visite : </strong></td><td>&emsp;&emsp;<%=new SimpleDateFormat("EEEEEEEE dd MMMMMMMMM yyyy à HH:mm").format(maSession.getLastVisitDate())%></td>
                    </tr>
                    <tr>
                        <td><strong>Nombre total de connexions :</strong></td><td>&emsp;&emsp;<%= user.getNbConnexions() %></td>
                    </tr>
                    <tr>
                        <td><strong>Nombre de qualification : </strong></td><td>&emsp;&emsp;<%= user.getNbQualifications() %></td>
                    </tr>                
            </table>
        </div>
        
        <br/>
        <a href="eventSkyTracker.jsp?action=changerProfil"
               class="ui-btn ui-shadow ui-corner-all ui-btn-a">
            Modifier
        </a>
        <a href="eventSkyTracker.jsp?action=contact" data-theme="a" 
          class="ui-btn ui-shadow ui-corner-all ui-btn-a">
            Contacter l'administrateur !
        </a>
        <%
        if(user.getGrade()==5){
        %>
                <br/>
                <a href="eventSkyTracker.jsp?action=reqAdmin" data-ajax="false" 
                   accesskey=""class="ui-btn ui-shadow ui-corner-all ui-btn-a">
                    Passer en mode administrateur !
                </a>
                <br/><br/>
        <% 
        }
        %>
        <a href="eventSkyTracker.jsp?action=deconnexion"
               class="ui-btn ui-shadow ui-corner-all ui-btn-a">
            Déconnexion
        </a>
    </div>

    <%@include file="../includes/footer.jspf" %>
</div>
</body>
</html>
