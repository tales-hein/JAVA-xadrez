package xadrez;

import tabuleiro.Tabuleiro;

public class PartidaXadrez {
	private Tabuleiro tabuleiro;
	
	public PartidaXadrez() {
		tabuleiro = new Tabuleiro(8,8);
	}
	
	public PieceXadrez[][] getPieces(){
		PieceXadrez[][] partida = new PieceXadrez[tabuleiro.getFileiras()][tabuleiro.getColunas()];
		for(int i=0; i<tabuleiro.getFileiras(); i++) {
			for(int j=0; j<tabuleiro.getColunas(); j++) {
				partida[i][j] = (PieceXadrez) tabuleiro.piece(i, j);
			}
		}
		return partida;
	}
}
