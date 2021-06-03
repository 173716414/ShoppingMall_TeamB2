package com.dao;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.common.DBConn;
import com.entity.ThirdInfo;
import com.entity.PageModel;
import com.entity.UserInfo;



public class ThirdInfoDAO {
	
	
public boolean checkThirdLogin(String email,String pwd){
		
		String sql  = "select * from ThirdInfo where email = '"+email+"' and pwd = '"+pwd+"'";
		ArrayList<Object> list = DBConn.ExecuteQuery(sql, new ThirdInfo());
		if(list != null){
			if(list.size() == 1){
				return true;
			}
		}
		return false;
		
		
	}
	public boolean checkOldUserPwd(int id,String oldUserPwd){
		String sql = "select * from ThirdInfo where Pwd ='"+oldUserPwd+"' and id="+id;
		ArrayList<Object> list = DBConn.ExecuteQuery(sql, new ThirdInfo());
		if(list != null){
			if(list.size() == 1){
				return true;
			}
		}
		return false;
	}
	
public static ThirdInfo getThirdInfo(String regEmail){
	
	String sql  = "select * from ThirdInfo where email='"+regEmail+"'";
	
	
	ArrayList<Object> list = DBConn.ExecuteQuery(sql, new ThirdInfo());
	return  (ThirdInfo)list.get(0);

}

public void addThird(String regEmail,String regPwd,String thirdName,String phone,String address){
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	String registerTime = sdf.format(new Date());
	String sql  = "insert into ThirdInfo values('"+regEmail+"','"+regPwd+"','"+thirdName+"','"+registerTime+"',1,'"+phone+"','"+address+"')";

	DBConn.ExecuteUD(sql);//执行SQL语句
}
public boolean checkEmail(String regEmail){
	
	String sql  = "select * from ThirdInfo where email='"+regEmail+"'";
	
	ArrayList<Object> list = DBConn.ExecuteQuery(sql, new ThirdInfo());
	if(list != null){
		if(list.size() == 1){
			return true;
		}
	}
	return false;
}






	public void coolThird(int thirdId,int isCooled){
		
			if(isCooled == 1){
				isCooled =0;
			}
			else{
				isCooled = 1;
			}
		
		String sql = "update ThirdInfo set isCooled = "+isCooled+" where id="+thirdId;
		
		DBConn.ExecuteUD(sql);//执行SQL语句
	}
	
	
	
	public ArrayList<Object> getPageModel(PageModel pm){
			
			int everyPageThirdInfoCount = pm.getEveryPageCount();//每页显示的公告数
			
			int currentPage = pm.getCurrentPage();//当前页
			
			if(pm.getSumCount()%everyPageThirdInfoCount != 0 && currentPage == pm.getLastPage()){
				
				everyPageThirdInfoCount = pm.getSumCount()%everyPageThirdInfoCount;
				
			}
			
	
			String sql  = "select * from (select top "+everyPageThirdInfoCount+" * from (select top "+pm.getEveryPageCount()*pm.getCurrentPage()+" * from ThirdInfo order by id) as a order by id desc) as b order by id";
			
			return DBConn.ExecuteQuery(sql, new ThirdInfo());
		}
	
	public int getSumSearchThirdCount(String key){
			
			String sql = "select * from ThirdInfo where email like  '%"+key+"%'";
			
			ArrayList<Object> list = DBConn.ExecuteQuery(sql, new ThirdInfo());
			
			if(list != null){
				
				return list.size();
			}
			return 0;
		}
	
	
	public int getSumThirdCount(){
		
		String sql = "select * from ThirdInfo";
		
		ArrayList<Object> list = DBConn.ExecuteQuery(sql, new ThirdInfo());
		
		if(list != null){
			
			return list.size();
		}
		return 0;
	}

public ThirdInfo getThirdInfo(int id){
	
	String sql  = "select * from ThirdInfo where id="+id;

	ArrayList<Object> list = DBConn.ExecuteQuery(sql, new ThirdInfo());
	
	if(list != null){
		if(list.size() == 1){
			
			return (ThirdInfo)list.get(0);
		}
	}
	return null;
}
	
	
	
	
public boolean isCooled(String email){
	
	String sql ="select * from ThirdInfo where email = '"+email+"'";
	
	ArrayList<Object> list = DBConn.ExecuteQuery(sql, new ThirdInfo());
	if(list != null){
		if(list.size() == 1){
			int isCooled = ((ThirdInfo)list.get(0)).getIsCooled();
			if(isCooled == 1){
				return true;
			}
		}
	}
	return false;
}



public ArrayList<Object> searchThirdInfo(PageModel pm,String key){
	
	int everyPageThirdInfoCount = pm.getEveryPageCount();//每页显示的公告数
	
	int currentPage = pm.getCurrentPage();//当前页
	
	if(pm.getSumCount()%everyPageThirdInfoCount != 0 && currentPage == pm.getLastPage()){
		
		everyPageThirdInfoCount = pm.getSumCount()%everyPageThirdInfoCount;
		
	}
	
	String sql  = "select * from (select top "+everyPageThirdInfoCount+" * from (select top "+pm.getEveryPageCount()*pm.getCurrentPage()+" * from ThirdInfo where email like '%"+key+"%' order by id) as a order by id desc) as b order by id";
	
	return DBConn.ExecuteQuery(sql, new ThirdInfo());
}



//public void updateThirdName(int userId,String userName,String phone,String address){
	public void updateThirdName(int userId,String phone,String address){
		String sql = "update thirdInfo set phone = '"+phone+"',address = '"+address+"' where id="+userId;
		DBConn.ExecuteUD(sql);//执行SQL语句
	}
	
	public void updateThirdPwd(int userId,String userPwd){
		String sql = "update thirdInfo set Pwd = '"+userPwd+"' where id="+userId;
		DBConn.ExecuteUD(sql);//执行SQL语句
	}

}
