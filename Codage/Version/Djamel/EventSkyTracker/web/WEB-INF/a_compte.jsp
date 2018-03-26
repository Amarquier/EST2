<%-- 
    Document    : a_compte
    Description : Consultatation des informations du compte actu connecter
--%>

<%@page import="com.metier.*"%>
<%@page import="com.persistence.*"%>

<%
    com.metier.ESTSession maSession = (com.metier.ESTSession)session.getAttribute("maSession");
    if (maSession != null) {
        com.persistence.User user = maSession.getUser();
        if (user != null) {
            // Si pas admin
            if(!maSession.isModeExpert()){
                request.getRequestDispatcher("eventSkyTracker.jsp?action=pbAdminMode").forward(request, response);
            } 
            else {
                request.getRequestDispatcher("a_infoUser.jsp").forward(request, response);
            }
        }
        else {
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
    else {
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }
%>

