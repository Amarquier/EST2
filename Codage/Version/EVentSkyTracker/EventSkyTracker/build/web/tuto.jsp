<%-- 
    Document    : tuto.jsp
    Description : Redirige la page tutoriel
    Created on  : 21 Mars 2017
--%>

<
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Tutoriel</title> 
        <%@include file="/includes/head.jspf" %>
    </head>
    <style>
        table
        {

            border-collapse: collapse;

        }

        td, th 
        {

            border: 1px solid black;

        }
    </style>

    <script>
        function tutoSuivant(num) {
            $.mobile.changePage("#tutoPage" + num);
        }
    </script>
    <body>
        <%-------------------------------------------------------------------------------------------------------------------
                                                            Page 1
        -------------------------------------------------------------------------------------------------------------------%>
        <link type="text/css" rel="stylesheet" href="css/images.css" />
        <div data-role="page" id="tutoPage1"> 

            <script type="text/javascript" src="js/tuto.js"></script> 
            <%@include file="includes/session.jspf" %>
            <%@ include file="/includes/tutoheader.jspf" %> 
           



            <div data-role="content">
                <br/><br/>
                <h3>La vie des étoiles</h3>
                <p>Si, par une belle nuit étoilée, nous regardons certaines régions du ciel, nous pouvons distinguer une grande variété de couleurs : des milliers d’étoiles de luminosités différentes.
                    D’où vient cette énergie émise en partie sous forme de lumière ? </p>            
                <center><div class="mesImages">
                        <img style="border-radius: 8px;  " 
                             src="images/tuto1.png"/> 
                        <p>Source : blogs.futura-sciences.com</p>
                    </div></center>
                <br/>
                <p>Depuis la découverte de la relativité restreinte par Einstein, les astronomes ont expliqué le processus utilisé dans les étoiles pour produire leur énergie : elles transforment l’hydrogène en hélium. 
                </p>
                <p>Cette nucléosynthèse est accompagnée d’une perte de masse qui correspond, selon la formule E=MC², à l’énergie produite. Cette réaction fait que l’étoile évolue et, a donc un début et une fin. </p>

                
                <div class="ui-grid-a">
                    <div class= "ui-block-a"></div>
                    <div class="ui-block-b">
                        <a id="btnPageSvt1" class="ui-btn"data-icon="arrow-r" data-iconpos="right" data-role="button">Page Suivante </a> 
                    </div>
                </div>
                <br/> <br/>
            </div>
            <br><br>
            <footer>
                <%@ include file="/includes/footer.jspf" %>
            </footer>
        </div>




        <%-------------------------------------------------------------------------------------------------------------------
                                                            Page 2
        -------------------------------------------------------------------------------------------------------------------%>

        <div data-role="page" id="tutoPage2">

            <div>

                <div class="header" data-role="header" data-id="main-header" data-tap-toggle="false" 
                     data-theme="a" data-position="fixed" data-fullscreen="true">
                    <h1>Tutoriel</h1>
                    <!-- un include dans un include : on ne peut pas utiliser @include -->
                </div>
            </div>
           

            <div data-role="content">
                <br/><br/>
                <h3>1- Naissance d’une étoile</h3>              
                <p>Des nuages moléculaires géants, des boules de gaz tournant sur elles-mêmes, deviennent, dans certaines situations instables. Cet effondrement gravitationnel peut être du au passage du nuage dans une zone de haute densité de matière, ou provoqué par l’onde de choc associée à une supernova.
                </p>
                <center><div class="mesImages">
                        <img style="width: 400px;"
                             src="images/tuto2.png"/>
                        <p>Fig : formation des étoiles à l’intérieur de la nébuleuse Messier 17 <br/> (http://hubblesite.org/image/1331/news_release/2003-13 )</p>
                    </div></center>
                <p>Au fur et à mesure qu'il s'effondre, le gaz se comprimé et s'échauffe violemment. 
                    Parti d'une température de quelques dizaines de degrés Kelvin, il atteint à un moment la température d'amorçage des réactions thermonucléaires c'est-à-dire, une dizaine de millions de degrés. </p>
                <h3>2- La séquence principale</h3>
                <p>Lorsque la température atteint des dizaines de millions de degrés,  la pression due aux réactions  de fusion de l’hydrogène compense les forces gravitationnelles et l’effondrement s’arrête. C’est le début de la période la plus longue de la vie de l’étoile : la séquence principale. 
                    La longévité de l’étoile sur la séquence principale dépend fortement de la masse de celle-ci et de la vitesse à laquelle elle brûle son combustible. </p>
                <div class="btn">
                    <div class="ui-grid-a">
                        <div class= "ui-block-a">
                            <a id="btnPagePdt2"class="ui-btn"data-icon="arrow-r" data-iconpos="right" data-role="button">Page Précédent </a> 
                        </div>
                        <div class="ui-block-b">
                            <a id="btnPageSvt2" class="ui-btn"data-icon="arrow-r" data-iconpos="right" data-role="button">Page Suivante </a> 
                        </div>
                    </div>
                </div> 
            </div> 
            <br/><br/><br/><br/>
            <footer>
                <%@ include file="/includes/footer.jspf" %>
            </footer>
        </div>

        <%-------------------------------------------------------------------------------------------------------------------
                                                            Page 3
        -------------------------------------------------------------------------------------------------------------------%>

        <div data-role="page" id="tutoPage3">
            <div>

                <div class="header" data-role="header" data-id="main-header" data-tap-toggle="false" 
                     data-theme="a" data-position="fixed" data-fullscreen="true">
                    <h1>Tutoriel</h1>
                    <!-- un include dans un include : on ne peut pas utiliser @include -->
                </div>
            </div>
            <div data-role="content">
                <br/><br/>
                <h3>3- La fin de vie des étoiles</h3>
                <p>Lorsque l’hydrogène est épuisé, l’étoile quitte la séquence principale. Arrivée à la fin de leur vie, les étoiles n'ont pas toutes le même destin.<br/> 
                    Là aussi, tout dépend de leur masse.   Pour les moins massives, leur mort sera relativement calme: elles s'éteindront après avoir expulsé petit à petit leurs couches externes, laissant derrière une naine blanche. En revanche, pour les plus massives (au-delà de 8 masses solaires) leur mort ne sera pas de tout repos: elles finiront leur vie dans une explosion cataclysmique. </p>
                <h3>3-1 Explosion d’une étoile isolée massive ( masse supérieure à 8 masses solaires)</h3>
                <p>Dès que  toute la quantité d’hydrogène d’une étoile a été transformée en hélium, les réactions nucléaires à l’intérieur de son cœur s’arrêtent. Seule la force gravitationnelle subsiste.  L’étoile s’effondre sous son poids. Suite à cette implosion, un cœur de neutrons se forme, l’effondrement gravitationnel s’arrête et les couches supérieures de l’étoile explosent : on parle <B> d’une supernova à effondrement de cœur.</B>  </p>
                <center><div class="mesImages">
                        <img style="width: 400px;"
                             src="images/tuto3.png"/>                       
                    </div></center>
                <p>Après un flash de quelques minutes, la supernova aura un éclat maximum au bout de  10 jours, mais elle restera visible presque 3 mois.</p>
                <p>Pour des étoiles encore plus massives, de masses supérieures à 40 masses solaires, la fin est encore plus spectaculaire. L’explosion génère un <B> sursaut gamma long.</B> </p>
                <center><div class="mesImages">
                        <img style="width: 200px;"
                             src="images/tuto4.png"/>                       
                    </div></center>
                <p>Tout à l’air de se dérouler très rapidement : l’étoile émet des jets de matière ultra relativistes qui vont modifier l’espace-temps. La contraction du temps autour de ces jets  permettra l’observation de l’éclat maximum entre quelques secondes et 20 minutes. Le phénomène est tellement brillant qu’il peut être comparé à l’éclat de 4000 Galaxies ! Un sursaut gamma long n’est observable qu’une semaine. Il laisse  derrière lui un trou noir. </p>
                <div class="btn">
                    <div class="ui-grid-a">
                        <div class= "ui-block-a">
                            <a id="btnPagePdt3"class="ui-btn"data-icon="arrow-r" data-iconpos="right" data-role="button">Page Précédent </a> 
                        </div>
                        <div class="ui-block-b">
                            <a id="btnPageSvt3" class="ui-btn"data-icon="arrow-r" data-iconpos="right" data-role="button">Page Suivante </a> 
                        </div>
                    </div>
                </div> 
            </div> 
            <br/><br/><br/><br/>
            <footer>
                <%@ include file="/includes/footer.jspf" %>
            </footer>
        </div>   



        <%-------------------------------------------------------------------------------------------------------------------
                                                Page 4
        -------------------------------------------------------------------------------------------------------------------%>

        <div data-role="page" id="tutoPage4">
            <div>

                <div class="header" data-role="header" data-id="main-header" data-tap-toggle="false" 
                     data-theme="a" data-position="fixed" data-fullscreen="true">
                    <h1>Tutoriel</h1>
                    <!-- un include dans un include : on ne peut pas utiliser @include -->
                </div>
            </div>
            
            <div data-role="content">
                <br/><br/>
                <h3>3-2 Explosion d’un couple d’étoiles</h3>
                <p>Il arrive que l’étoile massive fasse partie d’un couple d’étoiles. On l’appelle aussi système binaire : deux étoiles orbitent autour d’un centre de gravité commun.</p>
                <center><div class="mesImages">
                        <img style="width: 300px;"
                             src="images/tuto5.gif"/>                       
                    </div></center>
                <p>Une étoile en fin de vie absorbe la matière de la seconde étoile du système binaire.</p>
                <center><div class="mesImages">
                        <img style="width: 300px;"
                             src="images/tuto6.png"/>                      
                    </div></center>
                <p>Cet échange provoque l’allumage des réactions nucléaires en surface et l’étoile explose dans sa totalité, produisant une <b>supernova thermonucléaire.</b>Le phénomène atteint son éclat maximum en 15 jours et est observable pendant 3 mois.  </p>
                <p>Si les orbites des deux étoiles sont serrées, la relativité générale prédit une fusion de celles-ci accompagnée d’une émission d’ondes gravitationnelles.  Comme dans le cas des étoiles très massives,  le système va émettre des jets ultra relativistes. Le phénomène est connu sous le nom de <Bsursaut gamma court. La contraction relativiste du temps autour des jets fait que l’éclat maximum soit observable au bout de 10 secondes au maximum. Le phénomène sera observable seulement 1 semaine.  </p>
                    <center><div class="mesImages">
                            <img style="width: 300px;"
                                 src="images/tuto7.png"/>                      
                        </div></center>
                    <br/>
                    <div class="btn">
                        <div class="ui-grid-a">
                            <div class= "ui-block-a">
                                <a id="btnPagePdt4"class="ui-btn"data-icon="arrow-r" data-iconpos="right" data-role="button">Page Précédent </a> 
                            </div>
                            <div class="ui-block-b">
                                <a id="btnPageSvt4" class="ui-btn"data-icon="arrow-r" data-iconpos="right" data-role="button">Page Suivante </a> 
                            </div>
                        </div>
                    </div> 
            </div> 
            <br/><br/><br/><br/>
            <footer>
                <%@ include file="/includes/footer.jspf" %>
            </footer>
        </div>  




        <%-------------------------------------------------------------------------------------------------------------------
                                                Page 5
        -------------------------------------------------------------------------------------------------------------------%>

        <div data-role="page" id="tutoPage5">
            <div>
                <link type="text/css" rel="stylesheet" href="css/images.css" />
                <div class="header" data-role="header" data-id="main-header" data-tap-toggle="false" 
                     data-theme="a" data-position="fixed" data-fullscreen="true">
                    <h1>Tutoriel</h1>
                    
                    <!-- un include dans un include : on ne peut pas utiliser @include -->
                </div>
            </div>
            
            <div data-role="content">
                <br/><br/>
                <h3>En résumé</h3>
                <table>
                    <tr>
                        <td>       </td>
                        <td><B>Étoile unique</B> </td>
                        <td><B>Couple d’étoiles</B> </td>
                    <tr/>            

                    <tr>
                        <td><B>Masse modérée</B></td>
                        <td><FONT color="blue"><B>Supernova à effondrement de cœur</B></FONT> <br/>
                            Masse 8 à 40 masses solaires<br/>
                            Éclat absolu ~ 0,5 Galaxies<br/>
                            Éclat maximum ~ 10 jours + flash<br/>
                            Observation ~ 3 mois<br/>
                            Résidu : étoile à neutron<br/>
                            Découverte : surveys optiques</td>
                        <td><B><FONT color="blue">Supernova thermonucléaires</B></FONT><br/>
                            Masse 3 à 8 masses solaires<br/>
                            Éclat absolu ~ 2 Galaxies<br/>
                            Éclat maximum ~ 15 jours<br/>
                            Observation ~ 3 mois<br/> 
                            Résidu : aucun<br/>
                            Découverte : surveys optiques</td> 
                    <tr/>

                    <tr>
                        <td><B>Grande masse</B></td>
                        <td><FONT color="blue"><B>Sursaut gamma long</B></FONT> <br/>
                            Masse > 40 masses solaires<br/>
                            Éclat absolu ~ 4000 Galaxies<br/>
                            Éclat maximum ~ 0 à 20 minutes<br/>
                            Observation ~ 1 semaine<br/>  
                            Résidu : Trou noir<br/>
                            Découverte : Satellites gamma<br/>
                        <td><FONT color="blue"><B>Sursaut gamma court</B></FONT> <br/>
                            Masse ~ quelques masses solaires<br/>
                            Éclat absolu ~ 300 Galaxies<br/>
                            Éclat maximum < 10 secondes<br/>
                            Observation ~ 1 semaine<br/>
                            Résidu : Trou noir<br/>
                            Découverte : Satellites gamma<br/>
                    <tr/>
                </table>
                <br/><br/>
                <div class="btn">
                    <div class="ui-grid-a">
                        <div class= "ui-block-a">
                            <a id="btnPagePdt5"class="ui-btn"data-icon="arrow-r" data-iconpos="right" data-role="button">Page Précédent </a> 
                        </div>
                        <div class="ui-block-b">
                            <a href="evaluation.jsp"class="ui-btn"data-icon="arrow-r" data-iconpos="right" data-role="button" data-ajax="false">Evaluation </a> 
                        </div>
                    </div>
                </div> 
            </div> 
            <br><br><br>
            <footer>
                <%@ include file="/includes/footer.jspf" %>
            </footer>
        </div>  
    </body>
</html>

