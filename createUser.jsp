<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
			<h1 class="top-text">新規ユーザー登録</h1>
			<p class="login-coment">すべて入力してください</p>
			<form action="/OlympicQuiz/CreateUser" method="post" class="quiz-form">
				<div class="text-box">
					<p class="text-coment">ユーザーID:
					<br>(例)yamada 	※20字以内の半角英字で入力してください。</p>
					<input type="text" name="id" pattern="^[A-Za-z]+$" maxlength="20" style="width: 180px; height: 24px;" required>
				</div>
				<div class="text-box">
					<p class="text-coment">パスワード:
					<br>※4文字以上の半角英数字で入力してください。</p>
					<input type="password" name="pass"  pattern="^([0-9A-Za-z]{4,})$" style="width: 180px; height: 24px;" required>
				</div>
				<div class="text-box">
					<p class="text-coment">名前:
					<br>（例）山田</p>
					<input type="text" name="name" maxlength="20" style="width: 180px; height: 24px;" required>
				</div>

				<input type="submit" value="登録" class="btn-square btn"><br>
			</form>
		</div>
	</div>
	<div class="text-aline-center">
		<a href='http://127.0.0.1:8080/OlympicQuiz/index.jsp'>戻る</a>
	</div>
</div>
</body>
</html>

