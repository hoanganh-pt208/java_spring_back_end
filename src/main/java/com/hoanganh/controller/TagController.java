package com.hoanganh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hoanganh.model.Tag;
import com.hoanganh.service.TagService;

@RestController
@RequestMapping("/tag")
public class TagController {
	@Autowired
    private TagService tagService;
	/*
	 * Method get List User
	 */
	@RequestMapping(value = "/getTagList", method = RequestMethod.GET)
	public ResponseEntity<List<Tag>> getTagList() {
		List<Tag> list = null;
		try {
			list = tagService.getTagList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<List<Tag>>(list, HttpStatus.OK);
	}
}
