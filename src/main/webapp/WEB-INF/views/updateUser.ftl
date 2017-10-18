<#import "/spring.ftl" as spring/>

<div class="container">

    <form action="/users/${registrationForm.userid}" method="post"
       id= "registrationForm" name="updateUser">


        <label for="name">First Name</label>
        <input type="text" name="name" id="name" value="${registrationForm.name}" placeholder="name"/>

        <label for="surname">Last Name</label>
        <input type="text" name="surname" id="name"  value="${registrationForm.surname}" placeholder="surname"/>

        <label for="email">Email</label>
        <input type="email" name="email" id="email" value="${registrationForm.email}" placeholder="email"/>

        <label for="password">Password</label>
        <input type="password" name="password" id="password" value="${registrationForm.password}" placeholder="password"/>

        <label for="ssn">Ssn</label>
        <input type="text" name="ssn" id="ssn" value="${registrationForm.ssn}" placeholder="ssn"/>

        <label for="address">Address</label>
        <input type="text" name="address" id="address" value="${registrationForm.address}" placeholder="address"/>

        <input type="hidden" name="usertype" value="${registrationForm.usertype}"/>

                <input type="hidden" name="userid" value="${registrationForm.userid}"/>



        <button type="submit">Edit</button>
    </form>
</div>