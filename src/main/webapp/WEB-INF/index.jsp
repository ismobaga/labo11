<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<link href="https://unpkg.com/tailwindcss@^2/dist/tailwind.min.css"
	rel="stylesheet">
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
<link href="https://unpkg.com/tailwindcss@^2/dist/tailwind.min.css"
	rel="stylesheet">
</head>
<body>
	<div
		class="relative flex flex-col items-center justify-center min-h-screen pt-4 bg-white min-w-screen">

		<security:authorize access="!isAuthenticated()">
			<a
				class="px-8 py-3 mb-1 mr-1 font-bold text-blue-600 uppercase transition-all duration-300 ease-in-out bg-transparent border border-blue-600 border-solid rounded-md outline-none hover:bg-blue-600 hover:text-white active:bg-blue-600 focus:outline-none"
				type="button" href="/login"> Login </a>
		</security:authorize>
		<security:authorize access="isAuthenticated()">
			<div class="content-center w-4/5 h-auto m-5 text-center ">
				<p
					class="text-4xl font-extrabold leading-10 tracking-tight text-gray-900 sm:text-5xl sm:leading-none md:text-6xl">
					Hello! I am <span class="text-indigo-600">${user.username}</span>
				</p>
				<p class="text-5xl font-thin text-indigo-400">${user.role}</p>
			</div>



			<security:authorize access="hasRole('ROLE_ADMIN')">

				<!-- 	<a href="/userAdmin">Admin Page</a> -->


			</security:authorize>
			<security:authorize access="hasRole('ROLE_USER')">
				<!-- <a href="/adminPage">User Page</a> -->

			</security:authorize>
			<a href="/users" class="text-2xl  px-8 py-3 mb-1 mr-1">List Users</a>

			<a
				class="px-8 py-3 mb-1 mr-1 font-bold text-blue-600 uppercase transition-all duration-300 ease-in-out bg-transparent border border-blue-600 border-solid rounded-md outline-none hover:bg-blue-600 hover:text-white active:bg-blue-600 focus:outline-none"
				type="button" href="/logout"> Logout </a>
		</security:authorize>
	</div>
</body>
</html>