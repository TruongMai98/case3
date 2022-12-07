<%--
  Created by IntelliJ IDEA.
  User: TRUONGMAI
  Date: 12/4/2022
  Time: 11:12 AM
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
        <td>${requestScope["products"].getId()}</td>
      </tr>
      <tr>
        <td>Name</td>
        <td>${requestScope["products"].getName()}</td>
      </tr>
      <tr>
        <td>Price</td>
        <td>${requestScope["products"].getPrice()}</td>
      </tr>
      <tr>
        <td>Title</td>
        <td>${requestScope["products"].getTitle()}</td>
      </tr>
      <tr>
        <td>Category id</td>
        <td>${requestScope["products"].getCategoryId()}</td>
      </tr>
      <tr>
        <td>Description</td>
        <td>${requestScope["products"].getDescription()}</td>
      </tr>
      <tr>
        <td>Image</td>
        <td>${requestScope["products"].getImage()}</td>
      </tr>
      <tr>
        <td>
          <a href="/products">
            <input type="button" value="No">
          </a>
        </td>
        <td>
          <input type="submit" value="Yes">
        </td>
      </tr>
    </table>
  </fieldset>
</form>
</body>
</html>
