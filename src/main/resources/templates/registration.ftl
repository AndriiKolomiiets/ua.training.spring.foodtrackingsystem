
<#import "parts/common.ftl" as c>
<#--<#import  "parts/register_form.ftl" as r>-->
<#import "parts/register_form.ftl" as r>
<#import 'parts/footer.ftl' as f>
<@c.page>
<h2>Add new user</h2>
    ${message?ifExists}
    <#--<#if error>
                    <div class="alert alert-danger" role="alert">Invalid Username or Password!</div>
    </#if>-->
    <@r.register "/registration" />
<#--registration-->


    <@f.footer date="2019" project="Food Tracking System"/>
</@c.page>