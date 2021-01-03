package src;

/**
 * Cenário: A Steam está lhe contratando para desenvolver o jogo Batalha Naval.
 * IMPORTANTE! Escrevam um relatório explicando todos
 * os conceitos e as decisões que você tomou para escrever o seu programa. Esse
 * relatório deve vir separado do código.
 */
import java.util.*;

public class BatalhaNaval {
    static Scanner in = new Scanner(System.in);

    public static boolean verificaPosicao(int[][] matriz, int posiX, int posiY) {
        boolean barco = false;
        if (posiX == 0 && posiY == 1 || posiX == 2 && posiY == 3 || posiX == 4 && posiY == 5 || posiX == 6 && posiY == 7
                || posiX == 8 && posiY == 9) {
            matriz[posiX][posiY] = 1;
            barco = true;
        } else {
            matriz[posiX][posiY] = -1;
        }
        return barco;
    }

    public static int contaBarcos(int[][] matriz) {
        int numBarcos = 5;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] == 1) {
                    numBarcos--;
                }
            }
        }
        return numBarcos;
    }

    public static void imprimeMapa(int[][] matriz) {
        int num = 0, contador = 0;
        String barco = "🚢", mar = "🌊", bomba = "💣", simbolo = "null";
        // char barco='^',mar='~',simbolo='*';
        // caso a linha da String não funcione(corrigir espaçamento).

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] == 1) {
                    simbolo = barco;
                } else if (matriz[i][j] == 0) {
                    simbolo = mar;
                } else {
                    simbolo = bomba;
                }
                if (contador % 10 == 0 || contador == 0) {
                    System.out.println("");
                    if (contador == 0) {
                        System.out.println("   0 1 2 3 4 5 6 7 8 9");// corrigir aqui o espaçamento.
                    }
                    System.out.print(num + " ");
                    num++;
                    contador = 0;
                }
                System.out.print(simbolo);
                contador++;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matriz = new int[10][10];
        int posiX, posiY, barcos = 0, contadorPontos = 0;
        String nome = "null";

        // loop para receber valor na posição.
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = 0;
            }
        }
        do {
            System.out.print("Insira o seu nome (pelo menos 5 characteres):");
            nome = in.nextLine();
            if (nome.length() < 5) {
                System.out.println("NOME CURTO DEMAIS,MÍNIMO DE 5 CHARACTERES.");
            }
        } while (nome.length() < 5);

        do {
            System.out.print("Escolha a coordenada X do ataque: ");
            posiX = in.nextInt();
            System.out.print("Escolha a coordenada Y do ataque: ");
            posiY = in.nextInt();
            verificaPosicao(matriz, posiX, posiY);
            // System.out.println(verificada); //verificar se tudo está de acordo.
            barcos = contaBarcos(matriz);
            System.out.println("Restam " + barcos + " barcos para afundar.");
            imprimeMapa(matriz);
            System.out.println("");
            contadorPontos++;
        } while (barcos > 0);
        System.out.println("");
        if (contadorPontos == 5) {
            System.out.println("INCRÍVEL!");
        } else {
            System.out.println("Você precisou de " + contadorPontos + " tentativas para destruir a frota inimiga.");
        }
    }
}
