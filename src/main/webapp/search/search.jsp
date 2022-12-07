<%--
  Created by IntelliJ IDEA.
  User: TRUONGMAI
  Date: 12/5/2022
  Time: 3:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<section class="header-main border-bottom bg-light">
    <div class="container-sm">
        <div class="row p-2 pt-3 pb-3 d-flex align-items-center">
            <div class="col-md-2">
                <img  class="d-none d-md-flex" src="https://cdn-icons-png.flaticon.com/512/862/862819.png" width="50">
            </div>
            <div class="col-md-8">
                <div class="d-flex form-inputs ">
                    <form action="/customers?action=list" method="get" class="col-12 d-flex m-0">
                        <input class="form-control" type="text" name="search" placeholder="Search any product...">
                        <input type="submit" value="Search">
                    </form>
                </div>
            </div>

            <div class="col-md-2">
                <a href="https://colorlib.com/etc/404/colorlib-error-404-14/" class="text-decoration-none">
                    <div class="d-flex d-none d-md-flex flex-row-reverse align-items-center ">
                        <div class="d-flex flex-column ms-2">
                            <span class="qty text-dark">Cart</span>
                        </div>
                        <div>
                            <img src="https://cdn-icons-png.flaticon.com/512/1170/1170678.png" alt="" width="30">
                        </div>

                    </div>
                </a>
            </div>
        </div>
    </div>
</section>
</body>
</html>
