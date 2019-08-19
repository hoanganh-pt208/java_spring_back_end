package com.hoanganh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hoanganh.model.Tag;
import com.hoanganh.response.ResponseModel;
import com.hoanganh.service.TagService;

@RestController
@RequestMapping("/tag")
public class TagController {
	@Autowired
    private TagService tagService;
	
	/**
	 * Method get List User
	 */
	@RequestMapping(value = "/getTagList", method = RequestMethod.GET)
	public ResponseModel getTagList() {
		List<Tag> list = null;
		ResponseModel responseModel = new ResponseModel();
		try {
			list = tagService.getTagList();
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
