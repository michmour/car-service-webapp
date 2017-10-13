<#import "/spring.ftl" as spring/>

<h2>${message!""}</h2>
<h2>${errorMessage!""}</h2>


<div class="container">
    <form action="/register" method="post" id="registrationForm" name="registrationForm">

    <#--bind this field with the registration form fields-->
    <@spring.bind "registrationForm.firstname"/>
        <label for="firstname">First Name</label>
        <input type="text" name="firstname" id="firstname" placeholder="firstname"/>
    <#--dispay validation error message here for this field-->
    <#list spring.status.errorMessages as error>
        <span>${error}</span>
    </#list>

    <@spring.bind "registrationForm.lastname"/>
        <label for="lastname">Last Name</label>
        <input type="text" name="lastname" id="lastname" placeholder="lastname"/>
    <#list spring.status.errorMessages as error>
        <span>${error}</span>
    </#list>

    <@spring.bind "registrationForm.email"/>
        <label for="email">Email</label>
        <input type="email" name="email" id="email" placeholder="email"/>
    <#list spring.status.errorMessages as error>
        <span>${error}</span>
    </#list>

    <@spring.bind "registrationForm.username"/>
        <label for="username">Username</label>
        <input type="text" name="username" id="username" placeholder="username"/>
    <#list spring.status.errorMessages as error>
        <span>${error}</span>
    </#list>

    <@spring.bind "registrationForm.password"/>
        <label for="password">Password</label>
        <input type="password" name="password" id="password" placeholder="password"/>
    <#list spring.status.errorMessages as error>
        <span>${error}</span>
    </#list>
        <button type="submit">Register</button>
    </form>
</div>


