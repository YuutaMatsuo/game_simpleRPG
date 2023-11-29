package app.asset.character;

/*
 * モンスターインスタンスの雛形となるクラス
 * ステータスとして名前、HP、ATKを持つ
 */

public class Monster {
	public String name;
	public int hp;
	public int atk;

	public Monster(String name, int hp, int atk) {
		this.name = name;
		this.hp = hp;
		this.atk = atk;
	}

	public Monster(String name, int hp) {
		this(name, hp, 10);
	}

	public Monster(String name) {
		this(name, 100, 10);
	}

	public void attack(Hero h) {
		System.out.println(this.name + "は攻撃した！");
		System.out.println(h.name + "に" + this.atk + "ポイントのダメージを与えた！");
		h.hp -= this.atk;
	}
	
	public boolean isAlive() {
		return this.hp > 0;
	}
}
