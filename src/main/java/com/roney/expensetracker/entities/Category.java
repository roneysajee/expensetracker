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
@Table(name = "APP_CATEGORY")
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO,generator = "catSeqGenerator")
	@Column(name = "CATEGORY_ID")
	@SequenceGenerator(name = "catSeqGenerator", sequenceName = "CATEGORY_SEQ", allocationSize = 1)
	private int categoryId;
	
	@Column(name = "NAME")
	private String name;
	
//	@Column(name = "IMG")
//	private String img;
	
	@Column(name = "USER_ID")
	private int userId;
}
