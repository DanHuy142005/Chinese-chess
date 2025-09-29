package xiangqi.core;


public class Board {
	public static final int files = 9;
	public static final int ranks = 10;
	public static final int size = files * ranks;
	public static final int red = 0; 
	public static final int black = 1;
	private final int[] squares;
    private int sideToMove;
    public Board() {
    	this.squares = new int[size];
    	this.sideToMove = red;
    }
    public void changeSide() {
    	sideToMove = (sideToMove == red) ? black : red; 
    }
    public int getSideToMove() {
    	return sideToMove;
    }
    public static int index(int rank, int file) {
    	if(rank < 0 || rank >= ranks) {
    		throw new IllegalArgumentException("vượt quá chỉ số hàng");
    	}
    	if(file < 0 || file >= files) {
    		throw new IllegalArgumentException("vượt quá chỉ số cột");
    	}
    	return rank*files+file;
    }
    public int getPieces(int rank, int file) {
    	return squares[index(rank, file)];
    }
    public void setPieces(int rank, int file, int piece) {
    	squares[index(rank, file)] = piece;
    }
    public static Board initial() {
    	Board b = new Board();
    	int row0[] = {Pieces.bR, Pieces.bN, Pieces.bE, Pieces.bA, Pieces.bK,
                Pieces.bA, Pieces.bE, Pieces.bN, Pieces.bR }; 
    	for (int j = 0; j < files; j++) {
    		b.setPieces(0, j, row0[j]);
    	}
    	b.setPieces(2, 1, Pieces.bC);
    	b.setPieces(2, 7, Pieces.bC);
    	for (int j : new int[]{0,2,4,6,8}) b.setPieces(3, j, Pieces.bP);
    	for (int c : new int[]{0,2,4,6,8}) b.setPieces(6, c, Pieces.rP);
    	b.setPieces(7, 1, Pieces.rC);
    	b.setPieces(7, 7, Pieces.rC);
    	int[] row9 = { Pieces.rR, Pieces.rN, Pieces.rE, Pieces.rA, Pieces.rK,
                Pieces.rA, Pieces.rE, Pieces.rN, Pieces.rR };
        for (int c = 0; c < files; c++) b.setPieces(9, c, row9[c]);
        return b;
    }
    public void print() {
    	 StringBuilder sb = new StringBuilder();
         for (int r = 0; r < ranks; r++) {
             for (int f = 0; f < files; f++) {
                 int piece = getPieces(r, f);
                 sb.append(Pieces.symbol(piece))       
                   .append(' ');
             }
             sb.append('\n');
         }
         System.out.print(sb.toString());
         System.out.println("Side to move: " + (sideToMove == red ? "RED" : "BLACK"));	
    }
	public static void main(String[] args) {
		Board b = Board.initial();
        b.print();
	}
}

