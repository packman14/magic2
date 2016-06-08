/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function myFunction()
{
    setInterval(function () {
        $("#contenu").load("attente");
        $("#action_joueur").load("actualiserjeu");
        $("#actionJoueur").load("actualisertour");
    }, 500);
}

$(myFunction);


function lancerSort() {
    $.post("jeu", $("#lancerSort").serialize());
    $("#ingredients_dispo").load("actualiseringredients");

}
function piocher()
{
    $.post("piocher", $("#piocher"));
    $("#ingredients_dispo").load("actualiseringredients");

}

function sort()
{
    var cartes = $(".bordureVerte");

    $.post("sort/" + cartes.get(0).id + "/" + cartes.get(1).id, $("#sort"));
}

function carteCliquee(carteCliqueeID)
{
    if ($("#" + carteCliqueeID).hasClass("bordureVerte"))
    {
        $("#" + carteCliqueeID).removeClass("bordureVerte");
    } else
    {
        $("#" + carteCliqueeID).addClass("bordureVerte");
    }


}

    