<#assign
known = Session.SPRING_SECURITY_CONTEXT??
>

<#if known>
    <#assign
    user = Session.SPRING_SECURITY_CONTEXT.authentication.principal
    name = user.getUsername()
    id = user.getId()
    isAdmin = user.getAuthorities()?seq_contains('ADMIN')
    isWorker = user.getAuthorities()?seq_contains('WORKER')
    user_auth = true
    >
<#else>
    <#assign
    name = "unknown"
    isAdmin = false
    isWorker = false
    user_auth = false
    >
</#if>