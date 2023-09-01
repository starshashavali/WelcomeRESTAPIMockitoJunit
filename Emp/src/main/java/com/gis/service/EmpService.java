package com.gis.service;

import java.util.List;

import com.gis.entity.EmpEntity;

public interface EmpService {

	public boolean saveEmp(EmpEntity empDto);
	
	public boolean  updateEmp(EmpEntity empDto);

	public EmpEntity getById(Integer cid);

	public List<EmpEntity> getAllEmps();
	


}
