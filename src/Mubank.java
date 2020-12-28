package src;

/**
 * /*
 * TRABALHO PARA O CURSO DE PROGRAMAÇÃO I, UNICAP
 *
 * a) Ele deve ler do teclado o valor da fatura e o dia do seu pagamento. 
 * Os sistema deve garantir que o valor da fatura digitada seja positivo e que o dia do pagamento
 * 	esteja entre 1 e 31. No caso de números inválidos,apresente uma mensagem de erro correspondente, e
 *  requisite que o usuário digite novamente.	
 *  b) O valor de fato a ser pago vai depender da data limite da fatura. Todas as
 *  faturas terão a mesma data limite. Essa data deve ser o dia do aniversário
 *  do programador ( 28 ). Se o dia do pagamento foi
 *  anterior à data limite, o valor a ser pago deve ser reduzido de 5%. Caso seja,
 *  exatamente na data, é o valor completo. Caso seja posterior a data limite,
 *  deve-se acrescentar ao valor 2% mais 1% para cada dia que excedeu. Por
 *  exemplo, considere a data limite dia 10, caso o pagamento seja feito no dia
 *  14, o valor a ser pago deve ser acrescido de 6% (2% + 1% para cada dia
 *  além do dia 10).
 * 
 *  c) O processo de leitura dos dados das faturas e o cálculo do valor a ser pago
 *  deve se repetir. Essa repetição deve ser feita de acordo com o número da
 *  sua matrícula:
 * i)Se sua matrícula terminar com um número par, então antes de
 *  fornecer qualquer dado sobre as faturas, o usuário deve dizer a
 *  quantidade de faturas que dever ser lidas.
 *  ii) Se sua matrícula terminar com número impar, logo após a leitura
 *  dos dados de uma fatura e o cálculo do seu valor, o programa deve
 *  perguntar ao usuário se deseja processar mais uma fatura
 *  (digitando a letra 's') ou parar (digitando qualquer outra letra).
 *  
 *  d) Depois de conlcuir todos os pagamentos, uma das seguintes informações
 *  devem ser apresentadas. A Informação apresentada é definida de acordo
 *  com o seu nome:
 *  i) Se seu nome começar com as letras A-M, voce deve apresentar
 *  apresentar a média do pagamentos de acordo com o calculo
 *  adequado.
 * ii)Se seu nome começar com N-Z, você deve apresentar o somatorio
 *    de todos os dias que ultrapassaram o limite da data do pagamento.
 * 
 *  e) Por fim, o programa deve aprensentar uma mensagem de acordo com o
 *  número de pagamentos realizados:
 *  i) Se forem mais de 1000 pagamento: "Meta ótima alcançada"
 *  ii) Se forem entre 500 e 1000: "Meta intermediária alcançada"
 *  iii) entre 100 e 500: "Abaixo da meta"
 *  iv) abaixo de 100: "Programa desconinuado"
 *  
 *  Sua resposta deve mostrar a descrição configurada para suas características,
 *  considerando o seu nome, matrícula e dia de aniversário. Além do algoritmo em Java, você
 *  deve apresentar uma descrição da sua solução.
 *	
 */
import java.util.*;

public class Mubank {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int diaFatura, vencimentoFatura = 28,numeroFaturas, atrasoPagamento,somatorioAtraso=0;
        double valorFatura,valorFinalFatura = 0;
        System.out.println("===MuBank===");
        System.out.println("SISTEMA DE PAGAMENTO DE FATURAS");
        System.out.print("Quantas faturas serão pagas? ");
        numeroFaturas = in.nextInt();
        for (int i = 0; i < numeroFaturas; i++) {// loop quantidade de faturas para pagar.

            do { // loop de erro.
                System.out.print("Insira o valor da fatura: ");
                valorFatura = in.nextInt();
                System.out.print("Agora insira a data do pagamento: ");
                diaFatura = in.nextInt();
                if (valorFatura < 1 || diaFatura < 1 || diaFatura > 31) {
                    System.out.println("INFORMAÇÕES INVÁLIDAS.Tente novamente.");
                } else {
                }
            } while (valorFatura < 1 || diaFatura < 1 || diaFatura > 31);

            // atraso do pagamento.
            if (diaFatura > vencimentoFatura) {
                atrasoPagamento = diaFatura - vencimentoFatura;
                somatorioAtraso+=atrasoPagamento;
                valorFinalFatura = valorFatura + ((2 * valorFatura / 100) + ((valorFatura / 100) * atrasoPagamento));
                // adiantamento do pagamento.
            } else if (diaFatura < vencimentoFatura) {
                valorFinalFatura = valorFatura - (5 * valorFatura / 100);
                // pagando na data.
            } else {
                valorFinalFatura = valorFatura;
            }
            System.out.println("Considerando a data em que você pagou,o valor da fatura ficou em R$"+valorFinalFatura);
        }
        System.out.println("Você atrasou suas contas em "+somatorioAtraso+" dias.");
        if(numeroFaturas>1000) {
            System.out.println("Meta ótima alcançada.");
        }else if(numeroFaturas>500 && numeroFaturas<=1000) {
            System.out.println("Meta intermediária alcançada.");
        }else if (numeroFaturas>100 && numeroFaturas<=500) {
            System.out.println("Abaixo da meta.");
        }else{
            System.out.println("Programa descontinuado.");
        }

    }
}
