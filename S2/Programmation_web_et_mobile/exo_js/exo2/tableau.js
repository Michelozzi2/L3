//1
let sequence = [1,1,2,3,5,8,13]
const soustableau = sequence.map(e => e * 2)
console.log(soustableau)

//2
const soustableaupaire = sequence.filter(e => e % 2 ==0)
console.log(soustableaupaire)

const soustableauimpaire = sequence.filter(e => e % 2 !=0)
console.log(soustableauimpaire)

//3
const soustableausomme = sequence.reduce((a,b) => a + b)
console.log(soustableausomme)

//4
const estPaire = sequence.filter(e => e % 2 != 0).length != 0;
console.log(estPaire)

//5
const football = [
    {club:"SCB", joueur :"SANTELLI", but:2},
    {club:"SCB", joueur:"MAGRI", but:1},
    {club:"HAC", joueur:"KITALA", but:3},
    {club:"SCB", joueur:"ROBIC", but:3},
    {club:"BORDEAUX", joueur:"MAJA", but:4},
    ] 

const somme = football.filter(player => player.club == "SCB") .map(player => player.but +=1).reduce((somme,sumGoal) => somme+sumGoal);
console.log(somme)