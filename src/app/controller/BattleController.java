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
		ViewUtil.scroll(2);
		int exp = Battle.totalExp(monsters);

		// モンスターが全滅するか、ヒーローが全滅するまで戦闘を繰り返す
		while (Battle.isAllDead(monsters) == false && Battle.isAllDead(heros) == false) {
			ViewUtil.battleMenu(heros);

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
		System.out.println("戦闘終了！");
		ViewUtil.scrollSlow(4);
		Battle.addExp(heros, exp);
		ViewUtil.scroll(2);
		Battle.LevelUp(heros);
		Util.scanner.nextLine();
	}

	public void debugBattle() {
		for (int i = 0; i < 30; i++) {
			Monster[] monsters = Battle.popMonster(Util.random.nextInt(1, 5));
			int exp = Battle.totalExp(monsters);
			ViewUtil.scroll(2);
			Battle.showMonster(monsters);

			while (Battle.isAllDead(monsters) == false && Battle.isAllDead(heros) == false) {
				ViewUtil.battleMenu(heros);

				Battle.attak(heros, monsters);
				Battle.attak(monsters, heros);
				Battle.showMonsterHp(monsters);
				ViewUtil.scroll(2);

			}
			System.out.println("戦闘終了！");
			ViewUtil.scrollSlow(4);
			Battle.addExp(heros, exp);
			ViewUtil.scroll(2);
			Battle.LevelUp(heros);
		}
		this.debugMenu();
	}

	// デバッグモード
	// ヒーローのステータスを9999に設定する
	public void debugInitialize() {
		this.hero = new Hero("無敵の勇者", 99, 999, 999, 999, 30, 999, 100);
		this.warrior = new Hero("無敵の戦士", 99, 999, 999, 999, 30, 999, 100);
		this.mage = new Hero("無敵の魔法使い", 99, 999, 999, 999, 30, 999, 100);
		this.heros[0] = this.hero;
		this.heros[1] = this.warrior;
		this.heros[2] = this.mage;
		//Heroインスタンスのデバッグフラグをtrueにする
		//Levelマックスキャラの為、レベルアップ処理をスキップさせる。
		this.hero.debugMode = true;
		this.warrior.debugMode = true;
		this.mage.debugMode = true;

		System.out.println("===デバッグモードに入りました===");
		System.out.println();
		System.out.println("あなたのステータスは以下の通りです");
		this.hero.showStatus();
		ViewUtil.scroll(2);
		this.debugMenu();
	}

	public void debugMenu() {
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
