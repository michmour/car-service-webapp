<#import "/spring.ftl" as spring/>

<div class="container">

    <form action="/users/update" method="post"
       id= "registrationForm" name="updateUser">


        <label for="name">First Name</label>
        <input type="text" name="name" id="name" value="${registrationForm.name}" placeholder="name"/>

        <label for="surname">Last Name</label>
        <input type="text" name="surname" id="name"  value=${"surname"} placeholder="surname"/>

        <label for="email">Email</label>
        <input type="email" name="email" id="email" placeholder="email"/>

        <label for="password">Password</label>
        <input type="password" name="password" id="password" placeholder="password"/>

        <label for="ssn">Ssn</label>
        <input type="text" name="ssn" id="ssn" placeholder="ssn"/>

        <label for="address">Address</label>
        <input type="text" name="address" id="address" placeholder="address"/>

        <label for="usertype">Usertype</label>
        <input type="text" name="usertype" id="usertype" placeholder="usertype"/>

        <input type="hidden" name="userid" value="${registrationForm.userid}"/>

        <button type="submit">Edit</button>
    </form>
</div>