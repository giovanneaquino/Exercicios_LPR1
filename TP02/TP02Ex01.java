/*
 1. Entrar com dois valores via teclado, onde o segundo valor deverá ser maior que o primeiro.
Caso contrário solicitar novamente apenas o segundo valor.

Alunos: 
- Giovanne Brandão de Aquino
- Ricardo Queiroz Oliani
*/

import java.util.Scanner;

public class TP02Ex01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int primeiroValor, segundoValor;

        // Solicitar o primeiro valor
        System.out.print("Digite o primeiro valor: ");
        primeiroValor = scanner.nextInt();

        // Solicitar o segundo valor
        do {
            System.out.print("Digite o segundo valor (maior que o primeiro): ");
            segundoValor = scanner.nextInt();
        } while (segundoValor <= primeiroValor);

        // Exibir os valores
        System.out.println("Primeiro valor: " + primeiroValor);
        System.out.println("Segundo valor: " + segundoValor);

        scanner.close();
    }
}