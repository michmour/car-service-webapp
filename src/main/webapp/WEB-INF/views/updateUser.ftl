<#import "/spring.ftl" as spring/>

<div class="container">

    <form action="/users/${userForm.userid}" method="post"
       id= "userForm" name="updateUser">


        <label for="name">First Name</label>
        <input type="text" name="name" id="name" value="${userForm.name}" placeholder="name"/>

        <label for="surname">Last Name</label>
        <input type="text" name="surname" id="name"  value="${userForm.surname}" placeholder="surname"/>

        <label for="email">Email</label>
        <input type="email" name="email" id="email" value="${userForm.email}" placeholder="email"/>

        <label for="password">Password</label>
        <input type="password" name="password" id="password" value="${userForm.password}" placeholder="password"/>

        <label for="ssn">Ssn</label>
        <input type="text" name="ssn" id="ssn" value="${userForm.ssn}" placeholder="ssn"/>

        <label for="address">Address</label>
        <input type="text" name="address" id="address" value="${userForm.address}" placeholder="address"/>

        <input type="hidden" name="usertype" value="${userForm.usertype}"/>

                <input type="hidden" name="userid" value="${userForm.userid}"/>



        <button type="submit">Edit</button>
    </form>
</div>