package com.util;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


public class Validate {
	
	/**
	 * 是否为数字和英文验证
	 *
	 */
	public int getIntAndChar(String str){
		char c;
		int i;
		for (i = 0; i<str.length(); i++){
			c = str.charAt(i);
			if(!((c>='0' && c<='9') || (c>='a' && c<='z') || (c>='A' && c<='Z'))){
				break;
			}
		}//判断字符是否在某个区间
		if(i < str.length()){
			return -1;
		}else{
			return 0;
		}
	}
	
	/**
	 * 是否为整数验证
	 *
	 */
	public int getInt(String str){
		char c;
		int i;
		for (i = 0; i<str.length(); i++){
			c = str.charAt(i);
			if(!(c>='0' && c<='9')){
				break;
			}
		}//判断字符是否在某个区间
		if(i < str.length()){
			return -1;
		}else{
			return 0;
		}
	}
	
	/**
	 * 是否为非法字符验证
	 *
	 */
	public boolean getLawlessChar(String str){
		boolean flag = false;
		char c;
		for(int i = 0;i < str.length();i++){
			c = str.charAt(i);
			switch(c){
			case '<' : flag = true; break;
			case '>' : flag = true; break;
			case '"' : flag = true; break;
			case '&' : flag = true; break;
			case ' ' : flag = true; break;
			}
		}
		return flag;
	}
	
	/**
	 * 中文转换
	 * 将gb2312编码转换成unicode编码
	 */
	public String getUnicode(String str) {
		if(str != null){
			try {
				return new String(str.getBytes("iso8859_1"),"gb2312");
			} catch (UnsupportedEncodingException e) {
				// TODO 自动生成 catch 块
				e.printStackTrace();
				return str;
			}
		}else{
			return null;
		}
	}
	
	/**
	 * 中文转换
	 * 将unicode编码转换成gb2312编码
	 */
	public String getGb2312(String str) {
		if(str != null){
			try {
				return new String(str.getBytes("gb2312"),"iso8859_1");
			} catch (UnsupportedEncodingException e) {
				// TODO 自动生成 catch 块
				e.printStackTrace();
				return str;
			}
		}else{
			return null;
		}
	}
	
	/**
	 * 格式化日期 年-月-日 小时（0-23）:分钟:秒
	 */
	public static String getSystemDate(){
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		return df.format(date);
	}
	
	
	
	
	
	
	
	
	
	//日期比较   早于当前日期返回TRUE ,比当前日期迟,返回假
	public  boolean getDateIfNow(String date) throws ParseException {
		
			String nowdate=getSystemDate();
		
			
			SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
			Date ddd= new Date();
			ddd=formatDate.parse(date);   //输入的日期
			
			
			Date xxx=new Date();
			xxx=formatDate.parse(nowdate);   //当前日期
			
		 boolean flag = ddd.before(xxx);
		 //if(flag)System.out.print("早于今天");else
		 //System.out.print("晚于今天");
		return flag;
	}
		
	
/**     * Date转String  
   *      * @param count  
   * @return     
 * @throws ParseException */  
     public String datemmdd(String date) throws ParseException {  
	      
		SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd"); 
		Date ddd= new Date();
		ddd=formatDate.parse(date);
		formatDate = new SimpleDateFormat("MM月dd日"); 
		String str = formatDate.format(ddd);        
		String time;
		
		return str; 
	}
	
     public String datemmddtime(String date) throws ParseException {  
	      
		SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		Date ddd= new Date();
		ddd=formatDate.parse(date);
		formatDate = new SimpleDateFormat("MM月dd日  HH:mm"); 
		String str = formatDate.format(ddd);        
		String time;
		
		return str; 
	}
	
	
	
	/**
	 * 格式化日期 月-日
	 */
	public String getSystemDatemmdd(){
		SimpleDateFormat df = new SimpleDateFormat("MM月dd日");
		Date date = new Date();
		return df.format(date);
	}
	
	
	
	
	/**
	 * 四舍五入
	 */
	public float getRround(float f){
		int tem = (int)(f*100+0.5);
		float ff = ((float)tem/100);
		return ff;
	}
}
