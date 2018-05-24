<%-- 
    Document    : evalutation.jsp
    Description : Redirige la page évaluation
    Created on  : 21 Mars 2017
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="fr">
    <head>
        <title>Evaluation</title>
        <%@include file="includes/head.jspf"%>
    </head>
    <body>
        <div class="page" data-role="page" id="introTestPage">
            <div class="header" data-role="header" data-id="main-header" data-tap-toggle="false" 
                 data-theme="a" data-position="fixed" data-fullscreen="true">
                <h1>Evaluation</h1>
                <%@include file="includes/session.jspf" %>
                <%@include file="includes/user.jspf" %>
            </div>
            <script type="text/javascript" src="js/tuto.js"></script> 
            <div role="main" class="ui-content">
                <br/><br/>
                <p>Ce test, s'il est réussi, va vous permettre de vous inscrire. 
                    Ainsi, vous pourrez soumettre des images candidates à nos experts.</p>
                <p>Mais vous devez faire moins de 3 fautes.</p>
                <p>La durée du test n'est pas limitée.</p>
                <p>Commençons de suite !</p>

                <p><a id="Evaluation" class="ui-btn ui-shadow ui-corner-all" data-ajax="false">
                    Le test
                </a></p>
            </div>

            <%@include file="includes/footer.jspf" %>
        </div>

        <div class="page" data-role="page" id="evaluationPage">
            <div class="header" data-role="header" data-id="main-header" data-tap-toggle="false" 
                 data-theme="a" data-position="fixed" data-fullscreen="true">
                <h1>Evaluation</h1>
            </div>
            <div role="main" class="ui-content">
                <br/><br/>
                <div data-demo-html="true">
                    <div data-role="collapsibleset" data-theme="a"
                         class="ui-alt-icon">
                        
                        <div data-role="collapsible">
                            <h3><span id="rc01">Question 01</span></h3>
                            <form>
                                <fieldset data-role="controlgroup">
                                    <legend>Une kilonova est un phénomène qui se produit :</legend>
                                    <input name="rc01" id="rc010" value="01 0" checked="checked" type="radio">
                                    <label for="rc010">Pas de réponse</label>
                                    <input name="rc01" id="rc011" value="01 1" type="radio">
                                    <label for="rc011">juste après la fusion de deux étoiles à neutrons</label>
                                    <input name="rc01" id="rc012" value="01 2" type="radio">
                                    <label for="rc012">juste après la fusion de deux trous noirs</label>
                                    <input name="rc01" id="rc013" value="01 3" type="radio">
                                    <label for="rc013">lorsqu'une étoile à neutrons est absorbée par un trou noir</label>
                                    <input name="rc01" id="rc014" value="01 4" type="radio">
                                    <label for="rc014">quand une étoile a consommé son combustible </label>
                                </fieldset>
                            </form>
                        </div>
                        <div data-role="collapsible">
                            <h3><span id="rc02">Question 02</span></h3>
                            <form>
                                <fieldset data-role="controlgroup">
                                    <legend>Une kilonova est accompagné par une émission :</legend>
                                    <input name="rc02" id="rc020" value="02 0" checked="checked" type="radio">
                                    <label for="rc020">Pas de réponse</label>
                                    <input name="rc02" id="rc021" value="02 1" type="radio">
                                    <label for="rc021">d'ondes gravitationnelles et d'ondes électromagnétiques</label>
                                    <input name="rc02" id="rc022" value="02 2" type="radio">
                                    <label for="rc022">d'ondes gravitationnelles uniquement</label>
                                    <input name="rc02" id="rc023" value="02 3" type="radio">
                                    <label for="rc023">de lumière uniquement</label>   
                                    <input name="rc02" id="rc024" value="02 4" type="radio">
                                    <label for="rc024">d'ondes invisible par l'oeil</label> 
                                </fieldset>
                            </form>
                        </div>
                        <div data-role="collapsible">
                            <h3><span id="rc03">Question 03</span></h3>
                            <form>

                                <fieldset data-role="controlgroup">
                                    <legend>On peut détecter avec précision la position d'une kilonova :</legend>
                                    <input name="rc03" id="rc030" value="03 0" checked="checked" type="radio">
                                    <label for="rc030">Pas de réponse</label>
                                    <input name="rc03" id="rc031" value="03 1" type="radio">
                                    <label for="rc031">grâce à la lumière qu'elle émet</label>
                                    <input name="rc03" id="rc032" value="03 2" type="radio">
                                    <label for="rc032">grâce aux ondes gravitationnelles émises</label>
                                    <input name="rc03" id="rc033" value="03 3" type="radio">
                                    <label for="rc033">impossible de la localiser</label>
                                    <input name="rc03" id="rc034" valur="03 4" type="radio">
                                    <label for="rc034">grâce aux ondes gravitationnelles et aux ondes gamma émises</label>
                                </fieldset>
                            </form>
                        </div>
                        <div data-role="collapsible">
                            <h3><span id="rc04">Question 04</span></h3>
                            <form>
                                <center>
                                    <div class="tutoEval1">
                                        <%--  <img src="images/imageEval2.png">  image courbe à faire --%>
                                    </div>
                                </center>

                                <fieldset data-role="controlgroup">
                                    <legend>La lumière émise par une kilonova est visible :</legend>
                                    <input name="rc04" id="rc040" value="04 0" checked="checked" type="radio">
                                    <label for="rc040">Pas de réponse</label>
                                    <input name="rc04" id="rc041" value="04 1" type="radio">
                                    <label for="rc041">plusieurs jours</label>
                                    <input name="rc04" id="rc042" value="04 2" type="radio">
                                    <label for="rc042">plusieurs secondes</label>
                                    <input name="rc04" id="rc043" value="04 3" type="radio">
                                    <label for="rc043">plusieurs mois</label>
                                    <input name="rc04" id="rc044" value="04 4" type="radio">
                                    <label for="rc044">plusieurs semaines</label>
                                </fieldset>
                            </form>
                        </div>
                        <div data-role="collapsible">
                            <h3><span id="rc05">Question 05</span></h3>
                            <form>
                                <center>
                                    <div class="tutoEval2">
                                      <%--  <img src="images/imageEval2.png">  image courbe à faire --%>
                                    </div>
                                </center>
                                <fieldset data-role="controlgroup">
                                    <legend>La détection des kilonovas peut se faire :</legend>
                                    <input name="rc05" id="rc050" value="11 0" checked="checked" type="radio">
                                    <label for="rc050">Pas de réponse</label>
                                    <input name="rc05" id="rc051" value="05 1" type="radio">
                                    <label for="rc051">par n'importe quelle personne qui a accès aux images dans le domaine visible de la source d'émission des ondes gravitationnelles</label>
                                    <input name="rc05" id="rc052" value="05 2" type="radio">
                                    <label for="rc052">jà l'aide des téléscopes gamma uniquement une fois la position de la source d'ondes gravitationnelles connu</label>
                                    <input name="rc05" id="rc053" value="05 3" type="radio">
                                    <label for="rc053">à l'aide des satellites une fois la position de la source d'ondes gravitationnelles connue</label>
                                    <input name="rc05" id="rc054" value="05 4" type="radio">
                                    <label for="rc054">à l'aide des ondes gravitationnelles uniquement, car elles permettent de connaître la position de la source</label>
                                </fieldset>
                            </form>
                        </div>
                        <div data-role="collapsible">
                            <h3><span id="rc06">Question 06</span></h3>
                            <form>
                                <fieldset id="fieldset1" data-role="controlgroup" class="fieldset">
                                    <legend>Une supernova correspond à :</legend>
                                    <input name="rc06" id="rc060" value="06 0" checked="checked" type="radio">
                                    <label for="rc060">Pas de réponse</label>
                                    <input name="rc06" id="rc061" value="06 1" type="radio">
                                    <label for="rc061">la naissance d'une étoile</label>
                                    <input name="rc06" id="rc062" value="06 2" type="radio">
                                    <label for="rc062">la mort d'une étoile</label>
                                    <input name="rc06" id="rc063" value="06 3" type="radio">
                                    <label for="rc063">le passage d'une météorite dans une galaxie</label>
                                </fieldset>
                            </form>
                        </div>
                        <div data-role="collapsible">
                            <h3><span id="rc07">Question 07</span></h3>
                            <form>
                                <fieldset id="fieldset2" data-role="controlgroup" class="fieldset">
                                    <legend>L'intensité lumineuse maximale d'une supernova est atteinte :</legend>
                                    <input name="rc07" id="rc070" value="07 0" checked="checked" type="radio">
                                    <label for="rc070">Pas de réponse</label>
                                    <input name="rc07" id="rc071" value="07 1" type="radio">
                                    <label for="rc071">au bout d'une heure</label>
                                    <input name="rc07" id="rc072" value="07 2" type="radio">
                                    <label for="rc072">dans les premiers jours</label>
                                    <input name="rc07" id="rc073" value="07 3" type="radio">
                                    <label for="rc073">au bout d'un mois</label>
                                </fieldset>
                            </form>
                        </div>
                        <div data-role="collapsible">
                            <h3><span id="rc08">Question 08</span></h3>
                            <form>
                                <fieldset id="fieldset3" data-role="controlgroup" class="fieldset">
                                    <legend>Les images de cette application sont obtenues à partir de :</legend>
                                    <input name="rc08" id="rc080" value="08 0" checked="checked" type="radio">
                                    <label for="rc080">Pas de réponse</label>
                                    <input name="rc08" id="rc081" value="08 1" type="radio">
                                    <label for="rc081">un télescope</label>
                                    <input name="rc08" id="rc082" value="08 2" type="radio">
                                    <label for="rc082">deux télescopes</label>
                                    <input name="rc08" id="rc083" value="08 3" type="radio">
                                    <label for="rc083">trois télescopes</label>
                                    <input name="rc08" id="rc084" value="08 4" type="radio">
                                    <label for="rc084">plus de trois télescopes</label>
                                </fieldset>
                            </form>
                        </div>
                        <div data-role="collapsible">
                            <h3><span id="rc09">Question 09</span></h3>
                            <form>
                                <fieldset id="fieldset4" data-role="controlgroup" class="fieldset">
                                    <legend>Les galaxies surveillées chaque année sont au nombre de :</legend>
                                    <input name="rc09" id="rc090" value="09 0" checked="checked" type="radio">
                                    <label for="rc090">Pas de réponse</label>
                                    <input name="rc09" id="rc091" value="09 1" type="radio">
                                    <label for="rc091">10</label>
                                    <input name="rc09" id="rc092" value="09 2" type="radio">
                                    <label for="rc092">100</label>
                                    <input name="rc09" id="rc093" value="09 3" type="radio">
                                    <label for="rc093">1000</label>
                                    <input name="rc09" id="rc094" value="09 4" type="radio">
                                    <label for="rc094">10000</label>
                                </fieldset>
                            </form>
                        </div>
                        <div data-role="collapsible">
                            <h3><span id="rc10">Question 10</span></h3>
                            <form>
                                <div class="tutoImg">
                                    <img style="width: 250px;"
                                    <img src="images/test01.jpg">
                                    <img style="width: 250px;"
                                    <img src="images/test01Ref.jpg">
                                </div>
                                <fieldset id="fieldset5" data-role="controlgroup" class="fieldset">
                                    <legend>La trainée claire à gauche est due :</legend>
                                    <input name="rc10" id="rc100" value="10 0" checked="checked" type="radio">
                                    <label for="rc100">Pas de réponse</label>
                                    <input name="rc10" id="rc101" value="10 1" type="radio">
                                    <label for="rc101">au passage d'un cosmique</label>
                                    <input name="rc10" id="rc102" value="10 2" type="radio">
                                    <label for="rc102">au passage d'un satellite</label>
                                    <input name="rc10" id="rc103" value="10 3" type="radio">
                                    <label for="rc103">à une supernova</label>
                                </fieldset>
                            </form>
                        </div>
                        <div data-role="collapsible">
                            <h3><span id="rc11">Question 11</span></h3>
                            <form>
                                <fieldset data-role="controlgroup">
                                    <legend>Les supernovae visibles par cette application seront elles rares ?</legend>
                                    <input name="rc11" id="rc110" value="11 0" checked="checked" type="radio">
                                    <label for="rc110">je ne sais pas !</label>
                                    <input name="rc11" id="rc111" value="11 1" type="radio">
                                    <label for="rc111">environ 1 par mois</label>
                                    <input name="rc11" id="rc112" value="11 2" type="radio">
                                    <label for="rc112">environ 2 par an</label>
                                    <input name="rc11" id="rc113" value="11 3" type="radio">
                                    <label for="rc113">environ 1 tout les 5 ans</label>
                                </fieldset>
                            </form>
                        </div>
                        <div data-role="collapsible">
                            <h3><span id="rc12">Question 12</span></h3>
                            <form>
                                <fieldset data-role="controlgroup">
                                    <legend>Qu'est ce qu'une galaxie ?</legend>
                                    <input name="rc12" id="rc120" value="12 0" checked="checked" type="radio">
                                    <label for="rc120">je ne sais pas !</label>
                                    <input name="rc12" id="rc121" value="12 1" type="radio">
                                    <label for="rc121">une étoile</label>
                                    <input name="rc12" id="rc122" value="12 2" type="radio">
                                    <label for="rc122">un amas d'étoiles</label>
                                    <input name="rc12" id="rc123" value="12 3" type="radio">
                                    <label for="rc123">une étoile qui explose</label>
                                </fieldset>
                            </form>
                        </div>
                        <div data-role="collapsible">
                            <h3><span id="rc13">Question 13</span></h3>
                            <form>
                                <fieldset data-role="controlgroup">
                                    <legend>Si je vois une nouvelle source de lumière, qu'est ce que je fais ?</legend>
                                    <input name="rc13" id="rc130" value="13 0" checked="checked" type="radio">
                                    <label for="rc130">je ne sais pas !</label>
                                    <input name="rc13" id="rc131" value="13 1" type="radio">
                                    <label for="rc131">j'envoie une candidate immédiatement</label>
                                    <input name="rc13" id="rc132" value="13 2" type="radio">
                                    <label for="rc132">je vérifie l'historique avant d'envoyer</label>
                                    <input name="rc13" id="rc133" value="13 3" type="radio">
                                    <label for="rc133">je n'envoie rien</label>
                                </fieldset>
                            </form>
                        </div>
                        <div data-role="collapsible">
                            <h3><span id="rc14">Question 14</span></h3>
                            <form>
                                <div class="tutoImg2">
                                    <img style="width: 250px;"
                                    <img src="images/tuto36.jpg">
                                </div>
                                <fieldset data-role="controlgroup">
                                    <legend>Y a t-il une supernova dans cette image?</legend>
                                    <input name="rc14" id="rc140" value="14 0" checked="checked" type="radio">
                                    <label for="rc140">je ne sais pas !</label>
                                    <input name="rc14" id="rc141" value="14 1" type="radio">
                                    <label for="rc141">Oui, j'en suis sûr</label>
                                    <input name="rc14" id="rc142" value="14 2" type="radio">
                                    <label for="rc142">Je pense mais je vérifie avec histo et blink</label>
                                    <input name="rc14" id="rc143" value="14 3" type="radio">
                                    <label for="rc143">je n'envoie rien</label>
                                </fieldset>
                            </form>
                        </div>                               
                        <div data-role="collapsible">
                            <h3><span id="rc15">Question 15</span></h3>
                            <form>
                                <div class="tutoImg">
                                    <img style="width: 250px;"
                                    <img src="images/test01Ref.jpg">
                                    <img style="width: 250px;"
                                    <img src="images/test01Ref.jpg">
                                </div>
                                <fieldset data-role="controlgroup">
                                    <legend>Y a t-il une supernova dans cette image?</legend>
                                    <input name="rc15" id="rc150" value="15 0" checked="checked" type="radio">
                                    <label for="rc150">je ne sais pas !</label>
                                    <input name="rc15" id="rc151" value="15 1" type="radio">
                                    <label for="rc151">Oui j'en suis sûr</label>
                                    <input name="rc15" id="rc152" value="15 2" type="radio">
                                    <label for="rc152">Je pense mais je vérifie avec histo et blink</label>
                                    <input name="rc15" id="rc153" value="15 3" type="radio">
                                    <label for="rc153">je pense qu'il n'y en a pas</label>
                                </fieldset>
                            </form>
                        </div>
                        <div data-role="collapsible">
                            <h3><span id="rc16">Question 16</span></h3>
                            <form>
                                <div class="tutoImg2">
                                    <img style="width: 250px;"
                                    <img src="images/tuto35.jpg">
                                </div>
                                <fieldset data-role="controlgroup">
                                    <legend>Y a t-il une supernova dans cette image?</legend>
                                    <input name="rc16" id="rc160" value="16 0" checked="checked" type="radio">
                                    <label for="rc160">je ne sais pas !</label>
                                    <input name="rc16" id="rc161" value="16 1" type="radio">
                                    <label for="rc161">Oui, j'en suis sûr</label>
                                    <input name="rc16" id="rc162" value="16 2" type="radio">
                                    <label for="rc162">Je pense mais je vérifie avec histo et blink</label>
                                    <input name="rc16" id="rc163" value="16 3" type="radio">
                                    <label for="rc163">je n'envoie rien</label>
                                </fieldset>
                            </form>
                        </div>
                    </div>                 
                </div>
                <div class="ui-grid-a">
                    <div class="ui-block-a">
                        <button id="btnResetQCM" class="ui-btn">Reset</button>
                    </div>
                    <div class="ui-block-b">
                        <button id="btnTestQCM" class="ui-btn" data-ajax="false">Envoyer</button>
                    </div>
                </div>
            </div>
        
            
        <%-- le script pour s'exécuter doit être dans la page data-role --%>
        <script>
            var totalQCM = new Array();
            var nbQuestions = 16;

            // A l'initialisation de la page
            $(function () {
                $("#btnResetQCM").bind("click", resetQCM);
                $("#btnTestQCM").bind("click", testQCM);
                $("#btnPopupInscription").bind("click", inscription);
                $("#btnPopupDejaInscrit").bind("click", dejaInscrit);
                $("#btnPopupQCMRate").bind("click", QCMNonReussi);
                resetQCM();
                $("input[type='radio']").bind("change", function (event, ui) {//"input[type='radio']").bind("change", function (event, ui) {     "input:radio"
                    // valeur = "01 2"    
                    //           01 : num question (0 à n-1)
                    //            2 : num du choix
                    value = $(this).val();
                    question = parseInt(value.substring(0, 2));
                    choix = parseInt(value.substring(3, 4));
                    totalQCM[question - 1] = choix;
                    id = '#' + $(this).attr('name');
                    // le titre est gris si la question est traitée, noir sinon
                    if (choix > 0)
                        $(id).css('color', 'lightgrey');
                    else
                        $(id).css('color', 'black');
                });
            });

            // on reset toutes les forms
            function resetQCM() {
                for (i = 0; i < nbQuestions; i++) {
                    $('form')[i].reset();
                    totalQCM[i] = 0;
                    if (i + 1 >= 10)                  // tous les titres sont noirs
                        val = (i + 1).toString();
                    else
                        val = "0" + (i + 1).toString();
                    id = '#rc' + val;
                    $(id).css('color', 'black');
                }
            }

            function testQCM() {
                nbReponses = nbReponsesQCM();
                if (nbReponses >= nbQuestions) {    // est ce fini ?
                    envoiQCM();
                } else {                              // popup d'avertissement
                    $('#popupPbQCM').popup("open");
                }
            }

            function nbReponsesQCM() {
                var total = 0;

                for (i = 0; i < nbQuestions; i++) {
                    if (totalQCM[i] > 0)
                        total++;
                }
                return total;
            }

            function envoiQCM() {
                var reponses = "";
                for (i = 0; i < nbQuestions; i++) {
                    reponses += totalQCM[i] + "|";
                }
                $.ajax({
                    url: 'eventSkyTracker.jsp?action=qcm_req',
                    type: 'POST',
                    // On passe nos parametres par POST au script qcm_req.jsp
                    // pour transmettre les réponses au questionnaire 
                    data: 'reponses=' + reponses.toString(),
                    success: function (data) {
                        if (data.indexOf("oui") !== -1) {
                            $('#popupInscription').popup("open");
                        } else if (data.indexOf("inscrit") !== -1) {
                            $('#popupDejaInscrit').popup("open");
                        } else {
                            $('#popupQCMRate').popup("open");
                        }
                    },
                    error: function (resultat, statut, erreur) {
                        alert("Désolé, le serveur ne répond pas");
                    }
                });
            }

            function inscription() {
                window.location.href = "eventSkyTracker.jsp?action=inscription";
            }

            function dejaInscrit() {
                $.mobile.changePage("eventSkyTracker.jsp?action=infoUser", {transition: "slide"});
            }

            function QCMNonReussi() {
                document.location.href = "tuto.jsp";
            }
        </script>

        <%@include file="includes/footer.jspf" %>

        <!-- popup pb avec QCM en mode modal-->
        <div id="popupInscription" data-role="popup" data-theme="a" data-overlay-theme="b"
             class="ui-corner-all ui-alt-icon" data-corners="true" data-position-to="window" data-dismissible="false">
            <div class="mesPopups" align="center">
                <br/>
                <h3 id="textPopupInscription">Bravo !<br/>Vous pouvez maintenant vous inscrire.</h3>
                <br/>
                <button id="btnPopupInscription" class="ui-btn ui-corner-all">OK</button>
            </div>
        </div>

        <!-- popup déjà inscrit en mode modal-->
        <div id="popupDejaInscrit" data-role="popup" data-theme="a" data-overlay-theme="b"
             class="ui-corner-all ui-alt-icon" data-corners="true" data-position-to="window" data-dismissible="false">
            <div class="mesPopups" align="center">
                <br/>
                <h3 id="textPopupDejaInscrit">Bravo !<br/>Mais vous êtes déjà inscrit.</h3>
                <br/>
                <button id="btnPopupDejaInscrit" class="ui-btn ui-corner-all">OK</button>
            </div>
        </div>

        <!-- popup pb avec QCM en mode modal-->
        <div id="popupQCMRate" data-role="popup" data-theme="a" data-overlay-theme="b"
             class="ui-corner-all ui-alt-icon" data-corners="true" data-position-to="window" data-dismissible="false">
            <div class="mesPopups" align="center">
                <br/>
                <h3 id="textPopupQCMRate">Vous avez fait trop d'erreurs<br/>Revoyez le tutoriel.</h3>
                <br/>
                <button id="btnPopupQCMRate" class="ui-btn ui-corner-all" href="tuto.jsp">OK</button>
            </div>
        </div>

        <!-- popup pb avec QCM en mode non modal-->
        <div id="popupPbQCM" data-role="popup" data-theme="a" data-overlay-theme="b"
             class="ui-corner-all ui-alt-icon" data-corners="true" data-position-to="window" data-dismissible="true">
            <a href="#" data-rel="back" class="ui-btn ui-corner-all ui-shadow 
               ui-btn-a ui-icon-delete ui-btn-icon-notext ui-btn-right">Close</a>
            <div class="mesPopups" align="center">
                <br/>
                <h3 id="popupTextPbQCM">Vous n'avez pas répondu à toutes les questions.</h3>
                <br/>
            </div>
        </div>
        </div>
    </body>
</html>
