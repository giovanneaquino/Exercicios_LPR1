/*
6. Armazenar seis nomes em uma matriz de ordem 2x3. Apresentar os nomes na tela.

Alunos: 
- Giovanne Brandão de Aquino
- Ricardo Queiroz Oliani
*/


import java.util.Scanner;

public class TP02Ex06 {
    public static void main(String[] args) {
        // Criacao de um objeto Scanner para entrada de dados do usuario
        Scanner scanner = new Scanner(System.in);
        
        // Declaracao e inicializacao da matriz de ordem 2x3 para armazenar os nomes
        String[][] nomes = new String[2][3];
        
        // Preenchimento da matriz com os nomes fornecidos pelo usuario
        System.out.println("Digite os seis nomes para a matriz 2x3:");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("Digite o nome para a posicao [" + i + "][" + j + "]: ");
                nomes[i][j] = scanner.nextLine();
            }
        }
        
        // Exibicao dos nomes armazenados na matriz
        System.out.println("\nNomes armazenados na matriz 2x3:");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(nomes[i][j] + " ");
            }
            System.out.println(); // Pula para a proxima linha apos cada linha da matriz
        }
        
        // Fechamento do Scanner para evitar vazamento de recursos
        scanner.close();
    }
}
