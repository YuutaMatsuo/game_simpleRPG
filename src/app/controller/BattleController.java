package app.controller;

import app.asset.character.Hero;
import app.asset.character.Monster;
import app.utility.BattleUtil;
import app.utility.Util;
import app.utility.ViewUtil;

/*
 * 戦闘に関するメニュー選択や進行を行うクラス
 * インスタンスを持たないstaticクラス
 */

public class BattleController {
	static Hero[] heros = new Hero[1];

	// 戦闘を行うメソッド
	public static void battle() {
		Monster[] monsters = BattleUtil.popMonster(Util.random.nextInt(1, 5));
		for (Monster m : monsters) {
			System.out.println(m.name + "が現れた!");
			ViewUtil.wait(1);
		}
		ViewUtil.scrollSlow(2);

		// モンスターが全滅するか、ヒーローが全滅するまで戦闘を繰り返す
		while (BattleUtil.isAllDead(monsters) == false && BattleUtil.isAllDead(heros) == false) {
			System.out.println("1.たたかう    :" + heros[0].name + "HP:" + heros[0].hp);
			System.out.println("2.ぼうぎょ");
			System.out.println("3.逃げる");
			System.out.print(">>");

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
//				System.out.println("====================");
				BattleUtil.showMonsterHp(monsters);
//				BattleUtil.showHeroHp(heros);
				System.out.println("====================\n");
				break;
			case "2":
				System.out.println("現在順備中");
				ViewUtil.scrollSlow(4);
				break;
			}
		}
		System.out.println("\n戦闘終了！\n");
		Util.scanner.nextLine();
		Controller.topMenu();
	}
}
