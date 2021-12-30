package Attributes;

import java.lang.*;
import java.sql.*;
import oracle.jdbc.driver.*;
import oracle.sql.*;
import Attributes.*;
import javax.swing.*;
import Features.*;

public abstract class User {
	protected String userId;
	protected String password;
	protected int status;
	
	public User(String userId) {
		if (!userId.isEmpty())
			this.userId = userId;
		else
			throw new IllegalArgumentException("Fill in the User ID");
	}
	
	public abstract void fetch();
	
	public String getUserId() {
		return userId;
	}
	public void setStatus(int stts) {
		this.status = stts;
	}
	public void setPassword(String passwd) {
		if (!passwd.isEmpty())
			this.password = passwd;
		else
			throw new IllegalArgumentException("Fill in the password");
	}
	
	public static int checkStatus(String uid, String pass) {
		int result = -1;
		String query = "SELECT userId, password, status FROM login";     
		OracleConnection con = null;
        Statement st = null;
		ResultSet rs = null;
		System.out.println(query);
        try {
        	DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			System.out.println("driver loaded");
			con = (OracleConnection)DriverManager.getConnection("jdbc:oracle:thin:@studora.comp.polyu.edu.hk:1521:dbms","20041744D","gmjcegvh");
			System.out.println("connection done");//connection with database established
			st = con.createStatement();//create statement
			System.out.println("statement created");
			rs = st.executeQuery(query);//getting result
			System.out.println("results received");
			
			while(rs.next()) {
                String userId = rs.getString("userId");
                String password = rs.getString("password");
				int status = rs.getInt("status");
				
				if(userId.equals(uid) && password.equals(pass)) {
					result = status;
				}
			}
		}
        catch(Exception ex) {
			System.out.println("Exception : " +ex.getMessage());
			ex.printStackTrace();
        }
        finally {
	        try {
	            if(rs!=null)
					rs.close();
	
	            if(st!=null)
					st.close();
	
	            if(con!=null)
					con.close();
	        }
	        catch(Exception ex) {}
        }
		return result;
	}
	
	public void changePassword(ChangePasswordActivity a, String oldPass, String newPass) {
		String query = "UPDATE login SET password='"+newPass+"' WHERE (userId='"+this.userId+"' AND password='"+oldPass+"')";
		OracleConnection con = null;
        Statement st = null;
		System.out.println(query);
        try {
        	DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			System.out.println("driver loaded");
			con = (OracleConnection)DriverManager.getConnection("jdbc:oracle:thin:@studora.comp.polyu.edu.hk:1521:dbms","20041744D","gmjcegvh");
			System.out.println("connection done");//connection with database established
			st = con.createStatement();//create statement
			System.out.println("statement created");
			int res = st.executeUpdate(query);//insert
			System.out.println("data inserted");
			if (res > 0) {
				JOptionPane.showMessageDialog(null,"Password Updated!");
			a.setVisible(false);
			}
			else {
				JOptionPane.showMessageDialog(null,"Password didn't match!");
			}
		}
        catch(Exception ex) {
			System.out.println("Exception : " +ex.getMessage());
        }
        finally {
            try {
                if(st!=null)
					st.close();

                if(con!=null)
					con.close();
            }
            catch(Exception ex) {}
        }
	}
}