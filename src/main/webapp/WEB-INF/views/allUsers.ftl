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
                        Welcome to Admin Area
                    </h1>


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
                            <td> <a href="users/${user.userid}/edit">Edit</a></td>
                            <form action="users/${user.userid}/delete" method="post" name="deleteUser" onsubmit="return confirm('We will delete this user!');">
                                <input type="hidden" name="userid" value="${user.userid}"/>
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