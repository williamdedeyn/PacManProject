package pacman.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import pacman.Direction;
import pacman.MazeMap;
import pacman.Square;

class pacmanTestMazeMap {

	@Test
	void test() {
		//MazeMap tests
		
			boolean[] myPassable = new boolean[] {false,true};
			
			MazeMap myMazeMap1 = new MazeMap(1,2, myPassable );
			
			assertEquals(1,myMazeMap1.getWidth());
			assertEquals(2,myMazeMap1.getHeight());
			
			for (int i=0; i < myMazeMap1.getHeight(); i ++) {
				for(int j=0; j < myMazeMap1.getWidth(); j ++) {
					assertEquals(myMazeMap1.isPassable(i, j), myPassable[i*myMazeMap1.getWidth()+j]);
					
				}
			}	
			
			//exception tests for constructor
			
			Assertions.assertThrows(IllegalArgumentException.class, () -> {
				MazeMap myMazeMap2 = new MazeMap(0,2, myPassable );
			});
			
			Assertions.assertThrows(IllegalArgumentException.class, () -> {
				MazeMap myMazeMap3 = new MazeMap(1,0, myPassable);
			});
			
			Assertions.assertThrows(IllegalArgumentException.class, () -> {
				MazeMap myMazeMap4 = new MazeMap(1,2, null );
			});
			
			Assertions.assertThrows(IllegalArgumentException.class, () -> {
				MazeMap myMazeMap5 = new MazeMap(3,2, myPassable );
			});
			
			//Square tests 
			
			boolean[] myPassable1 = new boolean[] {false,true};
			MazeMap myMazeMap = new MazeMap(1,2, myPassable1 );
			Square mySquare = Square.of(myMazeMap, 0, 0);
			Square neighborSquare;
					
			//Constructor tests
			assertEquals(mySquare.isPassable(),myMazeMap.isPassable(0,0));
					
			//exception tests for constructor
					
					
			//getneighbor test 
			neighborSquare = mySquare.getNeighbor(Direction.LEFT);
			assertEquals(neighborSquare.getColumnIndex(),mySquare.getColumnIndex());
	}

}
