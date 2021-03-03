package pacman;

import java.util.Arrays;


/**
 * Each instance of this class represents a position in a maze, specified by a row index and a column index.
 * The top row and the leftmost column have index 0.
 * 
 * @immutable
 */
public class Square {
	
	/**
	 * @invar | 0 <= row && row < map.getHeight()
	 * @invar | 0 <= column && column < map.getWidth()
	 */
	private int row;
	private int column;
	/** @RepresentationObject */
	private MazeMap map;
	
	private Square(MazeMap mazemap, int rowIndex, int columnIndex) {
		this.row = rowIndex;
		this.column = columnIndex;
		this.map = mazemap;
		
	}
	
	public MazeMap getMazeMap() {return map;}
	
	public int getRowIndex() {return row;}
	
	public int getColumnIndex() { return column;}
	
	public boolean isPassable() { return map.isPassable(row, column); }
	
	public static Square of(MazeMap mazeMap, int rowIndex, int columnIndex) {
		if(rowIndex < 0 || rowIndex >= mazeMap.getHeight())
			throw new IllegalArgumentException("rowindex is not valid");
		if(columnIndex < 0 || columnIndex >= mazeMap.getWidth())
			throw new IllegalArgumentException("columnindex is not valid");
		if(mazeMap == null)
			throw new IllegalArgumentException("mazemap is null");
		 Square square = new Square(mazeMap,rowIndex,columnIndex);
		 return square;
	}
	
	/**
	 * Returns this square's neighbor in the given direction.
	 * If this square has no neigbor in the given direction, return the square that is furthest away in the opposite direction.
	 */
	// No formal documentation required
	public Square getNeighbor(Direction direction) {
		// Implementation hint: use method java.lang.Math.floorMod.
		throw new RuntimeException("not yet implemented");
	}

	/**
	 * Returns whether this square's neighbor in the given direction is passable.
	 */
	// No formal documentation required
	public boolean canMove(Direction direction) {
		throw new RuntimeException("Not yet implemented");
	}

	/**
	 * Returns the directions that are different from the given excluded direction and such that the neighbor in that direction is passable.
	 * The returned array shall have no null elements and shall have no duplicates.
	 */
	// No formal documentation required
	public Direction[] getPassableDirectionsExcept(Direction excludedDirection) {
		throw new RuntimeException("Not yet implemented");
	}
	
	/**
	 * Returns whether the given square refers to the same {@code MazeMap} object and has the same row and column index as this square.  
	 */
	public boolean equals(Square other) {
		throw new RuntimeException("Not yet implemented");
	}
	
}
