<#import 'parts/common.ftl' as c>
<#import "parts/login.ftl" as l>
<#import 'parts/footer.ftl' as f>
<#import 'parts/header.ftl' as h>
<@c.page>

<div>Page Not Found!</div>
<br>
    <@h.menu/>




<p>Click <a href="${springMacroRequestContext.getContextPath()}/main">here</a> to see a greeting.</p>


    <@f.footer date="2019" project="Food Tracking System"/>

</@c.page>