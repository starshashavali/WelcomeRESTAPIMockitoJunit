package com.gis.service;

import com.gis.binding.CountryBinding;
import com.gis.entity.CountryEntity;

public interface CountryService {

	public String upsert(CountryBinding binding);

	public String deleteCountry(Integer cid);

	public CountryEntity getCountry(Integer cid);

}
