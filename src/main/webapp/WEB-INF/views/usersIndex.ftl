<#include "/includes/header.ftl">
<div id="wrapper">
<#include "/includes/user_navigation.ftl">
    <div id="page-wrapper">

        <div class="container-fluid">

            <!-- Page Heading -->
            <div class="row">
                <div class="col-lg-12">

                    <h1 class="page-header">
                        Welcome ${userRepairs.name} ${userRepairs.surname }
                    </h1>


                    <table class="table table-bordered table-hover">
                    <#if userRepairs??>
                        <thead>
                        <tr>
                            <td>Service ID</td>
                            <td>Details</td>
                            <td>Service Cost</td>
                            <td>Service Date</td>
                            <td>Status</td>
                            <td>Type</td>
                        </tr>
                        </thead>
                    <tbody>

                        <#list userRepairs.servicescollection as repair>

                        <tr>
                            <td>${repair.serviceid}</td>
                            <td>${repair.details}</td>
                            <td>${repair.servicecost}</td>
                            <td>${repair.servicedate?datetime.iso?string["EEEE, MMMM dd, yyyy, HH:mm "]}</td>
                            <td>${repair.status}</td>
                            <td>${repair.type}</td>
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