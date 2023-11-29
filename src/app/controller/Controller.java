package app.controller;

import java.util.Scanner;

import app.manager.BattleManager;
import app.manager.ViewManager;

public class Controller {
	private ViewManager vm;
	private BattleManager bm;
	private BattleController bc;

	public Controller() {
		this.vm = new ViewManager();
		this.bm = new BattleManager();
		this.bc = new BattleController();
	}

	public void start() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("simpleRPGへようこそ！\n");
		vm.wait(3);
		vm.scroll(70);

		while (true) {
			System.out.println("実行する操作を選んでください");
			System.out.println("1.冒険に出る");
			System.out.println("2.宿屋に泊まる");
			System.out.println("3.お店に行く");
			System.out.println("4.終了する");
			System.out.print(">>");

			String nextAction = scanner.nextLine();

			if ("4".equals(nextAction)) {
				System.out.println("ゲームを終了します");
				break;
			}

			switch (nextAction) {
			case "1":
				bc.start();
				break;
			case "2":
				System.out.println("現在準備中");
				break;
			case "3":
				System.out.println("現在準備中");
				break;
			}
		}
	}
}
