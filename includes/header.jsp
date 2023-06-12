<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- Bootstrap CSS -->
        <link href="https://use.fontawesome.com/releases/v5.0.1/css/all.css" rel="stylesheet">

        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" 
              rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
        <link rel="stylesheet" href="./assets/css/style.css">
        <style>
            .dropdown-menu li {
                position: relative;
            }
            .dropdown-menu .dropdown-submenu {
                display: none;
                position: absolute;
                left: 100%;
                top: -7px;
            }
            .dropdown-menu .dropdown-submenu-left {
                right: 100%;
                left: auto;
            }
            .dropdown-menu > li:hover > .dropdown-submenu {
                display: block;
            }
        </style>

    </head>
    <body style="background-color: #FFFFFF">
        <!--Header-->

        <header>
            <nav class="navbar navbar-expand-sm navbar-toggleable-sm navbar-light box-shadow" style="background-color: #ECECEC;padding: 0; margin: 0;" >
                <div class="container-fluid">
                    <div class="navbar-collapse collapse d-sm-inline-flex justify-content-between">
                        <ul class="navbar-nav flex-grow-1">
                            <li class="nav-item">
                                <img  src="assets/img/menu.png" style="padding-top: 6px" onclick="openNav()">
                            </li>
                            <li class="nav-item">
                                <a href="student-home">
                                   <img style="width: 50%; height:80%"src="assets/img/site-logo.png" >
                                </a>
                            </li>
                        
                        </ul>
                    </div>

                </div>
                <div class="navbar-collapse collapse d-sm-inline-flex justify-content-end">
                    <ul class="navbar-nav flex-grow-1">
                        <li class="nav-item dropdown">
                            <a class="nav-link text-dark" href="#" id="navbarDropdownMenuLink" role="button"
                               data-mdb-toggle="dropdown" aria-expanded="false">
                                Account
                            </a>
                            <ul class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                                <li>
                                    <a class="dropdown-item">
                                        <i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-white bg-secondary"></i>
                                        Logout
                                    </a>
                                </li>
                            </ul>
                        </li>

                    </ul>
                </div>
            </nav>

        </header>
        <!-- end header -->
        <script>
            function openNav() {
                document.getElementById("mySidenav").style.width = "250px";
                document.getElementById("main").style.marginLeft = "250px";
            }

            /* Set the width of the side navigation to 0 and the left margin of the page content to 0 */
            function closeNav() {
                document.getElementById("mySidenav").style.width = "0";
                document.getElementById("main").style.marginLeft = "0";
            }
        </script>