<#import "/index.ftl" as spring/>
<html>

<body>
   <table>
<h1> ${msg!""}</h1>
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
           <td> <a href="/users/${user.userid}/delete">Delete</a></td>
       </tr>
     </#list>
     </#if>
   </table>


</body>
</html>