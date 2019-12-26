package com.springbook.bin;

public abstract class Member {
	private String name;
	final String id;
	private String password;
	private String memberService;
	private int age;

	public Member(String id, String password) {
		this.id = id;
		this.password = password;
	}

	public Member(String id, String password, int age) {
		this.id = id;
		this.password = password;
		this.age = age;
	}

	public Member(String id, String password, String name) {
		this.name = name;
		this.id = id;
		this.password = password;
	}

	public Member(String name, String id, String password, int age) {
		this.name = name;
		this.id = id;
		this.password = password;
		this.age = age;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getAge() {
		return age;
	}

	public String getId() {
		return id;
	}

	public String getMemberService() {
		return memberService;
	}

	public void setMemberService(String memberService) {
		this.memberService = memberService;
	}


	public boolean isAdult() {
		if (this.age >= 19)
			return true;
		else
			return false;
	}
	public abstract void getMemberInfo();
	public abstract int getDiscountRate();

}