package com.example.expense.controller;

import java.sql.Date;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.expense.entity.Category;
import com.example.expense.entity.Payment;
import com.example.expense.entity.Transaction;
import com.example.expense.entity.TransactionDTO;
import com.example.expense.entity.TransactionDTO2;
import com.example.expense.entity.Vendor;
import com.example.expense.services.CategoryService;
import com.example.expense.services.PaymentService;
import com.example.expense.services.TransactionService;
import com.example.expense.services.VendorService;
@CrossOrigin("*")
@RestController
public class TransactionController {
	@Autowired
	TransactionService tserv;
	
	@Autowired
	CategoryService cserv;
	
	@Autowired
	VendorService vserv;
	
	@Autowired
	PaymentService pserv;
	
	
	@PostMapping("/addTrans")
	public String addTrans(@RequestBody TransactionDTO transactionDTO)
	                       {
	    
	    Category category = cserv.getCategoryById(transactionDTO.getTcat()); // Assuming you have a method to get Category by ID
	    Vendor vendor=vserv.getVendorById(transactionDTO.getTven());
	    Payment payment=pserv.getPaymentById(transactionDTO.getTpay());
	    
	    Transaction trans = new Transaction();
	    trans.setTid(transactionDTO.getTid());
	    trans.setTdate(transactionDTO.getTdate());
	    trans.setTcat(category.getCat_name());
	    trans.setParticulars(transactionDTO.getParticulars());
	    trans.setAmount(transactionDTO.getAmount());
	    trans.setTven(vendor.getVname());
	    trans.setTpay(payment.getPtype());
	    trans.setTdetails(transactionDTO.getTdetails());
	    trans.setRemarks(transactionDTO.getRemarks());
	    trans.setCategory(category);
	    trans.setVendor(vendor);
	    trans.setPayment(payment);
	    tserv.addTrans(trans);
	    
	    category.getTransactions().add(trans);
	    cserv.updateCat(category);
	    
	    vendor.getTransactions().add(trans);
	    vserv.updateVen(vendor);
	    
	    payment.getTransactions().add(trans);
	    pserv.updatePay(payment);
	    
	    return "transaction";
	}

	 
	@GetMapping("/map-Tview")
	public List<TransactionDTO2> viewTrans() {
	    List<Transaction> tlist = tserv.viewTrans();
	    List<TransactionDTO2> tlist2 = new ArrayList<>();
	   

	   

	    for (Transaction transaction : tlist) {
	        TransactionDTO2 dto = new TransactionDTO2();
	        dto.setTid(transaction.getTid());
	        Category category = transaction.getCategory();
		    dto.setTcat(category.getCat_name());
	        dto.setAmount(transaction.getAmount());
	        dto.setTdate(transaction.getTdate());
	        dto.setParticulars(transaction.getParticulars());
	        tlist2.add(dto);
	    }

	    return tlist2;
	}

    


    @GetMapping("/Tupdate/{id}") // Corrected path variable
    public TransactionDTO showUpdateTransactionForm(@PathVariable("id") int id) {
    	
        Transaction transaction = tserv.getTransactionById(id);
        TransactionDTO t=new TransactionDTO();
        t.setTid(transaction.getTid());
        t.setTdate(transaction.getTdate());
        t.setTcat(transaction.getCategory().getCid());
        t.setParticulars(transaction.getParticulars());
        t.setAmount(transaction.getAmount());
        t.setTven(transaction.getVendor().getVid());
        t.setTpay(transaction.getPayment().getPid());
        t.setTdetails(transaction.getTdetails());
        t.setRemarks(transaction.getRemarks());
        String categoryName = tserv.getCategoryName(id);
        
        String vendorName=tserv.getVendorName(id);
        
        String paymentType=tserv.getPaymentType(id);
        
       
        return t;
    }

    @PostMapping("/Tupdate/{id}") // Changed to PostMapping
    public String updateTransaction(@PathVariable("id") int id, @RequestBody TransactionDTO transactionDTO) {
       
        Category category = cserv.getCategoryById(transactionDTO.getTcat()); // Assuming you have a method to get Category by ID
	    Vendor vendor=vserv.getVendorById(transactionDTO.getTven());
	    Payment payment=pserv.getPaymentById(transactionDTO.getTpay());
	    
	    Transaction trans = new Transaction();
	    trans.setTid(id);
	    trans.setTdate(transactionDTO.getTdate());
	    trans.setTcat(category.getCat_name());
	    trans.setParticulars(transactionDTO.getParticulars());
	    trans.setAmount(transactionDTO.getAmount());
	    trans.setTven(vendor.getVname());
	    trans.setTpay(payment.getPtype());
	    trans.setTdetails(transactionDTO.getTdetails());
	    trans.setRemarks(transactionDTO.getRemarks());
	    trans.setCategory(category);
	    trans.setVendor(vendor);
	    trans.setPayment(payment);
        tserv.updateTransaction(trans);
        
      
        return "transaction"; // Redirect to the view category page
    }
    

    @PostMapping("/Tdelete/{id}")
    public String deleteTransaction(@PathVariable("id") int id) {
        tserv.deleteTransactionById(id);
        return "deleted"; // Redirect to the view category page
    }



}
