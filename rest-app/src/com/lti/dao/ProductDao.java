package com.lti.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.lti.model.Product;

//classes which contain database interaction code
//are commonly referred to as Dao (Data Access Object)
//TODO: create table tbl_product(id number, name varchar2(20),
//								 price number(7,2), quantity number(4));
public class ProductDao {

	public void insert(Product product) {
		//write jdbc code here for inserting product data in the underlying table
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "hr", "hr");
			String sql = "INSERT INTO tbl_product VALUES(?, ?, ?, ?)";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, product.getId());
			stmt.setString(2, product.getName());
			stmt.setDouble(3, product.getPrice());
			stmt.setInt(4, product.getQuantity());
			stmt.executeUpdate();
		}
		catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace(); //rather we should throw some user defined exception
		}
		finally {
			try { conn.close(); } catch(Exception e) { }
		}
	}
}
