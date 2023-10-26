<%--
  Created by IntelliJ IDEA.
  User: adm
  Date: 21/10/2023
  Time: 17:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://cdn.tailwindcss.com"></script>
    <title>Login</title>
</head>

<body>
<nav class="flex justify-between  top-0 w-full p-[30px] items-center shadow-2xl drop-shadow-lg">
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
        <a href="#"
           class=" underline underline-offset-2 text-[#7E52A0] text-xl font-semibold max-md:w-full text-center max-md:my-2">Home</a>
        <a href="/simuler"
           class="hover:text-[#7E52A0] text-xl font-semibold max-md:w-full text-center max-md:my-2 hover:underline hover:underline-offset-2">Simulation</a>
        <a href="#gallerie"
           class="hover:text-[#7E52A0] text-xl font-semibold max-md:w-full text-center max-md:my-2 hover:underline hover:underline-offset-2">Contact</a>
    </ul>
    <div></div>

</nav>
<section class="py-16">
    <h1 class="text-4xl font-bold text-center  ">Login to the Sing in page </h1>
    <div class=" py-6 flex flex-col justify-center sm:py-12 mt-16  ">
        <div class="relative py-3 sm:max-w-xl sm:mx-auto">
            <div
                    class="absolute inset-0 bg-gradient-to-r from-[#7E52A0] to-[#29274C] shadow-lg transform -skew-y-6 sm:skew-y-0 sm:-rotate-6 sm:rounded-3xl">
            </div>
            <div class="relative px-4 py-10 bg-white shadow-lg sm:rounded-3xl sm:p-20">
                <div class="max-w-md mx-auto">
                    <div>
                        <h1 class="text-2xl font-semibold">Login </h1>
                    </div>
                    <div class="divide-y divide-gray-200">
                        <form class="py-8 text-base leading-6 space-y-4 text-gray-700 sm:text-lg sm:leading-7" action="/signin" method="post">
                            <div class="relative">
                                <input autocomplete="off" id="email" name="email" type="text" class="peer placeholder-transparent h-10 w-full border-b-2 border-gray-300 text-gray-900 focus:outline-none focus:borer-rose-600" placeholder="Email address" />
                                <label for="email" class="absolute left-0 -top-3.5 text-gray-600 text-sm peer-placeholder-shown:text-base peer-placeholder-shown:text-gray-440 peer-placeholder-shown:top-2 transition-all peer-focus:-top-3.5 peer-focus:text-gray-600 peer-focus:text-sm">Email Address</label>
                            </div>
                            <div class="relative">
                                <input autocomplete="off" id="password" name="matricule" type="password" class="peer placeholder-transparent h-10 w-full border-b-2 border-gray-300 text-gray-900 focus:outline-none focus:borer-rose-600" placeholder="Password" />
                                <label for="password" class="absolute left-0 -top-3.5 text-gray-600 text-sm peer-placeholder-shown:text-base peer-placeholder-shown:text-gray-440 peer-placeholder-shown:top-2 transition-all peer-focus:-top-3.5 peer-focus:text-gray-600 peer-focus:text-sm">Matricule</label>
                            </div>
                            <div class="relative">
                                <button class="bg-[#7E52A0] text-white rounded-md px-2 py-1">Submit</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
</body>
</html>
