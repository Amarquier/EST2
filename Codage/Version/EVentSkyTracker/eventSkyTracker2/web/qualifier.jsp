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
                <div id="video" align="center">
                    <img id="img0" src="images/tuto103.jpg" align="center"/>
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

                            <div  data-role="collapsible" data-collapsed="false">
                                <h3><span id="rp2">Question 2</span></h3>
                                <form>
                                    <fieldset id="fieldset2" data-role="controlgroup" class="fieldset">
                                        <legend id="legend2">L'évenement est'il au centre de l'image ?</legend>
                                        <input name="rp2" id="rp20" value="002 QS" type="radio">
                                        <label id="rp2.0" for="rp20">OUI</label>
                                        <input name="rp2" id="rp21" value="002 Q21" type="radio">
                                        <label id="rp2.1"for="rp21">NON</label>
                                    </fieldset>
                                </form>
                            </div>
                        </div>

                        <div id="Q3" value="03" style="display:none;" >
                            <div data-role="collapsible" data-collapsed="false">
                                <h3><span id="rp3">Question 3</span></h3>
                                <form>
                                    <fieldset id="fieldset3" data-role="controlgroup" class="fieldset">
                                        <legend id="legend3">L'évènement est-il visible sur une seule image ?</legend>
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
                                        <legend id="legend31">Estimer l'éclat</legend>
                                        <input name="rp31" id="rp310" value="031 Q31" type="radio">
                                        <label id="rp31.0" for="rp310">Fort</label>
                                        <input name="rp31" id="rp311" value="031 Q31" type="radio">
                                        <label id="rp31.1" for="rp311">Moyen</label>
                                        <input name="rp31" id="rp312" value="031 Q31" type="radio">
                                        <label id="rp31.2" for="rp312">Faible</label>
                                    </fieldset>
                                </form>
                            </div>
                        </div>
                        <div id="Q32" value="032" style="display:none;" >
                            <div data-role="collapsible" data-collapsed="false">
                                <h3><span id="rp32">Question 3.2</span></h3>
                                <form>
                                    <fieldset id="fieldset32" data-role="controlgroup" class="fieldset">
                                        <legend id="legend32">Est-ce une signature de rayon cosmique ?</legend>
                                        <input name="rp32" id="rp320" value="032 QF" type="radio">
                                        <label id="rp32.0" for="rp320">OUI</label>
                                        <input name="rp32" id="rp321" value="032 Q31" type="radio">
                                        <label id="rp32.1" for="rp321">NON</label>            
                                        <input name="rp32" id="rp322" value="032 Q31" type="radio">
                                        <label id="rp32.2" for="rp322">Je ne sais pas</label>  
                                    </fieldset>
                                </form>
                            </div>
                        </div>
                        <div id="Q33" value="033" style="display:none;" >
                            <div data-role="collapsible" data-collapsed="false">
                                <h3><span id="rp33">Question 3.3</span></h3>
                                <form>
                                    <fieldset id="fieldset33" data-role="controlgroup" class="fieldset">
                                        <legend id="legend33">Est-ce une signature de satellite ?</legend>
                                        <input name="rp33" id="rp330" value="033 QF" type="radio">
                                        <label id="rp33.0" for="rp330">OUI</label>
                                        <input name="rp33" id="rp331" value="033 QF" type="radio">
                                        <label id="rp33.1" for="rp331">NON</label>            
                                        <input name="rp33" id="rp332" value="033 QF" type="radio">
                                        <label id="rp33.2" for="rp332">Je ne sais pas</label>  
                                    </fieldset>
                                </form>
                            </div>
                        </div>
                        <div id="Q4" value="04" style="display:none;" >
                            <div data-role="collapsible" data-collapsed="false">
                                <h3><span id="rp4">Question 4</span></h3>
                                <form>
                                    <fieldset id="fieldset4" data-role="controlgroup" class="fieldset">
                                        <legend id="legend4">L'événement se déplace-t'il ?</legend>
                                        <input name="rp4" id="rp40" value="004 Q41" type="radio">
                                        <label id="rp4.0" for="rp40">OUI</label>
                                        <input name="rp4" id="rp41" value="004 QS" type="radio">
                                        <label id="rp4.1" for="rp41">NON</label>            
                                    </fieldset>
                                </form>
                            </div>
                        </div>
                        <div id="Q41" value="041" style="display:none;" >
                            <div data-role="collapsible" data-collapsed="false">
                                <h3><span id="rp41">Question 4.1</span></h3>
                                <form>
                                    <fieldset id="fieldset41" data-role="controlgroup" class="fieldset">
                                        <legend id="legend41" >Est-ce une signature de satellite ?</legend>
                                        <input name="rp41" id="rp410" value="041 QF" type="radio">
                                        <label id="rp41.0" for="rp410">OUI</label>
                                        <input name="rp41" id="rp411" value="041 Q41" type="radio">
                                        <label id="rp41.1" for="rp411">NON</label>
                                        <input name="rp41" id="rp412" value="041 Q41" type="radio">
                                        <label id="rp41.2" for="rp412">Je ne sais pas</label>  
                                    </fieldset>
                                </form>
                            </div>
                        </div>
                        <div id="Q42" value="042" style="display:none;" >
                            <div data-role="collapsible" data-collapsed="false">
                                <h3><span id="rp42">Question 4.2</span></h3>
                                <form>
                                    <fieldset id="fieldset42" data-role="controlgroup" class="fieldset">
                                        <legend id="legend42" >Est-ce une signature d'asteroide ?</legend>
                                        <input name="rp42" id="rp420" value="042 QF" type="radio">
                                        <label id="rp42.0" for="rp420">OUI</label>
                                        <input name="rp42" id="rp421" value="042 QF" type="radio">
                                        <label id="rp42.1" for="rp421">NON</label>  
                                        <input name="rp42" id="rp422" value="042 QF" type="radio">
                                        <label id="rp42.2" for="rp422">Je ne sais pas</label>  
                                    </fieldset>
                                </form>
                            </div>
                        </div>

                        <div id="Q5" value="05" style="display:none;" >
                            <div data-role="collapsible" data-collapsed="false">
                                <h3><span id="rp5">Question 5</span></h3>
                                <form>
                                    <fieldset id="fieldset5" data-role="controlgroup" class="fieldset">
                                        <legend id="legend5" >L'événement se trouve-t-il proche d'une galaxie ?</legend>
                                        <input name="rp5" id="rp50" value="005 QS" type="radio">
                                        <label id="rp5.0" for="rp50">OUI</label>
                                        <input name="rp5" id="rp51" value="005 QS" type="radio">
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
                                        <legend id="legend6" >L'événement a-t'il un aspect stellaire ?</legend>
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
                                        <legend id="legend7" >L'événement montre-t'il des variations de lumière évidentes ?</legend>
                                        <input name="rp7" id="rp70" value="007 QS" type="radio">
                                        <label id="rp7.0" for="rp70">OUI</label>
                                        <input name="rp7" id="rp71" value="007 Q71" type="radio">
                                        <label id="rp7.1" for="rp71">NON</label>            
                                    </fieldset>
                                </form>
                            </div>
                        </div>
                        <div id="Q71" value="071" style="display:none;" >
                            <div data-role="collapsible" data-collapsed="false">
                                <h3><span id="rp71">Question 7.1</span></h3>
                                <form>
                                    <fieldset id="fieldset71" data-role="controlgroup" class="fieldset">
                                        <legend id="legend71">Estimer l'éclat</legend>
                                        <input name="rp71" id="rp710" value="071 QF" type="radio">
                                        <label id="rp71.0" for="rp710">Fort</label>
                                        <input name="rp71" id="rp711" value="071 QF" type="radio">
                                        <label id="rp71.1" for="rp711">Moyen</label>     
                                        <input name="rp71" id="rp712" value="071 QF" type="radio">
                                        <label id="rp71.2" for="rp712">Faible</label>  
                                    </fieldset>
                                </form>
                            </div>
                        </div>
                        <div id="Q8" value="08" style="display:none;" >
                            <div data-role="collapsible" data-collapsed="false">
                                <h3><span id="rp8">Question 8</span></h3>
                                <form>
                                    <fieldset id="fieldset8" data-role="controlgroup" class="fieldset">
                                        <legend id="legend8">L'événement est-il visible sur toutes les images ?</legend>
                                        <input name="rp8" id="rp80" value="008 QS" type="radio">
                                        <label id="rp8.0" for="rp80">OUI</label>
                                        <input name="rp8" id="rp81" value="008 Q81" type="radio">
                                        <label id="rp8.1" for="rp81">NON</label>            
                                    </fieldset>
                                </form>
                            </div>
                        </div>
                        <div id="Q9" value="09" style="display:none;" >
                            <div data-role="collapsible" data-collapsed="false">
                                <h3><span id="rp9">Question 9</span></h3>
                                <form>
                                    <fieldset id="fieldset9" data-role="controlgroup" class="fieldset">
                                        <legend id="legend9" >Les variation de lumière présentent-elles un seul maximum d'éclat ?</legend>
                                        <input name="rp9" id="rp90" value="009 QS" type="radio">
                                        <label id="rp9.0" for="rp90">OUI</label>
                                        <input name="rp9" id="rp91" value="009 Q91" type="radio">
                                        <label id="rp9.1" for="rp91">NON</label>            
                                    </fieldset>
                                </form>
                            </div>
                        </div>
                        <div id="Q91" value="091" style="display:none;" >
                            <div data-role="collapsible" data-collapsed="false">
                                <h3><span id="rp91">Question 9.1</span></h3>
                                <form>
                                    <fieldset id="fieldset91" data-role="controlgroup" class="fieldset">
                                        <legend id="legend91">Estimer l'éclat maximum ?</legend>
                                        <input name="rp91" id="rp910" value="091 Q91" type="radio">
                                        <label id="rp91.0" for="rp910">Fort</label>
                                        <input name="rp91" id="rp911" value="091 Q91" type="radio">
                                        <label id="rp91.1" for="rp911">Moyen</label>   
                                        <input name="rp91" id="rp912" value="091 Q91" type="radio">
                                        <label id="rp91.2" for="rp912">Faible</label>  
                                    </fieldset>
                                </form>
                            </div>
                        </div>
                        <div id="Q92" value="092" style="display:none;" >
                            <div data-role="collapsible" data-collapsed="false">
                                <h3><span id="rp92">Question 9.2</span></h3>
                                <form>
                                    <fieldset id="fieldset92" data-role="controlgroup" class="fieldset">
                                        <legend id="legend92">Estimer l'éclat Minimum ?</legend>
                                        <input name="rp92" id="rp920" value="092 Q91" type="radio">
                                        <label id="rp92.0" for="rp920">Fort</label>
                                        <input name="rp92" id="rp921" value="092 Q91" type="radio">
                                        <label id="rp92.1" for="rp921">Moyen</label>   
                                        <input name="rp92" id="rp922" value="092 Q91" type="radio">
                                        <label id="rp92.2" for="rp922">Faible</label>  
                                    </fieldset>
                                </form>
                            </div>
                        </div>
                        <div id="Q93" value="093" style="display:none;" >
                            <div data-role="collapsible" data-collapsed="false">
                                <h3><span id="rp93">Question 9.3</span></h3>
                                <form>
                                    <fieldset id="fieldset93" data-role="controlgroup" class="fieldset">
                                        <legend id="legend93">Est-ce une signature d'étoile variable périodique ?</legend>
                                        <input name="rp93" id="rp930" value="093 QF" type="radio">
                                        <label id="rp93.0" for="rp930">OUI</label>
                                        <input name="rp93" id="rp931" value="093 QF" type="radio">
                                        <label id="rp93.1" for="rp931">NON</label>        
                                        <input name="rp93" id="rp932" value="093 QF" type="radio">
                                        <label id="rp93.2" for="rp932">Je ne sais pas</label>  
                                    </fieldset>
                                </form>
                            </div>
                        </div>
                        <div id="Q10" value="010" style="display:none;" >
                            <div data-role="collapsible" data-collapsed="false">
                                <h3><span id="rp10">Question 10</span></h3>
                                <form>
                                    <fieldset id="fieldset10" data-role="controlgroup" class="fieldset">
                                        <legend id="legend10">Estimer l'éclat maximum ?</legend>
                                        <input name="rp10" id="rp100" value="010 QS" type="radio">
                                        <label id="rp10.0" for="rp100">Fort</label>
                                        <input name="rp10" id="rp101" value="010 QS" type="radio">
                                        <label id="rp10.1" for="rp101">Moyen</label>        
                                        <input name="rp10" id="rp102" value="010 QS" type="radio">
                                        <label id="rp10.2" for="rp102">Faible</label>  
                                    </fieldset>
                                </form>
                            </div>
                        </div>
                        <div id="Q11" value="011" style="display:none;" >
                            <div data-role="collapsible" data-collapsed="false">
                                <h3><span id="rp11">Question 11</span></h3>
                                <form>
                                    <fieldset id="fieldset11" data-role="controlgroup" class="fieldset">
                                        <legend id="legend11">L'éclat ne fait-il que décroître ?</legend>
                                        <input name="rp11" id="rp110" value="011 QS" type="radio">
                                        <label id="rp11.0"for="rp110">OUI</label>
                                        <input name="rp11" id="rp111" value="011 Q111" type="radio">
                                        <label id="rp11.1" for="rp111">NON</label>        
                                    </fieldset>
                                </form>
                            </div>
                        </div>
                        <div id="Q111" value="0111" style="display:none;" >
                            <div data-role="collapsible" data-collapsed="false">
                                <h3><span id="rp111">Question 11.1</span></h3>
                                <form>
                                    <fieldset id="fieldset111" data-role="controlgroup" class="fieldset">
                                        <legend id="legend111" >L'éclat ne fait-il que croître ?</legend>
                                        <input name="rp111" id="rp1110" value="111 Q111" type="radio">
                                        <label id="rp111.0" for="rp1110">OUI</label>
                                        <input name="rp111" id="rp1111" value="111 Q111" type="radio">
                                        <label id="rp111.1" for="rp1111">NON</label>        
                                    </fieldset>
                                </form>
                            </div>
                        </div>
                        <div id="Q12" value="012" style="display:none;" >
                            <div data-role="collapsible" data-collapsed="false">
                                <h3><span id="rp12">Question 12</span></h3>
                                <form>
                                    <fieldset id="fieldset12" data-role="controlgroup" class="fieldset">
                                        <legend id="legend12">La montée d'éclat au maximum se fait-elle en moins de 2 heures</legend>
                                        <input name="rp12" id="rp120" value="012 Q121" type="radio">
                                        <label id="rp12.0" for="rp120">OUI</label>
                                        <input name="rp12" id="rp121" value="012 QS" type="radio">
                                        <label id="rp12.1" for="rp121">NON</label>        
                                    </fieldset>
                                </form>
                            </div>
                        </div>
                        <div id="Q121" value="0121" style="display:none;" >
                            <div data-role="collapsible" data-collapsed="false">
                                <h3><span id="rp121">Question 12.1</span></h3>
                                <form>
                                    <fieldset id="fieldset121" data-role="controlgroup" class="fieldset">
                                        <legend id="legend121">La montée d'éclat au maximum se fait-elle en moins de un jour</legend>
                                        <input name="rp121" id="rp1210" value="121 QFGRB" type="radio">
                                        <label id="rp121.0" for="rp1210">OUI</label>
                                        <input name="rp121" id="rp1211" value="121 QF" type="radio">
                                        <label id="rp121.1" for="rp1211">NON</label>        
                                    </fieldset>
                                </form>
                            </div>
                        </div>
                        <div id="Q13" value="013" style="display:none;" >
                            <div data-role="collapsible" data-collapsed="false">
                                <h3><span id="rp13">Question 13</span></h3>
                                <form>
                                    <fieldset id="fieldset13" data-role="controlgroup" class="fieldset">
                                        <legend id="legend13">La montée d'éclat au maximum se fait-elle en plus de 5 jours</legend>
                                        <input name="rp13" id="rp130" value="013 QFSN" type="radio">
                                        <label id="rp13.0" for="rp130">OUI</label>
                                        <input name="rp13" id="rp131" value="013 QFKN" type="radio">
                                        <label id="rp13.1" for="rp131">NON</label>        
                                    </fieldset>
                                </form>
                            </div>
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
