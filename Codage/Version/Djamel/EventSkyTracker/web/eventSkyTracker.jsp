<%-- 
    Document     : eventSkyTracker.jsp 
    Description  : Contrôleur du site (modèle MVC)
        Toute les requêtes utilisateur passe par ce contrôleur
            avec en paramètre l'action à réaliser
        Le contrôle se fait suivant l'état du user :
            non connecté, connecté (grade < 3, grade > 3, grade > 5)
        Il donne accès aux pages contenues dans le répertoire WEB-INF
            répertoire non accessible du Web pour des raisons de sécurité.
--%>

<%@page import="java.sql.Connection"%>
<%@page import="com.persistence.*"%>
<%@page import="com.metier.*"%>

<%
    Connection con = (Connection) session.getAttribute("con");
    if (con == null) {
        con = ConnexionMySQL.newConnexion();
    }
    session.setAttribute("con", con);

    // traitement des actions possibles
    String action = request.getParameter("action");
    ESTSession maSession = (ESTSession) session.getAttribute("maSession");
    // --------------------------------------------------------------------
    if (action == null) {
        request.getRequestDispatcher("index.jsp").forward(request, response);
    } else {
        if (action.equals("qcm_req")) {
            request.getRequestDispatcher("WEB-INF/qcm_req.jsp").forward(request, response);
        } else if (action.equals("qualifier_qcm_req")) {
            request.getRequestDispatcher("WEB-INF/qualifier_qcm_req.jsp").forward(request, response);
        } else if (action.equals("qualifier_req")) {
            request.getRequestDispatcher("WEB-INF/qualifier_req.jsp").forward(request, response);
        } else if (maSession == null) {                 // user non connecté
            if (action.equals("login")) {
                request.getRequestDispatcher("WEB-INF/login.jsp").forward(request, response);
            } else if (action.equals("login_req")) {
                request.getRequestDispatcher("WEB-INF/login_req.jsp").forward(request, response);
            } else if (action.equals("inscription")) {
                request.getRequestDispatcher("WEB-INF/inscription.jsp").forward(request, response);
            } else if (action.equals("inscription_req")) {
                request.getRequestDispatcher("WEB-INF/inscription_req.jsp").forward(request, response);
            } else if (action.equals("motDePassePerdu")) {
                request.getRequestDispatcher("WEB-INF/motDePassePerdu.jsp").forward(request, response);
            } else if (action.equals("motDePassePerdu_req")) {
                request.getRequestDispatcher("WEB-INF/motDePassePerdu_req.jsp").forward(request, response);
            } else if (action.equals("pseudoPerdu")) {
                request.getRequestDispatcher("WEB-INF/pseudoPerdu.jsp").forward(request, response);
            } else if (action.equals("pseudoPerdu_req")) {
                request.getRequestDispatcher("WEB-INF/pseudoPerdu_req.jsp").forward(request, response);
            } else if (action.equals("pbAdminMode")) {
                request.getRequestDispatcher("WEB-INF/login.jsp?message=pbAdminMode").forward(request, response);
            } else {
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        } // user connecté et de grade 5
        else if (maSession.isModeExpert()) {
            if (action.equals("a_gestion")) {
                request.getRequestDispatcher("WEB-INF/a_gestion.jsp").forward(request, response);
            } else if (action.equals("a_gestionCompte")) {
                request.getRequestDispatcher("WEB-INF/a_gestionCompte.jsp").forward(request, response);
            } else if (action.equals("a_gestionRecherche")) {
                request.getRequestDispatcher("WEB-INF/a_gestionRecherche.jsp").forward(request, response);
            } else if (action.equals("a_gestionHistorique")) {
                request.getRequestDispatcher("WEB-INF/a_gestionHistorique.jsp").forward(request, response);
            } else if (action.equals("a_gestionContact")) {
                request.getRequestDispatcher("WEB-INF/a_gestionContact.jsp").forward(request, response);
            } else if (action.equals("a_compte")) {
                request.getRequestDispatcher("WEB-INF/a_compte.jsp").forward(request, response);
            } else if (action.equals("a_actu")) {
                request.getRequestDispatcher("WEB-INF/a_actu.jsp").forward(request, response);
            } else if (action.equals("a_actuAdd")) {
                request.getRequestDispatcher("WEB-INF/a_actuAdd.jsp").forward(request, response);
            } else if (action.equals("a_actuMod")) {
                request.getRequestDispatcher("WEB-INF/a_actuMod.jsp").forward(request, response);
            } else if (action.equals("a_actuMod_req")) {
                request.getRequestDispatcher("WEB-INF/a_actuMod_req.jsp").forward(request, response);
            } else if (action.equals("a_actuDel")) {
                request.getRequestDispatcher("WEB-INF/a_actuDel.jsp").forward(request, response);
            } else if (action.equals("a_actuDel_req")) {
                request.getRequestDispatcher("WEB-INF/a_actuDel_req.jsp").forward(request, response);
            } else if (action.equals("a_blacklist")) {
                request.getRequestDispatcher("WEB-INF/a_blacklist.jsp").forward(request, response);
            } else if (action.equals("a_gradeMod")) {
                request.getRequestDispatcher("WEB-INF/a_gradeMod.jsp").forward(request, response);
            } else if (action.equals("a_msg")) {
                request.getRequestDispatcher("WEB-INF/a_msg.jsp").forward(request, response);
            } else if (action.equals("a_resultatQuestionnaire")) {
                request.getRequestDispatcher("WEB-INF/a_resultatQuestionnaire.jsp").forward(request, response);
                } else if (action.equals("a_resultatQuestionnaire_req")) {
                request.getRequestDispatcher("WEB-INF/a_resultatQuestionnaire_req.jsp").forward(request, response);
            } else if (action.equals("decoadmin")) {
                maSession.setModeExpert(false);
                request.getRequestDispatcher("compte.jsp").forward(request, response);
            } else if (action.equals("deconnexion")) {
                session.invalidate();   // fermeture de la session en cours
                request.getRequestDispatcher("WEB-INF/login.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("WEB-INF/a_compte.jsp").forward(request, response);
            }
        } else {
            com.persistence.User user = maSession.getUser();
            // Dmd de changement de profil
            if (action.equals("changerProfil")) {
                request.getRequestDispatcher("WEB-INF/profilMod.jsp").forward(request, response);
            } else if (action.equals("profilMod_req")) {
                request.getRequestDispatcher("WEB-INF/profilMod_req.jsp").forward(request, response);
            } else if (action.equals("infoUser")) {
                request.getRequestDispatcher("WEB-INF/infoUser.jsp").forward(request, response);
            } else if (action.equals("contact")) {
                request.getRequestDispatcher("WEB-INF/contact.jsp").forward(request, response);
            } else if (action.equals("reqContact")) {
                request.getRequestDispatcher("WEB-INF/contact_req.jsp").forward(request, response);
            } else if (action.equals("reqAdmin")) {
                if (user.getGrade() == 5) {
                    maSession.setModeExpert(true);
                    request.getRequestDispatcher("WEB-INF/a_compte.jsp").forward(request, response);
                } else {
                    request.getRequestDispatcher("compte.jsp").forward(request, response);
                }
            } else if (action.equals("pbAdminMode")) {
                request.getRequestDispatcher("WEB-INF/infoUser.jsp?message=pbAdminMode").forward(request, response);
            } else if (action.equals("deconnexion")) {
                session.invalidate();   // fermeture de la session en cours
                request.getRequestDispatcher("WEB-INF/login.jsp").forward(request, response);
            } else if (action.equals("lastImg_req")) {
                request.getRequestDispatcher("WEB-INF/lastImg_req.jsp").forward(request, response);
            } else {
                session.invalidate();   // fermeture de la session en cours
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        }
    }
%>

