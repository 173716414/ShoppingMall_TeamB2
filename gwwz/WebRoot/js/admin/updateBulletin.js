function checkNull(){
	if(document.getElementById("title").value == ""){
		alert("请输入公告标题!");
		return false;
	}
	else if(document.getElementById("title").value.length >80){
		alert("公告标题长度不得大于80位!");
		return false;
	}
	else if(document.getElementById("content").value == ""){
		alert("请输入公告内容!");
		return false;
	}
}

function back(){

	window.location.href = "../servlet/ManageBulletin?method=showManageBulletinPage";
	}
	