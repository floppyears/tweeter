<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Register</title>
    <meta name="layout" content="custom"/>
</head>

<body>
    <div>
        <g:hasErrors bean="${user}">
            <div class="errors">
                <g:renderErrors bean="${user}"/>
            </div>
        </g:hasErrors>
        <g:form action="register" role="form">
            <div class="form-group">
                <label for="username">Username</label>
                <g:textField id="username" class="form-control" name="username" value="${user?.username}" placeholder="username"/>
            </div>
            <div class="form-group">
                <label for="firstName">First Name</label>
                <g:textField class="form-control" name="firstName" value="${user?.firstName}" placeholder="John"/>
            </div>
            <div class="form-group">
                <label for="lastName">Last Name</label>
                <g:textField class="form-control" name="lastName" value="${user?.lastName}" placeholder="Doe"/>
            </div>
            <div class="form-group">
                <label for="email">Email</label>
                <g:textField class="form-control" name="email" value="${user?.email}" placeholder="johndoe@example.com"/>
            </div>
            <g:submitButton name="register" value="Register" class="btn btn-default" />
        </g:form>
    </div>
</body>
</html>