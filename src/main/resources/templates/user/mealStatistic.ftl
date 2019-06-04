<#import '../parts/common.ftl' as c>
<#import "../parts/login.ftl" as l>
<#import '../parts/footer.ftl' as f>
<#import '../parts/header.ftl' as h>
<@c.page>

<div>Meal Statistic</div>
<br>
    <@l.logout/>
    <@h.menu/>

    <@f.footer date="2019" project="Food Tracking System"/>
</@c.page>