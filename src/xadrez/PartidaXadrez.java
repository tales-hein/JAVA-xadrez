package xadrez;

import tabuleiro.Piece;
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
		PieceXadrez[][] partida = new PieceXadrez[tabuleiro.getLinhas()][tabuleiro.getColunas()];
		for(int i=0; i<tabuleiro.getLinhas(); i++) {
			for(int j=0; j<tabuleiro.getColunas(); j++) {
				partida[i][j] = (PieceXadrez) tabuleiro.piece(i, j);
			}
		}
		return partida;
	}
	
	public PieceXadrez makeChessMove(XadrezPosition sourceP, XadrezPosition targetP) {
		Position source = sourceP.toPosition();
		Position target = targetP.toPosition();
		validaSourcePosition(source);
		Piece capPiece = movimento(source, target);
		return (PieceXadrez) capPiece;
	}
	
	private Piece movimento(Position source, Position target) {
		Piece p = tabuleiro.removePiece(source);
		Piece capPiece = tabuleiro.removePiece(target);
		tabuleiro.placePiece(p, target);
		return capPiece;
	}
	
	private void validaSourcePosition(Position position) {
		if(!tabuleiro.thereIsPiece(position)) {
			throw new XadrezException("Nao ha peca na posicaoo de inicio da jogada");
		}
	}
	
	private void novaPosicaoPiece(char coluna, int linha, PieceXadrez piece) {
		tabuleiro.placePiece(piece, new XadrezPosition(coluna, linha).toPosition());
	}
	
	private void setupInicial() {
		novaPosicaoPiece('c', 1, new Torre(tabuleiro, Cor.BRANCO));
		novaPosicaoPiece('c', 2, new Torre(tabuleiro, Cor.BRANCO));
		novaPosicaoPiece('d', 2, new Torre(tabuleiro, Cor.BRANCO));
		novaPosicaoPiece('e', 2, new Torre(tabuleiro, Cor.BRANCO));
		novaPosicaoPiece('e', 1, new Torre(tabuleiro, Cor.BRANCO));
        novaPosicaoPiece('d', 1, new Rei(tabuleiro, Cor.BRANCO));

        novaPosicaoPiece('c', 7, new Torre(tabuleiro, Cor.PRETO));
        novaPosicaoPiece('c', 8, new Torre(tabuleiro, Cor.PRETO));
        novaPosicaoPiece('d', 7, new Torre(tabuleiro, Cor.PRETO));
        novaPosicaoPiece('e', 7, new Torre(tabuleiro, Cor.PRETO));
        novaPosicaoPiece('e', 8, new Torre(tabuleiro, Cor.PRETO));
        novaPosicaoPiece('d', 8, new Rei(tabuleiro, Cor.PRETO));
	}
}
