package app.table;

public class heroStatusTable {
	// ヒーローのレベルごとのステータスを定義するマスターテーブルクラス
	
	
	public static final int MAX_LEVEL = 5;
	
	//各種ヒーローのステータスのベースとなる値
	public static final int[][] heroStatusBase = {
			//勇者のベースステータス  HP/ MP/ ATK/ DEF/ 必要経験値
			{100, 30, 20, 10, 100},
			//戦士のベースステータス  HP/ MP/ ATK/ DEFF/ 必要経験値
			{150, 10, 15, 15, 100},
			//魔法使いのベースステータス	HP/ MP/ ATK/ DEFF/ 必要経験値
			{75, 50, 25, 7, 100}
	};
	
	//各レベルごとにステータスの上昇率を定義する
	public static final int[] statMagnification = {1, 2, 3, 4, 5};
	
	//三次元配列 [勇者、戦士、魔法使い] [ヒーロー毎のレベル] [レベルごとのステータス]
	//レベルアップ処理で使用
	public static int[][][] heroStatusMaster = {
			{	//勇者のステータス	HP/ MP/ ATK/ DEF/ 必要経験値
				{heroStatusTable.heroStatusBase[0][0], heroStatusTable.heroStatusBase[0][1], heroStatusTable.heroStatusBase[0][2], heroStatusTable.heroStatusBase[0][3], heroStatusTable.heroStatusBase[0][4]}, //レベル 1
				{heroStatusTable.heroStatusBase[0][0] * statMagnification[1], heroStatusTable.heroStatusBase[0][1] * statMagnification[1], heroStatusTable.heroStatusBase[0][2] * statMagnification[1], heroStatusTable.heroStatusBase[0][3] * statMagnification[1], heroStatusTable.heroStatusBase[0][4] * statMagnification[1]},	//レベル 2
				{heroStatusTable.heroStatusBase[0][0] * statMagnification[2], heroStatusTable.heroStatusBase[0][1] * statMagnification[2], heroStatusTable.heroStatusBase[0][2] * statMagnification[2], heroStatusTable.heroStatusBase[0][3] * statMagnification[2], heroStatusTable.heroStatusBase[0][4] * statMagnification[2]},	//レベル 3
				{heroStatusTable.heroStatusBase[0][0] * statMagnification[3], heroStatusTable.heroStatusBase[0][1] * statMagnification[3], heroStatusTable.heroStatusBase[0][2] * statMagnification[3], heroStatusTable.heroStatusBase[0][3] * statMagnification[3], heroStatusTable.heroStatusBase[0][4] * statMagnification[3]},	//レベル 4
				{heroStatusTable.heroStatusBase[0][0] * statMagnification[4], heroStatusTable.heroStatusBase[0][1] * statMagnification[4], heroStatusTable.heroStatusBase[0][2] * statMagnification[4], heroStatusTable.heroStatusBase[0][3] * statMagnification[4], heroStatusTable.heroStatusBase[0][4] * statMagnification[4]}	//レベル 5
			},
			
			{	//戦士のステータス	HP/ MP/ ATK/ DEF/ 必要経験値
				{heroStatusTable.heroStatusBase[1][0], heroStatusTable.heroStatusBase[1][1], heroStatusTable.heroStatusBase[1][2], heroStatusTable.heroStatusBase[1][3],heroStatusTable.heroStatusBase[1][4]}, //レベル 1
				{heroStatusTable.heroStatusBase[1][0] * statMagnification[1], heroStatusTable.heroStatusBase[1][1] * statMagnification[1], heroStatusTable.heroStatusBase[1][2] * statMagnification[1], heroStatusTable.heroStatusBase[1][3] * statMagnification[1], heroStatusTable.heroStatusBase[1][4] * statMagnification[1]},	//レベル 2
				{heroStatusTable.heroStatusBase[1][0] * statMagnification[2], heroStatusTable.heroStatusBase[1][1] * statMagnification[2], heroStatusTable.heroStatusBase[1][2] * statMagnification[2], heroStatusTable.heroStatusBase[1][3] * statMagnification[2], heroStatusTable.heroStatusBase[1][4] * statMagnification[2]},	//レベル 3
				{heroStatusTable.heroStatusBase[1][0] * statMagnification[3], heroStatusTable.heroStatusBase[1][1] * statMagnification[3], heroStatusTable.heroStatusBase[1][2] * statMagnification[3], heroStatusTable.heroStatusBase[1][3] * statMagnification[3], heroStatusTable.heroStatusBase[1][4] * statMagnification[3]},	//レベル 4
				{heroStatusTable.heroStatusBase[1][0] * statMagnification[4], heroStatusTable.heroStatusBase[1][1] * statMagnification[4], heroStatusTable.heroStatusBase[1][2] * statMagnification[4], heroStatusTable.heroStatusBase[1][3] * statMagnification[4], heroStatusTable.heroStatusBase[1][4] * statMagnification[4]}	//レベル 5
			},
			
			{	//魔法使いのステータス	HP/ MP/ ATK/ DEF/ 必要経験値
				{heroStatusTable.heroStatusBase[2][0], heroStatusTable.heroStatusBase[2][1], heroStatusTable.heroStatusBase[2][2], heroStatusTable.heroStatusBase[2][3],heroStatusTable.heroStatusBase[2][4] }, //レベル 1
				{heroStatusTable.heroStatusBase[2][0] * statMagnification[1], heroStatusTable.heroStatusBase[2][1] * statMagnification[1], heroStatusTable.heroStatusBase[2][2] * statMagnification[1], heroStatusTable.heroStatusBase[2][3] * statMagnification[1], heroStatusTable.heroStatusBase[2][4] * statMagnification[1]},	//レベル 2
				{heroStatusTable.heroStatusBase[2][0] * statMagnification[2], heroStatusTable.heroStatusBase[2][1] * statMagnification[2], heroStatusTable.heroStatusBase[2][2] * statMagnification[2], heroStatusTable.heroStatusBase[2][3] * statMagnification[2], heroStatusTable.heroStatusBase[2][4] * statMagnification[2]},	//レベル 3
				{heroStatusTable.heroStatusBase[2][0] * statMagnification[3], heroStatusTable.heroStatusBase[2][1] * statMagnification[3], heroStatusTable.heroStatusBase[2][2] * statMagnification[3], heroStatusTable.heroStatusBase[2][3] * statMagnification[3], heroStatusTable.heroStatusBase[2][4] * statMagnification[3]},	//レベル 4
				{heroStatusTable.heroStatusBase[2][0] * statMagnification[4], heroStatusTable.heroStatusBase[2][1] * statMagnification[4], heroStatusTable.heroStatusBase[2][2] * statMagnification[4], heroStatusTable.heroStatusBase[2][3] * statMagnification[4], heroStatusTable.heroStatusBase[2][4] * statMagnification[4]}	//レベル 5
			}
			
	};

}
