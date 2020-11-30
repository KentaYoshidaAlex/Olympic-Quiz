<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.Judge"%>
<%
String error = (String) request.getAttribute("error");
%>

<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!--     <link rel="stylesheet" type="text/css" href="css/style.css"> -->
<title>ログイン画面</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
<div class="wrapper">
    <div class="login text-aline-center">
		<div>
			<h1 class="top-text">ログイン</h1>

			<img src= "image/olympics_tokyo_2021.png" alt="いらすとやオリンピック" height="150"><br>
			<br>

			<%if(error != null){%>
			<%=error %>
			<%} else { %>

			<% }%>

			<form action="/OlympicQuiz/Login" method="post" class="form">

				<div class="text-box">
					<p class="text-coment">ユーザーID:</p>
					<input type="text" name="id" maxlength="8" style="width: 180px; height: 24px;" required>
				</div>
				<div class="text-box">
					<p class="text-coment">パスワード:</p>
					<input type="password" name="pass" maxlength="20" style="width: 180px; height: 24px;" required>
				</div>
				<input type='hidden' name='clearCount' value='0'>
				<input type='hidden' name='missCount' value='0'>
				<input type="submit" name='bttn' value="ログイン" class="btn-square btn">
			</form>
			<div>
				<p class="login-coment">アカウント登録がお済みでない方はこちらへ↓</p>
				<a href="createUser.jsp">
					<button class="btn-square btn">新規登録</button>
				</a>
			</div>
    	</div>
    </div>
	<div class="text-aline-center">
		<a href="adminLogin.jsp">管理者ログイン</a>
    </div>

</div>
</body>
</html>