<%-- 
    Document   : inscription_req
    Description : recoit par Ajax les informations pour créer le compte

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
    
    String pseudo   = request.getParameter("inscriptionPseudo");
    String nom      = request.getParameter("inscriptionNom");
    String eMail    = request.getParameter("inscriptionEMail");
    String password = request.getParameter("inscriptionPassword");
    String path = request.getParameter("path");
    String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
    String confirm = "";
    for(int x=0;x<8;x++)
    {
       int i = (int)Math.floor(Math.random() * chars.length());
       confirm += chars.charAt(i);
    }  
    if (User.isPseudoUsed(con, pseudo)) {
        request.getRequestDispatcher("inscription.jsp?message=pbPseudo").forward(request, response);
    }
    else if (User.isMailUsed(con, eMail)) {
        request.getRequestDispatcher("inscription.jsp?message=pbEmail").forward(request, response);   
    }
    else {
        String cPassword = com.persistence.Utils.encryptPassword(password);
        User user = User.create(con, pseudo, nom, eMail, cPassword, confirm);
        if (user != null) {
            %>
            <%
            // lui envoyer le mail de confirmation
            String contenu = "Bonjour Mme/Mr " + user.getUsername() + " ! \n\n"
                    + "Votre inscription sur le site de découverte de supernovae est presque terminée !"
                    + "\nVous devez valider votre compte en cliquant sur le lien ci-dessous : "
                    + "http://eventskytracker/mailConfirme_req.jsp?pseudo=" + user.getPseudo() + "&key=" + confirm
                    + "\nVotre pseudo est " + user.getPseudo()
                    + "\n\nA bientôt à la découverte de Supernovae :)";
            String to = user.getEmail();
            boolean ok = SmtpSend.sendMessage("Demande d'inscription sur eventSkyTracker", contenu, to);  
            if (ok) {
                request.getRequestDispatcher("msgCompte.jsp?msg=Nous vous avons envoyé un mail afin que vous validiez votre inscription ! Merci.").forward(request, response);
            }
            else {
                request.getRequestDispatcher("msgCompte.jsp?msg=Problème d'inscription").forward(request, response);
            }
        }
        else {                   // délie tous les objets liés à cette session
            session.invalidate();
            request.getRequestDispatcher("inscription.jsp?message=pbInscription").forward(request, response);
        }
    }
    
%>