package com.netflix.dto;

import com.netflix.dao.MembershipDAO;

public class MembershipDTO {
	
	private String id;
	private String nickname;
	private String signup_date;
	private int point;
	private String membership;
	
	
	
	public MembershipDTO() {}
	public MembershipDTO(String id, String nickname, String signup_date, int point, String member) {
		this.id = id;
		this.nickname = nickname;
		this.signup_date = signup_date;
		this.point = point;
		this.membership = member;
	}
	public MembershipDTO(String id, String nickname, int point) {
		this.id = id;
		this.nickname = nickname;
		this.point = point;
	}
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getSignup_date() {
		return signup_date;
	}
	public void setSignup_date(String signup_date) {
		this.signup_date = signup_date;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}

	public String toString() {
		return  id + "\t" + getMembership() + "\t" + nickname + "\t" + signup_date + "\t" + point;
	}
	
	public void setMembership (String member) {
		this.membership = member;
	}
	public String getMembership() {
		return membership;
	}
	
	
}
