package pacman;

import java.util.ArrayList;
import java.util.List;


/**
 * Each instance of this class represents a position in a maze, specified by a row index and a column index.
 * The top row and the leftmost column have index 0.
 * 
 * @immutable
 */

public class Square {

	/**
	 * @invar | 0 <= rowIndex && rowIndex < mazeMap.getHeight()
	 * @invar | 0 <= columnIndex && columnIndex < mazeMap.getWidth()
	 */
	private int rowIndex;
	private int columnIndex;
	
	/** @representationObject */
	private MazeMap mazeMap;
	
	private Square(MazeMap mazeMap, int rowIndex, int columnIndex) {
	
		this.mazeMap = mazeMap;
		this.rowIndex = rowIndex;
		this.columnIndex = columnIndex;
	}
	
	/**
	 * @basic
	 */
	public MazeMap getMazeMap() { 
		return mazeMap;
	}
	
	/**
	 * @basic
	 * 
	 * @post | 0 <= result && result < getMazeMap().getHeight()
	 */
	public int getRowIndex() { 
		return rowIndex;
	}
	
	/**
	 * @basic
	 * 
	 * @post | 0 <= result && result < getMazeMap().getWidth()
	 */
	public int getColumnIndex() { 
		return columnIndex;
	}
	
	/**
	 * @basic
	 * 
	 * @post | result == getMazeMap().isPassable(getRowIndex(),getColumnIndex())
	 */
	public boolean isPassable() { 
		return mazeMap.isPassable(rowIndex,columnIndex);
	}
	
	/**
	 * @throws IllegalArgumentException | rowIndex < 0
	 * @throws IllegalArgumentException | columnIndex <0
	 * @throws IllegalArgumentException | rowIndex >= mazeMap.getHeight()
	 * @throws IllegalArgumentException | columnIndex>= mazeMap.getWidth()
	 * 
	 * @inspects | mazeMap
	 * @creates | result
	 * 
	 * @post | result.getRowIndex() == rowIndex
	 * @post | result.getColumnIndex() == columnIndex
	 * @post | result.getMazeMap() == mazeMap
	 */
	public static Square of(MazeMap mazeMap, int rowIndex, int columnIndex) {
		if(rowIndex < 0)
			throw new IllegalArgumentException("rowIndex is less than 0");
		if(columnIndex <0)
			throw new IllegalArgumentException("columnIndex is less than 0");
		if(rowIndex >= mazeMap.getHeight())
			throw new IllegalArgumentException("rowIndex is greater than height mazemap");
		if(columnIndex >= mazeMap.getWidth())
			throw new IllegalArgumentException("columnIndex is greater than width mazemap");
		Square square = new Square(mazeMap, rowIndex, columnIndex);
		return square;
	}

	/**
	 * Returns this square's neighbor in the given direction.
	 * If this square has no neighbor in the given direction, return the square that is furthest away in the opposite direction.
	 */
	// No formal documentation required
	public Square getNeighbor(Direction direction) {
		
		switch (direction) {
		case RIGHT: 
			return of(mazeMap,rowIndex, java.lang.Math.floorMod(columnIndex + 1, mazeMap.getWidth()));
		case LEFT: 
			return of(mazeMap,rowIndex, java.lang.Math.floorMod(columnIndex - 1, mazeMap.getWidth()));
		case UP: 
			return of(mazeMap,java.lang.Math.floorMod(rowIndex - 1, mazeMap.getHeight()), columnIndex);
		case DOWN: 
			return of(mazeMap,java.lang.Math.floorMod(rowIndex + 1, mazeMap.getHeight()), columnIndex);
		default:
			return this;
		}
	}

	/**
	 * Returns whether this square's neighbor in the given direction is passable.
	 */
	// No formal documentation required
	public boolean canMove(Direction direction) {
		return getNeighbor(direction).isPassable();
	}

	/**
	 * Returns the directions that are different from the given excluded direction and such that the neighbor in that direction is passable.
	 * The returned array shall have no null elements and shall have no duplicates.
	 */
	// No formal documentation required
	
	public Direction[] getPassableDirectionsExcept(Direction excludedDirection) {
	
		List<Direction> passables = new  ArrayList<Direction>();
		
		for( Direction direction : Direction.values()) {
			if (direction != excludedDirection ) {
				if (canMove(direction)){
					passables.add(direction);
				}
			}
		}
		
		Direction[] passabledirections = new Direction[passables.size()]; 
		passabledirections = passables.toArray(passabledirections);
		
	return passabledirections;
	}
	
	/**
	 * Returns whether the given square refers to the same {@code MazeMap} object and has the same row and column index as this square.  
	 */
	public boolean equals(Square other) {
		return this.mazeMap == other.getMazeMap() && this.columnIndex == other.getColumnIndex() && this.rowIndex == other.getRowIndex();
	}
	
}
