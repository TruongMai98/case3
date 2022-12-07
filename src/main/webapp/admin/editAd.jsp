<%--
  Created by IntelliJ IDEA.
  User: TRUONGMAI
  Date: 12/4/2022
  Time: 2:35 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Admin</title>
</head>
<body>
<p>
    <a href="/products">Back to product list</a>
</p>
<form method="post">
    <fieldset>
        <legend>Product information</legend>
        <table>
            <tr>
                <td>Id</td>
                <td>
                    <input type="number" name="id" id="id" value="${requestScope['products'].getId()}" disabled>
                </td>
            </tr>
            <tr>
                <td>Name</td>
                <td>
                    <input type="text" name="name" id="name" value="${requestScope['products'].getName()}">
                </td>
            </tr>
            <tr>
                <td>Price</td>
                <td>
                    <input type="text" name="price" id="price" value="${requestScope['products'].getPrice()}">
                </td>
            </tr>
            <tr>
                <td>Title</td>
                <td>
                    <input type="text" name="title" id="title" value="${requestScope['products'].getTitle()}">
                </td>
            </tr>
            <tr>
                <td>Category id</td>
                <td>
                    <input type="text" name="categoryId" id="categoryId"
                           value="${requestScope['products'].getCategoryId()}">
                </td>
            </tr>
            <tr>
                <td>Description</td>
                <td>
                    <input type="text" name="description" id="description"
                           value="${requestScope['products'].getDescription()}">
                </td>
            </tr>
            <tr>
                <td>Image</td>
                <td>
                    <input type="text" name="image" id="image" value="${requestScope['products'].getImage()}">
                </td>
            </tr>
            <tr>
                <td>
                    <a href="/products">
                        <input type="button" value="No">
                    </a>
                </td>
                <td>
                    <input type="submit" value="Save">
                </td>
            </tr>
           <%-- <tr>
                <label for="avatar">Choose a profile picture:</label>
                <input type="file"
                       id="avatar" name="file"
                       accept="image/png, image/jpeg">
            </tr>--%>
        </table>
    </fieldset>
</form>
</body>
</html>
