package app.model;

import java.util.Scanner;

import app.asset.character.Human;
import app.logic.Util;
import app.view.View;

public class Inn {
	public Human[] humans;
	
	//	宿屋　HPを全回復する
	public void start() {
		View.scroll(4);
		System.out.println("宿屋へようこそ！\n\n冒険も疲れたでしょう。今日はゆっくり休息を取られてはいかがですか？");
		View.scroll(4);
		
		while(true) {
		System.out.println("宿屋で一休みすることでHPやMPが全回復します\n\n\n一休みしますか？ １泊 500G");
		System.out.println("現在の所持金:" + Human.getGold() + "G");
		View.scroll(4);
		System.out.println("1.ひと休みする");
		System.out.println("2.やっぱりやめる");
		System.out.print(">>");
		
		String nextAction = new Scanner(System.in).nextLine();
		if(nextAction.equals("2")) {
			System.out.println("それは残念・・・・\nまたいつでも来てくださいね！");
			View.scroll(4);
			View.load();
			View.scroll(4);
			break;
		}
			switch(nextAction) {
			case "1":
				System.out.println("\nゆっくり休んでいってくださいね！");
				View.scroll(4);
				Util.allHeal(humans);
				Human.setGold(Human.getGold() - 500);
				View.load();
				View.scroll(2);
				System.out.println("おはようございます！\nよく眠れましたか？\nまたのご利用お待ちしています。");
				View.scroll(4);
				break;
			}
			break;
		}
	}
}
