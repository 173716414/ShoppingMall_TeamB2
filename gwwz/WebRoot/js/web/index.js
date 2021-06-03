function changeAd(){
	if(document.getElementById("ad").style.backgroundImage == "url(image/icon/ad1.jpg)"){
		document.getElementById("ad").style.backgroundImage = "url(image/icon/ad2.jpg)";
	}
	else{
		document.getElementById("ad").style.backgroundImage = "url(image/icon/ad1.jpg)";
	}

	setTimeout("changeAd()", 2000);
}


