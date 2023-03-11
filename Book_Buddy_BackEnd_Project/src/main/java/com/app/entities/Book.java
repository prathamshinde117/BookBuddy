package com.app.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;


@Data
@Entity
@Table(name = "Books_tbl")
public class Book extends BaseEntity {

	@Column(name="name",nullable = false)
	private String name;
	@Column(name="author",nullable = false)
	private String author;
//	private String edition;
	@Column(name="description",nullable = false)
	private String description;
	@Column(name="price",nullable = false)
	private Double price;
	@Column(name = "create_time", nullable = false)
	private LocalDate createTime;
	@Override
	public String toString() {
		return "Book [name=" + name + ", author=" + author + ", description=" + description + ", price=" + price
				+ ", createTime=" + createTime + ", getId()=" + getId() + "]";
	}
	
	
	
//	@OneToMany(fetch = FetchType.LAZY, mappedBy = "book")
//	private Set<Purchase> purchaseOrders;
}
