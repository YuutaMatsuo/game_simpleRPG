package app.asset.character;

import java.util.Random;

import app.logic.Battle;
import app.view.View;

/*
 * 雛形となる抽象クラス
 * 勇者とモンスターに共通するメンバを定義する
 */

public abstract class Character {
	private String name;
	private int level;
	private int hp;
	private int mp;
	private int atk;
	private int def;

	public Character(String name, int level, int hp, int mp, int atk, int def) {
		this.name = name;
		this.level = level;
		this.hp = hp;
		this.mp = mp;
		this.atk = atk;
		this.def = def;
	}

	// 攻撃処理
	protected void attack(Character[] chara) {
		int damage = (int) (this.atk * 0.5);
		int random;
		while (true) {
			if (this.isAlive() == false) {
				break;
			}
			if (Battle.isAllDead(chara)) {
				break;
			}
			do {
				random = new Random().nextInt(chara.length);
			} while (chara[random].isAlive() == false);
			this.battleMessage();
			chara[random].defence(damage);
			View.scrollSlow(2);
			break;
		}
	}

	// 防御処理
	protected void defence(int damage) {
		int reductionDamage = damage - (int) (this.def * 0.25);
		if (this.hp < reductionDamage) {
			this.hp = 0;
			System.out.println(resultMessage());
		} else {
			this.hp -= reductionDamage;
			System.out.println(battleMessage(reductionDamage));
		}
	}

	// 戦闘中のメッセージ 攻撃時
	public void battleMessage() {
		System.out.println(this.name + "のこうげき！");
	}

	// 戦闘中のメッセージ 防御時
	protected abstract String battleMessage(int damage);

	// 死んでしまった際のメッセージ
	public abstract String resultMessage();

	// 生存していたらTrueが戻り地として返される
	public boolean isAlive() {
		boolean alive = this.hp > 0;
		if (!alive) {
			this.hp = 0;
		}
		return alive;
	}

	// 自身のインスタンスのステータスを表示 オーバーライド
	public String toString() {
		return "Lv." + (this.level + 1) + " " + this.name + "\nHP: " + this.hp + "\nMP: " + this.mp;
	}

	// 残りHPを表示
	public void showHp() {
		System.out.println("Lv." + (this.level + 1) + " " + this.name);
		System.out.println("HP: " + this.hp);
	}
	
	// 自身のインスタンス

	public String getName() {
		return name;
	}

	public int getLevel() {
		return level;
	}

	protected void setName(String name) {
		this.name = name;
	}

	protected void setLevel(int level) {
		this.level = level;
	}

	protected void setHp(int hp) {
		this.hp = hp;
	}

	protected void setMp(int mp) {
		this.mp = mp;
	}

	protected void setAtk(int atk) {
		this.atk = atk;
	}

	protected void setDef(int def) {
		this.def = def;
	}

	public int getHp() {
		return hp;
	}

	public int getMp() {
		return mp;
	}
}
