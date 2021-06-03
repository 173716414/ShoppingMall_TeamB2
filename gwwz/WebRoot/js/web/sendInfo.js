function checkSendInfo(){
	//获取文本框中的值
 		var name = document.getElementById("name").value;
 	 	var telephone = document.getElementById("telephone").value;
 	 	var movePhone = document.getElementById("movePhone").value;
 		var address = document.getElementById("address").value;
 		if(name == ""){
 			alert("请填写您的真实姓名!");
 			return false;
 		}
 		else if(telephone == "" && movePhone == ""){
 			alert("请至少填写一项电话联系方式!");
 			return false;
 		}
 		else if(address == ""){
 			alert("请填写您的收获地址!");
 			return false;
 		}
}