package com.gis.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "Country_Tbl")
@Data
public class CountryEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer cid;
	
	private String cname;
	private String ccode;

}
