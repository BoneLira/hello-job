
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
        System.out.println("");
        System.out.println("***ELEIÇÕES***");
        System.out.println("VOCÊ PODE ESCOLHER ENTRE OS CANDIDATOS: 1,2 E 3 PARA VOTAR.");
        do{
        System.out.print("Escolha seu candidato: ");
        candidato=in.nextInt();
            if(candidato<1 || candidato>3) {
                System.out.println("VOTO INVÁLIDO!");
                System.out.println("Escolha um candidato válido(1,2 ou 3)");
            }else{}
        }while(candidato<1 || candidato>3);
    }
    
}
