<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新規クイズ登録</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
<div class="wrapper">
    <div class="login ">
		<div>
			<h1 class="top-text text-aline-center">新規クイズ登録</h1>
			<p class="text-aline-center">◎現在のクイズ一覧を確認するには<a href="http://127.0.0.1:8080/OlympicQuiz/quizList.jsp"  target="_blank">こちら</a></p>
			<p class="top-text">◎新規クイズの作成は下記項目を入力してください。</p>



			<form action="/OlympicQuiz/CreateQuiz" method="post" >

				<div class="text-box">
					<p class="text-coment">●クイズ / メインジャンル : (例)Greeting<br>※半角英字で入力してください</p>
					<input type="text" name="mainGenre" pattern=^[A-Za-z]+$ required>
				</div>

				<div class="text-box">
					<p class="text-coment">●クイズ / サブジャンル : （例）hello<br>※半角英字で入力してください</p>
					<input type="text" name="subGenre" pattern=^[A-Za-z]+$ required>
				</div>
				<div class="text-box">
					<p class="text-coment">●問題内容 : （例）フランス語で「こんにちは」は？</p>
					<textarea name="question" rows="2" cols="50" required></textarea>
				</div>

				<div class="text-box">
					<p class="text-coment">●正しい解答 : （例）ボンジュール</p>
					<input type="text" name="answer"  required>
				</div>
				<div class="text-box">
					<p class="text-coment">●ヒント : （例）お○休み＋数字 </p>
					<textarea name="hint" rows="2" cols="50" required></textarea>
				</div>
				<div class="text-box">
					<p class="text-coment">●選択肢①</p>
					<input type="text" name="choice1" required>
				</div>
				<div class="text-box">
					<p class="text-coment">●選択肢②</p>
					<input type="text" name="choice2" required>
				</div>
				<div class="text-box">
					<p class="text-coment">●選択肢③</p>
					<input type="text" name="choice3" required>
				</div>
				<div class="text-box">
					<p class="text-coment">●選択肢④</p>
					<input type="text" name="choice4" required>
				</div>

				<div class="text-box">
					<p class="text-coment">●ご褒美画像 : （例）image/小ジャンル名.jpeg<br>※拡張子名まで入力してください。</p>
					<input type="text" name="image" value='image/.jpeg' required>
				</div>

				<div class="text-box">
					<p class="text-coment">●音声パスのアドレス※任意入力<br>※拡張子名まで入力してください</p>
					<input type="text" name="pass" value='.mp3'>
				</div>
				<div class="text-aline-center">
				<input type="submit" value="新規クイズ登録" class="btn-square  btn ">
				</div>
			</form>
		</div>
	</div>
	<div class="text-aline-center">
		<a href='http://127.0.0.1:8080/OlympicQuiz/admin.jsp'>▽管理者画面へ戻る</a>
    </div>
</div>
</body>
</html>