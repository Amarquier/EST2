var images = new Array();
var nomImages = new Array();
var delais = new Array();
var nbImages = 0;
var cheminImg;
var a = 0;

$(function () {
    
    $("#sliderVideo").on("change", slideChange);
    $(window).on("resize", drawReferences);
    $("#btnPcdt").on("click", imagePcdt);
    $("#btnSvt").on("click", imageSvt);
});

function init() {
    $("#sliderVideo").slider(); 
    chargerImages(); 
    if (nomImages.length >= 2) {
        $("#btnSvt").removeClass("ui-state-disabled");
    }
 
}

/*//cheminImg = chemin;
 cheminImg = "/home/disco/Bureau/EventSkyTracker/Codage/jpeg/";
 //for (var i = 0 ; i <= list.length ; i++)
 //nomImages.add(1,list);
 
 nomImages = delai;
 delais = [200,500,600,700,800,900]
 chargerImages();
 
 */
function remplir(listImage, delai) {
   
    nomImages = listImage;
    nbImages = nomImages.length;
    delais = delai;
    init();
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
    canvas.width = 0.90 * window.innerWidth - 32;


    var delaiTotal = delais[nomImages.length - 1] - delais[0];
    // on doit commencer et ficnir au centre du curseur
    var echelle = (canvas.width - lgCurseur) / delaiTotal;
    // on trace les références
    context.beginPath();
    context.lineWidth = '2';
    for (var i = 0; i < nomImages.length; i++) {
        context.moveTo(lgCurseur / 2 + (delais[i] - delais[0]) * echelle, 0);
        context.lineTo(lgCurseur / 2 + (delais[i] - delais[0]) * echelle, 20);
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
        var test = nomImages[i];
        $('<img id="img' + i + '"src="/jpeg' + nomImages[i] + '.jpg" align="center"/>').appendTo(video);
        // mettre les zIndex comme il faut (jusqu'à 1000 images !)
        // la zIndex la plus forte est devant (une zIndex négative ne se voit pas)
        // la position doit être absolue pour que les images se superposent
        $("#img" + i).css({position: "absolute", zIndex: 1000 - i});
        // on met à jour le tableau des images bug : $("#img" + i) ne marche pas ???
        images[i] = document.getElementById("img" + i);
    }

    // changer les valeurs initiales du slide en fonction des délais min, max
    var slider = $("#sliderVideo");

    slider.attr("max", delais[nomImages.length - 1]);
    slider.attr("min", delais[0]);
    slider.val(delais[0]);
    // rafraichir le slider avec les nouveaux paramètres
    //$("#sliderVideo").slider(); 
    $("#sliderVideo").slider("refresh");
    drawReferences();

    $("#sliderDelai").text($("#sliderVideo").val() + " min");

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

    $("#sliderDelai").text(pos + " min");

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
    document.getElementById("img" + intervalle).style.opacity = 1.0 - delta / duree;
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
    var test = delais[nomImages.length-1];
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
