<script>
    document.title = 'CS - Add User';
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
                        Add User
                    </h1>

<form action="/admin/users" method="post" id="userForm" name="addUser">

    <div class="form-group">
        <label for="name">First Name</label>
        <input type="text" class="form-control" name="name" id="name" placeholder="name"/>
    </div>


    <div class="form-group">
        <label for="name">Last Name</label>
        <input type="text" class="form-control" name="surname" id="name" placeholder="surname"/>
    </div>


    <div class="form-group">
        <label for="password">Password</label>
        <input type="password" class="form-control" name="password" id="password" placeholder="password"/>
    </div>

    <div class="form-group">
        <label for="email">User Email</label>
        <input type="email" class="form-control" name="email" id="email" placeholder="email"/>
    </div>

    <div class="form-group">
        <label for="ssn">Ssn</label>
        <input type="text" class="form-control" name="ssn" id="ssn" placeholder="ssn"/>
    </div>

    <div class="form-group">
        <label for="address">Address</label>
        <input type="text" class="form-control" name="address" id="address" placeholder="address"/>
    </div>

    <div class="form-group">
        <select name="usertype" id="">
            <option value="ADMIN">Admin</option>
            <option value="OWNER" selected>Car Owner</option>
        </select>
    </div>


    <div class="form-group">
        <input type="submit" class="btn btn-primary" value="Add Users">
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
