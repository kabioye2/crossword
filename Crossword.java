package homework;

import stdlib.StdOut;

public class Crossword {
	private Square[][] puzzle;

	public Crossword(boolean[][] blackSquares) {
		puzzle = new Square[blackSquares.length][blackSquares[0].length];
		// FINISH
		int label = 1;

		for (int r = 0; r < puzzle.length; r++) {//add rows
			for (int c = 0; c < puzzle[r].length; c++) {//add columns
				if (blackSquares[r][c] == true) {
					puzzle[r][c] = new Square(true, 0);// unlabeled black squares
				} else if (blackSquares[r][c] == false) {
					if (tobeLabeled(r, c, blackSquares) == true) {// labeled squares
						puzzle[r][c] = new Square(false, label);
						label++;// label non-black squares
					} else {
						puzzle[r][c] = new Square(false, 0);// unlabeled non-black squares
					}
				}
			}
		}
	}

	private boolean tobeLabeled(int r, int c, boolean[][] blackSquares) {
		// TODO
		if (blackSquares[r][c] == true)// if black don't label
			return false;
		if (r != 0 && blackSquares[r - 1][c] == true) {// if the row is not black and the row above is black
			return true;
		}
		if (c != 0 && blackSquares[r][c - 1] == true) {// if column is not black and the column to the left is black
			return true;
		}
		return false;// (inclusive) if row above and to the left is not black(white) then false
	}

	public void print() {
		for (int i = 0; i < puzzle.length; i++) {
			for (int j = 0; j < puzzle[0].length; j++)
				StdOut.print(puzzle[i][j].getLabel());
			StdOut.println();
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean[][] test = new boolean[7][9];
		test[0][0] = true;
		test[0][3] = true;
		test[0][4] = true;
		test[0][5] = true;
		test[1][4] = true;
		for (int j = 6; j < 9; j++)
			test[2][j] = true;
		test[3][2] = true;
		test[3][6] = true;
		for (int j = 0; j < 3; j++)
			test[4][j] = true;
		test[5][4] = true;
		test[6][3] = true;
		test[6][4] = true;
		test[6][5] = true;
		test[6][8] = true;

		Crossword c = new Crossword(test);
		c.print();

	}

}
