package pacman.test;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import pacman.PacMan;
import pacman.Square;
import pacman.MazeMap;

class pacmanTestPacman {

@Test
	
	void test() {
		MazeMap mazemap = new MazeMap(2,2,new boolean[] {true,true,false,true});
		Square square = Square.of(mazemap, 0, 1);
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {new PacMan(-1,square);});
		
		PacMan pacman = new PacMan(3,square);
		
		assertEquals(square,pacman.getSquare());
		assertEquals(3,pacman.getNbLives());
		
		Square square2 = Square.of(mazemap, -1, 0);
		pacman.setSquare(square2);
		
		assertEquals(square2,pacman.getSquare());
		assertEquals(3,pacman.getNbLives());
		
		pacman.die();
		
		assertEquals(square2,pacman.getSquare());
		assertEquals(2,pacman.getNbLives());
		
		pacman.die();
		
		assertEquals(square2,pacman.getSquare());
		assertEquals(1,pacman.getNbLives());
		
		pacman.die();
		
		assertEquals(square2,pacman.getSquare());
		assertEquals(0,pacman.getNbLives());
		
		
	}

}
