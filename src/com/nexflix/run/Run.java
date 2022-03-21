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

			System.out.println(" **** Netflix ȸ�� ���� �ý��� **** ");
			System.out.println(" 1. �ű� ȸ�� ���");
			System.out.println(" 2. ȸ�� ��� ���");
			System.out.println(" 3. ȸ�� ���� �˻�");
			System.out.println(" 4. ȸ�� ���� ����");
			System.out.println(" 5. ȸ�� ���� ����");
			System.out.println(" 6. �ý��� ����");
			System.out.print(" >> ");
			try {
				int menu = Integer.parseInt(sc.nextLine());

				if (menu == 1) { // �ű� ���
					System.out.println(" ȸ�� ��� ���� ");
					System.out.println(" 1. Basic");
					System.out.println(" 2. Standard");
					System.out.println(" 3. Premium");

					try {
						int membership = Integer.parseInt(sc.nextLine());
						if (membership == 1) {
							System.out.print(" �ű� ȸ�� ID(7�� �̳�) : ");
							String id = sc.nextLine();
							System.out.print(" �ű� ȸ�� �г���(4�� �̳�) : ");
							String nickname = sc.nextLine();
							System.out.print(" �ű� ȸ�� ������(210505 ��������) : ");
							String signup_date = sc.nextLine();
							System.out.print(" �ű� ȸ�� ����Ʈ : ");
							int point = Integer.parseInt(sc.nextLine());

							MembershipDTO all = new MembershipDTO(id, nickname, signup_date, point, ba.getMembership());

							dao.insert(all);

						} else if (membership == 2) {
							System.out.print(" �ű� ȸ�� ID(7�� �̳�) : ");
							String id = sc.nextLine();
							if (dao.idSerch(id)) {
								System.out.println(" �ߺ��� ���̵� �Դϴ�.");
							}
							
							System.out.print(" �ű� ȸ�� �г���(4�� �̳�) : ");
							String nickname = sc.nextLine();
							if (dao.nickSerch(nickname)) {
								System.out.println(" �ߺ��� �г��� �Դϴ�. ");
							}
							
							System.out.print(" �ű� ȸ�� ������(210505 ��������) : ");
							String signup_date = sc.nextLine();
							System.out.print(" �ű� ȸ�� ����Ʈ : ");
							int point = Integer.parseInt(sc.nextLine());
							MembershipDTO all = new MembershipDTO(id, nickname, signup_date, point, st.getMembership());
							dao.insert(all);

						} else if (membership == 3) {
							System.out.print(" �ű� ȸ�� ID(7�� �̳�) : ");
							String id = sc.nextLine();
							System.out.print(" �ű� ȸ�� �г���(4�� �̳�) : ");
							String nickname = sc.nextLine();
							System.out.print(" �ű� ȸ�� ������(210505 ��������) : ");
							String signup_date = sc.nextLine();
							System.out.print(" �ű� ȸ�� ����Ʈ : ");
							int point = Integer.parseInt(sc.nextLine());
							MembershipDTO all = new MembershipDTO(id, nickname, signup_date, point, pr.getMembership());
							dao.insert(all);
						} else {
							System.out.println(" �߸��� ��ȣ�Դϴ�. ");
						}
					} catch (NumberFormatException e) {
						System.out.println(" �߸��� ��ȣ�Դϴ�. ");
					}

				} else if (menu == 2) { // ȸ�� ��� ���

					ArrayList list = dao.selectAll();

					System.out.println("ID\t���\t�г���\t������\t����Ʈ");
					for (Object std : list) {
						System.out.println(std);
					}

				} else if (menu == 3) { // ȸ�� ���� �˻�
					System.out.println("1. ID�� �˻�");
					System.out.println("1. �г������� �˻�");
					String user = sc.nextLine();
					if (user.equals("1")) {
						System.out.print(" �˻��� ID �Է� : ");
						System.out.println("ID\t���\t�г���\t������\t����Ʈ");
						String id = sc.nextLine();

						dao.idFinds(id);
					} else if (user.equals("2")) {
						System.out.print(" �˻��� �г��� �Է� : ");
						String nick = sc.nextLine();
						System.out.println("ID\t���\t�г���\t������\t����Ʈ");
						dao.nickFinds(nick);
					} else {
						System.out.println(" �߸��� ��ȣ�Դϴ�. ");
					}

				} else if (menu == 4) { // ȸ�� ���� ����
					System.out.print(" ������ ȸ���� ID �Է� : ");
					String id = sc.nextLine();
					System.out.print(" ������ �г��� : ");
					String nick = sc.nextLine();
					System.out.print(" ������ ����Ʈ : ");
					int point = Integer.parseInt(sc.nextLine());

					MembershipDTO all = new MembershipDTO(id, nick, point);

					dao.modify(all);

					System.out.println(" ������ �Ϸ�Ǿ����ϴ�. ");

				} else if (menu == 5) { // ȸ�� ���� ����
					ArrayList list = dao.selectAll();

					System.out.println("ID\t���\t�г���\t������\t����Ʈ");
					for (Object std : list) {
						System.out.println(std);
					}
					System.out.print("\n ������ ȸ���� ID �Է� : ");
					String id = sc.nextLine();

					dao.delet(id);

				} else if (menu == 6) {
					System.out.println(" ���α׷��� �����մϴ�. ");
					break;
				} else {
					System.out.println(" �޴� ��ȣ�� �Է����ּ���.");
					continue;
				}
			} catch (Exception e) {
				System.out.println(" �޴��� �ٽ� �Է����ּ���. ");
				continue;
			}

		}

	}
}
