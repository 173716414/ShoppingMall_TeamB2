var xmlHttp = null;
var responseMSG = null;
    	//创建XMLHttp对象
    	function createXMLHttpRequest(){
			if(window.XMLHttpRequest){
				xmlHttp = new XMLHttpRequest();
			}
			else{
				try{
					xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
				}catch(e){
					xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
				}
			}
		}
		//创建发送数据对象
		function sendRequest(){
			var oldUserPwd = document.getElementById("oldUserPwd").value;
			if(oldUserPwd == ""){
		 		alert("请输入旧密码!");
		 		return false;
		 	}
		 	else{
				if(xmlHttp==null){
					createXMLHttpRequest();
				}
				//采用异步传输,POST方法
				xmlHttp.open("POST","../servlet/tUpdateUserInfo?method=checkOldUserPwd",true);
				//指定一个HTTP报头
				xmlHttp.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
				xmlHttp.onreadystatechange = callback;
				//将得到的输入信息传入到AjaxDoInput.java去处理
				xmlHttp.send("oldUserPwd="+oldUserPwd);
				return true;
			}
		}
		
		function callback(){
			if(xmlHttp.readyState == 4 && xmlHttp.status == 200){
				var msg = document.getElementById("msg");
				msg.innerText = xmlHttp.responseText;
				responseMSG =  xmlHttp.responseText;
			}
		}





function checkUserPwd(){
	//获取文本框中的值
 	var oldUserPwd = document.getElementById("oldUserPwd").value;
 	var newUserPwd = document.getElementById("newUserPwd").value;
 	var confirmNewUserPwd = document.getElementById("confirmNewUserPwd").value;
 	if(oldUserPwd == ""){
 		alert("请输入旧密码!");
 		return false;
 	}
 	else if(newUserPwd == ""){
 		alert("请输入新密码!");
 		return false;
 	}
 	else if(newUserPwd.length < 6){
 		alert("密码长度不得小于6位!请重新输入!");
 		return false;
 	}
 	else if(newUserPwd.indexOf(" ") != -1){
 		alert("密码不能包含空格!请重新输入!");
 		return false;
 	}
 	else if(confirmNewUserPwd != newUserPwd){
 		alert("两次输入的密码不一致!请重新输入!");
 		return false;
 	}
}