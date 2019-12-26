package com.springbook.app.product.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("ProductService")
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private SqlSessionTemplate mybatis;
	@Override
	public List<ProductVO> getProduct() {
		return mybatis.selectList("ProductDAO.getProduct");
	}
	@Override
	public List<ProductVO> getProductList(int id) {
		return mybatis.selectList("ProductDAO.getProductList",id);
	}
	@Override
	public List<ProductVO> getDetailProduct(int id) {
		return mybatis.selectList("ProductDAO.getDetailProduct",id);
	}
	public List<ProductVO> getReserveProduct(int id){
		return mybatis.selectList("ProductDAO.getReserveProduct",id);
	}
	@Override
	public List<ProductVO> getMyreservationProduct(ProductVO vo) {
		return mybatis.selectList("ProductDAO.getMyreservationProduct",vo);
	}
	@Override
	public void updateMyreservationProduct(ProductVO vo) {
		mybatis.update("ProductDAO.updateMyreservationProduct",vo);
		
	}

}
