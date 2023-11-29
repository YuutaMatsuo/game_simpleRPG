package app.manager;

import java.util.Scanner;

import app.asset.character.Hero;
import app.asset.monster.Monster;

public class BattleManager {
	private Hero warrior;
	private Hero wizard;
	private Hero priest;

	private Monster slime;
	private Monster goblin;
	private Monster orc;

	private ViewManager vm;

	public BattleManager() {
		this.warrior = new Hero("戦士", 100, 10, 20);
		this.wizard = new Hero("魔法使い", 80, 20, 10);
		this.priest = new Hero("僧侶", 60, 30, 10);

//		this.slime = new Monster("スライム", 150, 5);
		this.goblin = new Monster("ゴブリン", 30, 10);
		this.orc = new Monster("オーク", 40, 15);

		this.vm = new ViewManager();
	}

	public void start() {
		Scanner scanner = new Scanner(System.in);
		vm.scroll(60);
		System.out.println("冒険に出発！");
		this.battle();
	}

	public void battle() {
		Scanner scanner = new Scanner(System.in);
		this.slime = new Monster("スライム", 80, 5);
		System.out.println(slime.name + "が現れた！\n");
		while (slime.isAlive() == true) {
			System.out.println("1.戦う");
			System.out.println("2.逃げる");
			System.out.print(">>");

			String nextAction = scanner.nextLine();

			if ("2".equals(nextAction)) {
				vm.slowl(2);
				System.out.println(warrior.name + "は逃げ出した");
				System.out.println(wizard.name + "は逃げ出した");
				System.out.println(priest.name + "は逃げ出した");
				break;
			}

			switch (nextAction) {
			case "1":
				warrior.attack(slime);
				vm.slowl(2);
				slime.attack(warrior);
				vm.slowl(2);
				wizard.attack(slime);
				vm.slowl(2);
				slime.attack(wizard);
				vm.slowl(2);
				priest.attack(slime);
				vm.slowl(2);
				slime.attack(priest);
				vm.slowl(2);
				System.out.println(slime.name + "の残りHP:" + slime.hp);
				vm.slowl(2);
				System.out.println(warrior.name + "の残りHP:" + warrior.hp);
				System.out.println(wizard.name + "の残りHP:" + wizard.hp);
				System.out.println(priest.name + "の残りHP:" + priest.hp);
				vm.slowl(1);
				break;
			}
		}
		System.out.println("\n戦闘終了！\n");
		scanner.nextLine();
		this.start();
	}
}
