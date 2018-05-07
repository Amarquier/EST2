<%-- 
    Document    : mailConfirme_req.jsp
    Description : script pour l'affichage de la confirmation de l'envoi du mail
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
    String pseudo = request.getParameter("pseudo");
    String mailconfirme = request.getParameter("key");
    User u = User.getByPseudo(con, pseudo);
    String key = u.getMailConfirme();
    if(!u.getMailConfirme().equals("ok"))
    {
        if(mailconfirme.equals(key))
        {
            u.setMailConfirme("ok");
            u.save(con);
            request.getRequestDispatcher("mailConfirme.jsp?msg=Ce compte est maintenant confirmé !").forward(request, response); 
        }
        else
        {
            request.getRequestDispatcher("mailConfirme.jsp?msg=La confirmation a échoué, veuillez réessayer ou contacter l'administrateur.").forward(request, response); 
        }
    }
    else
    {
         request.getRequestDispatcher("mailConfirme.jsp?msg=Ce compte est déjà confirmé").forward(request, response); 
    }
    
%>