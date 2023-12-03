package app.controller;

import java.util.Scanner;

import app.asset.character.Hero;
import app.logic.Util;
import app.model.Debug;
import app.model.Dungeon;
import app.model.Field;
import app.model.Inn;
import app.view.View;

/*
 * メニュー選択や進行を行うクラス
 * 勇者インスタンスの生成もここで行う
 */

public class Controller {
	public Field field;
	public Dungeon dungeon = new Dungeon();
	public Inn inn = new Inn();
	public Debug debug;

	Hero[] heros = new Hero[3];
	Hero hero;
	Hero warrior;
	Hero mage;

	// コンストラクタ
	public Controller() {
		this.hero = new Hero("勇者", 0);
		this.warrior = new Hero("戦士", 1);
		this.mage = new Hero("魔法使い", 2);
	}

	// ゲーム開始時に呼び出されるメソッド
	// 勇者の名前を入力させ、その名前を元に勇者インスタンスを作成する
	public void initialize() {
		View.scroll(60);
		System.out.println("RPGゲームへようこそ！\n");
		System.out.println("勇者の名前を入力してください");
		System.out.print(">>");

		String name = Util.scanner.nextLine();
		// ヒーローテーブルを参照して勇者を生成する
		this.hero.name += name;
		this.heros[0] = this.hero;
		this.heros[1] = this.warrior;
		this.heros[2] = this.mage;

		// 各インスタンスへ勇者のインスタンスを代入
		field.heros = this.heros;
		dungeon.heros = this.heros;
		inn.heros = this.heros;
		debug.heros = this.heros;

		View.scrollSlow(2);

		System.out.println("ようこそ" + this.hero.name + "さん");
		View.wait(1);
		System.out.println("");
		View.scroll(6);
		View.load();
	}

	// デバッグモード
	// ヒーローのステータスを設定する
	public void debugInitialize() {
		// ヒーローテーブルを参照して勇者を生成する
		this.hero = new Hero("テスト勇者", 0);
		this.warrior = new Hero("テスト戦士", 1);
		this.mage = new Hero("テスト魔法使い", 2);
		this.heros[0] = this.hero;
		this.heros[1] = this.warrior;
		this.heros[2] = this.mage;
		
		// 各インスタンスへ勇者のインスタンスを代入
		field.heros = this.heros;
		dungeon.heros = this.heros;
		inn.heros = this.heros;
		debug.heros = this.heros;
		
		//デバッグインスタンスへ各インスタンスを代入
		debug.field = this.field;
		debug.dungeon = this.dungeon;
		debug.inn = this.inn;


		System.out.println("===デバッグモードに入りました===");
		View.scroll(2);
		System.out.println("勇者パーティーの強さを選択してください");
		System.out.println("1.最強 Lv.100");
		System.out.println("2.戦闘チェック用 Lv.1");
		System.out.println("3.戦闘チェック用 Lv.10");
		System.out.println("4.戦闘チェック用 Lv.20");
		System.out.println("5.戦闘チェック用 Lv.30");
		System.out.print(">>");

		String nextAction = new Scanner(System.in).nextLine();

		switch (nextAction) {
		case "1":
			Util.changeStatus(heros);
		case "2":
			Util.changeStatus(heros, 1);
			break;
		case "3":
			Util.changeStatus(heros, 10);
			break;
		case "4":
			Util.changeStatus(heros, 20);
			break;
		case "5":
			Util.changeStatus(heros, 30);
			break;
		}
		
		System.out.println();
		System.out.println("パーティーのステータスは以下の通りです");
		View.showAllStatus(heros);
		View.scroll(2);
	}

	// メインメニュー
	public void start() {
		while (true) {
			View.showTitle();
			View.wait(2);
			View.scroll(10);

			System.out.println("1.はじめから");
			System.out.println("2.終了する");
			System.out.println("3.デバッグモード");
			System.out.print(">>");

			String nextAction = new Scanner(System.in).nextLine();

			if ("2".equals(nextAction)) {
				System.out.println("ゲームを終了します");
				System.exit(0);
				break;
			}

			switch (nextAction) {
			case "1":
				this.initialize();
				this.menu();
				break;
			case "3":
				this.debugInitialize();
				debug.debugMenu();
				break;
			}
		}
	}

	// トップメニュー
	public void menu() {
		while (true) {
			View.showAllStatus(heros);
			View.scroll(2);
			System.out.println("実行するメニューを選択してください");
			System.out.println("1.冒険に出る");
			System.out.println("2.ダンジョンに挑戦する");
			System.out.println("3.宿屋で休む");
			System.out.println("4.メインメニューへ戻る");
			System.out.print(">>");

			String nextAction = new Scanner(System.in).nextLine();

			if ("4".equals(nextAction)) {
				System.out.println("メインメニューへ戻ります");
				View.load();
				this.start();
			}

			switch (nextAction) {
			case "1":
				field.start();
				break;
			case "2":
				dungeon.start();
				break;
			case "3":
				inn.start();
				break;
			}
		}
	}
}
