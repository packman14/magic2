/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function myFunction() 
{
    setInterval(function(){ 
        $( "#contenu" ).load( "attente" );
        $( "#action_joueur" ).load( "actualiserjeu" );
    }, 1000);
}

$(myFunction);