package com.util;

import com.dao.GoodsTypeDAO;
import com.entity.GoodsType;
import com.dao.GoodsTypeDetailInfoDAO;
import com.entity.GoodsTypeDetail;
public class PublicToolGetGoodsTypeName {
	
	public static String getGoodTypeName(int typeId){
		
		GoodsTypeDAO gtdao = new GoodsTypeDAO();
		GoodsType gt = gtdao.getGoodsTypeInfo(typeId);
		String typeName = gt.getTypeName();
		
		return typeName;
	}
	public static String getGoodDetailTypeName(int Id){
		
		GoodsTypeDetailInfoDAO gtdao = new GoodsTypeDetailInfoDAO();
		GoodsTypeDetail gt = gtdao.getTypeDetailInfo(Id);
		String typeName = gt.getTypeDetailInfo();
		
		return typeName;
	}

}
