package app.asset.character;

import app.table.heroStatusTable;

public class Brave extends Human {
	private int job;

	// コンストラクタ
	public Brave(String name, int level, int hp, int maxHp, int mp, int atk, int def, int exp) {
		super("戦士" + name, level, hp, maxHp, mp, atk, def, exp);
	}

	public Brave(String name, int job) {
		super("勇者" + name, 0, heroStatusTable.heroStatusMaster[job][0][0], heroStatusTable.heroStatusMaster[job][0][0],
				heroStatusTable.heroStatusMaster[job][0][1], heroStatusTable.heroStatusMaster[job][0][2],
				heroStatusTable.heroStatusMaster[job][0][3], heroStatusTable.heroStatusMaster[job][0][4]);
		this.job = job;
	}

	// レベルアップ処理
	public void LevelUp() {
		if (super.isDebugMode()) {
			System.out.println("デバッグモードの為" + super.getName() + "のレベルアップ処理をスキップします");
		} else if (super.isLevelUp()) {
			super.setLevel(getLevel() + 1);
			super.setHp(heroStatusTable.heroStatusMaster[this.job][super.getLevel()][0]);
			super.setMaxHp(heroStatusTable.heroStatusMaster[this.job][super.getLevel()][0]);
			super.setMp(heroStatusTable.heroStatusMaster[this.job][super.getLevel()][1]);
			super.setAtk(heroStatusTable.heroStatusMaster[this.job][super.getLevel()][2]);
			super.setDef(heroStatusTable.heroStatusMaster[this.job][super.getLevel()][3]);
			super.setNextExp(heroStatusTable.heroStatusMaster[this.job][super.getLevel()][4]);

			System.out.println(super.getName() + "は Lv." + super.getLevel() + "にレベルアップしました！");
		}
	}
}
