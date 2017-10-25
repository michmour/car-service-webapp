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

                    <div class="col-lg-3">
                        <div class="input-group">
                            <label for="servicedate">Start Date</label>
                            <input type="datetime-local" class="form-control" name="servicedate" id="servicedate"/>
                        </div>
                        <div class="input-group">
                            <label for="servicedate">End Date</label>
                            <input type="datetime-local" class="form-control" name="servicedate" id="servicedate"/>
                        </div>
                    </div>



                    <div class="row">

                        <div class="col-lg-4">
                            <label>Email Search</label>
                            <div class="input-group">
                                <input type="text" class="form-control" placeholder="Search by EMAIL">
                                <span class="input-group-btn">
                                    <button class="btn btn-secondary" type="button">Go!</button>
                                </span>
                            </div>
                        </div>

                        <div class="col-lg-4">
                            <label>SSN Search</label>
                            <div class="input-group">
                                <input type="text" class="form-control" placeholder="Search b">
                                <span class="input-group-btn">
                                    <button class="btn btn-secondary" type="button">Go!</button>
                                </span>
                            </div>
                        </div>
                        <br>


                    </div>
                </div>
                <!-- /.row -->

            </div>
            <!-- /.container-fluid -->

        </div>
        <!-- /#page-wrapper -->






<#include "/includes/footer.ftl">