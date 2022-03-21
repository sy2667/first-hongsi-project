package com.netflix.dto;

public class Standard extends MembershipDTO{

	public Standard() {
		super();
	}

	public Standard(String id, String nickname, String signup_date, int point, String member) {
		super(id, nickname, signup_date, point, member);
	}

	public String getMembership() {
		return "Stand";
	}
	
}
