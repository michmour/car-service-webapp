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

                    <form action="/admin/vehicles" method="post" id="userForm" name="addVehicle">

                        <div class="form-group">
                            <label for="vehiclemodel">Vehicle Model</label>
                            <input type="text" class="form-control" name="vehiclemodel" id="vehiclemodel" placeholder="Vehicle Model"/>
                        </div>


                        <div class="form-group">
                            <label for="colour">Colour</label>
                            <input type="text" class="form-control" name="colour" id="colour" placeholder="Vehicle Colour"/>
                        </div>


                        <div class="form-group">
                            <label for="platenumber">Plate Number</label>
                            <input type="text" class="form-control" name="platenumber" id="platenumber" placeholder="Plate Number"/>
                        </div>

                        <div class="form-group">
                            <label for="year">Model Year</label>
                            <input type="text" class="form-control" name="year" id="year" placeholder="Enter Year"/>
                        </div>


                    <#if usersList??>
                        <label for="userelid">Select User</label>


                        <select name="userelid">

                            <#list usersList as userValues>
                                <option value="${userValues.userid}">${userValues.name}</option>
                            </#list>

                        </select>

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
