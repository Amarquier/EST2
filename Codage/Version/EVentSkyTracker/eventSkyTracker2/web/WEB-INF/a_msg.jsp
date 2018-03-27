<%-- 
    Document    : a_msg
    Description : Envoi le message à l'utilisateur
    Created on  : 7 mars 2017, 15:40:42
    Author      : 
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="fr">
<head>
    <title>Information</title>
    <%@include file="../includes/a_head.jspf" %>
</head>

<body>
<div class="page" data-role="page" id="homePage">
    <div class="header" data-role="header" data-id="main-header" data-tap-toggle="false" 
        data-theme="b" data-position="fixed" data-fullscreen="true">
        <h1>Compte</h1>
        <%@include file="../includes/session.jspf" %>
        <%@include file="../includes/a_user.jspf" %>
    </div>
    <div role="main" class="ui-content">
        <br/><br/>
        <br/><br/><br/><br/>
        <div class="centrer"><h1><%= request.getParameter("msg") %></h1></div>
        <br/><br/>
        <a href="eventSkyTracker.jsp?action=a_gestionCompte&pseudo=<%= request.getParameter("pseudo") %>" data-ajax="false"
                     class="ui-btn ui-shadow ui-corner-all ui-btn-a"> OK </a>
        <br/>
        <br/><br/>
        <br/><br/>
        <br/><br/>
        <br/><br/>
        <br/><br/>
        <br/><br/>
    </div>
    
    <%@include file="../includes/a_footer.jspf" %>
</div>
</body>
</html>