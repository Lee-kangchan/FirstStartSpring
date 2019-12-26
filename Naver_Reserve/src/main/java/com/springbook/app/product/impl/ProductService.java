package com.springbook.app.product.impl;

import java.util.List;

public interface ProductService {

	List<ProductVO> getProduct();
	List<ProductVO> getProductList(int id);
	List<ProductVO> getDetailProduct(int id);
	List<ProductVO> getReserveProduct(int id);
	List<ProductVO> getMyreservationProduct(ProductVO vo);
	void updateMyreservationProduct(ProductVO vo);
}