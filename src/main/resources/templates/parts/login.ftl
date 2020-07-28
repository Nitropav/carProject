<#macro login path isRegister>
    <form action="${path}" method="post">
        <div><label> model.User Name : <input type="text" name="username"/> </label></div>
        <div><label> Password: <input type="password" name="password"/> </label></div>
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <button class="btn btn-primary" type="submit"><#if isRegister>Create<#else>Sign In</#if></button>
    </form>
</#macro>

<#macro logout>
    <form action="/logout" method="post">
        <button class="btn btn-primary" style="background-color: darkred" type="submit">Sign Out</button>
        <input type="hidden" name="_csrf" value="${_csrf.token}">
    </form>
</#macro>