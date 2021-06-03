package com.util;

import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspWriter;

import com.entity.GoodsInfo;

public class PublicToolIndexProductShow {

		public static void typeInfo(HttpServletRequest request, HttpServletResponse response,ArrayList<GoodsInfo> productListShow,JspWriter out){
		
		
			try {
				DecimalFormat df = new DecimalFormat("0.00");
				if(productListShow != null && productListShow.size() >= 8){
			  		for(int i=0;i<8;i++){
			  			GoodsInfo productShow = productListShow.get(i);
			  			String prePrice = df.format(productShow.getPrice());
			  			String currentPrice = df.format(productShow.getDiscountPrice());
			  			String discount = String.format("%.1f", productShow.getDiscount());
			  			if((int)productShow.getDiscount() == 10){
			  				if(PublicToolCheckParam.checkNullAndEmpty(productShow.getPhoto())){
			  					out.println(" <li>           <div class='recommendedpic bor1'><a href='servlet/ProductInfo?gid="+productShow.getGoodsId()+"'><img src='"+productShow.getPhoto()+"' border='0' width='158' height='143'/></a></div>");
								out.println(" <div class='recommendedtitle'><a href='servlet/ProductInfo?gid="+productShow.getGoodsId()+"'>"+productShow.getGoodsName()+"</a></div>");
								out.println("<div class='recommendedprice1'>£§"+currentPrice+"</div></li>");
			  				}
			  				else{
			  					out.println(" <li>           <div class='recommendedpic bor1'><a href='servlet/ProductInfo?gid="+productShow.getGoodsId()+"'><img src='webstyle/defaultpic.gif' border='0' width='158' height='143'/></a></div>");
								out.println(" <div class='recommendedtitle'><a href='servlet/ProductInfo?gid="+productShow.getGoodsId()+"'>"+productShow.getGoodsName()+"</a></div>");
								out.println("<div class='recommendedprice1'>£§"+currentPrice+"</div></li>");
			  				}
			  			}
			  			else{
			  				if(PublicToolCheckParam.checkNullAndEmpty(productShow.getPhoto())){
			  				
										  					out.println(" <li>           <div class='recommendedpic bor1'><a href='servlet/ProductInfo?gid="+productShow.getGoodsId()+"'><img src='"+productShow.getPhoto()+"' border='0' width='158' height='143'/></a></div>");
								out.println(" <div class='recommendedtitle'><a href='servlet/ProductInfo?gid="+productShow.getGoodsId()+"'>"+productShow.getGoodsName()+"</a></div>");
								out.println("<div class='recommendedprice1'>£§"+currentPrice+" <font color='#FF3399' >"+discount+"</font>’€</div></li>");
			  				}
			  				else{
			  					out.println("       <li>       <div class='recommendedpic bor1'><a href='servlet/ProductInfo?gid="+productShow.getGoodsId()+"'><img src='webstyle/defaultpic.gif' border='0' width='158' height='143'/></a></div>");
								out.println(" <div class='recommendedtitle'><a href='servlet/ProductInfo?gid="+productShow.getGoodsId()+"'>"+productShow.getGoodsName()+"</a></div>");
								out.println("<div class='recommendedprice1'>£§"+currentPrice+" <font color='#FF3399' >"+discount+"</font>’€</div> </li> ");
			  				}
			  			}
			  		}
		  		}
		  		else if(productListShow != null && productListShow.size() < 8){
		  			//for(int i=0;i<productListShow.size();i++){
						for(int i=0;i<productListShow.size();i++){
			  			GoodsInfo productShow = productListShow.get(i);
			  			String prePrice = df.format(productShow.getPrice());
			  			String currentPrice = df.format(productShow.getDiscountPrice());
			  			String discount = String.format("%.1f", productShow.getDiscount());
			  			if((int)productShow.getDiscount() == 10){
			  				if(PublicToolCheckParam.checkNullAndEmpty(productShow.getPhoto())){
			  					out.println("<li>            <div class='recommendedpic bor1'><a href='servlet/ProductInfo?gid="+productShow.getGoodsId()+"'><img src='"+productShow.getPhoto()+"' border='0' width='158' height='143'/></a></div>");
								out.println(" <div class='recommendedtitle'><a href='servlet/ProductInfo?gid="+productShow.getGoodsId()+"'>"+productShow.getGoodsName()+"</a></div>");
								out.println("<div class='recommendedprice1'>£§"+currentPrice+"</div></li>");
			  				}
			  				else{
			  					out.println(" <li>           <div class='recommendedpic bor1'><a href='servlet/ProductInfo?gid="+productShow.getGoodsId()+"'><img src='webstyle/defaultpic.gif' border='0' width='158' height='143'/></a></div>");
								out.println(" <div class='recommendedtitle'><a href='servlet/ProductInfo?gid="+productShow.getGoodsId()+"'>"+productShow.getGoodsName()+"</a></div>");
								out.println("<div class='recommendedprice1'>£§"+currentPrice+"</div></li>");
			  				}
			  			}
			  			else{
			  				if(PublicToolCheckParam.checkNullAndEmpty(productShow.getPhoto())){
			  				
										  					out.println(" <li>           <div class='recommendedpic bor1'><a href='servlet/ProductInfo?gid="+productShow.getGoodsId()+"'><img src='"+productShow.getPhoto()+"' border='0' width='158' height='143'/></a></div>");
								out.println(" <div class='recommendedtitle'><a href='servlet/ProductInfo?gid="+productShow.getGoodsId()+"'>"+productShow.getGoodsName()+"</a></div>");
								out.println("<div class='recommendedprice1'>£§"+currentPrice+" <font color='#FF3399' >"+discount+"</font>’€</div></li>");

							
							
							
			  				}
			  				else{
			  					out.println("       <li>       <div class='recommendedpic bor1'><a href='servlet/ProductInfo?gid="+productShow.getGoodsId()+"'><img src='webstyle/defaultpic.gif' border='0' width='158' height='143'/></a></div>");
								out.println(" <div class='recommendedtitle'><a href='servlet/ProductInfo?gid="+productShow.getGoodsId()+"'>"+productShow.getGoodsName()+"</a></div>");
								out.println("<div class='recommendedprice1'>£§"+currentPrice+" <font color='#FF3399' >"+discount+"</font>’€</div> </li> ");
			  				}
			  				
			  			}
		  			}
		  		}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
}
