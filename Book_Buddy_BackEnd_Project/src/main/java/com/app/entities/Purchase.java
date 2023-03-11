package com.app.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;


@Data
@Entity
@Table(name = "purchase_tbl")
public class Purchase extends BaseEntity {

	@Column(name = "user_id", nullable = false)
	private Long userId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", referencedColumnName = "id", insertable = false, updatable = false)
	private User user;
	
	@Column(name = "book_id", nullable = false)
	private Long bookId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "book_id", referencedColumnName = "id", insertable = false, updatable = false)
	private Book book;
	
	@Column(name="price", nullable = false)
	private Double price;
	
	@Column(name="purchase_time", nullable = false)
	private LocalDate purchaseTime;
	
}
