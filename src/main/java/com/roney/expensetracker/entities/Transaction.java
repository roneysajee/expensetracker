package com.roney.expensetracker.entities;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "APP_TRANSACTION")
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO,generator = "transSeqGenerator")
	@Column(name = "TRANSACTION_ID")
	@SequenceGenerator(name = "transSeqGenerator", sequenceName = "TRANSACTION_SEQ", allocationSize = 1)
	private int transactionId;
	
	@Column(name = "AMOUNT")
	private float amount;
	
	@Column(name = "TYPE")
	private int type;
	
	@Column(name = "DATE_COL")
	private Date date;
	
	@Column(name = "ACCOUNT")
	private int account;
	
	@Column(name = "CATEGORY")
	private int category;
	
	@Column(name = "USER_ID")
	private int userId;
}
