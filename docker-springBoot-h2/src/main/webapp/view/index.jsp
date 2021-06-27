<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Add Student</h2>
	<form action="addStu" method="get">
		Enter New Name : <input type="text" name="name" /> 
		Enter Age :      <input type="number" name="age" /> 
		Enter Grade :      <input type="number" name="grade" /> 
		Enter Address :  <input type="text" name="address" /> 
		<input type="submit" value="addStudent" />
	</form>

	<hr>

	<h2>Get Student</h2>
	<form action="getStu" method="get">
		<input type="submit" value="getStudent" />
	</form>

	<hr>

	<h2>Update Student</h2>
	<form action="updateStu" method="post">
		Enter Id :      <input type="number" name="id" /> 
		Enter New Name :<input type="text" name="name" /> 
						<input type="submit" value="getStudent" />
	</form>

	<hr>

	<h2>Delete Student</h2>
	<form action="deleteStu" method="post">
		Enter Id :<input type="number" name="id" /> 
				  <input type="submit" value="getStudent" />
	</form>
	<hr>

	<table border="1px">
		<thead>
			<tr>
				<td>Stu ID</td>
				<td>Stu Name</td>
				<td>Stu Age</td>
				<td>Stu Grade</td>
				<td>Stu Address</td>
			</tr>
		</thead>
		<c:forEach var="stu" items="${sudents}">

			<tbody>
				<tr>
					<td>${stu.stuId}</td>
					<td>${stu.stuName}</td>
					<td>${stu.stuAge}</td>
					<td>${stu.stuGrade}</td>
					<td>${stu.stuAddress}</td>
				</tr>
			</tbody>

		</c:forEach>
	</table>
</body>
</html>