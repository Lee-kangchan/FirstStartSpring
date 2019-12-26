package com.springbook.app.display.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service("DisplayService")
public class DisplayServiceImpl implements DisplayService{
	@Autowired
	DisplayDAO displayDAO;

	public List<DisplayVO> getDisplay(int id) {
		// TODO Auto-generated method stub
		return displayDAO.getDisplay(id);
	}

}
