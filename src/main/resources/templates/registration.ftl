
<#import "parts/common.ftl" as c>
<#import  "parts/register_form.ftl" as r>
<@c.page>
<h2>Add new user</h2>
    ${message?ifExists}
    <@r.register "/registration" />
</@c.page>