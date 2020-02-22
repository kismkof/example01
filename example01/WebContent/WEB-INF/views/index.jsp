<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/signin" method="post">
	ID : <input type="text" name="memberId"><br>
	PASSWORD : <input type="password" name="memberPassword"><br>
	<input type="submit" value="로그인"><br>
</form>
<button onclick="signUp()">회원가입</button>
<script type="text/javascript">
function signUp() {
	location.href = '/signup';
}
</script>
</body>
</html>