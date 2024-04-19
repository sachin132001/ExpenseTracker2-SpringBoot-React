package com.example.expense.entity;

public class VendorDTO {
	int vid;
    String vname;
    String vloc;
	public VendorDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public VendorDTO(int vid, String vname, String vloc) {
		super();
		this.vid = vid;
		this.vname = vname;
		this.vloc = vloc;
	}
	public int getVid() {
		return vid;
	}
	public void setVid(int vid) {
		this.vid = vid;
	}
	public String getVname() {
		return vname;
	}
	public void setVname(String vname) {
		this.vname = vname;
	}
	public String getVloc() {
		return vloc;
	}
	public void setVloc(String vloc) {
		this.vloc = vloc;
	}
	@Override
	public String toString() {
		return "VendorDTO [vid=" + vid + ", vname=" + vname + ", vloc=" + vloc + "]";
	}
    
    

}
