package com.roney.expensetracker.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table(name = "transaction-record")
@Entity
public class TransactionRecordEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "transaction-id")
	private long transRecord;
	
	@Column(name = "transaction-type")
	private String transType;
	
	@Column(name = "transaction-date")
	private Date transDate;
	
	@ManyToOne()
	@JoinColumn(name = "transaction-user")
	private UserEntity transUser;
	
	@Column(name = "transaction-amount")
	private double transAmount;
	
	
	@ManyToOne
	@JoinColumn(name = "transaction-category")
	private CatagoryEntity transCategory;
	
	
	@ManyToOne()
	@JoinColumn(name = "trancation-account")
	private UserAccountEntity transAccount;
	
	

}
