<%-- 
    Document    : mailConfirme.jsp
    Description : page pour l'affichage de la confirmation de l'envoi du mail
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="fr">
    <head>
        <title>Information</title>
        <%@include file="includes/head.jspf" %>
    </head>

    <body>
        <div class="page" data-role="page" id="homePage">
            <div class="header" data-role="header" data-id="main-header" data-tap-toggle="false" 
                        data-theme="a" data-position="fixed" data-fullscreen="true">
                <h1>Compte</h1>
                <%@include file="includes/session.jspf" %>   
                <%@include file="includes/user.jspf" %>
            </div>
            <div role="main" class="ui-content">
                <br/><br/><br/><br/><br/><br/>
                <div class="centrer">
                    <h1><%= request.getParameter("msg") %></h1>
                </div>
                <br/><br/>
                <a href="compte.jsp" class="ui-btn ui-shadow ui-corner-all ui-btn-a">OK</a>
                <br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
            </div>
            <%@include file="includes/footer.jspf" %>
        </div>
    </body>
</html>