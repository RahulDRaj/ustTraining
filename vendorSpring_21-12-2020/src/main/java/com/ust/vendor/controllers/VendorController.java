package com.ust.vendor.controllers;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ust.vendor.util.EmailUtil;
import com.ust.vendor.util.ReportUtil;

import com.ust.vendor.Entity.Vendor;
import com.ust.vendor.repos.VendorRepository;
import com.ust.vendor.service.VendorService;

@Controller
public class VendorController {
	
	@Autowired
	VendorService service;
	
	@Autowired
	EmailUtil emailUtil;
	
	@Autowired
	ReportUtil reportUtil;
	
	@Autowired
	ServletContext sc;
	
	@Autowired
	VendorRepository repository;
	
	@RequestMapping("/")
	public String showCreate()
	{
		return "CreateVendor";
	}
	
	@RequestMapping("/saveVen")
	public String saveLocation(@ModelAttribute("ven") Vendor vendor,ModelMap modelMap)
	{
		Vendor vendorSaved = service.saveVendor(vendor);
		String msg = "Vendor saved with ID"+ vendorSaved.getId();
		modelMap.addAttribute("msg",msg);
		
		emailUtil.sendEmail(vendorSaved.getEmail().trim(), "Vendor Created", "New Account is created");
		return "CreateVendor";
	}
	
	@RequestMapping("/displayVendors")
	public String displayLocations(ModelMap modelMap)
	{
		List<Vendor> vendors = service.getAllVendors();
		modelMap.addAttribute("vendors",vendors);
		return "displayVendors";
	}
	
	@RequestMapping("/deleteVendor")
	public String deleteLocation(@RequestParam("id") int id, ModelMap modelMap)
	{
		Vendor vendor = service.getVendorById(id);
		service.deleteVendor(vendor);
		
		List<Vendor> vendors = service.getAllVendors();
		modelMap.addAttribute("vendors",vendors);
		return "displayVendors";
	}
	
	@RequestMapping("/showUpdate")
	public String showUpdate(@RequestParam("id") int id, ModelMap modelMap)
	{
		Vendor vendor = service.getVendorById(id);
		
		modelMap.addAttribute("vendor",vendor);
		return "updateVendor";
	}
	
	@RequestMapping("/updateVen")
	public String updateLocation(@ModelAttribute("ven") Vendor vendor, ModelMap modelMap)
	{
		service.updateVendor(vendor);
		
		List<Vendor> vendors = service.getAllVendors();
		modelMap.addAttribute("vendors",vendors);
		return "displayVendors";
		
	}
	
	@RequestMapping("/generateReport")
	public String generateReport(){
		String path = sc.getRealPath("/");
		List<Object[]> data = repository.findTypeAndTypeCount();
		reportUtil.generatePieChart(path, data);
		return "report";
	}

}
