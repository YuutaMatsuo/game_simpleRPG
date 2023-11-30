package app.controller;

import app.asset.character.Hero;
import app.asset.character.Monster;
import app.utility.BattleUtil;
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
		warrior = new Hero("戦士", 150, 0, 20, 35);
		mage = new Hero("魔法使い", 70, 50, 35, 10);

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
		this.hero = new Hero("勇者" + name);
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
		Monster[] monsters = BattleUtil.popMonster(Util.random.nextInt(1, 5));
		BattleUtil.showMonster(monsters);

		// モンスターが全滅するか、ヒーローが全滅するまで戦闘を繰り返す
		while (BattleUtil.isAllDead(monsters) == false && BattleUtil.isAllDead(heros) == false) {
			System.out.println("=========================================");
			System.out.println("1.たたかう       " + heros[0].name + "   HP:" + heros[0].hp + "  MP:" + heros[0].mp);
			System.out.println("2.ぼうぎょ       " + heros[1].name + "   HP:" + heros[1].hp + "  MP:" + heros[1].mp);
			System.out.println("3.逃げる      " + heros[2].name + "  HP:" + heros[2].hp + "   MP:" + heros[2].mp);
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
				BattleUtil.attak(heros, monsters);
				BattleUtil.attak(monsters, heros);
				BattleUtil.showMonsterHp(monsters);
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
		Monster[] monsters = BattleUtil.popMonster(Util.random.nextInt(1, 5));
		for (Monster m : monsters) {
			System.out.println(m.name + "が現れた!");
			ViewUtil.wait(1);
		}
		ViewUtil.scrollSlow(2);
		while (BattleUtil.isAllDead(monsters) == false && BattleUtil.isAllDead(heros) == false) {
			System.out.println("=========================================");
			System.out.println("1.たたかう    :" + heros[0].name + "HP:" + heros[0].hp);
			System.out.println("2.ぼうぎょ");
			System.out.println("3.逃げる");
			System.out.println("=========================================");
			System.out.print("\n>>");

			BattleUtil.attak(heros, monsters);
			BattleUtil.attak(monsters, heros);
			BattleUtil.showMonsterHp(monsters);
			ViewUtil.scroll(2);
		}
		System.out.println("\n戦闘終了！\n");
		Util.scanner.nextLine();
		System.exit(0);
	}

	// デバッグモード
	// ヒーローのステータスを9999に設定する
	public void debugMenu() {
		this.hero = new Hero("無敵の勇者", 9999, 9999, 9999, 9999);
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
