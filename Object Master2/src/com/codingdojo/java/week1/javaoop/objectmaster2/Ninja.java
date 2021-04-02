package com.codingdojo.java.week1.javaoop.objectmaster2;

public class Ninja extends Human {
	public Ninja() {
		this.stealth = 10;
	}
	public Ninja(String name) {
		this.stealth = 10;
		this.name = name;
	}
	public void steal(Human human) {
		human.setHealth(human.getHealth()-stealth);
		System.out.println("Swiper done did his swiping!");
		System.out.println(human.getName() + "'s health decreased by " + this.stealth + ".");
	}
	public void runAway() {
		this.setHealth (-10);
	}
	
}
