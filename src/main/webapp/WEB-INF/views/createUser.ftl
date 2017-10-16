<#import "/spring.ftl" as spring/>

<div class="container">
    <form action="/users" method="post" id="registrationForm" name="addUser">

        <label for="name">First Name</label>
        <input type="text" name="name" id="name" placeholder="name"/>

        <label for="surname">Last Name</label>
        <input type="text" name="surname" id="name" placeholder="surname"/>

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


        <button type="submit">Register</button>
    </form>
</div>