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
                            <select name="status">
                                <option class="form-control" value="${repairForm.status}" selected>

                                </option>
                                <option value="PENDING" <#if repairForm.type=="PENDING">selected</#if>>PENDING</option>
                                <option value="IN PROGRESS" <#if repairForm.type=="IN PROGRESS">selected</#if>>IN PROGRESS</option>
                                <option value="COMPLETED" <#if repairForm.type=="COMPLETED">selected</#if>>COMPLETED</option>
                            </select>
                        </div>


                        <div class="form-group">
                            <label for="type">Type</label>
                            <select name="type">
                                <option value="SMALL" <#if repairForm.type=="SMALL">selected</#if>>SMALL</option>
                                <option value="BIG" <#if repairForm.type=="BIG">selected</#if>>BIG</option>
                            </select>
                        </div>

                        <div class="form-group">
                            <label for="servicecost">Service Cost</label>
                            <input type="number" class="form-control" name="servicecost" id="servicecost" value="${repairForm.servicecost}" placeholder="servicecost"/>
                        </div>

                        <div class="form-group">
                            <label for="details">Details</label>
                            <input type="text" class="form-control" name="details" id="details" value="${repairForm.details}" placeholder="details"/>
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