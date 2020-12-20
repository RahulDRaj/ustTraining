package com.ust.cart.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="products")
public class Product {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	 @Column(name="title")
	private String title;
	 @Column(name="price")
	private Float price;
	 @Column(name="category")
	private String category;
	 @Column(name="description")
	private String description;
	 @Column(name="image")
	private String image;
	 
	 @Override
		public String toString() {
			return "Product [id=" + id + ", title=" + title + ", price=" + price + ", category=" + category
					+ ", description=" + description + ", images=" + image + "]";
		}
	 
	 
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	

}
