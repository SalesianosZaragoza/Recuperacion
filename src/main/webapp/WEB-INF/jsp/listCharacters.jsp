<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.io.*,java.util.*,es.salesianos.model.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<style>
body {
    background-image: url("img/background.jpg");
}
</style>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>List characters</title>
	</head>
	<body>
		<table>
		    <thead>
		       <th>| ID |</th>
		       <th>Name |</th>
		       <th>Ring Bearer |</th>
		       <th>Race |</th>        
		    </thead>
			<c:forEach items="${listOfCharacters}" var="character">
			    <tr>
					<td style="text-align: center">${character.id}</td>
			        <td style="text-align: center">${character.name}</td>
			        <td style="text-align: center">${character.holder}</td>
			        <td style="text-align: center">${character.raceName}</td>
			        <td><a href="/deleteCharacter?id=${character.id}"> Delete</a></td>
			        <td><a href="/updateCharacter?id=${character.id}"> Update</a></td>   
			    </tr>
			</c:forEach>
		</table>
		<br>
								<span>Index</span>
		<form action="index">
			<input type="submit" value="index">
		</form>
		<img src="img/meme2.jpg" id="meme2">
	</body>
</html>