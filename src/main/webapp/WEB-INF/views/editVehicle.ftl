<script>
    document.title = 'CS - Edit Vehicle';
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
                        Edit User
                    </h1>

                    <form action="/admin/vehicles/${vehicleForm.vehicleid}" method="post"
                          id= "vehicleForm" name="updateVehicle">

                       <div class="form-group">
                            <label for="vehiclemodel">Model</label>
                            <@spring.formSingleSelect path="vehicleForm.vehiclemodel" options=vehicleBrandsList attributes='class="form-control"'/>
                       </div>

                        <div class="form-group">
                            <label for="colour">Colour</label>
                            <input type="text" class="form-control" name="colour" id="colour" value="${vehicleForm.colour}" placeholder="Vehicle Colour"/>
                        </div>

                        <div class="form-group">
                            <label for="year">Model Year</label>
                            <input type="text" class="form-control" name="year" id="year" value="${vehicleForm.year}" placeholder="Enter Year"/>
                        </div>


                        <div class="form-group">
                            <label for="platenumber">Plate Number</label>
                            <input type="text" class="form-control" name="platenumber" id="platenumber" value="${vehicleForm.platenumber}" placeholder="Plate Number"/>
                        </div>


                        <input type="hidden" name="vehicleid" value="${vehicleForm.vehicleid}"/>


                        <div class="form-group">
                            <input type="submit" class="btn btn-primary" value="Edit Vehicle">
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