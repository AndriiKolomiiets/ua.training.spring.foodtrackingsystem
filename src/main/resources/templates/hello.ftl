<#import 'parts/common.ftl' as c>
<#import "parts/login.ftl" as l>
<#import 'parts/footer.ftl' as f>
<#import 'parts/header.ftl' as h>
<@c.page>

<div>Welcome to Food Tracking System!</div>
<br>
    <@l.logout/>
<@h.menu/>

<div> Always happy to see you, ${username}</div>



<p>Click <a href="${springMacroRequestContext.getContextPath()}/hello">here</a> to see a greeting.</p>
<p><a href="/login">LOGIN</a></p>

    <@f.footer date="2019" project="Food Tracking System"/>
    <p>${f.pack}</p>
</@c.page>
