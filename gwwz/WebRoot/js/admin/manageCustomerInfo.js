function coolMoreCustomerInfo(){
	var ckb = document.getElementsByName("ckb");
	var flag = 0;
	var i;
	if(ckb.length == 0){
		alert("当前无任何客户信息!");
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
		if(confirm("您确定要冻结当前所选客户?")){
			return true;
		}
		return false;
		
	}
	else{
		alert("请选择您要冻结的客户!");
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



function searchCustomerInfo(){
	var key = document.getElementById("key").value;
	if(key == ""){
		alert("请输入查询关键词!");
		return false;
	}
	else{
		window.location.href = "../servlet/ManageCustomerInfo?method=search&key="+key+"";
		return true;
	}
}

function coolCustomerInfoOfSearching(customerId,isCooled,key){
	if(isCooled == "0"){
		if(confirm("您确定要冻结当前所选客户?")){
			window.location.href = "../servlet/ManageCustomerInfo?method=cool&customerId="+customerId+"&isCooled="+isCooled+"&isSearching=yes&key="+key+"";
		}
	}
	else{
		if(confirm("您确定要激活当前所选客户?")){
			window.location.href = "../servlet/ManageCustomerInfo?method=cool&customerId="+customerId+"&isCooled="+isCooled+"&isSearching=yes&key="+key+"";
		}
	}
}

function coolCustomerInfo(customerId,isCooled){
	if(isCooled == "0"){
		if(confirm("您确定要冻结当前所选客户?")){
			window.location.href = "../servlet/ManageCustomerInfo?method=cool&customerId="+customerId+"&isCooled="+isCooled+"";
		}
	}
	else{
		if(confirm("您确定要激活当前所选客户?")){
			window.location.href = "../servlet/ManageCustomerInfo?method=cool&customerId="+customerId+"&isCooled="+isCooled+"";
		}
	}
}




function back(){

	window.location.href = "../servlet/ManageCustomerInfo?method=showManageCustomerInfoPage";
	}
	
	