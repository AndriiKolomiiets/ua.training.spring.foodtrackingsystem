
<#import 'parts/common.ftl' as c>
<#import 'parts/footer.ftl' as f>

<@c.page>

<h1>Welcome!</h1>

<p>Click <a href="@{/hello}">here</a> to see a greeting.</p>

    <@f.footer date="2019" project="Food Tracking System"/>
    <p>${f.pack}</p>
</@c.page>