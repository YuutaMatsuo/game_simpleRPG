package app.controller;

import java.util.Random;
import java.util.Scanner;

import app.asset.character.Hero;
import app.asset.monster.Monster;
import app.manager.BattleManager;
import app.manager.ViewManager;

public class BattleController {
	private Hero[] heros = new Hero[3];

	private ViewManager vm;
	private BattleManager bm;

	public BattleController() {
		heros[0] = new Hero("戦士");
		heros[1] = new Hero("魔法使い");
		heros[2] = new Hero("僧侶");

		this.vm = new ViewManager();
		this.bm = new BattleManager();
	}

	public void start() {
		Scanner scanner = new Scanner(System.in);
		vm.scroll(60);
		System.out.println("冒険に出発！");
		this.battle();
	}

	public void battle() {
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();

		Monster[] monsters = bm.popMonster(random.nextInt(1, 3));
		for (Monster m : monsters) {
			System.out.println(m.name + "が現れた!");
			vm.wait(1);
		}
		vm.scrollSlow(2);

		while (monsters[0].isAlive() == true) {
			System.out.println("1.戦う");
			System.out.println("2.逃げる");
			System.out.print(">>");

			String nextAction = scanner.nextLine();

			if ("2".equals(nextAction)) {
				vm.scrollSlow(2);
				System.out.println("勇者たちは逃げ出した");
				break;
			}

			switch (nextAction) {
			case "1":
				bm.attak(heros, monsters);
				bm.attak(monsters, heros);
				System.out.println("====================");
				for(Monster m : monsters) {
					System.out.println(m.name + " HP:" + m.hp);
				}
				vm.scrollSlow(2);
				for(Hero h : heros) {
					System.out.println(h.name + " HP:" + h.hp);
				}
				System.out.println("====================\n");
				break;
			}
		}
		System.out.println("\n戦闘終了！\n");
		scanner.nextLine();
		this.start();
	}
}
