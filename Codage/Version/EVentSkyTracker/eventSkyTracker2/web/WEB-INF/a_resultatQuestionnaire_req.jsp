<%-- 
    Document    : a_resultatQuestionnaire_req
    Description : recoit par Ajax l'évènement à afficher
    Created on  : 20 avril 2017, 15:40:42
    Author      : SANSON
--%>

<%@page import="com.persistence.Utils"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.persistence.ConnexionMySQL"%>
<%@page import="com.persistence.Evenement"%>
<%@page import="com.persistence.CandidateEST"%>
<%@page import="com.persistence.ImageEST"%>
<%@page import="com.persistence.Qualification"%>
<%@include file="../includes/session.jspf" %> 
<%    
    String Trame = "--";
    String CandId = "";
    String User = "";
    String DateQual = "";
    String Reponse = "";
    
    ArrayList<Evenement> tabEvent = null;
    tabEvent = Evenement.liste(con);
    int evenement = Integer.parseInt(request.getParameter("event"));
    Trame += tabEvent.get(evenement).getIdOfficiel() + "--" + tabEvent.get(evenement).getDate();
    ArrayList<Qualification> listQuand = null;
    listQuand = Qualification.listeByEvent(con, tabEvent.get(evenement).getId());
    Trame += "--" + listQuand.size() + "--";
    for (int i = 0; i < listQuand.size(); i++) {
            CandId += Integer.toString(listQuand.get(i).getCanId()) + "/";
    }
    Trame += CandId;
    Trame += "--";
    for (int i = 0; i < listQuand.size(); i++) {
        if (i == listQuand.size() - 1) {
            User += listQuand.get(i).getUserPseudo();
        } else {
            User += listQuand.get(i).getUserPseudo() + "/";
        }
    }
    Trame += User;
    Trame += "--";
    for (int i = 0; i < listQuand.size(); i++) {
        if (i == listQuand.size() - 1) {
            DateQual += String.valueOf(listQuand.get(i).getDate());
        } else {
            DateQual += String.valueOf(listQuand.get(i).getDate()) + "/";
        }
    }
    Trame += DateQual;
    Trame += "--";
    for (int i = 0; i < listQuand.size(); i++) {
        if (i == listQuand.size() - 1) {
            Reponse +=listQuand.get(i).getQuestionnaire();
        } else {
            Reponse += listQuand.get(i).getQuestionnaire() + "/";
        }
    }
    Trame += Reponse;
   
    out.print(Trame);
%>
