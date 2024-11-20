package com.btcag.bootcamp.Enums;

public enum Attributes {
	HP("Health Points", "HP"),
	EP("Energy Points", "EP"),
	AR("Attack Range", "AR"),
	BD("Base Damage", "BD"),
	MS("Movement Speed", "MS"),
	AS("Armor Score", "AS"),
	DM("Damage Mod.", "DM"),
	AB("Acc. Bonus", "AB"),
	AP("Attribute Points", "AP");

	private final String longForm;
	private final String shortForm;

	// Constructor
	Attributes(String longForm, String shortForm) {
		this.longForm = longForm;
		this.shortForm = shortForm;
	}

	// Getter for long form
	public String getLongForm() {
		return longForm;
	}

	// Getter for short form
	public String getShortForm() {
		return shortForm;
	}

	// Override toString for readable output
	@Override
	public String toString() {
		return shortForm + " (" + longForm + ")";
	}
}
