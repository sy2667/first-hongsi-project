package com.netflix.dto;

public class Premium extends MembershipDTO{

	public Premium() {
		super();
	}

	public Premium(String id, String nickname, String signup_date, int point, String member) {
		super(id, nickname, signup_date, point,member);
	}

	public String getMembership() {
		return "Premium";
	}
	
}
