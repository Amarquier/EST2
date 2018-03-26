<%-- 
    Document   : qualifier_qcm_req
    Description : Envoie du questionnaire à la base
    Created on : 18 avr. 2017, 09:52:52
    Author     : Sanson
--%>

<%@page import="java.util.Random"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.lang.Integer"%>
<%@page import="com.persistence.User"%>
<%@page import="com.persistence.Qualification"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.persistence.ConnexionMySQL"%>
<%@page import="com.persistence.Evenement"%>
<%@page import="com.metier.ESTSession"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../includes/user.jspf" %>
create(Connection con, String userPseudo, int canId, int x, int y, String questionnaire)  throws Exception {
        Qualification qualification = new Qualification(userPseudo, canId, x, y, questionnaire);
<%
    int X = Integer.parseInt(request.getParameter("X"));
    int Y = Integer.parseInt(request.getParameter("Y"));
    int candId = Integer.parseInt(request.getParameter("candId"));
    String trame = request.getParameter("reponses");
    Connection con = (Connection) session.getAttribute("con");
    if (con == null) {
        con = ConnexionMySQL.newConnexion();
    }
    session.setAttribute("con", con);

    com.metier.ESTSession maSession = (com.metier.ESTSession) session.getAttribute("maSession");
    com.persistence.User user = maSession.getUser();
    String Pseudo = user.getPseudo();
    user.setNbQualifications(user.getNbQualifications() + 1);
    user.save(con);
    Qualification.create(con, Pseudo, candId , X, Y, trame);
    
    out.println(trame);
%>