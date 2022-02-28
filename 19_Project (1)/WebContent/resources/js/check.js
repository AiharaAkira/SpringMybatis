function drUploadCheck() {
	var titleInput = document.drUploadForm.d_title;
	var fileInput = document.drUploadForm.d_file;

	if (isEmpty(titleInput)) {
		alert("?");
		titleInput.value = "";
		titleInput.focus();
		return false;
	} else if (isEmpty(fileInput)) {
		alert("?");
		return false;
	}

	return true;
}

function gUploadCheck() {
	var titleInput = document.gUploadForm.g_title;
	var fileInput = document.gUploadForm.g_file;

	if (isEmpty(titleInput)) {
		alert("?");
		titleInput.value = "";
		titleInput.focus();
		return false;
	} else if (isEmpty(fileInput)) {
		alert("?");
		return false;
	}

	return true;
}

function joinCheck() {
	var idInput = document.joinForm.m_id;
	var pwInput = document.joinForm.m_pw;
	var pwChkInput = document.joinForm.m_pwChk;
	var nameInput = document.joinForm.m_name;
	var addr1Input = document.joinForm.m_addr1;
	var addr2Input = document.joinForm.m_addr2;
	var addr3Input = document.joinForm.m_addr3;
	var photoInput = document.joinForm.m_photo;

	if (isEmpty(idInput) || containsHS(idInput)
			|| $("#m_idInput").css("color") == "rgb(244, 67, 54)") {
		alert("ID?");
		idInput.value = "";
		idInput.focus();
		return false;
	} else if (isEmpty(pwInput) || notEquals(pwInput, pwChkInput)
			|| notContains(pwInput, "1234567890")) {
		alert("PW?");
		pwInput.value = "";
		pwChkInput.value = "";
		pwInput.focus();
		return false;
	} else if (isEmpty(nameInput)) {
		alert("이름?");
		nameInput.value = "";
		nameInput.focus();
		return false;
	} else if (isEmpty(addr1Input) || isEmpty(addr2Input)
			|| isEmpty(addr2Input)) {
		alert("주소?");
		addr1Input.value = "";
		addr2Input.value = "";
		addr3Input.value = "";
		addr1Input.focus();
		return false;
	} else if (isEmpty(photoInput)
			|| (isNotType(photoInput, "png") && isNotType(photoInput, "gif")
					&& isNotType(photoInput, "jpg") && isNotType(photoInput,
					"bmp"))) {
		alert("사진?");
		return false;
	}

	return true;
}

function loginCheck() {
	var idInput = document.loginForm.m_id;
	var pwInput = document.loginForm.m_pw;

	if (isEmpty(idInput) || isEmpty(pwInput)) {
		alert("?");
		idInput.value = "";
		pwInput.value = "";
		idInput.focus();
		return false;
	}

	return true;
}

function snsSearchCheck() {
	var searchInput = document.snsSearchForm.search;

	if (isEmpty(searchInput)) {
		alert("?");
		searchInput.focus();
		return false;
	}

	return true;
}

function snsWriteCheck() {
	var txtInput = document.snsWriteForm.s_txt;

	if (isEmpty(txtInput)) {
		alert("?");
		txtInput.focus();
		return false;
	}

	return true;
}

function snsWriteReplyCheck(f) {
	var txtInput = f.sr_txt;

	if (isEmpty(txtInput)) {
		alert("?");
		txtInput.focus();
		return false;
	}

	return true;
}

function updateMemberCheck() {
	var pwInput = document.updateMemberForm.m_pw;
	var pwChkInput = document.updateMemberForm.m_pwChk;
	var nameInput = document.updateMemberForm.m_name;
	var addr1Input = document.updateMemberForm.m_addr1;
	var addr2Input = document.updateMemberForm.m_addr2;
	var addr3Input = document.updateMemberForm.m_addr3;
	var photoInput = document.updateMemberForm.m_photo;

	if (isEmpty(pwInput) || notEquals(pwInput, pwChkInput)
			|| notContains(pwInput, "1234567890")) {
		alert("PW?");
		pwInput.value = "";
		pwChkInput.value = "";
		pwInput.focus();
		return false;
	} else if (isEmpty(nameInput)) {
		alert("이름?");
		nameInput.value = "";
		nameInput.focus();
		return false;
	} else if (isEmpty(addr1Input) || isEmpty(addr2Input)
			|| isEmpty(addr2Input)) {
		alert("주소?");
		addr1Input.value = "";
		addr2Input.value = "";
		addr3Input.value = "";
		addr1Input.focus();
		return false;
	} else if (isEmpty(photoInput)) {
		return true;
	} else if (isNotType(photoInput, "png") && isNotType(photoInput, "gif")
			&& isNotType(photoInput, "jpg") && isNotType(photoInput, "bmp")) {
		alert("사진?");
		return false;
	}

	return true;
}