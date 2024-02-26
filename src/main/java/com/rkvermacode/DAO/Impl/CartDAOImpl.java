package com.rkvermacode.DAO.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.rkvermacode.DAO.CartDAO;
import com.rkvermacode.Entity.Cart;

public class CartDAOImpl implements CartDAO {
	
	private Connection conn;
	

	public CartDAOImpl(Connection conn) {
		super();
		this.conn = conn;
	}


	@Override
	public boolean addCart(Cart cart) {
		boolean f = false;
		
		try {
			
			String sql = "insert into cart(pid,uid,productName,description,price,total_price) values(?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, cart.getPid());
			ps.setInt(2, cart.getUserId());
			ps.setString(3, cart.getProductName());
			ps.setString(4, cart.getDescription());
			ps.setDouble(5, cart.getPrice());
			ps.setDouble(6, cart.getTotal_price());
			
			int i = ps.executeUpdate();
			if(i==1) {
				f = true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return f;
	}


	@Override
	public List<Cart> getProductByUser(int userId) {
		List<Cart> list = new ArrayList<Cart>();
		Cart cart = null;
		double totalPrice=0;
		
		try {
			String sql = "select * from cart where uid=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, userId);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				cart = new Cart();
				
				cart.setCid(rs.getInt(1));
				cart.setPid(rs.getInt(2));
				cart.setUserId(rs.getInt(3));
				cart.setProductName(rs.getString(4));
				cart.setDescription(rs.getString(5));
				cart.setPrice(rs.getDouble(6));
				
				totalPrice = totalPrice+rs.getDouble(7);
				cart.setTotal_price(totalPrice);
				
				list.add(cart);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}


	@Override
	public boolean deleteProduct(int pid, int uid, int cid) {
		boolean f = false;
		
		try {
			
			String sql = "delete from cart where pid=? and uid=? and cid=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, pid);
			ps.setInt(2, uid);
			ps.setInt(3, cid);
			
			int i = ps.executeUpdate();
			
			if(i==1) {
				f=true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return f;
	}

}
