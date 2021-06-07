package com.tradeledger.cards.model;

import java.util.Set;

public class Eligibility {

	private Set<String> eligibleCards;

	public Eligibility(Set<String> eligibleCards) {
		this.eligibleCards = eligibleCards;
	}

	public Eligibility() {
		super();
	}

	public Set<String> getEligibleCards() {
		return eligibleCards;
	}

	public void setEligibleCards(Set<String> eligibleCards) {
		this.eligibleCards = eligibleCards;
	}
}
