package xiangqi.core;

public class Pieces {
	public static int piece;
	public static int empty = 0;
	public static final int k = 1;
	public static final int a = 2;
	public static final int e = 3;
	public static final int n = 4;
	public static final int r = 5;
	public static final int c = 6;
	public static final int p = 7;
	public static int encodePieces(int type, int color) {
		if(type > 7 || type < 0) 
			throw new IllegalArgumentException("Sai chỉ số quân cờ");
		if(color < 0 | color > 1)
			throw new IllegalArgumentException("Sai màu");
		return type + (color << 3);
	}
	int red = Board.red;
	int black = Board.black;
	int bK = encodePieces(k, black);
	int bA = encodePieces(a, black);
	int bE = encodePieces(e, black);
	int bN = encodePieces(n, black);
	int bR = encodePieces(r, black);
	int bC = encodePieces(c, black);
	int bP = encodePieces(p, black);
	int rK = encodePieces(k, red);
	int rA = encodePieces(a, red);
	int rE = encodePieces(e, red);
	int rN = encodePieces(n, red);
	int rR = encodePieces(r, red);
	int rC = encodePieces(c, red);
	int rP = encodePieces(p, red);
	public static int typeOf(int piece)  { 
		return (piece & 7); 
	}
	public static int colorOf(int piece) { 
		return ((piece >> 3) & 1); 
	}
	public static String symbol(int piece) {
		if (piece == empty) return ".";
		String s = switch(typeOf(piece)) {
		case k -> "K";
        case a -> "A";
        case e -> "E";
        case n -> "N";
        case r -> "R";
        case c -> "C";
        case p -> "P";
        default -> "?";	    
		};
		return (colorOf(piece) == Board.black) ? s : s.toLowerCase();
	}
	public static void main(String[] args) {
		
	}
}
