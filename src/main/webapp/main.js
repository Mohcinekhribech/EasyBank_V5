const simule = document.getElementById('simuler');
const coordonne = document.getElementById('coordonne');
console.log("test")
document.getElementById('montantVal').innerHTML = '30000 DH';
document.getElementById('monthValue').innerHTML = '24 mois';
document.getElementById('mensualiteVal').innerHTML = '30000 DH';

const montantVal = document.getElementById('montantVal').value;
const monthValue = document.getElementById('monthValue').value;
const mensualiteVal = document.getElementById('mensualiteVal').value;
const mensua = document.getElementById('mensualite').value;


function goTo() {

    // hide simuler div and show coordonne div
    simule.classList.add('hidden');
    coordonne.classList.remove('hidden');
    //get the value in the input when i click on the button
    const montant = document.getElementById('montant').value;

    const duree = document.getElementById('duree').value;
    const mensualite = document.getElementById('mensualite').value;
    const taux = 7;
    const tauFloat = taux / 100;

    const simulation = (montant * tauFloat / (1 - Math.pow(1 + tauFloat, -duree)));
    //get one number after the comma
    const simulation2 = simulation.toFixed(2);
    document.getElementById('mensualite').value = simulation2 + ' DH';
    //set the value in the div
    document.getElementById('montantVal').innerHTML = montant + ' DH';
    document.getElementById('monthValue').innerHTML = duree + ' mois';
    document.getElementById('mensualiteVal').innerHTML = simulation2 + ' DH';
    localStorage.setItem('montant', montant);
    localStorage.setItem('duree', duree);
    localStorage.setItem('simulation', simulation2);

}


function simuler(montant,duree) {
    // const mensualite = document.getElementById('mensualite').value;
    const taux = 7;
    const tauFloat = (taux / 100)/12 ;
    const simulation = (montant * tauFloat / (1 - Math.pow(1 + tauFloat, -duree)));
    //get two number after the comma
    const simulation2 = simulation.toFixed(2);
    return simulation2;

}




document.addEventListener('DOMContentLoaded', function () {
    const mensualiteRange = document.getElementById('rangemensuel');
    const mensualite = document.getElementById('mensualite');

    const dureeRange = document.getElementById('dureeRange');
    const duree = document.getElementById('duree');

    const montantRange = document.getElementById('montantRange');
    const montant = document.getElementById('montant');




    dureeRange.addEventListener('input', function () {
        duree.value = dureeRange.value;
        const dr= dureeRange.value;
        mensualite.value = simuler(montant.value,dr);
    });


    montantRange.addEventListener('input', function () {
        const mt = montantRange.value;
        montant.value = montantRange.value;
        mensualite.value = simuler(mt,duree.value);

    });
});
