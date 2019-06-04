<#import "../parts/common.ftl" as c>
<#import '../parts/footer.ftl' as f>
<@c.page>

    <h2> List of Users</h2>
<table>
    <thead>
    <tr>
        <th>Name</th>
        <th>Role</th>
        <th></th>
    </tr>
    </thead>

    <tr>
        <td>${username}</td>
    <td>${roles}</td>
    <td><a href="/user/<#--${user.id}-->">edit</a></td>
</tr>
</table>
<#--<table>
    <thead>
    <tr>
        <th>Name</th>
        <th>Role</th>
        <th></th>
    </tr>
    </thead>
    <#list users as user>
    <tr>
        <td>${user.username}</td>
    <td>#list user.roles as role>${role}<#sep>, </#list></td>
    <td><a href="/user/${user.id}">edit</a></td>
</tr>
</table>-->

    <@f.footer date="2019" project="Food Tracking System"/>
    <p>${f.pack}</p>
</@c.page>