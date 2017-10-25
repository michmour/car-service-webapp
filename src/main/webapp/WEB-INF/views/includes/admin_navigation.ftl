

<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="navbar-header">
        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </button>
        <a class="navbar-brand" href="/admin/index">CS Admin</a>
    </div>
    <!-- Top Menu Items -->
    <ul class="nav navbar-right top-nav">
        <li><a href="/admin/index"><span class="glyphicon glyphicon-home"></span> Home Page</a></li>

        <li class="dropdown">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-user"></i> Admin <b class="caret"></b></a>
            <ul class="dropdown-menu">
                <li class="divider"></li>
                <li>
                    <a href="/logout"><i class="fa fa-fw fa-power-off"></i> Log Out</a>
                </li>
            </ul>
        </li>
    </ul>


    <!-- Sidebar Menu Items - These collapse to the responsive navigation menu on small screens -->
    <div class="collapse navbar-collapse navbar-ex1-collapse">
        <ul class="nav navbar-nav side-nav">
            <li>
                <a href="/admin/index"><i class="fa fa-fw fa-calendar"></i> Calendar </a>
            </li>
            <li>
                <a href="javascript:;" data-toggle="collapse" data-target="#posts_dropdown"><i class="fa fa-fw fa-wrench  "></i> Repairs <i class="fa fa-fw fa-caret-down"></i></a>
                <ul id="posts_dropdown" class="collapse">
                    <li>
                        <a href="/admin/repairs">View All Repairs</a>
                    </li>
                    <li>
                        <a href="/admin/repairs/add">Add Repair</a>
                    </li>
                    <li>
                        <a href="/admin/repairs/search">Search Repair</a>
                    </li>
                </ul>
            </li>
            <li>
                <a href="javascript:;" data-toggle="collapse" data-target="#demo"><i class="fa fa-fw fa-users"></i> Users <i class="fa fa-fw fa-caret-down"></i></a>
                <ul id="demo" class="collapse">
                    <li>
                        <a href="/admin/users">View All Users</a>
                    </li>
                    <li>
                        <a href="/admin/users/add">Add User</a>
                    </li>
                    <li>
                        <a href="/admin/users/search">Search User</a>
                    </li>
                </ul>
            </li>
            <li>
                <a href="javascript:;" data-toggle="collapse" data-target="#cars"><i class="fa fa-fw fa-car"></i> Vehicles <i class="fa fa-fw fa-caret-down"></i></a>
                <ul id="cars" class="collapse">
                    <li>
                        <a href="/admin/vehicles">View All Vehicles</a>
                    </li>
                    <li>
                        <a href="/admin/vehicles/add">Add Vehicle</a>
                    </li>
                    <li>
                        <a href="/admin/vehicles/search">Search Vehicle</a>
                    </li>
                </ul>
            </li>
        </ul>
    </div>


    <!-- /.navbar-collapse -->
</nav>