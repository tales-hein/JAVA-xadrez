package tabuleiro;

public class Tabuleiro {
	private int linhas;
	private int colunas;
	private Piece[][] pieces;
	
	public Tabuleiro(int linhas, int colunas) {
		if(linhas<1 || colunas<1) {
			throw new TabuleiroException("Erro ao criar tabuleiro: "
					+ "deve haver pelo menos 1 coluna e uma 1 fileira");
		}
		this.linhas = linhas;
		this.colunas = colunas;
		this.pieces = new Piece[linhas][colunas];
	}

	public int getLinhas() {
		return linhas;
	}

	public int getColunas() {
		return colunas;
	}

	public Piece piece(int linha, int coluna) {
		if(!posicaoExists(linha, coluna)) {
			throw new TabuleiroException("Posicao fora do tabuleiro");
		}
		return pieces[linha][coluna];
	}
	
	public Piece piece(Position position) {
		if(!posicaoExists(position)) {
			throw new TabuleiroException("Posicao fora do tabuleiro");
		}
		return pieces[position.getLinha()][position.getColuna()];
	}
	
	public void placePiece(Piece piece, Position position) {
		if(thereIsPiece(position)) {
			throw new TabuleiroException("Ha uma peça nessa posicao " + position);
		}
		this.pieces[position.getLinha()][position.getColuna()] = piece;
		piece.position = position;
	}
	
	public Piece removePiece(Position position) {
		if(!posicaoExists(position)) {
			throw new TabuleiroException("Posicao fora do tabuleiro");
		}
		if (piece(position) == null) {
			return null;
		}
		Piece aux = piece(position);
		aux.position = null;
		pieces[position.getLinha()][position.getColuna()] = null;
		return aux;
	}
	
	public boolean posicaoExists(int linha, int coluna) {
		return (linha >= 0) && (linha < this.linhas) && (coluna >= 0) && (coluna < this.colunas);
	}
	
	public boolean posicaoExists(Position position) {
		return posicaoExists(position.getLinha(), position.getColuna());
	}
	
	public boolean thereIsPiece(Position position) {
		if(!posicaoExists(position)) {
			throw new TabuleiroException("Posicao fora do tabuleiro");
		}
		return piece(position) != null;
	}
}
