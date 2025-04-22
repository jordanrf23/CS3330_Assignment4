package mazeGrid;

public class Cell {
	
	private Component up;
	private Component down;
	private Component left;
	private Component right;
	
	public Cell(Component up, Component down, Component left, Component right) {
		super();
		this.up = up;
		this.down = down;
		this.left = left;
		this.right = right;
	}

	public Component getUp() {
		return up;
	}

	public void setUp(Component up) {
		this.up = up;
	}

	public Component getDown() {
		return down;
	}

	public void setDown(Component down) {
		this.down = down;
	}

	public Component getLeft() {
		return left;
	}

	public void setLeft(Component left) {
		this.left = left;
	}

	public Component getRight() {
		return right;
	}

	public void setRight(Component right) {
		this.right = right;
	}
	
	
	

}
