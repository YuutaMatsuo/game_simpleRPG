package app.manager;

public class ViewManager {
	public void scroll(int i) {
		while (i > 0) {
			System.out.println();
			try {
				Thread.sleep(30);
			} catch (InterruptedException e) {
			}
			i--;
		}
	}

	public void slowl(int i) {
		while (i > 0 && i % 2 == 0) {
			System.out.println();
			System.out.println();
			try {
				Thread.sleep(800);
			} catch (InterruptedException e) {
			}
			i--;
		}
	}
	
	public void wait(int i) {
		try {
			Thread.sleep(i * 1000);
		} catch (InterruptedException e) {
		}
	}
}
