package terrain;

import java.util.Random;
import java.util.Scanner;

public class SwampLogic {

	private boolean foundTreasure = false;
	private boolean alive = true;

	public void init() {
		Player p = new Player();
		Treasure t = new Treasure();
		Trap tr = new Trap();
		Random r = new Random();
		int p1 = r.nextInt(9);
		int p2 = r.nextInt(9);
		int t1 = r.nextInt(15);
		int t2 = r.nextInt(15);
		int tr1 = r.nextInt(15);
		int tr2 = r.nextInt(15);
		p.setPlayerX(p1);
		p.setPlayerY(p2);
		t.setTreasureX(t1);
		t.setTreasureY(t2);
		tr.setTrapX(tr1);
		tr.setTrapY(tr2);

		System.out.println(
				"You have now entered the dark and dingy zone known as the infinite swamp.\nUse your skills wisely and you will be rewarded.\nBut beware, the swamp truly is infinite, and foolish travellers may find themselves lost forever or killed.\nYou must also beware of any carnivorous plants in the swamp, which you can only sense by smell when they are within a metre of you.\nThere are rumours of a great treasure in this swamp that can only be found through a special dial.");
		System.out.println("The dial is reading "
				+ p.dial(p.getPlayerX(), p.getPlayerY(), t.getTreasureX(), t.getTreasureY()) + " metres...");
		System.out.println("Enter \"north\", \"south\", \"east\" or \"west\" to move in that direction.");
		play(p, t, tr);
	}

	private void play(Player p, Treasure t, Trap tr) {
		while (foundTreasure == false && alive == true) {
			String direction = userInput();
			if (!direction.equals("north") && !direction.equals("south") && !direction.equals("east") && !direction.equals("west")) {
				System.out.println("You have entered an invalid input, please only enter \"north\", \"south\", \"east\" or \"west\"");
			} else {
				if (direction.equals("north")) {
					p.incrementPlayerY();
				}
				if (direction.equals("south")) {
					p.decrementPlayerY();
				}
				if (direction.equals("east")) {
					p.incrementPlayerX();
				}
				if (direction.equals("west")) {
					p.decrementPlayerX();
				}
			}
			if ((p.getPlayerX()-1 == tr.getTrapX() || p.getPlayerX()+1 == tr.getTrapX() || (p.getPlayerX() == tr.getTrapX()) && (p.getPlayerY() != tr.getTrapY())) && ((p.getPlayerY()-1 == tr.getTrapY()) || (p.getPlayerY()+1 == tr.getTrapY()) || (p.getPlayerY() == tr.getTrapY() && (p.getPlayerX() != tr.getTrapX())))) {
				System.out.println("You smell a pungent aroma, like rotting flesh.");
			}
			if (p.getPlayerX()==tr.getTrapX() && p.getPlayerY()==tr.getTrapY()) {
				alive=false;
			}
			if ((p.dial(p.getPlayerX(), p.getPlayerY(), t.getTreasureX(), t.getTreasureY()) != 0)) {
				if (alive==true) {
					System.out.println("The dial is reading "
						+ p.dial(p.getPlayerX(), p.getPlayerY(), t.getTreasureX(), t.getTreasureY()) + " metres...");
			} else{
				}
			}
				else {
				foundTreasure = true;
			}
		}
		if (foundTreasure == true) {
			System.out.println("You found the treasure, congratulations!");
		}
		if (alive == false) {
			System.out.println("You were consumed by the carnivorous plant and will be slowly disintegrated over the course of a week. Rest in Peace.");
		}

	}

	private String userInput() {
		Scanner sc = new Scanner(System.in);
		String direction = sc.nextLine();
		direction = direction.toLowerCase();
		return direction;
	}
}
