<script>
    document.title = 'CS - Edit Repair';
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
                        Edit Repair
                    </h1>

                    <form action="/admin/repairs/${repairForm.serviceid}" method="post" id="repairEditForm" name="repairEditForm">

                        <div class="form-group">
                            <label for="servicedate">Service Date</label>
                            <input type="datetime-local" class="form-control" name="servicedate" id="servicedate" value="${repairForm.servicedate}"/>
                        </div>



                        <div class="form-group">
                             <label for="status">Status</label>
                             <@spring.formSingleSelect path="repairForm.status" options=repairStatusList attributes='class="form-control"'/>
                        </div>


                        <div class="form-group">
                             <label for="status">Type</label>
                             <@spring.formSingleSelect path="repairForm.type" options=repairTypeList attributes='class="form-control"'/>
                        </div>

                        <div class="form-group">
                            <label for="servicecost">Service Cost</label>
                            <input type="number" pattern="^[0-9]*$" class="form-control" name="servicecost" id="servicecost" value="${repairForm.servicecost}" placeholder="servicecost"/>
                        </div>

                        <div class="form-group">
                            <label for="details">Details</label>
                            <input type="text" pattern="^[a-zA-Z0-9@#$%^&]*$" class="form-control" name="details" id="details" value="${repairForm.details}" placeholder="details"/>
                        </div>

                        <input type="hidden" name="serviceid" value="${repairForm.serviceid}"/>


                        <div class="form-group">
                            <button type="submit">Edit Repair</button>
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