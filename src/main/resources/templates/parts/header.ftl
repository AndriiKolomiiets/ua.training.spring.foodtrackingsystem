//Menu + Language + LogOut
<#macro menu >
 <form action="/logout" method="post">
     <input type="hidden" name="_csrf" value="${_csrf.token}" />
     <input type="submit" class="header_button" value="Sign Out"/>
 </form>
<br>

<ul>
    <li><a href="${springMacroRequestContext.getContextPath()}foodTracking">food.tracking.title</a></li>
    <li style="float:right"><a href="${springMacroRequestContext.getContextPath()}userSettings">User Settings</a></li>
    <li><a href="${springMacroRequestContext.getContextPath()}dayMeal">Day Meal</a></li>
    <li><a href="${springMacroRequestContext.getContextPath()}mealStatistic">Statistic</a></li>
    <li><a href="${springMacroRequestContext.getContextPath()}userManagement">User Management</a></li>
</ul>
<br>

 <div class = "mr-2">
     <select id="locales" class="language" >
         <option value=""><#--${rc.getMessage("page.language")}--></option>
         <option value="IE">EN</option>
         <option value="UA">UA</option>
     </select>
 </div>
</#macro>

