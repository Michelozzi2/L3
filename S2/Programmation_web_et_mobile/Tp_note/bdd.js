// Attache un écouteur d'événements à l'élément d'entrée de fichier
var fileInput = document.querySelector('.file-input');
if (fileInput) {
    fileInput.addEventListener('change', function(e) {
        // Récupère le nom du premier fichier sélectionné
        var fileName = e.target.files[0].name;
        // Affiche le nom du fichier dans un élément avec la classe 'file-name'
        document.querySelector('.file-name').textContent = fileName;
    });
}


// Attache un écouteur d'événements à l'élément d'entrée de fichier
var fileInput = document.querySelector('.file-input');
if (fileInput) {
    fileInput.addEventListener('change', function(e) {
        // Récupère le nom du premier fichier sélectionné
        var fileName = e.target.files[0].name;
        // Affiche le nom du fichier dans un élément avec la classe 'file-name'
        document.querySelector('.file-name').textContent = fileName;
    });
}

// Fonction pour mettre à jour la table avec de nouvelles données
function updateTable(data) {
    // Obtient la table par son ID
    const table = document.getElementById('studentTable');
    
    // Si la table n'existe pas, quitte la fonction
    if (!table) return;
    
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
var nameInput = document.querySelector('#nameInput');
if (nameInput) {
    nameInput.addEventListener('input', function(e) {
        var search = e.target.value; // Récupère la valeur actuelle de l'élément d'entrée
        var suggestions = document.querySelector('#suggestions');// Récupère l'élément de suggestions

        if (search.length > 0) { // Effectue une recherche seulement si l'entrée est de 0 caractères ou plus
            // Récupère les résultats de la recherche depuis le serveur
            fetch('suggestion.php?query=' + search)
                .then(response => response.json()) // Convertit la réponse en JSON
                .then(data => {
                   if (suggestions){
                        // Efface les suggestions actuelles
                        suggestions.innerHTML = '';

                        // Ajoute les nouvelles suggestions
                        data.forEach(row => {
                            console.log(row);
                            var div = document.createElement('div'); // Crée un nouvel élément div
                            div.textContent = row.Nom + ' ' + row.Prenom; // Définit le contenu textuel de l'élément div
                            // Ajoute un écouteur d'événements à l'élément div
                            div.addEventListener('click', function() {
                                nameInput.value = row.Nom + ' ' + row.Prenom;
                                nameInput.setAttribute('data-id', row.idStudent); // Définit l'attribut data-id de l'élément d'entrée

                                // Met à jour la valeur de l'élément d'entrée avec le nom et le prénom de l'étudiant
                                document.querySelector('#name') ? document.querySelector('#name').value = row.Nom : null;
                                document.querySelector('#firstName') ? document.querySelector('#firstName').value = row.Prenom : null;
                                document.querySelector('#promo') ? document.querySelector('#promo').value = row.Promo : null;
                                document.querySelector('#skills') ? document.querySelector('#skills').value = row.Skills : null;
                                // Met à jour la table avec les données de l'étudiant
                                updateTable([row]);
                            });
                            // Ajoute l'élément div aux suggestions
                            suggestions.appendChild(div);
                        });

                        // Met à jour la table avec les données des étudiants correspondant à la recherche
                        updateTable(data);
                    }
                })
                .catch(error => {
                    console.error('Error fetching search results:', error);
                });
        } else {
            // Si le champ d'entrée est vide, efface les suggestions
            suggestions.innerHTML = '';
        }
    });
}


var editForm = document.querySelector('#edit-form');
document.addEventListener('DOMContentLoaded', (event) => {
    
    if (editForm) {

        editForm.addEventListener('submit', function(e) {
            e.preventDefault(); // Empêche le formulaire d'être soumis normalement

            // Récupère les valeurs des champs d'entrée
            var name = document.querySelector('#name').value;
            var firstName = document.querySelector('#firstName').value;
            var promo = document.querySelector('#promo').value;
            var skills = document.querySelector('#skills').value;

            // Envoie les données à update_student.php
            fetch('update_student.php', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/x-www-form-urlencoded',
                },
                body: new URLSearchParams({
                    'name': name,
                    'firstName': firstName,
                    'promo': promo,
                    'skills': skills,
                }),
            })
            .then(response => response.text())
            .then(data => {
                // Affiche le message de réponse
                alert(data);
            })
            .catch(error => console.error('Error:', error));
        });
    }
});


// Sélectionne le formulaire
var form = document.querySelector('#edit-team');

form.addEventListener('submit', function(e) {
    e.preventDefault(); // Empêche le comportement par défaut du formulaire

    // Crée un nouvel objet FormData à partir du formulaire
    var formData = new FormData(form);

    // Envoie une requête POST au serveur avec les données du formulaire
    fetch('create_team.php', {
        method: 'POST',
        body: formData
    })
    .then(response => response.json()) // Convertit la réponse en JSON
    .then(data => {
        // Gère la réponse du serveur
        if (data.status === 'success') {
            alert(data.message); // Affiche le message de succès
        } else {
            alert(data.message); // Affiche le message d'erreur
        }
    })
    .catch(error => {
        // Gère les erreurs
        console.error('Error:', error);
    });
});




document.addEventListener('DOMContentLoaded', function() {
    var form = document.querySelector('#editForm1');

    function handleSubmit(e) {
        e.preventDefault(); // Empêche le comportement par défaut du formulaire


        IdEquipe = document.querySelector('input[name=IdEquipe]').value
        IdEtudiant = document.querySelector('input[name=NomEtudiant]').getAttribute('data-id')


        // Envoie une requête POST au serveur avec les données du formulaire
        fetch('add_student_to_team.php', {
            method: 'POST',
            body: JSON.stringify({
                'IdEquipe': IdEquipe,
                'IdEtudiant': IdEtudiant
            })
        })
        .then(response => response.json()) // Convertit la réponse en JSON
        .then(data => {
            // Gère la réponse du serveur
            if (data.status === 'success') {
                alert(data.message); // Affiche le message de succès
            } else {
                alert(data.message); // Affiche le message d'erreur
            }
        })
        .catch(error => {
            // Gère les erreurs
            console.error('Error:', error);
        });
    }

    if (form) {
        form.addEventListener('submit', handleSubmit);
    }

    // Sélectionne le corps du tableau
    var tbody = document.querySelector('#teamsTable tbody');

    // Récupère les données de la table teams
    fetch('insert_student.php')
    .then(response => response.json()) // Convertit la réponse en JSON
    .then(teams => {
        // Parcourt chaque équipe
        teams.forEach(team => {
            // Crée une nouvelle ligne pour l'équipe
            var row = document.createElement('tr');

            // Ajoute une cellule pour chaque propriété de l'équipe
            for (var property in team) {
                var cell = document.createElement('td');
                cell.textContent = team[property];
                row.appendChild(cell);
            }

            // Ajoute la ligne au corps du tableau
            tbody.appendChild(row);
        });
    })
    .catch(error => {
        // Gère les erreurs
        console.error('Error:', error);
    });
});