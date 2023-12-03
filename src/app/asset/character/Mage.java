package app.asset.character;

import app.asset.weapon.Sword;
import app.table.heroStatusTable;

public class Mage {
	public String name;
	public int level;
	public int hp;
	public int maxHp;
	public int mp;
	public int atk;
	public int def;
	public int exp;
	public int nextExp;
	static int gold;
	public boolean debugMode = false;

	Sword sword;

	public Mage(String name, int level, int hp, int maxHp, int mp, int atk, int def, int exp) {
		this.name = name;
		this.level = level;
		this.hp = hp;
		this.maxHp = maxHp;
		this.mp = mp;
		this.atk = atk;
		this.def = def;
		this.nextExp = exp;
		this.gold = 500;
	}

	public Mage(String name) {
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

	public boolean isLevelUp() {
		if(this.level == heroStatusTable.MAX_LEVEL) {
			System.out.println(this.name + "はレベルの上限に達した為、経験値を受け取ることが出来ませんでした。");
			return false;
		}
		return exp > nextExp;
	}

	public boolean isAlive() {
		return this.hp > 0;
	}
}
