// Attache un écouteur d'événements à l'élément d'entrée de fichier
document.querySelector('.file-input').addEventListener('change', function(e) {
    // Récupère le nom du premier fichier sélectionné
    var fileName = e.target.files[0].name;
    // Affiche le nom du fichier dans un élément avec la classe 'file-name'
    document.querySelector('.file-name').textContent = fileName;
});



// Fonction pour mettre à jour la table avec de nouvelles données
function updateTable(data) {
    // Obtient la table par son ID
    const table = document.getElementById('studentTable');
    
    // Efface les lignes actuelles de la table
    // et initialise la table avec un en-tête
    table.innerHTML = '<thead><tr><th>Nom</th><th>Prenom</th><th>Promo</th></tr></thead><tbody></tbody>';
    
    // Parcourt chaque ligne de données
    data.forEach(row => {
        // Crée un nouvel élément de ligne de table
        const tr = document.createElement('tr');
        
        // Définit le contenu HTML de la ligne de table
        // en utilisant les données de la ligne
        tr.innerHTML = `<td>${row.Nom}</td><td>${row.Prenom}</td><td>${row.Promo}</td>`;
        
        // Ajoute la nouvelle ligne à la table
        table.appendChild(tr);
    });
}



// Récupère la liste initiale des étudiants depuis le serveur
fetch('get_students.php')
    .then(response => response.json()) // Convertit la réponse en JSON
    .then(updateTable); // Met à jour la table avec les données reçues



// Ajoute un écouteur d'événements à l'élément d'entrée pour le nom
document.querySelector('#nameInput').addEventListener('input', function(e) {
    var search = e.target.value; // Récupère la valeur actuelle de l'élément d'entrée
    var suggestions = document.querySelector('#suggestions');// Récupère l'élément de suggestions

    if (search.length > 0) { // Effectue une recherche seulement si l'entrée est de 3 caractères ou plus
        // Récupère les résultats de la recherche depuis le serveur
        fetch('search_students.php?search=' + search)
            .then(response => response.json()) // Convertit la réponse en JSON
            .then(data => {
                // Efface les suggestions actuelles
                suggestions.innerHTML = '';

                // Ajoute les nouvelles suggestions
                data.forEach(row => {
                    var div = document.createElement('div'); // Crée un nouvel élément div
                    div.textContent = row.Nom + ' ' + row.Prenom; // Définit le contenu textuel de l'élément div
                    // Ajoute un écouteur d'événements à l'élément div
                    div.addEventListener('click', function() {
                        // Met à jour la valeur de l'élément d'entrée avec le nom et le prénom de l'étudiant
                        document.querySelector('#nameInput').value = row.Nom + ' ' + row.Prenom;
                        // Met à jour la table avec les données de l'étudiant
                        updateTable([row]);
                    });
                    // Ajoute l'élément div aux suggestions
                    suggestions.appendChild(div);
                });
            });
    } else {
        // Si le champ d'entrée est vide, efface les suggestions
        suggestions.innerHTML = '';
    }
});



