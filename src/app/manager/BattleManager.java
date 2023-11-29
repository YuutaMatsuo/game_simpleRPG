package app.manager;

import java.util.Random;

import app.asset.character.Hero;
import app.asset.monster.Monster;

public class BattleManager {
	Random r;
	ViewManager vm;
	String[] monsterName = { "スライム", "キングスライム", "メタルスライム" };
	int[][] monsterStatus = { { 70, 5 }, // スライム HP atk
			{ 300, 12 }, // キングスライム HP atk
			{ 800, 50 }, // ゴブリン HP atk
	};

	public BattleManager() {
		vm = new ViewManager();
	}

	public Monster[] popMonster(int num) {
		Monster[] monsters = new Monster[num];
		Monster monster;
		int r;
		for (int i = 0; i < num; i++) {
			r = new Random().nextInt(3);
			monsters[i] = new Monster(this.monsterName[r], monsterStatus[r][0], monsterStatus[r][1]);
		}
		return monsters;
	}

	public void attak(Hero[] h, Monster[] m) {
		int r;
		for (Hero hero : h) {
			r = new Random().nextInt(m.length);
			hero.attack(m[r]);
			vm.scrollSlow(2);
		}
	}

	public void attak(Monster[] m, Hero[] h) {
		int r;
		for (Monster monster : m) {
			r = new Random().nextInt(h.length);
			monster.attack(h[r]);
			vm.scrollSlow(2);
		}
	}
}
