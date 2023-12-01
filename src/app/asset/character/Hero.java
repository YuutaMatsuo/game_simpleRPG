package app.asset.character;

import app.asset.weapon.Sword;

/*
 * ヒーローインスタンスの雛形となるクラス
 * ステータスとして名前、HP、MP、ATKを持つ
 */

public class Hero {
	public String name;
	public int level;
	public int hp;
	public int maxHp;
	public int mp;
	public int atk;
	public int def;
	public int exp;
	static int gold;

	Sword sword;

	public Hero(String name, int level, int hp, int maxHp, int mp, int atk, int def, int exp) {
		this.name = name;
		this.level = level;
		this.hp = hp;
		this.maxHp = maxHp;
		this.mp = mp;
		this.atk = atk;
		this.def = def;
		this.exp = exp;
		this.gold = 500;
	}

	public Hero(String name) {
		this(name, 1, 100, 100, 10, 10, 10, 0);
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
