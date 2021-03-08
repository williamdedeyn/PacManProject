package pacman.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;

import pacman.MazeMap;
import pacman.Square;
import pacman.Direction;
import pacman.Ghost;

import org.junit.jupiter.api.Test;

class pacmanTestGhost {

	@Test
	void test() {
	
		//Ghost Tests
		MazeMap mazemap = new MazeMap(2,2,new boolean[] {true, true, false, true});
		
		// Constructor Tests


		 Square square = Square.of(mazemap, 0, 1);
		 Direction direction = Direction.DOWN;
		 Ghost ghostValid = new Ghost(square,direction);
		 
		 // getters Tests
		 assertEquals(Direction.DOWN,ghostValid.getDirection());
		 assertEquals(square,ghostValid.getSquare());
		 
		 //setSquare Test
		 
		 
		 Square square2 = Square.of(mazemap, 1, 1);
		 ghostValid.setSquare(square2);
		 assertEquals(square2,ghostValid.getSquare());
		 assertEquals(direction,ghostValid.getDirection());
		 
		 // setDirections Tests
		 
		 square = Square.of(mazemap, 0, 1);
		 ghostValid.setSquare(square);
		 assertEquals(square,ghostValid.getSquare());
		 assertEquals(Direction.DOWN,ghostValid.getDirection());
		 ghostValid.setDirection(Direction.LEFT);
		 assertEquals(Direction.LEFT,ghostValid.getDirection());
		 ghostValid.setDirection(Direction.RIGHT);
		 assertEquals(Direction.RIGHT,ghostValid.getDirection());
		 ghostValid.setDirection(Direction.UP);
		 assertEquals(Direction.UP,ghostValid.getDirection());
		 	 
	}

}