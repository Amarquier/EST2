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
    $("#btnTutoSn").on("click", btnTutoSn);
    $("#Evaluation").on("click", evaluation);
    
    $("#btnPageSnSvt6").on("click", btnPageSnSvt6);
    $("#btnPageSnSvt7").on("click", btnPageSnSvt7);
    $("#btnPageSnSvt8").on("click", btnPageSnSvt8);
    $("#btnPageSnSvt9").on("click", btnPageSnSvt9);
    $("#btnPageSnSvt10").on("click", btnPageSnSvt10);
    $("#btnPageSnPdt6").on("click", btnPageSnPdt6);
    $("#btnPageSnPdt7").on("click", btnPageSnPdt7);
    $("#btnPageSnPdt8").on("click", btnPageSnPdt8);
    $("#btnPageSnPdt9").on("click", btnPageSnPdt9);
    $("#btnPageSnPdt10").on("click", btnPageSnPdt10);
    $("#btnPageSnPdt11").on("click", btnPageSnPdt11);
});

function btnPageSvt1() {
    page++;
    changePage(2);
}

function btnTutoSn() {
    page++;
    changePage(6);
    color:blue;
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

// PAGES TUTO SNDISCO //

function btnPageSnSvt6() {
    page++;
    changePage(7);
}
function btnPageSnSvt7() {
    page++;
    changePage(8);
}
function btnPageSnSvt8() {
    page++;
    changePage(9);
}
function btnPageSnSvt9() {
    page++;
    changePage(10);
}
function btnPageSnSvt10() {
    page++;
    changePage(11);
}

function btnPageSnPdt6() {
    page--;
    changePage(1);
}

function btnPageSnPdt7() {
    page--;
    changePage(6);
}
function btnPageSnPdt8() {
    page--;
    changePage(7);
}
function btnPageSnPdt9() {
    page--;
    changePage(8);
}
function btnPageSnPdt10() {
    page--;
    changePage(9);
}
function btnPageSnPdt11() {
    page--;
    changePage(10 );
}



function changePage(num) {

    $.mobile.changePage("#tutoPage" + num);
}

function evaluation() {
    $.mobile.changePage("#evaluationPage");
}
// ------------------ Fin de gestion du blink -----------------------