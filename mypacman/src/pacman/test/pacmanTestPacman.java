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
		//pacmanTest
		
		//MazeMap construction
		MazeMap mazemap = new MazeMap(2,2,new boolean [] {true,true,false,true});
		//constructor tests
		
		  Assertions.assertThrows(IllegalArgumentException.class, () -> { PacMan
		  pacmanInvalidRow = new PacMan(3,Square.of(mazemap, 2, 0));});
		  Assertions.assertThrows(IllegalArgumentException.class, () -> { PacMan
		  pacmanInvalidColumn = new PacMan(3,Square.of(mazemap, 1, 3));});
		  Assertions.assertThrows(IllegalArgumentException.class, () -> { PacMan
		  pacmanInvalidLives = new PacMan(-1,Square.of(mazemap, 1, 1));});
		  Assertions.assertThrows(IllegalArgumentException.class, () -> { PacMan
		  pacmanInvalidLives2 =new PacMan(-2,Square.of(mazemap, 0, 0));});
		  Assertions.assertThrows(IllegalArgumentException.class, () -> { PacMan
		  pacmanInvalidRow2 = new PacMan(3,Square.of(mazemap, -1, 0));});
		  Assertions.assertThrows(IllegalArgumentException.class, () -> { PacMan
		  pacmanInvalidColumn2 = new PacMan(3,Square.of(mazemap, 0, -2));});
		  Assertions.assertThrows(IllegalArgumentException.class, () -> { PacMan
		  pacmanInvalidPosition = new PacMan(1,Square.of(mazemap, 1, 0));});
		  
		  
		  Square square = Square.of(mazemap, 0, 0);
		  PacMan pacmanValid = new PacMan(1,square);
		  
		  //Test getNbLives()
		  assertEquals(1,pacmanValid.getNbLives());
		  //Test getSquare()
		  assertTrue(square == pacmanValid.getSquare());
		  
		  //Test setSquare
		  Assertions.assertThrows(IllegalArgumentException.class, () -> { 
			  pacmanValid.setSquare(Square.of(mazemap, 1, 0));
		  });
		  Assertions.assertThrows(IllegalArgumentException.class, () -> { 
			  pacmanValid.setSquare(Square.of(mazemap, -5, 0));
		  });
		  Assertions.assertThrows(IllegalArgumentException.class, () -> { 
			  pacmanValid.setSquare(Square.of(mazemap, 0, -1));
		  });
		  square = Square.of(mazemap, 0, 1);		  
		  pacmanValid.setSquare(square);
		  assertTrue(square == pacmanValid.getSquare());
		  assertEquals(1,pacmanValid.getNbLives());
		  
		  // Test die
		  square = Square.of(mazemap, 1, 1);
		  PacMan pacmandie = new PacMan(2,square);
		  assertEquals(2,pacmandie.getNbLives());
		  assertTrue(square == pacmandie.getSquare());
		  pacmandie.die();
		  assertEquals(1,pacmandie.getNbLives());
		  assertTrue(square == pacmandie.getSquare());
		  pacmandie.die();
		  assertEquals(0,pacmandie.getNbLives());
		  assertTrue(square == pacmandie.getSquare());
		  
		  
		  
		  
		
	}

}
