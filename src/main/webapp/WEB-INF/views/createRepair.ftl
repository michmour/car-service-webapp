<#import "/spring.ftl" as spring/>

<div class="container">
    <form action="/repairs" method="post" id="repairForm" name="addRepair">

        <label for="servicedate">Service Date</label>
        <input type="datetime-local" name="servicedate" id="servicedate"/>

        <label for="status">Status</label>
        <select name="status">
                  <option value="1">PENDING</option>
                  <option value="2">IN PROGRESS</option>
                  <option value="3">COMPLETED</option>
        </select>

        <label for="type">Type</label>
        <select name="type">
                         <option value="1">SMALL</option>
                         <option value="2">BIG</option>
        </select>

        <label for="servicecost">Service Cost</label>
        <input type="text" name="servicecost" id="servicecost" placeholder="servicecost"/>

        <#if usersList??>
        <label for="userelid">Select User</label>


        <select name="userelid">

        <#list usersList as userValues>
         <option value="${userValues.userid}">${userValues.name}</option>
        </#list>

        </select>

        </#if>
        <label for="details">Details</label>
        <input type="text" name="details" id="details" placeholder="details"/>

        <button type="submit">Register</button>
    </form>
</div>