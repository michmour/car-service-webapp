<script>
    document.title = 'CS - All Vehicles';
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
                        All Vehicles
                    </h1>

                    <#if message??>
                        <p  id= "flash-message-id" class="alert alert-success">${message}</p>
                    </#if>

                    <table class="table table-bordered table-hover">
                    <#if vehiclesList??>
                        <thead>
                        <tr>
                            <td>Vehicle ID</td>
                            <td>Colour</td>
                            <td>Plate Number</td>
                            <td>Vehicle Model </td>
                            <td>Year</td>
                            <td>User Credentials</td>
                            <td>Edit User</td>
                            <td>Delete User</td>
                        </tr>
                        </thead>
                    <tbody>
                        <#list vehiclesList as vehicle>

                        <tr>
                            <td>${vehicle.vehicleid}</td>
                            <td>${vehicle.colour}</td>
                            <td>${vehicle.platenumber}</td>
                            <td>${vehicle.vehiclemodel}</td>
                            <td>${vehicle.year}</td>
                            <td>${vehicle.userelid.name} ${vehicle.userelid.surname}</td>
                            <td><a class="btn btn-success btn-md active" role="button" href="vehicles/${vehicle.vehicleid}/edit" id="white" > Edit </a> </td>
                            <form action="vehicles/${vehicle.vehicleid}/delete" method="post" name="deleteUser" onsubmit="return confirm('We will delete this vehicle!');">
                                <input type="hidden" name="vehicleid" value="${vehicle.vehicleid}"/>
                                <td><button class="btn btn-danger" type="submit"> Delete</button></td>
                            </form>
                        </tr>
                        </#list>
                    </#if>
                    </tbody>
                    </table>

                </div>
            </div>
            <!-- /.row -->

        </div>
        <!-- /.container-fluid -->

    </div>
    <!-- /#page-wrapper -->






<#include "/includes/footer.ftl">