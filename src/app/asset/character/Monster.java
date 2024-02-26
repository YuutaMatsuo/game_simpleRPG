package app.asset.character;

/*
 * モンスターインスタンスの雛形となるクラス
 */

public class Monster extends Character {
	private int exp;
	private int gold;

	// モンスターのインスタンスを生成する際は、MonsterTableを参照して引数を渡す
	// 必ず４つすべての要素を引数に渡す
	public Monster(String name, int level, int hp, int atk, int def, int exp, int gold) {
		super(name, level, hp, 50, atk, def);
		this.exp = exp;
		this.gold = gold;
	}
	
	// 攻撃処理 オーバーライド
	public void attack(Character[] chara) {
		super.attack(chara);
	}

	// 戦闘中のメッセージ 防御時
	public String battleMessage(int damage) {
		return super.getName() + "に" + damage + "のダメージ！";
	}
	
	// 倒した際のメッセージ
	public String resultMessage() {
		return super.getName() + "を倒した！";
	}

	public int getExp() {
		return exp;
	}

	public int getGold() {
		return gold;
	}
}
