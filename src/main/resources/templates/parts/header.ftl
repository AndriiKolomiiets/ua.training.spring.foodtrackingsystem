//Menu + Language + LogOut
<#macro menu >
<ul>
    <li><a href="${springMacroRequestContext.getContextPath()}main">Home</a></li>
    <li style="float:right"><a href="${springMacroRequestContext.getContextPath()}settings">User Settings</a></li>
    <li><a href="${springMacroRequestContext.getContextPath()}meal-tracking">Meal Tracking</a></li>
    <li><a href="${springMacroRequestContext.getContextPath()}statistic">Statistic</a></li>
</ul>
<br>
</#macro>
<#--
<#macro list title items>
  <p>${title?cap_first}:
  <ul>
    <#list items as x>
      <li>${x?cap_first}
    </#list>
  </ul>
</#macro>
<@list items=["mouse", "elephant", "python"] title="Animals"/>-->
