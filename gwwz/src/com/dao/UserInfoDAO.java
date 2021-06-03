package com.dao;

import java.util.ArrayList;

import com.common.DBConn;
import com.entity.UserInfo;
import com.entity.PageModel;

public class UserInfoDAO {

	public boolean checkAdminLogin(String userName,String userPwd){
		String sql = "select * from UserInfo where userName = '"+userName+"' and userPwd ='"+userPwd+"'";
		ArrayList<Object> list = DBConn.ExecuteQuery(sql, new UserInfo());
		if(list != null){
			if(list.size() == 1){
				return true;
			}
		}
		return false;
	}
	
	
	public boolean checkOldUserPwd(int id,String oldUserPwd){
		String sql = "select * from UserInfo where userPwd ='"+oldUserPwd+"' and id="+id;
		ArrayList<Object> list = DBConn.ExecuteQuery(sql, new UserInfo());
		if(list != null){
			if(list.size() == 1){
				return true;
			}
		}
		return false;
	}
	
	
	public UserInfo getUserId(String userName){
		String sql = "select * from UserInfo where userName = '"+userName+"'";
		ArrayList<Object> list = DBConn.ExecuteQuery(sql, new UserInfo());
		if(list != null){
			if(list.size() == 1){
				return (UserInfo)list.get(0);
			}
		}
		return null;
	}
	
	public UserInfo getUserName(int userId){
		String sql = "select * from UserInfo where id="+userId;
		ArrayList<Object> list = DBConn.ExecuteQuery(sql, new UserInfo());
		if(list != null){
			if(list.size() == 1){
				return (UserInfo)list.get(0);
			}
		}
		return null;
	}
	
	public void updateUserName(int userId,String userName){
		String sql = "update UserInfo set userName = '"+userName+"' where id="+userId;
		DBConn.ExecuteUD(sql);//执行SQL语句
	}
	public void updateUserInfo(int userId,String userName,String userRole){
		String sql = "update UserInfo set userName = '"+userName+"',Role = '"+userRole+"' where id="+userId;
		DBConn.ExecuteUD(sql);//执行SQL语句
	}
	
	public void updateUserPwd(int userId,String userPwd){
		String sql = "update UserInfo set userPwd = '"+userPwd+"' where id="+userId;
		DBConn.ExecuteUD(sql);//执行SQL语句
	}
	
	
	
	
	
public int getSumUserCount(){
	
	String sql = "select * from userInfo";
	ArrayList<Object> list = DBConn.ExecuteQuery(sql, new UserInfo());
	if(list != null){
		return list.size();
	}
	
	return 0;
}





//admin show all userinfo
public ArrayList<Object> getPageModelOfAllUser(PageModel pm){
	
	int everyPageProductCount = pm.getEveryPageCount();//每页显示的商品数
	int currentPage = pm.getCurrentPage();//当前页
	
	if(pm.getSumCount()%everyPageProductCount != 0 && currentPage == pm.getLastPage()){
		
		everyPageProductCount = pm.getSumCount()%everyPageProductCount;
		
	}
	else if(pm.getSumCount() < pm.getEveryPageCount()){
		
		everyPageProductCount = pm.getSumCount();
		
	}
	String sql  = "select * from  userinfo  order by id desc";
	
	return DBConn.ExecuteQuery(sql, new UserInfo());
	
}


//删除用户
	public void deleteUserInfo(int Id){
		
		String sql = "delete from userInfo where Id="+Id;
		DBConn.ExecuteUD(sql);//执行SQL语句
		
	}
	
	
	//增加用户
	
		public void addUserInfo(String userName,String userPwd,String userRole){
		
		String sql = null;
		

			sql = "insert into userInfo values(id,'"+userName+"','"+userPwd+"',"+userRole+")";

			
		
		DBConn.ExecuteUD(sql);//执行SQL语句
	}
	



}
