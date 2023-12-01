package app.table;

/*
 * モンスターの生成の際に参照されるステータステーブルを定義するクラス
 * 
 */

public class MonsterTable {
	public static String[] monsterName = { "スライム", "おばけきのこ", "メタルスライム" };
	public static int[][] monsterStatus = {
			{ 35, 5 , 0, 20}, // スライム HP atk def
			{ 42, 9 , 0, 25}, // おばけきのこ HP atk def
			{ 70, 12 , 0, 50}, // メタルスライム HP atk def
	};
}
