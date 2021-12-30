package Attributes;

import java.lang.*;
import java.sql.*;
import oracle.jdbc.driver.*;
import oracle.sql.*;
import javax.swing.*;
import javax.swing.table.*;
import Attributes.*;
import Features.*;

public class Supplier extends User {
	private String supplierName;
	private String supplierLocation;
	private String productId;
	public static String[] columnNames = {"SupplierID", "SupplierName", "SupplierLocation", "ProductID"};
	public Supplier(String userId) {
		super(userId);
		this.setStatus(1);
	}
	
	public void setSupplierName(String name) {
		if (!name.isEmpty())
			this.supplierName = name;
		else
			throw new IllegalArgumentException("Fill in the name");
	}
	public void setSupplierLocation(String location) {
		if (!location.isEmpty())
			this.supplierLocation = location;
		else
			throw new IllegalArgumentException("Fill in the location");
	}
	public void setProductID(String id) {
		if (!id.isEmpty())
			this.productId = id;
		else
			throw new IllegalArgumentException("Fill in the product IDs (separate by commas if multiple)");
	}
	public String getSupplierLocation() {
		return supplierLocation;
	}
	public String getSupplierName() {
		return supplierName;
	}
	public String getProductIDs() {
		return productId;
	}
	
	public void createSupplier() {
		String query2 = "INSERT INTO supplier VALUES ('"+userId+"','"+supplierName+"','"+supplierLocation+"','"+productId+"')";
		OracleConnection con = null;
        Statement st = null;
		System.out.println(query2);
        try {
        	DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			System.out.println("driver loaded");
			con = (OracleConnection)DriverManager.getConnection("jdbc:oracle:thin:@studora.comp.polyu.edu.hk:1521:dbms","20041744D","gmjcegvh");
			System.out.println("connection done");//connection with database established
			st = con.createStatement();//create statement
			System.out.println("statement created");
			st.execute(query2);
			System.out.println("data inserted");
			JOptionPane.showMessageDialog(null,"Account Created!");
		}
        catch(Exception ex) {
			JOptionPane.showMessageDialog(null,"Failed to create account!");
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
	
	public void fetch() {
		String query = "SELECT supplierId, supplierName, supplierLocation, productId FROM supplier WHERE supplierId='"+this.userId+"'";     
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
			boolean flag = false;
			while(rs.next()) {
				this.supplierName = rs.getString("supplierName");
				this.supplierLocation = rs.getString("supplierLocation");
				this.productId = rs.getString("productId");
			}
		}
        catch(Exception ex) {
			System.out.println("Exception : " +ex.getMessage());
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
	}
	
	public void updateSupplier(String name, String location, String productid) {
		String query = "UPDATE supplier SET supplierName='"+name+"', supplierLocation='"+location+"', productId='"+productid+"' WHERE supplierId='"+this.userId+"'";
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
			st.executeUpdate(query);//insert
			System.out.println("data inserted");
			JOptionPane.showMessageDialog(null,"Information Updated!");
			this.supplierName = name;
			this.supplierLocation = location;
			this.productId = productid;
		}
        catch(Exception ex) {
			JOptionPane.showMessageDialog(null,"Failed to update account!");
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
	
	public void deleteSupplier() {
		String query2 = "DELETE FROM supplier WHERE supplierId ='"+this.userId+"'";
		OracleConnection con = null;
        Statement st = null;
		System.out.println(query2);
        try {
        	DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			System.out.println("driver loaded");
			con = (OracleConnection)DriverManager.getConnection("jdbc:oracle:thin:@studora.comp.polyu.edu.hk:1521:dbms","20041744D","gmjcegvh");
			System.out.println("connection done");//connection with database established
			st = con.createStatement();//create statement
			System.out.println("statement created");
			st.execute(query2);//delete
			System.out.println("data deleted");
			JOptionPane.showMessageDialog(null,"Account Deleted!");
			this.userId = "";
			this.supplierName = "";
			this.supplierLocation = "";
			this.productId = "";
		}
        catch(Exception ex) {
			JOptionPane.showMessageDialog(null,"Failed to delete account!");
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
	
	public static DefaultTableModel searchSupplier(String keyword, String byWhat) {
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(columnNames);
		String query = "SELECT * FROM supplier WHERE supplierId='"+keyword+"'";
		if (byWhat.equals("By Name"))
			query = "SELECT * FROM supplier WHERE supplierName LIKE '%"+keyword+"%'";
		else {}
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
				model.addRow(new Object[]{rs.getString("supplierId"), rs.getString("supplierName"), rs.getString("supplierLocation"), rs.getString("productId")});
			}
		}
        catch(Exception ex) {
			System.out.println("Exception : " +ex.getMessage());
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
		return model;
	}
}