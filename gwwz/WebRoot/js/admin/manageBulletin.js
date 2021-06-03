function showAddBulletinPage(){
	window.location.href = "../admin/addBulletin.jsp";
}

function deletMoreBulletin(){
	var ckb = document.getElementsByName("ckb");
	var flag = 0;
	var i;
	if(ckb.length == 0){
		alert("当前无任何公告信息!");
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
		if(confirm("您确定要删除当前所选公告?")){
			return true;
		}
		return false;
		
	}
	else{
		alert("请选择您要删除的公告信息!");
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



function searchBulletin(){
	var key = document.getElementById("key").value;
	if(key == ""){
		alert("请输入查询关键词!");
		return false;
	}
	else{
		window.location.href = "../servlet/ManageBulletin?method=search&key="+key+"";
		return true;
	}
}

function deleteBulletinOfSearching(bid,key){
	if(confirm("您确定要删除当前所选公告?")){
		window.location.href = "../servlet/ManageBulletin?method=delete&bid="+bid+"&isSearching=yes&key="+key+"";
	}
}
function deleteBulletin(bid){
	if(confirm("您确定要删除当前所选公告?")){
		window.location.href = "../servlet/ManageBulletin?method=delete&bid="+bid+"";
	}
}