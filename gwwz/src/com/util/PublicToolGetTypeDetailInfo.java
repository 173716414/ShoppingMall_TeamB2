package com.util;

import com.dao.GoodsTypeDAO;
import com.entity.GoodsType;
import com.dao.GoodsTypeDetailInfoDAO;
import com.entity.GoodsTypeDetail;

public class PublicToolGetTypeDetailInfo {
	
	public static int getTypeDetailnumb(int typeId){
		
		GoodsTypeDetailInfoDAO gtddao = new GoodsTypeDetailInfoDAO();

		int gt = gtddao.getTypeDetailCount(typeId);
		
		
		
		//if(typeName==null)typeName="kkkkk";
		return gt;
	}

}
