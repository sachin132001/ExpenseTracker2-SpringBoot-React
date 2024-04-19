package com.example.expense.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.expense.entity.Category;
import com.example.expense.entity.CategoryDTO;
import com.example.expense.services.CategoryService;
@CrossOrigin("*")
@RestController
public class CategoryController {
	@Autowired
	CategoryService cserv;
	@PostMapping("/addCat")
	public String addCat(@RequestBody CategoryDTO categoryDTO) {
	    Category category = new Category();
	    category.setCat_name(categoryDTO.getCat_name());
	    category.setCat_desc(categoryDTO.getCat_desc());
	    category.setCat_type(categoryDTO.getCat_type());
	    category.setP_cat(categoryDTO.getP_cat());
	    
	    cserv.addCat(category);
	    
	    return "category";
	}

	 
	@GetMapping("/map-view")
	public List<CategoryDTO> viewCat() {
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

    


    @GetMapping("/update/{id}") // Corrected path variable
    public Category showUpdateCategoryForm(@PathVariable("id") int id) {
        Category category = cserv.getCategoryById(id);
        String parentCategoryName = cserv.getParentCategoryName(id);
        return category;
    }

    @PostMapping("/update/{id}") // Changed to PostMapping
    public String updateCategory(@PathVariable("id") int id, @RequestBody CategoryDTO categoryDTO) {
        Category category = new Category();
        category.setCid(id);
        category.setCat_name(categoryDTO.getCat_name());
        category.setCat_desc(categoryDTO.getCat_desc());
        category.setCat_type(categoryDTO.getCat_type());
        category.setP_cat(categoryDTO.getP_cat());
        cserv.updateCategory(category);
        return "category"; // Redirect to the view category page
    }

    

    @PostMapping("/delete/{id}")
    public String deleteCategory(@PathVariable("id") int id) {
        cserv.deleteCategoryById(id);
        return "category"; // Redirect to the view category page
    }


}
