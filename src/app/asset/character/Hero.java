package app.asset.character;

import app.asset.weapon.Sword;

/*
 * ヒーローインスタンスの雛形となるクラス
 * ステータスとして名前、HP、MP、ATKを持つ
 */

public class Hero {
	public String name;
	public int hp;
	public int mp;
	public int atk;
	public int def;
	Sword sword;

	public Hero(String name, int hp, int mp, int atk, int def) {
		this.name = name;
		this.hp = hp;
		this.mp = mp;
		this.atk = atk;
		this.def = def;
	}

	public Hero(String name, int hp, int mp, int atk) {
		this(name, hp, mp, atk, 10);
	}

	public Hero(String name, int hp, int mp) {
		this(name, hp, mp, 20, 10);
	}

	public Hero(String name, int hp) {
		this(name, hp, 30, 20, 10);
	}

	public Hero(String name) {
		this(name, 100, 30, 20, 10);
	}

	public void showStatus() {
		System.out.println("=====================");
		System.out.println("名前: " + this.name);
		System.out.println("HP: " + this.hp);
		System.out.println("MP: " + this.mp);
		System.out.println("ATK: " + this.atk);
		System.out.println("DEF: " + this.def);
		System.out.println("=====================");
	}

	public void attack(Monster m) {
		int damage = this.atk - m.def;
		if (damage < 0) {
			damage = 0;
		}
		System.out.println(this.name + "は攻撃した！");
		System.out.println(m.name + "に" + damage + "ポイントのダメージを与えた！");
		m.hp -= damage;
	}

	public boolean isAlive() {
		return this.hp > 0;
	}

}
