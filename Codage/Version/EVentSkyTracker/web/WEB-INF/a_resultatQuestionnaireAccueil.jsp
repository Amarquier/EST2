<%-- 
    Document    : a_resultatQuestionnaire
    Description : Affiche les qualifications faites selon l'évènement
    Created on  : 20 avril 2017, 15:40:42
    Author      : SANSON
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="com.persistence.Utils"%>
<%@page import="com.persistence.Evenement"%>
<%@page import="com.persistence.CandidateEST"%>
<%@page import="com.persistence.CandidateSN"%>
<%@page import="com.persistence.User"%>
<%@page import="com.persistence.Qualification"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.persistence.ConnexionMySQL"%>
<%@page import="com.metier.ESTSession"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link type="text/css" rel="stylesheet" href="css/images.css" />
<!DOCTYPE html>
<html>
    <head>
        <title>Qualification candidates</title> 
        <%@ include file="../includes/a_head.jspf" %> 
    </head>

    <body>
        <div class="header" data-role="header" data-id="main-header" data-tap-toggle="false" 
             data-theme="b" data-position="fixed" data-fullscreen="true">
            <h1>Qualification candidates</h1>
            <%@include file="../includes/session.jspf" %>
            <%@include file="../includes/a_user.jspf" %>
        </div>
        <br> <br> <br> <br> 
        <div role="main" class="ui-content">
           
            <div data-role="content">
                <br/><br/>
              <!--  <h3>La vie des étoiles</h3>
                <p>Si, par une belle nuit étoilée, nous regardons certaines régions du ciel, nous pouvons distinguer une grande variété de couleurs : des milliers d’étoiles de luminosités différentes.
                    D’où vient cette énergie émise en partie sous forme de lumière ? </p>            
                
                <center><div class="mesImages">
                        <img style="border-radius: 8px;  " 
                             src="images/tuto1.png"/> 
                        <p>Source : blogs.futura-sciences.com</p>
                    </div></center>
                <br/>
                <p>Depuis la découverte de la relativité restreinte par Einstein, les astronomes ont expliqué le processus utilisé dans les étoiles pour produire leur énergie : elles transforment l’hydrogène en hélium. 
                </p>
                <p>Cette nucléosynthèse est accompagnée d’une perte de masse qui correspond, selon la formule E=MC², à l’énergie produite. Cette réaction fait que l’étoile évolue et, a donc un début et une fin. </p>
              -->  
                <br> <br/>
                <br> <br/>
              
                
                
                
                <a id="btnQualSn" class="ui-btn bouton_a" data-role="button" onclick="window.location.href='eventSkyTracker.jsp?action=a_resultatQuestionnaireSn'" > <br><br/>Supernovae</a>
                     <br> <br/> 
                     <br> <br/>
                     <br> <br/>
                     <a id="btnQualEST" class="ui-btn bouton_a" data-role="button" onclick="window.location.href='eventSkyTracker.jsp?action=a_resultatQuestionnaire'"><br><br/>Kilonovae</a>
                
                <br> <br/>
                <br/> <br/>
            </div>
            
            <div data-role="content">
                <form id="qualifier"></form>
            </div>
        </div>



        <br/><br/><br/>



        <footer>
            <%@ include file="../includes/a_footer.jspf" %>
        </footer> 

</body>
</html>