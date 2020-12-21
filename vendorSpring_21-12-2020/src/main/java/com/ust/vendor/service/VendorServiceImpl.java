package com.ust.vendor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ust.vendor.Entity.Vendor;
import com.ust.vendor.repos.VendorRepository;

@Service
public class VendorServiceImpl implements VendorService {
	
	@Autowired
	private VendorRepository repository;

	@Override
	public Vendor saveVendor(Vendor vedor) {
		// TODO Auto-generated method stub
		return repository.save(vedor);
	}

	@Override
	public Vendor updateVendor(Vendor vedor) {
		// TODO Auto-generated method stub
		return repository.save(vedor);
	}

	@Override
	public void deleteVendor(Vendor vedor) {
		// TODO Auto-generated method stub
		repository.delete(vedor);

	}

	@Override
	public Vendor getVendorById(int id) {
		// TODO Auto-generated method stub
		return repository.findById(id).get();
	}

	@Override
	public List<Vendor> getAllVendors() {
		// TODO Auto-generated method stub
		return (List<Vendor>) repository.findAll();
	}
	
	public VendorRepository getRepository() {
		return repository;
	}

	public void setRepository(VendorRepository repository) {
		this.repository = repository;
	}


}
