
// ---------------------------------------------------------------------------
// Variables globales
// 
// Fonctionne quelque soit le nbr d'images de 1 à N
// Mais ne pas garder les candidates avec une seule image
// Cas sans intêret
// ---------------------------------------------------------------------------
// les images sous la forme d'un tableau
var images = new Array;

// faire une requête Ajax qui récupère une string tel que :
//  Donne moi la liste des images avec leurs délais depuis l'évènement 
//    d'un candidat donné. (Navigation par candidat et pr evenement)
//  "tuto100 3 tuto101 19 tuto102 200 ..."
//  pour la transformer en 2 tableaux.
//  
// le nom des images à visualiser
var nomImages = ["tuto100", "tuto101", "tuto102", "tuto103", "tuto104", "tuto105", "tuto106"];
// les délais en minutes à partir de l'évènement initial (peut atteindre plusieurs jours)
var delais = [3, 19, 200, 400, 500, 800, 1000];
var nbImages = nomImages.length;

// ---------------------------------------------------------------------------
// fonction exécutée à la fin du chargement de la page
// ---------------------------------------------------------------------------
$(function() {
    init();
    $("#sliderVideo").on("change", slideChange);
    $(window).on("resize", drawReferences);
    $("#btnPcdt").on("click", imagePcdt);
    $("#btnSvt").on("click", imageSvt);
});

// ---------------------------------------------------------------------------
// fonction d'initialisation
// ---------------------------------------------------------------------------
function init() {
    chargerImages();
    if (nomImages.length >= 2) {
        $("#btnSvt").removeClass("ui-state-disabled");
    }
}

// ---------------------------------------------------------------------------
// fonction exécutée à l'appui sur le bouton 'précédent'
// ---------------------------------------------------------------------------
function imagePcdt() {
    var pos = $("#sliderVideo").val();
    
    // dans quel invervalle suis-je (entre 0 à nomImages.length - 2) ?
    var intervalle = intervalleCrt(pos);
    
    if (pos > delais[intervalle]) {
        $("#sliderVideo").val(delais[intervalle]);
    }
    else {
        $("#sliderVideo").val(delais[intervalle - 1]);
    }
    $("#sliderVideo").slider("refresh");
    slideChange();
}

// ---------------------------------------------------------------------------
// fonction exécutée à l'appui sur le bouton 'suivant'
// ---------------------------------------------------------------------------
function imageSvt() {
    var pos = $("#sliderVideo").val();
    
    // dans quel invervalle suis-je (entre 0 à nomImages.length - 2) ?
    var intervalle = intervalleCrt(pos);
    
    if (pos < delais[intervalle + 1]) {
        $("#sliderVideo").val(delais[intervalle + 1]);
    }
    else {
        $("#sliderVideo").val(delais[intervalle + 2]);
    }
    
    $("#sliderVideo").slider("refresh");
    slideChange();
}

// ---------------------------------------------------------------------------
// fonction ui trace la règle des positions des images 
// à chaque redimensionnement de la page 
// et au chargement de nouvelles images
// ---------------------------------------------------------------------------
function drawReferences() {
    // mettre à jour la règle des positions des images
    var canvas = document.getElementById("regle");  //$("#regle") pose pb !
    var context = canvas.getContext('2d');
    var lgCurseur = 32;  // taille du curseur du slider en px
    
    // on adapte la longueur du canvas à la longueur du slider (90%)
    canvas.width = 0.90*window.innerWidth;
    
    var delaiTotal = delais[nomImages.length - 1] - delais[0];
    // on doit commencer et ficnir au centre du curseur
    var echelle = (canvas.width - lgCurseur)/delaiTotal;
    // on trace les références
    context.beginPath();
    context.lineWidth = '2';
    for (var i = 0; i < nomImages.length; i++) {
        context.moveTo(lgCurseur/2 + (delais[i] - delais[0])*echelle,0);
        context.lineTo(lgCurseur/2 + (delais[i] - delais[0])*echelle,20);
    }
    context.stroke();
}

// ---------------------------------------------------------------------------
// Charge les nouvelles images pour faire la vidéo 
// utilise les variables globales : images, nomImages, delais
// ---------------------------------------------------------------------------
function chargerImages() {
    // supprimer d'abord les anciennes images
    var video = $('#video');
    video.empty();
    
    // on bloque les boutons
    $("#btnPcdt").addClass("ui-state-disabled");
    $("#btnSvt").addClass("ui-state-disabled");
    
    // on vide le tableau des images en le remplaçant par un nouveau tableau
    images = new Array;
    
    for (var i = 0; i < nomImages.length; i++) {
        // affichage des images reçues dans la vidéo à afficher
        // utilisation des ' et " pour l'HTML
        $('<img id="img' + i + '" src="images/' + nomImages[i] + '.jpg" align="center"/>').appendTo(video);
        // mettre les zIndex comme il faut (jusqu'à 1000 images !)
        // la zIndex la plus forte est devant (une zIndex négative ne se voit pas)
        // la position doit être absolue pour que les images se superposent
        $("#img" + i).css({zIndex: 1000 - i});
    }

    // changer les valeurs initiales du slide en fonction des délais min, max
    var slider = $("#sliderVideo");

    slider.attr("max", delais[nomImages.length - 1]);
    slider.attr("min", delais[0]);
    slider.val(delais[0]);
    // rafraichir le slider avec les nouveaux paramètres
    slider.slider("refresh");
    
    drawReferences();
    
    $("#sliderDelai").text($("#sliderVideo").val() + " mn");

    // y a t'il un suivant (validation du bouton 'suivant')
    if (nomImages.length >= 2) {
        $("#btnSvt").removeClass("ui-state-disabled");
    }
}

// ---------------------------------------------------------------------------
// Appelé quand le curseur est déplacé
// poiur mettre à jour l'opacité des images et les boutons 
// ---------------------------------------------------------------------------
function slideChange() {
    var pos = $("#sliderVideo").val();
    
    $("#sliderDelai").text(pos + " mn");
    
    // dans quel invervalle suis-je (entre 0 à nomImages.length - 2) ?
    var intervalle = intervalleCrt(pos);
    
    // On init les images en opacité, car on peut se déplacer sans slider

    // les images avant l'intervalle courant sont transparentes
    for (var i = 0; i < intervalle; i++) {
        // $("#img" + i) ne marche pas ???
        document.getElementById("img" + i).style.opacity = 0.0;
    }
    
    // les images après l'intervalle courant sont opaques
    // celle à droite de l'intervalle comprise
    for (var i = intervalle + 1; i < nomImages.length; i++) {
        document.getElementById("img" + i).style.opacity = 1.0;
    }
    
    // je suis entre les images intervalle et intervalle + 1
    // durée en minutes entre ces deux images
    var duree = delais[intervalle + 1] - delais[intervalle];
    // duree en minutes entre le curseur et l'image de gauche
    var delta = pos - delais[intervalle];
    
    // réglage de l'opacité de l'image de gauche entre 0 et 1.0,
    // l'autre est à 1.0 (100%)
    document.getElementById("img" + intervalle).style.opacity = 1.0 - delta/duree;
    majBoutons(pos);
}

// ---------------------------------------------------------------------------
// valide ou non les boutons en fonction de la position du curseur
// ---------------------------------------------------------------------------
function majBoutons(pos) {
    if (pos > delais[0])
        $("#btnPcdt").removeClass("ui-state-disabled");
    else
        $("#btnPcdt").addClass("ui-state-disabled");
    if (pos < delais[nomImages.length - 1])
        $("#btnSvt").removeClass("ui-state-disabled");
    else
        $("#btnSvt").addClass("ui-state-disabled");
}

// ---------------------------------------------------------------------------
// retourne le numéro de l'intervalle courant du curseur
// retour : un entier dans [0, nomImages.length - 2]
// ---------------------------------------------------------------------------
function intervalleCrt(pos) {
    var intervalle = 0;
    var i = 1;
    while ((i < nomImages.length - 1) && (pos > delais[i])) {
        intervalle = i;
        i++;
    }
    return intervalle;
}