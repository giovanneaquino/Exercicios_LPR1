/*
10. Entrar com uma matriz de ordem MxM, onde a ordem também será escolhida pelo usuário,
sendo que no máximo será de ordem 10 e quadrática. Após a digitação dos elementos,
calcular e exibir a matriz inversa. Exibir as matrizes na tela, sob a forma matricial (linhas x
colunas).

Alunos: 
- Giovanne Brandão de Aquino
- Ricardo Queiroz Oliani
*/


import java.util.Scanner;

public class TP02Ex10 {
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

        // Calculando e exibindo a matriz inversa
        double[][] inversa = calcularMatrizInversa(matriz);
        System.out.println("Matriz inversa:");
        imprimirMatriz(inversa);

        // Fechando o scanner
        scanner.close();
    }

    // Funcao para calcular a matriz inversa
    public static double[][] calcularMatrizInversa(double[][] matriz) {
        int ordem = matriz.length;
        double[][] identidade = new double[ordem][ordem];
        double[][] aumentada = new double[ordem][ordem * 2];

        // Inicializando a matriz identidade
        for (int i = 0; i < ordem; i++) {
            identidade[i][i] = 1;
        }

        // Criando a matriz aumentada (concatenando matriz original e identidade)
        for (int i = 0; i < ordem; i++) {
            for (int j = 0; j < ordem; j++) {
                aumentada[i][j] = matriz[i][j];
                aumentada[i][j + ordem] = identidade[i][j];
            }
        }

        // Aplicando o metodo de eliminacao de Gauss-Jordan
        for (int i = 0; i < ordem; i++) {
            // Dividindo a linha atual pelo pivot
            double pivot = aumentada[i][i];
            for (int j = 0; j < ordem * 2; j++) {
                aumentada[i][j] /= pivot;
            }
            // Eliminando os elementos abaixo do pivot
            for (int k = 0; k < ordem; k++) {
                if (k != i) {
                    double fator = aumentada[k][i];
                    for (int j = 0; j < ordem * 2; j++) {
                        aumentada[k][j] -= fator * aumentada[i][j];
                    }
                }
            }
        }

        // Obtendo a matriz inversa da parte da direita da matriz aumentada
        double[][] inversa = new double[ordem][ordem];
        for (int i = 0; i < ordem; i++) {
            for (int j = 0; j < ordem; j++) {
                inversa[i][j] = aumentada[i][j + ordem];
            }
        }

        return inversa;
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
