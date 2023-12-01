package app.model;

import app.asset.character.Hero;
import app.asset.character.Monster;
import app.table.MonsterTable;
import app.table.heroStatusTable;
import app.utility.Util;
import app.utility.ViewUtil;

/*
 * バトルに関する共有したい処理をまとめたクラス
 * インスタンスを持たない
 */

public class Battle {

	// 引数として受け取った数のモンスターのインスタンスを作成し
	// 配列に格納して戻り値として返す
	public static Monster[] popMonster(int num) {
		Monster[] monsters = new Monster[num];
		Monster monster;
		int r;
		for (int i = 0; i < num; i++) {
			r = Util.random.nextInt(MonsterTable.monsterName.length);
			monsters[i] = new Monster(MonsterTable.monsterName[r], MonsterTable.monsterStatus[r][0],
					MonsterTable.monsterStatus[r][1], MonsterTable.monsterStatus[r][2],MonsterTable.monsterStatus[r][3]);
		}
		return monsters;
	}

	// 引数として受け取ったヒーローとモンスターの配列を元に
	// ランダムに攻撃を行う
	// ヒーローからモンスターへ攻撃
	public static void attak(Hero[] h, Monster[] m) {
		int r;
		for (Hero hero : h) {
			if (hero.isAlive() == false) {
				continue;
			}
			if (Battle.isAllDead(m)) {
				continue;
			}
			do {
				r = Util.random.nextInt(m.length);
			} while (m[r].isAlive() == false);
			hero.attack(m[r]);
			ViewUtil.scrollSlow(2);
		}
	}

	// 引数として受け取ったモンスターとヒーローの配列を元に
	// ランダムに攻撃を行う
	// モンスターからヒーロへ攻撃
	public static void attak(Monster[] m, Hero[] h) {
		int r;
		for (Monster monster : m) {
			if (monster.isAlive() == false) {
				continue;
			}
			if (Battle.isAllDead(h)) {
				continue;
			}
			do {
				r = Util.random.nextInt(h.length);
			} while (h[r].isAlive() == false);
			monster.attack(h[r]);
			ViewUtil.scrollSlow(2);
		}
	}

	// ヒーローが全滅したかどうかを判定する
	public static boolean isAllDead(Hero[] h) {
		for (Hero hero : h) {
			if (hero.isAlive()) {
				return false;
			}
		}
		return true;
	}

	// モンスターが全滅したかどうかを判定する
	public static boolean isAllDead(Monster[] m) {
		for (int i = 0; i < m.length; i++) {
			if (m[i].isAlive()) {
				return false;
			}
		}
		m = null;
		return true;
	}

	// モンスターの残りHPを表示
	public static void showMonsterHp(Monster[] m) {
		for (Monster monster : m) {
			if (monster.isAlive() == false) {
				continue;
			}
//			System.out.println("♦" + monster.name + " HP:" + monster.hp);
			monster.showAllStatus();
		}
	}

	// ヒーローの残りHPを表示
	public static void showHeroHp(Hero[] h) {
		for (Hero hero : h) {
			if (hero.isAlive() == false) {
				continue;
			}
			System.out.println(hero.name + "HP:" + hero.hp);
		}
	}
	
	// モンスターの配列を受け取り１体ずつ表示
	public static void showMonster(Monster[] monsters) {
		for (Monster m : monsters) {
			System.out.println(m.name + "が現れた!");
			m.showStatus();
			ViewUtil.wait(1);
		}
		ViewUtil.scrollSlow(2);
	}
	
	// モンスターの合計経験値を計算し戻り値として返す
		public static int totalGold(Monster[] monsters) {
			int gold = 0;
			for(Monster m : monsters) {
				exp += m.exp;
			}
			return exp;
		}
	
	// モンスターの合計経験値を計算し戻り値として返す
	public static int totalExp(Monster[] monsters) {
		int exp = 0;
		for(Monster m : monsters) {
			exp += m.exp;
		}
		return exp;
	}
	
	//　ヒーローの経験値を増やすメソッド
	public static void addExp(Hero[] heros, int exp) {
		for (Hero h : heros) {
			h.exp += exp;
			System.out.println(h.name + "は" + exp + "の経験値を獲得しました！");
		}
	}
	
	//　ヒーローの配列を受け取り、レベルアップの条件を満たしていたらステータステーブルを参照してレベルアップを行う
	public static void LevelUp(Hero[] heros) {
		for (Hero hero : heros) {
			if (hero.debugMode) {
				System.out.println("デバッグモードの為" + hero.name + "のレベルアップ処理をスキップします");
				continue;
			}
			if (hero.isLevelUp()) {
				hero.level += 1;
				hero.hp = heroStatusTable.heroStatusMaster[0][hero.level - 1][0];
				hero.maxHp = heroStatusTable.heroStatusMaster[0][hero.level - 1][0];
				hero.mp = heroStatusTable.heroStatusMaster[0][hero.level - 1][1];
				hero.atk = heroStatusTable.heroStatusMaster[0][hero.level - 1][2];
				hero.def = heroStatusTable.heroStatusMaster[0][hero.level - 1][3];
				hero.nextExp = heroStatusTable.heroStatusMaster[0][hero.level - 1][4];

				System.out.println(hero.name + "は Lv." + hero.level + "にレベルアップしました！");
			}
		}
	}
}
