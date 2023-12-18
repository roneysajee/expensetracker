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
@Table(name = "catagory-list")
public class CatagoryEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO )
	@Column(name = "catagory-id" )
	private int catId;
	
	@Column(name = "catagory-name")
	private String catName;
	
	@OneToMany(mappedBy = "transCategory")
	@JsonIgnore
	private List<TransactionRecordEntity> catagoryTransactions;

}
