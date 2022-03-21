package com.netflix.dto;

public class Basic extends MembershipDTO {

	public Basic() {
		super();
	}

	public Basic(String id, String nickname, String signup_date, int point, String member) {
		super(id, nickname, signup_date, point, member);
	}
	
	public String getMembership() {
		return "Basic";
	}
}
