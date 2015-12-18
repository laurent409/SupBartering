<%-- 
    Document   : login
    Created on : 7 déc. 2015, 18:59:00
    Author     : Laurent
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css" rel="stylesheet">
        <title>SupBartering: Sign-up</title>
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
                <span class="error">${requestScope.user}</span>
                <h2 class="form-signin-heading">Sign-up</h2>
                <label for="mail" class="sr-only">Mail Address</label>
                <input type="mail" class="form-control" id="mail" name="mail" value="" placeholder="mail" required/>
                <span class="error">${form.erreurs['mail']}</span>
                <br>
                <label for="username" class="sr-only">Username</label>
                <input type="text" class="form-control" id="username" name="username" value="" placeholder="username" required/>
                <span class="erorr">${form.erreurs['username']}</span>
                <br>
                <label for="firstName" class="sr-only">First-name</label>
                <input type="text" class="form-control" id="firstName" name="firstName" value="" placeholder="firstName" required/>
                <span class="error">${form.erreurs['firstName']}</span>
                <br>
                <label for="lastName" class="sr-only">Last Name</label>
                <input type="text" class="form-control" id="lastName" name="lastName" value="" placeholder="lastName" required/>
                <span class="error">${form.erreurs['lastName']}</span>
                <br>
                <label for="postalCode" class="sr-only">Postal Code</label>
                <input type="number" class="form-control" id="postalCode" name="postalCode" value="" placeholder="postalCode" min="0" required/>
                <span class="error">${form.erreurs['postalCode']}</span>
                <br>
                <label for="password" class="sr-only">Password</label>
                <input type="password" class="form-control" id="password" name="password" value="" placeholder="password" required/>
                <span class="error">${form.erreurs['password']}</span>
                <br>
                <button type="submit" class="btn btn-lg btn-primary btn-block">Welcome to SupBartering</button>
            </form>
        </div>        
    </body>
</html>
