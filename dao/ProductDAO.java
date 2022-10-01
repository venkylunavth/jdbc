package com.ecom.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ecom.model.Product;
import com.ecom.model.User;

public class ProductDAO {

	private Connection con;

	public ProductDAO() {
		con = DBConnection.getConnection();
	}

	public boolean addProduct(Product p) {
		try {
			String query = "insert into product (name,price) values (?,?)";

			PreparedStatement ps;
			ps = con.prepareStatement(query);

			ps.setString(1, p.getName());
			ps.setFloat(2, p.getPrice());

			int n = ps.executeUpdate();
			if (n == 0)
				return false;
			else
				return true;

		} catch (SQLException e) {
			System.out.println(e);
			return false;
		}
	}

	public boolean deleteProduct(int id) {
		try {
			String query = "delete from product where id = ?";

			PreparedStatement ps;
			ps = con.prepareStatement(query);

			ps.setInt(1, id);

			int n = ps.executeUpdate();
			if (n == 0)
				return false;
			else
				return true;

		} catch (SQLException e) {
			System.out.println(e);
			return false;
		}
	}

	public boolean updateProduct(Product p) {
		try {
			String query = "update product set name=?,price=? where id=?";

			PreparedStatement ps;
			ps = con.prepareStatement(query);

			ps.setString(1, p.getName());
			ps.setFloat(2, p.getPrice());
			ps.setInt(3, p.getId());

			int n = ps.executeUpdate();
			if (n == 0)
				return false;
			else
				return true;

		} catch (SQLException e) {
			System.out.println(e);
			return false;
		}
	}

	public Product searchProduct(int id) {
		try {
			String query = "select * from product where id = ?";
			PreparedStatement ps;
			ps = con.prepareStatement(query);
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()==true)
			{
				int id1 = rs.getInt(1);
				String name = rs.getString(2);
				float price = rs.getFloat(3);
				
				Product p = new Product(name,price);
				p.setId(id1);
				return p;
			}
			else
			{
				return null;
			}

		} catch (SQLException e) {
			System.out.println(e);
			return null;
		}
	}
	public ArrayList<Product> getAllProducts() {
		try {
			String query = "select * from product";
		
			PreparedStatement ps;
			ps = con.prepareStatement(query);
		
			ResultSet rs = ps.executeQuery();
			ArrayList<Product> lst = new ArrayList<>();
			while(rs.next()==true)
			{
				int id1 = rs.getInt(1);
				String name = rs.getString(2);
				float price = rs.getFloat(3);
				
				Product p = new Product(name,price);
				p.setId(id1);
				lst.add(p);
			}
			return lst;
		} catch (SQLException e) {
			System.out.println(e);
			return null;
		}
	}
}
