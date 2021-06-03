function deletMoreOrder(){
	var ckb = document.getElementsByName("ckb");
	var flag = 0;
	var i;
	if(ckb.length == 0){
		alert("当前无任何订单信息!");
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
		if(confirm("您确定要删除当前所选订单?")){
			return true;
		}
		return false;
		
	}
	else{
		alert("请选择您要删除的订单!");
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



function searchOrder(){
	var key = document.getElementById("key").value;
	var orderTime1 = /\d{4}-\d{2}/;
	var orderTime2 = /\d{4}-\d{2}-\d{2}/;
	if(key == ""){
    	alert("请输入要查询的订单时间!");
    	return false;
    }
	else if(orderTime1.test(key) || orderTime2.test(key)){
		window.location.href = "../servlet/ManageOrder?method=search&key="+key+"";
    	return true;
		
	}
	else{
		alert("请输入正确的时间格式!\n例如：2008-08-08\n      2008-08");
		document.getElementById("key").value = "";
    	return false;    
	}
}


function deleteOrderOfSearching(orderId,key){
	if(confirm("您确定要删除当前所选订单?")){
		window.location.href = "../servlet/ManageOrder?method=delete&orderId="+orderId+"&isSearching=yes&key="+key+"";
	}
}
function deleteOrder(orderId){
	if(confirm("您确定要删除当前所选订单?")){
		window.location.href = "../servlet/ManageOrder?method=delete&orderId="+orderId+"";
	}
}



function confirmOrderOfSearching(orderId,status,key){
	if(status == "1"){
		if(confirm("您确定要取消对当前所选订单的确认?")){
			window.location.href = "../servlet/ManageOrder?method=confirm&orderId="+orderId+"&status="+status+"&key="+key+"";
		}
	}
	else{
		if(confirm("您确定要确认当前所选订单?")){
			window.location.href = "../servlet/ManageOrder?method=confirm&orderId="+orderId+"&status="+status+"&key="+key+"";
		}
	}
}

function confirmOrder(orderId,status){
	if(status == "1"){
		if(confirm("您确定要取消对当前所选订单的确认?")){
			window.location.href = "../servlet/ManageOrder?method=confirm&orderId="+orderId+"&status="+status+"";
		}
	}
	else{
		if(confirm("您确定要确认当前所选订单?")){
			window.location.href = "../servlet/ManageOrder?method=confirm&orderId="+orderId+"&status="+status+"";
		}
	}
}


function CheckOrderTime(orderTime)   
{    
    var reg = /^(\d+)-(\d{ 1,2 })-(\d{ 1,2 })$/;    
    var r = orderTime.match(reg);    
    if(r==null)return false;    
    r[2]=r[2]-1;    
    var d= new Date(r[1],r[2],r[3],r[4],r[5],r[6]);    
    if(d.getFullYear()!=r[1])return false;    
    if(d.getMonth()!=r[2])return false;    
    if(d.getDate()!=r[3])return false;   
    return true;    
}    

function back(){

	window.location.href = "../servlet/ManageOrder?method=showManageOrderPage";
	}
	
	