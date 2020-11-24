<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://unpkg.com/tailwindcss@^2/dist/tailwind.min.css"
	rel="stylesheet">
<title>Liste of Users</title>
</head>
<body>
	<div
		class="relative flex flex-col items-center justify-center min-h-screen pt-4 bg-white min-w-screen">

		<h2>List of Users</h2>



			<table
				class="border-collapse table-auto  whitespace-no-wrap bg-white table-striped relative">

				<thead>
					<tr class="bg-gray-100">
						<th>ID</th>
						<th>Name</th>
						<th>Role</th>
					</tr>
				</thead>
				<c:forEach var="user" items="${users}">
					<tr>
						<td>${user.id}</td>
						<td>${user.username}</td>
						<td>${user.role}</td>
					</tr>
				</c:forEach>
			</table>
			
			<a href="/" class="mb-2 text-xl font-heading">Retour Home</a>
	
	</div>
	</body>
</html>