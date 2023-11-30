package app.asset.weapon;

/*
 * 剣インスタンスの雛形となるクラス
 * ステータスとして名前、攻撃力を持つ
 */

public class Sword {
	public String name;
	public int atk;

	public Sword(String name, int atk) {
		this.name = name;
		this.atk = atk;
	}

	public Sword(String name) {
		this(name, 10);
	}

	public Sword() {
		this("木の剣", 10);
	}
}
