package com.devcookhome.model;

public class Group{
	private String name;

	public String toString(){
		return "Group: " + name;
	}

	public String sayName(){
		return "My name " + name;
	}

	public static void main(String[] args) {

		Group g = new Group();
		g.name = "vegetal";

		System.out.println(g);
		System.out.println(g.sayName());

	}	

}