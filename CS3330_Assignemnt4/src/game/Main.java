package game;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		
		int size = 3 + (int)(Math.random() * 5);
		Grid grid = new Grid(size);
		Agent agent = new Agent(size -1, size -1);
		
		boolean playing = true;
		System.out.println("Now playing Tears, Despair, & Debugging");
		System.out.println();
		
		while(playing) {
			grid.printGrid(agent.getRow(), agent.getCol());
			System.out.println("Move using UP, DOWN, LEFT, RIGHT");
			String move = scanner.nextLine();
			playing = grid.moveAgent(move, agent);
		}
		
		System.out.println("Game over");

	}

}
