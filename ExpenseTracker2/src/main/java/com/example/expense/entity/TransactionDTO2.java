package com.example.expense.entity;

import java.sql.Date;

public class TransactionDTO2 {

    int tid;
    
    String tcat;
    
    double amount;

    Date tdate;

    @Override
	public String toString() {
		return "TransactionDTO2 [tid=" + tid + ", tcat=" + tcat + ", amount=" + amount + ", tdate=" + tdate
				+ ", particulars=" + particulars + "]";
	}

	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	public String getTcat() {
		return tcat;
	}

	public void setTcat(String tcat) {
		this.tcat = tcat;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Date getTdate() {
		return tdate;
	}

	public void setTdate(Date tdate) {
		this.tdate = tdate;
	}

	public String getParticulars() {
		return particulars;
	}

	public void setParticulars(String particulars) {
		this.particulars = particulars;
	}

	public TransactionDTO2(int tid, String tcat, double amount, Date tdate, String particulars) {
		super();
		this.tid = tid;
		this.tcat = tcat;
		this.amount = amount;
		this.tdate = tdate;
		this.particulars = particulars;
	}

	public TransactionDTO2() {
		super();
		// TODO Auto-generated constructor stub
	}

	String particulars;

    

  


}
