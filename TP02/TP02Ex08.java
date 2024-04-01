/*
8. Entrar via teclado com doze valores e armazená-los em uma matriz de ordem 3x4. Após a
digitação dos valores solicitar uma constante multiplicativa, que deverá multiplicar cada
valor matriz e armazenar o resultado em outra matriz de mesma ordem, nas posições
correspondentes. Exibir as matrizes na tela, sob a forma matricial, ou seja, linhas por
colunas.

Alunos: 
- Giovanne Brandão de Aquino
- Ricardo Queiroz Oliani
*/


import java.util.Scanner;

public class TP02Ex08{
    public static void main(String[] args) {
        // Definindo uma matriz de ordem 3x4 para armazenar os valores
        int[][] matrizOriginal = new int[3][4];
        int[][] matrizResultado = new int[3][4];

        // Scanner para entrada de dados pelo teclado
        Scanner scanner = new Scanner(System.in);

        // Solicitando e armazenando os valores na matriz original
        System.out.println("Digite doze valores para preencher a matriz:");

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print("Valor para a posicao [" + i + "][" + j + "]: ");
                matrizOriginal[i][j] = scanner.nextInt();
            }
        }

        // Solicitando a constante multiplicativa
        System.out.print("Digite a constante multiplicativa: ");
        int constante = scanner.nextInt();

        // Multiplicando cada valor da matriz original pela constante e armazenando na matriz resultado
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                matrizResultado[i][j] = matrizOriginal[i][j] * constante;
            }
        }

        // Exibindo a matriz original
        System.out.println("Matriz original:");
        imprimirMatriz(matrizOriginal);

        // Exibindo a matriz resultado
        System.out.println("Matriz resultado:");
        imprimirMatriz(matrizResultado);

        // Fechando o scanner
        scanner.close();
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
