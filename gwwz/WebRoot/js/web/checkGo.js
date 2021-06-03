function checkGo(){
	if(document.getElementById("go").value == ""){
		alert("请输入您要跳转的页数!");
		return false;
	}
	else if(document.getElementById("go").value <= 0){
			alert("跳转页数不能小于0!请重新输入!");
			document.getElementById("go").value = "";
			return false;
		}
		var flag = false; 
		var go = document.getElementsByName("go");
		var size = go.length; 
		var exp = /^[0-9]*[1-9][0-9]*$/;
		
		//判断输入的计划数为异常字符 
		for(var i=0;i<size;i++){ 
		    if(!exp.test(go[i].value)){ 
		    flag = true;
		    break; 
		    } 
		} 
		if(flag == true && !(document.getElementById("go").value <= 0)){ 
			alert("跳转页数中包含特殊字符!请重新输入!");
			document.getElementById("go").value = "";
			return false ; 
		}
}