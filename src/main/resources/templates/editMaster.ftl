<#import "parts/common.ftl" as c>

<@c.page "none">
    <div>
        <form method="post" action="/master/show">
            <h3 style="color: #1e90ff">Редактирование мастера</h3>
            <table style="margin-top: 20px">
                <thead align="center">
                <tr>
                    <th scope="col">ФИО</th>
                    <th scope="col">Дата рождения</th>
                    <th scope="col">Категория</th>
                    <th scope="col">Профиль</th>
                    <th scope="col">Год начала работы</th>
                </tr>
                <tr align="center">
                    <th><input class="form-control" type="text" name="fIO" value="${master.fIO}"></th>
                    <th><input class="form-control" type="date" name="date_of_birth" value="${master.date_of_birth}">
                    </th>
                    <th><input class="form-control" type="number" name="category" value="${master.category}"></th>
                    <th><input class="form-control" type="number" name="profile" value="${master.profile}"></th>
                    <th><input class="form-control" type="text" maxlength="4" name="year_start_working"
                               value="${master.year_start_working}"></th>
                </tr>
                </thead>
            </table>
            <input type="hidden" value="${master.idmaster}" name="idmaster">
            <input type="hidden" value="${_csrf.token}" name="_csrf">
            <button type="submit" class="btn btn-secondary">Изменить</button>
        </form>
    </div>
</@c.page>