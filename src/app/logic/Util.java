package app.logic;

import app.asset.character.Human;

/*
 * 便利な処理をまとめたクラス
 * インスタンスを持たないstaticクラス
 */

public class Util {
	
	//　配列を受け取りMaxHP分回復を行う
	public static void allHeal(Human[] heros) {
		for(Human h : heros) {
			h.sleep();
		}
	}
}
