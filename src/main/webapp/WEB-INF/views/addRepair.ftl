<script>
    document.title = 'CS - Add Repair';
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
                        Add Repair
                    </h1>

                    <form action="/admin/repairs" method="post" id="repairForm" name="addRepair">

                        <div class="form-group">
                            <label for="servicedate">Service Date</label>
                            <input type="datetime-local" class="form-control" name="servicedate" id="servicedate"/>
                        </div>


                        <div class="form-group">
                            <label for="status">Status</label>
                            <select name="status">
                                <option value="PENDING">PENDING</option>
                                <option value="IN PROGRESS">IN PROGRESS</option>
                                <option value="COMPLETED">COMPLETED</option>
                            </select>
                        </div>


                        <div class="form-group">
                            <label for="type">Type</label>
                            <select name="type">
                                <option value="SMALL">SMALL</option>
                                <option value="BIG">BIG</option>
                            </select>
                        </div>

                        <div class="form-group">
                            <label for="servicecost">Service Cost</label>
                            <input type="text" class="form-control" name="servicecost" id="servicecost" placeholder="servicecost"/>
                        </div>

                    <#if usersList??>
                        <label for="userelid">Select User</label>


                        <select name="userelid">

                            <#list usersList as userValues>
                                <option value="${userValues.userid}">${userValues.name}</option>
                            </#list>

                        </select>

                    </#if>

                        <div class="form-group">
                            <label for="details">Details</label>
                            <input type="text" class="form-control" name="details" id="details" placeholder="details"/>
                        </div>


                        <div class="form-group">
                            <input type="submit" class="btn btn-primary" value="Add Repair">
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
