<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.User" %>
<%
	// セッションスコープからユーザー情報を取得
User createUser = (User) session.getAttribute("createUser");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新規ユーザー登録</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
<div class="wrapper">
    <div class="login text-aline-center">
		<div>
			<h1 class="top-text">新規登録成功</h1>
				<% if(createUser != null) { %>
					<p class="text-coment">☆新規登録に成功しました☆(｀・ω・´)</p>
					<p class="text-coment">早速ログインしてクイズに挑戦しましょう！</p>
					<a href="/OlympicQuiz/">
						<button class="btn-square btn">ログイン画面へ</button>
   			 		</a>
		</div>
	</div>
	<div class="text-aline-center">
		<% } else { %>
			<p class="text-coment">新規登録できませんでした(; ･`д･´)</p>
			<a href="/OlympicQuiz/createUser">トップへ戻る</a>
		<% } %>
    </div>
</div>
</body>
</html>