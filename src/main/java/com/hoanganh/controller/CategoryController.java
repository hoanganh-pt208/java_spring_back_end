package com.hoanganh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hoanganh.model.Category;
import com.hoanganh.service.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {
	@Autowired
    private CategoryService categoryService;
	/*
	 * Method get List Category
	 */
	@RequestMapping(value = "/getListCategory", method = RequestMethod.GET)
	public ResponseEntity<List<Category>> getTagList() {
		List<Category> list = null;
		try {
			list = categoryService.getListCategory();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<List<Category>>(list, HttpStatus.OK);
	}
}
