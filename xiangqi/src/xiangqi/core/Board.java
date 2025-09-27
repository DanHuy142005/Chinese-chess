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
	public static void main(String[] args) {
		
	}
}
