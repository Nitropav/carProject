<#include "parts/security.ftl">
<#import "parts/common.ftl" as c>

<@c.page "none">
    <#if isAdmin>
        <form method="post" action="/order/filter">
            <input type="hidden" name="_csrf" value="${_csrf.token}">
            <h3 style="color: #1e90ff">Поиск заказов по статусу</h3>
            <input type="text" name="filter">
            <button class="btn btn-outline-primary" type="submit">Поиск</button>
        </form>
    </#if>

    <div class="wrapper">
        <form method="post" action="/order">
            <input type="hidden" name="_csrf" value="${_csrf.token}">
            <div style="padding-top: 57px">
                <table class="table table-bordered">
                    <thead>
                    <tr>
                        <th scope="col">Время начала</th>
                        <th scope="col">Время окончания</th>
                        <th scope="col">Сумма</th>
                        <#if isAdmin>
                        <th scope="col">Клиент</th>
                        </#if>>
                        <th scope="col">Мастер</th>
                        <th scope="col">Статус</th>
                        <#if isAdmin>
                            <th scope="col" width="100">Редактирование</th>
                        <#else>
                            <th scope="col">Отказ</th>
                        </#if>
                    </tr>
                    </thead>
                    <tbody>
                    <#list orders as orders>
                        <tr>
                            <td>${orders.timestart}</td>
                            <td>${orders.timefinish}</td>
                            <td>${orders.amount}</td>
                            <#if isAdmin>
                                <td>${orders.id}</td>
                            </#if>
                            <td>${orders.idmaster.fIO}</td>
                            <td>${orders.status}</td>
                            <#if isAdmin>
                                <td>
                                    <form method="get" action="/order/${orders.idorder}">
                                        <button type="submit" class="btn btn-secondary">Изменить</button>
                                    </form>
                                </td>
                            <#else>
                                <#if orders.status != "Закрыт">
                                    <td>
                                        <form method="get" action="/myOrders">
                                            <input type="hidden" name="action" value="del">
                                            <input type="hidden" name="id_user" value="${id}">
                                            <input type="hidden" name="order" value="${orders.idorder}">
                                            <button type="submit" class="btn btn-danger">Отказаться</button>
                                        </form>
                                    </td>
                                <#else>
                                    <td>
                                        <form method="get" action="/myOrders/${orders.idorder}">
                                            <button type="submit" class="btn btn-secondary disable">Отказаться</button>
                                        </form>
                                    </td>
                                </#if>
                            </#if>
                        </tr>
                    </#list>
                    </tbody>
                </table>
            </div>
        </form>
    </div>
</@c.page>