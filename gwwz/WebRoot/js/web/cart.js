function updateCount(gid)
	{
		if(document.getElementById("gc"+gid).value == ""){
			alert("请输入您要修改的数量!");
			return false;
		}
		else if(document.getElementById("gc"+gid).value <= 0){
			alert("购物件数必须大于0!请重新输入!");
			document.getElementById("gc"+gid).value = "";
			return false;
		}
		var flag = false; 
		var count = document.getElementsByName("gc"+gid);
		var size = count.length; 
		var exp = /^[0-9]*[1-9][0-9]*$/;
		
		//判断输入的计划数为异常字符 
		for(var i=0;i<size;i++){ 
		    if(!exp.test(count[i].value)){ 
		    flag = true;
		    break; 
		    } 
		} 
		if(flag == true && !(document.getElementById("gc"+gid).value <= 0)){ 
			alert("购买件数中包含特殊字符!请重新输入!");
			document.getElementById("gc"+gid).value = "";
			return false ; 
		}
		else{
			document.frm.txtcount.value = document.getElementById("gc"+gid).value;
		 	document.frm.txtgid.value = gid;  		   		 
		 	document.frm.submit();//提交表单
		}
	}
	