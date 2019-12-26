package com.springbook.app.reservation.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springbook.app.product.impl.ProductVO;
@Repository
public class ReservationDAO {
	@Autowired
	private SqlSession mybatis;

	public List<ReservationVO> getReservation(int id) {
		return mybatis.selectList("ReservationDAO.getReservation",id);
	}
	public void insertReservation_info(ReservationVO vo) {
		mybatis.insert("insertReservation_info", vo);
	}
	public void insertReservation_info_price(ReservationVO vo) {
		mybatis.insert("insertReservation_info_price", vo);
	}
}
