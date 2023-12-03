package app.table;

public class heroStatusTable {
	// ヒーローのレベルごとのステータスを定義するマスターテーブルクラス
	
	
	public static final int MAX_LEVEL = 30;
	
	//各種ヒーローのステータスのベースとなる値
	public static final int[][] heroStatusBase = {
			//勇者のベースステータス  HP/ MP/ ATK/ DEF/ 必要経験値
			{510, 350, 300, 230, 500},
			//戦士のベースステータス  HP/ MP/ ATK/ DEFF/ 必要経験値
			{550, 60, 280, 250, 500},
			//魔法使いのベースステータス	HP/ MP/ ATK/ DEFF/ 必要経験値
			{420, 500, 340, 200, 500}
	};
	
	//各レベルごとにステータスの上昇率を定義する
	public static final double[] statMagnification = {1.0, 1.2, 1.4, 1.6, 1.8, 2.0, 2.2, 2.4, 2.6, 2.8, 3.0, 3.2, 3.4, 3.6, 3.8, 4.0, 4.2, 4.4, 4.6, 4.8, 5.0, 5.2, 5.4, 5.6, 5.8, 6.0, 6.2, 6.4, 6.6, 6.8};
	
	//三次元配列 [勇者、戦士、魔法使い] [ヒーロー毎のレベル] [レベルごとのステータス] が格納されたマスターテーブル
	//レベルアップ処理で使用
	public static int[][][] heroStatusMaster = {
			{	//勇者のステータス	HP/ MP/ ATK/ DEF/ 必要経験値
				// レベル　１～１０
				{(int)(heroStatusTable.heroStatusBase[0][0] * statMagnification[0]), (int)(heroStatusTable.heroStatusBase[0][1] * statMagnification[0]), (int)(heroStatusTable.heroStatusBase[0][2] * statMagnification[0]), (int)(heroStatusTable.heroStatusBase[0][3] * statMagnification[0]), (int)(heroStatusTable.heroStatusBase[0][4] * statMagnification[0])}, 	//レベル 1
				{(int)(heroStatusTable.heroStatusBase[0][0] * statMagnification[1]), (int)(heroStatusTable.heroStatusBase[0][1] * statMagnification[1]), (int)(heroStatusTable.heroStatusBase[0][2] * statMagnification[1]), (int)(heroStatusTable.heroStatusBase[0][3] * statMagnification[1]), (int)(heroStatusTable.heroStatusBase[0][4] * statMagnification[1])},	//レベル 2
				{(int)(heroStatusTable.heroStatusBase[0][0] * statMagnification[2]), (int)(heroStatusTable.heroStatusBase[0][1] * statMagnification[2]), (int)(heroStatusTable.heroStatusBase[0][2] * statMagnification[2]), (int)(heroStatusTable.heroStatusBase[0][3] * statMagnification[2]), (int)(heroStatusTable.heroStatusBase[0][4] * statMagnification[2])},	//レベル 3
				{(int)(heroStatusTable.heroStatusBase[0][0] * statMagnification[3]), (int)(heroStatusTable.heroStatusBase[0][1] * statMagnification[3]), (int)(heroStatusTable.heroStatusBase[0][2] * statMagnification[3]), (int)(heroStatusTable.heroStatusBase[0][3] * statMagnification[3]), (int)(heroStatusTable.heroStatusBase[0][4] * statMagnification[3])},	//レベル 4
				{(int)(heroStatusTable.heroStatusBase[0][0] * statMagnification[4]), (int)(heroStatusTable.heroStatusBase[0][1] * statMagnification[4]), (int)(heroStatusTable.heroStatusBase[0][2] * statMagnification[4]), (int)(heroStatusTable.heroStatusBase[0][3] * statMagnification[4]), (int)(heroStatusTable.heroStatusBase[0][4] * statMagnification[4])},	//レベル 5
				{(int)(heroStatusTable.heroStatusBase[0][0] * statMagnification[5]), (int)(heroStatusTable.heroStatusBase[0][1] * statMagnification[5]), (int)(heroStatusTable.heroStatusBase[0][2] * statMagnification[5]), (int)(heroStatusTable.heroStatusBase[0][3] * statMagnification[5]), (int)(heroStatusTable.heroStatusBase[0][4] * statMagnification[5])},	//レベル 6
				{(int)(heroStatusTable.heroStatusBase[0][0] * statMagnification[6]), (int)(heroStatusTable.heroStatusBase[0][1] * statMagnification[6]), (int)(heroStatusTable.heroStatusBase[0][2] * statMagnification[6]), (int)(heroStatusTable.heroStatusBase[0][3] * statMagnification[6]), (int)(heroStatusTable.heroStatusBase[0][4] * statMagnification[6])},	//レベル 7
				{(int)(heroStatusTable.heroStatusBase[0][0] * statMagnification[7]), (int)(heroStatusTable.heroStatusBase[0][1] * statMagnification[7]), (int)(heroStatusTable.heroStatusBase[0][2] * statMagnification[7]), (int)(heroStatusTable.heroStatusBase[0][3] * statMagnification[7]), (int)(heroStatusTable.heroStatusBase[0][4] * statMagnification[7])},	//レベル 8
				{(int)(heroStatusTable.heroStatusBase[0][0] * statMagnification[8]), (int)(heroStatusTable.heroStatusBase[0][1] * statMagnification[8]), (int)(heroStatusTable.heroStatusBase[0][2] * statMagnification[8]), (int)(heroStatusTable.heroStatusBase[0][3] * statMagnification[8]), (int)(heroStatusTable.heroStatusBase[0][4] * statMagnification[8])},	//レベル 9
				{(int)(heroStatusTable.heroStatusBase[0][0] * statMagnification[9]), (int)(heroStatusTable.heroStatusBase[0][1] * statMagnification[9]), (int)(heroStatusTable.heroStatusBase[0][2] * statMagnification[9]), (int)(heroStatusTable.heroStatusBase[0][3] * statMagnification[9]), (int)(heroStatusTable.heroStatusBase[0][4] * statMagnification[9])},	//レベル 10
				// レベル　１１～２０
				{(int)(heroStatusTable.heroStatusBase[0][0] * statMagnification[10]), (int)(heroStatusTable.heroStatusBase[0][1] * statMagnification[10]), (int)(heroStatusTable.heroStatusBase[0][2] * statMagnification[10]), (int)(heroStatusTable.heroStatusBase[0][3] * statMagnification[10]), (int)(heroStatusTable.heroStatusBase[0][4] * statMagnification[10])}, 	//レベル 11
				{(int)(heroStatusTable.heroStatusBase[0][0] * statMagnification[11]), (int)(heroStatusTable.heroStatusBase[0][1] * statMagnification[11]), (int)(heroStatusTable.heroStatusBase[0][2] * statMagnification[11]), (int)(heroStatusTable.heroStatusBase[0][3] * statMagnification[11]), (int)(heroStatusTable.heroStatusBase[0][4] * statMagnification[11])},	//レベル 12
				{(int)(heroStatusTable.heroStatusBase[0][0] * statMagnification[12]), (int)(heroStatusTable.heroStatusBase[0][1] * statMagnification[12]), (int)(heroStatusTable.heroStatusBase[0][2] * statMagnification[12]), (int)(heroStatusTable.heroStatusBase[0][3] * statMagnification[12]), (int)(heroStatusTable.heroStatusBase[0][4] * statMagnification[12])},	//レベル 13
				{(int)(heroStatusTable.heroStatusBase[0][0] * statMagnification[13]), (int)(heroStatusTable.heroStatusBase[0][1] * statMagnification[13]), (int)(heroStatusTable.heroStatusBase[0][2] * statMagnification[13]), (int)(heroStatusTable.heroStatusBase[0][3] * statMagnification[13]), (int)(heroStatusTable.heroStatusBase[0][4] * statMagnification[13])},	//レベル 14
				{(int)(heroStatusTable.heroStatusBase[0][0] * statMagnification[14]), (int)(heroStatusTable.heroStatusBase[0][1] * statMagnification[14]), (int)(heroStatusTable.heroStatusBase[0][2] * statMagnification[14]), (int)(heroStatusTable.heroStatusBase[0][3] * statMagnification[14]), (int)(heroStatusTable.heroStatusBase[0][4] * statMagnification[14])},	//レベル 15
				{(int)(heroStatusTable.heroStatusBase[0][0] * statMagnification[15]), (int)(heroStatusTable.heroStatusBase[0][1] * statMagnification[15]), (int)(heroStatusTable.heroStatusBase[0][2] * statMagnification[15]), (int)(heroStatusTable.heroStatusBase[0][3] * statMagnification[15]), (int)(heroStatusTable.heroStatusBase[0][4] * statMagnification[15])},	//レベル 16
				{(int)(heroStatusTable.heroStatusBase[0][0] * statMagnification[16]), (int)(heroStatusTable.heroStatusBase[0][1] * statMagnification[16]), (int)(heroStatusTable.heroStatusBase[0][2] * statMagnification[16]), (int)(heroStatusTable.heroStatusBase[0][3] * statMagnification[16]), (int)(heroStatusTable.heroStatusBase[0][4] * statMagnification[16])},	//レベル 17
				{(int)(heroStatusTable.heroStatusBase[0][0] * statMagnification[17]), (int)(heroStatusTable.heroStatusBase[0][1] * statMagnification[17]), (int)(heroStatusTable.heroStatusBase[0][2] * statMagnification[17]), (int)(heroStatusTable.heroStatusBase[0][3] * statMagnification[17]), (int)(heroStatusTable.heroStatusBase[0][4] * statMagnification[17])},	//レベル 18
				{(int)(heroStatusTable.heroStatusBase[0][0] * statMagnification[18]), (int)(heroStatusTable.heroStatusBase[0][1] * statMagnification[18]), (int)(heroStatusTable.heroStatusBase[0][2] * statMagnification[18]), (int)(heroStatusTable.heroStatusBase[0][3] * statMagnification[18]), (int)(heroStatusTable.heroStatusBase[0][4] * statMagnification[18])},	//レベル 19
				{(int)(heroStatusTable.heroStatusBase[0][0] * statMagnification[19]), (int)(heroStatusTable.heroStatusBase[0][1] * statMagnification[19]), (int)(heroStatusTable.heroStatusBase[0][2] * statMagnification[19]), (int)(heroStatusTable.heroStatusBase[0][3] * statMagnification[19]), (int)(heroStatusTable.heroStatusBase[0][4] * statMagnification[19])},	//レベル 20
				// レベル　２１～３０
				{(int)(heroStatusTable.heroStatusBase[0][0] * statMagnification[20]), (int)(heroStatusTable.heroStatusBase[0][1] * statMagnification[20]), (int)(heroStatusTable.heroStatusBase[0][2] * statMagnification[20]), (int)(heroStatusTable.heroStatusBase[0][3] * statMagnification[20]), (int)(heroStatusTable.heroStatusBase[0][4] * statMagnification[20])}, 	//レベル 21
				{(int)(heroStatusTable.heroStatusBase[0][0] * statMagnification[21]), (int)(heroStatusTable.heroStatusBase[0][1] * statMagnification[21]), (int)(heroStatusTable.heroStatusBase[0][2] * statMagnification[21]), (int)(heroStatusTable.heroStatusBase[0][3] * statMagnification[21]), (int)(heroStatusTable.heroStatusBase[0][4] * statMagnification[21])},	//レベル 22
				{(int)(heroStatusTable.heroStatusBase[0][0] * statMagnification[22]), (int)(heroStatusTable.heroStatusBase[0][1] * statMagnification[22]), (int)(heroStatusTable.heroStatusBase[0][2] * statMagnification[22]), (int)(heroStatusTable.heroStatusBase[0][3] * statMagnification[22]), (int)(heroStatusTable.heroStatusBase[0][4] * statMagnification[22])},	//レベル 23
				{(int)(heroStatusTable.heroStatusBase[0][0] * statMagnification[23]), (int)(heroStatusTable.heroStatusBase[0][1] * statMagnification[23]), (int)(heroStatusTable.heroStatusBase[0][2] * statMagnification[23]), (int)(heroStatusTable.heroStatusBase[0][3] * statMagnification[23]), (int)(heroStatusTable.heroStatusBase[0][4] * statMagnification[23])},	//レベル 24
				{(int)(heroStatusTable.heroStatusBase[0][0] * statMagnification[24]), (int)(heroStatusTable.heroStatusBase[0][1] * statMagnification[24]), (int)(heroStatusTable.heroStatusBase[0][2] * statMagnification[24]), (int)(heroStatusTable.heroStatusBase[0][3] * statMagnification[24]), (int)(heroStatusTable.heroStatusBase[0][4] * statMagnification[24])},	//レベル 25
				{(int)(heroStatusTable.heroStatusBase[0][0] * statMagnification[25]), (int)(heroStatusTable.heroStatusBase[0][1] * statMagnification[25]), (int)(heroStatusTable.heroStatusBase[0][2] * statMagnification[25]), (int)(heroStatusTable.heroStatusBase[0][3] * statMagnification[25]), (int)(heroStatusTable.heroStatusBase[0][4] * statMagnification[25])},	//レベル 26
				{(int)(heroStatusTable.heroStatusBase[0][0] * statMagnification[26]), (int)(heroStatusTable.heroStatusBase[0][1] * statMagnification[26]), (int)(heroStatusTable.heroStatusBase[0][2] * statMagnification[26]), (int)(heroStatusTable.heroStatusBase[0][3] * statMagnification[26]), (int)(heroStatusTable.heroStatusBase[0][4] * statMagnification[26])},	//レベル 27
				{(int)(heroStatusTable.heroStatusBase[0][0] * statMagnification[27]), (int)(heroStatusTable.heroStatusBase[0][1] * statMagnification[27]), (int)(heroStatusTable.heroStatusBase[0][2] * statMagnification[27]), (int)(heroStatusTable.heroStatusBase[0][3] * statMagnification[27]), (int)(heroStatusTable.heroStatusBase[0][4] * statMagnification[27])},	//レベル 28
				{(int)(heroStatusTable.heroStatusBase[0][0] * statMagnification[28]), (int)(heroStatusTable.heroStatusBase[0][1] * statMagnification[28]), (int)(heroStatusTable.heroStatusBase[0][2] * statMagnification[28]), (int)(heroStatusTable.heroStatusBase[0][3] * statMagnification[28]), (int)(heroStatusTable.heroStatusBase[0][4] * statMagnification[28])},	//レベル 29
				{(int)(heroStatusTable.heroStatusBase[0][0] * statMagnification[29]), (int)(heroStatusTable.heroStatusBase[0][1] * statMagnification[29]), (int)(heroStatusTable.heroStatusBase[0][2] * statMagnification[29]), (int)(heroStatusTable.heroStatusBase[0][3] * statMagnification[29]), (int)(heroStatusTable.heroStatusBase[0][4] * statMagnification[29])}	//レベル 30
			},
			
			{	//戦士のステータス	HP/ MP/ ATK/ DEF/ 必要経験値
				// レベル　１～１０
				{(int)(heroStatusTable.heroStatusBase[1][0] * statMagnification[0]), (int)(heroStatusTable.heroStatusBase[1][1] * statMagnification[0]), (int)(heroStatusTable.heroStatusBase[1][2] * statMagnification[0]), (int)(heroStatusTable.heroStatusBase[1][3] * statMagnification[0]), (int)(heroStatusTable.heroStatusBase[1][4] * statMagnification[0])}, 	//レベル 1
				{(int)(heroStatusTable.heroStatusBase[1][0] * statMagnification[1]), (int)(heroStatusTable.heroStatusBase[1][1] * statMagnification[1]), (int)(heroStatusTable.heroStatusBase[1][2] * statMagnification[1]), (int)(heroStatusTable.heroStatusBase[1][3] * statMagnification[1]), (int)(heroStatusTable.heroStatusBase[1][4] * statMagnification[1])},	//レベル 2
				{(int)(heroStatusTable.heroStatusBase[1][0] * statMagnification[2]), (int)(heroStatusTable.heroStatusBase[1][1] * statMagnification[2]), (int)(heroStatusTable.heroStatusBase[1][2] * statMagnification[2]), (int)(heroStatusTable.heroStatusBase[1][3] * statMagnification[2]), (int)(heroStatusTable.heroStatusBase[1][4] * statMagnification[2])},	//レベル 3
				{(int)(heroStatusTable.heroStatusBase[1][0] * statMagnification[3]), (int)(heroStatusTable.heroStatusBase[1][1] * statMagnification[3]), (int)(heroStatusTable.heroStatusBase[1][2] * statMagnification[3]), (int)(heroStatusTable.heroStatusBase[1][3] * statMagnification[3]), (int)(heroStatusTable.heroStatusBase[1][4] * statMagnification[3])},	//レベル 4
				{(int)(heroStatusTable.heroStatusBase[1][0] * statMagnification[4]), (int)(heroStatusTable.heroStatusBase[1][1] * statMagnification[4]), (int)(heroStatusTable.heroStatusBase[1][2] * statMagnification[4]), (int)(heroStatusTable.heroStatusBase[1][3] * statMagnification[4]), (int)(heroStatusTable.heroStatusBase[1][4] * statMagnification[4])},	//レベル 5
				{(int)(heroStatusTable.heroStatusBase[1][0] * statMagnification[5]), (int)(heroStatusTable.heroStatusBase[1][1] * statMagnification[5]), (int)(heroStatusTable.heroStatusBase[1][2] * statMagnification[5]), (int)(heroStatusTable.heroStatusBase[1][3] * statMagnification[5]), (int)(heroStatusTable.heroStatusBase[1][4] * statMagnification[5])},	//レベル 6
				{(int)(heroStatusTable.heroStatusBase[1][0] * statMagnification[6]), (int)(heroStatusTable.heroStatusBase[1][1] * statMagnification[6]), (int)(heroStatusTable.heroStatusBase[1][2] * statMagnification[6]), (int)(heroStatusTable.heroStatusBase[1][3] * statMagnification[6]), (int)(heroStatusTable.heroStatusBase[1][4] * statMagnification[6])},	//レベル 7
				{(int)(heroStatusTable.heroStatusBase[1][0] * statMagnification[7]), (int)(heroStatusTable.heroStatusBase[1][1] * statMagnification[7]), (int)(heroStatusTable.heroStatusBase[1][2] * statMagnification[7]), (int)(heroStatusTable.heroStatusBase[1][3] * statMagnification[7]), (int)(heroStatusTable.heroStatusBase[1][4] * statMagnification[7])},	//レベル 8
				{(int)(heroStatusTable.heroStatusBase[1][0] * statMagnification[8]), (int)(heroStatusTable.heroStatusBase[1][1] * statMagnification[8]), (int)(heroStatusTable.heroStatusBase[1][2] * statMagnification[8]), (int)(heroStatusTable.heroStatusBase[1][3] * statMagnification[8]), (int)(heroStatusTable.heroStatusBase[1][4] * statMagnification[8])},	//レベル 9
				{(int)(heroStatusTable.heroStatusBase[1][0] * statMagnification[9]), (int)(heroStatusTable.heroStatusBase[1][1] * statMagnification[9]), (int)(heroStatusTable.heroStatusBase[1][2] * statMagnification[9]), (int)(heroStatusTable.heroStatusBase[1][3] * statMagnification[9]), (int)(heroStatusTable.heroStatusBase[1][4] * statMagnification[9])},	//レベル 10
				// レベル　１１～２０
				{(int)(heroStatusTable.heroStatusBase[1][0] * statMagnification[10]), (int)(heroStatusTable.heroStatusBase[1][1] * statMagnification[10]), (int)(heroStatusTable.heroStatusBase[1][2] * statMagnification[10]), (int)(heroStatusTable.heroStatusBase[1][3] * statMagnification[10]), (int)(heroStatusTable.heroStatusBase[1][4] * statMagnification[10])}, 	//レベル 11
				{(int)(heroStatusTable.heroStatusBase[1][0] * statMagnification[11]), (int)(heroStatusTable.heroStatusBase[1][1] * statMagnification[11]), (int)(heroStatusTable.heroStatusBase[1][2] * statMagnification[11]), (int)(heroStatusTable.heroStatusBase[1][3] * statMagnification[11]), (int)(heroStatusTable.heroStatusBase[1][4] * statMagnification[11])},	//レベル 12
				{(int)(heroStatusTable.heroStatusBase[1][0] * statMagnification[12]), (int)(heroStatusTable.heroStatusBase[1][1] * statMagnification[12]), (int)(heroStatusTable.heroStatusBase[1][2] * statMagnification[12]), (int)(heroStatusTable.heroStatusBase[1][3] * statMagnification[12]), (int)(heroStatusTable.heroStatusBase[1][4] * statMagnification[12])},	//レベル 13
				{(int)(heroStatusTable.heroStatusBase[1][0] * statMagnification[13]), (int)(heroStatusTable.heroStatusBase[1][1] * statMagnification[13]), (int)(heroStatusTable.heroStatusBase[1][2] * statMagnification[13]), (int)(heroStatusTable.heroStatusBase[1][3] * statMagnification[13]), (int)(heroStatusTable.heroStatusBase[1][4] * statMagnification[13])},	//レベル 14
				{(int)(heroStatusTable.heroStatusBase[1][0] * statMagnification[14]), (int)(heroStatusTable.heroStatusBase[1][1] * statMagnification[14]), (int)(heroStatusTable.heroStatusBase[1][2] * statMagnification[14]), (int)(heroStatusTable.heroStatusBase[1][3] * statMagnification[14]), (int)(heroStatusTable.heroStatusBase[1][4] * statMagnification[14])},	//レベル 15
				{(int)(heroStatusTable.heroStatusBase[1][0] * statMagnification[15]), (int)(heroStatusTable.heroStatusBase[1][1] * statMagnification[15]), (int)(heroStatusTable.heroStatusBase[1][2] * statMagnification[15]), (int)(heroStatusTable.heroStatusBase[1][3] * statMagnification[15]), (int)(heroStatusTable.heroStatusBase[1][4] * statMagnification[15])},	//レベル 16
				{(int)(heroStatusTable.heroStatusBase[1][0] * statMagnification[16]), (int)(heroStatusTable.heroStatusBase[1][1] * statMagnification[16]), (int)(heroStatusTable.heroStatusBase[1][2] * statMagnification[16]), (int)(heroStatusTable.heroStatusBase[1][3] * statMagnification[16]), (int)(heroStatusTable.heroStatusBase[1][4] * statMagnification[16])},	//レベル 17
				{(int)(heroStatusTable.heroStatusBase[1][0] * statMagnification[17]), (int)(heroStatusTable.heroStatusBase[1][1] * statMagnification[17]), (int)(heroStatusTable.heroStatusBase[1][2] * statMagnification[17]), (int)(heroStatusTable.heroStatusBase[1][3] * statMagnification[17]), (int)(heroStatusTable.heroStatusBase[1][4] * statMagnification[17])},	//レベル 18
				{(int)(heroStatusTable.heroStatusBase[1][0] * statMagnification[18]), (int)(heroStatusTable.heroStatusBase[1][1] * statMagnification[18]), (int)(heroStatusTable.heroStatusBase[1][2] * statMagnification[18]), (int)(heroStatusTable.heroStatusBase[1][3] * statMagnification[18]), (int)(heroStatusTable.heroStatusBase[1][4] * statMagnification[18])},	//レベル 19
				{(int)(heroStatusTable.heroStatusBase[1][0] * statMagnification[19]), (int)(heroStatusTable.heroStatusBase[1][1] * statMagnification[19]), (int)(heroStatusTable.heroStatusBase[1][2] * statMagnification[19]), (int)(heroStatusTable.heroStatusBase[1][3] * statMagnification[19]), (int)(heroStatusTable.heroStatusBase[1][4] * statMagnification[19])},	//レベル 20
				// レベル　２１～３０
				{(int)(heroStatusTable.heroStatusBase[1][0] * statMagnification[20]), (int)(heroStatusTable.heroStatusBase[1][1] * statMagnification[20]), (int)(heroStatusTable.heroStatusBase[1][2] * statMagnification[20]), (int)(heroStatusTable.heroStatusBase[1][3] * statMagnification[20]), (int)(heroStatusTable.heroStatusBase[1][4] * statMagnification[20])}, 	//レベル 21
				{(int)(heroStatusTable.heroStatusBase[1][0] * statMagnification[21]), (int)(heroStatusTable.heroStatusBase[1][1] * statMagnification[21]), (int)(heroStatusTable.heroStatusBase[1][2] * statMagnification[21]), (int)(heroStatusTable.heroStatusBase[1][3] * statMagnification[21]), (int)(heroStatusTable.heroStatusBase[1][4] * statMagnification[21])},	//レベル 22
				{(int)(heroStatusTable.heroStatusBase[1][0] * statMagnification[22]), (int)(heroStatusTable.heroStatusBase[1][1] * statMagnification[22]), (int)(heroStatusTable.heroStatusBase[1][2] * statMagnification[22]), (int)(heroStatusTable.heroStatusBase[1][3] * statMagnification[22]), (int)(heroStatusTable.heroStatusBase[1][4] * statMagnification[22])},	//レベル 23
				{(int)(heroStatusTable.heroStatusBase[1][0] * statMagnification[23]), (int)(heroStatusTable.heroStatusBase[1][1] * statMagnification[23]), (int)(heroStatusTable.heroStatusBase[1][2] * statMagnification[23]), (int)(heroStatusTable.heroStatusBase[1][3] * statMagnification[23]), (int)(heroStatusTable.heroStatusBase[1][4] * statMagnification[23])},	//レベル 24
				{(int)(heroStatusTable.heroStatusBase[1][0] * statMagnification[24]), (int)(heroStatusTable.heroStatusBase[1][1] * statMagnification[24]), (int)(heroStatusTable.heroStatusBase[1][2] * statMagnification[24]), (int)(heroStatusTable.heroStatusBase[1][3] * statMagnification[24]), (int)(heroStatusTable.heroStatusBase[1][4] * statMagnification[24])},	//レベル 25
				{(int)(heroStatusTable.heroStatusBase[1][0] * statMagnification[25]), (int)(heroStatusTable.heroStatusBase[1][1] * statMagnification[25]), (int)(heroStatusTable.heroStatusBase[1][2] * statMagnification[25]), (int)(heroStatusTable.heroStatusBase[1][3] * statMagnification[25]), (int)(heroStatusTable.heroStatusBase[1][4] * statMagnification[25])},	//レベル 26
				{(int)(heroStatusTable.heroStatusBase[1][0] * statMagnification[26]), (int)(heroStatusTable.heroStatusBase[1][1] * statMagnification[26]), (int)(heroStatusTable.heroStatusBase[1][2] * statMagnification[26]), (int)(heroStatusTable.heroStatusBase[1][3] * statMagnification[26]), (int)(heroStatusTable.heroStatusBase[1][4] * statMagnification[26])},	//レベル 27
				{(int)(heroStatusTable.heroStatusBase[1][0] * statMagnification[27]), (int)(heroStatusTable.heroStatusBase[1][1] * statMagnification[27]), (int)(heroStatusTable.heroStatusBase[1][2] * statMagnification[27]), (int)(heroStatusTable.heroStatusBase[1][3] * statMagnification[27]), (int)(heroStatusTable.heroStatusBase[1][4] * statMagnification[27])},	//レベル 28
				{(int)(heroStatusTable.heroStatusBase[1][0] * statMagnification[28]), (int)(heroStatusTable.heroStatusBase[1][1] * statMagnification[28]), (int)(heroStatusTable.heroStatusBase[1][2] * statMagnification[28]), (int)(heroStatusTable.heroStatusBase[1][3] * statMagnification[28]), (int)(heroStatusTable.heroStatusBase[1][4] * statMagnification[28])},	//レベル 29
				{(int)(heroStatusTable.heroStatusBase[1][0] * statMagnification[29]), (int)(heroStatusTable.heroStatusBase[1][1] * statMagnification[29]), (int)(heroStatusTable.heroStatusBase[1][2] * statMagnification[29]), (int)(heroStatusTable.heroStatusBase[1][3] * statMagnification[29]), (int)(heroStatusTable.heroStatusBase[1][4] * statMagnification[29])}	//レベル 30
			},
			
			{	//魔法使いのステータス	HP/ MP/ ATK/ DEF/ 必要経験値
				// レベル　１～１０
				{(int)(heroStatusTable.heroStatusBase[2][0] * statMagnification[0]), (int)(heroStatusTable.heroStatusBase[2][1] * statMagnification[0]), (int)(heroStatusTable.heroStatusBase[2][2] * statMagnification[0]), (int)(heroStatusTable.heroStatusBase[2][3] * statMagnification[0]), (int)(heroStatusTable.heroStatusBase[2][4] * statMagnification[0])}, 	//レベル 1
				{(int)(heroStatusTable.heroStatusBase[2][0] * statMagnification[1]), (int)(heroStatusTable.heroStatusBase[2][1] * statMagnification[1]), (int)(heroStatusTable.heroStatusBase[2][2] * statMagnification[1]), (int)(heroStatusTable.heroStatusBase[2][3] * statMagnification[1]), (int)(heroStatusTable.heroStatusBase[2][4] * statMagnification[1])},	//レベル 2
				{(int)(heroStatusTable.heroStatusBase[2][0] * statMagnification[2]), (int)(heroStatusTable.heroStatusBase[2][1] * statMagnification[2]), (int)(heroStatusTable.heroStatusBase[2][2] * statMagnification[2]), (int)(heroStatusTable.heroStatusBase[2][3] * statMagnification[2]), (int)(heroStatusTable.heroStatusBase[2][4] * statMagnification[2])},	//レベル 3
				{(int)(heroStatusTable.heroStatusBase[2][0] * statMagnification[3]), (int)(heroStatusTable.heroStatusBase[2][1] * statMagnification[3]), (int)(heroStatusTable.heroStatusBase[2][2] * statMagnification[3]), (int)(heroStatusTable.heroStatusBase[2][3] * statMagnification[3]), (int)(heroStatusTable.heroStatusBase[2][4] * statMagnification[3])},	//レベル 4
				{(int)(heroStatusTable.heroStatusBase[2][0] * statMagnification[4]), (int)(heroStatusTable.heroStatusBase[2][1] * statMagnification[4]), (int)(heroStatusTable.heroStatusBase[2][2] * statMagnification[4]), (int)(heroStatusTable.heroStatusBase[2][3] * statMagnification[4]), (int)(heroStatusTable.heroStatusBase[2][4] * statMagnification[4])},	//レベル 5
				{(int)(heroStatusTable.heroStatusBase[2][0] * statMagnification[5]), (int)(heroStatusTable.heroStatusBase[2][1] * statMagnification[5]), (int)(heroStatusTable.heroStatusBase[2][2] * statMagnification[5]), (int)(heroStatusTable.heroStatusBase[2][3] * statMagnification[5]), (int)(heroStatusTable.heroStatusBase[2][4] * statMagnification[5])},	//レベル 6
				{(int)(heroStatusTable.heroStatusBase[2][0] * statMagnification[6]), (int)(heroStatusTable.heroStatusBase[2][1] * statMagnification[6]), (int)(heroStatusTable.heroStatusBase[2][2] * statMagnification[6]), (int)(heroStatusTable.heroStatusBase[2][3] * statMagnification[6]), (int)(heroStatusTable.heroStatusBase[2][4] * statMagnification[6])},	//レベル 7
				{(int)(heroStatusTable.heroStatusBase[2][0] * statMagnification[7]), (int)(heroStatusTable.heroStatusBase[2][1] * statMagnification[7]), (int)(heroStatusTable.heroStatusBase[2][2] * statMagnification[7]), (int)(heroStatusTable.heroStatusBase[2][3] * statMagnification[7]), (int)(heroStatusTable.heroStatusBase[2][4] * statMagnification[7])},	//レベル 8
				{(int)(heroStatusTable.heroStatusBase[2][0] * statMagnification[8]), (int)(heroStatusTable.heroStatusBase[2][1] * statMagnification[8]), (int)(heroStatusTable.heroStatusBase[2][2] * statMagnification[8]), (int)(heroStatusTable.heroStatusBase[2][3] * statMagnification[8]), (int)(heroStatusTable.heroStatusBase[2][4] * statMagnification[8])},	//レベル 9
				{(int)(heroStatusTable.heroStatusBase[2][0] * statMagnification[9]), (int)(heroStatusTable.heroStatusBase[2][1] * statMagnification[9]), (int)(heroStatusTable.heroStatusBase[2][2] * statMagnification[9]), (int)(heroStatusTable.heroStatusBase[2][3] * statMagnification[9]), (int)(heroStatusTable.heroStatusBase[2][4] * statMagnification[9])},	//レベル 10
				// レベル　１１～２０
				{(int)(heroStatusTable.heroStatusBase[2][0] * statMagnification[10]), (int)(heroStatusTable.heroStatusBase[2][1] * statMagnification[10]), (int)(heroStatusTable.heroStatusBase[2][2] * statMagnification[10]), (int)(heroStatusTable.heroStatusBase[2][3] * statMagnification[10]), (int)(heroStatusTable.heroStatusBase[2][4] * statMagnification[10])}, 	//レベル 11
				{(int)(heroStatusTable.heroStatusBase[2][0] * statMagnification[11]), (int)(heroStatusTable.heroStatusBase[2][1] * statMagnification[11]), (int)(heroStatusTable.heroStatusBase[2][2] * statMagnification[11]), (int)(heroStatusTable.heroStatusBase[2][3] * statMagnification[11]), (int)(heroStatusTable.heroStatusBase[2][4] * statMagnification[11])},	//レベル 12
				{(int)(heroStatusTable.heroStatusBase[2][0] * statMagnification[12]), (int)(heroStatusTable.heroStatusBase[2][1] * statMagnification[12]), (int)(heroStatusTable.heroStatusBase[2][2] * statMagnification[12]), (int)(heroStatusTable.heroStatusBase[2][3] * statMagnification[12]), (int)(heroStatusTable.heroStatusBase[2][4] * statMagnification[12])},	//レベル 13
				{(int)(heroStatusTable.heroStatusBase[2][0] * statMagnification[13]), (int)(heroStatusTable.heroStatusBase[2][1] * statMagnification[13]), (int)(heroStatusTable.heroStatusBase[2][2] * statMagnification[13]), (int)(heroStatusTable.heroStatusBase[2][3] * statMagnification[13]), (int)(heroStatusTable.heroStatusBase[2][4] * statMagnification[13])},	//レベル 14
				{(int)(heroStatusTable.heroStatusBase[2][0] * statMagnification[14]), (int)(heroStatusTable.heroStatusBase[2][1] * statMagnification[14]), (int)(heroStatusTable.heroStatusBase[2][2] * statMagnification[14]), (int)(heroStatusTable.heroStatusBase[2][3] * statMagnification[14]), (int)(heroStatusTable.heroStatusBase[2][4] * statMagnification[14])},	//レベル 15
				{(int)(heroStatusTable.heroStatusBase[2][0] * statMagnification[15]), (int)(heroStatusTable.heroStatusBase[2][1] * statMagnification[15]), (int)(heroStatusTable.heroStatusBase[2][2] * statMagnification[15]), (int)(heroStatusTable.heroStatusBase[2][3] * statMagnification[15]), (int)(heroStatusTable.heroStatusBase[2][4] * statMagnification[15])},	//レベル 16
				{(int)(heroStatusTable.heroStatusBase[2][0] * statMagnification[16]), (int)(heroStatusTable.heroStatusBase[2][1] * statMagnification[16]), (int)(heroStatusTable.heroStatusBase[2][2] * statMagnification[16]), (int)(heroStatusTable.heroStatusBase[2][3] * statMagnification[16]), (int)(heroStatusTable.heroStatusBase[2][4] * statMagnification[16])},	//レベル 17
				{(int)(heroStatusTable.heroStatusBase[2][0] * statMagnification[17]), (int)(heroStatusTable.heroStatusBase[2][1] * statMagnification[17]), (int)(heroStatusTable.heroStatusBase[2][2] * statMagnification[17]), (int)(heroStatusTable.heroStatusBase[2][3] * statMagnification[17]), (int)(heroStatusTable.heroStatusBase[2][4] * statMagnification[17])},	//レベル 18
				{(int)(heroStatusTable.heroStatusBase[2][0] * statMagnification[18]), (int)(heroStatusTable.heroStatusBase[2][1] * statMagnification[18]), (int)(heroStatusTable.heroStatusBase[2][2] * statMagnification[18]), (int)(heroStatusTable.heroStatusBase[2][3] * statMagnification[18]), (int)(heroStatusTable.heroStatusBase[2][4] * statMagnification[18])},	//レベル 19
				{(int)(heroStatusTable.heroStatusBase[2][0] * statMagnification[19]), (int)(heroStatusTable.heroStatusBase[2][1] * statMagnification[19]), (int)(heroStatusTable.heroStatusBase[2][2] * statMagnification[19]), (int)(heroStatusTable.heroStatusBase[2][3] * statMagnification[19]), (int)(heroStatusTable.heroStatusBase[2][4] * statMagnification[19])},	//レベル 20
				// レベル　２１～３０
				{(int)(heroStatusTable.heroStatusBase[2][0] * statMagnification[20]), (int)(heroStatusTable.heroStatusBase[2][1] * statMagnification[20]), (int)(heroStatusTable.heroStatusBase[2][2] * statMagnification[20]), (int)(heroStatusTable.heroStatusBase[2][3] * statMagnification[20]), (int)(heroStatusTable.heroStatusBase[2][4] * statMagnification[20])}, 	//レベル 21
				{(int)(heroStatusTable.heroStatusBase[2][0] * statMagnification[21]), (int)(heroStatusTable.heroStatusBase[2][1] * statMagnification[21]), (int)(heroStatusTable.heroStatusBase[2][2] * statMagnification[21]), (int)(heroStatusTable.heroStatusBase[2][3] * statMagnification[21]), (int)(heroStatusTable.heroStatusBase[2][4] * statMagnification[21])},	//レベル 22
				{(int)(heroStatusTable.heroStatusBase[2][0] * statMagnification[22]), (int)(heroStatusTable.heroStatusBase[2][1] * statMagnification[22]), (int)(heroStatusTable.heroStatusBase[2][2] * statMagnification[22]), (int)(heroStatusTable.heroStatusBase[2][3] * statMagnification[22]), (int)(heroStatusTable.heroStatusBase[2][4] * statMagnification[22])},	//レベル 23
				{(int)(heroStatusTable.heroStatusBase[2][0] * statMagnification[23]), (int)(heroStatusTable.heroStatusBase[2][1] * statMagnification[23]), (int)(heroStatusTable.heroStatusBase[2][2] * statMagnification[23]), (int)(heroStatusTable.heroStatusBase[2][3] * statMagnification[23]), (int)(heroStatusTable.heroStatusBase[2][4] * statMagnification[23])},	//レベル 24
				{(int)(heroStatusTable.heroStatusBase[2][0] * statMagnification[24]), (int)(heroStatusTable.heroStatusBase[2][1] * statMagnification[24]), (int)(heroStatusTable.heroStatusBase[2][2] * statMagnification[24]), (int)(heroStatusTable.heroStatusBase[2][3] * statMagnification[24]), (int)(heroStatusTable.heroStatusBase[2][4] * statMagnification[24])},	//レベル 25
				{(int)(heroStatusTable.heroStatusBase[2][0] * statMagnification[25]), (int)(heroStatusTable.heroStatusBase[2][1] * statMagnification[25]), (int)(heroStatusTable.heroStatusBase[2][2] * statMagnification[25]), (int)(heroStatusTable.heroStatusBase[2][3] * statMagnification[25]), (int)(heroStatusTable.heroStatusBase[2][4] * statMagnification[25])},	//レベル 26
				{(int)(heroStatusTable.heroStatusBase[2][0] * statMagnification[26]), (int)(heroStatusTable.heroStatusBase[2][1] * statMagnification[26]), (int)(heroStatusTable.heroStatusBase[2][2] * statMagnification[26]), (int)(heroStatusTable.heroStatusBase[2][3] * statMagnification[26]), (int)(heroStatusTable.heroStatusBase[2][4] * statMagnification[26])},	//レベル 27
				{(int)(heroStatusTable.heroStatusBase[2][0] * statMagnification[27]), (int)(heroStatusTable.heroStatusBase[2][1] * statMagnification[27]), (int)(heroStatusTable.heroStatusBase[2][2] * statMagnification[27]), (int)(heroStatusTable.heroStatusBase[2][3] * statMagnification[27]), (int)(heroStatusTable.heroStatusBase[2][4] * statMagnification[27])},	//レベル 28
				{(int)(heroStatusTable.heroStatusBase[2][0] * statMagnification[28]), (int)(heroStatusTable.heroStatusBase[2][1] * statMagnification[28]), (int)(heroStatusTable.heroStatusBase[2][2] * statMagnification[28]), (int)(heroStatusTable.heroStatusBase[2][3] * statMagnification[28]), (int)(heroStatusTable.heroStatusBase[2][4] * statMagnification[28])},	//レベル 29
				{(int)(heroStatusTable.heroStatusBase[2][0] * statMagnification[29]), (int)(heroStatusTable.heroStatusBase[2][1] * statMagnification[29]), (int)(heroStatusTable.heroStatusBase[2][2] * statMagnification[29]), (int)(heroStatusTable.heroStatusBase[2][3] * statMagnification[29]), (int)(heroStatusTable.heroStatusBase[2][4] * statMagnification[29])}	//レベル 30
			}		
	};
}