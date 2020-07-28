<#import "parts/common.ftl" as c>

<@c.page "none">
    <div>
        <form method="post" action="/order/show">
            <h3 style="color: #1e90ff">Редактирование заказа</h3>
            <table style="margin-top: 20px">
                <thead align="center">
                <tr>
                    <th scope="col">Время начала</th>
                    <th scope="col">Время окончания</th>
                    <th scope="col">Сумма</th>
                    <th scope="col">Клиент</th>
                    <th scope="col">Назначить мастера</th>
                    <th scope="col">Статус</th>
                </tr>
                <tr align="center">
                    <th><input class="form-control" disabled name="timestart" value="${orders.timestart}"></th>
                    <th><input class="form-control" name="timefinish" value="${orders.timefinish}"></th>
                    <th><input class="form-control" type="number" name="amount" value="${orders.amount}"></th>
                    <th><input class="form-control" disabled name="id_user" value="${orders.id}"></th>
                    <th>
                        <form>
                            <label>
                                <select class="combo-box" name="idmaster">
                                    <option value="default">${orders.idmaster}</option>
                                    <#list masters as master>
                                        <option name="mast">${master.idmaster}</option>
                                    </#list>
                                </select>
                            </label>
                        </form>
                    </th>
                    <th><input class="form-control" type="text" name="status" value="${orders.status}"></th>
                </tr>
                </thead>
            </table>
            <input type="hidden" value="${orders.idorder}" name="idorder">
            <input type="hidden" value="${_csrf.token}" name="_csrf">
            <button type="submit" class="btn btn-secondary">Сохранить</button>
        </form>
    </div>
</@c.page>