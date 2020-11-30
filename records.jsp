<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.User"%>
<%@ page import="model.Records" %>
<%@ page import="dao.RecordsDAO" %>
<%@ page import="java.util.List" %>
<%
	// アプリケーションスコープからユーザー情報を取得
	User user = (User) application.getAttribute("user");

	// クイズ記録を取得
	RecordsDAO recDAO = new RecordsDAO();
	List<Records> recList = recDAO.getRecords(user);
	List<Records> nonRecList = recDAO.getNoRecords(user);

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="style.css">
<title>クイズの記録</title>
</head>
<body>
<div class="wrapper">
    <div class="login text-aline-center">
		<div>
			<h1 class="top-text"><%= user.getName() %>さんのクイズの記録</h1>


<h3 class="top-text">～クリア済みのクイズ～</h3>
<table>
    <tr>
      <th>ジャンル</th>
      <th>カテゴリ</th>
      <th>ご褒美</th>
      <th>日付</th>
    </tr>
<% for(Records rec : recList) { %>
	<tr>
	<td><%= rec.getClMG() %></td>
	<td><%= rec.getClSG() %></td>
	<td><img src="<%= rec.getImage() %>" title="present" height="200"></td>
	<td><%= rec.getPlayDate() %></td>
	</tr>
<% } %>
</table>

<h3  class="top-text">～未挑戦のクイズ～</h3>
<table>
    <tr>
      <th>ジャンル</th>
      <th>カテゴリ</th>
    </tr>
<% for(Records rec : nonRecList) { %>
	<tr>
	<td><%= rec.getNonClMG() %></td>
	<td><%= rec.getNonClSG() %></td>
	</tr>
<% } %>
</table>
</div>
</div>
	<div class="text-aline-center">
		<a href='http://127.0.0.1:8080/OlympicQuiz/home.jsp'>▽ジャンル選択画面に戻る</a>
    </div>
</div>
</body>
</html>