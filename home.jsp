<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC '-//W3C//DTD HTML 4.0 Transitional//EN'>
<HTML>
<HEAD>
<TITLE>index.jsp</TITLE>
<META http-equiv=Content-Type content='text/html'>
<title>ホーム</title>
<link rel="stylesheet" href="style.css">
<script src="SubGenre.js"></script>
</head>
<body>
	<div class="wrapper">
		<div class="login text-aline-center">
			<div>
			<img src= "image/Olympic_2020.png" alt="オリンピック2020" height="150">
			<br>
				<h2>～ゲームのルール～</h2><br>
				●３問連続正解すると…　：　記念に写真をプレゼント！（各カテゴリごと）<br>
				●３問連続不正解だと…　：　ゲームオーバーに…！<br>
				※２問連続不正解時にヒントが出ます！ゲームオーバーになる前によんでみましょう！
				<br>
				<br>
				<div class="quiz-form">
					<div class="text-box">
						<p class="text-coment">どのジャンルに挑戦しますか？</p>
						<div class="cp_ipselect">
							<select class="cp_sl06" name="category" id="category" required>
								<option value=""></option>

								<option value="0">世界のあいさつ</option>

								<option value="1">オリンピック雑学</option>

								<option value="2">国内観光の雑学</option>

								<option value="3">基本英会話</option>
							</select> <span class="cp_sl06_highlight"></span> <span
								class="cp_sl06_selectbar"></span> <label
								class="cp_sl06_selectlabel">選択してください</label>
						</div>
					</div>
				</div>
				<form method='post' action='http://127.0.0.1:8080/OlympicQuiz/Main'
					class="quiz-form">
					<div class="text-box">
						<p class="text-coment">カテゴリ</p>
						<div class="cp_ipselect">
							<select class="cp_sl06" name="subGenre" id="subGenre" required>
								<option value=""></option>
							</select><span class="cp_sl06_highlight"></span> <span
								class="cp_sl06_selectbar"></span> <label
								class="cp_sl06_selectlabel">選択してください</label>
						</div>
					</div>
					<input type='submit' name='bttn' value='進む' class="btn-square btn ">
				</form>
				<p class="text-coment">
					これまでのクイズの記録は <a href="records.jsp" target="_blank">こちら</a>
				</p>
			</div>
		</div>

		<div class="text-aline-center">
			<form action="Logout" method="get">
				<input type="submit" value="ログアウト">
			</form>
		</div>
	</div>
</body>
</html>