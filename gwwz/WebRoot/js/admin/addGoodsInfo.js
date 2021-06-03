var xmlHttp = null;
var responseMSG = null;
    	//创建XMLHttp对象
    	function createXMLHttpRequest(){
			if(window.XMLHttpRequest){
				xmlHttp = new XMLHttpRequest();
			}
			else{
				try{
					xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
				}catch(e){
					xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
				}
			}
		}
		//创建发送数据对象
		function sendRequest(){
	 		var goodsTypeId = document.getElementById("goodsTypeId").value;
			if(xmlHttp==null){
				createXMLHttpRequest();
			}
			//采用异步传输,POST方法
			xmlHttp.open("POST","../servlet/ManageGoodsInfo?method=getTypeDetailInfo",true);
			//指定一个HTTP报头
			xmlHttp.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
			xmlHttp.onreadystatechange = callback;
			//将得到的输入信息传入到AjaxDoInput.java去处理
			xmlHttp.send("goodsTypeId="+goodsTypeId);
		}
		
		function callback(){
			if(xmlHttp.readyState == 4 && xmlHttp.status == 200){
				var typeContent = xmlHttp.responseText; //获取服务器返回的值
				var values = typeContent.split("|");
				var select = document.getElementById("typeDetailInfo");
				//先清空下拉列表中的值,显示子分类用
				select.options.length = 0;//清空
				for(var i=0;i<values.length-1;i++){
					var valuesx =values[i].split(",");
					select.options.add(new Option(valuesx[0],valuesx[1]));			
		  }	
			}
		}
		
		
function checkGoodsInfo(){
	var flag1 = false; 
	var flag2 = false;
	var price = document.getElementsByName("price");
	var discount = document.getElementsByName("discount");
	var size1 = price.length; 
	var size2 = discount.length;
	var exp1 = /^\d+(\.{0,1}\d+){0,1}$/;
	
	//判断输入的计划数为异常字符 
	for(var i=0;i<size1;i++){ 
	    if(!exp1.test(price[i].value)){ 
	    flag1 = true;
	    break; 
	    } 
	} 
	
	for(var i=0;i<size2;i++){ 
	    if(!exp1.test(discount[i].value)){ 
	    flag2 = true;
	    break; 
	    } 
	} 
	
	var flag3 = false; 
	var countRequire = document.getElementsByName("countRequire");
	var size3 = countRequire.length; 
	var exp2 = /^[0-9]*[1-9][0-9]*$/;
	
	//判断输入的计划数为异常字符 
	for(var i=0;i<size3;i++){ 
	    if(!exp2.test(countRequire[i].value)){ 
	    flag3 = true;
	    break; 
	    } 
	} 
	
	if(document.getElementById("goodsName").value == ""){
		alert("请输入商品名称!");
		return false;
	}
	else if(document.getElementById("price").value == ""){
		alert("请输入商品价格!");
		return false;
	}
	else if(flag1 == true){ 
		alert("输入的价格中包含特殊字符!请重新输入!");
		document.getElementById("price").value = "";
		return false ; 
	}
	else if(flag2 == true &&  document.getElementById("discount").value != ""){ 
		alert("输入的折扣中包含特殊字符!请重新输入!");
		document.getElementById("discount").value = "";
		return false ; 
	}
	else if(document.getElementById("discount").value != "" && (document.getElementById("discount").value >10 || document.getElementById("discount").value <1)){
		alert("打折区间为1到10折!请重新输入!")
		return false;
	}
	else if(document.getElementById("countRequire").value == ""){
		alert("请输入数量!");
		return false;
	}
	else if(flag3 == true){
		alert("您输入的数量中包含特殊字符!请重新输入!");
		document.getElementById("countRequire").value = "";
		return false;
	}
	
}



function back(){

	window.location.href = "../servlet/ManageGoodsInfo?method=showManageGoodsInfoPage";
	}
	