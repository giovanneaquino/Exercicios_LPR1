/*
9. Entrar com uma matriz de ordem MxN, onde a ordem também será escolhida pelo usuário,
sendo que no máximo 10x10. A matriz não precisa ser quadrática. Após a digitação dos
elementos, calcular e exibir a matriz transposta.

Alunos: 
- Giovanne Brandão de Aquino
- Ricardo Queiroz Oliani
*/


import java.util.Scanner;

public class TP02Ex09 {
    public static void main(String[] args) {
        // Scanner para entrada de dados pelo teclado
        Scanner scanner = new Scanner(System.in);

        // Solicitando a ordem da matriz
        System.out.print("Digite o numero de linhas da matriz (no maximo 10): ");
        int linhas = scanner.nextInt();
        System.out.print("Digite o numero de colunas da matriz (no maximo 10): ");
        int colunas = scanner.nextInt();

        // Verificando se a ordem e valida
        if (linhas <= 0 || linhas > 10 || colunas <= 0 || colunas > 10) {
            System.out.println("Ordem invalida. O numero de linhas e colunas deve estar entre 1 e 10.");
            return;
        }

        // Definindo uma matriz de ordem MxN para armazenar os valores
        int[][] matriz = new int[linhas][colunas];

        // Solicitando e armazenando os valores na matriz
        System.out.println("Digite os elementos da matriz:");

        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                System.out.print("Elemento [" + i + "][" + j + "]: ");
                matriz[i][j] = scanner.nextInt();
            }
        }

        // Exibindo a matriz original
        System.out.println("Matriz original:");
        imprimirMatriz(matriz);

        // Calculando e exibindo a matriz transposta
        System.out.println("Matriz transposta:");
        int[][] transposta = calcularTransposta(matriz);
        imprimirMatriz(transposta);

        // Fechando o scanner
        scanner.close();
    }

    // Funcao para calcular a matriz transposta
    public static int[][] calcularTransposta(int[][] matriz) {
        int linhas = matriz.length;
        int colunas = matriz[0].length;
        int[][] transposta = new int[colunas][linhas];

        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                transposta[j][i] = matriz[i][j];
            }
        }

        return transposta;
    }

    // Funcao para imprimir a matriz
    public static void imprimirMatriz(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
