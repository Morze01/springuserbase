<%--
  Created by IntelliJ IDEA.
  User: morze
  Date: 03.06.19
  Time: 9:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
    <link href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/js/bootstrap.min.js"></script>
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
</head>
<body>
<form class="form-horizontal" action='/register/process' method="POST">
    <fieldset>
        <div id="legend">
            <legend class="">Register</legend>
        </div>
        <div class="control-group">
            <!-- Username -->
            <label class="control-label"  for="username">Username</label>
            <div class="controls">
                <input type="text" id="username" name="username" placeholder="" class="input-xlarge">
                <p class="help-block">Username can contain any letters or numbers, without spaces</p>
            </div>
        </div>

        <!-- Fullname -->
        <label class="control-label"  for="fullname">Username</label>
        <div class="controls">
            <input type="text" id="fullname" name="fullname" placeholder="" class="input-xlarge">
            <p class="help-block">Please, enter you name</p>
        </div>
        </div>

        <%--<div class="control-group">--%>
            <%--<!-- E-mail -->--%>
            <%--<label class="control-label" for="email">E-mail</label>--%>
            <%--<div class="controls">--%>
                <%--<input type="text" id="email" name="email" placeholder="" class="input-xlarge">--%>
                <%--<p class="help-block">Please provide your E-mail</p>--%>
            <%--</div>--%>
        <%--</div>--%>

        <div class="control-group">
            <!-- Password-->
            <label class="control-label" for="password">Password</label>
            <div class="controls">
                <input type="password" id="password" name="password" placeholder="" class="input-xlarge">
                <p class="help-block">Password should be at least 4 characters</p>
            </div>
        </div>

        <%--<div class="control-group">--%>
            <%--<!-- Password -->--%>
            <%--<label class="control-label"  for="password_confirm">Password (Confirm)</label>--%>
            <%--<div class="controls">--%>
                <%--<input type="password" id="password_confirm" name="password_confirm" placeholder="" class="input-xlarge">--%>
                <%--<p class="help-block">Please confirm password</p>--%>
            <%--</div>--%>
        <%--</div>--%>

        <div class="control-group">
            <!-- Button -->
            <div class="controls">
                <button class="btn btn-success">Register</button>
            </div>
        </div>
    </fieldset>
</form>
</body>
</html>
