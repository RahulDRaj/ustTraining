package com.ust.vendor.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ust.vendor.Entity.Vendor;

public interface VendorRepository extends JpaRepository<Vendor,Integer> {
	@Query("select name,id from Vendor group by id")
	public List<Object[]> findTypeAndTypeCount();

}
