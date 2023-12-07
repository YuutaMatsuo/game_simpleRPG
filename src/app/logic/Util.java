package app.logic;

import java.util.Random;
import java.util.Scanner;

import app.asset.character.Hero;
import app.table.heroStatusTable;

/*
 * 便利な処理をまとめたクラス
 * インスタンスを持たないstaticクラス
 */

public class Util {
	public static Scanner scanner = new Scanner(System.in);
	public static Random random = new Random();

	// 勇者のレベルを引数で受け取った値に変更
	public static void changeStatus(Hero[] heros, int level) {
		if (level <= heroStatusTable.MAX_LEVEL && level > 0) {
			for (Hero hero : heros) {
				hero.level = level;
				hero.hp = heroStatusTable.heroStatusMaster[hero.job][level - 1][0];
				hero.maxHp = heroStatusTable.heroStatusMaster[hero.job][level - 1][0];
				hero.mp = heroStatusTable.heroStatusMaster[hero.job][level - 1][1];
				hero.atk = heroStatusTable.heroStatusMaster[hero.job][level - 1][2];
				hero.def = heroStatusTable.heroStatusMaster[hero.job][level - 1][3];
				hero.nextExp = heroStatusTable.heroStatusMaster[hero.job][level - 1][4];
			}
		} else {
			System.out.println("指定したレベルが正しくありません。 現在のレベル上限は Lv." + heroStatusTable.MAX_LEVEL + "です");
		}
	}

	// 勇者のレベルを最大値に変更 (オーバーロード)
	public static void changeStatus(Hero[] heros) {
		for (Hero hero : heros) {
			hero.level = 100;
			hero.hp = 9999;
			hero.maxHp = 9999;
			hero.mp = 9999;
			hero.atk = 9999;
			hero.def = 9999;
			hero.nextExp = 0;
			hero.debugMode = true;
		}
	}
	
	//　勇者の配列を受け取りMaxHP分回復を行う
	public static void allHeal(Hero[] heros) {
		for(Hero h : heros) {
			h.hp = h.maxHp;
		}
	}
}
