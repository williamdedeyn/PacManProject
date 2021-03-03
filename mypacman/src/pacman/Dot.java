package pacman;

/**
 * Each instance of this class represents a dot (a piece of food for Pac-Man) in a Pac-Man maze.
 * 
 * @immutable
 */
public class Dot {
	
	/**
	 * @invar | square != null
	 * @invar | 0 <= square.getRowIndex() && 
	 * 		  | square.getRowIndex() < square.getMazeMap().getHeight()
	 * @invar | 0 <= square.getColumnIndex() && 
	 * 		  | square.getColumnIndex() < square.getMazeMap().getWidth()
	 * @invar | square.isPassable() == true
	 */
	/** @RepresentationObject */
	private Square square;

	/**
	 * @basic
	 * 
	 * @post | 0 <= result.getRowIndex() && 
	 * 		 | result.getRowIndex() < result.getMazeMap().getHeight()
	 * @post | 0 <= result.getColumnIndex() && 
	 * 		 | result.getColumnIndex() < result.getMazeMap().getWidth()
	 * @post | result.isPassable() == true
	 * @post | result != null
	 */
	public Square getSquare() {return square;}
	
	/**
	 * @throws IllegalArgumentException | square.isPassable() == false
	 * @throws IllegalArgumentException | square == null
	 * @throws IllegalArgumentException | 0 > square.getRowIndex() || 
	 * 									| square.getRowIndex() >= square.getMazeMap().getHeight()
	 * @throws IllegalArgumentException | 0 > square.getColumnIndex() || 
	 * 									| square.getColumnIndex() >= square.getMazeMap().getWidth()
	 * 
	 * @inspects | square
	 * 
	 * @post | getSquare() == square
	 */
	public Dot(Square square) {
		if(square == null)
			throw new IllegalArgumentException("square can't be null");
		if(0 > square.getRowIndex() || square.getRowIndex() >= square.getMazeMap().getHeight())
			throw new IllegalArgumentException("Not a valid position");
		if(0 > square.getColumnIndex() || square.getColumnIndex() >= square.getMazeMap().getWidth())
			throw new IllegalArgumentException("Not a valid position");
		if(square.isPassable() == false)
			throw new IllegalArgumentException("Square is not free in the maze");
		this.square = square;}

}
