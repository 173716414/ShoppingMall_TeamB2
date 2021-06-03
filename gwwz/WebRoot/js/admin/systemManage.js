
function loginOut(exit){
	
	if(confirm("您确定要退出系统?")){
		window.location.href = "../servlet/CheckAdminLogin?method=loginOut";
	}
}