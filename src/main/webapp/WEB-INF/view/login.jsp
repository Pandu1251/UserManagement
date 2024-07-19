<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
    <link href="<c:url value='/static/css/bootstrap.min.css' />" rel="stylesheet">
    <link href="<c:url value='/static/css/style.css' />" rel="stylesheet">
</head>
<body>
    <div class="container text-center">
        <h3>User Login</h3>
        <hr>
        <form class="form-horizontal" method="POST" action="/login-user">
            <c:if test="${not empty error }">
                <div class="alert alert-danger">
                    <c:out value="${error }"></c:out>
                </div>
            </c:if>
            <div class="form-group">
                <label class="control-label col-md-3">Username</label>
                <div class="col-md-7">
                    <input type="text" class="form-control" name="username"
                        value="${user.username}" />
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-md-3">Password</label>
                <div class="col-md-7">
                    <input type="password" class="form-control" name="password"
                        value="${user.password}" />
                </div>
            </div>
            <div class="form-group">
                <input type="submit" class="btn btn-primary" value="Login" />
            </div>
        </form>
    </div>
    <script src="<c:url value='/static/js/jquery-1.11.1.min.js' />"></script>
    <script src="<c:url value='/static/js/bootstrap.min.js' />"></script>
</body>
</html>
