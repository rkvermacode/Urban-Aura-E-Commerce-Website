package com.rkvermacode.DAO.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.rkvermacode.DAO.ProductDAO;
import com.rkvermacode.Entity.ProductDetails;

public class ProductDAOImpl implements ProductDAO {

	private Connection conn;

	public ProductDAOImpl(Connection conn) {
		super();
		this.conn = conn;
	}

	@Override
	public boolean addProduct(ProductDetails productDetails) {

		boolean f = false;

		try {

			String sql = "insert into products_details(name,description,price,category,status,photo, email) values(?,?,?,?,?,?,?)";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, productDetails.getName());
			ps.setString(2, productDetails.getDescription());
			ps.setString(3, productDetails.getPrice());
			ps.setString(4, productDetails.getCategory());
			ps.setString(5, productDetails.getStatus());
			ps.setString(6, productDetails.getPhoto());
			ps.setString(7, productDetails.getEmail());

			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	@Override
	public List<ProductDetails> getAllProducts() {

		List<ProductDetails> list = new ArrayList<ProductDetails>();
		ProductDetails products = null;

		try {

			String sql = "select * from products_details";
			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				products = new ProductDetails();

				products.setId(rs.getInt(1));
				products.setName(rs.getString(2));
				products.setDescription(rs.getString(3));
				products.setPrice(rs.getString(4));
				products.setCategory(rs.getString(5));
				products.setStatus(rs.getString(6));
				products.setPhoto(rs.getString(7));
				products.setEmail(rs.getString(8));

				list.add(products);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public ProductDetails getProductById(int id) {

		ProductDetails products = null;

		try {

			String sql = "Select * from products_details where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				products = new ProductDetails();

				products.setId(rs.getInt(1));
				products.setName(rs.getString(2));
				products.setDescription(rs.getString(3));
				products.setPrice(rs.getString(4));
				products.setCategory(rs.getString(5));
				products.setStatus(rs.getString(6));
				products.setPhoto(rs.getString(7));
				products.setEmail(rs.getString(8));

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return products;
	}

	@Override
	public boolean editProduct(ProductDetails product) {
		boolean f = false;

		try {

			String sql = "update products_details set name=?, description=?, price=?, category=?, status=? where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, product.getName());
			ps.setString(2, product.getDescription());
			ps.setString(3, product.getPrice());
			ps.setString(4, product.getCategory());
			ps.setString(5, product.getStatus());
			ps.setInt(6, product.getId());

			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;
	}

	@Override
	public boolean deleteProduct(int id) {
		boolean f = false;

		try {

			String sql = "delete from products_details where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);

			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;
	}

	@Override
	public List<ProductDetails> getWomenProducts() {

		List<ProductDetails> list = new ArrayList<ProductDetails>();
		ProductDetails products = null;

		try {

			String sql = "select * from products_details where category=? and status=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "women");
			ps.setString(2, "Active");

			ResultSet rs = ps.executeQuery();
			int i = 1;
			while (rs.next() && i <= 4) {
				products = new ProductDetails();

				products.setId(rs.getInt(1));
				products.setName(rs.getString(2));
				products.setDescription(rs.getString(3));
				products.setPrice(rs.getString(4));
				products.setCategory(rs.getString(5));
				products.setStatus(rs.getString(6));
				products.setPhoto(rs.getString(7));
				products.setEmail(rs.getString(8));

				list.add(products);
				i++;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public List<ProductDetails> getRecentProducts() {
		List<ProductDetails> list = new ArrayList<ProductDetails>();
		ProductDetails products = null;

		try {

			String sql = "select * from products_details where status=? order by id desc";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "Active");
			

			ResultSet rs = ps.executeQuery();
			int i = 1;
			while (rs.next() && i <= 4) {
				products = new ProductDetails();

				products.setId(rs.getInt(1));
				products.setName(rs.getString(2));
				products.setDescription(rs.getString(3));
				products.setPrice(rs.getString(4));
				products.setCategory(rs.getString(5));
				products.setStatus(rs.getString(6));
				products.setPhoto(rs.getString(7));
				products.setEmail(rs.getString(8));

				list.add(products);
				i++;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public List<ProductDetails> getMenProducts() {
		List<ProductDetails> list = new ArrayList<ProductDetails>();
		ProductDetails products = null;

		try {

			String sql = "select * from products_details where category=? and status=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "men");
			ps.setString(2, "Active");

			ResultSet rs = ps.executeQuery();
			int i = 1;
			while (rs.next() && i <= 4) {
				products = new ProductDetails();

				products.setId(rs.getInt(1));
				products.setName(rs.getString(2));
				products.setDescription(rs.getString(3));
				products.setPrice(rs.getString(4));
				products.setCategory(rs.getString(5));
				products.setStatus(rs.getString(6));
				products.setPhoto(rs.getString(7));
				products.setEmail(rs.getString(8));

				list.add(products);
				i++;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public List<ProductDetails> getChildrenProduct() {
		List<ProductDetails> list = new ArrayList<ProductDetails>();
		ProductDetails products = null;

		try {

			String sql = "select * from products_details where category=? and status=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "children");
			ps.setString(2, "Active");

			ResultSet rs = ps.executeQuery();
			int i = 1;
			while (rs.next() && i <= 4) {
				products = new ProductDetails();

				products.setId(rs.getInt(1));
				products.setName(rs.getString(2));
				products.setDescription(rs.getString(3));
				products.setPrice(rs.getString(4));
				products.setCategory(rs.getString(5));
				products.setStatus(rs.getString(6));
				products.setPhoto(rs.getString(7));
				products.setEmail(rs.getString(8));

				list.add(products);
				i++;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public List<ProductDetails> getAllRecentProduct() {
		List<ProductDetails> list = new ArrayList<ProductDetails>();
		ProductDetails products = null;

		try {

			String sql = "select * from products_details where status=? order by id desc";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "Active");
			

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				products = new ProductDetails();

				products.setId(rs.getInt(1));
				products.setName(rs.getString(2));
				products.setDescription(rs.getString(3));
				products.setPrice(rs.getString(4));
				products.setCategory(rs.getString(5));
				products.setStatus(rs.getString(6));
				products.setPhoto(rs.getString(7));
				products.setEmail(rs.getString(8));

				list.add(products);
			
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public List<ProductDetails> getAllMenProduct() {
		List<ProductDetails> list = new ArrayList<ProductDetails>();
		ProductDetails products = null;

		try {

			String sql = "select * from products_details where category=? and status=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "men");
			ps.setString(2, "Active");

			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				products = new ProductDetails();

				products.setId(rs.getInt(1));
				products.setName(rs.getString(2));
				products.setDescription(rs.getString(3));
				products.setPrice(rs.getString(4));
				products.setCategory(rs.getString(5));
				products.setStatus(rs.getString(6));
				products.setPhoto(rs.getString(7));
				products.setEmail(rs.getString(8));

				list.add(products);
				
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public List<ProductDetails> getAllWomenProduct() {
		List<ProductDetails> list = new ArrayList<ProductDetails>();
		ProductDetails products = null;

		try {

			String sql = "select * from products_details where category=? and status=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "women");
			ps.setString(2, "Active");

			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				products = new ProductDetails();

				products.setId(rs.getInt(1));
				products.setName(rs.getString(2));
				products.setDescription(rs.getString(3));
				products.setPrice(rs.getString(4));
				products.setCategory(rs.getString(5));
				products.setStatus(rs.getString(6));
				products.setPhoto(rs.getString(7));
				products.setEmail(rs.getString(8));

				list.add(products);
			
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public List<ProductDetails> getAllChildrenProduct() {
		List<ProductDetails> list = new ArrayList<ProductDetails>();
		ProductDetails products = null;

		try {

			String sql = "select * from products_details where category=? and status=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "children");
			ps.setString(2, "Active");

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				products = new ProductDetails();

				products.setId(rs.getInt(1));
				products.setName(rs.getString(2));
				products.setDescription(rs.getString(3));
				products.setPrice(rs.getString(4));
				products.setCategory(rs.getString(5));
				products.setStatus(rs.getString(6));
				products.setPhoto(rs.getString(7));
				products.setEmail(rs.getString(8));

				list.add(products);
				
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public List<ProductDetails> searchProducts(String characters) {
		List<ProductDetails> list = new ArrayList<ProductDetails>();
		ProductDetails products = null;

		try {

			String sql = "select * from products_details where (name like ? or description like ? or category like ?) and status = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "%"+characters+"%");
			ps.setString(2, "%"+characters+"%");
			ps.setString(3, "%"+characters+"%");
			ps.setString(4, "Active");

			ResultSet rs = ps.executeQuery();
			int i = 1;
			while (rs.next() && i <= 4) {
				products = new ProductDetails();

				products.setId(rs.getInt(1));
				products.setName(rs.getString(2));
				products.setDescription(rs.getString(3));
				products.setPrice(rs.getString(4));
				products.setCategory(rs.getString(5));
				products.setStatus(rs.getString(6));
				products.setPhoto(rs.getString(7));
				products.setEmail(rs.getString(8));

				list.add(products);
				i++;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

}
