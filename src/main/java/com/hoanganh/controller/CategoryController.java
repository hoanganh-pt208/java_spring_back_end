package com.hoanganh.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hoanganh.model.Category;
import com.hoanganh.response.ResponseModel;
import com.hoanganh.service.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {
	@Autowired
	private CategoryService categoryService;

	/**
	 * Method get List Category
	 */
	@RequestMapping(value = "/getListCategory", method = RequestMethod.GET)
	public ResponseModel getTagList(HttpServletResponse response) {
		List<Category> list = null;
		ResponseModel responseModel = new ResponseModel();
		try {
			list = categoryService.getListCategory();
			responseModel.setData(list);
			responseModel.setStatus("success");
			return responseModel;
		} catch (Exception e) {
			e.printStackTrace();
			responseModel.setStatus("fail");
			return responseModel;
		}
	}
}
