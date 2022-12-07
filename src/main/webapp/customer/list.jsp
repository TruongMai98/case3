<%--
  Created by IntelliJ IDEA.
  User: TRUONGMAI
  Date: 12/5/2022
  Time: 12:34 PM
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
<section class="container-sm">
    <div class="card-header my-3">All Products</div>
    <div class="row">
        <c:forEach items="${requestScope['products']}" var="product">
            <div class="card col-3 my-1 mx-5">
                <img src="${product.getImage()}" class="card-img-top " alt="...">
                <div class="card-body">
                    <a href="/customers?action=view&id=${product.getId()}" class="text-success opacity-100 text-decoration-none">
                        <h5 class="card-title ">${product.getName()}</h5>
                    </a>
                    <p class="card-text">${product.getDescription()}</p>
                    <a href="#" class="btn btn-success opacity-75 ">Add to cart</a>
                </div>
            </div>
        </c:forEach>
    </div>
</section>


<footer>
    <jsp:include page="/footer/footer.jsp"></jsp:include>
</footer>
</body>
</html>
