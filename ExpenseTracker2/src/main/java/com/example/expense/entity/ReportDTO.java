package com.example.expense.entity;

public class ReportDTO {
	
	String fromDate;
	String toDate;
	public ReportDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ReportDTO(String fromDate, String toDate) {
		super();
		this.fromDate = fromDate;
		this.toDate = toDate;
	}
	public String getFromDate() {
		return fromDate;
	}
	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}
	public String getToDate() {
		return toDate;
	}
	public void setToDate(String toDate) {
		this.toDate = toDate;
	}
	@Override
	public String toString() {
		return "ReportDTO [fromDate=" + fromDate + ", toDate=" + toDate + "]";
	}
	
	

}
