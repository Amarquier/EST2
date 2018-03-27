<%-- 
    Document    : a_gestionHistorique
    Description : Affiche l'historique d'un utilisateur
    Created on  : 15/06/2017, 15:40:42
    Author      : Sanson
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="com.persistence.Utils"%>
<%@page import="com.persistence.Evenement"%>
<%@page import="com.persistence.Candidate"%>
<%@page import="com.persistence.User"%>
<%@page import="com.persistence.Qualification"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.persistence.ConnexionMySQL"%>
<%@page import="com.metier.ESTSession"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Historique</title> 
        <%@ include file="../includes/a_head.jspf" %> 
    </head>
    <body>
    <div class="header" data-role="header" data-id="main-header" data-tap-toggle="false" 
        data-theme="b" data-position="fixed" data-fullscreen="true">
            <h1>Historique</h1>
        <%@include file="../includes/session.jspf" %>
        <%@include file="../includes/a_user.jspf" %>
        </div>
        <div role="main" class="ui-content">
            <%
            ArrayList<Qualification> qualif = new ArrayList<Qualification>();
            String pUser = request.getParameter("pseudo");
            out.print("<br/>" +"<br/>"+ "<br/>");
            
                qualif = Qualification.listeByPseudo(con, pUser);
                if (qualif.size() > 0){ 
                    for(int i = 0;i<qualif.size();i++){
                out.println("<div data-role='collapsible' data-collapsed-icon='carat-d'"
                        +"class='ui-alt-icon' data-expanded-icon='carat-u'>");
                out.print("<h4>");
                    
                Candidate candidateCrt = Candidate.getById(con, qualif.get(i).getCanId());
                Evenement eventCrt = Evenement.getById(con,candidateCrt.getEventId());
                    
                out.print("Evenement : " + eventCrt.getIdOfficiel() + "<br/>");
                out.print("Candidate : " + candidateCrt.getId() + "<br/>");
                out.print("Qualification du " + Utils.toString(qualif.get(i).getDate()) + " par ");
                out.print(qualif.get(i).getUserPseudo() + "<br/>");
                out.print("</h4>");
                out.print("<p>");
                    
                String questionnaire = qualif.get(i).getQuestionnaire();
                    
                String[] parts = questionnaire.split("\\|");
                    
                for(int k = 0; k<parts.length; k +=2){
                    out.print(parts[k] + " : ");
                    out.print(parts[k + 1] + "<br/>");
                }
                out.println("</p>");
                
                
                out.println("</div>");
                }
                }
                else{
                    out.print("<br/>" +"<br/>"+ "<br/>");
                    out.print("<h4 align= ' center '>Aucune qualification faite par cet utilisateur <h4>");
                }
            out.print("<br/>" +"<br/>"+ "<br/>");
            %>
        </div>
        <footer>
            <%@ include file="../includes/a_footer.jspf" %>
        </footer>
    </body>
</html>