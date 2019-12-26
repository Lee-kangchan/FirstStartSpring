 package com.springbook.app.display.impl;

import java.util.List;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springbook.util.SqlSessionFactoryBean;

@Repository 
public class DisplayDAO {
	@Autowired
	private SqlSession mybatis;

	
	public List<DisplayVO> getDisplay(int id) {
		return mybatis.selectList("DisplayDAO.getDisplay", id);
	}

}
