package pacman.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import pacman.MazeMap;


class pacmanTestMazeMap {

	@Test
	void test() {

	//MazeMap tests 
	
	
	boolean[] myPassable = new boolean[] {false,true};
	
	MazeMap myMazeMap1 = new MazeMap(1,2, myPassable );
	
	assertEquals(1,myMazeMap1.getWidth());
	assertEquals(2,myMazeMap1.getHeight());
	
	
	
	//exception tests for constructor
	
	Assertions.assertThrows(IllegalArgumentException.class, () -> {new MazeMap(0,2, myPassable );});
	
	Assertions.assertThrows(IllegalArgumentException.class, () -> {new MazeMap(1,0, myPassable);});
	
	Assertions.assertThrows(IllegalArgumentException.class, () -> {new MazeMap(1,2, null );});
	
	Assertions.assertThrows(IllegalArgumentException.class, () -> {new MazeMap(3,2, myPassable );});
	
	// isPassable tests
	
	for (int i=0; i < myMazeMap1.getHeight(); i ++) {
		for(int j=0; j < myMazeMap1.getWidth(); j ++) {
			assertEquals(myMazeMap1.isPassable(i, j), myPassable[i*myMazeMap1.getWidth()+j]);
			
		}
	}	
	
	Assertions.assertThrows(IllegalArgumentException.class, () -> {myMazeMap1.isPassable(-1, 0);});
	
	Assertions.assertThrows(IllegalArgumentException.class, () -> {myMazeMap1.isPassable(0, -1);});
	
	Assertions.assertThrows(IllegalArgumentException.class, () -> {myMazeMap1.isPassable(2, 0);});
	
	Assertions.assertThrows(IllegalArgumentException.class, () -> {myMazeMap1.isPassable(0, 1);});


	
}

}
