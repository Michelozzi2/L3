function tirerAleatoire() {
    // Sélectionner tous les éléments <li> dans la liste
    var elements = document.querySelectorAll("li");

    // Générer un index aléatoire
    var randomIndex = Math.floor(Math.random() * elements.length);

    // Supprimer la classe de surbrillance de tous les éléments
    elements.forEach(function(element) {
        element.classList.remove("highlight");
    });

    // Ajouter la classe de surbrillance à l'élément sélectionné aléatoirement
    elements[randomIndex].classList.add("highlight");
}