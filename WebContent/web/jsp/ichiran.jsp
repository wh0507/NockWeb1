<%@page import="java.util.Optional"%>
<%@page import="sogo.ShohinBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
String no1 = null;
String no = request.getParameter("no");
ArrayList<ShohinBean> lists = (ArrayList<ShohinBean>) session.getAttribute("ShohinList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="<%=request.getContextPath()%>/css/style.css" rel="stylesheet" type="text/css">
<title>商品マスタ</title>
</head>
<body>
	<h1>商品一覧</h1>
	<table>
		<tr>
		<%if (no.equals("2")) { %>
			<th></th>
		<%} %>
			<th>ID</th>
			<th>商品名</th>
			<th>価格</th>
		</tr>
		<%
		for (ShohinBean list : lists) {
		%>
		<tr>
			<%if (no.equals("2")) { %>
			<td><input type="radio"></td>
			<%} %>
			<td><%=list.getId()%></td>
			<td><%=list.getName()%></td>
			<td><%=list.getKakaku()%></td>
		</tr>
		<%
		}
		%>
	</table>
	<p></p>
	<div class="form_button">
		<form action="mod.jsp?no=<%=no%>" method="POST">
			<input type="submit" value="変更">
		</form>
		<form action="kakunin.jsp?no=4" method="POST">
			<input type="submit" value="削除">
		</form>
		<form action="menu.jsp" method="GET">
			<input type="submit" value="戻る">
		</form>
	</div>
</body>
</html>