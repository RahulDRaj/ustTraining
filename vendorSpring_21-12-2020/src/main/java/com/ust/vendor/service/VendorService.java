package com.ust.vendor.service;

import java.util.List;


import com.ust.vendor.Entity.Vendor;

public interface VendorService {
	Vendor saveVendor(Vendor vedor);
	Vendor updateVendor(Vendor vedor);
	void deleteVendor(Vendor vedorr);
	Vendor getVendorById(int id);
	List<Vendor> getAllVendors();

}
