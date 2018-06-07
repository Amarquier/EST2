<%-- 
    Document    : lastImg_req.jsp
    Description : retourne par Ajax la dernière image observée
    Created on  : 7 mai 2014, 13:49:42
    Author      : 
--%>

<%@page import="java.sql.Connection"%>
<%@page import="com.persistence.ConnexionMySQL"%>
<%@page import="com.persistence.User"%>
<%@page import="com.persistence.CandidateSN"%>
<%@page import="com.metier.SmtpSend"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    Connection con = (Connection) session.getAttribute("con");
    if (con == null)
        con = ConnexionMySQL.newConnexion();
    session.setAttribute("con", con);
    int pos = Integer.parseInt(request.getParameter("pos"));
    String chemin = request.getParameter("chemin");
    String tabChemin[] = chemin.split("/");
    String buff = tabChemin[4].toString();
    String gala[] = buff.split("\\.");
    String telescope = tabChemin[2].toString();
    String date = tabChemin[3].toString();
    String galaxie = gala[0].toString();
    com.metier.ESTSession maSession = (com.metier.ESTSession)session.getAttribute("maSession");
    if (maSession != null) {
        com.persistence.User user = maSession.getUser();
        user.setLastImgGalaxie(galaxie);
        user.setLastImgDate(date);
        user.setLastImg(telescope);
        user.setLastImgPos(pos);
        user.save(con);
    }
%>