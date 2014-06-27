<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Register</title>
</head>

<body>
    <div>
        <g:hasErrors bean="${user}">
            <div class="errors">
                <g:renderErrors bean="${user}"/>
            </div>
        </g:hasErrors>
        <g:form action="register">
            <div>
                <label for="username"></label>
                <g:textField name="username" value="${user?.username}"/>
            </div>
            <div>
                <label for="firstName"></label>
                <g:textField name="firstName" value="${user?.firstName}"/>
            </div>
            <div>
                <label for="lastName"></label>
                <g:textField name="lastName" value="${user?.lastName}"/>
            </div>
            <div>
                <label for="email"></label>
                <g:textField name="email" value=""/>
            </div>
            <g:submitButton name="register" value="Register" />
        </g:form>
    </div>
</body>
</html>