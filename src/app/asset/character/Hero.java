package app.asset.character;

import app.asset.monster.Monster;
import app.asset.weapon.Sword;

public class Hero {
	public String name;
	public int hp;
	public int mp;
	public int atk;
	Sword sword;

	public Hero(String name, int hp, int mp, int atk) {
		this.name = name;
		this.hp = hp;
		this.mp = mp;
		this.atk = atk;
	}

	public Hero(String name, int hp, int mp) {
		this(name, hp, mp, 10);
	}

	public Hero(String name, int hp) {
		this(name, hp, 10, 10);
	}

	public Hero(String name) {
		this(name, 200, 30, 50);
	}

	public void attack(Monster m) {
		System.out.println(this.name + "は攻撃した！");
		System.out.println(m.name + "に" + this.atk + "ポイントのダメージを与えた！");
		m.hp -= this.atk;
	}
	
	public boolean isAlive() {
		return this.hp > 0;
	}

}
