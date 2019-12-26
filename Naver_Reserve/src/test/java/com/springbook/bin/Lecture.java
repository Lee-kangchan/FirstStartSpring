package com.springbook.bin;

import java.util.ArrayList;

public class Lecture {
	private final String lectureId;
	private final String title;
	private int maxNum;
	private String content;
	private ArrayList<Member> members;

	public Lecture(String lectureId, String title) {
		this.lectureId = lectureId;
		this.title = title;
		members = new ArrayList<Member>();
	}

	public Lecture(String lectureId, String title, int maxNum) {
		this.lectureId = lectureId;
		this.title = title;
		this.maxNum = maxNum;
		members = new ArrayList<Member>();
	}

	public String getLectureId() {
		return lectureId;
	}

	public String getTitle() {
		return title;
	}

	public void setMaxNum(int maxNum) {
		if (maxNum > 100) {
			System.out.println("수강인원은 100명을 초과할 수 없습니다.");
			return;
		}
		this.maxNum = maxNum;
	}

	public int getMaxNum() {
		return maxNum;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getContent() {
		return content;
	}

	public void register(Member member) {
		members.add(member);
	}

	public Member unregister(Member member) {

		int index = findMember(member);
		if (index == -1) {
			System.out.println("해당 학생이 존재하지 않습니다.");
			return null;
		}

		Member old = members.get(index);
		members.remove(index);

		return old;
	}

	private int findMember(Member member) {

		// 검색코드
		for (int index = 0; index < members.size(); index++) {
			if (member == members.get(index))
				return index;
		}

		return -1; // 배열의 인덱스가 -1이 나올 순 없기에 -1로 설정
	}

	public Member findMemberById(String id) {
		for (Member member : members) {
			if (id.contentEquals(member.getId())) {
				return member;
			}
		}
		return null;
	}

	public Member findMemberById(String id, String ps) {
		for (Member member : members) {
			if (id.contentEquals(member.getId())) {
				if (ps.contentEquals(member.getPassword())) {
					return member;
				}
			}
		}
		return null;
	}
	
	
	public void printMembers() {
		for (Member member : members) {
			System.out.println("회원정보:"+member.getMemberService()+" 아이디:"+member.getId()+" 할인율:"+member.getDiscountRate() +" 나이:"+member.getAge());
		}
	}

}
