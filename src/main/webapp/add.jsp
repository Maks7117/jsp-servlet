<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create new teacher</title>
</head>
<body>
<form action="/web/add" method="post">
    <label for="name">Name
        <input type="text" id="name" name="name">
    </label>
    <label for="age">Age
        <input type="text" id="age" name="age">
    </label>
    <label for="salary">Salary
        <input type="text" id="salary" name="salary">
    </label>
    <input type="submit" value="Add">
</form>
<p><a href='<c:url value="/" />'>Head</a></p>
<p><a href='<c:url value="/show"/>'>List teacher</a></p>
<p><a href='<c:url value="/login" />'>Log in</a></p>
</body>
</html>
