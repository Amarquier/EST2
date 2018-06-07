<%-- 
    Document   : refAdd_req.jsp
    Created on : 4 févr. 2016, 08:35:12
    Author     : 
--%>

<%@page import="java.sql.Connection"%>
<%@page import="com.metier.*"%>
<%@page import="com.persistence.*"%>
<%@page pageEncoding="UTF-8"%>

<jsp:useBean id="monAppli" scope="application" class="com.metier.DiscoApplication"/>
<%
     Connection con = (Connection) session.getAttribute("con");
    if (con == null)
        con = ConnexionMySQL.newConnexion();
    session.setAttribute("con", con);
    
    com.metier.ESTSession maSession = (com.metier.ESTSession)session.getAttribute("maSession");
    com.persistence.User user = null;
    if (maSession != null) {
        user = maSession.getUser();
    }
    if (user != null) {
        String nomGalaxie = request.getParameter("nomGalaxie");
        String cheminObs = request.getParameter("chemin");
        String cheminRef = DiscoApplication.getPath() + "/refgal/" + nomGalaxie + ".jpg";
        String tChemin[] = cheminObs.split("/");
        // détermine le chemin absolu
        String dateCrt = tChemin[tChemin.length - 2];
        String telescope = tChemin[tChemin.length - 3];
        String chemin = DiscoApplication.getPath() + "/" + telescope + "/" + dateCrt + "/" + tChemin[tChemin.length - 1];
        
        if(user.getGrade() == 5) {
            DiscoApplication.remplacer(chemin, cheminRef);
            ImageSN image = ImageSN.getByChemin(con, telescope, nomGalaxie, dateCrt);
            String nomRef = image.getGalaxieRef();
            image.changeGalaxieRef();
            nomRef = image.getGalaxieRef();
            out.println("oui");
        }
        else {
            CanReference.create(con, user.getPseudo(), nomGalaxie, cheminObs);
            out.println("non");
        }
    }
%>