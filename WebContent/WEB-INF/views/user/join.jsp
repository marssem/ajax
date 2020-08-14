<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<script>
var isChecked = false;

function checkValue(){ 
	/* if(!isChecked){
		alert('중복확인을 눌러주세요');
		return false;
	}  */
	var ui_id = document.querySelector('#ui_id');
	if(ui_id.value.trim().length<4){
		alert('아이디를 확인해 주세요.');
		ui_id.focus();
		return false;
		
	}
	var ui_pwd = document.querySelector('#ui_pwd');
	if(ui_pwd.value.trim().length<4){
		alert('비밀번호를 확인해 주세요.');
		ui_pwd.focus();
		return false;
	}
	var ui_name = document.querySelector('#ui_name');
	if(ui_name.value.trim().length<2){
		alert('이름을 확인해 주세요.');
		ui_name.focus();
		return false;
	}
	var ui_age = document.querySelector('#ui_age');
	if(ui_age.value<1 || ui_age.value>120){
		alert('나이를 확인해 주세요.');
		ui_age.focus();
		return false;
	}
	var ui_birth = document.querySelector('#ui_birth');
	/* alert(ui_birth.value); */
	if(!ui_birth.value){
		alert('생년월일을 확인해 주세요.');
		ui_birth.focus();
		return false;
	}
	var ui_phone = document.querySelector('#ui_phone');
	if(!ui_phone.value){
		alert('전화번호를 확인해 주세요.');
		ui_phone.focus();
		return false;
	}
	var ui_nickname = document.querySelector('#ui_nickname');
	if(ui_nickname.value.trim().length<2){
		alert('별명은 2글자 이상입니다.');
		ui_nickname.focus();
		return false;
	}

}
function checkId(){
	var id = document.querySelector('#ui_id').value;
	var xhr = new XMLHttpRequest();
	xhr.open('GET','/user/checkid?ui_id='+id);
	xhr.onreadystatechange = function(){
		if(xhr.readyState==4){
			if(xhr.status==200){
				var res = JSON.parse(xhr.responseText);
				alert(res.msg);
				if(res.result=='true'){
					isChecked = true;
				}
			}
		}
	}
	xhr.send();
}
</script>
<form action="/user/join" method="post" onsubmit="return checkValue()">
	ID : <input type="text" name="ui_id" id="ui_id" onchange="isChecked = false;"> 
	<button type="button" onclick="checkId()">중복확인</button><br>
	PWD : <input type="password" name="ui_pwd" id="ui_pwd"><br>
	이름 : <input type="text" name="ui_name" id="ui_name"><br>
	age : <input type="number" name="ui_age" id="ui_age"><br>
	birth : <input type="date" name="ui_birth" id="ui_birth"><br>
	phone : <input type="text" name="ui_phone" id="ui_phone"><br>
	email : <input type="text" name="ui_email" id="ui_email"><br>
	별명 : <input type="text" name="ui_nickname" id="ui_nickname"><br>
	<button>회원가입</button>
</form>
</body>
</html>