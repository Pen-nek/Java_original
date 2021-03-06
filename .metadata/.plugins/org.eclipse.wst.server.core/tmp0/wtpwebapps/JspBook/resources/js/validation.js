function CheckAddMember() {
	
	var userId = document.getElementById("userId");	// getElementById : document로부터 이 ID값을 가진 요소의 값을 가져와라
	var userPw = document.getElementById("userPw");
	var name = document.getElementById("name");
	var email = document.getElementById("email");
	
	// 아이디 형식 및 길이 체크
		// 영,숫자 조합 / 8~12글자 / 영문자로 시작
	if (!check(/^[a-z|A-Z]\w{7,11}$/, userId, "[아이디]\n영문 또는 숫자를 사용하여 8~12자 내에서 입력하세요\n첫 글자는 반드시 영문자로 시작하세요"))
		return false;
	
	// 비밀번호 형식 및 길이 체크
		// 영,숫자,특문 조합 / 8~20글자
	if (!check(/^(?=.*\d)(?=.*[A-Z|a-z])(?=.*[^\w\d\s:])([^\s]){8,20}$/, userPw, "[비밀번호]\n영문, 숫자, 특수문자를 조합하여 8~20자 내에서 입력하세요"))
		return false;
	
	// 이름 체크
	if (name.value.length < 1 || name.value.length > 21 ) {
		alert("[이름]\n1~20자까지 입력 가능합니다");
		name.select();
		name.focus();
		return false;
	}
	
	// 이메일 체크
	if (!check(/^((?!\.)[\w-_.]*[^.])(@\w+)(\.\w+(\.\w+)?[^.\W])$/, email, "[이메일]\n이메일 형식에 맞게 입력하세요"))
		return false;
	
	// 유효성 체크 함수
	function check(regExp, e, msg) {
		
		if (regExp.test(e.value)) {
			return true;
		}
		alert(msg);
		e.select();
		e.focus();
		return false;
	}
	
	document.newMember.submit();
	
}