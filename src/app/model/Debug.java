package app.model;

import java.util.Scanner;

import app.asset.character.Hero;
import app.controller.Controller;
import app.logic.Util;
import app.view.View;

public class Debug {
	public Controller controller;
	public Field field;
	public Dungeon dungeon;
	public Inn inn;

	public Hero[] heros;
	public Hero hero;
	public Hero warrior;
	public Hero mage;

	// デバッグメニュー 機能の確認用 各種処理へのショートカット
	public void debugMenu() {
		while (true) {
			System.out.println("実行するメニューを選択してください");
			System.out.println("1.戦闘チェック");
			System.out.println("2.ダンジョンチェック");
			System.out.println("3.ステータス一覧表示");
			System.out.println("4.終了する");
			System.out.print(">>");

			String nextAction = new Scanner(System.in).nextLine();

			if ("4".equals(nextAction)) {
				System.out.println("メインメニューへ戻ります");
				controller.start();
			}

			switch (nextAction) {
			case "1":
				field.continuousBattleMode = true;
				int count = debugContinue();
				View.load();
				while (count > 0) {
					field.battle();
					count--;
				}
				View.scroll(2);
				this.debugMenu();
				break;
			case "2":
				System.out.println("制作中");
				;
				break;
			case "3":
				View.showAllStatus();
				View.scroll(2);
				this.debugMenu();
				break;
			}
		}
	}

	public int debugContinue() {
		System.out.println("戦闘回数を入力してください");
		System.out.print(">>");
		int count = Util.scanner.nextInt();
		return count;
	}
}
