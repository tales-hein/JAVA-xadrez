package xadrez;

import tabuleiro.Piece;
import tabuleiro.Tabuleiro;

public class PieceXadrez extends Piece {
	private Cor cor;

	public PieceXadrez(Tabuleiro tabuleiro, Cor cor) {
		super(tabuleiro);
		this.cor = cor;
	}

	public Cor getCor() {
		return cor;
	}
}
