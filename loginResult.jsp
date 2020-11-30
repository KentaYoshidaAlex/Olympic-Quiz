<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.User"%>
<%
	// セッションスコープからユーザー情報を取得
User user = (User) application.getAttribute("user");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ジャンル選択</title>
<link rel="stylesheet" href="style.css">
<script src="SubGenre.js"></script>
</head>
<body>
	<div class="wrapper">
		<div class="login text-aline-center">
			<div>
				<%
					if (user != null) {
				%>
				<h4>☆ログインに成功しました☆(｀・ω・´)</h4>
				<br>

				<p class="text-coment">
					ようこそ<%=user.getName()%>さん<br> <img src="image/welcome.png"
						alt="ようこそ" height="100"><br>
				</p>
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
					<input type='submit' name='bttn' value='進む' class="btn-square btn">
				</form>
				<div class="text-aline-center login-coment">
					<a href="records.jsp">クイズの記録</a>
				</div>
			</div>
		</div>
			<div class="text-aline-center">
						<form action="Logout" method="get">
							 <input type="submit" value="ログアウト" >
						</form>
		    </div>
		<%
			} else {
		%>
		<p>ログインできませんでした(; ･`д･´)</p>
		<a href="/OlympicQuiz/">トップへ戻る</a>
		<%
			}
		%>
	</div>
</body>
</html>