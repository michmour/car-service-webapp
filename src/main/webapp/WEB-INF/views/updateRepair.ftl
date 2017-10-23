<#import "/spring.ftl" as spring/>

<div class="container">
    <form action="/repairs/${repairForm.serviceid}" method="post" id="repairEditForm" name="repairEditForm">

        <label for="servicedate">Service Date</label>
        <input type="datetime-local" name="servicedate" id="servicedate" value="${repairForm.servicedate}"/>

        <label for="status">Status</label>
        <select name="status">
        <option value="${repairForm.status}" selected>

        </option>
            <option value="PENDING" <#if repairForm.type=="PENDING">selected</#if>>PENDING</option>
            <option value="IN PROGRESS" <#if repairForm.type=="IN PROGRESS">selected</#if>>IN PROGRESS</option>
            <option value="COMPLETED" <#if repairForm.type=="COMPLETED">selected</#if>>COMPLETED</option>
        </select>

        <label for="type">Type</label>
        <select name="type">
        	<option value="SMALL" <#if repairForm.type=="SMALL">selected</#if>>SMALL</option>
        	<option value="BIG" <#if repairForm.type=="BIG">selected</#if>>BIG</option>
        </select>

        <label for="servicecost">Service Cost</label>
        <input type="number" name="servicecost" id="servicecost" value="${repairForm.servicecost}" placeholder="servicecost"/>

                        <input type="hidden" name="serviceid" value="${repairForm.serviceid}"/>


        <label for="details">Details</label>
        <input type="text" name="details" id="details" value="${repairForm.details}" placeholder="details"/>

        <button type="submit">Register</button>
    </form>
</div>