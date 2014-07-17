<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
  <title>Home</title>
  <meta name="layout" content="custom"/>
</head>
<body>
<h4>Tweet</h4>
<g:form action="create" controller="tweet" role="form">
    <div class="form-group">
        <g:textArea class="form-control" name="text" value="" />
    </div>
    <g:submitButton class="btn btn-default" name="create" value="Save" />
</g:form>
<g:alert saved="${flash.tweetMsg}" />
<div>
    <g:if test="${user.followsTweets}">
        <g:render template="/tweet/tweet" collection="${user.followsTweets.sort{a, b -> b.dateCreated <=> a.dateCreated}}" var="tweet" />
    </g:if>
</div>
</body>
</html>