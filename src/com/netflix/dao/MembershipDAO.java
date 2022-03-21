package com.netflix.dao;

import java.util.ArrayList;

import com.netflix.dto.MembershipDTO;

public class MembershipDAO {

	private ArrayList<Object> memList = new ArrayList<>();
	private MembershipDTO dto = new MembershipDTO();

	public void insert(MembershipDTO mbs) {
		memList.add(mbs);
	}

	public ArrayList selectAll() { // ��ü���
		return memList;
	}

	public void idFinds(String id) { // �����˻� ���̵�
		for (int i = 0; i < memList.size(); i++) {
			if (((MembershipDTO) memList.get(i)).getId().equals(id)) {
				System.out.println(memList.get(i));
				break;
			} 
		}
	}

	public void nickFinds(String nick) { // �����˻� �г���
		for (int i = 0; i < memList.size(); i++) {
			if (((MembershipDTO) memList.get(i)).getNickname().equals(nick)) {
				System.out.println(memList.get(i));
				break;
			}
		}
	}

	public void modify(MembershipDTO mao) {
		for (int i = 0; i < memList.size(); i++) {
			if (((MembershipDTO) memList.get(i)).getId() == mao.getId()) {
				((MembershipDTO) memList.get(i)).setNickname(mao.getNickname());
				((MembershipDTO) memList.get(i)).setPoint(mao.getPoint());
				break;
			}
		}
	}

	public void delet(String id) {
		for (int i = 0; i < memList.size(); i++) {
			if (((MembershipDTO) memList.get(i)).getId().equals(id)) {
				memList.remove(i);
			}
		}
	}

	public  boolean idSerch(String id) {
		boolean f = false;
		for (int i = 0; i < memList.size(); i++) {
			if (((MembershipDTO) memList.get(i)).getId() == id) {
				f = true;
			}
		} return f; 
	}
	
	public boolean nickSerch(String nick) {
		boolean f = false;
		for (int i = 0; i < memList.size(); i++) {
			if (((MembershipDTO) memList.get(i)).getId() == nick) {
				f = true;
			}
		} return f;
	}
	
}
