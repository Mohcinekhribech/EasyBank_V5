<%--
  Created by IntelliJ IDEA.
  User: adm
  Date: 16/10/2023
  Time: 12:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <script src="https://cdn.tailwindcss.com"></script>

    <title>Simulation</title>

</head>

<body>
<nav class="flex justify-between  top-0 w-full p-[30px] items-center">
    <svg @click="Showmenu" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5"
         stroke="currentColor" class="menu w-6 h-6 md:hidden cursor-pointer">
        <path stroke-linecap="round" stroke-linejoin="round" d="M3.75 6.75h16.5M3.75 12h16.5m-16.5 5.25h16.5" />
    </svg>
    <p class="font-bold text-4xl max-md:text-sm">Easy<span class="text-[#7E52A0]">Bank</span></p>
    <ul id="ul"
        class="flex max-md:top-0 md:space-x-10 font-medium max-md:flex-col max-md:w-full max-md:left-0 max-md:p-4 max-md:absolute max-md:w-full">
        <svg @click="Hidemenu" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5"
             stroke="currentColor" class="w-6 h-6 flec md:hidden cursor-pointer">
            <path stroke-linecap="round" stroke-linejoin="round" d="M6 18L18 6M6 6l12 12" />
        </svg>
        <a href="/home"
           class="hover:text-[#7E52A0] text-xl font-semibold max-md:w-full text-center  max-md:my-2 hover:underline hover:underline-offset-2">Home</a>
        <a href="#"
           class=" underline underline-offset-2 text-[#7E52A0] text-xl font-semibold max-md:w-full text-center max-md:my-2">Simulation</a>
        <a href="#gallerie"
           class="hover:text-[#7E52A0] text-xl font-semibold max-md:w-full text-center max-md:my-2 hover:underline hover:underline-offset-2">Contact</a>
    </ul>
    <a href="/login"
       class="px-4 py-2 bg-[#7E52A0] hover:bg-[#29274C] cursor-pointer text-sm font-bold rounded-lg text-white max-md:text-xs">Sign
        In</a>
</nav>

<section>

    <div class="w-full py-6">
        <div class="flex">
            <div class="w-1/3">
                <div class="relative mb-2">
                    <div class="w-10 h-10 mx-auto bg-[#7E52A0] rounded-full text-lg text-white flex items-center">
              <span class="text-center text-white w-full">
                <svg class="w-full fill-current" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" width="24"
                     height="24">
                  <path class="heroicon-ui"
                        d="M5 3h14a2 2 0 0 1 2 2v14a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V5c0-1.1.9-2 2-2zm14 8V5H5v6h14zm0 2H5v6h14v-6zM8 9a1 1 0 1 1 0-2 1 1 0 0 1 0 2zm0 8a1 1 0 1 1 0-2 1 1 0 0 1 0 2z" />
                </svg>
              </span>
                    </div>
                </div>

                <div class="text-xs text-center md:text-base">Simuler mon Crédit</div>
            </div>

            <div class="w-1/3">
                <div class="relative mb-2">
                    <div class="absolute flex align-center items-center align-middle content-center"
                         style="width: calc(100% - 2.5rem - 1rem); top: 50%; transform: translate(-50%, -50%)">
                        <div class="w-full bg-gray-200 rounded items-center align-middle align-center flex-1">
                            <div class="w-0 bg-[#7E52A0]  py-1 rounded" style="width: 100%;"></div>
                        </div>
                    </div>

                    <div class="w-10 h-10 mx-auto bg-[#7E52A0] rounded-full text-lg text-white flex items-center">
              <span class="text-center text-white w-full">
                <svg class="w-full fill-current" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" width="24"
                     height="24">
                  <path class="heroicon-ui"
                        d="M19 10h2a1 1 0 0 1 0 2h-2v2a1 1 0 0 1-2 0v-2h-2a1 1 0 0 1 0-2h2V8a1 1 0 0 1 2 0v2zM9 12A5 5 0 1 1 9 2a5 5 0 0 1 0 10zm0-2a3 3 0 1 0 0-6 3 3 0 0 0 0 6zm8 11a1 1 0 0 1-2 0v-2a3 3 0 0 0-3-3H7a3 3 0 0 0-3 3v2a1 1 0 0 1-2 0v-2a5 5 0 0 1 5-5h5a5 5 0 0 1 5 5v2z" />
                </svg>
              </span>
                    </div>
                </div>

                <div class="text-xs text-center md:text-base">Mes Coordonnées</div>
            </div>

            <div class="w-1/3">
                <div class="relative mb-2">
                    <div class="absolute flex align-center items-center align-middle content-center"
                         style="width: calc(100% - 2.5rem - 1rem); top: 50%; transform: translate(-50%, -50%)">
                        <div class="w-full bg-gray-200 rounded items-center align-middle align-center flex-1">
                            <div class="w-0 bg-[#7E52A0]  py-1 rounded" style="width: 33%;"></div>
                        </div>
                    </div>

                    <div
                            class="w-10 h-10 mx-auto bg-white border-2 border-gray-200 rounded-full text-lg text-white flex items-center">
              <span class="text-center text-gray-600 w-full">
                <svg class="w-full fill-current" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" width="24"
                     height="24">
                  <path class="heroicon-ui"
                        d="M9 4.58V4c0-1.1.9-2 2-2h2a2 2 0 0 1 2 2v.58a8 8 0 0 1 1.92 1.11l.5-.29a2 2 0 0 1 2.74.73l1 1.74a2 2 0 0 1-.73 2.73l-.5.29a8.06 8.06 0 0 1 0 2.22l.5.3a2 2 0 0 1 .73 2.72l-1 1.74a2 2 0 0 1-2.73.73l-.5-.3A8 8 0 0 1 15 19.43V20a2 2 0 0 1-2 2h-2a2 2 0 0 1-2-2v-.58a8 8 0 0 1-1.92-1.11l-.5.29a2 2 0 0 1-2.74-.73l-1-1.74a2 2 0 0 1 .73-2.73l.5-.29a8.06 8.06 0 0 1 0-2.22l-.5-.3a2 2 0 0 1-.73-2.72l1-1.74a2 2 0 0 1 2.73-.73l.5.3A8 8 0 0 1 9 4.57zM7.88 7.64l-.54.51-1.77-1.02-1 1.74 1.76 1.01-.17.73a6.02 6.02 0 0 0 0 2.78l.17.73-1.76 1.01 1 1.74 1.77-1.02.54.51a6 6 0 0 0 2.4 1.4l.72.2V20h2v-2.04l.71-.2a6 6 0 0 0 2.41-1.4l.54-.51 1.77 1.02 1-1.74-1.76-1.01.17-.73a6.02 6.02 0 0 0 0-2.78l-.17-.73 1.76-1.01-1-1.74-1.77 1.02-.54-.51a6 6 0 0 0-2.4-1.4l-.72-.2V4h-2v2.04l-.71.2a6 6 0 0 0-2.41 1.4zM12 16a4 4 0 1 1 0-8 4 4 0 0 1 0 8zm0-2a2 2 0 1 0 0-4 2 2 0 0 0 0 4z" />
                </svg>
              </span>
                    </div>
                </div>

                <div class="text-xs text-center md:text-base">Mes infos Personnelles</div>
            </div>
        </div>
    </div>
    </div>
</section>
<section class="flex m-12 justify-center flex-wrap  ">
    <div class="m-12 shadow-lg w-2/4  rounded-lg h-fit sm:rounded-lg p-4 px-12 gap-4 flex flex-col">
        <div id="simuler">
            <div>
                <div class="my-4">
                    <label for="countries" class="block mb-2 text-sm font-medium text-black ">Mon
                        projet</label>
                    <select id="countries"
                            class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5  dark:border-gray-600   ">
                        <option value="">J’ai besoin d’argent</option>
                        <option value="">Je finance mon véhicule d’occasion</option>
                        <option value="">Je Gère mes imprévus</option>
                        <option value="">Je finance mon véhicule neuf</option>
                        <option value="">J’équipe ma maison</option>
                    </select>
                </div>
                <div class="my-4">
                    <label for="countries" class="block mb-2 text-sm font-medium text-black ">Je suis</label>
                    <select id="countries"
                            class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5  dark:border-gray-600 ">
                        <option value="">Fonctionnaire</option>
                        <option value="">Salarié du secteur privé</option>
                        <option value="">Profession libérale</option>
                        <option value="">Commerçant</option>
                        <option value="">Artisan</option>
                        <option value="">Retraité</option>
                        <option value="">Autres professions</option>
                    </select>
                </div>
                <div class="my-4">
                    <div class="p-2">
                        <div class="flex justify-between">
                            <label for="montantRange" class="block mb-2 text-sm font-medium text-gray-900">Montant (en DH)</label>
                            <input class="p-2 max-w-fit apparence-none bg-gray-200 rounded-md cursor-pointer" type="text"
                                   name="montant" disabled value="30000" id="montant">
                        </div>
                        <input id="montantRange" min="5000" max="600000" type="range" value="30000" name="montant"
                               class="w-full h-2 apparence-none bg-gray-200 rounded-md cursor-pointer">
                    </div>
                    <div class="p-2">
                        <div class="flex justify-between">
                            <label for="dureeRange" class="block mb-2 text-sm font-medium text-black">Durée (en mois)</label>
                            <input class="p-2 max-w-fit apparence-none bg-gray-200 rounded-md cursor-pointer" type="text"
                                   name="duree" id="duree" disabled value="24">
                        </div>
                        <input id="dureeRange" min="2" max="30" type="range" value="24" name="duree"
                               class="w-full h-2 text-yellow-500 apparence-none bg-gray-200 rounded-md cursor-pointer">
                    </div>
                    <div class="p-2">
                        <div class="flex justify-between">
                            <label for="rangemensuel" class="block mb-2 text-sm font-medium text-gray-900">Mensualités (en
                                DH)</label>
                            <input class="p-2 max-w-fit apparence-none bg-gray-200 rounded-md cursor-pointer" type="text"
                                   name="mensualite" id="mensualite" disabled value="30000">
                        </div>
                    </div>
                </div>
                <div class="mx-auto ">
                    <button class="bg-[#7E52A0] hover:bg-[#29274C] text-white font-bold py-4 px-6 rounded-full "
                            onclick="goTo()">
                        continuer
                    </button>
                </div>
            </div>
        </div>
        <div id="coordonne" class="hidden">
            <form action="info" class="flex flex-col gap-8">
                <label for="id" class="text-xl font-bold">Inserer le code client</label>
                <input type="text" name="id" placeholder=" Client"
                       class="w-full border-2 border-gray-300 p-2 rounded-lg focus:outline-none focus:border-[#7E52A0]">
                <button type="submit" class="bg-[#7E52A0] text-white font-bold p-2 rounded-full hover:bg-[#29274C] text-white font-bold py-4 px-6 ">
                    valider
                </button>
            </form>
        </div>
    </div>
    <div class="m-12 shadow-lg w-1/4  rounded-lg h-fit text-center">
        <h1 class="text-2xl font-bold ">Mon récapitulatif</h1>
        <div class="bg-gray-100 mt-4 h-[2rem] font-bold">
            Mon projet
        </div>
        <div class="flex justify-between px-4 py-2">
            <p class="text-yellow-500 font-bold">Prêt Personnel</p>
            <p></p>
        </div>
        <div class="bg-gray-100 mt-4 h-[2rem] font-bold">
            Détails de mon crédit
        </div>
        <div>
            <div class=" flex justify-between p-4">
                <p>vous etes :</p>
                <p class="text-yellow-500 font-bold">Fonctionnaire</p>
            </div>
            <hr>
            <div class=" flex justify-between p-4">
                <p>Montant :</p>
                <p class="text-yellow-500 font-bold" id="montantVal"> DH</p>
            </div>
            <hr>
            <div class=" flex justify-between p-4">
                <p>Durée:</p>
                <p class="text-yellow-500 font-bold " id="monthValue">mois</p>
            </div>
            <div class=" flex justify-between p-4">
                <p>Mensualité:</p>
                <p class="text-yellow-500 font-bold " id="mensualiteVal">DH</p>
            </div>
            <hr>
        </div>

    </div>
</section>



</body>
<script>
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

</script>
</html>
