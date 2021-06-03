function showAddGoodsInfoPage(){
	window.location.href = "../servlet/ManageGoodsInfo?method=showAddGoodsInfoPage";
}

function deletMoreGoodsInfo(){
	var ckb = document.getElementsByName("ckb");
	var flag = 0;
	var i;
	if(ckb.length == 0){
		alert("当前无任何商品信息!");
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
		if(confirm("您确定要删除当前所选商品?")){
			return true;
		}
		return false;
		
	}
	else{
		alert("请选择您要删除的商品!");
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



function searchGoodsInfo(){
	var key = document.getElementById("key").value;
	if(key == ""){
		alert("请输入查询关键词!");
		return false;
	}
	else{
		window.location.href = "../servlet/ManageGoodsInfo?method=search&key="+key+"";
		return true;
	}
}

function deleteGoodsInfoOfSearching(goodsId,key){
	if(confirm("您确定要删除当前所选商品?")){
		window.location.href = "../servlet/ManageGoodsInfo?method=delete&goodsId="+goodsId+"&isSearching=yes&key="+key+"";
	}
}
function deleteGoodsInfo(goodsId){
	if(confirm("您确定要删除当前所选商品?")){
		window.location.href = "../servlet/ManageGoodsInfo?method=delete&goodsId="+goodsId+"";
	}
}


function coolGoodsInfoOfSearching(GoodsId,isCooled,key){
	if(isCooled == "0"){
		if(confirm("您确定要取消审核当前所选商品?")){
			window.location.href = "../servlet/ManageGoodsInfo?method=cool&GoodsId="+GoodsId+"&isCooled="+isCooled+"&isSearching=yes&key="+key+"";
		}
	}
	else{
		if(confirm("您确定要审核当前所选商品?")){
			window.location.href = "../servlet/ManageGoodsInfo?method=cool&GoodsId="+GoodsId+"&isCooled="+isCooled+"&isSearching=yes&key="+key+"";
		}
	}
}

function coolGoodsInfo(GoodsId,isCooled){
	if(isCooled == "0"){
		if(confirm("您确定要取消审核当前所选商品?")){
			window.location.href = "../servlet/ManageGoodsInfo?method=cool&GoodsId="+GoodsId+"&isCooled="+isCooled+"";
		}
	}
	else{
		if(confirm("您确定要审核当前所选商品?")){
			window.location.href = "../servlet/ManageGoodsInfo?method=cool&GoodsId="+GoodsId+"&isCooled="+isCooled+"";
		}
	}
}


function coolMoreGoodsInfo(){
	var ckb = document.getElementsByName("ckb");
	var flag = 0;
	var i;
	if(ckb.length == 0){
		alert("当前无任何商品信息!");
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
		if(confirm("您确定要取消审核当前所选客户?")){
			return true;
		}
		return false;
		
	}
	else{
		alert("请选择您要取消审核的商品!");
		return false;
	}
}
