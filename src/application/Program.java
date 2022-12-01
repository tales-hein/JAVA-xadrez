package application;

import java.util.InputMismatchException;
import java.util.Scanner;

import xadrez.PartidaXadrez;
import xadrez.PieceXadrez;
import xadrez.XadrezException;
import xadrez.XadrezPosition;

public class Program {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		PartidaXadrez partida = new PartidaXadrez();
		
		while(true){
			try {
				UI.limpaTela();
				UI.printTabuleiro(partida.getPieces());
				System.out.println();
				System.out.print("Peca a ser movida: ");
				XadrezPosition source = UI.readXadrezPosition(sc);
				System.out.println();
				System.out.print("Alvo: ");
				XadrezPosition target = UI.readXadrezPosition(sc);
				PieceXadrez capPiece = partida.makeChessMove(source, target);
			}catch(XadrezException e) {
				System.out.println(e.getMessage());
				sc.nextLine();
			}catch(InputMismatchException e) {
				System.out.println(e.getMessage());
				sc.nextLine();
			}
		}
	}
}
