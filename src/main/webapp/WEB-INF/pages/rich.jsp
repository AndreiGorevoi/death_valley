<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: javac
  Date: 9/13/2020
  Time: 3:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="<c:url value="/richest"/>" method="get">
    <input id="richest-account" readonly value="richest">
    <button>Get</button>
</form>
<form action="<c:url value="/sum"/>" method="get">
    <input id="sum-accounts"  readonly value="sum">
    <button>Get</button>
</form>
</body>
</html>
