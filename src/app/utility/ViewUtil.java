package app.utility;

import app.asset.character.Hero;

/**
 * 表示に関する処理をまとめたクラス
 * インスタンスを持たないstaticクラス
 */

public class ViewUtil {

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
	
	//引数で受け取った数の改行を行うメソッド
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
	
	//引数で受け取った数の改行を行うメソッド ゆっくり
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
	
	//引数で受け取った数の秒数待機するメソッド
	public static void wait(int i) {
		try {
			Thread.sleep(i * 1000);
		} catch (InterruptedException e) {
		}
	}
	
	public static void battleMenu(Hero[] heros) {
		System.out.println("=========================================");
		System.out.println("1.たたかう       Lv." + heros[0].level + " " + heros[0].name + "   HP:" + heros[0].hp + "  MP:" + heros[0].mp);
		System.out.println("2.ぼうぎょ       Lv." + heros[1].level + " " + heros[1].name + "   HP:" + heros[1].hp + "  MP:" + heros[1].mp);
		System.out.println("3.逃げる      Lv." + heros[2].level + " " + heros[2].name + "  HP:" + heros[2].hp + "   MP:" + heros[2].mp);
		System.out.println("=========================================");
		System.out.print("\n>>");
	}
}
