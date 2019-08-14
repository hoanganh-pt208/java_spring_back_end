package com.hoanganh.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hoanganh.dao.TagDao;
import com.hoanganh.model.Tag;

@Service
@Transactional
public class TagServiceImpl implements TagService {
	@Autowired
	private TagDao tagDao;
	/*
	 * Method get Tag List
	 */
	public List<Tag> getTagList() {
		// TODO Auto-generated method stub
		return tagDao.getTagList();
	}

}
