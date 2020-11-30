<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.QuizData" %>
<%
	// セッションスコープからユーザー情報を取得
QuizData createQuiz = (QuizData) session.getAttribute("createQuiz");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新規クイズ登録</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
<div class="wrapper">
    <div class="login text-aline-center">
		<div>
			<h1 class="top-text">新規クイズ登録</h1>
			<% if(createQuiz != null) { %>
			<p class="login-coment">☆新規クイズ登録に成功しました☆(｀・ω・´)</p>
			<p class="login-coment">
			<a href="http://127.0.0.1:8080/OlympicQuiz/quizList.jsp"class="top-text" target="_blank">クイズ一覧へ</a>
			</p>
			<p class="login-coment">
			<a href="/OlympicQuiz/"class="top-text">トップページへ</a>
			</p>


			<% } else { %>
				<p>新規登録できませんでした(; ･`д･´)</p>
				<a href="/OlympicQuiz/createQuiz">新規作成画面へ戻る</a>
			<% } %>
		</div>
	</div>
</div>
</body>
</html>