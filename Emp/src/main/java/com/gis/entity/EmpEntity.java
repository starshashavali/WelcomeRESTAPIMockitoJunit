package com.gis.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="EmpEntity_Dtls")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class EmpEntity {
	
@Id
@GeneratedValue
private Integer empId;
private  String empName;
private Double  empSal;

}
