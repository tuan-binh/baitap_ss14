package com.example.model;

public class Product {
	private int id;
	private String name;
	private String description;
	private double price;
	private String urlImage;
	
	public Product() {
	}
	
	public Product(int id, String name, String description, double price, String urlImage) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.urlImage = urlImage;
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
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public String getUrlImage() {
		return urlImage;
	}
	
	public void setUrlImage(String urlImage) {
		this.urlImage = urlImage;
	}
	
	@Override
	public String toString() {
		return "[ "+ name + " ]";
	}
}
