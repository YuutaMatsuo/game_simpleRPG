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
		this(name, 500, 30, 50);
	}
	
	public void showStatus() {
		System.out.println("=====================");
		System.out.println("名前: " + this.name);
		System.out.println("HP: " + this.hp);
		System.out.println("MP: " + this.mp);
		System.out.println("ATK: " + this.atk);
		System.out.println("=====================");
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
