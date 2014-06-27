<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>${user.username}'s tweets</title>
</head>

<body>
<g:render template="/tweet/tweet" collection="${user.tweets}" var="tweet" />
</body>
</html>