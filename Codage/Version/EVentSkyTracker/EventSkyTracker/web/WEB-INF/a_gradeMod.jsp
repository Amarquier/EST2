<%-- 
    Document    : a_gestionMod
    Description : Change le grade d'un utilisateur
--%>
<%@page import="com.persistence.User"%>
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
        <%
            User uMod = User.getByPseudo(con, request.getParameter("pseudo"));
            int grade = Integer.parseInt(request.getParameter("grade"));
            uMod.setGrade(grade);
            uMod.save(con);
        %>
        <div class="centrer"><h1>Le grade de <%= request.getParameter("pseudo") %> a été changer.</h1></div>
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