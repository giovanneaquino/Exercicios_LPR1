/*
2. Entrar via teclado com dez valores positivos. Consistir a digitação e enviar mensagem de
erro, se necessário. Após a digitação, exibir:
a. O maior valor;
b. A soma dos valores;
c. A média aritmética dos valores.

Alunos: 
- Giovanne Brandão de Aquino
- Ricardo Queiroz Oliani
*/

import java.util.Scanner;

public class TP02Ex02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Array para armazenar os valores
        int[] valores = new int[10];

        // Variaveis para armazenar o maior valor, a soma e a media
        int maiorValor = Integer.MIN_VALUE;
        int soma = 0;
        double media = 0;

        // Solicitar os valores ao usuario
        for (int i = 0; i < 10; i++) {
            boolean entradaValida = false;
            do {
                System.out.print("Digite o " + (i + 1) + "o valor positivo: ");
                int valor = scanner.nextInt();
                if (valor > 0) {
                    valores[i] = valor;
                    entradaValida = true;
                } else {
                    System.out.println("Erro: Digite um valor positivo.");
                }
            } while (!entradaValida);

            // Atualizar o maior valor e a soma
            if (valores[i] > maiorValor) {
                maiorValor = valores[i];
            }
            soma += valores[i];
        }

        // Calcular a media
        media = (double) soma / 10;

        // Exibir os resultados
        System.out.println("O maior valor e: " + maiorValor);
        System.out.println("A soma dos valores e: " + soma);
        System.out.println("A media aritmetica dos valores e: " + media);

        scanner.close();
    }
}
