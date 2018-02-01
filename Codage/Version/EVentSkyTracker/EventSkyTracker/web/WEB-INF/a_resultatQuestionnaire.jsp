<%-- 
    Document    : a_resultatQuestionnaire
    Description : Affiche les qualifications faites selon l'évènement
    Created on  : 20 avril 2017, 15:40:42
    Author      : SANSON
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="com.persistence.Utils"%>
<%@page import="com.persistence.Evenement"%>
<%@page import="com.persistence.Candidate"%>
<%@page import="com.persistence.User"%>
<%@page import="com.persistence.Qualification"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.persistence.ConnexionMySQL"%>
<%@page import="com.metier.ESTSession"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Questionnaire</title> 
        <%@ include file="../includes/a_head.jspf" %> 
    </head>

    <body>
        <div class="header" data-role="header" data-id="main-header" data-tap-toggle="false" 
             data-theme="b" data-position="fixed" data-fullscreen="true">
            <h1>Questionnaire</h1>
            <%@include file="../includes/session.jspf" %>
            <%@include file="../includes/a_user.jspf" %>
        </div>
        <br> <br> <br> <br> 
        <div role="main" class="ui-content">
            <div class="ui-grid-a">
                <div class="ui-block-a">
                    <a href="#" id="btnEventPrecedent" data-iconpos="right" 
                       data-role="button">Précedent</a>
                </div>
                <div class="ui-block-b">
                    <a href="#" id="btnEventSuivant" data-iconpos="right" 
                       data-role="button">Suivant</a>
                </div>

            </div>

            <div id="event">


            </div>
            <div data-role="content">
                <form id="qualifier"></form>
            </div>
        </div>



        <br/><br/><br/>



        <footer>
            <%@ include file="../includes/a_footer.jspf" %>
        </footer> 
    </div>
    <%     
        ArrayList<Evenement> tabEvent = null;
        ArrayList<Qualification> tabQual = null;
        ArrayList<Integer> IdEvent = new ArrayList<Integer>();
        int NbEventQual = 0;
        tabEvent = Evenement.liste(con);
        for (int i = tabEvent.size(); i >= 1 ; i--) {
            tabQual = Qualification.listeByEvent(con, i);
            if (tabQual.size() > 0) {
                IdEvent.add(NbEventQual,(tabEvent.get(i-1).getId())-1);
                NbEventQual++;
            }
        }

    %>
    <script>

        $(function () {
            
            chargerImg();
            cache();
            $("#btnEventSuivant").bind("click", EvtSvt);
            $("#btnEventPrecedent").bind("click", EvtPct);
        });
       
        var test = <%=IdEvent%> ; 
        var idTab = 0;
        var evenement = 0;
        var cand = 0;
        var NbQual;
        var EventId;
        var date;
        var CandId;
        var User;
        var DateQual;
        var Question;
        var ant = 0;
        var Qualification = [];
       
        function EvtSvt() {
            if (evenement < <%=NbEventQual%> -1) {
                ant = evenement;
                idTab++;
                evenement = test[idTab];
                cache();
                chargerImg();
            }


        }
        function EvtPct() {
            if (evenement > 0) {
                ant = evenement;
                idTab--;
                evenement = test[idTab];
                cache();
                chargerImg();
            } 
                
        }

        function cache() {
            if (<%=NbEventQual%> <=1){
                $("#btnEventSuivant").removeClass("ui-state-disabled");
                $("#btnEventPrecedent").removeClass("ui-state-disabled");
            }
            if (evenement > 0)
                $("#btnEventPrecedent").removeClass("ui-state-disabled");
            else
                $("#btnEventPrecedent").addClass("ui-state-disabled");
            if (evenement < <%=NbEventQual%> -1)
                $("#btnEventSuivant").removeClass("ui-state-disabled");
            else
                $("#btnEventSuivant").addClass("ui-state-disabled");
        }

        function chargerImg() {
            $.ajax({
                url: 'eventSkyTracker.jsp?action=a_resultatQuestionnaire_req',
                type: 'POST',
                // On passe nos parametres par POST au script qcm_req.jsp
                // pour transmettre les réponses au questionnaire 
                data: 'event=' + evenement,
                success: function (data) {
                    var reps = data.split("--");
                    EventId = reps[1].split("|");
                    date = reps[2].split("|");
                    NbQual = reps[3].split("|");
                    NbQual = NbQual.map(Number);
                    CanId = reps[4].split("/");
                    User = reps[5].split("/");
                    DateQual = reps[6].split("/");
                    Question = reps[7].split("/");
                    for (var i = 0; i < Question.length; i++) {
                        Qualification[i] = Question[i].split("|");
                    }
                    if (NbQual <= 0) {
                        if ((ant < evenement) || (ant === 0)) {
                            EvtSvt();

                        } else {
                            EvtPct();

                        }

                    }
                    Affichage();

                },
                error: function (resultat, statut, erreur) {
                    alert("Désolé, le serveur ne répond pas");
                }

            });

        }
        function Affichage() {

            document.getElementById('qualifier').innerHTML = "";
            $('#qualifier')
                    .append($('<div>')
                            .attr({
                                'data-role': 'collapsible-set',
                                'data-collapsed-icon': 'carat-d',
                                'class': 'ui-alt-icon',
                                'data-expanded-icon': 'carat-u',
                                'id': 'primary'
                            }));
            for (i = 0; i < NbQual; i++) {
                ($('<div>')
                        .attr({
                            'data-role': 'collapsible',
                            'data-collapsed-icon': 'carat-d',
                            'class': 'ui-alt-icon',
                            'data-expanded-icon': 'carat-u'

                        })
                        .html('<h4> CandId = ' + CanId[i] + '<br> Fait le : ' + DateQual[i] + 
                        '<br> par : ' + User[i] + '</h4><p>' + Qualification[i] + '</p>' + "</div>"))
                        .appendTo('#primary');
            }
            $('#qualifier').collapsibleset().trigger('create');
            if (NbQual <= 0)
                document.getElementById("event").innerHTML = "<h4 align='center'> Aucune qualification </h4>";
            else
                document.getElementById("event").innerHTML = "<h4 align='center'> Evènement : " + EventId + "<br> Date : " + date + "</h4>";
        }


    </script>
</body>
</html>