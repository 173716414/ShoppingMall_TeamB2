function changeAd(){
	if(document.getElementById("ad").style.backgroundImage == "url(../image/icon/ad4.jpg)"){
		document.getElementById("ad").style.backgroundImage = "url(../image/icon/ad5.jpg)";
	}
	else{
		document.getElementById("ad").style.backgroundImage = "url(../image/icon/ad4.jpg)";
	}

	setTimeout("changeAd()", 2000);
}