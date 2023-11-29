package app.controller;

import app.asset.character.Hero;
import app.utility.Util;
import app.utility.ViewUtil;

/*
 * メニュー選択や進行を行うクラス
 * インスタンスを持たないstaticクラス
 */

public class Controller {
	static Hero hero;
	
	//メインメニュー
	public static void start() {
		ViewUtil.showTitle();
		ViewUtil.wait(2);
		ViewUtil.scroll(30);

		while (true) {
			System.out.println("1.はじめから");
			System.out.println("2.つづきから");
			System.out.println("3.デバッグモード");
			System.out.println("4.終了する");
			System.out.print(">>");

			String nextAction = Util.scanner.nextLine();

			if ("4".equals(nextAction)) {
				System.out.println("ゲームを終了します");
				System.exit(0);
				break;
			}

			switch (nextAction) {
			case "1":
				Controller.initialize();
				break;
			case "2":
				System.out.println("現在準備中\n");
				ViewUtil.wait(2);
				ViewUtil.scroll(60);
				Controller.start();
				break;
			case "3":
				Controller.debugMenu();
				break;
			}
		}
	}
	
	//ゲーム開始時に呼び出されるメソッド
	//勇者の名前を入力させ、その名前を元に勇者インスタンスを作成する
	public static void initialize() {
		ViewUtil.scroll(60);
		System.out.println("RPGゲームへようこそ！\n");
		System.out.println("勇者の名前を入力してください");
		System.out.print(">>");

		String name = Util.scanner.nextLine();
		Controller.hero = new Hero("勇者" + name);
		BattleController.heros[0] = Controller.hero;
		ViewUtil.scrollSlow(2);

		System.out.println("ようこそ" + Controller.hero.name + "さん");
		ViewUtil.wait(1);
		System.out.println("あなたのステータスは以下の通りです");
		Controller.hero.showStatus();
		ViewUtil.wait(1);
		System.out.println("それでは冒険の旅にいってらっしゃい！");
		Controller.topMenu();
	}
	
	//トップメニュー
	public static void topMenu() {
		ViewUtil.scrollSlow(4);
		System.out.println("実行するメニューを選択してください");
		System.out.println("1.冒険に出る");
		System.out.println("4.終了する");
		System.out.print(">>");

		String nextAction = Util.scanner.nextLine();

		if ("4".equals(nextAction)) {
			System.out.println("メインメニューへ戻ります");
			Controller.start();
		}

		switch (nextAction) {
		case "1":
			BattleController.battle();
			break;
		default: {
			System.out.println("正しい値を入力してください");
			Controller.topMenu();
		}
		}
	}
	
	//デバッグモード
	//ヒーローのステータスを9999に設定する
	public static void debugMenu() {
		Controller.hero = new Hero("無敵の勇者",9999,9999,100);
		BattleController.heros[0] = Controller.hero;
		
		ViewUtil.scrollSlow(4);
		System.out.println("===デバッグモードに入りました===");
		ViewUtil.wait(1);
		System.out.println("あなたのステータスは以下の通りです");
		Controller.hero.showStatus();
		ViewUtil.wait(1);
		System.out.println("実行するメニューを選択してください");
		System.out.println("1.冒険に出る");
		System.out.println("4.終了する");
		System.out.print(">>");

		String nextAction = Util.scanner.nextLine();

		if ("4".equals(nextAction)) {
			System.out.println("メインメニューへ戻ります");
			Controller.start();
		}

		switch (nextAction) {
		case "1":
			BattleController.battle();
			break;
		default: {
			System.out.println("正しい値を入力してください");
			Controller.topMenu();
		}
		}
	}
}
