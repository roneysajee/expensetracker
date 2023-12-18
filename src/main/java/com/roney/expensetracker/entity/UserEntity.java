package com.roney.expensetracker.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "user-details")
public class UserEntity {

	@Id
	@Column(name = "user-id")
	@GeneratedValue(strategy = GenerationType.AUTO )
	private int userId;
	
	@Column(name = "user-email")
	private String userEmail;
	
	@Column(name = "user-password")
	private String userPass;
	
	@Column(name = "firstname")
	private String firstName;
	
	@Column(name = "lastname")
	private String lastname;
	
	@OneToMany(mappedBy = "transUser")
	@JsonIgnore
	private List<TransactionRecordEntity> userTransactions;
	
	
}
