package com.app.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Data;

@Data
@Entity
@Table(name = "users_tbl")
public class User extends BaseEntity {

	@Column(name = "username", unique = true, nullable = false, length = 100)
	private String username;

	@Column(name = "password", nullable = false)
	private String password;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "create_time", nullable = false)
	private LocalDate createTime;
	
	@Enumerated(EnumType.STRING)
	@Column(name="role",nullable=false)
	private Role role;
	

    @Transient
    private String token;


	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", name=" + name + ", createTime=" + createTime
				+ ", role=" + role + ", token=" + token + ", getId()=" + getId() + "]";
	}
    
    
}
