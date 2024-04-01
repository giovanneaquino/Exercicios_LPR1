/*
7. Entrar via teclado com doze valores e armazená-los em uma matriz de ordem 3x4. Após a
digitação dos valores solicitar uma constante multiplicativa, que deverá multiplicar cada
valor matriz e armazenar o resultado na própria matriz, nas posições correspondentes.

Alunos: 
- Giovanne Brandão de Aquino
- Ricardo Queiroz Oliani
*/


import java.util.Scanner;

public class TP02Ex07 {
    public static void main(String[] args) {
        // Definindo uma matriz de ordem 3x4 para armazenar os valores
        int[][] matriz = new int[3][4];

        // Scanner para entrada de dados pelo teclado
        Scanner scanner = new Scanner(System.in);

        // Solicitando e armazenando os valores na matriz
        System.out.println("Digite doze valores para preencher a matriz:");

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print("Valor para a posicao [" + i + "][" + j + "]: ");
                matriz[i][j] = scanner.nextInt();
            }
        }

        // Solicitando a constante multiplicativa
        System.out.print("Digite a constante multiplicativa: ");
        int constante = scanner.nextInt();

        // Multiplicando cada valor da matriz pela constante
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                matriz[i][j] *= constante;
            }
        }

        // Exibindo a matriz resultante
        System.out.println("Matriz resultante apos multiplicacao:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(matriz[i][j] + "\t");
            }
            System.out.println();
        }

        // Fechando o scanner
        scanner.close();
    }
}
