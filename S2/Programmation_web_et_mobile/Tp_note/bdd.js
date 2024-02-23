document.querySelector('.file-input').addEventListener('change', function(e) {
    var fileName = e.target.files[0].name;
    document.querySelector('.file-name').textContent = fileName;
});

function updateTable(data) {
    const table = document.getElementById('studentTable');
    // Clear the current table rows
    table.innerHTML = '<thead><tr><th>Nom</th><th>Prenom</th><th>Promo</th></tr></thead><tbody></tbody>';
    data.forEach(row => {
        const tr = document.createElement('tr');
        tr.innerHTML = `<td>${row.Nom}</td><td>${row.Prenom}</td><td>${row.Promo}</td>`;
        table.appendChild(tr);
    });
}

fetch('get_students.php')
    .then(response => response.json())
    .then(updateTable);

document.querySelector('#nameInput').addEventListener('input', function(e) {
    var search = e.target.value;
    if (search.length > 2) { // Only search if the input is 3 characters or longer
        fetch('search_students.php?search=' + search)
            .then(response => response.json())
            .then(data => {
                // Clear the current suggestions
                var suggestions = document.querySelector('.suggestions');
                suggestions.innerHTML = '';

                // Add the new suggestions
                data.forEach(row => {
                    var div = document.createElement('div');
                    div.textContent = row.Nom + ' ' + row.Prenom;
                    div.addEventListener('click', function() {
                        document.querySelector('#nameInput').value = row.Nom + ' ' + row.Prenom;
                        updateTable([row]);
                    });
                    suggestions.appendChild(div);
                });
            });
    }
});