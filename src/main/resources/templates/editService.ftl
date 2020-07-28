<#import "parts/common.ftl" as c>

<@c.page "none">
    <div>
        <form method="post" action="/service/show">
            <h3 style="color: #1e90ff">Редактирование услуги</h3>
            <table style="margin-top: 20px">
                <thead align="center">
                <tr>
                    <th scope="col">Название</th>
                    <th scope="col">Стоимость</th>
                    <th scope="col">Время</th>
                </tr>
                <tr align="center">
                    <th><input class="form-control" type="text" name="name" value="${service.name}"></th>
                    <th><input class="form-control" type="text" name="cost" value="${service.cost}"></th>
                    <th><input class="form-control" type="time" name="duration" value="${service.duration}"></th>
                </tr>
                </thead>
            </table>
            <input type="hidden" value="${service.idservice}" name="idservice">
            <input type="hidden" value="${_csrf.token}" name="_csrf">
            <button type="submit" class="btn btn-secondary">Изменить</button>
        </form>
    </div>
</@c.page>