<#import 'parts/common.ftl' as c>
<#import "parts/login.ftl" as l>
<#import 'parts/footer.ftl' as f>
<@c.page>

<div>Welcome to Food Tracking System!</div>

<ul>
    <li><a href="${springMacroRequestContext.getContextPath()}/hello">Home</a></li>
    <li style="float:right"><a href="${springMacroRequestContext.getContextPath()}/userSettings">User Settings</a></li>
    <li><a href="food_tracking.jsp">Food Tracking</a></li>
    <li><a href="statistic.jsp">Statistic</a></li>
</ul>
<br>

<div> Always happy to see you, ${username}</div>

    <@l.logout/>

<p>Click <a href="${springMacroRequestContext.getContextPath()}/hello">here</a> to see a greeting.</p>
<p><a href="/login">LOGIN</a></p>

    <@f.footer date="2019" project="Food Tracking System"/>
    <p>${f.pack}</p>
</@c.page>
