<%-- 
    Document    : qualifier.jsp
    Description : Page qui permet de qualifier une candidate.
    Created on  : 3 Avril 2017
--%>
<%@page import="java.util.Random"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.persistence.ConnexionMySQL"%>
<%@page import="com.persistence.Evenement"%>
<%@page import="com.persistence.CandidateEST"%>
<%@page import="com.persistence.ImageEST"%>
<%@page import="com.metier.ESTSession"%>
<%@page import="com.metier.DiscoApplication"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="fr">
    <head>
        <title>Qualifier</title>
        <%@include file="includes/head.jspf"%>

    </head>
    <body>
        <div class="page" data-role="page" id="PageQualifier">
            <%@include file="includes/session.jspf" %>
            <%@include file="includes/qualifierHeader.jspf" %>
            <%                ArrayList<Evenement> tabEvent = null;
                tabEvent = Evenement.liste(con);
            %>
            <!-- panel de galaxies -->
            <div id="panelQualifier" data-role="panel" data-position="right" class="ui-alt-icon"
                 data-position-fixed="true" data-display="push" data-theme="b">
                <ul data-role="listview" data-icon="false">
                    <li data-role="list-divider">Aller à :</li>

                    <%
                        int NbEvent = 0;
                        ArrayList<CandidateEST> tabCand = null;
                        for (int i = 0; i < tabEvent.size(); i++) {
                            if (user != null) {
                                tabCand = CandidateEST.getByEvenementAndUser(con, i, user.getPseudo());
                                if (tabCand.size() > 0) {
                                    out.print("<li><a data-rel=" + '"' + "close" + '"' + "onclick='changeEvent(" + i + ");'>" + tabEvent.get(i).getDate() + "</a></li>");
                                }
                            } else {
                                out.print("<li><a data-rel=" + '"' + "close" + '"' + "onclick='changeEvent(" + i + ");'>" + tabEvent.get(i).getDate() + "</a></li>");
                            }
                        }
                    %>
                    <li data-icon="delete"><a href="#" data-rel="close">Close</a></li>
                </ul>
            </div>
            <div role="main" class="ui-content">
                <script type="text/javascript" src="js/qcm_qualifier.js"></script> 
                <script type="text/javascript" src="js/slider.js"></script>

                <link rel="stylesheet" href="css/images.css">
                <br/><br/>
                <div class="ui-grid-a">
                    <div class="ui-block-a">
                        <a href="#" id="btnCanPrecedent" data-iconpos="right" 
                           data-role="button">Candidate Précedent</a>
                    </div>
                    <div class="ui-block-b">
                        <a href="#" id="btnCanSuivant" data-iconpos="right" 
                           data-role="button">Candidate Suivant</a>
                    </div>

                </div>
                <br/>
                <div id="galax">
                    <div id="video" align="center">
                    <img id="img0" src="images/tuto103.jpg" />
                    </div>
                    <div id="ref" align="center">
                        <img id="img0" src="images/tuto103.jpg" />
                    </div>
                </div>
                <!-- Ajouter l'info du délai entre le curseur et l'événement initial en mn -->
                <div id="sliderDelai" align="center">0 min</div>

                <!-- Le slider (le label est caché) -->
                <div id="divSliderVideo">
                            <label for="sliderVideo" class="ui-hidden-accessible">Slider :</label>
                    <div  name="sliderVideo" id="sliderVideo">
                    </div>
                    <!-- Ajouter des index visuels des positions des images au dessus du slider -->
                    <canvas id="regle" height="50" ></canvas>
                    <div class="ui-grid-c">
                        <%--<textarea style="FONT-FAMILY: Verdana" id="textEvent" rows=1 name="textarea" placeholder=""></textarea>--%>
                    </div>
                    <br/>
                    <div class="ui-grid-a">
                        <div class="ui-block-a">
                            <a href="#" id="btnPcdt" data-iconpos="left" 
                               data-role="button">Image Précédente</a>
                        </div>
                        <div class="ui-block-b">
                            <a href="#" id="btnSvt" data-iconpos="right" 
                               data-role="button">Image Suivante</a>

                        </div>


                    </div>

                </div>

                <%--     <div class="ui-block-b">
                         <textarea style="FONT-FAMILY: Verdana" id="textCand" rows=1 name="textarea" placeholder=""></textarea>

                    </div>
                    <div class="ui-block-c">
                        <textarea style="FONT-FAMILY: Verdana" id="textImg" rows=1 name="textarea" placeholder=""></textarea>

                    </div>
                    <div class="ui-block-d">
                        <textarea style="FONT-FAMILY: Verdana" id="textDelai" rows=1 name="textarea" placeholder=""></textarea>

                    </div>--%>

                <% if (user != null) {%>



                <div data-demo-html="true">

                    <div data-role="collapsibleset" data-theme="a"
                         class="ui-alt-icon"> 
                        <div id="Q1" style="display:block;" value="01">
                            <div data-role="collapsible" data-collapsed="false"<%--question développer--%>  >
                                <h3><span id="rp1">Question 1</span></h3>
                                <form id="form1">
                                    <fieldset id="fieldset1" data-role="controlgroup" class="fieldset">
                                        <legend id="legend1">L'évenement est visible ?</legend>
                                        <input name="rp1" id="rp10" value="001 QS" type="radio">
                                        <label id="rp1.0" for="rp10">OUI</label>
                                        <input name="rp1" id="rp11" value="001 QF" type="radio">
                                        <label id="rp1.1" for="rp11">NON</label>
                                    </fieldset>
                                </form>
                            </div>
                        </div>

                        <div id="Q2" value="02" style="display:none;" >
                            <div data-role="collapsible" data-collapsed="false">
                                <h3><span id="rp2">Question 2</span></h3>
                                <form>
                                    <fieldset id="fieldset2" data-role="controlgroup" class="fieldset">
                                        <legend id="legend2">L'évènement est-il visible sur une seule image ?</legend>
                                        <input name="rp2" id="rp20" value="002 Q21" type="radio">
                                        <label id="rp2.0" for="rp20">OUI</label>
                                        <input name="rp2" id="rp21" value="002 QS" type="radio">
                                        <label id="rp2.1" for="rp21">NON</label>                                        
                                    </fieldset>
                                </form>
                            </div>
                        </div>
                                
                        <div id="Q21" value="021" style="display:none;" >
                            <div data-role="collapsible" data-collapsed="false">
                                <h3><span id="rp21">Question 2.1</span></h3>
                                <form>
                                    <fieldset id="fieldset21" data-role="controlgroup" class="fieldset">
                                        <legend id="legend21">Estimer l'éclat</legend>
                                        <input name="rp21" id="rp210" value="021 Q21" type="radio">
                                        <label id="rp21.0" for="rp210">Fort</label>
                                        <input name="rp21" id="rp211" value="021 Q21" type="radio">
                                        <label id="rp21.1" for="rp211">Moyen</label>
                                        <input name="rp21" id="rp212" value="021 Q21" type="radio">
                                        <label id="rp21.2" for="rp212">Faible</label>
                                    </fieldset>
                                </form>
                            </div>
                        </div>
                                
                        <div id="Q22" value="022" style="display:none;" >
                            <div data-role="collapsible" data-collapsed="false">
                                <h3><span id="rp22">Question 2.2</span></h3>
                                <form>
                                    <fieldset id="fieldset22" data-role="controlgroup" class="fieldset">
                                        <legend id="legend22">Est-ce une signature de rayon cosmique ?</legend>
                                        <input name="rp22" id="rp220" value="022 QF" type="radio">
                                        <label id="rp22.0" for="rp220">OUI</label>
                                        <input name="rp32" id="rp221" value="022 Q21" type="radio">
                                        <label id="rp22.1" for="rp221">NON</label>            
                                        <input name="rp32" id="rp222" value="022 Q21" type="radio">
                                        <label id="rp22.2" for="rp222">Je ne sais pas</label>  
                                    </fieldset>
                                </form>
                            </div>
                        </div>
                        <div id="Q23" value="023" style="display:none;" >
                            <div data-role="collapsible" data-collapsed="false">
                                <h3><span id="rp23">Question 2.3</span></h3>
                                <form>
                                    <fieldset id="fieldset23" data-role="controlgroup" class="fieldset">
                                        <legend id="legend23">Est-ce une signature de satellite ?</legend>
                                        <input name="rp23" id="rp230" value="023 QF" type="radio">
                                        <label id="rp23.0" for="rp230">OUI</label>
                                        <input name="rp23" id="rp231" value="023 QF" type="radio">
                                        <label id="rp23.1" for="rp231">NON</label>            
                                        <input name="rp23" id="rp232" value="023 QF" type="radio">
                                        <label id="rp23.2" for="rp232">Je ne sais pas</label>  
                                    </fieldset>
                                </form>
                            </div>
                        </div>
                        <div id="Q3" value="03" style="display:none;" >
                            <div data-role="collapsible" data-collapsed="false">
                                <h3><span id="rp3">Question 3</span></h3>
                                <form>
                                    <fieldset id="fieldset3" data-role="controlgroup" class="fieldset">
                                        <legend id="legend3">L'événement se déplace-t'il ?</legend>
                                        <input name="rp3" id="rp30" value="003 Q31" type="radio">
                                        <label id="rp3.0" for="rp30">OUI</label>
                                        <input name="rp3" id="rp31" value="003 QS" type="radio">
                                        <label id="rp3.1" for="rp31">NON</label>            
                                    </fieldset>
                                </form>
                            </div>
                        </div>
                        <div id="Q31" value="031" style="display:none;" >
                            <div data-role="collapsible" data-collapsed="false">
                                <h3><span id="rp31">Question 3.1</span></h3>
                                <form>
                                    <fieldset id="fieldset31" data-role="controlgroup" class="fieldset">
                                        <legend id="legend31" >Est-ce une signature de satellite ?</legend>
                                        <input name="rp31" id="rp310" value="031 QF" type="radio">
                                        <label id="rp31.0" for="rp310">OUI</label>
                                        <input name="rp31" id="rp311" value="031 Q31" type="radio">
                                        <label id="rp31.1" for="rp311">NON</label>
                                        <input name="rp31" id="rp312" value="031 Q31" type="radio">
                                        <label id="rp31.2" for="rp312">Je ne sais pas</label>  
                                    </fieldset>
                                </form>
                            </div>
                        </div>
                        <div id="Q32" value="032" style="display:none;" >
                            <div data-role="collapsible" data-collapsed="false">
                                <h3><span id="rp32">Question 3.2</span></h3>
                                <form>
                                    <fieldset id="fieldset32" data-role="controlgroup" class="fieldset">
                                        <legend id="legend32" >Est-ce une signature d'asteroide ?</legend>
                                        <input name="rp32" id="rp320" value="032 QF" type="radio">
                                        <label id="rp32.0" for="rp320">OUI</label>
                                        <input name="rp32" id="rp321" value="032 QF" type="radio">
                                        <label id="rp32.1" for="rp321">NON</label>  
                                        <input name="rp32" id="rp322" value="032 QF" type="radio">
                                        <label id="rp32.2" for="rp322">Je ne sais pas</label>  
                                    </fieldset>
                                </form>
                            </div>
                        </div>

                        <div id="Q4" value="04" style="display:none;" >
                            <div data-role="collapsible" data-collapsed="false">
                                <h3><span id="rp4">Question 4</span></h3>
                                <form>
                                    <fieldset id="fieldset4" data-role="controlgroup" class="fieldset">
                                        <legend id="legend4" >L'événement a-t'il un aspect stellaire ?</legend>
                                        <input name="rp4" id="rp40" value="004 QS" type="radio">
                                        <label id="rp4.0" for="rp40">OUI</label>
                                        <input name="rp4" id="rp41" value="004 QS" type="radio">
                                        <label id="rp4.1" for="rp41">NON</label>            
                                    </fieldset>
                                </form>
                            </div>
                        </div>
                                
                        <div id="Q5" value="05" style="display:none;" >
                            <div data-role="collapsible" data-collapsed="false">
                                <h3><span id="rp5">Question 5</span></h3>
                                <form>
                                    <fieldset id="fieldset5" data-role="controlgroup" class="fieldset">
                                        <legend id="legend5" >L'événement montre-t'il des variations de lumière ?</legend>
                                        <input name="rp5" id="rp50" value="005 QS" type="radio">
                                        <label id="rp5.0" for="rp50">OUI</label>
                                        <input name="rp5" id="rp51" value="005 QF" type="radio">
                                        <label id="rp5.1" for="rp51">NON</label>            
                                    </fieldset>
                                </form>
                            </div>
                        </div>
                        
                        <div id="Q6" value="06" style="display:none;" >
                            <div data-role="collapsible" data-collapsed="false">
                                <h3><span id="rp6">Question 6</span></h3>
                                <form>
                                    <fieldset id="fieldset6" data-role="controlgroup" class="fieldset">
                                        <legend id="legend6">L'événement est-il visible sur toutes les images ?</legend>
                                        <input name="rp6" id="rp60" value="006 QS" type="radio">
                                        <label id="rp6.0" for="rp60">OUI</label>
                                        <input name="rp6" id="rp61" value="006 QS" type="radio">
                                        <label id="rp6.1" for="rp61">NON</label>            
                                    </fieldset>
                                </form>
                            </div>
                        </div>
                                
                        <div id="Q7" value="07" style="display:none;" >
                            <div data-role="collapsible" data-collapsed="false">
                                <h3><span id="rp7">Question 7</span></h3>
                                <form>
                                    <fieldset id="fieldset7" data-role="controlgroup" class="fieldset">
                                        <legend id="legend7">L'événement dure-t-il au moins une dizaine de jours ?</legend>
                                        <input name="rp7" id="rp70" value="007 QF" type="radio">
                                        <label id="rp7.0" for="rp70">OUI</label>
                                        <input name="rp7" id="rp71" value="007 QF" type="radio">
                                        <label id="rp7.1" for="rp71">NON</label>
                                        <input name="rp7" id="rp72" value="007 QF" type="radio">
                                        <label id="rp7.2" for="rp72">Je n'ai pas assez d'éléments pour répondre</label>            
                                    </fieldset>
                                </form>
                            </div>
                        </div>                                

                    <div class="ui-grid-a">
                        <div class="ui-block-a">
                            <button id="btnPrec" disabled="false" class="ui-btn">Précedent</button>
                        </div>
                        <div class="ui-block-b">
                            <button id="btnSuiv" class="ui-btn" data-ajax="false">Suivant</button>
                        </div>
                    </div>
                    <%}
                    %>
                </div>

                <%@include file="includes/footer.jspf" %>
            </div>


            <%-- le script pour s'exécuter doit être dans la page data-role --%>
            <script>
            </script>

            <div id="popupFinit" data-role="popup" data-theme="a" data-overlay-theme="b"
                 class="ui-corner-all" data-corners="true" data-position-to="window">

                <div class="mesPopups"> 
                    <center><p>

                            <br><strong>Confirmer l'envoi du QCM ?</strong></p>
                        <div class="ui-grid-a">
                            <div class="ui-block-a">
                                <input type="button" id='confenv' onclick='window.location.reload(false)' value="OUI"/>
                            </div>
                            <div class="ui-block-b">
                                <a href="#" id="btnNon" data-rel="back" data-position-to="window"class="ui-btn ui-corner-all ui-shadow" data-transition="pop">NON</a>
                            </div>
                        </div>
                        
                        
                    </center>
                </div>
            </div>
            <div id="popupPointerEvent" data-role="popup" data-theme="a" data-overlay-theme="b"
                 class="ui-corner-all" data-corners="true" data-position-to="window">
                <a href="#" data-rel="back" class="ui-btn ui-corner-all ui-shadow
                   ui-btn-a ui-icon-delete ui-btn-icon-notext ui-btn-right" style="background-color:black;">
                    Fermer
                </a>
                <div class="mesPopups"> 
                    <center><p>

                            <br><strong>Pointer évènement</strong></p>
                    </center>

                </div>
            </div>
            <div id="popupPointerImageConcernee" data-role="popup" data-theme="a" data-overlay-theme="b"
                 class="ui-corner-all" data-corners="true" data-position-to="window">
                <a href="#" data-rel="back" class="ui-btn ui-corner-all ui-shadow
                   ui-btn-a ui-icon-delete ui-btn-icon-notext ui-btn-right" style="background-color:black;">
                    Fermer
                </a>
                <div class="mesPopups"> 
                    <center><p>

                            <br><strong>Pointer l'image concernée</strong></p>
                    </center>

                </div>
            </div>
            <div id="popupPointerImageDispaAppa" data-role="popup" data-theme="a" data-overlay-theme="b"
                 class="ui-corner-all" data-corners="true" data-position-to="window">
                <a href="#" data-rel="back" class="ui-btn ui-corner-all ui-shadow
                   ui-btn-a ui-icon-delete ui-btn-icon-notext ui-btn-right" style="background-color:black;">
                    Fermer
                </a>
                <div class="mesPopups"> 
                    <center><p>

                            <br><strong>Pointer l'image de disparition et d'apparition</strong></p>
                        <button OK ></button>
                    </center>

                </div>
            </div>
            <div id="popupPointerMaxEclat" data-role="popup" data-theme="a" data-overlay-theme="b"
                 class="ui-corner-all" data-corners="true" data-position-to="window">
                <a href="#" data-rel="back" class="ui-btn ui-corner-all ui-shadow
                   ui-btn-a ui-icon-delete ui-btn-icon-notext ui-btn-right" style="background-color:black;">
                    Fermer
                </a>
                <div class="mesPopups"> 
                    <center><p>

                            <br><strong>Pointer l'image du maximum d'éclat</strong></p>
                        <button OK ></button>
                    </center>

                </div>
            </div>
            <div id="popupQFGRB" data-role="popup" data-theme="a" data-overlay-theme="b"
                 class="ui-corner-all" data-corners="true" data-position-to="window">
                <a href="#" data-rel="back" class="ui-btn ui-corner-all ui-shadow
                   ui-btn-a ui-icon-delete ui-btn-icon-notext ui-btn-right" style="background-color:black;">
                    Fermer
                </a>
                <div class="mesPopups"> 
                    <center><p>

                            <br><strong>Sursaut Gama</strong></p>
                        <input type="button" onclick='window.location.reload(false)' value="Ok"/>
                    </center>

                </div>
            </div>
            <div id="popupQFSN" data-role="popup" data-theme="a" data-overlay-theme="b"
                 class="ui-corner-all" data-corners="true" data-position-to="window">
                <a href="#" data-rel="back" class="ui-btn ui-corner-all ui-shadow
                   ui-btn-a ui-icon-delete ui-btn-icon-notext ui-btn-right" style="background-color:black;">
                    Fermer
                </a>
                <div class="mesPopups"> 
                    <center><p>

                            <br><strong>SuperNova ou Nova</strong></p>
                        <button OK ></button>
                    </center>

                </div>
            </div>
            <div id="popupQFKN" data-role="popup" data-theme="a" data-overlay-theme="b"
                 class="ui-corner-all" data-corners="true" data-position-to="window">
                <a href="#" data-rel="back" class="ui-btn ui-corner-all ui-shadow
                   ui-btn-a ui-icon-delete ui-btn-icon-notext ui-btn-right" style="background-color:black;">
                    Fermer
                </a>
                <div class="mesPopups"> 
                    <center><p>

                            <br><strong>KiloNova</strong></p>
                        <button OK ></button>
                    </center>

                </div>
            </div>
        </div>
    </div>

    <script>
        /*
         *
         *   Initialisation de la page
         *
         */
        var cand = 0;
        var evenement = 0;
        var NbCand = 0;
        $(function () {
            chargerImg();
            initEvent();
            $("#btnCanSuivant").bind("click", CanSvt);
            $("#btnCanPrecedent").bind("click", CanPrdt);
        });
        function initEvent() {
            $("#btnCanPrecedent").addClass("ui-state-disabled");


        }
        function changeEvent(numEvent) {
            evenement = numEvent;
            cand = 0;
            chargerImg();

        }

        function CanSvt() {
            if (cand < (NbCand - 1)) {
                cand++;
                chargerImg();
            }

        }


        function CanPrdt() {
            if (cand > 0) {
                cand--;
                chargerImg();
            }

        }
        function cache() {
            if (cand === NbCand - 1)
                $("#btnCanSuivant").addClass("ui-state-disabled");
            else
                $("#btnCanSuivant").removeClass("ui-state-disabled");
            if (cand === 0)
                $("#btnCanPrecedent").addClass("ui-state-disabled");
            else
                $("#btnCanPrecedent").removeClass("ui-state-disabled");
        }

        function chargerImg() {

            $.ajax({
                url: 'eventSkyTracker.jsp?action=qualifier_req',
                type: 'POST',
                // On passe nos parametres par POST au script qualifier_req.jsp
                // pour transmettre la candidate et l'évènement
                data: 'candidate=' + cand + '&event=' + evenement,
                success: function (data) {
                    if (data.indexOf("aucunEvent") !== -1) {
                        var cheminImages = ["/Aucun_Event/AucuneCandidate"];
                        var listDelai = [0];
                        remplir(cheminImages, listDelai);
                        $("#btnCanPrecedent").removeClass("ui-state-disabled");
                        $("#btnCanSuivant").removeClass("ui-state-disabled");
                        /*on fait disparaitre tous les éléments de la page */
                        document.getElementById("Q1").style.display = 'none';
                        document.getElementById("btnPrec").style.display = 'none';
                        document.getElementById("btnSuiv").style.display = 'none';
                        document.getElementById("btnSvt").style.display = 'none';
                        document.getElementById("btnPcdt").style.display = 'none';
                        document.getElementById("btnCanPrecedent").style.display = 'none';
                        document.getElementById("btnCanSuivant").style.display = 'none';
                        document.getElementById("divSliderVideo").style.display = 'none';
                        document.getElementById("sliderDelai").style.display = 'none';
                    } else {
                        var reps = data.split("--");
                        var cheminImages = reps[1].split("|");
                        var tabDelai = reps[2].split("|");
                        var X = reps[3].split("|");
                        var Y = reps[4].split("|");
                        var candId = reps[5].split("|");
                        var trame = reps[6].split("|");
                        NbCand = reps[7].split("|");
                        NbCand = NbCand.map(Number);
                        var listDelai = tabDelai.map(Number);
                        getX(X);
                        getY(Y);
                        getCandId(candId);
                        cache();
                        remplir(cheminImages, listDelai);
                    }
                },
                error: function (resultat, statut, erreur) {
                    alert("Désolé, le serveur ne répond pas");
                }

            });

        }

    </script>
</body>
</html>