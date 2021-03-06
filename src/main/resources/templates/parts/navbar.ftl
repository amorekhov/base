<#include "security.ftl">
<#import "login.ftl" as l>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="/">Travel</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">

            <li class="nav-item">
                <a class="nav-link" href="/">Home </a>
            </li>

            <li class="nav-item">
                <a class="nav-link" href="/order">Order </a>
            </li>

            <li class="nav-item">
                <a class="nav-link" href="/order/${currentUserId}">My orders </a>
            </li>

            <li class="nav-item">
                <a class="nav-link" href="/travelall">Travel </a>
            </li>

            <li class="nav-item">
                <a class="nav-link" href="/user">User </a>
            </li>

        </ul>

        <div class="navbar-text mr-3">${name}</div>

        <@l.logout />
    </div>
</nav>