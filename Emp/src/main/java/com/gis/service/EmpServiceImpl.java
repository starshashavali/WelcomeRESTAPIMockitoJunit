package com.gis.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gis.entity.EmpEntity;
import com.gis.repo.EmpRepo;

@Service
public  class EmpServiceImpl implements EmpService {
	@Autowired
	private EmpRepo empRepo;

	@Override
	public boolean saveEmp(EmpEntity empDto) {
		EmpEntity entity = new EmpEntity();
		EmpEntity saveEmpObj = empRepo.save(entity);
		if (saveEmpObj != null) {
			return true;
		}
		return false;
	}

	@Override
	public boolean updateEmp(EmpEntity empDto) {
	    Optional<EmpEntity> optionalEntity = empRepo.findById(empDto.getEmpId());

	    if (optionalEntity.isPresent()) {
	        EmpEntity existingEntity = optionalEntity.get();
	        existingEntity.setEmpId(empDto.getEmpId());
	        existingEntity.setEmpName(empDto.getEmpName());
	        existingEntity.setEmpSal(empDto.getEmpSal());
	        empRepo.save(existingEntity); // Save the updated entity
	        return true;
	    } else {
	        return false; // Employee with empId not found
	    }
	}


	



	@Override
	public EmpEntity getById(Integer cid) {
			
			Optional<EmpEntity> findById = empRepo.findById(cid);

			if (findById.isPresent()) {
				return findById.get();
			}
			return null;
		}

		
	
	
	

	@Override
	public List<EmpEntity> getAllEmps() {
		
		return empRepo.findAll();
	}

}
				

	


