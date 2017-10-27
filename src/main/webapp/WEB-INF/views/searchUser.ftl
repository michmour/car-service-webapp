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
                                <input  type="text" id="searchInput" class="form-control" placeholder="Search">

                                 <label>Search Categories</label>
                                <select id="CategoryId" class="form-control" >
                                  <option value="ownerssn" selected>Owner by Social Security Number</option>
                                  <option value="owneremail">Owner by Email</option>
                                  <option value="repairssn">Repairs by Social Security Number</option>
                                  <option value="vehicleplate">Vehicle by Plate Number</option>
                                  <option value="vehiclessn">Vehicles by Social Security Number</option>
                                </select>
                                <div class="input-group">
                                <label>Search Repairs by Date</label>
                                <input  type="datetime-local" id="searchDate" class="form-control">
                           </div>
                             </div>

                        <br>

                        <br>
                        <table id="location" class="table table-bordered table-hover">
                            <thead>
                            </thead>
                            <tbody>
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