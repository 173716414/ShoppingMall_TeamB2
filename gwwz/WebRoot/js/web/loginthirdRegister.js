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
			if(checkEmail() == false){
				return false;
			}
		 	else{
		 		var regEmail = document.getElementById("regEmail").value;
				if(xmlHttp==null){
					createXMLHttpRequest();
				}
				//采用异步传输,POST方法
				xmlHttp.open("POST","../servlet/DoMethod?method=checkEmail",true);
				//指定一个HTTP报头
				xmlHttp.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
				xmlHttp.onreadystatechange = callback;
				//将得到的输入信息传入到AjaxDoInput.java去处理
				xmlHttp.send("regEmail="+regEmail);
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


function showAndHideTalbe(){
	if(document.getElementById("ck").checked == true){
		document.getElementById("detail").style.display = "block";
	}
	else{
		document.getElementById("detail").style.display = "none";
	}
}


function checkLogin(){
	//获取文本框中的值
 	var email = document.getElementById("email").value;
 	var pwd = document.getElementById("pwd").value;
 	if(email == ""){
 		alert("请输入邮箱地址!");
 		return false;
 	}
 	else if(email.indexOf("@") == -1 || email.indexOf(".") == -1){
 		alert("邮箱地址不合法!请重新输入!");
 		return false;
 	}
 	else if(email.indexOf(" ") != -1){
 		alert("邮箱地址中不能含有空格!请重新输入!");
 		return false;
 	}
 	else if(pwd == ""){
 		alert("请输入密码!");
 		return false;
 	}
 	else if(pwd.length < 6){
 		alert("密码长度不得小于6位!请重新输入!");
 		return false;
 	}
 	else if(pwd.indexOf(" ") != -1){
 		alert("密码不能包含空格!请重新输入!");
 		return false;
 	}
}
function checkRegister(){
	//获取文本框中的值
	var regEmail = document.getElementById("regEmail").value;
 	var regPwd = document.getElementById("regPwd").value;
 	var regConPwd = document.getElementById("regConPwd").value;
 	if(checkEmail() == false){
 		return false;
 	}
 	else if(responseMSG.length == 16){
 		alert("邮箱已被注册,请重新输入!");
 		return false;
 	}
 	else if(regPwd == ""){
 		alert("请输入密码!");
 		return false;
 	}
 	else if(regPwd.length < 6){
 		alert("密码长度不得小于6位!请重新输入!");
 		return false;
 	}
 	else if(regPwd.indexOf(" ") != -1){
 		alert("密码不能包含空格!请重新输入!");
 		return false;
 	}
 	else if(regConPwd == ""){
 		alert("请输入确认密码!");
 		return false;
 	}
 	else if(regConPwd != regPwd){
 		alert("两次密码输入不一致!请重新输入!");
 		return false;
 	}
 	else if(document.getElementById("ck").checked == true){
 		var thirdname = document.getElementById("thirdname").value;
 	 	var telephone = document.getElementById("telephone").value;
 	 	var movePhone = document.getElementById("movePhone").value;
 		var address = document.getElementById("address").value;
 		if(thirdname == ""){
 			alert("请填写您的商户名称!");
 			return false;
 		}
 		else if(phone == "" ){
 			alert("请填写电话联系方式!");
 			return false;
 		}
 		else if(address == ""){
 			alert("请填写您的联系地址!");
 			return false;
 		}
 	}
}


function checkEmail(){
	
	var regEmail = document.getElementById("regEmail").value;
	
	if(regEmail == ""){
 		alert("请输入邮箱地址!");
 		return false;
 	}
	else if(regEmail.indexOf("@") == -1 || regEmail.indexOf(".") == -1){
 		alert("邮箱地址不合法!请重新输入!");
 		return false;
 	}
	else if(regEmail.indexOf(" ") != -1){
 		alert("邮箱地址中不能含有空格!请重新输入!");
 		return false;
 	}
 	return true;
}