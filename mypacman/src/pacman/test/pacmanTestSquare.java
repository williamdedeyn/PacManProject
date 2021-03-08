package pacman.test;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import pacman.Direction;
import pacman.MazeMap;
import pacman.Square;

class pacmanTestSquare {

	@Test
	void test() {
	
	//Square tests 
	//System.out.print("Running SquareTest\n");
	
	/*Test MazeMap looks like : 
	 *      0 1 2 3 
	 *  0   x   x 
	 *  1	    x
	 *  2   x   
	 *  3   x   x
	 *  4         x
	 *  5   x x   x
	 *  6         x
	*/

	boolean[] myPassable = new boolean[] {false,true,false,true, true,true,false,true, false,true,true,true, false,true,false,true, true,true,true,false, false,false,true,false, true,true,true,false};
	MazeMap myMazeMap = new MazeMap(4,7, myPassable );
	MazeMap mySecondMazeMap = new MazeMap(4,7, myPassable );
	Square myCenterSquare = Square.of(myMazeMap, 4, 2);
	Square mySecondCenterSquare = Square.of(mySecondMazeMap, 4, 2);
	Square myCornerSquare = Square.of(myMazeMap, 0, 3);
	Square neighborSquare;
	Direction[] myPassableDirections;
	
	
	//Constructor tests
	assertEquals(myCenterSquare.isPassable(),myMazeMap.isPassable(4,2));
	assertEquals(myCenterSquare.getRowIndex(),4);
	assertEquals(myCenterSquare.getColumnIndex(),2);
	assertEquals(myCenterSquare.getMazeMap(),myMazeMap);
	
	//exception tests for constructor
	Assertions.assertThrows(IllegalArgumentException.class, () -> { Square.of(myMazeMap, -1, 0);});
	Assertions.assertThrows(IllegalArgumentException.class, () -> { Square.of(myMazeMap, 0, -1);});
	Assertions.assertThrows(IllegalArgumentException.class, () -> { Square.of(myMazeMap, 7, 0);});
	Assertions.assertThrows(IllegalArgumentException.class, () -> {Square.of(myMazeMap, 0, 4);});

	
	// isPassable tests
		

	// getneighbor tests
	// center Square
	neighborSquare = myCenterSquare.getNeighbor(Direction.LEFT);
	//System.out.print("neighborSquare " + neighborSquare.getRowIndex() + "," + neighborSquare.getColumnIndex() + "\n");
	assertEquals(neighborSquare.getColumnIndex(),1);
	assertEquals(neighborSquare.getRowIndex(),myCenterSquare.getRowIndex());
	
	neighborSquare = myCenterSquare.getNeighbor(Direction.RIGHT);
	//System.out.print("neighborSquare " + neighborSquare.getRowIndex() + "," + neighborSquare.getColumnIndex() + "\n");
	assertEquals(neighborSquare.getColumnIndex(),3);
	assertEquals(neighborSquare.getRowIndex(),myCenterSquare.getRowIndex());
	
	neighborSquare = myCenterSquare.getNeighbor(Direction.UP);
	//System.out.print("neighborSquare " + neighborSquare.getRowIndex() + "," + neighborSquare.getColumnIndex() + "\n");
	assertEquals(neighborSquare.getColumnIndex(),myCenterSquare.getColumnIndex());
	assertEquals(neighborSquare.getRowIndex(),3);
	
	neighborSquare = myCenterSquare.getNeighbor(Direction.DOWN);
	//System.out.print("neighborSquare " + neighborSquare.getRowIndex() + "," + neighborSquare.getColumnIndex() + "\n");
	assertEquals(neighborSquare.getColumnIndex(),myCenterSquare.getColumnIndex());
	assertEquals(neighborSquare.getRowIndex(),5);
	
	// canMove test
	// center Square
	
	assertEquals(myCenterSquare.canMove(Direction.UP),false);
	assertEquals(myCenterSquare.canMove(Direction.RIGHT),false);
	assertEquals(myCenterSquare.canMove(Direction.DOWN),true);
	assertEquals(myCenterSquare.canMove(Direction.LEFT),true);
	
	// getPassableDirectionsExcept test
	// center Square

	myPassableDirections = myCenterSquare.getPassableDirectionsExcept(Direction.UP);
	assertEquals(myPassableDirections[0],Direction.DOWN); // order will always be RIGHT, DOWN, LEFT, UP as the values of the enum Direction corresponds to the order in which they are declared.
	assertEquals(myPassableDirections[1],Direction.LEFT);
	assertEquals(myPassableDirections.length,2);
	//System.out.print("myPassableDirections " + myPassableDirections[0] + "\n" );
	//System.out.print("myPassableDirections " + myPassableDirections[1] + "\n" );
	
	// getneighbor test
	// corner Square
	neighborSquare = myCornerSquare.getNeighbor(Direction.LEFT);
	//System.out.print("neighborSquare " + neighborSquare.getRowIndex() + "," + neighborSquare.getColumnIndex() + "\n");
	assertEquals(neighborSquare.getColumnIndex(),2);
	assertEquals(neighborSquare.getRowIndex(),myCornerSquare.getRowIndex());
	
	neighborSquare = myCornerSquare.getNeighbor(Direction.RIGHT);
	//System.out.print("neighborSquare " + neighborSquare.getRowIndex() + "," + neighborSquare.getColumnIndex() + "\n");
	assertEquals(neighborSquare.getColumnIndex(),0);
	assertEquals(neighborSquare.getRowIndex(),myCornerSquare.getRowIndex());
	
	neighborSquare = myCornerSquare.getNeighbor(Direction.UP);
	//System.out.print("neighborSquare " + neighborSquare.getRowIndex() + "," + neighborSquare.getColumnIndex() + "\n");
	assertEquals(neighborSquare.getColumnIndex(),myCornerSquare.getColumnIndex());
	assertEquals(neighborSquare.getRowIndex(),6);
	
	neighborSquare = myCornerSquare.getNeighbor(Direction.DOWN);
	//System.out.print("neighborSquare " + neighborSquare.getRowIndex() + "," + neighborSquare.getColumnIndex() + "\n");
	assertEquals(neighborSquare.getColumnIndex(),myCornerSquare.getColumnIndex());
	assertEquals(neighborSquare.getRowIndex(),1);
	

	
	// canMove test
	// corner Square
	
	assertEquals(myCornerSquare.canMove(Direction.UP),false);
	assertEquals(myCornerSquare.canMove(Direction.RIGHT),false);
	assertEquals(myCornerSquare.canMove(Direction.DOWN),true);
	assertEquals(myCornerSquare.canMove(Direction.LEFT),false);
	
	// getPassableDirectionsExcept test@
	// corner Square

	myPassableDirections = myCornerSquare.getPassableDirectionsExcept(Direction.UP);
	assertEquals(myPassableDirections[0],Direction.DOWN); // order will always be RIGHT, DOWN, LEFT, UP as the values of the enum Direction corresponds to the order in which they are declared.
	assertEquals(myPassableDirections.length,1);
	//System.out.print("myPassableDirections " + myPassableDirections[0] + "\n" );
	
	// equals test
	// 
	// different @code mazeMap - identical rowIndex/columnIndex
	assertEquals(myCenterSquare.equals(mySecondCenterSquare),false);
	// different columnIndex - identical rowIndex/@code mazeMap
	assertEquals(myCenterSquare.equals(myCenterSquare.getNeighbor(Direction.LEFT)),false);
	// different rowIndex - identical columnIndex/@code mazeMap
	assertEquals(myCenterSquare.equals(myCenterSquare.getNeighbor(Direction.DOWN)),false);
	// everything identical
	assertEquals(myCenterSquare.equals(myCenterSquare),true);
}


}
