<script>
    document.title = 'CS - All Users';
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
                        All Users
                        </h1>

                    <div class="row">
                        <div class="col-lg-6">
                            <div class="input-group">
                            <span class="input-group-btn">
                                    <button id="getUsers" class="btn btn-secondary" type="button">Go!</button>
                                </span>
                                <input type="text" class="form-control" placeholder="Search by SSN">
                            </div>
                        </div>
                        <div class="col-lg-6">
                            <div class="input-group">
                                <input type="text" class="form-control" placeholder="Search by EMAIL">
                                <span class="input-group-btn">
                                    <button class="btn btn-secondary" type="button">Go!</button>
                                </span>
                            </div>
                        </div>
                    </div>
                    <br>


                    <table class="table table-bordered table-hover">
                    <#if users??>
                        <thead>
                        <tr>
                            <td>ID</td>
                            <td>First Name</td>
                            <td>Last Name</td>
                            <td>Address</td>
                            <td>Email</td>
                            <td>Role</td>
                            <td>Edit User</td>
                            <td>Delete User</td>
                        </tr>
                        </thead>
                    <tbody>

                        <#list users as user>

                        <tr>
                            <td>${user.userid}</td>
                            <td>${user.name}</td>
                            <td>${user.surname}</td>
                            <td>${user.address}</td>
                            <td>${user.email}</td>
                            <td>${user.usertype}</td>
                            <td> <button class="btn btn-success" type="submit"> <a id="white" href="users/${user.userid}/edit">Edit</button></a></td>
                            <form action="users/${user.userid}/delete" method="post" name="deleteUser" onsubmit="return confirm('We will delete this user!');">
                                <input type="hidden" name="userid" value="${user.userid}"/>
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