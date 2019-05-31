<#macro login path>
<#--<div <#if==${param.error}>
    Invalid username and password.
</div>
<div <#if="${param.logout}">
    You have been logged out.
</div>-->
    <form action="${path}" method="post">
        <div><label> Login : <input type="text" name="username"/> </label></div>
        <div><label> Password: <input type="password" name="password"/> </label></div>
        <#--<input type="hidden" name="_csrf" value="{_csrf.token}"/>-->
        <div><input type="submit" value="Sign In"/></div>
    </form>
</#macro>