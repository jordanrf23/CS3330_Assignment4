package game;

import java.util.Random;

public class Grid {
	
	private final int size;
	private final Cell[][] cells;
	private final Random rand = new Random();
	
	public Grid(int size) {
		this.size = 0;
		this.cells = null;
		if (size < 3 || size > 7) {
			throw new IllegalArgumentException("Size must be between 3 and 7");
		}
	}
	
	private void generationGrid() {
		int exitRow = rand.nextInt(size);
		
		for (int i=0; i<size; i++) {
			for(int j=0; j<size; j++) {
				Component up = randComponent();
				Component down = randComponent();
				Component left = (j == 0 && i == exitRow) ? Component.EXIT : randComponent();
				Component right = randComponent();
				
				if(up != Component.APERTURE && down != Component.APERTURE && left != Component.APERTURE && right != Component.APERTURE && left != Component.EXIT) {
					int dir = rand.nextInt(4);
					switch(dir) {
					case 0 -> up = Component.APERTURE;
					case 1 -> down = Component.APERTURE;
					case 2 -> left = Component.APERTURE;
					case 3 -> right = Component.APERTURE;
					}
				}
				cells[i][j]= new Cell(up,down,left,right);
			}
		}
	}

	private Component randComponent() {
		// TODO Auto-generated method stub
		return rand.nextBoolean() ? Component.APERTURE : Component.WALL;
	}
	
	public Cell[][] getCells(){
		return cells;
	}
	
	public void printGrid(int agentRow, int agentCol) {
		for(int i=0; i<size; i++) {
			for(int j=0; j<size; j++) {
				if(i == agentRow && j == agentCol) {
					System.out.print("A ");
				}else if (j == 0 && cells[i][j].getLeft() == Component.EXIT) {
					System.out.print("E ");
				}else {
					System.out.print("S ");
				}
			}
			System.out.println();
		}
	}
	
	public boolean moveAgent(String direction, Agent agent) {
		int row = agent.getRow();
		int col = agent.getCol();
		Cell current = cells[row][col];
		
		switch(direction.toUpperCase()) {
			case "UP": 
				if(row > 0 && current.getUp() != Component.WALL) {
					agent.setPosition(row - 1, col);
					return true;
				}
				break;
			case "LEFT":
				if(col == 0 && current.getLeft() == Component.EXIT) {
					System.out.println("agent left the grid");
					return false;
				}else if(col > 0 && current.getLeft() != Component.WALL) {
					agent.setPosition(row, col - 1);
					return true;
				}
				break;
			case "RIGHT":
				if(col < size -1 && current.getRight() != Component.WALL) {
					agent.setPosition(row, col + 1);
					return true;
				}
				break;
			default:
				System.out.println("Invaild ask. Use UP, DOWN, LEFT, RIGHT");
			}
		return true;
	
	}

}
