package com.springbook.app.reservation.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("ReservationService")
public class ReservationServiceImpl implements ReservationService {
	
	@Autowired
	SqlSession mybatis;
	
	@Override
	public List<ReservationVO> getReservation(int id) {
		return mybatis.selectList("ReservationDAO.getReservation",id);
	}
	@Override
	public void insertReservation_info(ReservationVO vo) {
		mybatis.insert("ReservationDAO.insertReservation_info",vo);
		
	}
	@Override
	public void insertReservation_info_price(ReservationVO vo) {
		mybatis.insert("ReservationDAO.insertReservation_info_price",vo);
	}
}
