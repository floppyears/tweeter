<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
  <title>Home</title>
</head>
<body>
    <div>
        <g:form action="create" controller="tweet">
            <g:textArea name="tweet" value="" />
            <g:submitButton name="create" value="Save" />
        </g:form>
    </div>
</body>
</html>