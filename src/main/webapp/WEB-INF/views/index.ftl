<#import "/index.ftl" as spring/>
<html>

<body>
   <table>
<#if users??>
     <tr>
       <th>ID</th>
       <th>Name</th>
        <th>Action</th>
     </tr>
     <#list users as user>
       <tr>
         <td>${user.userid}</td>
         <td>${user.name}</td>
         <td>${user.surname}</td>
        <td> <a href="/users/${user.userid}/edit">Edit</a></td>
       </tr>
     </#list>
     </#if>
   </table>


</body>
</html>