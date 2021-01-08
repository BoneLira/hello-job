package src;

/*
* Cenário: Uma empresa de celulares chamada MOKIA pretende relançar uma linha de celulares que fez muito sucesso no   
* passado, 3310. Com o aparelho, virá um jogo chamado Snake 2.0, que é uma evolução do jogo Snake da versão origina(no   
* Brasil, esse game ficou popular pelo nome do Jogo da Cobrinha). Nessa nova versão, o jogo é realizado num tabuleiro 
* de   10x10. E o jogador começa sempre da posição [0,0]. Partindo dessa posição o jogador deve percorrer o tabuleiro 
* pegando   os elementos que estão presentes do tabuleiro. O jogo acaba quando todas as marcas visíveis do tabuleiro são 
* alcançadas.   Contudo, existem marcações secretas no tabuleiro que se alcançadas, concedem pontos extras ao jogador. 
*/
import java.util.*;

public class SnakeGame {
    static Scanner in = new Scanner(System.in);

    public static boolean verificaMovimento(int[][] tabuleiro, int inicialX, int inicialY, int finalX, int finalY) {

        boolean movimentoValido = false, movimentoX = false, movimentoY = false;

        if (finalX != inicialX && finalY != inicialY || finalX == inicialX && finalY == inicialY) {

        } else if (tabuleiro[finalX][finalY] == -1) {
            movimentoValido = false;
        } else {
            if (inicialX == 0 || inicialY == 0) {
                if (finalX == inicialX || finalX == inicialX + 1 || finalX == inicialX - 1) {
                    movimentoX = true;
                }
                if (finalY == inicialY || finalY == inicialY + 1 || finalY == inicialY - 1) {
                    movimentoY = true;
                }
            } else if (inicialX == 9 || inicialY == 9) {
                if (finalX == inicialX || finalX == inicialX - 1 || finalX == inicialX + 1) {
                    movimentoX = true;
                }
                if (finalY == inicialY || finalY == inicialY - 1 || finalY == inicialY + 1) {
                    movimentoY = true;
                }
            } else {
                if (finalX == inicialX || finalX == inicialX - 1 || finalX == inicialX + 1) {
                    movimentoX = true;
                }
                if (finalY == inicialY || finalY == inicialY - 1 || finalY == inicialY + 1) {
                    movimentoY = true;
                } // if(finalX==inicialX && finalY==inicialY +1 || finalY==inicialY-1) {

                // }
            }
        }

        if (movimentoX == true && movimentoY == true) {
            movimentoValido = true;
            inicialX = finalX;
            inicialY = finalY;
        }

        return movimentoValido;
    }

    public static int calculaPontos(int[][] tabuleiro, int finalX, int finalY) {
        int pontos = 0;
        pontos += tabuleiro[finalX][finalY];
        return pontos;
    }

    public static void imprimeMapa(int[][] tabuleiro) {
        int num = 0;
        String eixoY = "  0 1 2 3 4 5 6 7 8 9 ", corpoSnake = "🟢", cabeçaSnake = "🐍", visivel = "💰", sinal = "null";

        System.out.println(eixoY);
        for (int i = 0; i < tabuleiro.length; i++) {
            System.out.print(num + " ");

            for (int j = 0; j < tabuleiro[i].length; j++) {
                if (tabuleiro[i][j] == -1) {
                    sinal = corpoSnake;
                } else if (tabuleiro[i][j] == 0) {
                    sinal = "[]";
                } else if (tabuleiro[i][j] == 1) {
                    sinal = cabeçaSnake;
                } else if (tabuleiro[i][j] == 5) {
                    sinal = visivel;
                }
                System.out.print(sinal);
            }
            num++;
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        int[][] tabuleiro = new int[10][10];
        int inicialX = 0, inicialY = 0, finalX, finalY, pontos = 0, jogadas = 0, score = 0;
        String nome1 = "null", nome2 = "null";
        char novaPartida = 'S';
        boolean nomesConferem = false, movimento;

        do {
            // valor inicial colocado como 0.
            for (int i = 0; i < tabuleiro.length; i++) {
                for (int j = 0; j < tabuleiro[i].length; j++) {
                    tabuleiro[i][j] = 0;
                }
            }
            // marcação visível.
            tabuleiro[0][1] = 5;
            tabuleiro[2][3] = 5;
            tabuleiro[4][5] = 5;
            tabuleiro[6][7] = 5;
            tabuleiro[8][9] = 5;
            // marcação invisível.
            tabuleiro[3][5] = 15;
            tabuleiro[6][0] = 15;
            tabuleiro[2][1] = 15;
            tabuleiro[8][2] = 15;
            tabuleiro[9][3] = 15;

            System.out.println("Comece colocando seu nome(mais de 7 characteres)");

            do {
                System.out.print("Escolha um NOME: ");
                nome1 = in.next();

                System.out.print("confirme seu NOME: ");
                nome2 = in.next();

                if (nome1.equals(nome2) && nome1.length() > 3) {
                    nomesConferem = true;
                } else {
                    nomesConferem = false;
                    System.out.println(
                            "ERRO.Você deve ter errado os nomes ou escolheu nomes curtos demais.Tente novamente");
                    System.out.println("");

                }
            } while (nomesConferem == false);

            while (tabuleiro[0][1] == 5 || tabuleiro[2][3] == 5 || tabuleiro[4][5] == 5 || tabuleiro[6][7] == 5
                    || tabuleiro[8][9] == 5) {

                do {
                    System.out.println("Insira as coordenadas de movimento.");
                    System.out.print("Coordenada X: ");
                    finalX = in.nextInt();
                    System.out.print("Coordenada Y: ");
                    finalY = in.nextInt();
                    movimento = verificaMovimento(tabuleiro, inicialX, inicialY, finalX, finalY);
                    if (movimento == false) {
                        System.out.println("MOVIMENTO NÃO PERMITIDO,TENTE NOVAMENTE.");
                    }
                } while (movimento == false);

                if (movimento == true) {
                    pontos += calculaPontos(tabuleiro, finalX, finalY);
                    if (tabuleiro[finalX][finalY] >= 5) {
                        System.out.println("Seus pontos: " + pontos);
                    }
                    tabuleiro[inicialX][inicialY] = -1;
                    inicialX = finalX;
                    inicialY = finalY;
                    tabuleiro[finalX][finalY] = 1;
                    jogadas++;

                }
                score = pontos / jogadas;
                imprimeMapa(tabuleiro);

                System.out.println(inicialX + ", " + inicialY);
                System.out.println(jogadas);

            }
            System.out.println("PARABÉNS," + nome1 + ", sua pontuação foi de " + score + " pontos");
            System.out.print("DESEJA CONTINUAR? (s/n): ");
            novaPartida = in.next().charAt(0);
            if (novaPartida == 's' || novaPartida == 'S') {
                inicialX = 0;
                inicialY = 0;
                pontos = 0;
                score = 0;
            }
        } while (novaPartida == 's' || novaPartida == 'S');
        System.out.println("Obrigado por jogar.Até mais!");
    }
}
