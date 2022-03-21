package com.nexflix.run;

import java.util.ArrayList;
import java.util.Scanner;

import com.netflix.dao.MembershipDAO;
import com.netflix.dto.Basic;
import com.netflix.dto.MembershipDTO;
import com.netflix.dto.Premium;
import com.netflix.dto.Standard;

public class Run {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		MembershipDAO dao = new MembershipDAO();
		MembershipDTO dto = new MembershipDTO();
		Basic ba = new Basic();
		Standard st = new Standard();
		Premium pr = new Premium();

		while (true) {

			System.out.println(" **** Netflix 회원 관리 시스템 **** ");
			System.out.println(" 1. 신규 회원 등록");
			System.out.println(" 2. 회원 목록 출력");
			System.out.println(" 3. 회원 정보 검색");
			System.out.println(" 4. 회원 정보 수정");
			System.out.println(" 5. 회원 정보 삭제");
			System.out.println(" 6. 시스템 종료");
			System.out.print(" >> ");
			try {
				int menu = Integer.parseInt(sc.nextLine());

				if (menu == 1) { // 신규 등록
					System.out.println(" 회원 등급 선택 ");
					System.out.println(" 1. Basic");
					System.out.println(" 2. Standard");
					System.out.println(" 3. Premium");

					try {
						int membership = Integer.parseInt(sc.nextLine());
						if (membership == 1) {
							System.out.print(" 신규 회원 ID(7자 이내) : ");
							String id = sc.nextLine();
							System.out.print(" 신규 회원 닉네임(4자 이내) : ");
							String nickname = sc.nextLine();
							System.out.print(" 신규 회원 가입일(210505 형식으로) : ");
							String signup_date = sc.nextLine();
							System.out.print(" 신규 회원 포인트 : ");
							int point = Integer.parseInt(sc.nextLine());

							MembershipDTO all = new MembershipDTO(id, nickname, signup_date, point, ba.getMembership());

							dao.insert(all);

						} else if (membership == 2) {
							System.out.print(" 신규 회원 ID(7자 이내) : ");
							String id = sc.nextLine();
							if (dao.idSerch(id)) {
								System.out.println(" 중복된 아이디 입니다.");
							}
							
							System.out.print(" 신규 회원 닉네임(4자 이내) : ");
							String nickname = sc.nextLine();
							if (dao.nickSerch(nickname)) {
								System.out.println(" 중복된 닉네입 입니다. ");
							}
							
							System.out.print(" 신규 회원 가입일(210505 형식으로) : ");
							String signup_date = sc.nextLine();
							System.out.print(" 신규 회원 포인트 : ");
							int point = Integer.parseInt(sc.nextLine());
							MembershipDTO all = new MembershipDTO(id, nickname, signup_date, point, st.getMembership());
							dao.insert(all);

						} else if (membership == 3) {
							System.out.print(" 신규 회원 ID(7자 이내) : ");
							String id = sc.nextLine();
							System.out.print(" 신규 회원 닉네임(4자 이내) : ");
							String nickname = sc.nextLine();
							System.out.print(" 신규 회원 가입일(210505 형식으로) : ");
							String signup_date = sc.nextLine();
							System.out.print(" 신규 회원 포인트 : ");
							int point = Integer.parseInt(sc.nextLine());
							MembershipDTO all = new MembershipDTO(id, nickname, signup_date, point, pr.getMembership());
							dao.insert(all);
						} else {
							System.out.println(" 잘못된 번호입니다. ");
						}
					} catch (NumberFormatException e) {
						System.out.println(" 잘못된 번호입니다. ");
					}

				} else if (menu == 2) { // 회원 목록 출력

					ArrayList list = dao.selectAll();

					System.out.println("ID\t등급\t닉네임\t가입일\t포인트");
					for (Object std : list) {
						System.out.println(std);
					}

				} else if (menu == 3) { // 회원 정보 검색
					System.out.println("1. ID로 검색");
					System.out.println("1. 닉네임으로 검색");
					String user = sc.nextLine();
					if (user.equals("1")) {
						System.out.print(" 검색할 ID 입력 : ");
						System.out.println("ID\t등급\t닉네임\t가입일\t포인트");
						String id = sc.nextLine();

						dao.idFinds(id);
					} else if (user.equals("2")) {
						System.out.print(" 검색할 닉네입 입력 : ");
						String nick = sc.nextLine();
						System.out.println("ID\t등급\t닉네임\t가입일\t포인트");
						dao.nickFinds(nick);
					} else {
						System.out.println(" 잘못된 번호입니다. ");
					}

				} else if (menu == 4) { // 회원 정보 수정
					System.out.print(" 수정할 회원의 ID 입력 : ");
					String id = sc.nextLine();
					System.out.print(" 수정할 닉네임 : ");
					String nick = sc.nextLine();
					System.out.print(" 수정할 포인트 : ");
					int point = Integer.parseInt(sc.nextLine());

					MembershipDTO all = new MembershipDTO(id, nick, point);

					dao.modify(all);

					System.out.println(" 변경이 완료되었습니다. ");

				} else if (menu == 5) { // 회원 정보 삭제
					ArrayList list = dao.selectAll();

					System.out.println("ID\t등급\t닉네임\t가입일\t포인트");
					for (Object std : list) {
						System.out.println(std);
					}
					System.out.print("\n 삭제할 회원의 ID 입력 : ");
					String id = sc.nextLine();

					dao.delet(id);

				} else if (menu == 6) {
					System.out.println(" 프로그램을 종료합니다. ");
					break;
				} else {
					System.out.println(" 메뉴 번호를 입력해주세요.");
					continue;
				}
			} catch (Exception e) {
				System.out.println(" 메뉴를 다시 입력해주세요. ");
				continue;
			}

		}

	}
}
