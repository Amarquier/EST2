/* global imagesNoms, cheminCalern, cheminChili, cheminRef */

// --------------------- callback ----------------------- 

var page;

$(function () {
    $("#btnPageSvt1").on("click", btnPageSvt1);
    $("#btnPageSvt2").on("click", btnPageSvt2);
    $("#btnPageSvt3").on("click", btnPageSvt3);
    $("#btnPageSvt4").on("click", btnPageSvt4);
    $("#btnPagePdt2").on("click", btnPagePdt2);
    $("#btnPagePdt3").on("click", btnPagePdt3);
    $("#btnPagePdt4").on("click", btnPagePdt4);
    $("#btnPagePdt5").on("click", btnPagePdt5);
    $("#Evaluation").on("click", evaluation);
});

function btnPageSvt1() {
    page++;
    changePage(2);
}

function btnPageSvt2() {
    page++;
    changePage(3);
}

function btnPageSvt3() {
    page++;
    changePage(4);
}
function btnPageSvt4() {
    page++;
    changePage(5);
}
function btnPagePdt2() {
    page--;
    changePage(1);
}

function btnPagePdt3() {
    page--;
    changePage(2);
}
function btnPagePdt4() {
    page--;
    changePage(3);
}
function btnPagePdt5() {
    page--;
    changePage(4);
}

function changePage(num) {

    $.mobile.changePage("#tutoPage" + num);
}

function evaluation() {
    $.mobile.changePage("#evaluationPage");
}
// ------------------ Fin de gestion du blink -----------------------