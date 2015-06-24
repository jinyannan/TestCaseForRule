package org.antlr.ext.TestCase;

import java.util.ArrayList;

public class Dog {
	public int age;
	public String name;
	public Leg dogLeg;
	public String getName() {
		return "name";
	}
	public int getInt() {
		return 10;
	}
	public ArrayList<String> getEyes() {
		return new ArrayList<String>();
	}
	public String getAge(){
		return "";
	}
	public Integer getAge(Integer age){
		return age;
	}
	public String getAge(String age){
		return age;
	}
	public Boolean getAge(int age1, int age2){
		return true;
	}
	
	public String getAge(int age1, String age2){
		return age2;
	}
}
