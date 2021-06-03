var xmlHttp = null;
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

		
	<!--剩余数量显示和购买数量判断不能超过剩余数量-->
function getCount(countRequire){
	var goodsCount = document.getElementById("count").value;
	if(goodsCount == ""){
		alert("请输入您要购买的数量!");
		return false;
	}
	else if(goodsCount <= 0){
		alert("购物件数必须大于0!请重新输入!");
		document.getElementById("count").value = "";
		return false;
	}
	else if(goodsCount > countRequire){
		alert("购物件数不能大于商品数量!");
		document.getElementById("count").value = "";
		return false;
	}
	var flag = false; 
	var count = document.getElementsByName("count");
	var size = count.length; 
	var exp = /^[0-9]*[1-9][0-9]*$/;
	
	//判断输入的计划数为异常字符 
	for(var i=0;i<size;i++) { 
	    if(!exp.test(count[i].value)){ 
	    	flag = true; 
	    	break; 
	    } 
	} 
	if(flag == true && !(document.getElementById("count").value <= 0)){ 
		alert("购买件数中包含特殊字符!请重新输入!");
		document.getElementById("count").value = "";
		return false ; 
	}
}

