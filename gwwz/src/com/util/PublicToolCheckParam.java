package com.util;
public class PublicToolCheckParam {
	
	//判断不为空    
    public static boolean checkNullAndEmpty(Object obj){
		
		if(obj != null && !obj.toString().trim().equals("")){
			return true;
		}
		return false;
	}
}
