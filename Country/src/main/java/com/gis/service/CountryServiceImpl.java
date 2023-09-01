package com.gis.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gis.binding.CountryBinding;
import com.gis.entity.CountryEntity;
import com.gis.repo.CountryRepo;

@Service
public class CountryServiceImpl implements CountryService {
	
	
	@Autowired
	private CountryRepo countryRepo;

	@Override
	public String upsert(CountryBinding binding) {
		
		
		if(binding.getCid()!=null) {
			
			CountryEntity entity=new CountryEntity();
			BeanUtils.copyProperties(binding, entity);
			
			countryRepo.save(entity);
			
			return "Country saved ...";
			
			
			
		}
		
		CountryEntity entity=new CountryEntity();
		
		BeanUtils.copyProperties(binding, entity);
		
		countryRepo.save(entity);
		
		return "Details updated Successfully.. .";
		

		
	}

	@Override
	public String deleteCountry(Integer cid) {
		
		countryRepo.deleteById(cid);
		
		return "Country Deleted";
		
	}

	@Override
	public CountryEntity getCountry(Integer cid) {
		Optional<CountryEntity> findById = countryRepo.findById(cid);
		if(findById.isPresent()) {
			CountryEntity countryEntity = findById.get();
			return countryEntity;
		}
		return null;
	
		
	}

}
