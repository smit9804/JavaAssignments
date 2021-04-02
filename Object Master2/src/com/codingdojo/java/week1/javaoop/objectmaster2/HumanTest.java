package com.codingdojo.java.week1.javaoop.objectmaster2;

public class HumanTest {

	public static void main(String[] args) {
		Human human1 = new Human("Donald Trump");
		Human human2 = new Human("Lincoln Riley");
		Human human3 = new Human("Nick Saban");
		Wizard wizard1 = new Wizard("Bernie Sanders");
		Wizard wizard2 = new Wizard("Willie Nelson");
		Wizard wizard3 = new Wizard("Betty White");
		Ninja ninja1 = new Ninja("Miller Lite");
		Ninja ninja2 = new Ninja("White Claw");
		Ninja ninja3 = new Ninja("Jack Daniels");
		Samurai samurai1 = new Samurai("Madi");
		Samurai samurai2 = new Samurai("Ashley");
		Samurai samurai3 = new Samurai("Emily");
		
		human1.attack(wizard1);
		human2.attack(human3);
		wizard2.fireball(ninja3);
		samurai1.deathBlow(wizard3);
		samurai3.howMany();
		

	}

}
