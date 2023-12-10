package app.logic;

import java.util.Random;
import java.util.Scanner;

import app.asset.character.Human;
import app.table.heroStatusTable;

/*
 * 便利な処理をまとめたクラス
 * インスタンスを持たないstaticクラス
 */

public class Util {
	public static Scanner scanner = new Scanner(System.in);
	public static Random random = new Random();

	// 勇者のレベルを引数で受け取った値に変更
	public static void changeStatus(Human[] heros, int level) {
		if (level <= heroStatusTable.MAX_LEVEL && level > 0) {
			for (Human human : heros) {
				human.level = level;
				human.hp = heroStatusTable.heroStatusMaster[human.job][level - 1][0];
				human.maxHp = heroStatusTable.heroStatusMaster[human.job][level - 1][0];
				human.mp = heroStatusTable.heroStatusMaster[human.job][level - 1][1];
				human.atk = heroStatusTable.heroStatusMaster[human.job][level - 1][2];
				human.def = heroStatusTable.heroStatusMaster[human.job][level - 1][3];
				human.nextExp = heroStatusTable.heroStatusMaster[human.job][level - 1][4];
			}
		} else {
			System.out.println("指定したレベルが正しくありません。 現在のレベル上限は Lv." + heroStatusTable.MAX_LEVEL + "です");
		}
	}

	// 勇者のレベルを最大値に変更 (オーバーロード)
	public static void changeStatus(Human[] heros) {
		for (Human human : heros) {
			human.level = 100;
			human.hp = 9999;
			human.maxHp = 9999;
			human.mp = 9999;
			human.atk = 9999;
			human.def = 9999;
			human.nextExp = 0;
			human.debugMode = true;
		}
	}
	
	//　勇者の配列を受け取りMaxHP分回復を行う
	public static void allHeal(Human[] heros) {
		for(Human h : heros) {
			h.hp = h.maxHp;
		}
	}
}
