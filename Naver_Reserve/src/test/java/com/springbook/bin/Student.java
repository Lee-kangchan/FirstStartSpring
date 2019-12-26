package com.springbook.bin;

import java.util.ArrayList;
import java.util.Scanner;

public class Student {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ArrayList<Lecture> arrayLecture = new ArrayList<Lecture>();

		int button = 0;
		while (button != 4) {
			System.out.println("--------------------------------");
			System.out.println("1.강의추가 2.멤버추가 3.강의조회 4.종료");
			System.out.println("--------------------------------");
			button = scanner.nextInt();
			String lectureId;
			String title;
			int maxnum;
			if (button == 1) { // 수업 추가
				System.out.print("수업번호:");
				lectureId = scanner.next();
				System.out.print("제목:");
				title = scanner.next();
				System.out.print("인원수:");
				maxnum = scanner.nextInt();
				Lecture lecture = new Lecture(lectureId, title, maxnum);
				arrayLecture.add(lecture);
			} else if (button == 2) { // 수업 안 학생들 추가
				String lecture;
				System.out.print("강의제목 입력:"); // 원하는 강의의 학생을 추가
				lecture = scanner.next();
				for (Lecture to : arrayLecture) {
					if(lecture.equals(to.getTitle()))
					{
					while (button != 4) {
						System.out.println("---------------------------------");
						System.out.println("1.수강등록 2.수강취소 3.수강자조회 4.종료");
						System.out.println("---------------------------------");
						button = scanner.nextInt();
						String id;
						String ps;
						String person;
						int age;
						if (button == 1) { // 아이디추가로 강의 등록

							
							Member member;
							System.out.print("고급회원?(y/n) :");
							person = scanner.next();
							System.out.print("아이디 입력:");
							id = scanner.next();
							System.out.print("비번 입력:");
							ps = scanner.next();
							System.out.print("나이 입력:");
							age = scanner.nextInt();
							
							if(person.equals("y")) {
								member = new SpecialMember(id, ps, age);
							}
							else {
								if(age> 19 ) {
									member = new BasicMember(id, ps, age);
								}
								else {
									member = new StudentMember(id, ps, age);
								}
							}
							member.getMemberInfo();
							Member result = to.findMemberById(id);
							
							if(result==null) {
								to.register(member);
								System.out.println("추가되었습니다.");
							}
						} else if (button == 2) { // 아이디 삭제
							System.out.println("수강신청할 아이디 비밀번호를 입력하시오:");
							System.out.print("id:");
							id = scanner.next();
							System.out.print("ps:");
							ps = scanner.next();
							Member member = to.findMemberById(id,ps);
							to.unregister(member);
						} else if (button == 3) { // 강의 학생 조회
							to.printMembers();
						} 
						else if (button == 4) {
							System.out.println("종료하겠습니다.");
							button=0;
							break;
						} else {
							System.out.println("잘못누르셨습니다.");
						}
					}
					}
				}
			} else if (button == 3) { // 강의 조회
				for (Lecture vo : arrayLecture) {
					System.out.println("강의번호:" + vo.getLectureId() + " 제목:" + vo.getTitle());
				}
			} 
			else if (button == 4) {
				System.out.println("종료하겠습니다.");
				break;
			} else {
				System.out.println("잘못누르셨습니다.");
				continue;

			}

		}
	}
}