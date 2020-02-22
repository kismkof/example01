<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sign Up</title>
</head>
<body>
<div>
	<form name="frm" action="" method="post" onsubmit="onSubmit(); return false;">
		ID : <input type="text" id="memberId" name="memberId"><br>
		NAME : <input type="text" id="memberName" name="memberName"><br>
		PASSWORD : <input type="password" id="memberPassword" name="memberPassword"><br>
		EMAIL : <input type="email" id="memberEmail" name="memberEmail"><br>
		PHONE : <input type="tel" id="memberPhone" name="memberPhone"><br>
		<input type="submit" value="Submit">
	</form>
</div>
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	
})

function onSubmit(){
	var validationCheck = true;
	var memberId = $('#memberId').val();
	
	if(memberId == null || $.trim(memberId) == '') {
		alert('아이디를 입력해주세요');
		$('#memberId').focus();
		return false;
	}
	
	if(!validationCheck) {
		alert('필수 값을 입력해주세요');
		return false;
	}
	
	alert('회원가입이 완료되었습니다.');
	
	var frm = document.frm;
	frm.action = '/insertMember';
	frm.submit();
}
</script>
</body>
</html>