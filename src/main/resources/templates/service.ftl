<#import "parts/common.ftl" as c>

<@c.page "none">
    <div>
        <form method="post">
            <input type="hidden" name="_csrf" value="${_csrf.token}">
            <h3 style="color: #1e90ff">Добаление услуги</h3>
            <input type="text" name="name" placeholder="Название">
            <input type="text" name="cost" placeholder="Стоимость">
            <input type="time" name="duration" placeholder="Время">
            <button class="btn btn-outline-primary" type="submit">Добавить</button>
        </form>
    </div>
    <form method="post" action="/service/filter">
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <h3 style="color: #1e90ff">Поиск услуг по цене</h3>
        <input type="text" name="filter">
        <button class="btn btn-outline-primary" type="submit">Поиск</button>
    </form>
    <div class="wrapper">
        <form method="post">
            <input type="hidden" name="_csrf" value="${_csrf.token}">
            <div style="padding-top: 57px">
                <table class="table table-bordered">
                    <thead>
                    <tr>
                        <th scope="col">Название</th>
                        <th scope="col">Стоимость</th>
                        <th scope="col">Время</th>
                        <th scope="col" width="100">Удаление</th>
                        <th scope="col" width="100">Редактирование</th>
                    </tr>
                    </thead>
                    <tbody>
                    <#list services as service>
                        <tr>
                            <td>${service.name}</td>
                            <td>${service.cost}</td>
                            <td>${service.duration}</td>
                            <td>
                                <form method="post" action="/service/deleteService">
                                    <input type="hidden" value="${service.idservice}" name="idService">
                                    <input type="hidden" value="${_csrf.token}" name="_csrf">
                                    <button class="btn btn-danger" type="submit">Удалить</button>
                                </form>
                            </td>
                            <td>
                                <form method="get" action="/service/${service.idservice}">
                                    <button type="submit" class="btn btn-secondary">Изменить</button>
                                </form>
                            </td>
                        </tr>
                    </#list>
                    </tbody>
                </table>
            </div>
        </form>
    </div>
</@c.page>