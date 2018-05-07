var suivant;
var question = 1;

$(function () {
    $("#btnPrec").on("click", precedent);
    $("#btnSuiv").on("click", suivant);
   
});

function suivant() { //Appui bouton suivant
     document.getElementById("btnPrec").disabled = false;
    for (var i = 0; i <= 4; i++) { //Es-que il y à une réponse cochée ?
        if ($("#rp" + question + i).is(':checked')) { //SI OUI
            value = $("#rp" + question + i).val();
            suivant = value.substring(4, 10);
            break;
        }
        else {  //sinon ne rien faire
            suivant = "NP";
        }
    }
    //document.getElementById("text").innerHTML = trame;
    if (suivant !== "NP") {     //Passe à la question suivante 
        if (suivant === "QS") { //Question +1
            //if (question === 9)
                //$('#popupPointerMaxEclat').popup("open"); A faire pour l'année prochaine du projet
            QS();
        }
        if (suivant === "Q21") { // branche annexe question 2.1
            Q21();
        }
        if (suivant === "Q31") { // branche annexe question 3.1
            Q31();
        }
        if (suivant === "Q41") { // branche annexe question 4.1
            Q41();
        }
        if (suivant === "Q71") { // branche annexe question 4.1
            Q71();
        }
        if (suivant === "Q81") { // branche annexe question 4.1
            Q81();
        }
        if (suivant === "Q91") { // branche annexe question 4.1
            Q91();
        }
        if (suivant === "Q111") { // branche annexe question 4.1
            Q111();
        }
        if (suivant === "Q121") { // branche annexe question 4.1
            Q121();
        }
        if (suivant === "QF") { // Questionnaire finit
            QF();
        }
        if (suivant === "QFGRB") { // Questionnaire finit
            QFGRB();
        }
        if (suivant === "QFSN") { // Questionnaire finit
            QFSN();
        }
        if (suivant === "QFKN") { // Questionnaire finit
            QFKN();
        }

    }

    if (question >= 2) // Faire apparaitre bouton Précédent
        document.getElementById("btnPrec").disabled = false;

    else  // Faire disparaitre bouton Précédent
        document.getElementById("btnPrec").disabled = true;

}
function precedent() { //Appui bouton précédent

    if (question === 12) {
        document.getElementById("Q" + question).style.display = 'none';
        if ($("#rp111").is(':checked')) { //SI OUI
            question = 111; //revien question précédente
        }
        else {
            question = 11; //revien question précédente
        }
        if (question === 11) {
            for (var i = 0; i <= 2; i++) {
                $("#rp111" + i).attr('checked', false).checkboxradio("refresh");
                $("#rp111" + i).attr('checked', false).checkboxradio("refresh");
            }
        }
        document.getElementById("Q" + question).style.display = 'block'; //Affiche question précédente
    }
    else {
        if (question === 31) { // Passe de question 3.1 à question 3
            document.getElementById("Q" + question).style.display = 'none';
            question = 4;
        }
        if (question === 41) { // Passe de question 4.1 à question 4
            document.getElementById("Q" + question).style.display = 'none';
            question = 5;
        }
        if (question === 71) { // Passe de question 7.1 à question 7
            document.getElementById("Q" + question).style.display = 'none';
            question = 8;
        }
        if (question === 81) { // Passe de question 7.1 à question 7
            document.getElementById("Q" + question).style.display = 'none';
            question = 9;
        }
        if (question === 91) { // Passe de question 7.1 à question 7
            document.getElementById("Q" + question).style.display = 'none';
            question = 10;
        }
        if (question === 111) { // Passe de question 7.1 à question 7
            document.getElementById("Q" + question).style.display = 'none';
            question = 12;
        }
        if (question === 121) { // Passe de question 7.1 à question 7
            document.getElementById("Q" + question).style.display = 'none';
            question = 13;
        }
        question -= 1; //revien question précédente
        for (var i = 0; i <= 4; i++) { //Es-que il y à une réponse cochée ?
            if ($("#rp" + question + i).is(':checked')) { //SI OUI
                break;
            }
            else {  //sinon ne rien faire

            }
        }
        document.getElementById("Q" + question).style.display = 'block'; //Affiche question précédente
        document.getElementById("Q" + (question + 1)).style.display = 'none'; //Disparition question actuel
    }
    if (question >= 2) // Faire apparaitre bouton Précédent
        document.getElementById("btnPrec").disabled = false;
    else // Faire disparaitre bouton Précédent
        document.getElementById("btnPrec").disabled = true;
}

function QS() {
    document.getElementById("Q" + question).style.display = 'none';
    question += 1;
    document.getElementById("Q" + question).style.display = 'block';
}

function Q21() {
    //$('#popupPointerEvent').popup("open");  A faire pour l'année prochaine du projet
    document.getElementById("Q" + question).style.display = 'none';
    question += 1;
    document.getElementById("Q" + question).style.display = 'block';
}

function Q31() {
    if (question >= 31) {
        document.getElementById("Q" + question).style.display = 'none';

    }
    else {
        document.getElementById("Q" + question).style.display = 'none';
        //$('#popupPointerImageConcernee').popup("open");  A faire pour l'année prochaine du projet
        question = 30;
    }
    question += 1;
    document.getElementById("Q" + question).style.display = 'block';
}
function Q41() {
    if (question >= 41) {
        document.getElementById("Q" + question).style.display = 'none';

    }
    else {
        document.getElementById("Q" + question).style.display = 'none';
        question = 40;
    }
    question += 1;
    document.getElementById("Q" + question).style.display = 'block';
}
function Q71() {
    document.getElementById("Q" + question).style.display = 'none';
    question = 70;
    question += 1;
    document.getElementById("Q" + question).style.display = 'block';
}

function Q81() {
    //$('#popupPointerImageDispaAppa').popup("open");  A faire pour l'année prochaine du projet
    document.getElementById("Q" + question).style.display = 'none';
    question += 1;
    document.getElementById("Q" + question).style.display = 'block';
}
function Q91() {
    if (question >= 91) {
        document.getElementById("Q" + question).style.display = 'none';
    }
    else {
        document.getElementById("Q" + question).style.display = 'none';
        question = 90;
    }
    question += 1;
    document.getElementById("Q" + question).style.display = 'block';
}
function Q111() {
    if (question >= 111) {
        document.getElementById("Q" + question).style.display = 'none';
        question = 11;
    }
    else {
        document.getElementById("Q" + question).style.display = 'none';
        question = 110;
    }
    question += 1;
    document.getElementById("Q" + question).style.display = 'block';
}
function Q121() {
    document.getElementById("Q" + question).style.display = 'none';
    question = 120;
    question += 1;
    document.getElementById("Q" + question).style.display = 'block';
}
function QF() {
    $('#popupFinit').popup("open");
}
function QFGRB() {
    $('#popupQFGRB').popup("open");
    
}
function QFSN() {
    $('#popupQFSN').popup("open");
   
}
function QFKN() {
    $('#popupQFKN').popup("open");
    
}



