package app.table;

/*
 * モンスターの生成の際に参照されるステータステーブルを定義するクラス
 * 
 */

public class MonsterTable {
	public static String[] monsterName = { "スライム", "おばけきのこ", "メタルスライム" };
	public static int[][] monsterStatus = {
			{ 70, 5 , 5}, // スライム HP atk def
			{ 50, 9 , 3}, // おばけきのこ HP atk def
			{ 30, 20 , 15}, // メタルスライム HP atk def
	};
}
