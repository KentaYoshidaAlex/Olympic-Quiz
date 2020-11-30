<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.QuizData" %>
<%@ page import="java.util.List" %>
<%@ page import="model.User" %>
<%@ page import="model.Judge" %>
<%@ page import="model.AllQuizMusic" %>

<%
	//セッションスコープからインスタンスを取得
	//QuizData q = (QuizData) session.getAttribute("quiz");
	QuizData quizData = (QuizData) session.getAttribute("quiz");
	QuizData exquiz = (QuizData )session.getAttribute( "exquiz" );
	AllQuizMusic am = (AllQuizMusic)session.getAttribute( "am" );
%>
<%
	//アプリケーションスコープからUserインスタンスを取得
	User user = (User) application.getAttribute("user");
	String name = user.getName();
	int clearCount = user.getClearCount();
	int missCount = user.getMissCount();
%>
<%
	//リクエストスコープからrwのインスタンスを取得
	Judge judge = (Judge) request.getAttribute("judge");
	int j = judge.getJudge();
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>プレイ画面</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
<div class="wrapper">
    <div class="login text-aline-center">
		<div>
			<!-- 初回ｱｸｾｽ時、正解時、不正解時を判定するif文（ページ上部に表示する文言） -->
			<% if(j == 0) { %>  ようこそ！<br>
			<% } else if( j == 1 && clearCount <= 2){ %> 正解です！<br>
			<img src= "image/happy.png" alt="ハッピーカエル" height="100"><br>

			<% if(quizData.getPass() != null)  { %>
		    ↓今、正解した「<%= exquiz.getAnswer() %>」の発音を確認したい方はコチラ↓<br>
			<audio src="<%= exquiz.getPass() %>" controls></audio>
			<br> <% } %>
			<% } else if( j == 2 ){ %>残念、不正解です！<br>
			<img src= "image/hmmmm.png" alt="うーんクマ" height="100"><br>
			<% } %>

<!-- ******************************************************************************************* -->

			<!-- クイズパートメイン部分 -->
			<p><%= name %>さん。現在のクリア数は<%= clearCount %>問です</p><br>

				<!-- 3問連続正解時（ご褒美ページへのリンク＆継続プレイのクイズ文を表示） -->
				<% if(clearCount >= 3 && missCount == 0) { %><br>

					<!-- 音声ありのクイズの場合、再生ボタンを表示 -->
					<p>
					目標達成です！おめでとうございます！<br>
					<img src= "image/cracker.png" alt="クラッカー2" height="100"><br>
					<audio src="<%= am.getCorrectS() %>" autoplay></audio>
					</p>
					<% if(quizData.getPass() != null)  { %>
					<br>↓今、正解した「<%= exquiz.getAnswer() %>」の発音を確認したい方はコチラ↓<br>
					<br>
					<audio src="<%= exquiz.getPass() %>" controls></audio>
					 <br> <% } %>
					<p>
					<br><a href='http://127.0.0.1:8080/OlympicQuiz/present.jsp' class="btn-square">ご褒美ページへ</a>
					</p>
					<br>
					<br>
					<!-- クイズ本文 -->
					引き続きお楽しみの方はこちら↓ <br>
					<br>
					<% if(quizData.getMainGenre()== "Greeting") { %>
						<img src= "image/Olympic_2020.png" alt="オリンピック2020"><br>
					<% } %>

					下記の問題の空欄に当てはまる単語を選択してください。<br>
					<br>
					<h3>Q : <%= quizData.getQuestion() %></h3><br>
					<p>
					適切な回答を選択してください。<br>

					<div class="form">
					<div class="top-text">
					<form method='post'	action='http://127.0.0.1:8080/OlympicQuiz/Main'>
						<ol>
							<li><%= quizData.getChoice1() %><input type='radio'
								name='choice' value='<%= quizData.getChoice1() %>' required></li>
							<li><%= quizData.getChoice2() %><input type='radio'
								name='choice' value='<%= quizData.getChoice2() %>'></li>
							<li><%= quizData.getChoice3() %><input type='radio'
								name='choice' value='<%= quizData.getChoice3() %>'></li>
							<li><%= quizData.getChoice4() %><input type='radio'
								name='choice' value='<%= quizData.getChoice4() %>'></li>
						</ol>
							<input type='hidden' name='subGenre' value='<%= quizData.getSubGenre() %>'>
							<input type='hidden' name='no' value='<%= quizData.getNo() %>'><br>

						<br> <input type='submit' name='bttn' value='回答' class="btn-square"><br>
					</form>
					</div>
					</div>

					<a href='http://127.0.0.1:8080/OlympicQuiz/home.jsp'>▽ジャンル選択画面に戻る</a><br>


				<!-- 3問連続不正解の場合 -->
					<% } else if( missCount >= 3 ){ %>
					<!-- 何も表示しない -->
					<br>


				<!-- それ以外（通常のクイズ本文を表示） -->
					<% } else { %>
					<br>
					下記の問題の空欄に当てはまる単語を選択してください。<br>
					<br>
					<h3>Q : <%= quizData.getQuestion() %></h3><br>
					<p>
					適切な回答を選択してください。<br>
					<div  class="form">
					<div class="top-text">
					<form method='post' action='http://127.0.0.1:8080/OlympicQuiz/Main' >
					    <ol>
					    	<li><%= quizData.getChoice1() %><input type='radio' name='choice'value='<%= quizData.getChoice1() %>' required></li>
					    	<li><%= quizData.getChoice2() %><input type='radio' name='choice'value='<%= quizData.getChoice2() %>' ></li>
					    	<li><%= quizData.getChoice3() %><input type='radio' name='choice'value='<%= quizData.getChoice3() %>' ></li>
					    	<li><%= quizData.getChoice4() %><input type='radio' name='choice'value='<%= quizData.getChoice4() %>' ></li>
					    </ol>
					    <input type='hidden' name='subGenre' value='<%= quizData.getSubGenre() %>'>
					    <input type='hidden' name='no' value='<%= quizData.getNo() %>' ><br>
					    <br>
					    <input type='submit' name='bttn' value='回答' class="btn-square">
					</form>
					</div>
					</div>

					<% } %>

<!-- ******************************************************************************************* -->

			<!-- 下部に表示する文言と自動再生効果音のif文 -->
				<!-- 1問目不正解の場合 -->
					<% if( missCount == 1 ) { %><br>
					もう一度チャレンジ<br>

				<!-- 2問目不正解の場合（ヒント表示） -->
					<% } else if( missCount == 2 ){ %><br>
					ヒント<br>
					<div class="form">
					<div class="box">
						<p><%= quizData.getHint() %></p>
					<% } if (missCount == 2 && quizData.getMainGenre().equals( "Greeting")) { %>
					<br>世界の挨拶について、まとめて学習したい方はコチラ↓<br>
					<a href="http://127.0.0.1:8080/OlympicQuiz/column.jsp" target="_blank" rel="noopener noreferrer">コラムページ</a>
					</div>
					</div>

				<!-- 3問連続不正解の場合（ゲームオーバー） -->
					<% } else if( missCount >= 3 ){ %>
					<!-- クリアカウント数を0に。 -->
					<% user.setClearCount( 0 );
					user.setMissCount( 0 ); %>

					<!-- ゲームオーバーの効果音 -->
					<audio src="<%= am.getGameOverS() %>" autoplay></audio><br>
					ゲームオーバーです<br>
					<img src= "image/bad.png" alt="残念" height="100"><br>
					<br>
					▽ジャンル選択画面に戻る<br>
					<a href='http://127.0.0.1:8080/OlympicQuiz/home.jsp'><img src= "image/home.png" alt="home" height="40"></a><br>

				<!-- 3問連続正解の場合（正解の効果音） -->
					<% } else if(clearCount == 3) { %><br>
					<audio src="<%= am.getCorrectS() %>" autoplay></audio>
					<% } %>
		</div>
	</div>
				<div class="text-aline-center">
							<form action="Logout" method="get">
								 <input type="submit" value="ログアウト" >
							</form>
			    </div>
</div>

</body>
</html>