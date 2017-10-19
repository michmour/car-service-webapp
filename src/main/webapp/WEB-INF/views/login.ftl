<#import "/spring.ftl" as spring/>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>Bootstrap 101 Template</title>
    <link rel="icon" type="image/x-icon" href="http://direct.smilebasicsource.com/main/favicon.ico ">

    <!-- Bootstrap -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<ul class="tab-group">
    <li class="tab active"><a href="/register">Sign Up</a></li>
    <li class="tab"><a href="/login">Log In</a></li>
</ul>


<div class="form">
    <form action="/login" method="post" id="loginForm" name="loginForm">
        <label for="username">Username</label>
        <input type="text" name="username" id="username" placeholder="username" autocomplete="off"/>

        <label for="password">Password</label>
        <input type="password" name="password" id="password" placeholder="password"/>

        <button type="submit">Login</button>
    </form>
</div>

<div class="container">
    <div class="row">
        <div class="col-md-4 col-md-offset-4">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">Please sign in</h3>
                </div>
                <div class="panel-body">
                    <form action="/login" method="post" id="loginForm" name="loginForm">
                        <fieldset>
                            <div class="form-group">
                                <input class="form-control" type="text" name="username" id="username" placeholder="username" autocomplete="off"/>
                            </div>
                            <div class="form-group">
                                <input class="form-control" type="password" name="password" id="password" placeholder="password"/>
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

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="js/bootstrap.min.js"></script>
</body>