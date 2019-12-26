package com.springbook.app.reservation.impl;

import java.util.List;

public interface ReservationService  {
	List<ReservationVO> getReservation(int id);
	void insertReservation_info(ReservationVO vo);
	void insertReservation_info_price(ReservationVO vo);
	
}
