package com.springbook.app.reservation.impl;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReservationVO {
	
	private int id;
	private double score;
	private String comment;
	private String reservation_name;
	private String reservation_tel;
	private String reservation_email;
	private String reservation_date;
	private int reservation_id;
	private int product_id;
	private ArrayList<int[]> product_price_id;
	private ArrayList<int[]> count;
	private String save_file_name;
	public String getSave_file_name() {
		return save_file_name;
	}
	public void setSave_file_name(String save_file_name) {
		this.save_file_name = save_file_name;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	public String getReservation_name() {
		return reservation_name;
	}
	public void setReservation_name(String reservation_name) {
		this.reservation_name = reservation_name;
	}
	public String getReservation_tel() {
		return reservation_tel;
	}
	public void setReservation_tel(String reservation_tel) {
		this.reservation_tel = reservation_tel;
	}
	public String getReservation_email() {
		return reservation_email;
	}
	public void setReservation_email(String reservation_email) {
		this.reservation_email = reservation_email;
	}
	public int getReservation_id() {
		return reservation_id;
	}
	public void setReservation_id(int reservation_id) {
		this.reservation_id = reservation_id;
	}
	public ArrayList<int[]> getProduct_price_id() {
		return product_price_id;
	}
	public void setProduct_price_id(ArrayList<int[]> product_price_id) {
		this.product_price_id = product_price_id;
	}
	public ArrayList<int[]> getCount() {
		return count;
	}
	public void setCount(ArrayList<int[]> count) {
		this.count = count;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public String getReservation_date() {
		return reservation_date;
	}
	public void setReservation_date(String string) {
		this.reservation_date = string;
	}
	@Override
	public String toString() {
		return "ReservationVO [id=" + id + ", score=" + score + ", comment=" + comment + ", reservation_name="
				+ reservation_name + ", reservation_tel=" + reservation_tel + ", reservation_email=" + reservation_email
				+ "]";
	}
	
	
}
