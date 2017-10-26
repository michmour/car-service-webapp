<script>
    document.title = 'CS - Edit User';
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

                    <form action="/admin/users/${userForm.userid}" method="post"
                          id= "userForm" name="updateUser">

                        <div class="form-group">
                            <label for="name">First Name</label>
                            <input type="text" class="form-control" pattern="^[a-zA-Z ]*$" name="name" id="name" value="${userForm.name}" placeholder="name"/>
                        </div>


                        <div class="form-group">
                            <label for="surname">Last Name</label>
                            <input type="text"class="form-control" pattern="^[a-zA-Z ]*$" name="surname" id="name"  value="${userForm.surname}" placeholder="surname"/>
                        </div>


                        <div class="form-group">
                            <label for="password">Password</label>
                            <input type="password" class="form-control" pattern="^[a-zA-Z0-9@#$%^&]*$" name="password" id="password" value="${userForm.password}" placeholder="password"/>
                        </div>

                        <div class="form-group">
                            <label for="email">Email</label>
                            <input type="email" pattern="^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[A-Za-z]{1,63}$" class="form-control" name="email" id="email" value="${userForm.email}" placeholder="email"/>
                        </div>

                        <div class="form-group">
                            <label for="ssn">Ssn</label>
                            <input type="text" class="form-control" pattern="^[0-9]{9}$" name="ssn" id="ssn" value="${userForm.ssn}" placeholder="ssn"/>
                        </div>

                        <div class="form-group">
                            <label for="address">Address</label>
                            <input type="text" pattern="^[a-zA-Z0-9]*$" class="form-control" name="address" id="address" value="${userForm.address}" placeholder="address"/>
                        </div>

                        <input type="hidden" name="usertype" value="${userForm.usertype}"/>

                        <input type="hidden" name="userid" value="${userForm.userid}"/>


                        <div class="form-group">
                            <input type="submit" class="btn btn-primary" value="Edit User">
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