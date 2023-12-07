package app.asset.character;

/*
 * モンスターインスタンスの雛形となるクラス
 * ステータスとして名前、HP、ATKを持つ
 */

public class Monster {
	private String name;
	private int hp;
	private int atk;
	private int def;
	private int exp;
	private int gold;
	private int level;

	// モンスターのインスタンスを生成する際は、MonsterTableを参照して引数を渡す
	// 必ず４つすべての要素を引数に渡す
	public Monster(String name, int hp, int atk, int def, int exp, int gold) {
		this.name = name;
		this.hp = hp;
		this.atk = atk;
		this.def = def;
		this.exp = exp;
		this.gold = gold;
	}
	// モンスターの攻撃メソッド
	public void attack(Hero h, boolean def) {
		int damage = 0;
		if (!def) {
			damage = (int) (this.atk * 0.5) - (int) (h.def * 0.25);
			if (damage < 0) {
				damage = 0;
			}
		} else {
			damage = (int) (this.atk * 0.5) - (int) (h.def * 0.5);
			if (damage < 0) {
				damage = 0;
				System.out.println("勇者達は身を守っている！（防御力２倍）");
			}
		}
		System.out.println(this.name + "のこうげき！");
		System.out.println(h.name + "に" + damage + "のダメージ！");
		h.hp -= damage;

	}
	// モンスターのステータスを表示するメソッド
	public void showStatus() {
		System.out.println("HP: " + this.hp);
		System.out.println("ATK: " + this.atk);
		System.out.println("DEF: " + this.def);
		System.out.println();
	}
	//	モンスターのステータスを表示するメソッド  Name表示あり
	public void showAllStatus() {
		System.out.println("Lv." + (this.level + 1) + " " + this.name);
		System.out.println("HP: " + this.hp);
		System.out.println("ATK: " + this.atk);
		System.out.println("DEF: " + this.def);
		System.out.println();
	}
	//	モンスターが生きているかチェックするメソッド　生存していればTrueを返す
	public boolean isAlive() {
		return this.hp > 0;
	}
}
