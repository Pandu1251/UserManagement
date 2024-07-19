<!DOCTYPE html >
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Cache-Control" content="no-cache">
<meta http-equiv="Expires" content="sat, 01 Dec 2001 00:00:00 GMT">
<title>My project | home</title>
<link href="<c:url value='/static/css/bootstrap.min.css' />" rel="stylesheet">
<link href="<c:url value='/static/css/style.css' />" rel="stylesheet">
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
    <div role="navigation">
        <div class="navbar navbar-inverse">
            <a href="/home" class="navbar-brand">Home</a>
            <div class="navbar-collapse collapse">
                <ul class="nav navbar-nav">
                    <li><a href="/login">Login</a></li>
                    <li><a href="/register">New Registration</a></li>
                    <li><a href="/show-users">All Users</a></li>
                </ul>
            </div>
        </div>
    </div>
    <div class="container" id="homediv">
                <div class="jumbotron text-center">
                    <h1>Welcome to Spring boot</h1>
                    <h3>My saved videos</h3>
                </div>
            </div>
            
            <div class="container text-centered">
            <div class="alert alert success">
            <h4> session 1:Spring boot Tutorial </h4>
            <div>
            <iframe width="250" height="150" src="https://www.youtube.com/embed/UBrDxaB8RUs?si=jPQHJDl8_DzO7ngE" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" referrerpolicy="strict-origin-when-cross-origin" allowfullscreen></iframe>
            </div>
            
            </div>
            
            
            </div>
    </body>
    
   </html>
