
// Ainda faltam várias adições ao jogo que serão feitas ao longo do tempo.
// It´s a DEMO, guys!
package src;

import java.util.*;

public class TicTacToe {
    static Scanner in = new Scanner(System.in);

    public static void imprimeMapa(int[][] tabuleiro) {
        char jogador = '.', jogador1 = 'X', jogador2 = 'O';

        for (int i = 0; i < tabuleiro.length; i++) {
            System.out.println("");
            for (int j = 0; j < tabuleiro[i].length; j++) {
                if (tabuleiro[i][j] == 1) {
                    System.out.print("[" + jogador1 + "]");
                } else if (tabuleiro[i][j] == 2) {
                    System.out.print("[" + jogador2 + "]");
                } else {
                    System.out.print("[" + jogador + "]");
                }
            }
        }
        System.out.println("");
    }

    public static boolean pontoValido(int[][] tabuleiro, int posiX, int posiY) {
        boolean ponto = false;

        if (tabuleiro[posiX][0] == tabuleiro[posiX][1] && tabuleiro[posiX][2] == tabuleiro[posiX][0]
                && tabuleiro[posiX][0] != 0) {
            ponto = true;
        } else if (tabuleiro[0][posiY] == tabuleiro[1][posiY] && tabuleiro[2][posiY] == tabuleiro[0][posiY]
                && tabuleiro[0][posiY] != 0) {
            ponto = true;

        } else if (tabuleiro[0][0] == tabuleiro[1][1] && tabuleiro[0][0] == tabuleiro[2][2] && tabuleiro[0][0] != 0
                || tabuleiro[0][2] == tabuleiro[1][1] && tabuleiro[2][0] == tabuleiro[0][2] && tabuleiro[0][2] != 0) {
            ponto = true;

        }
        return ponto;
    }

    public static void main(String[] args) {
        int[][] tabuleiro = new int[3][3];
        int posiX, posiY, contador = 0, vencedor = 0;
        String player1, player2;
        boolean ponto = false;

        System.out.print("Insira o nome do jogador 1: ");
        player1 = in.nextLine();
        System.out.print("Agora insira o nome do jogador 2: ");
        player2 = in.nextLine();

        do {
            System.out.println("Insira o 'X' :");
            posiX = in.nextInt();
            posiY = in.nextInt();
            tabuleiro[posiX][posiY] = 1;
            imprimeMapa(tabuleiro);

            ponto = pontoValido(tabuleiro, posiX, posiY);
            contador++;

            if (ponto == true) { // if it is a point, the game ends.
                System.out.println("Parabéns, " + player1 + " Você ganhou a partida!");
                vencedor = 1;
                break;
            }
            System.out.println("Insira o 'O' :");
            posiX = in.nextInt();
            posiY = in.nextInt();
            tabuleiro[posiX][posiY] = 2;
            imprimeMapa(tabuleiro);
            ponto = pontoValido(tabuleiro, posiX, posiY);

            contador++;

        } while (ponto == false || contador == 9);
        if (contador == 9) {
            System.out.println("Empate!");
        } else {
            if (vencedor == 0) {
                System.out.println("Parabéns, " + player2 + " Você ganhou a partida!");
            }
        }
    }
}