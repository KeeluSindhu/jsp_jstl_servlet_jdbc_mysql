package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import models.zomato;
public class zomatoservice {
	private Connection conn;
	public zomatoservice(Connection conn) {
		super();
		this.conn = conn;
	}
	public boolean adding(zomato zo) {
	
		boolean f=false;
		try {
			String sql="insert into zomatoregistration(name,email,password,confirmpassword)values(?,?,?,?)";
			PreparedStatement pmst=conn.prepareStatement(sql);
			pmst.setString(1, zo.getName());
			pmst.setString(2, zo.getEmail());
			pmst.setString(3, zo.getPassword());
			pmst.setString(4, zo.getConfirmpassword());
			
			int i=pmst.executeUpdate();
			if( i > 0) {
			 f=true;
			 
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}
	
     public List<zomato> getall(){
    	 List<zomato> ll=new ArrayList<zomato>();
    	 zomato z = null;
    	 try {
			 String sql="select * from  zomatoregistration";
			 PreparedStatement pmst= conn.prepareStatement(sql);
			ResultSet RS =pmst.executeQuery();
			while (RS.next()) {
				z = new zomato();
				z.setId(RS.getInt(1));
				z.setName(RS.getString(2));
				z.setEmail(RS.getString(3));
				z.setPassword(RS.getString(4));
				z.setConfirmpassword(RS.getString(5));
				ll.add(z);
				
			}
    		 
		} catch (Exception e) {
			e.printStackTrace();
		}
    	 return ll;
     }
     public zomato getById(int id) {
    	 zomato z = null;
    	 try {
			String sql="select * from zomatoregistration where id =?";
			PreparedStatement pmst=conn.prepareStatement(sql);
			pmst.setInt(1, id);
			ResultSet RS=pmst.executeQuery();
			while (RS.next()) {
				z = new zomato();
				z.setId(RS.getInt(1));
				z.setName(RS.getString(2));
				z.setEmail(RS.getString(3));
				z.setPassword(RS.getString(4));
				z.setConfirmpassword(RS.getString(5));
				
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
    	 return z;
    	 
     }
     public boolean deleteById(int id) {
    	 boolean f=false;
    	 try {
			String sql="delete from zomatoregistration where id=?";
			PreparedStatement pmst=conn.prepareStatement(sql);
			pmst.setInt(1, id);
			int i=pmst.executeUpdate();
			if (i>0) {
				f=true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
    	 return f;
     }

     public boolean updatezomato(zomato zo) {
    	 boolean f=false;
    	 try {
			String sql="update zomatoregistration set name=?,email=?,password=?,confirmpassword=? where id=?";
			PreparedStatement pmst=conn.prepareStatement(sql);
			pmst.setString(1, zo.getName());
			pmst.setString(2, zo.getEmail());
			pmst.setString(3, zo.getPassword());
			pmst.setString(4, zo.getConfirmpassword());
			pmst.setInt(5, zo.getId());
			pmst.executeUpdate();
			int i=pmst.executeUpdate();
			if (i>0) {
				f=true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
    	 return f;
    	 
     }
}
