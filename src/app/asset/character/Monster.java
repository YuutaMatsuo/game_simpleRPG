package app.asset.character;

/*
 * モンスターインスタンスの雛形となるクラス
 * ステータスとして名前、HP、ATKを持つ
 */

public class Monster {
	public String name;
	public int hp;
	public int atk;
	public int def;

	// モンスターのインスタンスを生成する際は、MonsterTableを参照して引数を渡す
	// 必ず４つすべての要素を引数に渡す
	public Monster(String name, int hp, int atk, int def) {
		this.name = name;
		this.hp = hp;
		this.atk = atk;
		this.def = def;
	}

	public void attack(Hero h) {
			int damage = this.atk - h.def;
			if(damage < 0) {
				damage = 0;
			}
			System.out.println(this.name + "のこうげき！");
			System.out.println(h.name + "に" + damage + "のダメージ！");
			h.hp -= damage;
			System.out.println("テスト2");
	}
	
	public void showStatus() {
		System.out.println("HP: " + this.hp);
		System.out.println("ATK: " + this.atk);
		System.out.println("DEF: " + this.def);
		System.out.println();
	}
	
	public void showAllStatus() {
		System.out.println(this.name);
		System.out.println("HP: " + this.hp);
		System.out.println("ATK: " + this.atk);
		System.out.println("DEF: " + this.def);
		System.out.println();
	}

	public boolean isAlive() {
		return this.hp > 0;
	}
}
