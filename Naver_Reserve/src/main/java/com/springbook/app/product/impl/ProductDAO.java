package com.springbook.app.product.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springbook.util.SqlSessionFactoryBean;
@Repository
public class ProductDAO {
	@Autowired
	private SqlSession mybatis;
	
	public List<ProductVO> getProduct() {
		return mybatis.selectList("ProductDAO.getProduct");
	}
	public List<ProductVO> getProductList(int id){
		return mybatis.selectList("ProductDAO.getProductList",id);
	}
	public List<ProductVO> getDetailProduct(int id){
		return mybatis.selectList("ProductDAO.getDetailProduct",id);
	}
	public List<ProductVO> getReserveProduct(int id){
		return mybatis.selectList("ProductDAO.getReserveProduct",id);
	}
	public List<ProductVO> getMyreservationProduct(ProductVO vo){
		return mybatis.selectList("ProductDAO.getMyreservationProduct",vo);
	}
	public void updateMyreservationProduct(ProductVO vo){
		mybatis.update("ProductDAO.updateMyreservationProduct",vo);
	}
}
