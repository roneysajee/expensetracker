package com.roney.expensetracker.entity;



import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity(name = "account-list")
public class UserAccountEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "account-id")
	private int accountId;
	
	@Column(name = "account-name")
	private String accountName;
	
	@Column(name = "account-balance")
	private double accountBalance;
	
	@OneToMany(mappedBy = "transAccount")
	@JsonIgnore
	private List<TransactionRecordEntity> accountTransactions;
	
	

	

}
