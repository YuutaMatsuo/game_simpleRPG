package app.utility;

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
}
