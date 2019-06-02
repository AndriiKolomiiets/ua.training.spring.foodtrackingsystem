<#macro register path>
    <form action="${path}" method="post">
        <div><label> Login : <input type="text" name="username"/> </label></div>
        <div><label> Password: <input type="password" name="password"/> </label></div>
        <div><label> Email: <input type="text" name="email" /></label></div>
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <div><input type="submit" value="Register"/></div>
    </form>
</#macro>