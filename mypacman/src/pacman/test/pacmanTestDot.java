package pacman.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;

import pacman.Direction;
import pacman.Dot;
import pacman.Ghost;
import pacman.MazeMap;
import pacman.Square;

import org.junit.jupiter.api.Test;

class pacmanTestDot {

	@Test
	void test() {
		// Dot Tests
		
		MazeMap mazemap = new MazeMap(2,2,new boolean[] {true,true,false,true});
		
		// Consructor Tests
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> { Dot
			  dotInvalidSquare = new Dot(null);});
		Assertions.assertThrows(IllegalArgumentException.class, () -> { Dot
			  dotInvalidSquare = new Dot(Square.of(mazemap, -1, 0));});
		Assertions.assertThrows(IllegalArgumentException.class, () -> { Dot
			  dotInvalidSquare = new Dot(Square.of(mazemap, 3, 0));});
		Assertions.assertThrows(IllegalArgumentException.class, () -> { Dot
			  dotInvalidSquare = new Dot(Square.of(mazemap, 0, -2));});
		Assertions.assertThrows(IllegalArgumentException.class, () -> { Dot
			  dotInvalidSquare = new Dot(Square.of(mazemap, 0, 5));});
		Assertions.assertThrows(IllegalArgumentException.class, () -> { Dot
			  dotInvalidSquare = new Dot(Square.of(mazemap, 1, 0));});
		
		Square square = Square.of(mazemap, 0, 1);
		Dot dotValid = new Dot(square);
		// getSquare Test
		
		assertEquals(square,dotValid.getSquare());
		
	
	
	
	
	}

}
