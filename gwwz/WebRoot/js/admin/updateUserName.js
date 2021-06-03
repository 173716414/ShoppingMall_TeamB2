function checkUserName(){
	
	var userName = document.getElementById("userName").value;
	if(userName == ""){
		alert("请输入您要更改后的用户名!");
		return false;
	}
	else if(userName.length <5){
		alert("用户名长度不得小于5位!请重新输入!");
		document.getElementById("userName").value = "";
		return false;
	}
	else{
		top.location.href = " ../servlet/UpdateUserInfo?method=updateUserName&userName="+userName+"";
		return true;
	}
}
