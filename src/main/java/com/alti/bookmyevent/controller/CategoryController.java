package com.alti.bookmyevent.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alti.bookmyevent.ORM.Category;
import com.alti.bookmyevent.service.CategoryService;

@RestController()
@RequestMapping("/category")
public class CategoryController {
	
	@Autowired CategoryService categoryService;
	
	@PostMapping()
	public ResponseEntity<Category> createCategory(@RequestBody Category category) {
		return new ResponseEntity<Category>(categoryService.createCategory(category), HttpStatus.CREATED);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Category>> getAllCategory() {
		return new ResponseEntity<List<Category>>(categoryService.getAllCategory(), HttpStatus.OK);
	}
	
	@GetMapping()
	public ResponseEntity<Category> getCategoryById(@RequestParam Integer id) throws Exception {
		return new ResponseEntity<Category>(categoryService.getCategoryById(id), HttpStatus.OK);
	}
	
	@PutMapping()
	public ResponseEntity<Category> updateCategory(@RequestBody Category category) {
		return new ResponseEntity<Category>(categoryService.updateCategory(category), HttpStatus.OK);
	}
	
	@DeleteMapping()
	public void deleteCategory(@RequestParam Integer id) {
		categoryService.deleteCategory(id);
	}
}
