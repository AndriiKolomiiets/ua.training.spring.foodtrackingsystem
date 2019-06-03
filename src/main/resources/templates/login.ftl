
<#import 'parts/common.ftl' as c>
<#import 'parts/footer.ftl' as f>
<#import "parts/login.ftl" as l>
<@c.page>
<#--<div th:if="${param.error}">
    Invalid username and password.
</div>
<div th:if="${param.logout}">
    You have been logged out.
</div>-->
    <#if logout>
                    <div class="alert alert-info" role="alert">You've been logged out successfully.</div>
    </#if>
    <#if error>
                    <div class="alert alert-danger" role="alert">Invalid Username or Password!</div>
    </#if>
<h1>Login page!</h1>
<@l.login "/login"/>

    <@f.footer date="2019" project="Food Tracking System"/>
    <p>${f.pack}</p>
</@c.page>


<#--
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="https://www.thymeleaf.org"
      xmlns:sec="https://www.thymeleaf.org/thymeleaf-extras-springsecurity3">
<head>
    <title>Spring Security Example </title>
    <#import "/templates/.templates/ftl/footer.ftl" as f>
</head>
<body>
<div th:if="${param.error}">
    Invalid username and password.
</div>
<div th:if="${param.logout}">
    You have been logged out.
</div>
<form th:action="@{/login}" method="post">
    <div><label> User Name : <input type="text" name="username"/> </label></div>
    <div><label> Password: <input type="password" name="password"/> </label></div>
    <div><input type="submit" value="Sign In"/></div>
</form>


<@f.footer date="2019"/>
${f.package}
</body>
</html>-->
