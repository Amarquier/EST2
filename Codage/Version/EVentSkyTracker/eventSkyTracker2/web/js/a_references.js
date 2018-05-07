/*
 * Script JavaScript pour la section en mode administrateur
 * de l'application smartphone
 * Utilisé par a_references.jsp uniquement
 */

$(function() {
    $("#a_ref_btnValider").on("click", a_ref_valider);
    $("#a_ref_btnRefuser").on("click", a_ref_refuser);
});

function a_ref_valider() {
    $("#a_ref_btnValider").hide();
    var userPseudo = $("#a_ref_pseudo").text();
    var chemin = document.getElementById("a_ref_imgobs").src;
    buf = chemin.split("/");
    telescope = buf[buf.length - 3];
    date = buf[buf.length - 2];
    var nomImage = buf[buf.length - 1];
    chemin = "/jpeg/" + telescope + "/" + date + "/" + nomImage;
    $.ajax({
        url  : 'discovery.jsp?action=a_refValider_req',
        type : 'POST',
        data : 'userPseudo=' + userPseudo + '&chemin=' + chemin,
        dataType : 'html'
    });
    setTimeout(function() {$(location).attr('href',"discovery.jsp?action=a_ref");}, 100);
}

function a_ref_refuser() {
    $("#a_ref_btnRefuser").hide();
    var userPseudo = $("#a_ref_pseudo").text();
    var chemin = document.getElementById("a_ref_imgobs").src;
    buf = chemin.split("/");
    telescope = buf[buf.length - 3];
    date = buf[buf.length - 2];
    var nomImage = buf[buf.length - 1];
    chemin = "/jpeg/" + telescope + "/" + date + "/" + nomImage;
    $.ajax({
        url  : 'discovery.jsp?action=a_refRefuser_req',
        type : 'POST',
        data : 'userPseudo=' + userPseudo + '&chemin=' + chemin,
        dataType : 'html'
    });
    setTimeout(function() {$(location).attr('href',"discovery.jsp?action=a_ref");}, 100);
}

function popupSendMail() {
    if (sendingMail) {
        sendingMail = false;
        $('#popupSendMail').popup('open');
    }
}