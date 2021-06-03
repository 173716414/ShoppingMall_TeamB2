package com.dao;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.common.DBConn;
import com.entity.BulletinInfo;
import com.entity.PageModel;

public class BulletinDAO {


public void addBulletin(String title,String content,int userId){
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	String createTime = sdf.format(new Date());
	
	String sql = "insert into bulletin values(id,'"+title+"','"+content+"',"+userId+",'"+createTime+"')";
	DBConn.ExecuteUD(sql);//执行SQL语句
	
}

	public void deleteBulletin(int id){
		
		String sql = "delete from Bulletin where id="+id;
		DBConn.ExecuteUD(sql);//执行SQL语句
		
	}
	
	
	
	
	public ArrayList<Object> getBulletin(){
			
			String sql  = "select * from Bulletin order by id desc";
			
			return DBConn.ExecuteQuery(sql, new BulletinInfo());
			
		}
	
public BulletinInfo getBulletinInfo(int id){
	
	String sql  = "select * from Bulletin where id="+id;
	
	
	ArrayList<Object> list = DBConn.ExecuteQuery(sql, new BulletinInfo());
	return  (BulletinInfo)list.get(0);
}
	
public ArrayList<Object> getPageModel(PageModel pm){
		
	//	int everyPageBulletinCount = pm.getEveryPageCount();//每页显示的公告数
		
 String sql  = "select * from  Bulletin order by id desc  limit  "+((pm.getCurrentPage()-1)*pm.getEveryPageCount())+","+(pm.getEveryPageCount()  );
		
		return DBConn.ExecuteQuery(sql, new BulletinInfo());
	}



public int getSumBulletinCount(){
	
	String sql  = "select * from Bulletin";
	
	if(DBConn.ExecuteQuery(sql, new BulletinInfo()) != null){
		return (DBConn.ExecuteQuery(sql, new BulletinInfo())).size();
	}
	return 0;
}


public int getSumSearchBulletinCount(String key){
		
		String sql  = "select * from Bulletin where title like '%"+key+"%'";
		
		if(DBConn.ExecuteQuery(sql, new BulletinInfo()) != null){
			return (DBConn.ExecuteQuery(sql, new BulletinInfo())).size();
		}
		return 0;
	
	}



public ArrayList<Object> searchBulletin(PageModel pm,String key){
	
	int everyPageBulletinCount = pm.getEveryPageCount();//每页显示的公告数
	
	int currentPage = pm.getCurrentPage();//当前页
	
	if(pm.getSumCount()%everyPageBulletinCount != 0 && currentPage == pm.getLastPage()){
		
		everyPageBulletinCount = pm.getSumCount()%everyPageBulletinCount;
		
	}
	
	String sql  = "select * from  Bulletin where title like '%"+key+"%' order by id desc  limit  "+((pm.getCurrentPage()-1)*pm.getEveryPageCount())+","+(pm.getEveryPageCount()  );
	
	return DBConn.ExecuteQuery(sql, new BulletinInfo());
}

public void updateBulletin(int id,String title,String content){
	
	String sql = "update Bulletin set title = '"+title+"',content = '"+content+"' where id="+id;
	DBConn.ExecuteUD(sql);//执行SQL语句
	
}
}
