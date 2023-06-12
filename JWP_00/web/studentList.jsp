<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Student Management</title>
</head>
<body>
    <h1>Student Management</h1>
    <form action="StudentServlet" method="post">
        <input type="hidden" name="action" value="add">
        <label for="studentName">Student Name:</label>
        <input type="text" id="studentName" name="studentName" required>
        <input type="submit" value="Add Student">
    </form>

    <table>
        <tr>
            <th>Student ID</th>
            <th>Student Name</th>
            <th>Actions</th>
        </tr>
        <c:forEach items="${studentList}" var="student">
            <tr>
                <td>${student.studentId}</td>
                <td>${student.studentName}</td>
                <td>
                    <form action="StudentServlet" method="post" style="display: inline-block;">
                        <input type="hidden" name="action" value="update">
                        <input type="hidden" name="studentId" value="${student.studentId}">
                        <input type="text" name="studentName" value="${student.studentName}" required>
                        <input type="submit" value="Update">
                    </form>
                    <form action="StudentServlet" method="post" style="display: inline-block;">
                        <input type="hidden" name="action" value="delete">
                        <input type="hidden" name="studentId" value="${student.studentId}">
                        <input type="submit" value="Delete">
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
