package com.dao;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.common.DBConn;
import com.entity.CustomerInfo;
import com.entity.PageModel;



public class CustomerInfoDAO {

public static CustomerInfo getCustomerInfo(String regEmail){
	
	String sql  = "select * from CustomerInfo where email='"+regEmail+"'";
	
	
	ArrayList<Object> list = DBConn.ExecuteQuery(sql, new CustomerInfo());
	return  (CustomerInfo)list.get(0);

}

public void addCustomer(String regEmail,String regPwd,String question,String answer){
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	String registerTime = sdf.format(new Date());
	String sql  = "insert into CustomerInfo values(id,'"+regEmail+"','"+regPwd+"','"+registerTime+"',0,'"+question+"','"+answer+"')";

	DBConn.ExecuteUD(sql);//执行SQL语句
}
public boolean checkEmail(String regEmail){
	
	String sql  = "select * from CustomerInfo where email='"+regEmail+"'";
	
	ArrayList<Object> list = DBConn.ExecuteQuery(sql, new CustomerInfo());
	if(list != null){
		if(list.size() == 1){
			return true;
		}
	}
	return false;
}


public boolean checkLogin(String email,String pwd){
		
		String sql  = "select * from CustomerInfo where email = '"+email+"' and pwd = '"+pwd+"'";
		ArrayList<Object> list = DBConn.ExecuteQuery(sql, new CustomerInfo());
		if(list != null){
			if(list.size() == 1){
				return true;
			}
		}
		return false;
		
		
	}
	
	//校验找加密码问题是否正确 
public boolean checklost(String email,String question,String answer){
		
		String sql  = "select * from CustomerInfo where email = '"+email+"' and question = '"+question+"' and answer = '"+answer+"'";
		ArrayList<Object> list = DBConn.ExecuteQuery(sql, new CustomerInfo());
		if(list != null){
			if(list.size() == 1){
				return true;
			}
		}
		return false;
		
		
	}

	//密码找回功能设定密码为111111
	public void setdefaultpwd(String email){
		
		
		String sql = "update CustomerInfo set pwd ='111111' where email='"+email+"'";
		
		DBConn.ExecuteUD(sql);//执行SQL语句
	}
	//修改密码
	public void updatepwd(String email,String pwd){
		
		
		String sql = "update CustomerInfo set pwd ='"+pwd+"' where email='"+email+"'";
		
		DBConn.ExecuteUD(sql);//执行SQL语句
	}


	public void coolCustomer(int customerId,int isCooled){
		
			if(isCooled == 1){
				isCooled =0;
			}
			else{
				isCooled = 1;
			}
		
		String sql = "update CustomerInfo set isCooled = "+isCooled+" where id="+customerId;
		
		DBConn.ExecuteUD(sql);//执行SQL语句
	}
	
	
	
	
	public CustomerInfo getCustomerInfo(int id){
		
		String sql  = "select * from CustomerInfo where id="+id;
	
		ArrayList<Object> list = DBConn.ExecuteQuery(sql, new CustomerInfo());
		
		if(list != null){
			if(list.size() == 1){
				
				return (CustomerInfo)list.get(0);
			}
		}
		return null;
	}
	
	public ArrayList<Object> getPageModel(PageModel pm){
			
			int everyPageCustomerInfoCount = pm.getEveryPageCount();//每页显示的公告数
			
			int currentPage = pm.getCurrentPage();//当前页
			
			if(pm.getSumCount()%everyPageCustomerInfoCount != 0 && currentPage == pm.getLastPage()){
				
				everyPageCustomerInfoCount = pm.getSumCount()%everyPageCustomerInfoCount;
				
			}
			
	
			String sql  = "select * from  CustomerInfo   limit "+((pm.getCurrentPage()-1)*pm.getEveryPageCount())+","+(pm.getEveryPageCount()  );
			
			return DBConn.ExecuteQuery(sql, new CustomerInfo());
		}
	
	//所有用户娄
	public int getSumCustomerCount(){
		
		String sql = "select * from CustomerInfo";
		
		ArrayList<Object> list = DBConn.ExecuteQuery(sql, new CustomerInfo());
		
		if(list != null){
			
			return list.size();
		}
		return 0;
	}
	//冻结用户娄
	public int getdongjie(){
		
		String sql = "select * from CustomerInfo where iscooled=1";
		
		ArrayList<Object> list = DBConn.ExecuteQuery(sql, new CustomerInfo());
		
		if(list != null){
			
			return list.size();
		}
		return 0;
	}
	//正常用户娄
	public int getzhengchang(){
		
		String sql = "select * from CustomerInfo where iscooled=0";
		
		ArrayList<Object> list = DBConn.ExecuteQuery(sql, new CustomerInfo());
		
		if(list != null){
			
			return list.size();
		}
		return 0;
	}



//搜索总数
public int getSumSearchCustomerCount(String key){
		
		String sql = "select * from CustomerInfo where email like  '%"+key+"%'";
		
		ArrayList<Object> list = DBConn.ExecuteQuery(sql, new CustomerInfo());
		
		if(list != null){
			
			return list.size();
		}
		return 0;
	}
	
	
		//冻结用户娄
	public int getsdongjie(String key){
		
		String sql = "select * from CustomerInfo where iscooled=1 and  email  like '%"+key+"%'";
		
		ArrayList<Object> list = DBConn.ExecuteQuery(sql, new CustomerInfo());
		
		if(list != null){
			
			return list.size();
		}
		return 0;
	}
	//正常用户娄
	public int getszhengchang(String key){
		
		String sql = "select * from CustomerInfo where iscooled=0 and email  like '%"+key+"%'";
		
		ArrayList<Object> list = DBConn.ExecuteQuery(sql, new CustomerInfo());
		
		if(list != null){
			
			return list.size();
		}
		return 0;
	}

	
public boolean isCooled(String email){
	
	String sql ="select * from CustomerInfo where email = '"+email+"'";
	
	ArrayList<Object> list = DBConn.ExecuteQuery(sql, new CustomerInfo());
	if(list != null){
		if(list.size() == 1){
			int isCooled = ((CustomerInfo)list.get(0)).getIsCooled();
			if(isCooled == 1){
				return true;
			}
		}
	}
	return false;
}



public ArrayList<Object> searchCustomerInfo(PageModel pm,String key){
	
	int everyPageCustomerInfoCount = pm.getEveryPageCount();//每页显示的公告数
	
	int currentPage = pm.getCurrentPage();//当前页
	
	if(pm.getSumCount()%everyPageCustomerInfoCount != 0 && currentPage == pm.getLastPage()){
		
		everyPageCustomerInfoCount = pm.getSumCount()%everyPageCustomerInfoCount;
		
	}
	
	String sql  = "select * from   CustomerInfo where email like '%"+key+"%' order by id  limit  "+((pm.getCurrentPage()-1)*pm.getEveryPageCount())+","+(pm.getEveryPageCount()  );
	
	return DBConn.ExecuteQuery(sql, new CustomerInfo());
}
}
