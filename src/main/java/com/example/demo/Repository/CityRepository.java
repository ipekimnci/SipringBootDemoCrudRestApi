package com.example.demo.Repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.Entities.City;

@Repository
public class CityRepository implements ICityRepository{
	
	private EntityManager entityManager;
    
	@Autowired
	public CityRepository(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	@Transactional
	public List<City> getAll() {
		Session session=entityManager.unwrap(Session.class);
		List<City> cities=session.createQuery("from City",City.class).getResultList();
		return cities;
	}

	@Override
	public void add(City city) {
		Session session=entityManager.unwrap(Session.class);
		session.saveOrUpdate(city);
		
	}

	@Override
	public void update(City city) {
		Session session=entityManager.unwrap(Session.class);
		session.saveOrUpdate(city);
		
	}

	@Override
	public void delete(int id) {
		Session session=entityManager.unwrap(Session.class);
		City citytoDelete= session.get(City.class, id);
		session.delete(citytoDelete);
		
	}

	@Override
	public City getById(int id) {
		Session session=entityManager.unwrap(Session.class);
		City city= session.get(City.class, id);
		return city;
	}

	@Override
	public City getByName(String name) {
	    Session session=entityManager.unwrap(Session.class);
		City city= session.get(City.class, name);
		return city;
	}

}
