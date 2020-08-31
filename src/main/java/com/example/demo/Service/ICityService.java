package com.example.demo.Service;

import java.util.List;

import com.example.demo.Entities.City;


public interface ICityService {
	List<City> getAll();
	City add(City city);
	City update(City city);
	Boolean delete(int id);
	City getById(int id);
	City getByName(String name);

}
