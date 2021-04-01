<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<ul class="sidebar navbar-nav">
    <li class="nav-item active">
        <a class="nav-link" href="/school">
            <i class="fas fa-fw fa-dice-three"></i>
            <span>Main</span>
        </a>
    </li>
    <li class="nav-item active">
        <a class="nav-link" href="/groups">
            <i class="fas fa-fw fa-user-friends"></i>
            <span>Groups</span>
        </a>
    </li>
    <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="pagesDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
            <i class="fas fa-fw fa-folder"></i>
            <span>Pages</span>
        </a>
        <div class="dropdown-menu" aria-labelledby="pagesDropdown">
            <h6 class="dropdown-header">Login Screens:</h6>
            <a class="dropdown-item" href="login.html">Login</a>
            <a class="dropdown-item" href="register.html">Register</a>
            <a class="dropdown-item" href="forgot-password.html">Forgot Password</a>
            <div class="dropdown-divider"></div>
            <h6 class="dropdown-header">Other Pages:</h6>
            <a class="dropdown-item" href="404.html">404 Page</a>
            <a class="dropdown-item" href="blank.html">Blank Page</a>
        </div>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="/exercises">
            <i class="fas fa-fw fa-table"></i>
            <span>Exercises</span></a>
    </li>
</ul>