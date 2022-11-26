package tabuleiro;

public class Tabuleiro {
	private int fileiras;
	private int colunas;
	private Piece[][] pieces;
	
	public Tabuleiro(int fileiras, int colunas) {
		this.fileiras = fileiras;
		this.colunas = colunas;
		this.pieces = new Piece[fileiras][colunas];
	}

	public int getFileiras() {
		return fileiras;
	}

	public void setFileiras(int fileiras) {
		this.fileiras = fileiras;
	}

	public int getColunas() {
		return colunas;
	}

	public void setColunas(int colunas) {
		this.colunas = colunas;
	}
	
	public Piece piece(int fileira, int coluna) {
		return pieces[fileira][coluna];
	}
	
	public Piece piece(Position position) {
		return pieces[position.getFileira()][position.getColuna()];
	}
	
	public void placePiece(Piece piece, Position position) {
		this.pieces[position.getFileira()][position.getColuna()] = piece;
		piece.position = position;
	}
	
}
