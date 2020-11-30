<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!--     <link rel="stylesheet" type="text/css" href="css/style.css"> -->
    <title>管理者ログイン画面</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
<div class="wrapper">
    <div class="login text-aline-center">
		<div>
			<h1 class="top-text">管理者ログイン</h1>
			   <form action="/OlympicQuiz/Login" method="post" class="form">
					<div class="text-box">
					<p class="text-coment">管理者ID：</p>
					<input type="text" name="id" maxlength="20" style="width: 180px; height: 24px;" required>
				</div>
				<div class="text-box">
					<p class="text-coment">パスワード:</p>
					<input type="password" name="pass" maxlength="20" style="width: 180px; height: 24px;" required>
				</div>
			       <input type='hidden' name='clearCount' value='0'>
			       <input type='hidden' name='missCount' value='0'>
			       <input type="submit" name='bttn' value="管理者ログイン" class="btn-square btn">
			   </form>
			<br>
		</div>
	</div>
	<div class="text-aline-center">
		<a href="index.jsp">▽トップ画面へ</a>
    </div>
</div>
</body>
</html>