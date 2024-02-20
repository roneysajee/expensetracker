package com.roney.expensetracker.entities;




import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "APP_USER")
public class User {

	@Id
	@Column(name = "USER_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;
	
	@Column(name = "USERNAME")
	private String username;
	
	@Column(name = "FULLNAME")
	private String fullName;
	
	@Column(name = "Email")
	private String email;
	
	@Column(name = "PASSWORD")
	private String password;
	
	@Column(name = "IMG")
	private String image;
}
