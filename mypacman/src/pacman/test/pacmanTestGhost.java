package pacman.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;

import pacman.MazeMap;
import pacman.PacMan;
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
		
		 Assertions.assertThrows(IllegalArgumentException.class, () -> { Ghost
			  ghostInvalidSquare = new Ghost(null,Direction.RIGHT);});
		 Assertions.assertThrows(IllegalArgumentException.class, () -> { Ghost
			  ghostInvalidDirection = new Ghost(Square.of(mazemap, 1, 1),null);});
		 Assertions.assertThrows(IllegalArgumentException.class, () -> { Ghost
			  ghostInvalidSquare2 = new Ghost(Square.of(mazemap, 3, 0),Direction.RIGHT);});
		 Assertions.assertThrows(IllegalArgumentException.class, () -> { Ghost
			  ghostInvalidSquare3 = new Ghost(Square.of(mazemap, 0, 2),Direction.RIGHT);});
		 Assertions.assertThrows(IllegalArgumentException.class, () -> { Ghost
			  ghostInvalidSquare4 = new Ghost(Square.of(mazemap, -1, 0),Direction.RIGHT);});
		 Assertions.assertThrows(IllegalArgumentException.class, () -> { Ghost
			  ghostInvalidSquare5 = new Ghost(Square.of(mazemap, 0, -2),Direction.RIGHT);});
		 Assertions.assertThrows(IllegalArgumentException.class, () -> { Ghost
			  ghostInvalidSquare6 = new Ghost(Square.of(mazemap, 1, 0),Direction.RIGHT);});
		 Assertions.assertThrows(IllegalArgumentException.class, () -> { Ghost
		      ghostInvalidDirection2 = new Ghost(Square.of(mazemap, 1, 1),Direction.LEFT);});
		 Assertions.assertThrows(IllegalArgumentException.class, () -> { Ghost
			  ghostInvalidDirection3 = new Ghost(Square.of(mazemap, 1, 1),Direction.DOWN);});
		 Assertions.assertThrows(IllegalArgumentException.class, () -> { Ghost
			  ghostInvalidDirection4 = new Ghost(Square.of(mazemap, 1, 1),Direction.RIGHT);});
		 
		 Square square = Square.of(mazemap, 0, 1);
		 Ghost ghostValid = new Ghost(square,Direction.DOWN);
		 // getters Tests
		 assertEquals(square,ghostValid.getSquare());
		 assertEquals(Direction.DOWN,ghostValid.getDirection());
		 
		 //setSquare Test
		 
		 Assertions.assertThrows(IllegalArgumentException.class, () -> { 
			 ghostValid.setSquare(Square.of(mazemap, 1, 0));
		 });
		 Assertions.assertThrows(IllegalArgumentException.class, () -> { 
			 ghostValid.setSquare(null);
		 });
		 Assertions.assertThrows(IllegalArgumentException.class, () -> { 
			 ghostValid.setSquare(Square.of(mazemap, -2, 0));
		 });
		 Assertions.assertThrows(IllegalArgumentException.class, () -> { 
			 ghostValid.setSquare(Square.of(mazemap, 5, 0));
		 });
		 Assertions.assertThrows(IllegalArgumentException.class, () -> { 
			 ghostValid.setSquare(Square.of(mazemap, 0, -2));
		 });
		 Assertions.assertThrows(IllegalArgumentException.class, () -> { 
			 ghostValid.setSquare(Square.of(mazemap, 1, 2));
		 });
		 
		 square = Square.of(mazemap, 1, 1);
		 ghostValid.setSquare(square);
		 assertEquals(square,ghostValid.getSquare());
		 assertEquals(Direction.DOWN,ghostValid.getDirection());
		 
		 // setDirections Tests
		 
		 Assertions.assertThrows(IllegalArgumentException.class, () -> { 
			 ghostValid.setDirection(null);
		 });
		 Assertions.assertThrows(IllegalArgumentException.class, () -> { 
			 ghostValid.setDirection(Direction.RIGHT);
		 });
		 Assertions.assertThrows(IllegalArgumentException.class, () -> { 
			 ghostValid.setDirection(Direction.DOWN);
		 });
		 Assertions.assertThrows(IllegalArgumentException.class, () -> { 
			 ghostValid.setDirection(Direction.LEFT);
		 });
		 ghostValid.setDirection(Direction.UP);
		 assertEquals(Direction.UP,ghostValid.getDirection());
		 assertEquals(square,ghostValid.getSquare());
		 
		 
		 
	
	
	
	}

}
