package app.table;

/*
 * モンスターの生成の際に参照されるステータステーブルを定義するクラス
 * 
 */

public class MonsterTable {
	public static String[] monsterName = { "スライム", "おばけきのこ", "メタルスライム" };
	public static int[][] monsterStatus = {
			{ 70, 5 }, // スライム HP atk
			{ 50, 9 }, // おばけきのこ HP atk
			{ 120, 30 }, // メタルスライム HP atk
	};
}
