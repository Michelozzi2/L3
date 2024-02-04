window.onload = function() {
    const playerNameInput = document.getElementById('name');
    const playerNumberInput = document.getElementById('number');
    const playerSumInput = document.getElementById('somme');

    const versusDiv = document.getElementById('versus');
    const playerNameSpan = document.getElementById('playerName');
    const resultSpan = document.getElementById('result');
    const computerNameSpan = document.getElementById('computerName');

    playerNameInput.addEventListener('input', function() {
        playerNameSpan.textContent = playerNameInput.value;
    });

    function generateComputerNumber() {
        return Math.floor(Math.random() * 5) + 1; // Random number between 1 and 5
    }

    function generateComputerSum() {
        return Math.floor(Math.random() * 10) + 1; // Random sum between 1 and 10
    }

    function determineWinner(playerNumber, computerNumber, playerSum, computerSum) {
        if (playerNumber + playerSum > computerNumber + computerSum) {
            resultSpan.textContent = playerNameInput.value + ' a gagné!';
        } else if (playerNumber + playerSum < computerNumber + computerSum) {
            resultSpan.textContent = 'Ordi a gagné!';
        } else {
            resultSpan.textContent = 'Match nul!';
        }
    }

    playerNumberInput.addEventListener('input', function() {
        const playerNumber = parseInt(playerNumberInput.value);
        const playerSum = parseInt(playerSumInput.value);

        const computerNumber = generateComputerNumber();
        const computerSum = generateComputerSum();

        determineWinner(playerNumber, computerNumber, playerSum, computerSum);
    });

    playerSumInput.addEventListener('input', function() {
        const playerNumber = parseInt(playerNumberInput.value);
        const playerSum = parseInt(playerSumInput.value);

        const computerNumber = generateComputerNumber();
        const computerSum = generateComputerSum();

        determineWinner(playerNumber, computerNumber, playerSum, computerSum);
    });
};