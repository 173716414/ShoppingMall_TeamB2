function sh(orderid){
		if(confirm("您确认已经收货?")){
			window.location.href = "../servlet/OrderInfo?method=sh&orderId="+orderid+"";
		}
}
function th(orderid){
		if(confirm("您确认要退货?")){
			window.location.href = "../servlet/OrderInfo?method=th&orderId="+orderid+"";
		}
}

function checkupdate(){

	//获取文本框中的值
 	var regPwd = document.getElementById("regPwd").value;
 	var regConPwd = document.getElementById("regConPwd").value;
 	 if(regPwd == ""){
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
	 	
}
