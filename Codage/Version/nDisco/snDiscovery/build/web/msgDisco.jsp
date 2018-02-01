<%-- 
    Document   : site
    Created on : 05 Mai 2014, 16:54:26
    Author     : 
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="fr">
<head>
    <title>Information</title>
    <%@include file="includes/head.jspf" %>
</head>

<body>
<div class="page  ui-page-theme-b" data-role="page" id="homePage">
    <div class="header" data-role="header" data-id="main-header" data-tap-toggle="false" data-theme="b"
        data-position="fixed" data-fullscreen="true" style="background-color: #4e6c97;">
        <h1>Compte</h1>
        <%@include file="includes/user.jspf" %>
    </div>
    <div role="main" class="ui-content">
        <br/><br/>
        <br/><br/><br/><br/>
        <div class="centrer"><h1><%= request.getParameter("msg") %></h1></div>
        <br/><br/>
        <a href="disco.jsp"
                     class="ui-btn ui-shadow ui-corner-all ui-btn-a"> OK </a>
        <br/>
        <br/><br/>
        <br/><br/>
        <br/><br/>
        <br/><br/>
        <br/><br/>
        <br/><br/>
    </div>
    
    <%@include file="includes/footer.jspf" %>
</div>
</body>
</html>