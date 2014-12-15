<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
  <title>Home</title>
  <meta name="layout" content="custom"/>
</head>
<body>
<div ng-controller="userController">
    <h4>Tweet</h4>
    <create-tweet></create-tweet>
    <tweet ng-repeat="tweet in tweets|orderBy:'dateCreated':true"></tweet>
</div>
</body>
</html>