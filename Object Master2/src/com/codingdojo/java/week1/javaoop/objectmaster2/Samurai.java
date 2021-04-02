package com.codingdojo.java.week1.javaoop.objectmaster2;

public class Samurai extends Human {
	int samuraiCount = 0;
	
	public Samurai() {
		this.health = 200;
		samuraiCount +=1;
	}
	public Samurai(String name) {
		this.health = 200;
		this.name = name;
		samuraiCount +=1;
	}
	public void deathBlow(Human human) {
		human.setHealth(human.getHealth()-human.getHealth());
		this.setHealth(this.getHealth()/2);
		System.out.println("HWWWAAAAHHHHHHH");
	}
	public void meditate() {
		this.setHealth(this.getHealth()+(this.getHealth()/2));
		System.out.println("MMMMMM");
	}
	public int howMany() {
		System.out.println(samuraiCount);
		return samuraiCount;
	}
}
