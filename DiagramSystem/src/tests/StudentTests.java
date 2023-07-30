package tests;

import system.*;

import static org.junit.Assert.*;

import org.junit.Test;

import app.DrawingApp;
import system.TwoDimArrayUtil;

public class StudentTests{

	@Test
    public void testLeftRight() {
        char[][] left = {
            {'a', 'b', 'c'},
            {'d', 'e','f'},
            {'g', 'h', 'i'},
            {'j', 'k', 'l'},
        };
        char[][] right = {
            {'m','n'},
            {'o','p', 'q', 'r'},
        };
        char[][] expectedPopulate = {
            {'a', 'b', 'c', 'm', 'n'},
            {'d', 'e', 'f','o','p','q','r'},
            {'g','h','i'},
        	{'j','k','l'}};
        
        char[][] actualPopulate = TwoDimArrayUtil.appendLeftRight(left,right);
        assertArrayEquals(expectedPopulate, actualPopulate);
    }
	
	@Test
	public void testTopBottom() {
		
		char[][] top = {
				{'a', 'b', 'c'},
				{'d', 'e','f'},
				{'g', 'h', 'i'},
				{'j', 'k', 'l'},
		};
		char[][] bottom = {
				{'m','n'},
				{'o','p', 'q', 'r'},
		};
		char[][] expectedPopulate = {
				{'a', 'b', 'c'},
				{'d', 'e','f'},
				{'g', 'h', 'i'},
				{'j', 'k', 'l'},
				{'m','n',},
				{'o','p','q','r'}};
		
		char[][] actualPopulate = TwoDimArrayUtil.appendTopBottom(top,bottom);
		assertArrayEquals(expectedPopulate, actualPopulate);
	}
	
	@Test
	public void testShiftColumnsLeft() {
	    char[][] preShift = {
	    		{'a', 'b', 'c'},
	    		{'d', 'e', 'f'},
	    		{'g', 'h', 'i'}};
	    char[][] shifted = {
	    		{'b', 'c', 'a'},
	    		{'e', 'f', 'd'},
	    		{'h', 'i', 'g'}};
	    TwoDimArrayUtil.rotateLeftOneColumn(preShift);
	    assertArrayEquals(shifted, preShift);
	    
	    char[][] ragged = {
	    		{'b', 'c', 'a','6'},
	    		{'e', 'f', 'd'},
	    		{'h', 'i', 'g'}};
	    
	     // Assert that it throws IllegalArgument when null
 		assertThrows(IllegalArgumentException.class, () -> {
 			TwoDimArrayUtil.rotateLeftOneColumn(null);
 		});
 		
         // Assert that it throws IllegalArgumentException when ragged
 		assertThrows(IllegalArgumentException.class, () -> {
 			TwoDimArrayUtil.rotateLeftOneColumn(ragged);
 		});
	}
	
	@Test
    public void testRotateTopOneRow() {
        char[][] preShift = { 
        		{ 'a', 'b', 'c' },
        		{ 'd', 'e', 'f' },
        		{ 'g', 'h', 'i' } };
        char[][] shifted = { 
        		{ 'd', 'e', 'f' },
        		{ 'g', 'h', 'i' },
        		{ 'a', 'b', 'c' } };
        TwoDimArrayUtil.rotateTopOneRow(preShift);
        assertArrayEquals(shifted, preShift);
        
        char[][] ragged = { 
        		{ 'd', 'e', 'f' },
        		{ 'g', 'h', 'i' },
        		{ 'a', 'b', 'c' ,'d'} };
        // Assert that it throws IllegalArgument when null
 		assertThrows(IllegalArgumentException.class, () -> {
 			TwoDimArrayUtil.rotateLeftOneColumn(null);
 		});
 		
 		// Assert that it throws IllegalArgumentException when ragged
 		assertThrows(IllegalArgumentException.class, () -> {
 			TwoDimArrayUtil.rotateLeftOneColumn(ragged);
 		});
    }
	
	@Test
	public void testHoriZontalBars() {
		
		//Declare all the inputs for the constructor
		HorizontalBars horiBar;
		int MAX_ROWS = 6;
		int MAX_COLS = 6;
		int BARS = 6;
		char COLOR1 = 'R';
		char COLOR2 = 'G';
		char COLOR3 = 'B';
		int ANIMATION_TYPE = 1;
		
		// Test the constructor and the board
		horiBar = new HorizontalBars(MAX_ROWS, MAX_COLS, BARS, COLOR1, COLOR2, COLOR3, ANIMATION_TYPE);
		String drawHori = DrawingApp.getHorizontalBars(MAX_ROWS, MAX_COLS, BARS, COLOR1, COLOR2, COLOR3);
		assertEquals(toString(horiBar.getBoard()),drawHori);
		
		// Test animation type 1
		horiBar.nextAnimationStep();
		
		String animation1 = 
				  "GGGGGG\n"
				+ "BBBBBB\n"
				+ "RRRRRR\n"
				+ "GGGGGG\n"
				+ "BBBBBB\n"
				+ "RRRRRR";
		assertEquals(animation1,toString(horiBar.getBoard()));
		
		// Test the rows
		assertEquals(MAX_ROWS, horiBar.getNumberRows());
		
		// Test the columns
		assertEquals(MAX_COLS, horiBar.getNumberCols());
		
	}
	
	@Test
	public void testVerticalBars() {
		
		//Declare all the inputs for the constructor
		VerticalBars vertiBar;
		int MAX_ROWS = 6;
		int MAX_COLS = 6;
		int BARS = 6;
		char COLOR1 = 'R';
		char COLOR2 = 'G';
		char COLOR3 = 'B';
		int ANIMATION_TYPE = 1;
		
		// Test the constructor and the board
		vertiBar = new VerticalBars(MAX_ROWS, MAX_COLS, BARS, COLOR1, COLOR2, COLOR3, ANIMATION_TYPE);
		String drawVerti = DrawingApp.getVerticalBars(MAX_ROWS, MAX_COLS, BARS, COLOR1, COLOR2, COLOR3);
		assertEquals(toString(vertiBar.getBoard()),drawVerti);
		
		// Test animation type 1
		vertiBar.nextAnimationStep();
		
		String animation1 = 
				  "GBRGBR\n"
				+ "GBRGBR\n"
				+ "GBRGBR\n"
				+ "GBRGBR\n"
				+ "GBRGBR\n"
				+ "GBRGBR";
		
		assertEquals(animation1,toString(vertiBar.getBoard()));
		
		// Test the rows
		assertEquals(MAX_ROWS, vertiBar.getNumberRows());
		
		// Test the columns
		assertEquals(MAX_COLS, vertiBar.getNumberCols());
		
	}
	
	@Test
	public void testFLAG() {
		
		//Declare all the inputs for the constructor
		Flag flag1, flag2;
		
		int SIZE = 3;
		int MAX_ROWS = 6;
		int MAX_COLS = SIZE * 5;
		char COLOR1 = 'R';
		char COLOR2 = 'G';
		char COLOR3 = 'B';
		int ANIMATION_TYPE = 1;
		
		// Test the constructor and the board
		flag1 = new Flag(SIZE, COLOR1, COLOR2, COLOR3, ANIMATION_TYPE);
		flag2 = new Flag(SIZE, COLOR1, COLOR2, COLOR3, ANIMATION_TYPE + 1);
		String drawFlag = DrawingApp.getFlag(SIZE, COLOR1, COLOR2, COLOR3);
		assertEquals(toString(flag1.getBoard()),drawFlag);
		
		// Test animation type 1
		flag1.nextAnimationStep();
		
		  String animation1 = ""
		  		+ "GGGGGGGGGGGGGGR\n"
		  		+ "RBBBBBBBBBBBBBR\n"
		  		+ "RRGGGGGGGGGGGGR\n"
		  		+ "RRGGGGGGGGGGGGR\n"
		  		+ "RBBBBBBBBBBBBBR\n"
		  		+ "GGGGGGGGGGGGGGR";
		  assertEquals(animation1,toString(flag1.getBoard()));
		  
		  // Test animation type 2
		  flag2.nextAnimationStep();		  
		  String animation2 =
				  "RRBBBBBBBBBBBBB\n"
		  		+ "RRRGGGGGGGGGGGG\n"
		  		+ "RRRGGGGGGGGGGGG\n"
		  		+ "RRBBBBBBBBBBBBB\n"
		  		+ "RGGGGGGGGGGGGGG\n"
		  		+ "RGGGGGGGGGGGGGG";
		  assertEquals(animation2,toString(flag2.getBoard()));
		  
		// Test the rows
		 assertEquals(MAX_ROWS, flag1.getNumberRows());
		 assertEquals(MAX_ROWS, flag2.getNumberRows());
		 
		// Test the columns
		 assertEquals(MAX_COLS, flag1.getNumberCols());
		 assertEquals(MAX_COLS, flag2.getNumberCols());
		
	}
	
	@Test
	public void testCombineLeftRight() {
		
		//Declare all the inputs for the constructor
		VerticalBars vertiBar1, vertiBar2;
		int MAX_ROWS = 6;				
		int MAX_COLS = 6;
		int BARS = 6;
		char COLOR1 = 'R';
		char COLOR2 = 'G';
		char COLOR3 = 'B';
		char COLOR4 = 'Y';
		char COLOR5 = '*';
		char COLOR6 = '.';
		int ANIMATION_TYPE = 1;
				
		// Test the constructor and the board
		vertiBar1 = new VerticalBars(MAX_ROWS, MAX_COLS, BARS, COLOR1, COLOR2, COLOR3, ANIMATION_TYPE);
		vertiBar2 = new VerticalBars(MAX_ROWS, MAX_COLS, BARS, COLOR4, COLOR5, COLOR6, ANIMATION_TYPE + 1);
		CombineLeftRight combineLR = new CombineLeftRight(vertiBar1,vertiBar2,ANIMATION_TYPE);
		
		String expectedCombineLR = 
				"RGBRGBY*.Y*.\n"
			  + "RGBRGBY*.Y*.\n"
			  + "RGBRGBY*.Y*.\n"
			  + "RGBRGBY*.Y*.\n"
			  + "RGBRGBY*.Y*.\n"
			  + "RGBRGBY*.Y*.";
		
		assertEquals(toString(combineLR.getBoard()),expectedCombineLR);
		
		// Test animation 1
		vertiBar1.nextAnimationStep();
		
		String animation1 = 
				  "GBRGBR\n"
				+ "GBRGBR\n"
				+ "GBRGBR\n"
				+ "GBRGBR\n"
				+ "GBRGBR\n"
				+ "GBRGBR";
		
		assertEquals(toString(vertiBar1.getBoard()),animation1);
		
		// Test animation 2
		vertiBar2.nextAnimationStep();
		
		String animation2 = 
				  "Y*.Y*.\n"
				+ "Y*.Y*.\n"
				+ "Y*.Y*.\n"
				+ "Y*.Y*.\n"
				+ "Y*.Y*.\n"
				+ "Y*.Y*.";
		
		assertEquals(toString(vertiBar2.getBoard()),animation2);
		
		// Test the rows
		assertEquals(MAX_ROWS, combineLR.getNumberRows());
				
		// Test the columns
		int combinedCols = vertiBar1.getNumberCols() + vertiBar2.getNumberCols();
		assertEquals(combinedCols, combineLR.getNumberCols());
		
		// Assert that it throws IllegalArgumentException when ragged
		HorizontalBars vertiBar3 = new HorizontalBars(MAX_ROWS + 5, MAX_COLS, BARS, COLOR1, COLOR2, COLOR3, ANIMATION_TYPE);
		HorizontalBars vertiBar4 = new HorizontalBars(MAX_ROWS, MAX_COLS + 5, BARS, COLOR4, COLOR5, COLOR6, ANIMATION_TYPE + 1);
		assertThrows(IllegalArgumentException.class, () -> {
			new CombineTopBottom(vertiBar3,vertiBar4,ANIMATION_TYPE + 1);
		});
				
	}
	
	@Test
	public void testCombineTopBottom() {
		
		//Declare all the inputs for the constructor
		HorizontalBars horiBar1, horiBar2;
		int MAX_ROWS = 6;				
		int MAX_COLS = 6;
		int BARS = 6;
		char COLOR1 = 'R';
		char COLOR2 = 'G';
		char COLOR3 = 'B';
		char COLOR4 = 'Y';
		char COLOR5 = '*';
		char COLOR6 = '.';
		int ANIMATION_TYPE = 1;

		// Test the constructor and the board
		horiBar1 = new HorizontalBars(MAX_ROWS, MAX_COLS, BARS, COLOR1, COLOR2, COLOR3, ANIMATION_TYPE);
		horiBar2 = new HorizontalBars(MAX_ROWS, MAX_COLS, BARS, COLOR4, COLOR5, COLOR6, ANIMATION_TYPE + 1);
		CombineTopBottom combineTB = new CombineTopBottom(horiBar1, horiBar2, ANIMATION_TYPE);
		
		String expectedCombineTB =
				  "RRRRRR\n"
				+ "GGGGGG\n"
				+ "BBBBBB\n"
				+ "RRRRRR\n"
				+ "GGGGGG\n"
				+ "BBBBBB\n"
				+ "YYYYYY\n"
				+ "******\n"
				+ "......\n"
				+ "YYYYYY\n"
				+ "******\n"
				+ "......";

		assertEquals(toString(combineTB.getBoard()), expectedCombineTB);
		
		// Test animation 1
		combineTB.nextAnimationStep();

		String animation1 =
				  "RRRRRR\n"
				+ "GGGGGG\n"
				+ "BBBBBB\n"
				+ "RRRRRR\n"
				+ "GGGGGG\n"
				+ "BBBBBB\n"
				+ "YYYYYY\n"
				+ "******\n"
				+ "......\n"
				+ "YYYYYY\n"
				+ "******\n"
				+ "......";	
	    assertEquals(toString(combineTB.getBoard()), animation1);

		// Test animation 2
        CombineTopBottom combineTB2 = new CombineTopBottom(horiBar1,horiBar2,ANIMATION_TYPE + 1);
        combineTB2.nextAnimationStep();

        String animation2 = 
				  "GGGGGG\n"
				+ "BBBBBB\n"
				+ "RRRRRR\n"
				+ "GGGGGG\n"
				+ "BBBBBB\n"
				+ "YYYYYY\n"
				+ "******\n"
				+ "......\n"
				+ "YYYYYY\n"
				+ "******\n"
				+ "......\n"
				+ "RRRRRR";			
		assertEquals(toString(combineTB2.getBoard()), animation2);

		// Test the rows
		assertEquals(MAX_ROWS * 2, combineTB.getNumberRows());

		// Test the columns
	    assertEquals(MAX_COLS, combineTB.getNumberCols());

		// Assert that it throws IllegalArgumentException when ragged
		HorizontalBars horiBar3 = new HorizontalBars(MAX_ROWS + 5, MAX_COLS, BARS, COLOR1, COLOR2, COLOR3, ANIMATION_TYPE);
		HorizontalBars horiBar4 = new HorizontalBars(MAX_ROWS, MAX_COLS + 5, BARS, COLOR4, COLOR5, COLOR6, ANIMATION_TYPE + 1);
		assertThrows(IllegalArgumentException.class, () -> {
			new CombineTopBottom(horiBar3,horiBar4,ANIMATION_TYPE + 1);
		});
	}
	
	// toString method to compare constructors
	public static String toString(char array [][]){
		
		StringBuilder s = new StringBuilder();
		
		for(int i = 0; i < array.length; i++) {
			
			for (int j = 0; j < array[i].length; j++) {
				s.append(array[i][j]);
			}
			if (i != array.length - 1) {
				s.append("\n");
			}
		}
		return s.toString();
	}
}
