package app.controller;

import app.asset.character.Hero;
import app.asset.character.Monster;
import app.model.Battle;
import app.table.heroStatusTable;
import app.utility.Util;
import app.utility.ViewUtil;

/*
 * 戦闘に関するメニュー選択や進行を行うクラス
 * 
 */

public class BattleController {
//	Controller controller = new Controller();
	private Hero[] heros = new Hero[3];
	private Hero hero;
	private Hero warrior;
	private Hero mage;

	public BattleController() {
		this.warrior = new Hero("戦士", 1, heroStatusTable.heroStatusMaster[1][0][0],
				heroStatusTable.heroStatusMaster[1][0][0], heroStatusTable.heroStatusMaster[1][0][1],
				heroStatusTable.heroStatusMaster[1][0][2], heroStatusTable.heroStatusMaster[1][0][3],
				heroStatusTable.heroStatusMaster[1][0][4]);
		this.mage = new Hero("魔法使い", 1, heroStatusTable.heroStatusMaster[0][0][0],
				heroStatusTable.heroStatusMaster[2][0][0], heroStatusTable.heroStatusMaster[2][0][1],
				heroStatusTable.heroStatusMaster[2][0][2], heroStatusTable.heroStatusMaster[2][0][3],
				heroStatusTable.heroStatusMaster[2][0][4]);

		heros[1] = warrior;
		heros[2] = mage;
	}

	// ゲーム開始時に呼び出されるメソッド
	// 勇者の名前を入力させ、その名前を元に勇者インスタンスを作成する
	public void initialize() {
		ViewUtil.scroll(60);
		System.out.println("RPGゲームへようこそ！\n");
		System.out.println("勇者の名前を入力してください");
		System.out.print(">>");

		String name = Util.scanner.nextLine();
		this.hero = new Hero("勇者" + name, 1, heroStatusTable.heroStatusMaster[0][0][0],
				heroStatusTable.heroStatusMaster[0][0][0], heroStatusTable.heroStatusMaster[0][0][1],
				heroStatusTable.heroStatusMaster[0][0][2], heroStatusTable.heroStatusMaster[0][0][3],
				heroStatusTable.heroStatusMaster[0][0][4]);
		this.heros[0] = this.hero;
		ViewUtil.scrollSlow(2);

		System.out.println("ようこそ" + this.hero.name + "さん");
		ViewUtil.wait(1);
		System.out.println("あなたのステータスは以下の通りです");
		this.hero.showStatus();
		ViewUtil.wait(1);
	}

	// 戦闘を行うメソッド
	public void battle() {
		/*
		 * popMonsterメソッド 引数として受け取った数に応じたMonster型のインスタンスを生成し、配列に格納したあと戻り値として値を返す
		 */
		Monster[] monsters = Battle.popMonster(Util.random.nextInt(1, 5));
		Battle.showMonster(monsters);

		// モンスターが全滅するか、ヒーローが全滅するまで戦闘を繰り返す
		while (Battle.isAllDead(monsters) == false && Battle.isAllDead(heros) == false) {
			System.out.println("=========================================");
			System.out.println("1.たたかう       Lv." + heros[0].level + " " + heros[0].name + "   HP:" + heros[0].hp + "  MP:" + heros[0].mp);
			System.out.println("2.ぼうぎょ       Lv." + heros[1].level + " " + heros[1].name + "   HP:" + heros[1].hp + "  MP:" + heros[1].mp);
			System.out.println("3.逃げる      Lv." + heros[2].level + " " + heros[2].name + "  HP:" + heros[2].hp + "   MP:" + heros[2].mp);
			System.out.println("=========================================");
			System.out.print("\n>>");

			String nextAction = Util.scanner.nextLine();

			if ("3".equals(nextAction)) {
				ViewUtil.scrollSlow(2);
				System.out.println("勇者たちは逃げ出した");
				break;
			}

			switch (nextAction) {
			case "1":
				Battle.attak(heros, monsters);
				Battle.attak(monsters, heros);
				Battle.showMonsterHp(monsters);
				ViewUtil.scroll(2);
				break;
			case "2":
				System.out.println("現在順備中");
				ViewUtil.scrollSlow(4);
				break;
			}
		}
		System.out.println("\n戦闘終了！\n");
		Util.scanner.nextLine();
	}

	public void debugBattle() {
		Monster[] monsters = Battle.popMonster(Util.random.nextInt(1, 5));
		for (Monster m : monsters) {
			System.out.println(m.name + "が現れた!");
			ViewUtil.wait(1);
		}
		ViewUtil.scrollSlow(2);
		while (Battle.isAllDead(monsters) == false && Battle.isAllDead(heros) == false) {
			System.out.println("=========================================");
			System.out.println("1.たたかう    :" + heros[0].name + "HP:" + heros[0].hp);
			System.out.println("2.ぼうぎょ");
			System.out.println("3.逃げる");
			System.out.println("=========================================");
			System.out.print("\n>>");

			Battle.attak(heros, monsters);
			Battle.attak(monsters, heros);
			Battle.showMonsterHp(monsters);
			ViewUtil.scroll(2);
		}
		System.out.println("\n戦闘終了！\n");
		Util.scanner.nextLine();
		System.exit(0);
	}

	// デバッグモード
	// ヒーローのステータスを9999に設定する
	public void debugMenu() {
		this.hero = new Hero("無敵の勇者", 99, 999, 999, 999, 100, 999, 9999);
		this.heros[0] = this.hero;

		ViewUtil.scrollSlow(4);
		System.out.println("===デバッグモードに入りました===");
		ViewUtil.wait(1);
		System.out.println("あなたのステータスは以下の通りです");
		this.hero.showStatus();
		ViewUtil.wait(1);
		System.out.println("実行するメニューを選択してください");
		System.out.println("1.冒険に出る");
		System.out.println("2.戦闘画面チェック");
		System.out.println("4.終了する");
		System.out.print(">>");

		String nextAction = Util.scanner.nextLine();

		if ("4".equals(nextAction)) {
			System.out.println("メインメニューへ戻ります");
		}

		switch (nextAction) {
		case "1":
			this.battle();
			break;
		case "2":
			this.debugBattle();
			break;
		default: {
			System.out.println("正しい値を入力してください");
		}
		}
	}
}
