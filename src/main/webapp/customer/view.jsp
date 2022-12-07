<%--
  Created by IntelliJ IDEA.
  User: TRUONGMAI
  Date: 12/5/2022
  Time: 10:52 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Store</title>
    <link rel="stylesheet" href="/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/style.css">
</head>
<body>
<nav>
    <jsp:include page="/header/header.jsp"></jsp:include>
</nav>

<section>
    <jsp:include page="/search/search.jsp"></jsp:include>
</section>

<section class="py-5">
    <div class="container px-4 px-lg-5 my-5">
        <div class="row gx-4 gx-lg-5 center align-items-c">
            <div class="col-md-6"><img class="card-img-top mb-5 mb-md-0" src="${requestScope['products'].getImage()}" alt="..."></div>
            <div class="col-md-6">
                <div class="small mb-1">${requestScope['products'].getTitle()}</div>
                <h1 class="display-5 fw-bolder">${requestScope['products'].getName()}</h1>
                <div class="fs-5 mb-5">
                    <span>${requestScope['products'].getPrice()} VND</span>
                </div>
                <p class="lead">${requestScope['products'].getDescription()}</p>
                <div class="d-flex">
                    <input class="form-control text-center me-3" id="inputQuantity" type="number" value="1" style="max-width: 3rem">
                    <button class="btn btn-outline-success flex-shrink-0" type="button">
                        <i class="bi-cart-fill me-1"></i>
                        Add to cart
                    </button>
                </div>
            </div>
        </div>
    </div>
</section>


<footer>
    <jsp:include page="/footer/footer2.jsp"></jsp:include>
</footer>

</body>
</html>
