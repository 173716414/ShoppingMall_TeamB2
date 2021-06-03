function addTypeName(){
	
	var typeName = document.getElementById("typeName").value;
	if(typeName == ""){
		alert("请输入您要添加的商品类型名称!");
		return false;
	}
}


function back(){

	window.location.href = "../servlet/ManageGoodsType?method=showManageGoodsTypePage";
	}
	
