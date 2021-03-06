<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>My user base</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
    <%--<link href="<c:url value="../resources/css/bootstrap.min.css" />"--%>
          <%--rel="stylesheet">--%>
    <%--<script src="<c:url value="../resources/js/jquery-1.11.1.min.js" />"></script>--%>
    <%--<script src="<c:url value="../resources/js/bootstrap.min.js" />"></script>--%>

</head>
<body>
<div class="container">
    <div class="col-md-offset-2 col-md-7">
        <h2 class="text-center">User base</h2>
        <div class="panel panel-info">
            <div class="panel-heading">
                <div class="panel-title">Add User</div>
            </div>
            <div class="panel-body">
                <form:form action="saveUser" cssClass="form-horizontal"
                           method="post" modelAttribute="user">

                    <!-- need to associate this data with customer id -->
                    <form:hidden path="id" />

                    <div class="form-group">
                        <label for="name" class="col-md-3 control-label">Name</label>
                        <div class="col-md-9">
                            <form:input path="name" cssClass="form-control" />
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="password" class="col-md-3 control-label">Password</label>
                        <div class="col-md-9">
                            <form:input path="password" cssClass="form-control" />
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="login" class="col-md-3 control-label">Login</label>
                        <div class="col-md-9">
                            <form:input path="login" cssClass="form-control" />
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="role" class="col-md-3 control-label">Role</label>
                        <div class="col-md-9">
                            <%--<select path="role" id="role" cssClass="form-control" />--%>
                            <%--<option>user</option><option>admin</option>--%>
                            <%--</select>--%>
                            <form:input path="role" cssClass="form-control" />
                                <select class="form-control" id="role" rows="2" name="role">
                                    <option>user</option>
                                    <option>admin</option>
                                </select>
                        </div>
                    </div>

                    <div class="form-group">
                        <!-- Button -->
                        <div class="col-md-offset-3 col-md-9">
                            <form:button cssClass="btn btn-primary">Submit</form:button>
                        </div>
                    </div>

                </form:form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
