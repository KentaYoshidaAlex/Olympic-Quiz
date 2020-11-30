<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.QuizData" %>
<%@ page import="dao.QuizDAO" %>
<%@ page import="java.util.List" %>
<%
	QuizDAO qDao = new QuizDAO();
	List<QuizData> quizDataList = qDao.findAllQuiz();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>クイズ一覧</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
<h1 class="top-text">現在のクイズ一覧</h1>
	<table>
    <tr>
      <th>メインジャンル</th>
      <th>サブジャンル</th>
      <th>問番号</th>
      <th>質問</th>
      <th>解答</th>
      <th>ヒント</th>
      <th>選択肢①</th>
      <th>選択肢②</th>
      <th>選択肢③</th>
      <th>選択肢④</th>
      <th>画像パス</th>
      <th>パス</th>
    </tr>
	<% for(QuizData quizData : quizDataList) { %>

	    <tr>
	      <td><%= quizData.getMainGenre() %></td>
	      <td><%= quizData.getSubGenre() %></td>
	      <td><%= quizData.getNo() %></td>
	      <td><%= quizData.getQuestion() %></td>
	      <td><%= quizData.getAnswer() %></td>
	      <td><%= quizData.getHint() %></td>
	      <td><%= quizData.getChoice1() %></td>
	      <td><%= quizData.getChoice2() %></td>
	      <td><%= quizData.getChoice3() %></td>
	      <td><%= quizData.getChoice4() %></td>
	      <td><%= quizData.getImage() %></td>
	      <td><%= quizData.getPass() %></td>

	<% } %>
    </tr>
  </table>
  <br>
  <div class="text-aline-center">
	<p><a href='http://127.0.0.1:8080/OlympicQuiz/createQuiz.jsp'>▽新規クイズ登録画面へ戻る</a></p>
  </div>
  <br>
</body>
</html>