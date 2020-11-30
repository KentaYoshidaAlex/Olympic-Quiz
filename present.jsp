<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.QuizData" %>
<%@ page import="model.AllQuizMusic" %>
<%@ page import="java.util.List" %>


<%
	//セッションスコープからインスタンスを取得
	//QuizData q = (QuizData) session.getAttribute("quiz");
	QuizData quizData = (QuizData) session.getAttribute("quiz");
	AllQuizMusic  am2 = (AllQuizMusic)session.getAttribute( "am" );

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ご褒美</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
<div class="wrapper">
    <div class="login text-aline-center">
		<div>
			<h1 class="top-text">おめでとうございます</h1>
			<h3 class="presentfont top-text">3問連続正解されたので、記念に写真をプレゼントします！</h3>
			<img src="<%= quizData.getImage() %>" title="present" height="400"class="quiz-form">
			<audio src="<%= am2.getCongratulationsS() %>" autoplay></audio>
			<p class="login-coment top-text">これまでのクイズの記録は<a href="records.jsp" target="_blank">こちら</a></p>
			<a href='http://127.0.0.1:8080/OlympicQuiz/home.jsp'>
				<button class="btn-square btn">▽ジャンル選択画面に戻る</button>
			</a>
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