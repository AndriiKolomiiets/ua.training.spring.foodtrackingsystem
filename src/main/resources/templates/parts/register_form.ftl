<#macro register path>

    <form action="${path}" method="post">
        <div><label> Login : <input type="text" name="username"/> </label>
        <#if usernameError??>
                <div class="invalid-feedback">
                    ${usernameError}
                </div>
        </#if></div>

        <div><label> Password: <input type="password" name="password"/> </label>
        <#if passwordError??>
                <div class="invalid-feedback">
                    ${passwordError}
                </div>
        </#if></div>

        <div><label> Password: <input type="password" name="password2"/> </label>
        <#if password2Error??>
                    <div class="invalid-feedback">
                        ${password2Error}
                    </div>
        </#if></div>

        <div><label> Email: <input type="text" name="email"/></label>
        <#if emailError??>
                    <div class="invalid-feedback">
                        ${emailError}
                    </div>
        </#if></div>
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <div><input type="submit" class="button" value="Register"/></div>
    </form>
</#macro>