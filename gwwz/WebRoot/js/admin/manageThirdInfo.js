function coolMoreThirdInfo(){
	var ckb = document.getElementsByName("ckb");
	var flag = 0;
	var i;
	if(ckb.length == 0){
		alert("当前无任何商户信息!");
		return false;
	}
	else if(ckb.length > 0){
		for(i=0;i<ckb.length;i++){
			if(ckb[i].checked == true){
				flag = 1;
				break;
			}
		}
	}
	if(flag == 1){
		if(confirm("您确定要取消审核当前所选商户?")){
			return true;
		}
		return false;
		
	}
	else{
		alert("请选择您要审核通过的商户!");
		return false;
	}
}


function selectAll(){
	var ckb = document.getElementsByName("ckb");
	if(ckb.length > 0){
		if(document.getElementById("checkAll").checked == true){
			for(var i=0;i<ckb.length;i++){
				ckb[i].checked = true;
			}
		}
		else if(document.getElementById("checkAll").checked == false){
			for(var i=0;i<ckb.length;i++){
				ckb[i].checked = false;
			}
		}
	}
}



function searchThirdInfo(){
	var key = document.getElementById("key").value;
	if(key == ""){
		alert("请输入查询关键词!");
		return false;
	}
	else{
		window.location.href = "../servlet/ManageThirdInfo?method=search&key="+key+"";
		return true;
	}
}

function coolThirdInfoOfSearching(thirdId,isCooled,key){
	if(isCooled == "0"){
		if(confirm("您确定要取消审核当前所选商户?")){
			window.location.href = "../servlet/ManageThirdInfo?method=cool&thirdId="+thirdId+"&isCooled="+isCooled+"&isSearching=yes&key="+key+"";
		}
	}
	else{
		if(confirm("您确定要审核通过当前所选商户?")){
			window.location.href = "../servlet/ManageThirdInfo?method=cool&thirdId="+thirdId+"&isCooled="+isCooled+"&isSearching=yes&key="+key+"";
		}
	}
}

function coolThirdInfo(thirdId,isCooled){
	if(isCooled == "0"){
		if(confirm("您确定要取消审核当前所选商户?")){
			window.location.href = "../servlet/ManageThirdInfo?method=cool&thirdId="+thirdId+"&isCooled="+isCooled+"";
		}
	}
	else{
		if(confirm("您确定要审核当前所选商户?")){
			window.location.href = "../servlet/ManageThirdInfo?method=cool&thirdId="+thirdId+"&isCooled="+isCooled+"";
		}
	}
}




function back(){

	window.location.href = "../servlet/ManageThirdInfo?method=showManageThirdInfoPage";
	}
	
	