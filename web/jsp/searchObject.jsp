<%-- 
    Document   : searchObject
    Created on : 14 déc. 2015, 11:58:44
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
        <title>SupBartering: Search Items</title>
    </head>
    <body>
        <nav class="navbar navbar-inverse navbar-fixed-top">
            <div class="container">
                <div class="navbar-header">
                    <a class="navbar-brand" href="${pageContext.servletContext.contextPath}/home">SupBartering</a>
                </div>
                <c:if test="${not empty sessionScope.user}">
                    <ul class="nav navbar-nav">
                        <li><a href="${pageContext.servletContext.contextPath}/admin/add-object">
                                <span class="glyphicon glyphicon-plus-sign"></span> New Item
                            </a>
                        </li>
                    </ul>
                </c:if>
                <form method="POST" class="navbar-form navbar-left">
                    <div class="form-group">
                        <input type="text" name="searchLikeThis" id="searchLikeThis" class="form-control" placeholder="Search item" required>
                    </div>
                    <button type="submit" class="btn btn-default">
                        <span class="glyphicon glyphicon-search"></span>
                    </button>
                </form>
                <ul class="nav navbar-nav navbar-right">
                <c:if test="${not empty sessionScope.user}">
                    <li><a href="${pageContext.servletContext.contextPath}/admin/settings"><span class="glyphicon glyphicon-user"></span> My Settings</a></li>
                    <li><a href="${pageContext.servletContext.contextPath}/logout">Sign-out</a></li>
                </c:if>
                <c:if test="${empty sessionScope.user}">
                    <li><a href="${pageContext.servletContext.contextPath}/login">Sign-in</a></li>
                    <li><a href="${pageContext.servletContext.contextPath}/register">Sign-up</a></li>
                </c:if>
                </ul>
            </div>  
        </nav>
        <div class="jumbotron">
            <div class="container">
                <br>
                <h2>Are you seeking items ? <span class="glyphicon glyphicon-shopping-cart"></span></h2>
                <p>Here you can see all items you've sought ! </p>
            </div>
        </div>
        <div class="container">
            <div class="panel panel-default">
                <!-- Default panel contents -->
                <div class="panel-heading"><h4>Item found</h4></div>

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
                    <c:forEach items="${foundItems}" var="item">
                        <tr>
                            <td><c:out value="${item.name}"/></td>
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
