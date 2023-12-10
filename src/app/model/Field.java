package app.model;

import java.util.Scanner;

import app.asset.character.Human;
import app.asset.character.Monster;
import app.controller.Controller;
import app.logic.Battle;
import app.logic.Util;
import app.view.View;

public class Field {

	public Controller controller;
	public Human[] heros;

	// 連続戦闘モード 初期値false デバッグの際に使用
	public boolean continuousBattleMode = false;
	// 防御モード 戦闘中の防御力上昇
	public boolean defenceMode = false;

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
		Monster[] monsters = Battle.popMonster(Util.random.nextInt(1, 5), this.heros[0].level);
		Battle.showMonster(monsters);
		View.scroll(2);
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
				Battle.attak(this.heros, monsters);
				Battle.attak(monsters, this.heros, defenceMode);
				Battle.showMonsterHp(monsters);
				View.scroll(2);
				break;
			case "2":
				this.defenceMode = true;
				Battle.attak(monsters, heros, defenceMode);
				this.defenceMode = false;
				Battle.showMonsterHp(monsters);
				View.scrollSlow(4);
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
			Battle.addExp(this.heros, exp);
			Battle.addGold(this.heros, gold);
			View.scroll(2);
			Battle.LevelUp(this.heros);
			View.scroll(4);
		}
	}
}
