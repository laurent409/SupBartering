<%-- 
    Document   : detailsObject
    Created on : 16 déc. 2015, 16:36:40
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
        <title>Supbartering: Item Details</title>
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
                <h2>Item Details
                    <span class="glyphicon glyphicon-info-sign"></span> 
                </h2>
                <p>Here you can see all details of item</p>
            </div>
        </div>
        <div class="container text-center">
            <div class="col-md-12 text-center">
                <div class="thumbnail">
                    <c:set var="itemDetails" value="${itemDetails}" />
                    <div class="caption">
                        <h3><c:out value="${itemDetails.name}"/></h3>
                        <p><c:out value="${itemDetails.description}"/></p>
                        <h5>Price : €<c:out value="${itemDetails.price}"/></h5>
                        <h5>Type : <c:out value="${itemDetails.type}"/></h5>
                        <h5>Created date : <c:out value="${itemDetails.dateCreation}"/></h5>
                        <p>
                            <a href="${pageContext.servletContext.contextPath}/home" class="btn btn-success" role="button">
                                <span class="glyphicon glyphicon-chevron-left"></span> Back
                            </a>
                            <c:if test="${sessionScope.user.id eq itemDetails.idCreator}">
                                <a href="${pageContext.servletContext.contextPath}/admin/delete?idItem=${itemDetails.id}" class="btn btn-danger" role="button">
                                    <span class="glyphicon glyphicon-trash"</span>
                                </a>
                            </c:if>                            
                        </p>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
