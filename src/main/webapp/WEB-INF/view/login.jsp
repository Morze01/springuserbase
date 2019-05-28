<%--
  Created by IntelliJ IDEA.
  User: morze
  Date: 14.05.19
  Time: 12:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org"
      xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3">
<head>
    <meta charset="utf-8">
    <title>Login page</title>
    <%--<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">--%>
    <%--<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>--%>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
</head>
<body>
<%--<div th:if="${param.error}">--%>
    <%--Invalid username and password.--%>
<%--</div>--%>
<%--<div th:if="${param.logout}">--%>
    <%--You have been logged out.--%>
<%--</div>--%>
<div class="container">
    <div class="col-lg-6 col-md-6 col-xs-11 col-md-offset-3 col-xs-offset-2 login-form">
        <div class="col-xs-8 col-md-offset-2">
            <h2 style="text-align: center;">Добро пожаловать</h2>
            <form th:action="@{/login}" method="post">
                <div class="form-group login-group">
                    <input type="text" class="form-control" id="uName" name="login" placeholder="Login"
                           required/>
                    <br>
                    <input type="password" class="form-control" type="text" id="uPass" name="password"
                           required placeholder="Password" required/>
                    <br>
                    <input type="submit" class="btn btn-primary btn-block" value="Login"/>
                <%--<label> User Name : <input type="text" name="login"/> </label><br>--%>
                <%--<label> Password: <input type="password" name="password"/> </label><br>--%>
                <%--<input type="submit" value="Sign In"/><br>--%>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>
