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
           <form action="/users/${user.userid}/delete" method="post" name="deleteUser">
               <input type="hidden" name="userid" value="${user.userid}"/>
           <td><button type="submit">Delete</button></td>
           </form>
       </tr>
     </#list>
     </#if>
   </table>


</body>
</html>