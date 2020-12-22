package com.ust.vendor.controllers;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ust.vendor.Entity.Vendor;
import com.ust.vendor.repos.VendorRepository;



@RestController
@RequestMapping("/vendor")
public class VendorRestController {
	
	@Autowired
	VendorRepository vendorRespsitory;
	
	@GetMapping
	public List<Vendor> getVendorss()
	{
		return vendorRespsitory.findAll();
	}
	
	@PostMapping
	public Vendor createLocation(@RequestBody Vendor location) 
	{
		return vendorRespsitory.save(location);
	}
	
	@PutMapping
	public Vendor updateLocation(@RequestBody Vendor location) 
	{
		return vendorRespsitory.save(location);
	}
	
	@DeleteMapping("/{id}")
	public void deleteLocation(@PathVariable("id") int id)
	{
		vendorRespsitory.deleteById(id);
		
	}
	
	@GetMapping("/{id}")
	public Optional<Vendor> getLocation(@PathVariable("id") int id)
	{
		return vendorRespsitory.findById(id);
		
	}
	
	
	

}
