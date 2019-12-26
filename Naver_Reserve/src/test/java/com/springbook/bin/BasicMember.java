package com.springbook.bin;

public class BasicMember extends Member {

	private int discountRate = 10;

	public BasicMember(String id, String password, int age) {
		super(id, password, age);
	}

	public void getMemberInfo() {
		super.setMemberService("일반회원");
	}

	public int getDiscountRate() {
		return discountRate;
	}

}
