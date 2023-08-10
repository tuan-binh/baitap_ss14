package com.example.service;

import com.example.model.Product;
import com.example.utils.ConnectDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductService implements IBaseService<Product, Integer> {
	private Connection con = null;
	
	@Override
	public List<Product> getList() {
		List<Product> list = new ArrayList<>();
		try {
			con = ConnectDB.getConnection();
			CallableStatement callSt = con.prepareCall("{call GET_ALL_PRODUCT}");
			ResultSet rs = callSt.executeQuery();
			while (rs.next()) {
				Product product = new Product();
				product.setId(rs.getInt("id"));
				product.setName(rs.getString("name"));
				product.setDescription(rs.getString("description"));
				product.setPrice(rs.getLong("price"));
				product.setUrlImage(rs.getString("urlImage"));
				list.add(product);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			ConnectDB.closeConnection(con);
		}
		return list;
	}
	
	@Override
	public void save(Product element) {
		con = ConnectDB.getConnection();
		CallableStatement callSt = null;
		if (element.getId() == 0) {
			try {
				callSt = con.prepareCall("{call INSERT_DATA(?,?,?,?)}");
				callSt.setString(1, element.getName());
				callSt.setString(2, element.getDescription());
				callSt.setDouble(3, element.getPrice());
				callSt.setString(4, element.getUrlImage());
				callSt.execute();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			} finally {
				ConnectDB.closeConnection(con);
			}
		} else {
			try {
				callSt = con.prepareCall("{call UPDATE_DATA(?,?,?,?,?)}");
				callSt.setInt(1,element.getId());
				callSt.setString(2, element.getName());
				callSt.setString(3, element.getDescription());
				callSt.setDouble(4, element.getPrice());
				callSt.setString(5, element.getUrlImage());
				callSt.execute();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			} finally {
				ConnectDB.closeConnection(con);
			}
		}
	}
	
	@Override
	public void delete(Integer id) {
		con = ConnectDB.getConnection();
		CallableStatement callSt = null;
		try {
			callSt = con.prepareCall("{call DELETE_BY_ID(?)}");
			callSt.setInt(1, id);
			callSt.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			ConnectDB.closeConnection(con);
		}
	}
	
	@Override
	public Product findById(Integer id) {
		con = ConnectDB.getConnection();
		CallableStatement callSt = null;
		Product product = new Product();
		try {
			callSt = con.prepareCall("{call GET_USER_BY_ID(?)}");
			callSt.setInt(1, id);
			ResultSet rs = callSt.executeQuery();
			while (rs.next()) {
				product.setId(rs.getInt("id"));
				product.setName(rs.getString("name"));
				product.setDescription(rs.getString("description"));
				product.setPrice(rs.getLong("price"));
				product.setUrlImage(rs.getString("urlImage"));
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			ConnectDB.closeConnection(con);
		}
		
		return product;
	}
}
