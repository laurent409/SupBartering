<%-- 
    Document   : adminManage
    Created on : 13 déc. 2015, 13:05:12
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
        <title>Supbartering: Manage objects</title>
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
        <div class="jumbotron">
            <div class="container">
                <br>
                <h2>Welcome back to your SupBartering dashbord ${sessionScope.user.userName} !
                    <span class="glyphicon glyphicon-shopping-cart"></span>
                </h2>
                <p>You can manage here all of your items ! </p>
            </div>
        </div>
        <div class="container">
            <div class="panel panel-default">
                <!-- Default panel contents -->
                <div class="panel-heading"><h4>All items added</h4></div>

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
                    <c:forEach items="${allItems}" var="item">
                        <tr>
                            <td>
                                <a href="${pageContext.servletContext.contextPath}/admin/item-details?idItem=${item.id}">
                                    <span class="glyphicon glyphicon-info-sign"></span>
                                </a>
                                <c:out value="${item.name}"/>                            
                            </td>
                            <td>
                                <c:out value="${item.description}"/>
                            </td>
                            <td>
                                <c:out value="€${item.price}"/>
                            </td>
                            <td>
                                <c:out value="${item.type}"/>
                            </td>
                            <td>
                                <c:out value="${item.dateCreation}"/>
                            </td>
                        </tr>
                    </c:forEach>                    
                    </tbody>
                </table>
            </div>
            <div class="panel panel-default">
                <!-- Default panel contents -->
                <div class="panel-heading">
                    <h4>Your own items</h4>
                </div>
                <!-- Table -->
                <table class="table">
                    <thead>
                        <tr>
                            <th>Name</th>
                            <th>Description</th>
                            <th>Price</th>
                            <th>Type</th>
                            <th>Added</th>
                            <th><span class="glyphicon glyphicon-remove"</span></th>
                        </tr>                    
                    </thead>
                    <tbody>
                    <c:forEach items="${myOwnItems}" var="item">
                        <c:url value="/admin/delete-confirmation?idItem=${item.id}" var="deleteItem">
                            <c:param name="idItem" value="${item.id}"/>
                        </c:url>
                        <c:url value="/admin/item-details?idItem=${item.id}" var="detailsItem">
                            <c:param name="idItem" value="${item.id}"/>
                        </c:url>                        
                        <tr>
                            <td>
                                <a href="${pageContext.servletContext.contextPath}/admin/item-details?idItem=${item.id}">
                                    <span class="glyphicon glyphicon-info-sign"></span>
                                </a>
                                <c:out value="${item.name}"/>                            
                            </td>
                            <td>
                                <c:out value="${item.description}"/>
                            </td>
                            <td>
                                <c:out value="€${item.price}"/>
                            </td>
                            <td>
                                <c:out value="${item.type}"/>
                            </td>
                            <td>
                                <c:out value="${item.dateCreation}"/>
                            </td>
                            <td>
                                <a href="${pageContext.servletContext.contextPath}/admin/delete?idItem=${item.id}">
                                    <span class="glyphicon glyphicon-trash"</span>
                                </a>
                            </td>
                        </tr>
                    </c:forEach>       
                    </tbody>
                </table>
            </div>
        </div>
    </body>
</html>
