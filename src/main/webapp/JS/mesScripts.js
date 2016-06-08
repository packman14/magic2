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
//        $("#ingredients_dispo").load("actualiseringredients");

    }, 1000);
}

$(myFunction);


function lancerSort() {
    $.post("jeu", $("#lancerSort").serialize());
}
function piocher()
{
    $.post("piocher", $("#piocher"));
}

function sort()
{
    var cartes = $(".bordureVerte");
    
    $.post("sort/" + cartes.get(0).id + "/" + cartes.get(1).id, $("#sort"));
}

function carteCliquee(carteCliqueeID)
{
    if($("#" + carteCliqueeID).hasClass("bordureVerte"))
    {
        $("#" + carteCliqueeID).removeClass("bordureVerte")
    }
    else
    {
        $("#" + carteCliqueeID).addClass("bordureVerte");
    }
    
    
}

    