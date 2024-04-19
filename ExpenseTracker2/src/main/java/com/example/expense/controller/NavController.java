package com.example.expense.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.expense.entity.Category;
import com.example.expense.entity.CategoryDTO;
import com.example.expense.entity.Payment;
import com.example.expense.entity.PaymentDTO;
import com.example.expense.entity.Vendor;
import com.example.expense.entity.VendorDTO;
import com.example.expense.services.CategoryService;
import com.example.expense.services.PaymentService;
import com.example.expense.services.VendorService;
@CrossOrigin("*")
@RestController
public class NavController {
	
	@Autowired
	CategoryService cserv;
	
	@Autowired
	VendorService vserv;
	
	@Autowired
	PaymentService pserv;
	
	@GetMapping("/map-register")
	public String register() {
		return "register";
	}
	
	@GetMapping("/map-login")
	public String login() {
		return "login";
	}

	
	
    @GetMapping("/map-addCategory")
	public List<CategoryDTO> addCategory() {
    	 List<Category> clist = cserv.viewCat();
 	    List<CategoryDTO> clist2 = new ArrayList<>();

 	    for (Category category : clist) {
 	        CategoryDTO dto = new CategoryDTO();
 	        dto.setCid(category.getCid());
 	        dto.setCat_name(category.getCat_name());
 	        dto.setCat_desc(category.getCat_desc());
 	        dto.setCat_type(category.getCat_type());
 	        dto.setP_cat(category.getP_cat());
 	        clist2.add(dto);
 	    }

 	    return clist2;
	}
    
   @GetMapping("/map-addVendor")
   public List<VendorDTO> addVendor() {
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
   
   @GetMapping("/map-addPayment")
   public List<PaymentDTO> addPayment() {
	   List<Payment> plist = pserv.viewPay();
	    List<PaymentDTO> plist2 = new ArrayList<>();

	    for (Payment payment : plist) {
	        PaymentDTO dto = new PaymentDTO();
	        dto.setPid(payment.getPid());
	        dto.setPtype(payment.getPtype());
	        dto.setPmode(payment.getPmode());
	        dto.setPdesc(payment.getPdesc());
	        plist2.add(dto);
	    }

	    return plist2;
   }
   @GetMapping("/map-addTransaction")
  	public String addTransaction() {
  		return "addTransaction";
  	}
}
