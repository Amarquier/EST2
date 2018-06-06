<%-- 
    Document   : a_canValider_req.jsp
    Created on : 4 févr. 2014, 08:35:12
    Author     : jpdms
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.Statement"%>
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
    String pseudo           = request.getParameter("userDisco");
    String objet            = request.getParameter("objet");
    String contenu          = request.getParameter("contenu");
    String nomImage         = request.getParameter("nomImage");
    String chemin           = request.getParameter("chemin");
    String dateDecouverte   = request.getParameter("dateDecouverte");
    int x = Integer.parseInt(request.getParameter("x"));
    int y = Integer.parseInt(request.getParameter("y"));
    User uMod = User.getByPseudo(con, pseudo);
    if (Decouverte.exist(con, pseudo, nomImage, chemin)) {
        request.getRequestDispatcher("../discovery.jsp?action=a_canConfirme_req&msg=Vous ne pouvez pas valider deux fois la même supernova.").forward(request, response);
    }
    else {
        // lui envoyer le mail de confirmation
        String mail = contenu;
        String to = uMod.getEmail();
        boolean ok = SmtpSend.sendMessage(objet, mail, to);  
        if (ok) {
            uMod.setNbDecouvertes(uMod.getNbDecouvertes() + 1);
            uMod.save(con); 
            // ajouter(Connection con, String userPseudo, String nomImage, String chemin, String dateDecouverte, int x, int y
            if (!Decouverte.ajouter(con, pseudo, nomImage, chemin, dateDecouverte, x, y)) {
                request.getRequestDispatcher("../discovery.jsp?action=a_canConfirme_req&msg=La découverte n'a pas été sauvegardée").forward(request, response);
            }
            else {
                if (CandidateSN.supprimer(con, pseudo, nomImage, chemin)) {
                    request.getRequestDispatcher("../discovery.jsp?action=a_canConfirme_req&msg=Le mail a correctement été envoyé et la supernova correctement validée.").forward(request, response);
                }
                else {
                    request.getRequestDispatcher("../discovery.jsp?action=a_canConfirme_req&msg=La candidate n'a pas été supprimée.").forward(request, response);
                }
            }
        }
        else {
            request.getRequestDispatcher("../discovery.jsp?action=a_canConfirme_req&msg=Le mail n'a pas été correctement envoyé et la supernova n'a pas été correctement validée.").forward(request, response);
        }
    }
%>