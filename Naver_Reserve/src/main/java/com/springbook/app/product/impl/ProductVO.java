package com.springbook.app.product.impl;

import java.time.LocalDateTime;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString; 
@Data
@Getter
@Setter
@ToString
public class ProductVO {
	private int id;
	private int category_id;
	private String description;
	private String content;
	private String save_file_name;
	private String price_type_name;
	private String reservation_email;
	private int price;
	private double discount_rate;
	private String opening_hours;
	private String place_name;
	private String place_lot;
	private String place_street;
	private String tel;
	private String homepage;
	private int count;
	private int cancel_flag;
	
}
