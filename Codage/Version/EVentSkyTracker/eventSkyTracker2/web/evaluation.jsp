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
                            <form id="form1">
                                <fieldset id="fieldset1" data-role="controlgroup" class="fieldset">
                                    <legend>La lumière émise par les étoiles :</legend>
                                    <input name="rc01" id="rc010" value="01 0" checked="checked" type="radio">
                                    <label for="rc010">pas de réponse</label>
                                    <input name="rc01" id="rc011" value="01 1" type="radio">
                                    <label for="rc011">a toujours la même intensité</label>
                                    <input name="rc01" id="rc012" value="01 2" type="radio">
                                    <label for="rc012">est liée à la transformation de l’hydrogène en hélium à l’intérieur de l’étoile</label>
                                    <input name="rc01" id="rc013" value="01 3" type="radio">
                                    <label for="rc013">est liée à la transformation de l’hélium en hydrogène à l’intérieur de l’étoile</label>
                                </fieldset>
                            </form>
                        </div>
                        <div data-role="collapsible">
                            <h3><span id="rc02">Question 02</span></h3>
                            <form>
                                <fieldset id="fieldset2" data-role="controlgroup" class="fieldset">
                                    <legend>La naissance d’une étoile </legend>
                                    <input name="rc02" id="rc020" value="02 0" checked="checked" type="radio">
                                    <label for="rc020">Pas de réponse</label>
                                    <input name="rc02" id="rc021" value="02 1" type="radio">
                                    <label for="rc021"> a lieu dans les systèmes planétaires</label>
                                    <input name="rc02" id="rc022" value="02 2" type="radio">
                                    <label for="rc022">c’est la période la plus longue de la vie d’une étoile</label>
                                    <input name="rc02" id="rc023" value="02 3" type="radio">
                                    <label for="rc023">a lieu dans de nuages de gaz</label>
                                </fieldset>
                            </form>
                        </div>
                        <div data-role="collapsible">
                            <h3><span id="rc03">Question 03</span></h3>
                            <form>
                                <fieldset id="fieldset3" data-role="controlgroup" class="fieldset">
                                    <legend>La séquence principale :</legend>
                                    <input name="rc03" id="rc030" value="03 0" checked="checked" type="radio">
                                    <label for="rc030">Pas de réponse</label>
                                    <input name="rc03" id="rc031" value="03 1" type="radio">
                                    <label for="rc031"> représente la fin de vie d’une étoile</label>
                                    <input name="rc03" id="rc032" value="03 2" type="radio">
                                    <label for="rc032">est une représentation graphique</label>
                                    <input name="rc03" id="rc033" value="03 3" type="radio">
                                    <label for="rc033"> représente la période la plus longue de la vie d’une étoile</label>
                                    <input name="rc03" id="rc034" value="03 4" type="radio">
                                    <label for="rc034">ne dépend pas de la masse de l’étoile</label>                                  
                                </fieldset>
                            </form>
                        </div>
                        <div data-role="collapsible">
                            <h3><span id="rc04">Question 04</span></h3>
                            <form>
                                <fieldset id="fieldset4" data-role="controlgroup" class="fieldset">
                                    <legend>La fin de vie des étoiles massives :</legend>
                                    <input name="rc04" id="rc040" value="04 0" checked="checked" type="radio">
                                    <label for="rc040">Pas de réponse</label>
                                    <input name="rc04" id="rc041" value="04 1" type="radio">
                                    <label for="rc041">est toujours accompagnée par une augmentation soudaine de l’intensité de la lumière qu’elle émet</label>
                                    <input name="rc04" id="rc042" value="04 2" type="radio">
                                    <label for="rc042">est toujours accompagnée par une diminution progressive de l’intensité de la lumière qu’elle émet</label>
                                    <input name="rc04" id="rc043" value="04 3" type="radio">
                                    <label for="rc043">est toujours accompagnée par une augmentation progressive de l’intensité de la lumière qu’elle émet</label>

                                </fieldset>
                            </form>
                        </div>
                        <div data-role="collapsible">
                            <h3><span id="rc05">Question 05</span></h3>
                            <form>

                                <fieldset id="fieldset5" data-role="controlgroup" class="fieldset">
                                    <legend>L’explosion d’une étoile :</legend>
                                    <input name="rc05" id="rc050" value="05 0" checked="checked" type="radio">
                                    <label for="rc050">Pas de réponse</label>
                                    <input name="rc05" id="rc051" value="05 1" type="radio">
                                    <label for="rc051">est un phénomène qui arrive à toute étoile en fin de vie</label>
                                    <input name="rc05" id="rc052" value="05 2" type="radio">
                                    <label for="rc052">est liée à sa masse</label>
                                    <input name="rc05" id="rc053" value="05 3" type="radio">
                                    <label for="rc053">est déclenchée par un phénomène cosmique dans la proximité de l’étoile</label>
                                </fieldset>
                            </form>
                        </div>
                        <div data-role="collapsible">
                            <h3><span id="rc06">Question 06</span></h3>
                            <form>
                                <fieldset data-role="controlgroup">
                                    <legend>Une étoile de masse comprise entre 8 et 40 masses solaires :</legend>
                                    <input name="rc06" id="rc060" value="06 0" checked="checked" type="radio">
                                    <label for="rc060">Pas de réponse</label>
                                    <input name="rc06" id="rc061" value="06 1" type="radio">
                                    <label for="rc061">finit sa vie par une explosion générant des sursauts gamma</label>
                                    <input name="rc06" id="rc062" value="06 2" type="radio">
                                    <label for="rc062">finit sa vie comme naine blanche</label>
                                    <input name="rc06" id="rc063" value="06 3" type="radio">
                                    <label for="rc063">finit sa vie comme supernova à effondrement de cœur</label>
                                </fieldset>
                            </form>
                        </div>
                        <div data-role="collapsible">
                            <h3><span id="rc07">Question 07</span></h3>
                            <form>
                                <fieldset data-role="controlgroup">
                                    <legend>Une supernova à effondrement de cœur :</legend>
                                    <input name="rc07" id="rc070" value="07 0" checked="checked" type="radio">
                                    <label for="rc070">Pas de réponse</label>
                                    <input name="rc07" id="rc071" value="07 1" type="radio">
                                    <label for="rc071">sera visible plusieurs semaines</label>
                                    <input name="rc07" id="rc072" value="07 2" type="radio">
                                    <label for="rc072">est toujours accompagnée par un sursaut gamma</label>
                                    <input name="rc07" id="rc073" value="07 3" type="radio">
                                    <label for="rc073">sera visible grâce à un flash de quelques minutes </label>
                                </fieldset>
                            </form>
                        </div>
                        <div data-role="collapsible">
                            <h3><span id="rc08">Question 08</span></h3>
                            <form>
                                <fieldset data-role="controlgroup">
                                    <legend> Un sursaut gamma long:</legend>
                                    <input name="rc08" id="rc080" value="08 0" checked="checked" type="radio">
                                    <label for="rc080">Pas de réponse</label>
                                    <input name="rc08" id="rc081" value="08 1" type="radio">
                                    <label for="rc081">est un phénomène de faible éclat qui ne dure que quelques heures</label>
                                    <input name="rc08" id="rc082" value="08 2" type="radio">
                                    <label for="rc082">est un phénomène extrêmement brillant qui ne dure que quelques heures</label>
                                    <input name="rc08" id="rc083" value="08 3" type="radio">
                                    <label for="rc083">est un phénomène extrêmement brillant qui dure quelques semaines</label>                                  
                                </fieldset>
                            </form>
                        </div>
                        <div data-role="collapsible">
                            <h3><span id="rc09">Question 09</span></h3>
                            <form>

                                <fieldset data-role="controlgroup">
                                    <legend>L’explosion d’un couple d’étoiles</legend>
                                    <input name="rc09" id="rc090" value="09 0" checked="checked" type="radio">
                                    <label for="rc090">Pas de réponse</label>
                                    <input name="rc09" id="rc091" value="09 1" type="radio">
                                    <label for="rc091">génère une supernova à effondrement de cœur</label>
                                    <input name="rc09" id="rc092" value="09 2" type="radio">
                                    <label for="rc092">génère un sursaut gamma long</label>
                                    <input name="rc09" id="rc093" value="09 3" type="radio">
                                    <label for="rc093">génère un sursaut gamma court</label>
                                </fieldset>
                            </form>
                        </div>
                        <div data-role="collapsible">
                            <h3><span id="rc10">Question 10</span></h3>
                            <form>
                                <center>
                                    <div class="tutoEval1">
                                        <%--  <img src="images/imageEval2.png">  image courbe à faire --%>
                                    </div>
                                </center>

                                <fieldset data-role="controlgroup">
                                    <legend>La courbe rouge correspond à : </legend>
                                    <input name="rc10" id="rc100" value="10 0" checked="checked" type="radio">
                                    <label for="rc100">Pas de réponse</label>
                                    <input name="rc10" id="rc101" value="10 1" type="radio">
                                    <label for="rc101">à un sursaut gamma long </label>
                                    <input name="rc10" id="rc102" value="10 2" type="radio">
                                    <label for="rc102">à un sursaut gamma court</label>
                                    <input name="rc10" id="rc103" value="10 3" type="radio">
                                    <label for="rc103">à une supernova thermonucléaire</label>
                                    <input name="rc10" id="rc104" value="10 4" type="radio">
                                    <label for="rc104">à une supernova à effondrement de cœur </label>
                                </fieldset>
                            </form>
                        </div>
                        <div data-role="collapsible">
                            <h3><span id="rc11">Question 11</span></h3>
                            <form>
                                <center>
                                    <div class="tutoEval2">
                                      <%--  <img src="images/imageEval2.png">  image courbe à faire --%>
                                    </div>
                                </center>
                                <fieldset data-role="controlgroup">
                                    <legend>La courbe rouge correspond à :</legend>
                                    <input name="rc11" id="rc110" value="11 0" checked="checked" type="radio">
                                    <label for="rc110">Pas de réponse</label>
                                    <input name="rc11" id="rc111" value="11 1" type="radio">
                                    <label for="rc111">à un sursaut gamma long </label>
                                    <input name="rc11" id="rc112" value="11 2" type="radio">
                                    <label for="rc112">à une supernova thermonucléaire</label>
                                    <input name="rc11" id="rc113" value="11 3" type="radio">
                                    <label for="rc113">à un sursaut gamma court</label>
                                    <input name="rc11" id="rc114" value="11 4" type="radio">
                                    <label for="rc114">à une supernova à effondrement de cœur</label>
                                </fieldset>
                            </form>
                        </div>
                        <div data-role="collapsible">
                            <h3><span id="rc12">Question 12</span></h3>
                            <form>
                                <fieldset id="fieldset1" data-role="controlgroup" class="fieldset">
                                    <legend>Une supernova correspond à :</legend>
                                    <input name="rc12" id="rc120" value="012 0" checked="checked" type="radio">
                                    <label for="rc120">Pas de réponse</label>
                                    <input name="rc12" id="rc121" value="12 1" type="radio">
                                    <label for="rc121">la naissance d'une étoile</label>
                                    <input name="rc12" id="rc122" value="12 2" type="radio">
                                    <label for="rc122">la mort d'une étoile</label>
                                    <input name="rc12" id="rc123" value="12 3" type="radio">
                                    <label for="rc123">le passage d'une météorite dans une galaxie</label>
                                </fieldset>
                            </form>
                        </div>
                        <div data-role="collapsible">
                            <h3><span id="rc13">Question 13</span></h3>
                            <form>
                                <fieldset id="fieldset2" data-role="controlgroup" class="fieldset">
                                    <legend>L'intensité lumineuse maximale d'une supernova est atteinte :</legend>
                                    <input name="rc13" id="rc130" value="13 0" checked="checked" type="radio">
                                    <label for="rc130">Pas de réponse</label>
                                    <input name="rc13" id="rc131" value="13 1" type="radio">
                                    <label for="rc131">au bout d'une heure</label>
                                    <input name="rc13" id="rc132" value="13 2" type="radio">
                                    <label for="rc132">dans les premiers jours</label>
                                    <input name="rc13" id="rc133" value="13 3" type="radio">
                                    <label for="rc133">au bout d'un mois</label>
                                </fieldset>
                            </form>
                        </div>
                        <div data-role="collapsible">
                            <h3><span id="rc14">Question 14</span></h3>
                            <form>
                                <fieldset id="fieldset3" data-role="controlgroup" class="fieldset">
                                    <legend>Les images de cette application sont obtenues à partir de :</legend>
                                    <input name="rc14" id="rc140" value="14 0" checked="checked" type="radio">
                                    <label for="rc140">Pas de réponse</label>
                                    <input name="rc14" id="rc141" value="14 1" type="radio">
                                    <label for="rc141">un télescope</label>
                                    <input name="rc14" id="rc142" value="14 2" type="radio">
                                    <label for="rc142">deux télescopes</label>
                                    <input name="rc14" id="rc143" value="14 3" type="radio">
                                    <label for="rc143">trois télescopes</label>
                                    <input name="rc14" id="rc144" value="14 4" type="radio">
                                    <label for="rc144">plus de trois télescopes</label>
                                </fieldset>
                            </form>
                        </div>
                        <div data-role="collapsible">
                            <h3><span id="rc15">Question 15</span></h3>
                            <form>
                                <fieldset id="fieldset4" data-role="controlgroup" class="fieldset">
                                    <legend>Les galaxies surveillées chaque année sont au nombre de :</legend>
                                    <input name="rc15" id="rc150" value="15 0" checked="checked" type="radio">
                                    <label for="rc150">Pas de réponse</label>
                                    <input name="rc15" id="rc151" value="15 1" type="radio">
                                    <label for="rc151">10</label>
                                    <input name="rc15" id="rc152" value="15 2" type="radio">
                                    <label for="rc152">100</label>
                                    <input name="rc15" id="rc153" value="15 3" type="radio">
                                    <label for="rc153">1000</label>
                                    <input name="rc15" id="rc154" value="15 4" type="radio">
                                    <label for="rc154">10000</label>
                                </fieldset>
                            </form>
                        </div>
                        <div data-role="collapsible">
                            <h3><span id="rc16">Question 16</span></h3>
                            <form>
                                <div class="tutoImg">
                                    <img src="images/test01.jpg">
                                    <img src="images/test01Ref.jpg">
                                </div>
                                <fieldset id="fieldset5" data-role="controlgroup" class="fieldset">
                                    <legend>La trainée claire à gauche est due :</legend>
                                    <input name="rc16" id="rc160" value="16 0" checked="checked" type="radio">
                                    <label for="rc160">Pas de réponse</label>
                                    <input name="rc16" id="rc161" value="16 1" type="radio">
                                    <label for="rc161">au passage d'un cosmique</label>
                                    <input name="rc16" id="rc162" value="16 2" type="radio">
                                    <label for="rc162">au passage d'un satellite</label>
                                    <input name="rc16" id="rc163" value="16 3" type="radio">
                                    <label for="rc163">à une supernova</label>
                                </fieldset>
                            </form>
                        </div>
                        <div data-role="collapsible">
                            <h3><span id="rc17">Question 17</span></h3>
                            <form>
                                <fieldset data-role="controlgroup">
                                    <legend>Les supernovae visibles par cette application seront elles rares ?</legend>
                                    <input name="rc17" id="rc170" value="17 0" checked="checked" type="radio">
                                    <label for="rc170">je ne sais pas !</label>
                                    <input name="rc17" id="rc171" value="17 1" type="radio">
                                    <label for="rc171">environ 1 par mois</label>
                                    <input name="rc17" id="rc172" value="17 2" type="radio">
                                    <label for="rc172">environ 2 par an</label>
                                    <input name="rc17" id="rc173" value="17 3" type="radio">
                                    <label for="rc173">environ 1 tout les 5 ans</label>
                                </fieldset>
                            </form>
                        </div>
                        <div data-role="collapsible">
                            <h3><span id="rc18">Question 18</span></h3>
                            <form>
                                <fieldset data-role="controlgroup">
                                    <legend>Qu'est ce qu'une galaxie ?</legend>
                                    <input name="rc18" id="rc180" value="18 0" checked="checked" type="radio">
                                    <label for="rc180">je ne sais pas !</label>
                                    <input name="rc18" id="rc181" value="18 1" type="radio">
                                    <label for="rc181">une étoile</label>
                                    <input name="rc18" id="rc182" value="18 2" type="radio">
                                    <label for="rc182">un amas d'étoiles</label>
                                    <input name="rc18" id="rc183" value="18 3" type="radio">
                                    <label for="rc183">une étoile qui explose</label>
                                </fieldset>
                            </form>
                        </div>
                        <div data-role="collapsible">
                            <h3><span id="rc19">Question 19</span></h3>
                            <form>
                                <fieldset data-role="controlgroup">
                                    <legend>Si je vois une nouvelle source de lumière, qu'est ce que je fais ?</legend>
                                    <input name="rc19" id="rc190" value="19 0" checked="checked" type="radio">
                                    <label for="rc190">je ne sais pas !</label>
                                    <input name="rc19" id="rc191" value="19 1" type="radio">
                                    <label for="rc191">j'envoie une candidate immédiatement</label>
                                    <input name="rc19" id="rc192" value="19 2" type="radio">
                                    <label for="rc192">je vérifie l'historique avant d'envoyer</label>
                                    <input name="rc19" id="rc193" value="19 3" type="radio">
                                    <label for="rc193">je n'envoie rien</label>
                                </fieldset>
                            </form>
                        </div>
                        <div data-role="collapsible">
                            <h3><span id="rc20">Question 20</span></h3>
                            <form>
                                <div class="tutoImg2">
                                    <img src="images/tuto36.jpg">
                                </div>
                                <fieldset data-role="controlgroup">
                                    <legend>Y a t-il une supernova dans cette image?</legend>
                                    <input name="rc20" id="rc200" value="20 0" checked="checked" type="radio">
                                    <label for="rc200">je ne sais pas !</label>
                                    <input name="rc20" id="rc201" value="20 1" type="radio">
                                    <label for="rc201">Oui, j'en suis sûr</label>
                                    <input name="rc20" id="rc202" value="20 2" type="radio">
                                    <label for="rc202">Je pense mais je vérifie avec histo et blink</label>
                                    <input name="rc20" id="rc203" value="20 3" type="radio">
                                    <label for="rc203">je n'envoie rien</label>
                                </fieldset>
                            </form>
                        </div>                               
                        <div data-role="collapsible">
                            <h3><span id="rc21">Question 21</span></h3>
                            <form>
                                <div class="tutoImg">
                                    <img src="images/test01Ref.jpg">
                                    <img src="images/test01Ref.jpg">
                                </div>
                                <fieldset data-role="controlgroup">
                                    <legend>Y a t-il une supernova dans cette image?</legend>
                                    <input name="rc21" id="rc210" value="21 0" checked="checked" type="radio">
                                    <label for="rc210">je ne sais pas !</label>
                                    <input name="rc21" id="rc211" value="21 1" type="radio">
                                    <label for="rc211">Oui j'en suis sûr</label>
                                    <input name="rc21" id="rc212" value="21 2" type="radio">
                                    <label for="rc212">Je pense mais je vérifie avec histo et blink</label>
                                    <input name="rc21" id="rc213" value="21 3" type="radio">
                                    <label for="rc213">je pense qu'il n'y en a pas</label>
                                </fieldset>
                            </form>
                        </div>
                        <div data-role="collapsible">
                            <h3><span id="rc22">Question 22</span></h3>
                            <form>
                                <div class="tutoImg2">
                                    <img src="images/tuto35.jpg">
                                </div>
                                <fieldset data-role="controlgroup">
                                    <legend>Y a t-il une supernova dans cette image?</legend>
                                    <input name="rc22" id="rc220" value="22 0" checked="checked" type="radio">
                                    <label for="rc220">je ne sais pas !</label>
                                    <input name="rc22" id="rc221" value="22 1" type="radio">
                                    <label for="rc221">Oui, j'en suis sûr</label>
                                    <input name="rc22" id="rc222" value="22 2" type="radio">
                                    <label for="rc222">Je pense mais je vérifie avec histo et blink</label>
                                    <input name="rc22" id="rc223" value="22 3" type="radio">
                                    <label for="rc223">je n'envoie rien</label>
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
            var nbQuestions = 22;

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
