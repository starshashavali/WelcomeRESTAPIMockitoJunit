package com.gis.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gis.binding.CountryBinding;
import com.gis.entity.CountryEntity;
import com.gis.service.CountryService;

@RestController
public class CountryController {
	@Autowired
	private CountryService countryService;

	@PostMapping("/saveRecord")
	public String saveRecord(@RequestBody CountryBinding binding) {
		
		 return countryService.upsert(binding);
	}
		

	@GetMapping("country/{id}")
	public CountryEntity getRecord(@PathVariable Integer id) {
		 CountryEntity country = countryService.getCountry(id);
		return country;
	}

	@DeleteMapping("country/{id}")
	public String deleteById(@PathVariable Integer id) {
		 return countryService.deleteCountry(id);
		

	}

}
