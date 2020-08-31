package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.Entities.City;
import com.example.demo.Repository.ICityRepository;

@Service
public class CityService implements ICityService{
	
	private ICityRepository cityRepository;
    
	@Autowired
	public CityService(ICityRepository cityRepository) {
		this.cityRepository = cityRepository;
	}

	@Override
	@Transactional
	public List<City> getAll() {
		return this.cityRepository.getAll();
	}

	@Override
	@Transactional
	public City add(City city) {
		if (city.getName()==null || city.getName().isEmpty()) {				
			throw new IllegalArgumentException("City name can not be null");
	    }else {
	    this.cityRepository.add(city);
		return city;
	    }
	}

	@Override
	@Transactional
	public City update(City city) {
		if (city.getName()==null || city.getName().isEmpty()) {				
			throw new IllegalArgumentException("City name can not be null");
	    }else {
	    this.cityRepository.update(city);
		return city;
	    }
	}

	@Override
	@Transactional
	public Boolean delete(int id) {
		this.cityRepository.delete(id);
		return true;
	}

	@Override
	@Transactional
	public City getById(int id) {
		return this.cityRepository.getById(id);
	}

	@Override
	@Transactional
	public City getByName(String name) {
		return this.cityRepository.getByName(name);
	}

}
