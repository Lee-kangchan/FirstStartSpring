package com.springbook.bin;

public class StudentMember extends Member {

	private int discountRate = 20;

	public StudentMember(String id, String password, int age) {
		super(id, password, age);
	}

	public void getMemberInfo() {
		super.setMemberService("학생회원");
	}

	public int getDiscountRate() {
		return discountRate;
	}
}
