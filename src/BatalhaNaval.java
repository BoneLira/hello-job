package src;

/**
 * Cenário: A Steam está lhe contratando para desenvolver város jogos clássicos.
 * O primeiro jogo será a Batalha Naval. O jogo deve ser implementado da
 * seguinte forma:
 * 
 * 1-[] A. Faça uma função chamada verificaPosicao que recebe como parâmetro uma
 * matriz de números inteiros, e dois outros números inteiros, referentes à
 * posição que devem ser verificada. Caso as coordenadas passadas como parâmetro
 * sejam referentes às coordenadas de um barco na matriz, então a função deve
 * retornar verdadeiro. Caso contrário, deve retorna, falso.
 * 
 * 2-[] B. Faça uma função chamada contaBarcos, ela recebe como parâmetro a
 * matriz correspondente as posições do mapa. Essa função deve contar a
 * quantidade de barcos que ainda estão presentes na matriz e retornar esse
 * valor.
 * 
 * 3-[] C. Faça uma função chamada imprimeMapa, ela recebe como parâmetro a
 * matriz correspondente as posições do mapa. Ela não retorna nada, mas sim
 * apresentar na tela todas as posições que já foram atingidas, e as que ainda
 * estão disponíveis. A função NÃO deve diferenciar uma posição que tem um barco
 * ainda não atacado das outras. Ou seja, deve ser apresentado na tela o mesmo
 * símbolo para um barco ou água. Os símbolos ficam a critério do programador.
 * 
 * 4-[] D. Main, você deve inicialmente criar todas as variáveis necessárias e
 * uma matriz de números inteiros de 10x10, essa matriz representa o mapa. Em
 * seguida, você deve preenchê-la com as posições referentes aos barcos e as
 * posições vazias (água). Todos os barcos só ocupam um espaço, e a sua posição
 * é determinada pelo CPF do programador (ou seja, o seu que está respondendo à
 * prova). Por exemplo, considere o CPF 012.345.678-90. Os barcos ficaram nas
 * posições [0,1], [2, 3], [4, 5], [6, 7] e [8, 9]. O último número deve ser
 * ignorado, pois, o CPF tem uma quantidade Impar de números.Os barcos devem ser
 * representados com 1 e água como 0. Você NÃO deve perguntar ao usuário o CPF
 * dele, esse é o SEU CPF, logo essas posições são fixas para o programa sempre.
 * Caso seu CPF gere posições iguais, considere somente uma. O mapa deve começar
 * com esses valores predeterminados, ou seja, você NÃO deve pedir para o
 * usuário digitar os valores de cada posição.
 * 
 * 5-[] E. Uma vez que a tabela seja preenchida, o programa deve perguntar o
 * nome do jogador e GARANTIR que esse nome tenha ao menos 5 caracteres. Caso
 * não tenha, o programa deve apresentar uma mensagem de erro e pedir o nome
 * novamente.
 * 
 * 6-[] F. Em seguida o programa deve pedir as coordenadas do tiro do jogador e:
 * a. Verificar se acertou, usando o resultado da função verificaPosicao. Caso
 * tenha acertado, deve ser exibida a mensagem "Parabéns, você acertou um
 * barco", caso não deve exibir: "Água". b. A posição do tiro, deve ser
 * substituída pelo valor -1 (independente se era um barco ou água). c. Em
 * seguida, você deve apresentar o mapa usando a função imprimeMapa. d. E por
 * fim, você deve apresentar quantos barcos que ainda não foram afundados,
 * usando a função contaBarco. e. Esse processo deve se repetir até que todos os
 * barcos tenham sido afundados.
 * 
 * 7-[] G. Depois que todos os barcos sejam afundados, você deve apresentar uma
 * mensagem com o nome do jogador e quantidade de pontos que ele fez. A
 * quantidade de pontos é quantidade total de tiros que ele precisou para
 * afundar todos os barcos. IMPORTANTE! Escrevam um relatório explicando todos
 * os conceitos e as decisões que você tomou para escrever o seu programa. Esse
 * relatório deve vir separado do código.
 */
public class BatalhaNaval {
    public static boolean verificaPosicao(int[][] matriz, int posiX, int posiY) {
        boolean barco = false;
        if (matriz[posiX][posiY] == 1) {
            barco = true;
        }
        return barco;
    }

    public static void main(String[] args) {

    }

}
