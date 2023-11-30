package app.utility;

import app.asset.character.Hero;
import app.asset.character.Monster;
import app.table.MonsterTable;

/*
 * バトルに関する処理をまとめたクラス
 * インスタンスを持たないstaticクラス
 */

public class BattleUtil {

	// 引数として受け取った数のモンスターのインスタンスを作成し
	// 配列に格納して戻り値として返す
	public static Monster[] popMonster(int num) {
		Monster[] monsters = new Monster[num];
		Monster monster;
		int r;
		for (int i = 0; i < num; i++) {
			r = Util.random.nextInt(MonsterTable.monsterName.length);
			monsters[i] = new Monster(MonsterTable.monsterName[r], MonsterTable.monsterStatus[r][0],
					MonsterTable.monsterStatus[r][1]);
		}
		return monsters;
	}

	// 引数として受け取ったヒーローとモンスターの配列を元に
	// ランダムに攻撃を行う
	// ヒーローからモンスターへ攻撃
	public static void attak(Hero[] h, Monster[] m) {
		int r;
		for (Hero hero : h) {
			do {
				r = Util.random.nextInt(m.length);
			} while (m[r].isAlive() == false);
			if (hero.isAlive() == false) {
				continue;
			}
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
			do {
				r = Util.random.nextInt(h.length);
			} while (h[r].isAlive() == false);
			if (monster.isAlive() == false) {
				continue;
			}
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
		return true;
	}

	// モンスターの残りHPを表示
	public static void showMonsterHp(Monster[] m) {
		for (Monster monster : m) {
			if (monster.isAlive() == false) {
				continue;
			}
			System.out.println(monster.name + " HP:" + monster.hp);
			ViewUtil.scrollSlow(2);
		}
	}
	
	//ヒーローの残りHPを表示
	public static void showHeroHp(Hero[] h) {
		for (Hero hero : h) {
			if (hero.isAlive() == false) {
				continue;
			}
			System.out.println(hero.name + "HP:" + hero.hp);
			ViewUtil.scrollSlow(2);
		}
	}
}
