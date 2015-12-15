<%-- 
    Document   : confirmationDeleteItem
    Created on : 14 déc. 2015, 15:42:28
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
        <title>Supbartering: Confirmation</title>
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
        <div class="jumbotron alert-danger" role="alert">
            <div class="container">
                <br>
                <h2>Are you serious ${sessionScope.user.userName} ?!
                    <span class="glyphicon glyphicon-trash"></span> 
                </h2>
                <p>Do you really want to delete this item ? </p>
            </div>
        </div>
        <div class="container text-center">
            <div class="col-md-12 text-center">
                <div class="thumbnail">
                    <c:set var="itemToDelete" value="${itemToDelete}" />
                    <div class="caption">
                        <h3><c:out value="${itemToDelete.name}"/></h3>
                        <p><c:out value="${itemToDelete.description}"/></p>
                        <h5>Price : €<c:out value="${itemToDelete.price}"/></h5>
                        <h5>Type : <c:out value="${itemToDelete.type}"/></h5>
                        <form method="POST">
                            <input type="hidden" name="itemToDeleteConfirmated" id="itemToDeleteConfirmated" value="<c:out value="${itemToDelete.id}"/>"
                            <p>
                                <a href="${pageContext.servletContext.contextPath}/admin" class="btn btn-danger" role="button">
                                    <span class="glyphicon glyphicon-remove-circle"></span>
                                </a>
                                <button type="submit" class="btn btn-success">
                                    <span class="glyphicon glyphicon-ok-circle"></span>
                                </button>
                            </p>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
