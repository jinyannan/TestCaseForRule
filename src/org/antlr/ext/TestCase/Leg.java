package org.antlr.ext.TestCase;

public class Leg {
	public String hairColor = "";
	
	public Leg(String hairColor) {
		super();
		this.hairColor = hairColor;
	}
	{
		hairColor = "red";
	}
	public Integer getLegs(){
		return 4;
	}
}
