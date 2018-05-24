<%-- 
    Document    : qualifier.jsp
    Description : Page qui permet de qualifier une candidate.
    Created on  : 3 Avril 2017
--%>
<%@page import="java.util.Random"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.persistence.ConnexionMySQL"%>
<%@page import="com.persistence.Evenement"%>
<%@page import="com.persistence.CandidateEST"%>
<%@page import="com.persistence.ImageEST"%>
<%@page import="com.metier.ESTSession"%>
<%@page import="com.metier.DiscoApplication"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="fr">
    <head>
        <title>Images</title>
        <%@include file="includes/head.jspf"%>
        <link rel="stylesheet" href="css/images.css">
    </head>
    <body>
        <div class="page" data-role="page" id="PageQualifier">
            <%@include file="includes/session.jspf" %>
            <%@include file="includes/qualifierHeader.jspf" %>
            
            <div role="main" class="ui-content">
                <script type="text/javascript" src="js/qcm_qualifier.js"></script> 
                <script type="text/javascript" src="js/slider.js"></script>
                <br> <br/><br> <br/><br> <br/><br> <br/><br> <br/>
                <center>
                    <a id="btnImageSn" class="ui-btn bouton" data-role="button" onclick="window.location.href='qualifierSN.jsp'" >Supernovae</a>
                    <br> <br/><br> <br/><br> <br/>
                    <a id="btnImageEST" class="ui-btn bouton" data-role="button" onclick="window.location.href='qualifierEST.jsp'">Kilonovae</a>
                </center>
                <br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
                <%@include file="includes/footer.jspf" %>
            </div>
        </div>      
    </body>
</html>
