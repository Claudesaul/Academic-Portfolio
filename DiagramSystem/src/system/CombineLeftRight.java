package system;

public class CombineLeftRight implements Diagram {
	
	private int animationType;
	private char[][] board;
	
	public CombineLeftRight(Diagram left, Diagram right, int animationType) {
		
		if (left.getNumberRows() != right.getNumberRows()) {
			throw new IllegalArgumentException();
		}
		
		this.animationType = animationType;
		
		board = TwoDimArrayUtil.appendLeftRight(left.getBoard(), right.getBoard());
		
	}

	public char[][] getBoard() {
		return board;
	}

	public char[][] nextAnimationStep() {
		
		if (animationType == 1) {
			TwoDimArrayUtil.rotateLeftOneColumn(board);
		}
		if (animationType == 2) {
			TwoDimArrayUtil.rotateTopOneRow(board);
		}
		return board;
	}

	public int getNumberRows() {
		return board.length;
	}

	public int getNumberCols() {
		return board[0].length;
	}
	

}
