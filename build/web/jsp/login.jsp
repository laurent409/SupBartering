<%-- 
    Document   : login
    Created on : 8 déc. 2015, 16:29:26
    Author     : Laurent
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css" rel="stylesheet">
        <title>SupBartering: Sign-in</title>
    </head>
    <body>
        <nav class="navbar navbar-inverse navbar-fixed-top">
            <div class="container">
                <div class="navbar-header">
                    <a class="navbar-brand" href="${pageContext.servletContext.contextPath}/home">SupBartering</a>
                </div>
                <form method="POST" class="navbar-form navbar-left">
                    <div class="form-group">
                        <input type="text" name="searchLikeThis" id="searchLikeThis" class="form-control" placeholder="Search item" required>
                    </div>
                    <button type="submit" class="btn btn-default">
                        <span class="glyphicon glyphicon-search"></span>
                    </button>
                </form>
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="${pageContext.servletContext.contextPath}/login">Sign-in</a></li>
                    <li><a href="${pageContext.servletContext.contextPath}/register">Sign-up</a></li>
                </ul>
            </div>  
        </nav>        
        <div class="container">
            <a href="home"><span class="glyphicon glyphicon-hand-left" style="max-width: 330px; padding-top: 10%; padding-left: 2%; margin: 0 auto;"> Back</span></a>
            <form method="POST" class="form-signin" style="max-width: 330px; padding: 4%; margin: 0 auto;">
                <h2 class="form-signin-heading">Sign-in</h2>
                <label for="username" class="sr-only">Username</label>
                <input type="text" class="form-control" id="username" name="username" value="" placeholder="username" required/>
                <br>
                <label for="password" class="sr-only">Password</label>
                <input type="password" class="form-control" id="password" name="password" value="" placeholder="password" required/>
                <br>
                <button type="submit" class="btn btn-lg btn-primary btn-block">Welcome back</button>
            </form>
        </div>
    </body>
</html>
