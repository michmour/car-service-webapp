<script>
    document.title = 'CS - Add Vehicle';
</script>

<#include "/includes/header.ftl">
<div id="wrapper">
<#include "/includes/admin_navigation.ftl">
    <div id="page-wrapper">

        <div class="container-fluid">

            <!-- Page Heading -->
            <div class="row">
                <div class="col-lg-12">

                    <h1 class="page-header">
                        Add Vehicle
                    </h1>

                <#if errorMessage ??>
                    <p id= "flash-message-id" class="alert alert-danger">${errorMessage }</p>
                </#if>

                    <form action="/admin/vehicles" method="post" id="userForm" name="addVehicle">

                        <div class="form-group">
                             <label for="vehiclemodel">Model</label>
                             <@spring.formSingleSelect path="vehicleForm.vehiclemodel" options=vehicleBrandsList attributes='class="form-control"'/>
                        </div>


                        <div class="form-group">
                            <label for="colour">Colour</label>
                            <input type="text" pattern="^[a-zA-Z ]*$" class="form-control" name="colour" id="colour" placeholder="Vehicle Colour"/>
                        </div>


                        <div class="form-group">
                            <label for="platenumber">Plate Number</label>
                            <input type="text" pattern="^([A-Z]{3})-\d{4}$" class="form-control" name="platenumber" id="platenumber" placeholder="Plate Number"/>
                        </div>

                        <div class="form-group">
                            <label for="year">Model Year</label>
                            <input type="text" pattern="^[0-9]{4}$" class="form-control" name="year" id="year" placeholder="Enter Year"/>
                        </div>


                    <#if usersList??>
                    <div class="form-group">
                        <label for="userelid">Select User</label>


                        <select name="userelid" class="form-control">

                            <#list usersList as userValues>
                                <option value="${userValues.userid}">${userValues.name} ${userValues.surname}</option>
                            </#list>

                        </select>
                        </div>

                    </#if>


                        <div class="form-group">
                            <input type="submit" class="btn btn-primary" value="Add Vehicle">
                        </div>

                    </form>


                </div>
            </div>
            <!-- /.row -->

        </div>
        <!-- /.container-fluid -->

    </div>
    <!-- /#page-wrapper -->




<#include "/includes/footer.ftl">
