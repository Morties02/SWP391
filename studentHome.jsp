<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!Doctype html>
<%@include file="/includes/header.jsp"%>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- Bootstrap CSS -->
        <link href="https://use.fontawesome.com/releases/v5.0.1/css/all.css" rel="stylesheet">

        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" 
              rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

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
        <style>
            .sidenav {
                height: 100%; /* 100% Full-height */
                width: 0; /* 0 width - change this with JavaScript */
                position: fixed; /* Stay in place */
                z-index: 1; /* Stay on top */
                top: 0; /* Stay at the top */
                left: 0;
                background-color: #FFFFFF; /* Black*/
                overflow-x: hidden; /* Disable horizontal scroll */
                padding-top: 60px; /* Place content 60px from the top */
                transition: 0.5s; /* 0.5 second transition effect to slide in the sidenav */
            }

            /* The navigation menu links */
            .sidenav ul a {
                padding: 8px 8px 8px 32px;
                text-decoration: none;
                font-size: 25px;
                color: #818181;
                display: block;
                transition: 0.3s;
            }

            /* When you mouse over the navigation links, change their color */
            .sidenav ul a :hover {
                color: #f1f1f1;
            }

            /* Position and style the close button (top right corner) */
            .sidenav .closebtn {
                position: absolute;
                top: 0;
                right: 25px;
                font-size: 36px;
                margin-left: 50px;
            }

            /* Style page content - use this if you want to push the page content to the right when you open the side navigation */
            #main {
                transition: margin-left .5s;
                padding: 20px;
            }

            /* On smaller screens, where height is less than 450px, change the style of the sidenav (less padding and a smaller font size) */
            @media screen and (max-height: 450px) {
                .sidenav {
                    padding-top: 15px;
                }
                .sidenav a {
                    font-size: 18px;
                }
            }
        </style>
         <style>
      * {
        box-sizing: border-box;
      }
      .loginPopup {
        position: relative;
        text-align: center;
        width: 100%;
      }
      .formPopup {
        display: none;
        position: fixed;
        left: 45%;
        top: 5%;
        transform: translate(-50%, 5%);
        border: 3px solid #999999;
        z-index: 9;
      }
      .formContainer {
        max-width: 300px;
        padding: 20px;
        background-color: #fff;
      }
      .formContainer input[type=text],
      .formContainer input[type=password] {
        width: 100%;
        padding: 15px;
        margin: 5px 0 20px 0;
        border: none;
        background: #eee;
      }
      .formContainer input[type=text]:focus,
      .formContainer input[type=password]:focus {
        background-color: #ddd;
        outline: none;
      }
      .formContainer .btn {
        padding: 12px 20px;
        border: none;
        background-color: lightblue;
        color: #fff;
        cursor: pointer;
        width: 100%;
        margin-bottom: 15px;
        opacity: 0.8;
      }
      .formContainer .cancel {
        background-color: red;
      }
      .formContainer .btn:hover,
      .openButton:hover {
        opacity: 1;
      }
    </style>
    </head>


    <div class="card sidenav" id="mySidenav" style="width: 0" >
        <div class="card-header">
            Your Classes ${count}
            <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>

        </div>
        <ul class="list-group list-group-flush">
            <c:forEach items="${stdClasses}" var="cl">
                <li class="list-group-item">                
                    <a href="viewlisttest?classId=${cl.getClassId()}">
                        ${cl.getClassName()}                
                    </a>
                </li>
            </c:forEach>
        </ul>
    </div>            



    <section class="vh-100" style="background-color: white;">
        <div class="container py-5 h-100">
            <div class="row d-flex justify-content-center align-items-center h-100">
                <div id="main" class="card h-100 main">
                    <div class="card-body">
                        <form action="student-home" method = "post">
                            <div class="input-group" style="margin-bottom: 66px;">

                                <div class="form-outline">
                                    <input type="search" name ="searchString" class="form-control" placeholder="Search" />
                                </div>
                                <button type="button" class="btn btn-primary" type="submit">
                                    <i class="fas fa-search"></i>
                                </button>
                            </div>
                        </form>

                        <div class="form-outline">
                            <h3 class="card-title"  style="margin-bottom: 33px;">Courses    Total: ${allclass.size()}</h3>
                            <ul class="list-group">
                                <c:forEach items="${allclass}" var="ac">
                                    <li class="list-group-item" >
                                       ${ac.getClassName()}
                                       <a href="#" onclick="openForm(${ac.getClassId()})">Attempt</a>
                                    </li>
                                    </c:forEach>
                            </ul>
                        </div>

                        <div class="enrollPopup">
                            <div class="formPopup" id="popupForm">
                                <form action="/attemp-class" class="formContainer" method="post">
                                    <h2>Enter Enrollment Key</h2>
                                    <label for="psw">
                                        <strong>Enrollment Key</strong>
                                    </label>
                                    <input type="hidden" name="enrollClassId" value="0"/>
                                     <input type="hidden" name="stdId" value="${stdId}"/>
                                    <input type="password" id="psw" placeholder="Enter Enrollment Key" name="psw" required>
                                    <button type="submit" class="btn">Submit</button>
                                    <button type="button" class="btn cancel" onclick="closeForm()">Close</button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
    </section>

    <hr style="color: white;">

     <script>
      function openForm(pram) {
        document.getElementById("popupForm").style.display = "block";
        document.getElementById("enrollClassId").value = param;
      }
      function closeForm() {
        document.getElementById("popupForm").style.display = "none";
      }
    </script>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" 
            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous">
    </script>

    <!-- MDB -->
    <script
        type="text/javascript"
        src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/6.3.0/mdb.min.js"
    ></script>
</body>
</html>
