<%@ taglib prefix="th" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: morze
  Date: 02.06.19
  Time: 0:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>Registration</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>

<body>

<div class="container">
    <div class="col-lg-6 col-md-6 col-xs-11 col-md-offset-3 col-xs-offset-2 login-form">
        <div class="col-xs-8 col-md-offset-2">
            <h2 style="text-align: center;">Register</h2>
            <form method="POST" th:action="@{/register}" id="registerForm">
                <div class="form-group login-group">
                    <label for="username">Username: </label>
                    <input id="username" type="text" name="username"/><br/>

                    <label for="password">Password: </label>
                    <input id="password" type="password" name="password"/><br/>

                    <label for="fullname">Full name: </label>
                    <input id="fullname" type="text" name="fullname"/><br/>

                    <input type="submit" value="Register"/>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>
