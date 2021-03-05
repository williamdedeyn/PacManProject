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

		 Assertions.assertThrows(IllegalArgumentException.class, () -> { new Ghost(null,Direction.RIGHT);});
		 Assertions.assertThrows(IllegalArgumentException.class, () -> { new Ghost(Square.of(mazemap, 1, 1),null);});
		 
		 Assertions.assertThrows(IllegalArgumentException.class, () -> { new Ghost(Square.of(mazemap, 3, 0),Direction.RIGHT);});
		 Assertions.assertThrows(IllegalArgumentException.class, () -> { new Ghost(Square.of(mazemap, 0, 2),Direction.RIGHT);});
		 Assertions.assertThrows(IllegalArgumentException.class, () -> { new Ghost(Square.of(mazemap, -1, 0),Direction.RIGHT);});
		 Assertions.assertThrows(IllegalArgumentException.class, () -> { new Ghost(Square.of(mazemap, 0, -2),Direction.RIGHT);});
		 
		 Assertions.assertThrows(IllegalArgumentException.class, () -> { new Ghost(Square.of(mazemap, 1, 0),Direction.RIGHT);});
		 
		 Assertions.assertThrows(IllegalArgumentException.class, () -> { new Ghost(Square.of(mazemap, 1, 1),Direction.LEFT);});
		 Assertions.assertThrows(IllegalArgumentException.class, () -> { new Ghost(Square.of(mazemap, 1, 1),Direction.RIGHT);});
		 
		 Assertions.assertThrows(IllegalArgumentException.class, () -> { new Ghost(Square.of(mazemap, 0, 0),Direction.UP);});
		 Assertions.assertThrows(IllegalArgumentException.class, () -> { new Ghost(Square.of(mazemap, 0, 0),Direction.DOWN);});
		
		 Square square = Square.of(mazemap, 0, 1);
		 Direction direction = Direction.DOWN;
		 Ghost ghostValid = new Ghost(square,direction);
		 
		 // getters Tests
		 Square result = ghostValid.getSquare();
		 assertEquals(square,ghostValid.getSquare());
		 assertTrue(result != null);
		 assertTrue(0 <= result.getRowIndex());
		 assertTrue(result.getRowIndex() < result.getMazeMap().getHeight());
		 assertTrue(0 <= result.getColumnIndex());
		 assertTrue(result.getColumnIndex() < result.getMazeMap().getWidth());
		 assertTrue(result.isPassable() == true);
		 assertEquals(direction,ghostValid.getDirection());
		 assertTrue(ghostValid.getDirection() != null);
		 
		 //setSquare Test
		 
		 Assertions.assertThrows(IllegalArgumentException.class, () -> {ghostValid.setSquare(Square.of(mazemap, 1, 0));});
		 Assertions.assertThrows(IllegalArgumentException.class, () -> {ghostValid.setSquare(null);});
		 Assertions.assertThrows(IllegalArgumentException.class, () -> {ghostValid.setSquare(Square.of(mazemap, -2, 0));});
		 Assertions.assertThrows(IllegalArgumentException.class, () -> {ghostValid.setSquare(Square.of(mazemap, 5, 0));});
		 Assertions.assertThrows(IllegalArgumentException.class, () -> {ghostValid.setSquare(Square.of(mazemap, 0, -2));});
		 Assertions.assertThrows(IllegalArgumentException.class, () -> {ghostValid.setSquare(Square.of(mazemap, 1, 2));});
		 
		 square = Square.of(mazemap, 1, 1);
		 ghostValid.setSquare(square);
		 assertEquals(square,ghostValid.getSquare());
		 assertEquals(direction,ghostValid.getDirection());
		 
		 // setDirections Tests
		 
		 Assertions.assertThrows(IllegalArgumentException.class, () -> {ghostValid.setDirection(null);});
		 Assertions.assertThrows(IllegalArgumentException.class, () -> {ghostValid.setDirection(Direction.RIGHT);});

		 Assertions.assertThrows(IllegalArgumentException.class, () -> {ghostValid.setDirection(Direction.LEFT);});
		 
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
		 
		 square = Square.of(mazemap, 0, 0);
		 ghostValid.setDirection(Direction.LEFT);
		 ghostValid.setSquare(square);
		 
		 Assertions.assertThrows(IllegalArgumentException.class, () -> {ghostValid.setDirection(null);});
		 Assertions.assertThrows(IllegalArgumentException.class, () -> {ghostValid.setDirection(Direction.UP);});

		 Assertions.assertThrows(IllegalArgumentException.class, () -> {ghostValid.setDirection(Direction.DOWN);});
		 
		 ghostValid.setDirection(Direction.LEFT);
		 assertEquals(Direction.LEFT,ghostValid.getDirection());
		 ghostValid.setDirection(Direction.RIGHT);
		 assertEquals(Direction.RIGHT,ghostValid.getDirection());
		 
	}

}