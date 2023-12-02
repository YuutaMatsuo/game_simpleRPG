package app.view;

import app.asset.character.Hero;
import app.table.MonsterStatusTable;
import app.table.heroStatusTable;

/**
 * 表示に関する処理をまとめたクラス インスタンスを持たないstaticクラス
 */

public class View {

	public static void showTitle() {
		System.out.println(
				"================================================================================================================================");
		System.out.println();
		System.out.println("                                      ■ ■                          ");
		System.out.println("                                 ■     ■                           ");
		System.out.println("■■■■■   ■■■■■     ■■■■■          ■                          ■■     ");
		System.out.println("■    ■  ■    ■   ■■   ■         ■■■■■■■■■                   ■      ");
		System.out.println("■    ■■ ■    ■  ■■              ■   ■■                      ■      ");
		System.out.println("■    ■  ■    ■  ■              ■    ■                      ■■  ■   ");
		System.out.println("■■■■■   ■■■■■   ■    ■■■      ■■    ■      ■■■■■■■■■■■     ■   ■   ");
		System.out.println("■   ■   ■       ■      ■            ■                      ■    ■  ");
		System.out.println("■    ■  ■       ■■     ■           ■                      ■    ■■■ ");
		System.out.println("■    ■■ ■        ■■   ■■          ■■                    ■■■■■■■■ ■■");
		System.out.println("■     ■ ■         ■■■■■          ■■                                ");
		System.out.println();
		System.out.println(
				"================================================================================================================================");
	}

	// 引数で受け取った数の改行を行うメソッド
	public static void scroll(int i) {
		while (i > 0) {
			System.out.println();
			try {
				Thread.sleep(30);
			} catch (InterruptedException e) {
			}
			i--;
		}
	}

	// 引数で受け取った数の改行を行うメソッド ゆっくり
	public static void scrollSlow(int i) {
		i = i / 2;
		while (i > 0) {
			System.out.println();
			System.out.println();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
			i--;
		}
	}

	// 引数で受け取った数の秒数待機するメソッド
	public static void wait(int i) {
		try {
			Thread.sleep(i * 1000);
		} catch (InterruptedException e) {
		}
	}
	
	public static void load() {
		System.out.println("Now Loading ...");
		for(int i = 0; i < 30; i++) {
			System.out.print("■");
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
			}
		}
		for(int i = 0; i < 60; i++) {
			System.out.print("■");
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
			}
		}
		View.scroll(50);
	}

	public static void battleMenu(Hero[] heros) {
		System.out.println("=========================================");
		System.out.println("1.たたかう       Lv." + heros[0].level + " " + heros[0].name + "   HP:" + heros[0].hp + "  MP:"
				+ heros[0].mp);
		System.out.println("2.ぼうぎょ       Lv." + heros[1].level + " " + heros[1].name + "   HP:" + heros[1].hp + "  MP:"
				+ heros[1].mp);
		System.out.println("3.逃げる      Lv." + heros[2].level + " " + heros[2].name + "  HP:" + heros[2].hp + "   MP:"
				+ heros[2].mp);
		System.out.println("=========================================");
		System.out.print("\n>>");
	}

	// 引数で渡されたパーティーメンバーのステータスを表示
	public static void showAllStatus(Hero[] heros) {
		System.out.println("=========================================");
		System.out
				.println("Lv." + heros[0].level + " " + heros[0].name + "   HP:" + heros[0].hp + "  MP:" + heros[0].mp);
		System.out
				.println("Lv." + heros[1].level + " " + heros[1].name + "   HP:" + heros[1].hp + "  MP:" + heros[1].mp);
		System.out
				.println("Lv." + heros[2].level + " " + heros[2].name + "  HP:" + heros[2].hp + "   MP:" + heros[2].mp);
		System.out.println("=========================================");
	}

	// ステータスマスターテーブルから、すべての値を出力する
	// デバッグチェック用
	public static void showAllStatus() {
		for (int[][] num : heroStatusTable.heroStatusMaster) {
			int lv = 1;
			System.out.println("各レベルごとのヒーローのステータス ** HP/ MP/ ATK/ DEF/ レベルアップに必要な経験値 **");
			for (int[] num1 : num) {
				System.out.print("レベル" + lv + " ");
				for (int num2 : num1) {
					System.out.print(num2 + " ");
				}
				lv++;
				View.scroll(1);
			}
			lv = 1;
			View.scroll(1);
		}
		View.scroll(1);
		
		int lv = 1;
		int name = 0;
		for (int[][] num : MonsterStatusTable.monsterStatusMaster) {
			System.out.println("各レベルごとの" + MonsterStatusTable.monsterName[name] + "のステータス ** HP/ MP/ ATK/ DEF/ モンスターの排出経験値 **");
			for (int[] num1 : num) {
				System.out.print("レベル" + lv + " ");
				for (int num2 : num1) {
					System.out.print(num2 + " ");
				}
				lv++;
				View.scroll(1);
			}
			lv = 1;
			name++;
			View.scroll(1);
		}
		View.scroll(1);
	}
	
	public static void feildMessage() {
		View.scroll(2);
		System.out.println("ここではプレイヤーのレベルに応じたモンスターが出現します");
		System.out.println("全部で３回の戦闘が行われ、すべての戦闘に勝利する事でクリアです！");
		System.out.println("各戦闘ごとに経験値を獲得することができ、一定以上の経験値を獲得することで次のレベルに上がります");
		View.scroll(2);
		View.load();
	}
}
