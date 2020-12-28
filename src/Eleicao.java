
package src;
/*
 * Trabalho do primeiro gq - Programação I.
 * 
 * AS INSTRUÇÕES:
 * Faça um programa em Java para realizar uma eleição entre 3 candidatos 
 * (os candidatos são identificados pelos números inteiros 1, 2 ou 3). Seu programa deve:
 * a) Ler o voto (1, 2 ou 3) de cada eleitor. Mostrar uma mensagem de erro caso o usuário digite um voto inválido e 
 * ler novamente o voto até que um voto válido seja recebido;
 * b) Após a leitura de cada voto, o usuário deve escolher se deseja continuar (tecla ‘s’) ou 
 * encerrar a pesquisa (tecla ‘n’ ou qualquer outra tecla diferente de ‘s’);
 * c) Imprimir o percentual de votos de cada candidato;
 * d) Caso um candidato possua 50% ou mais dos votos, imprimir "Vencedor no primeiro turno: X", onde X é o código(1,2 ou 3) 
 * do candidato com mais votos. Caso contrário, imprimir "Segundo turno".
 * */

import java.util.*;

public class Eleicao {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int candidato;
        float contador1 = 0, contador2 = 0, contador3 = 0, contadorLoop = 0, porcentagemVotos1, porcentagemVotos2,
                porcentagemVotos3;
        char continuar;
        System.out.println("");
        System.out.println("***ELEIÇÕES***");
        do {
            System.out.println("VOCÊ PODE ESCOLHER ENTRE OS CANDIDATOS: 1,2 E 3 PARA VOTAR.");
            do {
                System.out.print("Escolha seu candidato: ");
                candidato = in.nextInt();
                if (candidato < 1 || candidato > 3) {
                    System.out.println("VOTO INVÁLIDO!");
                    System.out.println("Escolha um candidato válido(1,2 ou 3)");
                    System.out.println("");
                } else {
                }

            } while (candidato < 1 || candidato > 3);
            if (candidato == 1) {
                contador1++;
            } else if (candidato == 2) {
                contador2++;
            } else {
                contador3++;
            }
            System.out.print("Deseja continuar votando? (s/n): ");
            continuar = in.next().charAt(0);
            contadorLoop++;
        } while (continuar == 's' || continuar == 'S');
        porcentagemVotos1 = (contador1 / contadorLoop) * 100;
        porcentagemVotos2 = (contador2 / contadorLoop) * 100;
        porcentagemVotos3 = (contador3 / contadorLoop) * 100;
        System.out.println("candidato1= [" + contador1 + "] candidato2= [" + contador2 + "] candidato3= [" + contador3
                + "]" + " loops: " + contadorLoop);
        System.out.println("porcentagem dos candidatos 1,2,3: ");
        System.out.println(porcentagemVotos1);
        System.out.println(porcentagemVotos2);
        System.out.println(porcentagemVotos3);
        if (porcentagemVotos1 >= 50 || porcentagemVotos2 >= 50 || porcentagemVotos3 >= 50) {

            if (porcentagemVotos1 > porcentagemVotos2 && porcentagemVotos1 > porcentagemVotos3) {
                System.out.println("O candidato 1 venceu");
            }
            if (porcentagemVotos2 > porcentagemVotos1 && porcentagemVotos2 > porcentagemVotos3) {
                System.out.println("O candidato 2 venceu");
            }
            if (porcentagemVotos3 > porcentagemVotos1 && porcentagemVotos3 > porcentagemVotos2) {
                System.out.println("O candidato 3 venceu");
            }
        } else {
            System.out.println("Segundo turno!");
        }

    }
}
