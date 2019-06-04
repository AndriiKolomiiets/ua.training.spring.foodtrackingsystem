
<#import 'parts/common.ftl' as c>
<#import 'parts/footer.ftl' as f>

<@c.page>

<h1>Welcome!</h1>
<p>Click <a href="${springMacroRequestContext.getContextPath()}/hello">here</a> to see a greeting.</p>
<p><a href="/login">LOGIN</a></p>

    <@f.footer date="2019" project="Food Tracking System"/>
</@c.page>