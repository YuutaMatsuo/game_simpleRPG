package app.model;

public class Player {
	private int x;
	private int y;

	public Player(int startX, int startY) {
		this.x = startX;
		this.y = startY;
	}

	public void move(int dx, int dy) {
		this.x += dx;
		this.y += dy;
	}
}
