package com.example.expense.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.expense.entity.Vendor;
import com.example.expense.entity.VendorDTO;
import com.example.expense.services.VendorService;
@CrossOrigin("*")
@RestController
public class VendorController {
	@Autowired
	VendorService vserv;
	@PostMapping("/addVen")
	public String addVen(@RequestBody VendorDTO vendorDTO) {
	    Vendor vendor = new Vendor();
	    vendor.setVname(vendorDTO.getVname());
	    vendor.setVloc(vendorDTO.getVloc());
	    
	    vserv.addVen(vendor);
	    
	    return "vendor";
	}

	@GetMapping("/map-Vview")
	public List<VendorDTO> viewVen() {
	    List<Vendor> vlist = vserv.viewVen();
	    List<VendorDTO> vlist2 = new ArrayList<>();

	    for (Vendor vendor : vlist) {
	        VendorDTO dto = new VendorDTO();
	        dto.setVid(vendor.getVid());
	        dto.setVname(vendor.getVname());
	        dto.setVloc(vendor.getVloc());
	        vlist2.add(dto);
	    }

	    return vlist2;
	}

    


    @GetMapping("/Vupdate/{id}") // Corrected path variable
    public Vendor showUpdateVendorForm(@PathVariable("id") int id) {
        Vendor vendor = vserv.getVendorById(id);
        return vendor;// Assuming you have a corresponding HTML file for updating category
    }
    @PostMapping("/Vupdate/{id}") // Changed to PostMapping
    public String updateVendor(@PathVariable("id") int id, @RequestBody VendorDTO vendorDTO) {
        Vendor vendor = new Vendor();
        vendor.setVid(id);
        vendor.setVname(vendorDTO.getVname());
        vendor.setVloc(vendorDTO.getVloc());
        vserv.updateVendor(vendor);
        return "vendor"; // Redirect to the view category page
    }
    

    @PostMapping("/Vdelete/{id}")
    public String deleteVendor(@PathVariable("id") int id) {
        vserv.deleteVendorById(id);
        return "deleted"; // Redirect to the view category page
    }



}
