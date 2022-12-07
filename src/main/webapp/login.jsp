<%--
  Created by IntelliJ IDEA.
  User: TRUONGMAI
  Date: 12/6/2022
  Time: 12:29 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" href="/css/bootstrap.min.css">
</head>
<body>
<form action="/login" method="post">
    <section class="vh-100 bg-success bg-opacity-75">
        <div class="container py-5 h-100">
            <div class="row d-flex justify-content-center align-items-center h-100">
                <div class="col-12 col-md-8 col-lg-6 col-xl-5">
                    <div class="card shadow-2-strong" style="border-radius: 1rem;">
                        <div class="card-body p-5 text-center">
                            <form>
                                <h3 class="mb-5">Sign in</h3>
                                <div class="form-outline mb-4">username
                                    <input type="text" id="username" name="username" class="form-control form-control-lg"/>
                                    <label class="form-label">User Name</label>
                                </div>
                                <div class="form-outline mb-4">
                                    <input type="password" id="password" name="password" class="form-control form-control-lg"/>
                                    <label class="form-label">Password</label>
                                </div>
                                <button class="btn btn-primary btn-lg btn-block" type="submit">Login</button>
                            </form>
                            <hr class="my-4">
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
</form>
</body>
</html>
