package com.gis.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "BooK_Tbl_Dts")
@AllArgsConstructor
@NoArgsConstructor
public class BookEntity {
	private Integer bookId;
	private String bookName;
	private Double bookPrice;

}
