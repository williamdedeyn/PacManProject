package pacman;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Each instance of this class represents a maze layout, specifying the width and height of the maze
 * and, for each position in the maze, whether it is passable or not.
 * 
 * @immutable
 */
public class MazeMap {
	
	/**
	* @invar | 1 <= width
	* @invar | 1 <= height
	* @invar | elements != null
	* @invar | elements.length == width*height
	*/
	private int width;
	private int height;
	/** @representationObject */
	private boolean[] elements;
	
	/**
	 * Returns the width (i.e. the number of columns) of this maze map.
	 * @basic
	 * 
	 * @post | result >= 1
	 */
	public int getWidth() { return width; }
	
	/**
	 * Returns the height (i.e. the number of rows) of this maze map.
	 * @basic
	 * 
	 * @post | result >= 1
	 */
	public int getHeight() { return height; }
	
	/**
	 * Returns whether the square in this maze at row index {@code row} and column index {@code column} is passable.
	 * The square in the top-left corner of the maze has row index 0 and column index 0.
	 * 
	 * @throws IllegalArgumentException | rowIndex >= getWidth()
	 * @throws IllegalArgumentException | columnIndex >= getHeight()
	 * @throws IllegalArgumentException | rowIndex < 0
	 * @throws IllegalArgumentException | columnIndex < 0
	 * 
	 */
	public boolean isPassable(int rowIndex, int columnIndex) {
		if( rowIndex >= getWidth())
			throw new IllegalArgumentException("row outside the maze");
		if( rowIndex < 0)
			throw new IllegalArgumentException("rowindex can't be smaller than 0");
		if( columnIndex >= getHeight())
			throw new IllegalArgumentException("column outside the maze");
		if(columnIndex < 0)
			throw new IllegalArgumentException("columnnindex can't be smaller than 0");
		return elements[rowIndex*width+columnIndex];
	}
	
	/**
	 * Initializes this object so that it represents a maze layout with the given width, height, and
	 * passable positions. The passable positions are given in row-major order (i.e. the first {@code width} elements
	 * of {@code passable} specify the passability of the maze positions in the first row of the maze).
	 * 
	 * @throws IllegalArgumentException | width < 1
	 * @throws IllegalArgumentException | height < 1
	 * @throws IllegalArgumentException | passable == null
	 * @throws IllegalArgumentException | passable.length != width*height
	 * 
	 * @inspects | passable
	 * 
	 * @post | getWidth() == width
	 * @post | getHeight() == height
	 * @post | IntStream.range(0, getHeight()).allMatch(rowIndex -> IntStream.range(0, getWidth()).allMatch(columnIndex -> 
	 *       | isPassable(rowIndex,columnIndex) == passable[ rowIndex*width + columnIndex ]))
	 * 
	 */
	public MazeMap(int width, int height, boolean[] passable) {
		if(width < 1)
			throw new IllegalArgumentException("width is less than 1");
		if(height < 1)
			throw new IllegalArgumentException("height is less than 1");
		if(passable == null)
			throw new IllegalArgumentException("passable is null");
		if(passable.length != width*height)
			throw new IllegalArgumentException("passable has wrong length");
		this.width = width;
		this.height = height;
		this.elements = passable.clone();
	}
}
