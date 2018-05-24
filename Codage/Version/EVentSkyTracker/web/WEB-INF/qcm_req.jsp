<%-- 
    Document    : qcm_req.jsp
    Description : retourne par Ajax si le test est réussi ou non
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    // retourne par Ajax les infos de la galaxie concernée
    String trame = request.getParameter("reponses");
    String reps[] = trame.split("\\|", -1);
    int nbBonnesReponses = 0;
    // les bonnes réponses                       |
    int[] bonnesReponses = {1,1,1,1,1,2,2,2,3,1,1,2,2,2,3,2};
    for (int i = 0; i < bonnesReponses.length; i++) {
        if (Integer.parseInt(reps[i]) == bonnesReponses[i])
            nbBonnesReponses++;
    }
    // au max 3 erreurs possibles
    if (nbBonnesReponses >= bonnesReponses.length - 3) {
            com.metier.ESTSession maSession = (com.metier.ESTSession)session.getAttribute("maSession");
            if (maSession == null)
                out.println("oui");
            else
                out.println("inscrit");
    }
    else
        out.println("non");
%>