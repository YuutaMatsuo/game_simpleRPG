package app.asset.character;

import app.table.heroStatusTable;

/*
 * 勇者インスタンスの雛形となる抽象クラス
 * 勇者に共通するメンバを定義する
 */

public abstract class Human extends Character {
	private int maxHp;
	private int exp;
	private int nextExp;
	private static int gold;
	private boolean debugMode;

	// コンストラクタ
	public Human(String name, int level, int hp, int maxHp, int mp, int atk, int def, int exp) {
		super(name, level, hp, mp, atk, def);
		this.maxHp = maxHp;
		this.nextExp = exp;
		this.gold = 500;
		this.debugMode = true;
	}

	// 攻撃処理 オーバーライド
	protected void attack(Character[] chara) {
		battleMessage();
		super.attack(chara);
	}

	// 戦闘中のメッセージ 防御時
	public String battleMessage(int damage) {
		return super.getName() + "は" + damage + "のダメージを受けた";
	}

	// 死んでしまった際のメッセージ
	public String resultMessage() {
		return super.getName() + "は死んでしまった";
	}

	// 経験値を増やす処理
	public void addExp(int exp) {
		this.exp += exp;
		System.out.println(super.getName() + "は" + exp + "の経験値を獲得しました！");
	}

	// ゴールドを増やす処理
	public void addGold(int gold) {
		Human.gold += gold;
		System.out.println(super.getName() + "は" + gold + "のゴールドを入手しました！");
	}

	// 経験値が次のレベルアップに必要な量を超えているかチェックする
	public boolean isLevelUp() {
		if (super.getLevel() + 1 == heroStatusTable.MAX_LEVEL) {
			System.out.println(super.getName() + "はレベルの上限に達した為、経験値を受け取ることが出来ませんでした。");
			return false;
		}
		return exp > nextExp;
	}

	// レベルアップ処理
	public abstract void LevelUp();

	// デバッグモードかチェックする
	public boolean isDebugMode() {
		return this.debugMode;
	}

	protected void setMaxHp(int maxHp) {
		this.maxHp = maxHp;
	}

	protected void setNextExp(int nextExp) {
		this.nextExp = nextExp;
	}
}
