<#include "security.ftl">
<#import "login.ftl" as l>

<nav class="navbar navbar-expand-lg navbar-light" style="background-color: #ccfff7;">
    <a class="navbar-brand" href="/">СТО</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <#if isAdmin>
                <li class="nav-item">
                    <a class="nav-link" href="/master">Мастера</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/user">Пользователи</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/service">Услуги</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/order">Заказы</a>
                </li>
            </#if>
            <#if name != "unknown" && !isAdmin && !isWorker>
                <div class="mr-3">
                    <form method="get" action="/registerOnService">
                        <input type="hidden" name="id_user" value="${id}">
                        <button class="btn btn-info" type="submit"> Запись</button>
                    </form>
                </div>
                <div>
                    <form method="get" action="/myOrders">
                        <input type="hidden" name="id_user" value="${id}">
                        <button class="btn btn-info" type="submit"> История обслуживания</button>
                    </form>
                </div>
            </#if>
            <#if isWorker>
                <li class="nav-item">
                    <a class="nav-link" href="/order">Просмотр графика</a>
                </li>
            </#if>
            <li class="nav-item">
                <a class="nav-link" href="/about">О нас</a>
            </li>
        </ul>


        <#if name == "unknown">
            <a href="/login"> Войти </a>
        <#else>
            <div class="nav-item mr-4">
                <form method="get" action="/carlist">
                    <input type="hidden" name="id" value="${id}">
                    <button class="btn btn-primary" type="submit"> Мои машины</button>
                </form>
            </div>
            <div class="mr-4">${name}</div>
            <@l.logout />
        </#if>

    </div>
</nav>