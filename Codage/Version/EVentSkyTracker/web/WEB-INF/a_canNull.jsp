<%-- 
    Document   : a_canNull.jsp
    Created on : 05 Mai 2014, 16:54:26
    Author     : 
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
        <br/><br/><br/><br/><br/><br/><br/><br/><br/>
        <div class="centrer"><h1>Il n'y a aucune demande de candidate.</h1></div>
        <br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
    </div>
    <%@include file="../includes/a_footer.jspf" %>
</div>
</body>
</html>