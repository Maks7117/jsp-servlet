<%@ page import="by.sheremet.modele.Teacher" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="by.sheremet.logic.Salary" %>
<%@ page import="by.sheremet.repository.PersonRepositoryInMemory" %>
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

<%
    HashMap<Integer, Teacher> teachers =
            (HashMap)request.getAttribute("teachers");

%>
<%
    Salary salary = new Salary();
    PersonRepositoryInMemory personRepositoryInMemory = PersonRepositoryInMemory.getInstance();

%>
<table>
    <tr>
        <th>Name</th>
        <th>Average salary:</th>
    </tr>
    <% for (Teacher teacher : teachers.values()){
    %>
    <tr>
        <td><%=teacher.getName()%>
        </td>
        <td><%=salary.averageSalary(teacher.getSalary())%>
        </td>
    </tr>
    <%}%>
</table>


</body>
</html>