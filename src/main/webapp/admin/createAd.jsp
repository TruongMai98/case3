<%--
  Created by IntelliJ IDEA.
  User: TRUONGMAI
  Date: 12/4/2022
  Time: 2:20 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Admin</title>
    <link rel="stylesheet" href="/css/bootstrap.min.css">
</head>
<body>
<p>
    <a href="/products">Back to product list</a>
</p>
<form method="post">
    <fieldset class="mx-5 w-25">
        <legend>Product information</legend>
        <table class="table">
            <tr class="row">
                <td>Name</td>
                <td>
                    <input type="text" name="name" id="name" class="w-100">
                </td>
            </tr>
            <tr class="row">
                <td>Price</td>
                <td>
                    <input type="text" name="price" id="price" class="w-100">
                </td>
            </tr>
            <tr class="row">
                <td>Title</td>
                <td>
                    <input type="text" name="title" id="title" class="w-100">
                </td>
            </tr>
            <tr class="row">
                <td>Category id</td>
                <td>
                    <input type="text" name="categoryId" id="categoryId" class="w-100">
                </td>
            </tr>
            <tr class="row">
                <td>Description</td>
                <td>
                    <input type="text" name="description" id="description" size="70">
                </td>
            </tr>
            <tr class="row">
                <td>Image</td>
                <td>
                    <input type="text" name="image" id="image" size="70">
                </td>
            </tr>
            <tr class="row">
                <td class="col-1 mx-3">
                    <input type="submit" value="Save" class="btn btn-primary">
                </td>
                <td class="col-1">
                    <a href="/products">
                        <input type="button" value="No" class="btn btn-success">
                    </a>
                </td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
