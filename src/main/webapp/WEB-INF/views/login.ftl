<#include "/includes/header.ftl">

<script>
    document.title = 'CS - Login Page';
</script>

<div class="container">
    <div class="row">
        <div class="text-center col-md-4 col-md-offset-4">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">Please sign in</h3>
                </div>
                <div class="panel-body">
                    <form action="/login" method="post" id="loginForm" name="loginForm">
                        <fieldset>
                            <div class="form-group">
                                <input class="form-control" type="text" name="username" id="username" placeholder="Your E-Mail" autocomplete="off"/>
                            </div>
                            <div class="form-group">
                                <input class="form-control" type="password" name="password" id="password" placeholder="Your Password"/>
                            </div>
                            <div class="checkbox">
                                <input class="btn btn-lg btn-success btn-block" type="submit" value="Login">
                        </fieldset>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<#include "/includes/footer.ftl">