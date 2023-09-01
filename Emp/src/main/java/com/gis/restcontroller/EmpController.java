package com.gis.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gis.entity.EmpEntity;
import com.gis.service.EmpService;

@RestController
public class EmpController {
	@Autowired
	private EmpService empService;
	
	@PostMapping("/saveEmp")
	public ResponseEntity<String> saveEmp(@RequestBody EmpEntity empEntity){
		boolean status = empService.saveEmp(empEntity);
		if(status) {
			return new ResponseEntity<String>("Record inserted successfully", HttpStatus.CREATED);
		}else {
			return new ResponseEntity<String>("Record not inserted", HttpStatus.BAD_REQUEST);
		}
		
		
	}
	@PutMapping("/updateEmp")
	public ResponseEntity<String> updateEmpDts(@RequestBody EmpEntity empDto){
		boolean status = empService.updateEmp(empDto);
		if(status) {
			return new ResponseEntity<String>("Record updated successfully", HttpStatus.OK);
		}else {
			return new ResponseEntity<String>("Record not updated", HttpStatus.BAD_REQUEST);
		}
		
		
	}


	@GetMapping("/emp/{cid}")
	public ResponseEntity<EmpEntity> getCourse(@PathVariable Integer cid) {
		EmpEntity emp = empService.getById(cid);
		return new ResponseEntity<>(emp, HttpStatus.OK);
	}

	@GetMapping("/emp")
	public ResponseEntity<List<EmpEntity>> getAllCourses() {
		List<EmpEntity> allCourses = empService.getAllEmps();
		return new ResponseEntity<>(allCourses, HttpStatus.OK);
	}



	

}