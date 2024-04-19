package com.example.expense.entity;

public class CategoryDTO {
	int cid;
   String cat_name;
   String cat_desc;
   String cat_type;
   String p_cat;
   
 public CategoryDTO() {
	super();
	// TODO Auto-generated constructor stub
 }

public CategoryDTO(int cid, String cat_name, String cat_desc, String cat_type, String p_cat) {
	super();
	this.cid = cid;
	this.cat_name = cat_name;
	this.cat_desc = cat_desc;
	this.cat_type = cat_type;
	this.p_cat = p_cat;
}

public int getCid() {
	return cid;
}

public void setCid(int cid) {
	this.cid = cid;
}

public String getCat_name() {
	return cat_name;
}

public void setCat_name(String cat_name) {
	this.cat_name = cat_name;
}

public String getCat_desc() {
	return cat_desc;
}

public void setCat_desc(String cat_desc) {
	this.cat_desc = cat_desc;
}

public String getCat_type() {
	return cat_type;
}

public void setCat_type(String cat_type) {
	this.cat_type = cat_type;
}

public String getP_cat() {
	return p_cat;
}

public void setP_cat(String p_cat) {
	this.p_cat = p_cat;
}

@Override
public String toString() {
	return "CategoryDTO [cid=" + cid + ", cat_name=" + cat_name + ", cat_desc=" + cat_desc + ", cat_type=" + cat_type
			+ ", p_cat=" + p_cat + "]";
}
 
 
   
   

}
