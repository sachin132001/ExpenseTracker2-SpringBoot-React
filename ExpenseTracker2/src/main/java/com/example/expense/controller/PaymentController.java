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

import com.example.expense.entity.Payment;
import com.example.expense.entity.PaymentDTO;
import com.example.expense.entity.Vendor;
import com.example.expense.services.PaymentService;
@CrossOrigin("*")
@RestController
public class PaymentController {
	
	@Autowired
	PaymentService pserv;
	
	@PostMapping("/addPay")
	public String addPay(@RequestBody PaymentDTO paymentDTO) {
	    Payment payment = new Payment();
	    payment.setPtype(paymentDTO.getPtype());
	    payment.setPmode(paymentDTO.getPmode());
	    payment.setPdesc(paymentDTO.getPdesc());
	    
	    pserv.addPay(payment);
	    
	    return "payment";
	}

	 
	@GetMapping("/map-Pview")
	public List<PaymentDTO> viewPay() {
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

    


	@GetMapping("/Pupdate/{id}") // Corrected path variable
	public PaymentDTO showUpdatePaymentForm(@PathVariable("id") int id) {
	    Payment payment = pserv.getPaymentById(id);
	    PaymentDTO paymentDTO = new PaymentDTO();
	    paymentDTO.setPid(payment.getPid());
	    paymentDTO.setPtype(payment.getPtype());
	    paymentDTO.setPmode(payment.getPmode());
	    paymentDTO.setPdesc(payment.getPdesc());
	    
	    
	    return paymentDTO;
	}

	@PostMapping("/Pupdate/{id}") // Changed to PostMapping
	public String updatePayment(@PathVariable("id") int id, @RequestBody PaymentDTO paymentDTO) {
	    Payment payment = new Payment();
	    payment.setPid(id); // Set the existing ID
	    payment.setPtype(paymentDTO.getPtype());
	    payment.setPmode(paymentDTO.getPmode());
	    payment.setPdesc(paymentDTO.getPdesc());
	    
	    pserv.updatePayment(payment);
	    return "payment"; // Redirect to the view payment page
	}


    

    @PostMapping("/Pdelete/{id}")
    public String deletePayment(@PathVariable("id") int id) {
        pserv.deletePaymentById(id);
        return "deleted"; // Redirect to the view category page
    }



}
