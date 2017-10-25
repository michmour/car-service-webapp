<script>
    document.title = 'CS - Index';
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
                        Welcome to Admin Area
                    </h1>


                    <table class="table table-bordered table-hover">
                    <#if repairs??>
                        <thead>
                        <tr>
                            <td>Service ID</td>
                            <td>Details</td>
                            <td>Service Cost</td>
                            <td>Service Date</td>
                            <td>Status</td>
                            <td>Type</td>
                            <td>User Credentials</td>
                            <td>Edit User</td>
                            <td>Delete User</td>
                        </tr>
                        </thead>
                    <tbody>
                        <#list repairs.content as repair>

                        <tr>
                            <td>${repair.serviceid}</td>
                            <td>${repair.details}</td>
                            <td>${repair.servicecost}</td>
                            <td>${repair.servicedate?datetime.iso?string["EEEE, MMMM dd, yyyy, HH:mm "]}</td>
                            <td>${repair.status}</td>
                            <td>${repair.type}</td>
                            <td>${repair.userelid.name} ${repair.userelid.surname}</td>
                            <td><button class="btn btn-success" type="submit"> <a id="white" href="repairs/${repair.serviceid}/edit">Edit</button></a></td>
                            <form action="repairs/${repair.serviceid}/delete" method="post" name="deleteUser" onsubmit="return confirm('We will delete this repair!');">
                                <input type="hidden" name="serviceid" value="${repair.serviceid}"/>
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