document.addEventListener('DOMContentLoaded', (event) => {
    let NombreAleatoire = Math.floor(Math.random() * 10) + 1;
    let Boutton = document.createElement('button');
    let counter = 0;
    Boutton.textContent = "Valider";
    document.body.appendChild(Boutton);
    console.log(NombreAleatoire);
    

    Boutton.addEventListener('click', () => {
        let userNumber = document.getElementById('number').value;
        let userName = document.getElementById('name').value;
        counter++;
        if(userNumber == NombreAleatoire) {
            alert("Bravo " + userName + " !, vous avez trouvé le juste prix en " + counter + " coups !");
        } else if(userNumber > NombreAleatoire) {
            alert("Désolé, votre nombre est trop grand. Essayez encore !");
        } else {
            alert("Désolé, votre nombre est trop petit. Essayez encore !");
        }
    });
});