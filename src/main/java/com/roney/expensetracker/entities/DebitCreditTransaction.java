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
@Table(name = "DEBIT_CREDIT_TRANSACTION")
public class DebitCreditTransaction {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO,generator = "dbcrSeqGenerator")
	@Column(name = "TRANSACTION_ID")
	@SequenceGenerator(name = "dbcrSeqGenerator", sequenceName = "DBCR_SEQ", allocationSize = 1)
	private int transactionId;

	@Column(name = "AMOUNT")
	private float amount;

	@Column(name = "TYPE")
	private int type;

	@Column(name = "DATE_COL")
	private Date date;

	@Column(name = "ACCOUNT")
	private int account;

	@Column(name = "DEBIT_CREDIT_ACC")
	private int debitCreditAcc;

	@Column(name = "USER_ID")
	private int userId;
}
