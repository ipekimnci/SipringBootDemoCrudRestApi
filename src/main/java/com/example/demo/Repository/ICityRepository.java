package com.example.demo.Repository;

import java.util.List;

import com.example.demo.Entities.City;

public interface ICityRepository {
	List<City> getAll();
	void add(City city);
	void update(City city);
	void delete(int id);
	City getById(int id);
	City getByName(String name);

}
