/* 
    Document    : qualifier.jsp
    Description : Script JavaScript pour la section en mode user de l'application 
        smartphone Utilisé par qualifier.jsp uniquement;
        Source repris, modifié et enrichi à partir du source de snDiscovery
    Created on  : 05 Mai 2014
    Modifie le  : 16 Mars 2017
    Author      : 
*/

/* global imagesNoms, dateCrt */

// --------------- Gestion de la position de l'image ----------------- 
var position = 1;                              // indice courant de l'observation
var img = new Image();                         // image de la candidate
var holdCords = { holdX : -100, holdY : -100}; // position de la candidate
var sendingMail = false;
var timer;
var x = 0;
var images = new Array();

// --------------------- installation des callback ----------------------------
$(function() {
    $("#clicZoom").on("click", popupZoom);
    $("#btnPcdt").on("click", imagePrecedente);
    $("#btnSvt").on("click", imageSuivante);
    $("#btnCandidat").on("click", initCandidat);
    
    $("#mon_canvas").on("tap",  tapHandler);
    $("#mon_canvas").on("vmousedown", vMouseDownHandler);
    
    $("#btnPseudoPerduOK").on("click", dmdPseudoPerdu);
    $("#btnMotDePassePerduOK").on("click", dmdPseudoPerdu);
    $("#popupCandidat").on("popupafterclose", popupSendMail);
    $("#popupPseudoPerdu").on("popupafterclose", popupSendPseudo);
    $("#popupMotDePassePerdu").on("popupafterclose", popupSendMotDePasse);
    
    $(document).on("pagecontainershow", initImages);
});

// ----------------------------------------------------------------------------
// ------------------  FONCTIONS A REVOIR COMPLETEMENT ------------------------
// ----------------------------------------------------------------------------

function initImages() {
    nouvelleImage(position);
}

function nouvelleDate(dateCrt) {
    // résout le pb d'une app sous IPhone sans sortir de l'app
    position = 1;
    $(location).attr('href',"qualifier.jsp?date=" + dateCrt);
    nouvelleimage(1);
}

// Appui sur le bouton de confirmation d'identification d'un candidat
// il faut d'abord vérifié que le user a pointé l'endroit repéré



/* création d'une nouvelle candidate */
function initCandidat() {
    initCanvas();
    var imgNom = imagesNoms[position-1];
    var nom = imgNom.substring(4, imgNom.length);
    $("#nomCandidat").text(nom);
    // On ne peut pas valider tant que la position n'est pas pointée
    $("#btnConfirmCandidat").hide();
}

/* init de la popup de zoom de la vidéo */
function popupZoom() {
    var imgNom = imagesNoms[position-1];
    var chemin = (imgNom.charAt(0) === 'F') ? cheminCalern : cheminChili;
    var nom = imgNom.substring(4, imgNom.length);
    images[0] = chemin + nom + ".jpg";
    $("#video").attr('src', images[0]);
}


function initCanvas() {
    // il n'y en a qu'un, mais jQuery nécessite de prendre le 1er élément ds ce cas
    var canvas = $("#mon_canvas")[0];
    // Contexte de dessin 2D du canvas
    var ctx = canvas.getContext("2d");
    var imgNom = imagesNoms[position-1];
    var chemin = (imgNom.charAt(0) === 'F') ? cheminCalern : cheminChili;
    var nom = imgNom.substring(4, imgNom.length);
    img.src = chemin + nom + ".jpg";
    // l'image est déjà chargée
    ctx.drawImage(img, 0, 0, 77, 77, 0, 0, canvas.width, canvas.height);
}

function imageSuivante() {
    position = suivant();
    nouvelleImage(position);
}


function imagePrecedente() {
    position = precedent();
    nouvelleImage(position);
}

function nouvelleImage(pos) {
    // A refaire
}
// ----------------------------------------------------------------------------
// ----------------------------------------------------------------------------
 

// sur un tap on dessine autour un carré
function tapHandler(event) {
    // il n'y en a qu'un, mais jQuery nécessite de prendre le 1er élément ds ce cas
    var canvas = $("#mon_canvas")[0];
    // Contexte de dessin 2D du canvas
    var ctx = canvas.getContext("2d");
    // on efface l'ancienne image
    ctx.clearRect(0, 0, canvas.width, canvas.height);
    // on redessine l'image
    ctx.drawImage(img, 0, 0, 77, 77, 0, 0, canvas.width, canvas.height);
    // dessine un carré autour du tap
    ctx.beginPath();
    ctx.strokeStyle="LightCyan";
    ctx.rect(holdCords.holdX - 30, holdCords.holdY - 30, 60, 60);
    ctx.stroke();
    // Maintenant on peut valider la découverte !!!
    $("#btnConfirmCandidat").show();
}

// permet de conserver les coordonnées du tap 
// par rapport à l'origine du canvas
function vMouseDownHandler(event) {
    // offset du canvas par rapport à la page
    var canvasOffset = $("#mon_canvas").offset();
    var offsetX = canvasOffset.left;
    var offsetY = canvasOffset.top;
    holdCords.holdX = parseInt(event.pageX - offsetX);
    holdCords.holdY = parseInt(event.pageY - offsetY);
};

function clearArray(tab) {
    while(tab.length > 0) {
        tab.pop();
    }
}

function precedent() {
    return offset(-1);
}

function suivant() {
    return offset(1);
}

// _offset entre 1 et size()
function offset(_offset) {
    newPosition = position + _offset;
    if (newPosition <= 0)
        newPosition = 1;
    else if (newPosition > imagesNoms.length)
        newPosition = imagesNoms.length;
    return newPosition;
}

function setCharAt(str,index,chr) {
    if(index > str.length-1) return str;
    return str.substr(0,index) + chr + str.substr(index+1);
}


function popupSendMail() {
    if (sendingMail) {
        sendingMail = false;
        $('#popupSendMail').popup('open');
    }
}

function popupSendPseudo() {
    if ($('#formPseudoPerdu').valid() && sendingMail) {
        sendingMail = false;
        setTimeout(function () {
            $("#popupSendPseudo").popup("open");
        }, 100);
    }
}

function popupSendMotDePasse() {
    if ($('#formMotDePassePerdu').valid() && sendingMail) {
        sendingMail = false;
        setTimeout(function () {
            $("#popupSendMotDePasse").popup("open");
        }, 100);
    }
}

// Appui sur le bouton de demande de pseudo
function dmdPseudoPerdu() {
    var pseudoPerduEMail = $("#pseudoPerduEMail").val();
    
    sendingMail = true;
    $.ajax({
        url  : 'eventSkyTracker.jsp?action=pseudoPerduEMail',
        type : 'POST',
        data : 'pseudoPerduEMail=' + pseudoPerduEMail,
        dataType : 'html',
        success: function(data) {
            $('.progressBar').hide();
            $('#popupSendPseudo').popup( "option", "dismissible", true );
            // résout un bug de popup sans sortir de l'app
            $(location).attr('href',"msgQualifier.jsp?msg=" + data);
        },
        error : function(resultat, statut, erreur) {
            $('.progressBar').hide();
            $('#popupTextSendPseudo').text("Impossible de vous envoyer votre pseudo !");
            $('#popupSendPseudo').popup( "option", "dismissible", true );
            return false;
        }
    });
}
