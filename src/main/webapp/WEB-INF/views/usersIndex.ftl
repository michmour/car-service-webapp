<#include "/includes/header.ftl">
<div id="wrapper">
<#include "/includes/admin_navigation.ftl">
    <div id="page-wrapper">

        <div class="container-fluid">

            <!-- Page Heading -->
            <div class="row">
                <div class="col-lg-12">

                    <h1 class="page-header">
                        Welcome ${userRepairs.name} ${userRepairs.surname }
                    </h1>


                    <table class="table table-bordered table-hover">
                    <#if userRepairs??>
                        <thead>
                        <tr>
                            <td>Service ID</td>
                            <td>Details</td>
                            <td>Service Cost</td>
                            <td>Service Date</td>
                            <td>Status</td>
                            <td>Type</td>
                            <td>Edit User</td>
                            <td>Delete User</td>
                        </tr>
                        </thead>
                    <tbody>

                        <#list userRepairs.servicescollection as repair>

                        <tr>
                            <td>${repair.serviceid}</td>
                            <td>${repair.details}</td>
                            <td>${repair.servicecost}</td>
                            <td>${repair.servicedate}</td>
                            <td>${repair.status}</td>
                            <td>${repair.type}</td>
                            <td> <a href="repairs/${repair.serviceid}/edit">Edit</a></td>
                            <form action="repairs/${repair.serviceid}/delete" method="post" name="deleteUser" onsubmit="return confirm('We will delete this user!');">
                                <input type="hidden" name="serviceid" value="${repair.serviceid}"/>
                                <td><button type="submit"> Delete</button></td>
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