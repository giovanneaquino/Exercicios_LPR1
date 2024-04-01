/*
11. Entrar com uma matriz de ordem MxM, onde a ordem também será escolhida pelo usuário,
sendo que no máximo será de ordem 10 e quadrática. Após a digitação dos elementos,
calcular e exibir determinante da matriz.

Alunos: 
- Giovanne Brandão de Aquino
- Ricardo Queiroz Oliani
*/


import java.util.Scanner;

public class TP02Ex11 {
    public static void main(String[] args) {
        // Scanner para entrada de dados pelo teclado
        Scanner scanner = new Scanner(System.in);

        // Solicitando a ordem da matriz
        System.out.print("Digite a ordem da matriz (no maximo 10): ");
        int ordem = scanner.nextInt();

        // Verificando se a ordem e valida
        if (ordem <= 0 || ordem > 10) {
            System.out.println("Ordem invalida. A ordem deve estar entre 1 e 10.");
            return;
        }

        // Definindo uma matriz de ordem MxM para armazenar os valores
        double[][] matriz = new double[ordem][ordem];

        // Solicitando e armazenando os valores na matriz
        System.out.println("Digite os elementos da matriz:");

        for (int i = 0; i < ordem; i++) {
            for (int j = 0; j < ordem; j++) {
                System.out.print("Elemento [" + i + "][" + j + "]: ");
                matriz[i][j] = scanner.nextDouble();
            }
        }

        // Exibindo a matriz original
        System.out.println("Matriz original:");
        imprimirMatriz(matriz);

        // Calculando e exibindo o determinante da matriz
        double determinante = calcularDeterminante(matriz);
        System.out.println("Determinante da matriz: " + determinante);

        // Fechando o scanner
        scanner.close();
    }

    // Funcao para calcular o determinante da matriz
    public static double calcularDeterminante(double[][] matriz) {
        int ordem = matriz.length;
        if (ordem == 1) {
            return matriz[0][0];
        } else {
            double determinante = 0;
            for (int j = 0; j < ordem; j++) {
                double[][] submatriz = new double[ordem - 1][ordem - 1];
                for (int i = 1; i < ordem; i++) {
                    for (int k = 0; k < ordem; k++) {
                        if (k < j) {
                            submatriz[i - 1][k] = matriz[i][k];
                        } else if (k > j) {
                            submatriz[i - 1][k - 1] = matriz[i][k];
                        }
                    }
                }
                determinante += Math.pow(-1, j) * matriz[0][j] * calcularDeterminante(submatriz);
            }
            return determinante;
        }
    }

    // Funcao para imprimir a matriz
    public static void imprimirMatriz(double[][] matriz) {
        int linhas = matriz.length;
        int colunas = matriz[0].length;
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                System.out.print(matriz[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
