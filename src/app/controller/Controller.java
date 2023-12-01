package app.controller;

import app.utility.Util;
import app.utility.ViewUtil;

/*
 * メニュー選択や進行を行うクラス
 * 
 */

public class Controller {
	BattleController bc = new BattleController();

	// メインメニュー
	public void start() {
		ViewUtil.showTitle();
		ViewUtil.wait(2);
		ViewUtil.scroll(10);
		
	

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
				bc.initialize();
				this.menu();
				break;
			case "2":
				System.out.println("現在準備中\n");
				ViewUtil.wait(2);
				ViewUtil.scroll(60);
				this.start();
				break;
			case "3":
				bc.debugMenu();
				break;
			}
		}
	}

	// トップメニュー
	public void menu() {
		ViewUtil.scrollSlow(4);
		System.out.println("実行するメニューを選択してください");
		System.out.println("1.冒険に出る");
		System.out.println("4.終了する");
		System.out.print(">>");

		String nextAction = Util.scanner.nextLine();

		if ("4".equals(nextAction)) {
			System.out.println("メインメニューへ戻ります");
			this.start();
		}

		switch (nextAction) {
		case "1":
			bc.battle();
			this.menu();
			break;
		default: {
			System.out.println("正しい値を入力してください");
			this.menu();
		}
		}
	}
}
