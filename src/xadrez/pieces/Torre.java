package xadrez.pieces;

import tabuleiro.Tabuleiro;
import xadrez.Cor;
import xadrez.PieceXadrez;

public class Torre extends PieceXadrez{
	public Torre(Tabuleiro tabuleiro, Cor cor) {
		super(tabuleiro, cor);
	}
	@Override
	public String toString() {
		return "T";
	}
}
