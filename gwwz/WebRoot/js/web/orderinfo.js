//创建XMLHttp对象
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
		//创建发送数据对象
		function sendRequest(orderId){
			var serviceAssessment = document.getElementById("serviceAssessment").value;
			if(serviceAssessment == ""){
				alert("请输入服务评价内容!");
				return false;
			}
			else{
				var isInsert = "insert";
				var method = "showOrderInfo";
				if(xmlHttp == null){
					createXMLHttpRequest();
				}		
				//采用异步传输,GET方法
				xmlHttp.open("POST","../servlet/OrderInfo",true);
				xmlHttp.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
				xmlHttp.send("isInsert="+isInsert+"&method="+method+"&serviceAssessment="+serviceAssessment+"&orderId="+orderId);
				document.getElementById("serviceAssessment").value = "";
				xmlHttp.onreadystatechange = callback;
				return true;
			}
		}
		
		function callback(){
			if(xmlHttp.readyState == 4 && xmlHttp.status == 200){
				var serviceAssessmentTable = document.getElementById("serviceAssessmentTable");
				serviceAssessmentTable.innerHTML = xmlHttp.responseText;
			}		
		}