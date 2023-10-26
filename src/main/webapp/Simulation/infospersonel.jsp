<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: adm
  Date: 19/10/2023
  Time: 11:37
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
        <a href="#home"
           class="hover:text-[#7E52A0] text-xl font-semibold max-md:w-full text-center  max-md:my-2 hover:underline hover:underline-offset-2">Home</a>
        <a href="#service"
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
                            <div class="w-0 bg-[#7E52A0]  py-1 rounded" style="width: 100%; "></div>
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
                            <div class="w-0 bg-[#7E52A0]  py-1 rounded" style="width:100%;"></div>
                        </div>
                    </div>

                    <div class="w-10 h-10 mx-auto bg-[#7E52A0] rounded-full text-lg text-white flex items-center ">
              <span class="text-center text-gray-600 w-full text-white ">
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
    <div class="m-12 shadow-lg w-2/4  rounded-lg h-fit  sm:rounded-lg p-12  px-12 gap-4 flex flex-col ">
        <div id="infos">
            <form action="insertCredit">
                <div class="flex flex-col gap-2">
                    <label for="attribute" class="text-lg font-bold">Nom</label>
                    <input value="<c:out value="${client.nom}"/>" type="text" name="attribute" placeholder="Nom"
                           class="w-full border-2 border-gray-300 p-2 rounded-lg focus:outline-none focus:border-[#7E52A0]">
                </div>
                <div class="flex flex-col gap-2">
                    <label for="attribute" class="text-lg font-bold">Prenom</label>
                    <input type="text" value="<c:out value="${client.prenom}"/>" name="attribute" placeholder="Prenom"
                           class="w-full border-2 border-gray-300 p-2 rounded-lg focus:outline-none focus:border-[#7E52A0]">
                </div>
                <div>
                    <label for="attribute" class="text-lg font-bold">Date de Naissance</label>
                    <input type="text" value="<c:out value="${client.datenaissance}"/>" name="attribute" placeholder="birth"
                           class="w-full border-2 border-gray-300 p-2 rounded-lg focus:outline-none focus:border-[#7E52A0]">
                </div>
                <div>
                    <label for="attribute" class="text-lg font-bold">Adresse</label>
                    <input type="text"  value="<c:out value="${client.adresse}"/>" name="attribute" placeholder="Adresse"
                           class="w-full border-2 border-gray-300 p-2 rounded-lg focus:outline-none focus:border-[#7E52A0]">
                </div>
                <div class="mt-4">
                    <label for=""> Avez vous un crédit en cours ?</label>
                    <div class="flex gap-4">
                        <div>
                            <input type="radio" name="attribute" >
                            <label for="">Oui</label>
                        </div>
                        <div>
                            <input type="radio" name="attribute" >
                            <label for="">Non</label>
                        </div>
                    </div>
                </div>
                <div class="flex gap-8 mt-4">
                    <div>
                        <input type="checkbox" name="attribute" >
                        <label for="">J'ai lu et j'accepte les conditions générales d'utilisation figurant sur les informations légales, notamment la mention relative à la protection des données personnelles</label>
                    </div>
                </div>
                <input type="hidden" name="simulation" id="simulation" />
                <input type="hidden" name="mois" id="duree" />
                <input type="hidden" name="montant" id="montant" />
                <button type="submit" class=" mt-8 mx-[40%] bg-[#7E52A0] text-white font-bold p-2 rounded-full hover:bg-[#29274C] text-white font-bold py-4 px-6">
                    valider
                </button>
            </form>
        </div>
    </div>
    <div class="m-12 shadow-lg w-1/4  rounded-lg h-fit text-center">
        <h1 class="text-2xl font-bold ">Mon récapitulatif</h1>
        <div class="bg-gray-100 mt-4 h-[2rem]">
            Mon projet
        </div>
        <div class="flex justify-between px-4 py-2">
            <p class="text-yellow-500 font-bold">Prêt Personnel</p>
            <p></p>
        </div>
        <div class="bg-gray-100 mt-4 h-[2rem] ">
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
                <p class="text-yellow-500 font-bold" id="montantV"> DH</p>
            </div>
            <hr>
            <div class=" flex justify-between p-4">
                <p>Durée:</p>
                <p class="text-yellow-500 font-bold " id="monthV">mois</p>
            </div>
            <div class=" flex justify-between p-4">
                <p>Mensualité:</p>
                <p class="text-yellow-500 font-bold " id="mensualiteV">DH</p>
            </div>
            <hr>
        </div>

    </div>
</section>

</body>
<script src="main.js"></script>
</html>
<script>
    document.getElementById('simulation').value = localStorage.getItem('simulation')
    document.getElementById('duree').value = localStorage.getItem('duree')
    document.getElementById('montant').value = localStorage.getItem('montant')
    document.getElementById('montantV').innerHTML = localStorage.getItem('montant') + ' DH';
    document.getElementById('monthV').innerHTML = localStorage.getItem('duree') + ' mois';
    document.getElementById('mensualiteV').innerHTML = localStorage.getItem('simulation') + ' DH';
</script>
```
