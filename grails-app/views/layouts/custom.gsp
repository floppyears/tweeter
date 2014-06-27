<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title><g:layoutTitle default="Tweeter"/></title>
    <asset:stylesheet src="application.css"/>
    <asset:javascript src="application.js"/>
    <g:layoutHead/>
</head>

<body>
<nav class="navbar navbar-default" role="navigation">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <a class="navbar-brand" href="#">Brand</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <g:if test="${user}">
                <g:form action="logout" controller="user" class="navbar-form navbar-right" role="form">
                    <p class="navbar-text">${user.username}</p>
                    <g:submitButton class="btn btn-default" name="logout" value="Logout" />
                </g:form>
            </g:if>
            <g:else>
                <g:form action="login" controller="user" class="navbar-form navbar-right" role="form">
                    <div class="form-group">
                        <g:textField name="username" type="text" class="form-control" placeholder="username" />
                    </div>
                    <g:submitButton class="btn btn-default" name="login" value="Login" />
                </g:form>
            </g:else>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>
    <div class="container-fluid">
        <div class="col-md-4"></div>
        <div class="col-md-4">
            <g:layoutBody/>
        </div>
        <div class="col-md-4"></div>
    </div>
</body>
</html>