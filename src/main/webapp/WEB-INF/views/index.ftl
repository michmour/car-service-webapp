<#import "/index.ftl" as spring/>
<html>

<body>
   <table>
<#if users??>
     <tr>
       <th>ID</th>
       <th>Name</th>
     </tr>
     <#list users as user>
       <tr>
         <td>${user.userid}</td>
         <td>${user.name}</td>
       </tr>
     </#list>
     </#if>
   </table>


</body>
</html>