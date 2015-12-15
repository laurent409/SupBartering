<%-- 
    Document   : settings
    Created on : 13 déc. 2015, 13:49:52
    Author     : Laurent
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css" rel="stylesheet">
        <title>SupBartering: Settings</title>
    </head>
    <body>
        <nav class="navbar navbar-inverse navbar-fixed-top">
            <div class="container">
                <div class="navbar-header">
                    <a class="navbar-brand" href="${pageContext.servletContext.contextPath}/home">SupBartering</a>
                </div>
                <ul class="nav navbar-nav">
                    <li><a href="${pageContext.servletContext.contextPath}/admin/add-object">
                            <span class="glyphicon glyphicon-plus-sign"></span> New Item
                        </a>
                    </li>
                </ul>
                <form method="POST" class="navbar-form navbar-left">
                    <div class="form-group">
                        <input type="text" name="searchLikeThis" id="searchLikeThis" class="form-control" placeholder="Search item" required>
                    </div>
                    <button type="submit" class="btn btn-default">
                        <span class="glyphicon glyphicon-search"></span>
                    </button>
                </form>
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="${pageContext.servletContext.contextPath}/admin/settings"><span class="glyphicon glyphicon-user"></span> My Settings</a></li>
                    <li><a href="${pageContext.servletContext.contextPath}/logout">Sign-out</a></li>
                </ul>
            </div>  
        </nav>        
        <div class="container">
            <a href="${pageContext.servletContext.contextPath}/admin"><span class="glyphicon glyphicon-hand-left" style="max-width: 330px; padding-top: 10%; padding-left: 2%; margin: 0 auto;"> Back</span></a>
            <form method="POST" class="form-signin" style="max-width: 330px; padding: 4%; margin: 0 auto;">
                <h2 class="form-signin-heading">My Settings</h2>
                <label for="mail" class="sr-only">Mail Address</label>
                <input type="mail" class="form-control" id="mail" name="mail" value="${sessionScope.user.mailAddress}" placeholder="mail address" required/>
                <br>
                <label for="username" class="sr-only">Username</label>
                <input type="text" class="form-control" id="username" name="username" value="${sessionScope.user.userName}" placeholder="username" readonly/>
                <br>
                <label for="firstName" class="sr-only">First-name</label>
                <input type="text" class="form-control" id="firstName" name="firstName" value="${sessionScope.user.firstName}" placeholder="first name" required/>
                <br>
                <label for="lastName" class="sr-only">Last Name</label>
                <input type="text" class="form-control" id="lastName" name="lastName" value="${sessionScope.user.lastName}" placeholder="last name" required/>
                <br>
                <label for="postalCode" class="sr-only">Postal Code</label>
                <input type="number" class="form-control" id="postalCode" name="postalCode" value="${sessionScope.user.postalCode}" placeholder="postal code" min="0" required/>
                <br>
                <label for="password" class="sr-only">Password</label>
                <input type="password" class="form-control" id="password" name="password" value="${sessionScope.user.password}" placeholder="password" required/>
                <br>
                <button type="submit" class="btn btn-lg btn-primary btn-block">Change it !</button>
            </form>
        </div>
    </body>
</html>
