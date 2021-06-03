package com.common;

import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DBConn {

	//连接字符串
	
	                                      
	//private final static String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	//private final static String URL = "jdbc:sqlserver://localhost:1433;databaseName=gwwz";
	private final static String DRIVER = "com.mysql.jdbc.Driver";
	private final static String URL = "jdbc:mysql://8.140.30.207:3306/gwwz?characterEncoding=utf8";
	private final static String USER = "root";
	private final static String PWD = "";  //这里修改数据库密码       ////这里修改数据库密码
	
	/**
	 * 
	 * 使用了Tomcat的连接池
	 * 
	 * @return
	
	public static Connection GetConn() {
		
		try {
			//获取Tomcat中的连接，需要使用JNDI这个服务
	    	//通过JNDI找到Tomcat的连接池
	    	Context ctx = new InitialContext();
	    	
	    	DataSource ds = (DataSource)ctx.lookup("java:comp/env/myPool");
	    	
	    	Connection conn = ds.getConnection();//连接来自于连接池
	    
	    	return conn;
	    	
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
    	return null;
	}
 */
	//关闭连接
	public static void CloseConn(ResultSet rs,PreparedStatement pstmt,Connection conn) {
		try {
			
			if(rs!=null){
				rs.close();
			}
			
			if(pstmt!=null){
				pstmt.close();
			}
			if (conn != null && conn.isClosed() == false) {				
				conn.close();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	
	/**
	 * 
	 * 
	 * 查询的封装
	 * @param sql
	 * @param obj
	 * @return
	 */
	
	
@SuppressWarnings("unchecked")
public static ArrayList<Object> ExecuteQuery(String sql,Object obj){
		
		//获取数据库连接
		Connection conn = DBConn.getConn();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList list = new ArrayList();
		
		try {			
			//创建执行SQL语句的pstmt对象
			pstmt = conn.prepareStatement(sql);
			
			//执行SQL语句,并且返回结果集
			rs = pstmt.executeQuery();
									
			while(rs.next()){ //遍历结果集	
				
				//使用Java反射机制，获取对象信息，根据对象的方法，动态调用类中的所有set方法，完成对象的赋值			
				Class cla = Class.forName(obj.getClass().getName());//动态加载类											
				Method [] ms = cla.getMethods();//获取类的方法
				Object currentobj  = cla.newInstance();//创建该类的实例
				
				for(int i=0;i<ms.length;i++){//遍历所有的方法
					if(ms[i].getName().startsWith("set")){//获取以set开头的方法
						Class[] cc = ms[i].getParameterTypes();//获取当前方法的参数
						
						if(cc.length>0){//判断参数的个数，是否大于0
							if("int".equals(cc[0].getName().toLowerCase())){//获取参数的类型，int类型
								ms[i].invoke(currentobj,rs.getInt(ms[i].getName().substring(3)));
							}
							else if("float".equals(cc[0].getName().toLowerCase())){//获取参数的类型，float类型
								ms[i].invoke(currentobj,rs.getFloat(ms[i].getName().substring(3)));
							}
							else if("double".equals(cc[0].getName().toLowerCase())){//获取参数的类型，double类型
								ms[i].invoke(currentobj,rs.getDouble(ms[i].getName().substring(3)));
							}
							else if("char".equals(cc[0].getName().toLowerCase())){//获取参数的类型，char类型								
								ms[i].invoke(currentobj,new String(rs.getString(ms[i].getName().substring(3))).charAt(0));								
							}
							else if(cc[0].getName().indexOf("String")!=0){//获取参数的类型，string类型				
								ms[i].invoke(currentobj,rs.getString(ms[i].getName().substring(3)));							
							}else{
								System.out.println("常用数据类型不匹配！（只能支持：int、float、double、char、String数据类型）");
							}
							
						}else{ //set方法没有传递参数
							System.out.println("set方法必须有且只有一个参数！");
						}
					}				
				}	
				
				list.add(currentobj);//将新添加的实例，存放在List中
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();			
		}finally{
			//关闭连接 
			DBConn.CloseConn(rs, pstmt, conn);
		}		
		return null;		
	}
	

	
	/**
	 * 
	 * 
	 * 增、删、改的封装
	 * @param sql
	 * @return
	 */
	public static int ExecuteUD(String sql){
		
		Connection conn = DBConn.getConn();
		PreparedStatement pstmt = null;
		try {
			
			pstmt = conn.prepareStatement(sql);
			
			return pstmt.executeUpdate();
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally{
			
			DBConn.CloseConn(null, pstmt, conn);
		}
		return 0;
	}
	
	
	//打开连接
	public static Connection getConn() {

		try {
			
			Class.forName(DRIVER);
			return DriverManager.getConnection(URL, USER, PWD);
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return null;
	}
}
