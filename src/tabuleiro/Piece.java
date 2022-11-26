package tabuleiro;

public class Piece {
	protected Position position;
	private Tabuleiro tabuleiro;
	
	public Piece(Tabuleiro tabuleiro) {
		this.tabuleiro = tabuleiro;
		this.position = null;
	}
	
	protected Tabuleiro getTabuleiro() {
		return this.tabuleiro;
	}
}
