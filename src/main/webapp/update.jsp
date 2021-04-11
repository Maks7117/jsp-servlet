<%--
  Created by IntelliJ IDEA.
  User: ALLA
  Date: 07-Feb-21
  Time: 00:39
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>


<div>Имя: <c:out value="${requestScope.teacher.name}"/> </div>
<div>Salary: <c:out value="${requestScope.teacher.salary}"/> </div>
<div>Возраст: <c:out value="${requestScope.teacher.age}"/> </div>

<br />

<form method="post" action="<c:url value='/update'/>">

    <label>Новое имя: <input type="text" name="name" /></label><br>

    <label>New salary: <input type="text" name="salary" /></label><br>

    <input type="number" hidden name="id" value="${requestScope.teacher.id}"/>

    <input type="submit" value="Ok" name="Ok"><br>
</form>
</body>
</html>