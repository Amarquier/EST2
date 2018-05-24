<%-- 
    Document   : index 
    Description  : page accueil  
    Created on : 5 février 2017
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Acceuil</title> 
        <%@ include file="/includes/head.jspf" %> 
    </head>
    <body>
        <div data-role="page" id="page1">
            <div class="header" data-role="header" data-id="main-header" data-tap-toggle="false" 
                 data-theme="a" data-position="fixed" data-fullscreen="true">
                <h1>Accueil</h1>
                <%@include file="includes/session.jspf" %>
                <%@include file="includes/user.jspf" %>
            </div>
            <div role="main" class="ui-content">

                <br/><br/>
                <h4>Cette application de science participative (crowdsourcing science) va  
                    vous permettre de découvrir des évènements liées à des phénomènes cataclysmique.</h4>
                <center><div class="mesImages">
                        <img style="border-radius: 8px;  " 
                             src="images/accueil.jpg"/>           
                    </div></center>
                <br/>
                <p>Vous allez découvrir des ondes gravitationnelles,et ainsi aider les chercheurs par votre perspicacité.</p>
                <p>Si c’est la première fois que vous venez nous voir, il faudra d’abord suivre le tutoriel, afin de comprendre ce qu’est une supernova, une onde gravitationnelle et le but de ce site.A la fin du tutoriel, vous passerez une petite évaluation qui vous permettra de vous inscrire si vous réussissez.</p>
                <p>Mais même sans vous inscrire vous pouvez jouer au scientifique .</p>
                <p>Si vous découvrez des supernovas ou des ondes gravitationnelles, vous serez mondialement connu.</p>
                <br/>
                <p>AIDE :</p>
                <ol>
                    <li>En tournant votre téléphone à l'horizontale, l'observation des images sera plus facile.</li>
                    <li>Pour cacher la barre de navigation du navigateur :<br/>
                        <ul>
                            <li>Sur IPhone, mettre un signet (bookmark) de ce site sur le bureau.</li>
                            <li>Sur Androïd, créer un signet (bookmark) du site, puis créer un
                                raccourci sur l'écran d'accueil par un appui long sur ce signet.</li>
                        </ul>
                    </li>
                </ol>
                <br/>
                <center><br/><br/><br/>
                    <p class="mini">V0.2 - Mai 2018<br/>Développement : BTS SNIR Lycée V. Hugo Colomiers 31
                    </p>
                </center>
            </div>
            <footer>
                <%@ include file="/includes/footer.jspf" %>
            </footer>
        </div>
    </body>
</html>