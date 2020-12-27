package src;
/**
 * 1. Faça um algoritmo que leia o ano que uma pessoa (dia, mês e ano), 
 * o ano atual e mostre a idade da pessoa.
 * 2. Altere o algorítimo anterior para mostrar quantos dias se passaram desde o seu nascimento 
 * (Considere que todos os anos têm 365 dias).
 * 
 */
import java.util.*;

public class Idade {
    static Scanner in = new Scanner(System.in);

    public static void mostrarIdade(String dataAtual, String dataNascimento) {

    }

    public static void main(String[] args) {
        int diaNascimento, mesNascimento, anoNascimento, anoAtual, mesAtual, diaAtual, idadeDias = 0, idadeMeses = 0,
                idadeAnos = 0;
        String diaA, diaN, mesA, mesN, anoA, anoN, dataAtual, dataNascimento;

        try {
            System.out.print("Insira a data atual(DD/MM/AAAA): ");
            dataAtual = in.next();
            System.out.print("Insira a data do seu nascimento(DD/MM/AAAA): ");
            dataNascimento = in.next();
            diaA = dataAtual.substring(0, 2);
            mesA = dataAtual.substring(3, 5);
            anoA = dataAtual.substring(6, 10);
            anoAtual = Integer.parseInt(anoA);
            mesAtual = Integer.parseInt(mesA);
            diaAtual = Integer.parseInt(diaA);

            diaN = dataNascimento.substring(0, 2);
            mesN = dataNascimento.substring(3, 5);
            anoN = dataNascimento.substring(6, 10);
            anoNascimento = Integer.parseInt(anoN);
            mesNascimento = Integer.parseInt(mesN);
            diaNascimento = Integer.parseInt(diaN);

            idadeAnos = anoAtual - anoNascimento;

            if (mesAtual < mesNascimento) {
                idadeAnos--;
                

            }
            if (mesAtual == mesNascimento) {
                if (diaAtual < diaNascimento) {
                    idadeAnos--;
                }
            }
            idadeMeses = idadeAnos * 12;
            idadeDias = idadeAnos * 365;

            System.out.println(
                    "Sua idade em [dias: " + idadeDias + "] [meses: " + idadeMeses + "] [anos: " + idadeAnos + "] ");
        } catch (Exception stringIndexOutOfBounException) {
            System.out.println("FORMATO INVÁLIDO!");
            // loop

        }

    }
}