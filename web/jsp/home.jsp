<%-- 
    Document   : index
    Created on : 7 déc. 2015, 18:52:53
    Author     : Laurent
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css" rel="stylesheet">
        <title>SupBartering</title>
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
        <div class="jumbotron">
            <div class="container">
                <br>
                <h1>Welcome to SupBartering ! <span class="glyphicon glyphicon-shopping-cart"></span></h1>
                <p>SupBartering is a new way for selling off all items ! </p>
                <c:set var="numberOfUsers" value="${numberOfUsers}" scope="page" />
                <p>There are ${numberOfUsers} registered users.</p>
                <c:if test="${empty username}">
                <p><a class="btn btn-primary btn-lg" href="login" role="button">Get started !</a> or <a href="register" role="button">Sign-up</a></p>
                </c:if>
            </div>
        </div>
        <div class="container">
            <div class="panel panel-default">
                <!-- Default panel contents -->
                <div class="panel-heading"><h4>Last items added</h4></div>

                <!-- Table -->
                <table class="table">
                    <thead>
                        <tr>
                            <th>Name</th>
                            <th>Description</th>
                            <th>Price</th>
                            <th>Type</th>
                            <th>Added</th>
                        </tr>                    
                    </thead>
                    <tbody>
                    <c:forEach items="${items}" var="item">
                        <tr>
                            <td>
                                <a href="${pageContext.servletContext.contextPath}/item-details?idItem=${item.id}">
                                    <span class="glyphicon glyphicon-info-sign"></span>
                                </a>
                            </td>
                            <td><c:out value="${item.description}"/></td>
                            <td><c:out value="€${item.price}"/></td>
                            <td><c:out value="${item.type}"/></td>
                            <td><c:out value="${item.dateCreation}"/></td>
                        </tr>
                    </c:forEach>                    
                    </tbody>
                </table>
            </div>        
        </div>
        <script src="/ressources/js/jquery-1.11.3.min.js"></script>
        <script src="/ressources/js/bootstrap.min.js"></script>
        <script src="/ressources/js/npm.js"></script>
    </body>
</html>
