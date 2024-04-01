/*
4. Armazenar seis valores em uma matriz de ordem 2x3. Apresentar os valores na tela.

Alunos: 
- Giovanne Brandão de Aquino
- Ricardo Queiroz Oliani
*/


import java.util.Scanner;

public class TP02Ex04 {
    public static void main(String[] args) {
        // Criando um objeto Scanner para entrada de dados do usuario
        Scanner scanner = new Scanner(System.in);
        
        // Criando a matriz de ordem 2x3
        int[][] matriz = new int[2][3];
        
        // Preenchendo a matriz com valores fornecidos pelo usuario
        System.out.println("Digite os valores para a matriz 2x3:");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("Digite o valor para a posicao [" + i + "][" + j + "]: ");
                matriz[i][j] = scanner.nextInt();
            }
        }
        
        // Exibindo os valores armazenados na matriz
        System.out.println("\nValores da matriz 2x3:");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println(); // Pula para a proxima linha apos cada linha da matriz
        }
        
        // Fechando o Scanner para evitar vazamento de recursos
        scanner.close();
    }
 }
