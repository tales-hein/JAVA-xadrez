package xadrez;

import tabuleiro.Position;
import tabuleiro.Tabuleiro;
import xadrez.pieces.Rei;
import xadrez.pieces.Torre;

public class PartidaXadrez {
	private Tabuleiro tabuleiro;
	
	public PartidaXadrez() {
		tabuleiro = new Tabuleiro(8,8);
		setupInicial();
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
	
	private void setupInicial() {
		tabuleiro.placePiece(new Torre(tabuleiro, Cor.BRANCO), new Position(2, 1));
		tabuleiro.placePiece(new Rei(tabuleiro, Cor.PRETO), new Position(2, 5));
	}
}
