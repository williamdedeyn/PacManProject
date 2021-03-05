package pacman;

import java.util.Random;

/**
 * Each instance of this class represents a ghost in a Pac-Man maze.
 */
public class Ghost {
	
	/**
	 * @invar | square.isPassable() == true
	 * @invar | square.canMove(direction) == true
	 * @invar | square != null
	 * @invar | 0 <= square.getRowIndex() && 
	 * 		  | square.getRowIndex() < square.getMazeMap().getHeight()
	 * @invar | 0 <= square.getColumnIndex() && 
	 * 		  | square.getColumnIndex() < square.getMazeMap().getWidth()
	 */
	/** @RepresentationObjects */
	private Direction direction;
	private Square square;
	
	/**
	 * Returns the current square of the ghost in the maze
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
	 * Returns the direction in which this ghost will preferably move next.
	 * @basic
	 * 
	 */
	public Direction getDirection() { return direction; }
	
	/**
	 * @inspects | square
	 * @inspects | direction
	 * 
	 * @post | getSquare() == square
	 * @post | getDirection() == direction
	 *
	 */
	public Ghost(Square square, Direction direction) {
		this.square = square;
		this.direction = direction;
	}
	
	/**
	 * @mutates | this
	 * @inspects | square 
	 * 
	 * @post | getSquare() == square
	 * @post | getDirection() == old(getDirection())
	 */
	public void setSquare(Square square) {
		this.square = square;
	}

	/**
	 * 
	 * @mutates | this
	 * @inspects | direction 
	 * 
	 * @post | getDirection() == direction
	 * @post | getSquare() == old(getSquare())
	 */
	public void setDirection(Direction direction) {
		this.direction = direction;
	}
	
	private static int MOVE_FORWARD_PREFERENCE = 10;
	
	// No formal document required
	public Direction chooseNextMoveDirection(Random random) {
		int moveForwardPreference = getSquare().canMove(getDirection()) ? MOVE_FORWARD_PREFERENCE : 0;
		Direction[] passableDirections = getSquare().getPassableDirectionsExcept(getDirection().getOpposite());
		if (passableDirections.length == 0)
			return getDirection().getOpposite();
		int result = random.nextInt(moveForwardPreference + passableDirections.length);
		if (result < moveForwardPreference)
			return getDirection();
		return passableDirections[result - moveForwardPreference];
	}
	
	// No formal document required
	public void move(Random random) {
		setDirection(chooseNextMoveDirection(random));
		setSquare(getSquare().getNeighbor(getDirection()));
	}
}
