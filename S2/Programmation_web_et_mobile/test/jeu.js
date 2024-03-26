/*
 Code de cours de dev web 2023
 PA Bisgambiglia 
*/
"use strict";

var score = 0;
var pseudo = "";

// gestion du nom
const ouputnomuser = document.querySelector("#spanusername");
const inputnomuser = document.querySelector("#idusername");
ouputnomuser.textContent = inputnomuser.value;
inputnomuser.addEventListener("input", (event) => {
    pseudo = event.target.value;
    ouputnomuser.textContent = event.target.value;
    score = 0;
    document.querySelector("#idscore").textContent = score;
});

// gestion de la création du compte
var outputmessage = "";
const inputsavecpt = document.querySelector("#idsubmit");
inputsavecpt.addEventListener("click", function() {
    // envoyer une requête AJAX pour créer le compte
    fetch("/2023/controleur.php",
    {
        method: "POST",
        // whatever data you want to post with a key-value pair
        body: "pseudo="+pseudo+"&score="+score,
        headers: 
        {
            "Content-Type": "application/x-www-form-urlencoded"
        }
    })
    .then(response => response.json())
    .then(response => {
        //console.log(JSON.stringify(response));
        //console.log(response.pseudo);
        outputmessage = "compte : " + response.pseudo + " sauvegardé";
        document.querySelector("#idmessage").textContent = outputmessage;
    })
}); 

// gestion affichage de tous les scores
var outputscoremessage = "<h3>Best Scores</h3>";
const linkbestscore = document.querySelector("#idbestscore");
linkbestscore.addEventListener("click", function() {
    // envoyer une requête AJAX pour créer le compte
    fetch("/2023/controleur.php?all=1",
    {
        method: "GET",
        headers: 
        {
            "Content-Type": "text/html; charset=utf-8"
        }
    })
    .then(response => response.json())
    .then(response => {
        //console.log(JSON.stringify(response));
        //console.log(response.pseudo);
        for (const property in response) {
            outputscoremessage += "<p> Joueur : <strong>" + response[property].pseudo_user + "</strong> score : " + response[property].score_user+"</p>";
        }
        document.querySelector('#bestscore').style.display = 'block';
        document.querySelector('#bestscore').style.visibility = 'visible';
        document.querySelector("#bestscore").innerHTML = outputscoremessage;
    })
}); 

// gestion de l'input 1 user valeur entre 1 et 5 
const value = document.querySelector("#valuenbr");
const input = document.querySelector("#idusernbr");
value.textContent = input.value;
input.addEventListener("input", (event) => {
  value.textContent = event.target.value;
});

// gestion de l'input 2 user valeur de la somme 
const value2 = document.querySelector("#valuesum");
const input2 = document.querySelector("#idusersum");
value2.textContent = input2.value;
input2.addEventListener("input", (event) => {
  value2.textContent = event.target.value;
  // lancement du programme de jeu
  game(value.value,value2.value);
});

/* fonction du jeu*/
function game(valueuser=0,sumuser=0)
{
    const computervalue = document.querySelector("#idpcnbr");
    const computersum = document.querySelector("#idpcnsum");
    const resultat = document.querySelector("#winner");
    // gestion des choix de l'ordinateur
    const randomvalue = getRandomInt(5);
    computervalue.textContent = randomvalue;
    let ouputcomputervalue = randomvalue+getRandomInt(4);
    computersum.textContent = ouputcomputervalue;
    // calcul des sommes et du résultat
    let ouputuservalue = parseInt(sumuser);
    let ouputwinnervalue = parseInt(valueuser)+randomvalue;
    // gestion de la variable de sortie
    let ouputresultat = "";
    // gestion des balises span de la zone du centre
    document.querySelector("#idspanusersum").textContent = ouputuservalue;
    document.querySelector("#idspanpcsum").textContent = ouputcomputervalue;
    document.querySelector("#resultat").textContent = ouputwinnervalue;
    // test pour trouver qui gagne
    let joueurresfinal = Math.abs(ouputwinnervalue - ouputuservalue);
    let pcresfinal = Math.abs(ouputwinnervalue - ouputcomputervalue);
    // gestion du cas des égalités
    if ((ouputuservalue === ouputcomputervalue) || (joueurresfinal === pcresfinal)){
        ouputresultat +=  " égalité";
    }
    else if (joueurresfinal < pcresfinal){
        ouputresultat += " le joueur gagner";
        score += 1;
        // à faire une requête update du score dans la BD
    }
    else{
        ouputresultat += " le joueur perd";
    }
    // affichage du résultat
    resultat.textContent = ouputresultat;
    document.querySelector("#idscore").textContent = score;
}

// fonction qui renvoie un nombre aléatoire entre 1 et max
function getRandomInt(max) {
    return Math.floor(Math.random() * max)+1;
}
