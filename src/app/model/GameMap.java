package app.model;

public class GameMap {
	private static final int MAX_X = 7;
    private static final int MAX_Y = 7;
    private static final int MAP_SIZE = 19;
    
    private static final int[][] map = new int[MAP_SIZE][MAP_SIZE];

	public void setTile(int x, int y, int value) {
		map[x][y] = value;
	}

	public int getTile(int x, int y) {
		return map[x][y];
	}
}
