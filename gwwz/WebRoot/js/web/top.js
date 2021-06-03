function getKey(){
	var key = document.getElementById("key").value;
	if(key==""){
		alert("请输入搜索关键字!");
		return false;}
	else{
		top.location.href = "../servlet/SearchProduct?key="+key+"";
		return true;
	}
}