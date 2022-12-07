<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: TRUONGMAI
  Date: 12/5/2022
  Time: 1:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<nav class="navbar navbar-expand p-2 bg-success bg-opacity-75 ">
    <div class="container-sm">
        <ul class="navbar-nav d-none d-md-flex mr-auto">
            <li class="nav-item">
                <a class="nav-link" href="#" data-abc="true">
                    <img src="https://cdn-icons-png.flaticon.com/512/2713/2713569.png" alt="" width="25">
                </a>
            </li>
            <li>
                <p></p>
                <p class="text-uppercase text-dark">vegetable shop</p>
            </li>
        </ul>
        <ul class="navbar-nav d-flex align-items-center">
            <li class="nav-item">
                <div class="d-flex flex-row">
                    <img src="https://cdn-icons-png.flaticon.com/512/3106/3106773.png" class="rounded-circle"
                         width="30">
                </div>
            </li>
            <c:if test="${requestScope['username'] == null}">
                <li class="nav-item">
                    <a href="/login" class="nav-link d-flex align-items-center"
                       data-abc="true"><span>Login</span><i class='bx bxs-chevron-down'></i></a>
                </li>
            </c:if>
            <c:if test="${requestScope['username'] != null}">
                <li class="nav-item">
                    <a href="#" class="nav-link d-flex align-items-center"
                       data-abc="true"><span>${username}</span><i class='bx bxs-chevron-down'></i></a>
                </li>
                <li class="nav-item">
                    <a href="/logout" class="nav-link d-flex align-items-center"
                       data-abc="true"><span>Logout</span><i class='bx bxs-chevron-down'></i></a>
                </li>
            </c:if>
        </ul>
    </div>
</nav>
</body>
</html>
