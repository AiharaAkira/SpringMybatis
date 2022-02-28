function goHome() {
	location.href='index.go';
}

function logout() {
	let ok = confirm("정말?")
	if(ok){
		location.href='member.logout';
	}
}

function bye() {
	var ok = confirm("?");
	if (ok) {
		location.href = "member.bye";
	}
}

function deleteFile(n, f) {
	var ok = confirm("?");
	if (ok) {
		location.href = "dataroom.delete?d_no=" + n + "&d_file=" + f;
	}
}


function deleteSNSMsg(n) {
	var ok = confirm("?");
	if (ok) {
		location.href = "sns.delete?s_no=" + n;
	}
}

function deleteSNSReply(n, p) {
	var ok = confirm("?");
	if (ok) {
		location.href = "sns.reply.delete?r_no=" + n + "&p=" + p;
	}
}

function updateSNSMsg(n, t, p) {
	t = prompt("말", t);
	if (t != null && t.length > 0 && t.length < 250) {
		location.href = "sns.update?s_no=" + n + "&s_txt=" + t + "&p=" + p;
	}
}


function goJoin() {
	location.href = "member.join.go";
}

function goMemberInfo() {
	location.href = "member.info";
}


function deleteCommunityMsg(n) {
	var ok = confirm("?");
	if (ok) {
		location.href = "community.delete?c_no=" + n;
	}
}


function sendCommunityMsg(to) {
	var t = prompt("말", t);
	if (t != null && t.length > 0 && t.length < 180) {
		location.href = "community.send?c_to=" + to + "&c_txt=" + t;
	}
}








