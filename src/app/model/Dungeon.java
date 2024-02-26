package app.model;

import java.util.Random;
import java.util.Scanner;

import app.asset.character.Blackmage;
import app.asset.character.Brave;
import app.asset.character.Human;
import app.asset.character.Monster;
import app.asset.character.Warrior;
import app.controller.Controller;
import app.logic.Battle;
import app.view.View;

public class Dungeon {

	public Controller controller;
	public Human[] heros;
	Scanner scanner = new Scanner(System.in);
	Random random = new Random();

	// 連続戦闘モード 初期値false デバッグの際に使用
	public boolean continuousBattleMode = false;
	// 防御モード 戦闘中の防御力上昇
	public boolean defenceMode = false;

	public Dungeon() {

	}

	//
	public void start() {
		View.feildMessage();
		for (int i = 0; i < 3; i++) {
			System.out.println("Battle " + (i + 1) + "/3");
			View.scroll(2);
			this.battle();
		}
		System.out.println("冒険おつかれさま！\nメニューにもどります！");
		View.load();
	}

	// 戦闘を行うメソッド
	public void battle() {
		/*
		 * popMonsterメソッド 引数として受け取った数に応じたMonster型のインスタンスを生成し、配列に格納したあと戻り値として値を返す
		 */
		Monster[] monsters = Battle.createMonster(this.random.nextInt(1, 5), this.heros[0].getLevel());
		Battle.showMonster(monsters);
		View.scroll(2);
		View.showAllStatus(monsters);
		int exp = Battle.totalExp(monsters);
		int gold = Battle.totalGold(monsters);
		String nextAction;

		// モンスターが全滅するか、ヒーローが全滅するまで戦闘を繰り返す
		while (Battle.isAllDead(monsters) == false && Battle.isAllDead(this.heros) == false) {
			View.battleMenu(this.heros);

			if (this.continuousBattleMode == true) {
				nextAction = "1";
			} else {
				nextAction = new Scanner(System.in).nextLine();
			}

			if ("3".equals(nextAction)) {
				View.scrollSlow(2);
				System.out.println("勇者たちは逃げ出した");
				View.scroll(2);
				View.load();
				controller.menu();
			}

			switch (nextAction) {
			case "1":
				for (Human h : this.heros) {
					h.attack(monsters);
				}
				for (Monster m : monsters) {
					m.attack(this.heros);
				}
				View.showAllStatus(monsters);
				View.scroll(2);
				break;
			case "2":
				for (Human h : this.heros) {
					h.setDefendMode(true);
				}
				for (Monster m : monsters) {
					m.attack(this.heros);
				}
				for (Human h : this.heros) {
					h.setDefendMode(false);
				}
				break;
			}
			if (Battle.isAllDead(heros)) {
				System.out.println("勇者達は死んでしまった・・・・・");
				View.scroll(4);
				View.load();
				controller.start();
				break;
			}
		}
		if (!Battle.isAllDead(heros)) {
			System.out.println("戦闘終了！");
			View.scrollSlow(4);
			for (Human h : this.heros) {
				h.addExp(exp);
			}
			for (Human h : this.heros) {
				h.addGold(gold);
			}
			View.scroll(2);
			for (Human h : this.heros) {
				if (h instanceof Brave) {
					((Brave) h).levelUp();
				} else if (h instanceof Warrior) {
					((Warrior) h).levelUp();
				} else if (h instanceof Blackmage) {
					((Blackmage) h).levelUp();
				}
			}
			View.scroll(4);
		}
	}
}
