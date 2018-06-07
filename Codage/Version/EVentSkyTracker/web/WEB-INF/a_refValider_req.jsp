<%-- 
    Document    : a_refValider_req.jsp
    Description : Valide le remplacement d'une image de reference 
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
    com.metier.ESTSession maSession = (com.metier.ESTSession)session.getAttribute("maSession");
    if (maSession == null) {  
        request.getRequestDispatcher("discovery.jsp?action=pbAdminMode").forward(request, response);
    }
    String userPseudo = request.getParameter("userPseudo").trim();
    String chemin = request.getParameter("chemin").trim();
    
    String tChemin[] = chemin.split("/");
    String nomImage = tChemin[tChemin.length - 1];
    String dateCrt = tChemin[tChemin.length - 2];
    String telescope = tChemin[tChemin.length - 3];
    
    String cheminRef = DiscoApplication.getRefPath()+ "/" + nomImage;
    String rChemin = DiscoApplication.getPath() + "/" + telescope + "/" + dateCrt + "/" + nomImage;
    // on copie l'image comme image de reference
    DiscoApplication.remplacer(rChemin, cheminRef);
    // on suppprime l'info dans la BD
    CanReference.delete(con, userPseudo, chemin);
    out.print("OK");
%>