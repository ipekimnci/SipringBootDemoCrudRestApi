package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entities.City;
import com.example.demo.Service.ICityService;

@RestController
@RequestMapping("/city")
public class CityController {
	
	private ICityService cityService;
	
	@Autowired
	public CityController(ICityService cityService) {
		this.cityService = cityService;
	}
	
	@GetMapping("/get")
	public ResponseEntity<List<City>> get(){
		List<City> cities= cityService.getAll();
		return new ResponseEntity<List<City>>(cities, HttpStatus.OK);
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<City> getById(@PathVariable("id") int id) {
		City city= cityService.getById(id);
		 return new ResponseEntity<City>(city, HttpStatus.OK);
	}
	
	@PostMapping("/create")
	public ResponseEntity<City> createCity(@RequestBody City city){
		return ResponseEntity.ok(cityService.add(city));
	}
	
	@PutMapping("/update")
	public ResponseEntity<City> updateCity(@RequestBody City city){
		return ResponseEntity.ok(cityService.update(city));	
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Boolean> deleteCity(@PathVariable("id") int id){
		return ResponseEntity.ok(cityService.delete(id));
	}
	
	

}
