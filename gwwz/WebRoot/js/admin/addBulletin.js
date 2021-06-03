function checkText(){
	
	if(document.getElementById("title").value == ""){
		alert("请输入公告标题!");
		return false;
	}
	else if(document.getElementById("content").value == ""){
		alert("请输入公告内容!");
		return false;
	}
}
