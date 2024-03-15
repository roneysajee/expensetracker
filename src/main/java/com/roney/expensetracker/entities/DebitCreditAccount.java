package com.roney.expensetracker.entities;

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
@Table(name = "DEBIT_CREDIT_ACCOUNT")
public class DebitCreditAccount {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO,generator = "dbcrAccSeqGenerator")
	@Column(name = "ACC_ID")
	@SequenceGenerator(name = "dbcrAccSeqGenerator", sequenceName = "DBCR_ACC_SEQ", allocationSize = 1)
	private int accId;
	
	@Column(name = "USER_ID")
	private int userId;
	
	@Column(name = "BALANCE")
	private float balance;
}
