<script>
    document.title = 'CS - Search Users';
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
                        Search Users
                    </h1>

                    <div class="row">

                        <div class="col-lg-6">
                            <label>Email Search</label>
                            <div class="input-group">
                                <input type="text" class="form-control" placeholder="Search by EMAIL">
                                <span class="input-group-btn">
                                    <button id="searchbutton" class="btn btn-secondary" type="button">Go!</button>
                                </span>
                            </div>
                        </div>

                        <div class="col-lg-6">
                            <label>SSN Search</label>
                            <div class="input-group">
                                <input type="text" class="form-control" placeholder="Search by SSN">
                                <span class="input-group-btn">
                                    <button class="btn btn-secondary" type="button">Go!</button>
                                </span>
                            </div>
                        </div>

                        <br>
                        <table id="location" class="table table-bordered table-hover">
                                                <tr>
                                                    <th>ssn</th>
                                                    <th>surname</th>
                                                </tr>
                                            </table>


                    </div>
                </div>
                <!-- /.row -->

            </div>
            <!-- /.container-fluid -->

        </div>
        <!-- /#page-wrapper -->






<#include "/includes/footer.ftl">