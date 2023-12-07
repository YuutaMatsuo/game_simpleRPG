 package app.asset.character;

import app.table.heroStatusTable;
/*
 * ヒーローインスタンスの雛形となるクラス
 * ステータスとして名前、HP、MP、ATKを持つ
 */

public class Hero {
	public String name;
	public int job; // 0.勇者 1.戦士 2.魔法使い
	public int level;
	public int hp;
	public int maxHp;
	public int mp;
	public int atk;
	public int def;
	public int exp;
	public int nextExp;
	public static int gold;
	public boolean debugMode = false;
	
	//コンストラクタ
	public Hero(String name, int job, int level, int hp, int maxHp, int mp, int atk, int def, int exp) {
		this.name = name;
		this.job = job;
		this.level = level;
		this.hp = hp;
		this.maxHp = maxHp;
		this.mp = mp;
		this.atk = atk;
		this.def = def;
		this.nextExp = exp;
		this.gold = 500;
	}

	public Hero(String name, int job) {
		this.name = name;
		this.job = job;
		this.level = 1;
		this.hp = heroStatusTable.heroStatusMaster[job][1][0];
		this.maxHp = heroStatusTable.heroStatusMaster[job][1][0];
		this.mp = heroStatusTable.heroStatusMaster[job][1][1];
		this.atk = heroStatusTable.heroStatusMaster[job][1][2];
		this.def = heroStatusTable.heroStatusMaster[job][1][3];
		this.nextExp = heroStatusTable.heroStatusMaster[job][1][4];
		this.gold = 500;
	}
	//ステータスを表示する
	public void showStatus() {
		System.out.println("=====================");
		System.out.println("名前: " + this.name);
		System.out.println("HP: " + this.hp);
		System.out.println("MP: " + this.mp);
		System.out.println("ATK: " + this.atk);
		System.out.println("DEF: " + this.def);
		System.out.println("=====================");
	}
	//モンスターへの攻撃 計算式は ヒーローの攻撃力の50% - モンスターの防御力の25% で計算
	public void attack(Monster m) {
		int damage = (int) (this.atk * 0.5) - (int) (m.def * 0.25);
		if (damage < 0) {
			damage = 0;
		}
		System.out.println(this.name + "は攻撃した！");
		System.out.println(m.name + "に" + damage + "ポイントのダメージを与えた！");
		m.hp -= damage;
	}
	//　経験値が次のレベルアップに必要な量を超えているかチェックする
	public boolean isLevelUp() {
		if (this.level == heroStatusTable.MAX_LEVEL) {
			System.out.println(this.name + "はレベルの上限に達した為、経験値を受け取ることが出来ませんでした。");
			return false;
		}
		return exp > nextExp;
	}
	// ヒーローが生きているか確認する 生存していたらTrueが戻り地として返される
	public boolean isAlive() {
		boolean alive = this.hp > 0;
		if(!alive) {
			this.hp = 0;
		}
		return alive;
	}
	// デバッグモードかチェックする 
	public boolean isDebugMode() {
		return this.debugMode;
	}

}
