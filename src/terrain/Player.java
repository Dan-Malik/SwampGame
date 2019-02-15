package terrain;

public class Player {
	private int PlayerX = 0;
	private int PlayerY = 0;

	public int getPlayerX() {
		return PlayerX;
	}

	public int getPlayerY() {
		return PlayerY;
	}

	public void setPlayerX(int playerX) {
		this.PlayerX = playerX;
	}

	public void setPlayerY(int playerY) {
		this.PlayerY = playerY;
	}

	public void incrementPlayerX() {
		this.PlayerX++;
	}

	public void incrementPlayerY() {
		this.PlayerY++;
	}

	public void decrementPlayerX() {
		this.PlayerX--;
	}

	public void decrementPlayerY() {
		this.PlayerY--;
	}

	public double dial(int playerX, int playerY, int treasureX, int treasureY) {
		double pX = (double) playerX;
		double pY = (double) playerY;
		double tX = (double) treasureX;
		double tY = (double) treasureY;
		double distance = Math.sqrt((pX - tX) * (pX - tX) + (pY - tY) * (pY - tY));
		return distance;
	}

}
