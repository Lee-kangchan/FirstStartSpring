package com.springbook.bin;

public class SpecialMember extends Member {

	private int discountRate = 0;

	public SpecialMember(String id, String password, int age) {
		super(id, password, age);
	}

	public void getMemberInfo() {
		super.setMemberService("고급회원");
	}

	public int getDiscountRate() {
		return discountRate;
	}
}
