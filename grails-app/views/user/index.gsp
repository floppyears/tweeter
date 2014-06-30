<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
  <title>Home</title>
  <meta name="layout" content="custom"/>
</head>
<body>
<g:if test="${strSaved == "success"}">
    <div class="alert alert-success" role="alert">Successfully tweeted!</div>
</g:if>
<g:if test="${strSaved == "fail"}">
    <div class="alert alert-danger" role="alert">Something went wrong. Your tweet was not heard.</div>
</g:if>
<h4>Tweet</h4>
<g:form action="create" controller="tweet" role="form">
    <div class="form-group">
        <g:textArea class="form-control" name="text" value="" />
    </div>
    <g:submitButton class="btn btn-default" name="create" value="Save" />
</g:form>
</body>
</html>