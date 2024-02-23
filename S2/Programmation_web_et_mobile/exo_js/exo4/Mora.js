// Sélection des éléments du DOM
const Pseudo = document.querySelector("#pseudo");
const playButton = document.querySelector("#play_button");
const players_result = document.querySelector("#player_result");
const gagnant = document.querySelector("#gagnant");
const cardHide = document.querySelector("#card_hide");


// Sélection des éléments du joueur
const input_selected_player = document.querySelector("#select_choice_player");
const value_player_choice = document.querySelector("#choice_player");
const input_selected_player_res = document.querySelector("#select_choice_res_player");
const value_player_choice_res = document.querySelector("#choice_res_player");

// Sélection des éléments du bot
const input_selected_bot = document.querySelector("#select_choice_bot");
const value_bot_choice = document.querySelector("#choice_bot");
const input_selected_res_bot = document.querySelector("#select_choice_res_bot");
const value_res_bot_choice = document.querySelector("#choice_res_bot");

// Fonction pour générer un nombre aléatoire
function getRandomInt(min, max) {
    min = Math.ceil(min);
    max = Math.floor(max);
    return Math.floor(Math.random() * (max - min + 1)) + min;
}

// Fonction pour afficher la valeur du joueur
function displayPlayerValue(inputElement, displayElement) {
    displayElement.textContent = Math.round(inputElement.value);
    inputElement.addEventListener("input", (event) => {
        displayElement.textContent = Math.round(event.target.value);
    });
}

// Fonction pour afficher la valeur du bot
function displayBotValue(inputElement, displayElement) {
    inputElement.addEventListener("input", (event) => {
        displayElement.textContent = Math.round(event.target.value);
    });
}

// Affichage des choix du joueur et du bot
displayPlayerValue(input_selected_player, value_player_choice);
displayPlayerValue(input_selected_player_res, value_player_choice_res);
displayBotValue(input_selected_bot, value_bot_choice);
displayBotValue(input_selected_res_bot, value_res_bot_choice);

window.onload = function() {
    var sliders = document.querySelectorAll('input[type="range"]');
    sliders.forEach(function(slider) {
        slider.oninput = function() {
            var value = (this.value-this.min)/(this.max-this.min)*100
            this.style.background = 'linear-gradient(to right, #f5f5f5 0%, #6fb9bb calc(' + value + '% - 10px), #f5f5f5 calc(' + value + '% - 10px), #f5f5f5 100%)';
        };
    });
};

function updateSliderBackground(slider) {
    var value = (slider.value-slider.min)/(slider.max-slider.min)*100
    slider.style.background = 'linear-gradient(to right, #f5f5f5 0%, #6fb9bb calc(' + value + '% - 10px), #f5f5f5 calc(' + value + '% - 10px), #f5f5f5 100%)';
}

window.onload = function() {
    var sliders = document.querySelectorAll('input[type="range"]');
    sliders.forEach(function(slider) {
        slider.oninput = function() {
            updateSliderBackground(this);
        };
        updateSliderBackground(slider);
    });
};

// Événement quand on clique sur le bouton
playButton.addEventListener("click", () => {
    // Génération aléatoire des choix du bot
    input_selected_bot.value = getRandomInt(1, 5);
    value_bot_choice.textContent = Math.round(input_selected_bot.value);
    updateSliderBackground(input_selected_bot);

    input_selected_res_bot.value = getRandomInt(2, 10);
    value_res_bot_choice.textContent = Math.round(input_selected_res_bot.value);
    updateSliderBackground(input_selected_res_bot);

    // Calcul de la somme et des différences
    const sum = Number(input_selected_player.value) + Number(input_selected_bot.value);
    const playerDifference = Math.abs(sum - Number(input_selected_player_res.value));
    const botDifference = Math.abs(sum - Number(input_selected_res_bot.value));

    // Affichage des résultats
    cardHide.style.display = "block";
    players_result.textContent = `Somme : ${Math.round(sum)}`;

    // Détermination et affichage du gagnant
    let winner;
    if (playerDifference < botDifference) {
        winner = Pseudo.value.trim() !== "" ? Pseudo.value : 'Joueur';
    } else if (botDifference < playerDifference) {
        winner = 'Ordinateur';
    } else {
        winner = 'Personne, c\'est un match nul';
    }
    gagnant.textContent = `Le gagnant est : ${winner}`;
});