package com.example.expense.entity;

public class PaymentDTO {
	int pid;
	String ptype;
	String pmode;
	String pdesc;
	public PaymentDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PaymentDTO(int pid, String ptype, String pmode, String pdesc) {
		super();
		this.pid = pid;
		this.ptype = ptype;
		this.pmode = pmode;
		this.pdesc = pdesc;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPtype() {
		return ptype;
	}
	public void setPtype(String ptype) {
		this.ptype = ptype;
	}
	public String getPmode() {
		return pmode;
	}
	public void setPmode(String pmode) {
		this.pmode = pmode;
	}
	public String getPdesc() {
		return pdesc;
	}
	public void setPdesc(String pdesc) {
		this.pdesc = pdesc;
	}
	@Override
	public String toString() {
		return "PaymentDTO [pid=" + pid + ", ptype=" + ptype + ", pmode=" + pmode + ", pdesc=" + pdesc + "]";
	}
	
	

}
