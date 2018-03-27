/*
 * Script a_candadates.js pour la section en mode user
 * de l'application smartphone
 * Utilisé par disco.jsp uniquement
 */

// --------------------- callback ----------------------- 

$(function() {
    resizecanvas();
    $(window).on("resize", resizecanvas);
    $("#btnInfos").on("click", afficheInfos);
    $("#btnHisto").on("click", afficheHisto);
});

// --------------------- Gestion des infos ---------------------------
function afficheInfos() {
    var nom = $("#nomGalaxie").text();
    $("#nomInfos").text("Nom : " + nom);
    
    $.ajax({
        url  : 'infosGalaxie_req.jsp',
        type : 'POST',
        data : 'nom=' + nom,
        success: function(data) {
            var tabInfos = data.split("|");
            $("#catInfos").text("Catégorie: " + tabInfos[1]);
            $("#textInfos").text("Informations: " + tabInfos[2]);
            $("#nbNovInfos").text("Supernovae découvertes: " + tabInfos[3]);
            $("#adrInfos").text("Ascension droite (degré): " + tabInfos[4]);
            $("#decInfos").text("Déclinaison (degré): " + tabInfos[5]);
            // conversion de méga parsec en million d'année lumière
            $("#distInfos").text("Distance (mal): " + 3.2616*tabInfos[6]);
            $("#magInfos").text("Magnitude: " + tabInfos[7]);
        },
        error : function(resultat, statut, erreur) {
            alert("Impossible de récupérer les infos.\n Msg: " + erreur);
        }
    });
}

// ------------------ Gestion de l'historique ------------------------
function afficheHisto() {
    var nom = $("#nomGalaxie").text();
    $("#nomInfos").text("Nom : " + nom);
    
    $.ajax({
        url  : 'lastImg_req.jsp',
        type : 'POST',
        data : 'nom=' + nom,
        success: function(data) {
            var tabInfos = data.split("|");
            var codeHTML = "<div>";
            src = new Array("images/pasImageCeJour.jpg", "images/pasImageCeJour.jpg",
                            "images/pasImageCeJour.jpg", "images/pasImageCeJour.jpg",
                            "images/pasImageCeJour.jpg", "images/pasImageCeJour.jpg");
            for (i = 0; i < tabInfos.length; i++) {
                var info = tabInfos[i].replace(/\s/g,"");
                var leChemin = (info.charAt(0) === 'F') ? "/jpeg/Tarot_Calern/" : "/jpeg/Tarot_Chili/";
                var laDate = info.substring(1, info.length);
                
                str = leChemin + laDate + "/" + nom + ".jpg";
                src[i] = str;
            }
            
            for (i = 0; i < src.length; i++) {
                codeHTML += "<img src='" + src[i] + "'/>";
            }
            codeHTML += "</div>";
            $("#imgHisto").html(codeHTML);
        },
        error : function(resultat, statut, erreur) {
            alert("Impossible de récupérer les infos");
        }
    });
}

function resizecanvas() {
    var nom = $("#nomGalaxie").text();
    
    var c = document.getElementById("canvasObs");
    // Initialise la taille du canvas en fonction de la taille de l'image
    c.attr('width',  cWidth); //max width
    c.attr('height', cHeight); //max height
    // Récupere les coordonnées du carré
    var cX = document.getElementById("cX").value;
    var cY = document.getElementById("cY").value;
    // Traitement
    cX = cWidth * cX;
    cX = cX / 256;                        
    cY = cWidth * cY;
    cY = cY / 256;
    var t = cWidth * 60;
    t= t / 256;
    var moins = cWidth * 30;
    moins = moins / 256;
    // Dessine le carré
    // il n'y en a qu'un, mais jQuery nécessite de prendre le 1er élément ds ce cas
    var canvas = $("#canvasObs")[0];
    // Contexte de dessin 2D du canvas
    var ctx = canvas.getContext("2d");
    
    ctx.strokeStyle="LightCyan";
    ctx.rect(cX - moins, cY - moins, t, t);
    ctx.stroke();
}

function popupSendMail() {
    if (sendingMail) {
        sendingMail = false;
        $('#popupSendMail').popup('open');
    }
}

function imageSuivante() {
    position = suivant();
    nouvelleImage(position);
}

function imagePrecedente() {
    position = precedent();
    nouvelleImage(position);
}

