package com.mobile101.tierlistAPI.tierlist.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mobile101.tierlistAPI.exception.BaseException;
import com.mobile101.tierlistAPI.tierlist.business.CategoryBusiness;
import com.mobile101.tierlistAPI.tierlist.json.CategoryJson;
import com.mobile101.tierlistAPI.tierlist.model.Category;
import com.mobile101.tierlistAPI.tierlist.payload.CategoryPayload;
import com.mobile101.tierlistAPI.tierlist.service.CategoryService;

@RestController
@RequestMapping("/api")
public class CategoryController {
    @Autowired
	CategoryService categoryService;
	
	@Autowired
	CategoryBusiness categoryBusiness;

	public CategoryController(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	
	@PostMapping("/categories")
	public ResponseEntity<Long> saveCategory(@RequestBody CategoryPayload payload) throws BaseException {
		Long categoryId = categoryBusiness.saveCategory(payload);
		return new ResponseEntity<>(categoryId, HttpStatus.CREATED);
	}
	
	
	@GetMapping(value = "/categories")
	public ResponseEntity<List<CategoryJson>> getAllCategories() throws BaseException{
		return ResponseEntity.ok(categoryBusiness.getListCategory());
	}
	
	@GetMapping(value = "/categories/{id}")
	public ResponseEntity<CategoryJson> getCategoryById(@PathVariable("id") long id) throws BaseException{
		return ResponseEntity.ok(categoryBusiness.getCategoryId(id));
	}
	
    @PutMapping(value = "/categories/{id}")
	public ResponseEntity<CategoryJson> updatecategory(@PathVariable("id") long id, @RequestBody CategoryPayload payload){
		Optional<Category> categoryData = categoryService.findOptionalById(id);
		if(categoryData.isPresent()) {
			categoryBusiness.updateCategory(categoryData.get().getId(), payload);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/categories/{id}")
	public ResponseEntity<CategoryJson> deleteCategoryById(@PathVariable("id") long id) {
		try {
			categoryBusiness.deleteCategory(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}