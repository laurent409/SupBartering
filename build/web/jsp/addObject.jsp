<%-- 
    Document   : addObject
    Created on : 13 déc. 2015, 15:28:48
    Author     : Laurent
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css" rel="stylesheet">
        <title>SupBartering: Add Object</title>
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
            <form action="${pageContext.servletContext.contextPath}/admin/add-object" method="POST" class="form-signin" style="max-width: 330px; padding: 4%; margin: 0 auto;" >
                <h2 class="form-signin-heading">Add your own item !</h2>
                <label for="name" class="sr-only">Name</label>
                <input type="text" class="form-control" id="name" name="name" value="" placeholder="name" required/>
                <br>
                <label for="description" class="sr-only">Description</label>
                <textarea class="form-control" id="description" name="description" placeholder="description" required></textarea>
                <br>
                <label for="price" class="sr-only">Price</label>
                <input type="number" class="form-control" id="price" name="price" placeholder="price €" min="0" step="0.01" required/>
                <br>
                <label for="type" class="sr-only">Type</label>
                <select class="form-control" name="type" id="type" required>
                    <option value="-" selected="selected">-</option>
                    <option value="Vehicle">Vehicle</option>
                    <option value="Real-Estate">Real-Estate</option>
                    <option value="Multimedia">Multimedia</option>
                    <option value="Housing">Housing</option>
                    <option value="Entertainment">Entertainment</option>
                    <option value="Professional Material">Professional Material</option>
                    <option value="Other">Other</option>
                </select>
                <br>
                <label for="picturePath" class="sr-only">Picture (doesn't work yet)</label>
                <input type="file" class="form-control" id="picturePath" name="picturePath" value="" placeholder="picturePath"/>
                <br>
                <button type="submit" class="btn btn-lg btn-primary btn-block">Add this item <span class="glyphicon glyphicon-gift"></span></button>
            </form>
        </div>
    </body>
</html>
