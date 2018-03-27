<%-- 
    Document    : Compte.jsp
    Description : Redirige la requ�te en fonction de la connexion.
        Si le user n'est pas connect� : les infos du user sont affich�es
        si le user n'est pas connect� : une page de login s'ouvre
    Created on  : 21 Mars 2017
--%>

<%@page import="com.metier.*"%>
<%@page import="com.persistence.*"%>

<%
    com.metier.ESTSession maSession = (com.metier.ESTSession)session.getAttribute("maSession");
    if (maSession != null) {
        com.persistence.User user = maSession.getUser();
        if (user != null) {
            request.getRequestDispatcher("WEB-INF/infoUser.jsp").forward(request, response);
        }
        else {
            request.getRequestDispatcher("WEB-INF/login.jsp").forward(request, response);
        }
    }
    else {
        request.getRequestDispatcher("WEB-INF/login.jsp").forward(request, response);
    }
%>

