<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>Admin</title>
    <link rel="stylesheet" href="/css/bootstrap.min.css">
</head>
<body>
<h1>Product list</h1>
<div class="container-sm row mx-auto">
    <div class="col-md-4 w-25 mx-auto">
        <a href="/products?action=create">Create new product</a>
    </div>
    <div class="col-md-4 w-25 mx-auto">
      <a href="/customers?action=list">Show view store</a>
    </div>
    <div class="col-md-4 w-25 mx-auto">
         <a href="/logout">Logout</a>
    </div>
</div>

<div class="container-sm my-3">
    <form action="" method="get">
        <table class="mx-auto w-75">
            <tr class="col-xxl-12">
                <td>
                    <input type="text" name="search" placeholder="Search by name" class="w-100">
                </td>
                <td>
                    <input type="submit" value="Search">
                </td>
            </tr>
        </table>
    </form>
</div>
<div class="container-sm">
    <table class="table table-striped">
        <tr>
            <td>Id</td>
            <td>Name</td>
            <td>Price</td>
            <td>Tile</td>
            <td>Description</td>
            <td>CategoryId</td>
            <td>Image</td>
            <td></td>
            <td></td>
        </tr>
        <c:forEach items="${requestScope['products']}" var="product">
            <tr>
                <td>${product.getId()}</td>
                <td>
                    <a href="/products?action=view-ad&id=${product.getId()}">${product.getName()}</a>
                </td>
                <td>${product.getPrice()}</td>
                <td>${product.getTitle()}</td>
                <td>${product.getDescription()}</td>
                <td>${product.getCategoryId()}</td>
                <td>
                    <img width="70" height="70" src="${product.getImage()}" alt="...">
                </td>
                <td><a href="/products?action=edit&id=${product.getId()}">Edit</a></td>
                <td><a href="/products?action=delete&id=${product.getId()}">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</div>
<div class="container-sm text-center">
    <c:forEach var="pageId" begin="1" end="${requestScope['totalPage']}">
        <a href="/products?page=${pageId}">${pageId}</a>
    </c:forEach>
</div>

</body>
</html>