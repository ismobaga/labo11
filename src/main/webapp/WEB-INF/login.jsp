<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link href="https://unpkg.com/tailwindcss@^2/dist/tailwind.min.css"
	rel="stylesheet">
</head>
<body>
	<div
		class="flex items-center justify-center h-screen bg-gray-700 sm:px-6">


		<div
			class="w-full max-w-sm p-4 bg-gray-900 rounded-md shadow-md sm:p-6">
			<div class="flex items-center justify-center">
				<span class="text-xl font-medium text-white">Login</span>
			</div>

			<p class="text-red-500">${msg}</p>
			<form action="/perform_login" method="POST">
				<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" />
				<div>
					<label for="username" class="block"> <span
						class="text-sm text-white">Username</span> <input
						class="block w-full px-3 py-2 mt-1 text-white rounded bg-gray-700"
						name="username" id="username">
					</label>
				</div>
				<br />
				<div>
					<label for="password"><span class="text-sm text-white">Password</span>
						<input id="password"
						class="block w-full px-3 py-2 mt-1 text-white rounded bg-gray-700"
						name="password"></label>
				</div>

				<div class="mt-6">
					<button type="submit"
						class="w-full p-3  text-sm text-center text-white bg-indigo-500 rounded-md ">Login</button>
				</div>
			</form>
		</div>
	</div>
</body>
</html>