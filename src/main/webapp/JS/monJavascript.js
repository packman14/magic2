/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function chargerPlateau(){
    $('#plateau').load('plateau', callback);
    
}
function callback() {
    
    setTimeout(chargerPlateau, 1000);
}

chargerPlateau();

//setInterval(maFonction, 1000);
//load(maFonction);

function maCallback(donnees) {
    $('#ressource').html(donnees.titre);
    $('#plateau').html(donnees.id);
}

$.get('film/find/1', maCallback);