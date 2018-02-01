<%-- 
    Document    : a_gestionContact
    Description : Contacter un utilisateur
--%>

<%@page import="java.sql.Connection"%>
<%@page import="com.metier.*"%>
<%@page import="com.persistence.*"%>
<%@page pageEncoding="UTF-8"%>

<jsp:useBean id="monAppli" scope="application" class="com.metier.ESTApplication"/>
<%
    Connection con = (Connection) session.getAttribute("con");
    if (con == null)
        con = ConnexionMySQL.newConnexion();
    session.setAttribute("con", con);
    String pseudo  = request.getParameter("pseudo");
    String objet     = request.getParameter("objet");
    String contenu     = request.getParameter("contenu");
    // lui envoyer le mail de confirmation
    String mail = contenu;
    User user = User.getByPseudo(con, pseudo);
    String to = user.getEmail();
    boolean ok = SmtpSend.sendMessage(objet, mail, to);  
    if (ok) {
        request.getRequestDispatcher("../eventSkyTracker.jsp?action=a_msg&msg=Le mail a correctement été envoyé.").forward(request, response);
    }
    else {
        request.getRequestDispatcher("../eventSkyTracker.jsp?action=a_msg&msg=Le mail n'a pas été correctement envoyé.").forward(request, response);
    }
    
%>