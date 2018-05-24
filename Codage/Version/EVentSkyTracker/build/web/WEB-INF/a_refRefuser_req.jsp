<%-- 
    Document    : a_refRefuser_req.jsp
    Description : Annuler le remplacement d'une image de reference 
    Created on  : 16 Juin 2015, 15:40:42
    Author      : 
--%>

<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.metier.*"%>
<%@page import="com.persistence.*"%>
<%@page pageEncoding="UTF-8"%>
<jsp:useBean id="monAppli" scope="application" class="com.metier.DiscoApplication"/>
<%
    Connection con = (Connection) session.getAttribute("con");
    if (con == null) {
        con = ConnexionMySQL.newConnexion();
        session.setAttribute("con", con);
    }
    com.metier.DiscoSession maSession = (com.metier.DiscoSession)session.getAttribute("maSession");
    if (maSession == null) {  
        request.getRequestDispatcher("discovery.jsp?action=pbAdminMode").forward(request, response);
    }
    String userPseudo = request.getParameter("userPseudo").trim();
    String chemin = request.getParameter("chemin").trim();
    // on suppprime l'info dans la BD
    CanReference.delete(con, userPseudo, chemin);
    out.print("OK");
%>