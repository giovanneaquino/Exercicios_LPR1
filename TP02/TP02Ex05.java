/*
5. Armazenar seis valores em uma matriz de ordem 3x2. Apresentar os valores na tela.

Alunos: 
- Giovanne Brandão de Aquino
- Ricardo Queiroz Oliani
*/


import java.util.Scanner;

public class TP02Ex05 {
    public static void main(String[] args) {
        // Criacao de um objeto Scanner para entrada de dados do usuario
        Scanner scanner = new Scanner(System.in);
        
        // Declaracao e inicializacao da matriz de ordem 3x2
        int[][] matriz = new int[3][2];
        
        // Preenchimento da matriz com valores fornecidos pelo usuario
        System.out.println("Digite os valores para a matriz 3x2:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print("Digite o valor para a posicao [" + i + "][" + j + "]: ");
                matriz[i][j] = scanner.nextInt();
            }
        }
        
        // Exibicao dos valores armazenados na matriz
        System.out.println("\nValores da matriz 3x2:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println(); // Pula para a proxima linha apos cada linha da matriz
        }
        
        // Fechamento do Scanner para evitar vazamento de recursos
        scanner.close();
    }
}
