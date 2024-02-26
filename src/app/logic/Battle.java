package app.logic;

import java.util.Random;

import app.asset.character.Character;
import app.asset.character.Monster;
import app.table.MonsterStatusTable;
import app.view.View;

/*
 * バトルに関する共有したい処理をまとめたクラス
 * インスタンスを持たない
 */

public class Battle {

	// 引数として受け取った数のモンスターのインスタンスを作成し
	// 配列に格納して戻り値として返す
	public static Monster[] createMonster(int num, int level) {
		Monster[] monsters = new Monster[num];
		int random;
		int lv;
		for (int i = 0; i < num; i++) {
			random = new Random().nextInt(MonsterStatusTable.monsterName.length);
			do {
				lv = new Random().nextInt(level - 2, level + 2);
			} while (lv < 0);
			// モンスターテーブルを参照してランダムに1体モンスターのインスタンスを生成し配列 i 番目に格納
			monsters[i] = new Monster(MonsterStatusTable.monsterName[random], lv,
					MonsterStatusTable.monsterStatusMaster[random][lv][0], MonsterStatusTable.monsterStatusMaster[random][lv][1],
					MonsterStatusTable.monsterStatusMaster[random][lv][2], MonsterStatusTable.monsterStatusMaster[random][lv][3],
					MonsterStatusTable.monsterStatusMaster[random][lv][4]);
		}
		return monsters;
	}

	// 全滅したかどうかを判定する
	public static boolean isAllDead(Character[] c) {
		for (int i = 0; i < c.length; i++) {
			if (c[i].isAlive()) {
				return false;
			}
		}
		c = null;
		return true;
	}

	// モンスターの配列を受け取り１体ずつ表示
	public static void showMonster(Monster[] monsters) {
		for (Monster m : monsters) {
			System.out.println("Lv." + (m.getLevel() + 1) + " " + m.getName() + "が現れた!");
			View.wait(1);
		}
		View.scrollSlow(2);
	}

	// モンスターの合計排出ゴールドを計算し戻り値として返す
	public static int totalGold(Monster[] monsters) {
		int gold = 0;
		for (Monster m : monsters) {
			gold += m.getGold();
		}
		return gold;
	}

	// モンスターの合計経験値を計算し戻り値として返す
	public static int totalExp(Monster[] monsters) {
		int exp = 0;
		for (Monster m : monsters) {
			exp += m.getExp();
		}
		return exp;
	}
}
