package com.tradeledger.cards.common;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public final class Applicant {

	@NotEmpty
	private String name;
	
	@NotEmpty
	private String address;
	
	@NotEmpty
	private String email;
	
	public Applicant() {}
	
	public Applicant(String name, String email, String address) {
		
		this.name = name;
		this.email = email;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public String getEmail() {
		return email;
	}
	
}
