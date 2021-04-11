<%@ page import="by.sheremet.modele.Teacher" %>
<%@ page import="by.sheremet.repository.PersonRepositoryInMemory" %>
<%@ page import="by.sheremet.logic.Salary" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Teachers</title>
</head>
<body>

<p><a href='<c:url value="/" />'>Head</a></p>
<p><a href='<c:url value="/add"/>'>Add new teacher</a></p>
<p><a href='<c:url value="/login" />'>Log in</a></p>

<h2>All Teachers</h2><br />

<c:forEach var="teacher" items="${requestScope.teachers}">
    <ul>

        <li>Имя: <c:out value="${teacher.name}"/></li>

        <li>Salary: <c:out value="${teacher.salary}"/></li>

        <li>Возраст: <c:out value="${teacher.age}"/></li>

        <form method="post" action="<c:url value='/delete'/>">
            <input type="number" hidden name="id" value="${teacher.id}" />
            <input type="submit" name="delete" value="Delete"/>
        </form>

        <form method="get" action="<c:url value='/update'/>">
            <input type="number" hidden name="id" value="${teacher.id}" />
            <input type="submit" value="Update"/>
        </form>
        <form method="get" action="<c:url value='/aver'/>">
            <input type="number" hidden name="id" value="${teacher.id}" />
            <input type="submit" value="Average Salary"/>
        </form>
    </ul>
    <hr />

</c:forEach>
</body>
</html>

