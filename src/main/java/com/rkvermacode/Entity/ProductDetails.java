package com.rkvermacode.Entity;

public class ProductDetails {

	private int id;
	private String name;
	private String description;
	private String price;
	private String category;
	private String status;
	private String photo;
	private String email;

	public ProductDetails() {
		super();
	}

	public ProductDetails(String name, String description, String price, String category, String status, String photo,
			String email) {
		super();
		this.name = name;
		this.description = description;
		this.price = price;
		this.category = category;
		this.status = status;
		this.photo = photo;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "ProductDetails [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price
				+ ", category=" + category + ", status=" + status + ", photo=" + photo + ", email=" + email + "]";
	}

}
