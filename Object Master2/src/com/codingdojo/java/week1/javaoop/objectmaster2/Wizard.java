package com.codingdojo.java.week1.javaoop.objectmaster2;

public class Wizard extends Human{
	public Wizard() {
		this.health = 50;
		this.intelligence = 8;
	}
	public Wizard(String name) {
		this.health = 50;
		this.intelligence = 8;
		this.name = name;
	}
	public void heal(Human human) {
		human.setHealth(human.getHealth()+intelligence);
		System.out.println("Here, have a beer to replenish your health!");
		System.out.println(human.getName() + "'s health was replinished by " + this.intelligence + ".");
		
	}
	public void fireball(Human human) {
		human.setHealth(human.getHealth()-(intelligence*3));
		System.out.println("Feel the BERN!!!!!");
		System.out.println(human.getName() + "'s health decreased by " + intelligence*3 + ".");
	}
}
