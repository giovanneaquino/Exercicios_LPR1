/*
3. Entrar via teclado com “N” valores quaisquer. O valor “N” (que representa a quantidade de
números) será digitado, deverá ser positivo, porém menor que vinte. Caso a quantidade não
satisfaça a restrição, enviar mensagem de erro e solicitar o valor novamente. Após a
digitação dos “N” valores, exibir:
a. O maior valor;
b. O menor valor;
c. A soma dos valores;
d. A média aritmética dos valores;
e. A porcentagem de valores que são positivos;
f. A porcentagem de valores negativos;
Após exibir os dados, perguntar ao usuário de deseja ou não uma nova execução do
programa. Consistir a resposta no sentido de aceitar somente “S” ou “N” e encerrar o
programa em função dessa resposta.

Alunos: 
- Giovanne Brandão de Aquino
- Ricardo Queiroz Oliani
*/


import java.util.Scanner;

public class TP02Ex03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char continuar;
        do {
            // Entrada da quantidade de numeros
            int N;
            do {
                System.out.println("Digite a quantidade de numeros (positivo e menor que 20): ");
                N = scanner.nextInt();
                if (N <= 0 || N >= 20) {
                    System.out.println("Quantidade de numeros invalida. Digite novamente.");
                }
            } while (N <= 0 || N >= 20);

            // Entrada dos numeros e calculos
            int[] valores = new int[N];
            int soma = 0;
            int positivos = 0;
            int negativos = 0;

            System.out.println("Digite os " + N + " valores:");
            for (int i = 0; i < N; i++) {
                valores[i] = scanner.nextInt();
                soma += valores[i];
                if (valores[i] > 0) {
                    positivos++;
                } else if (valores[i] < 0) {
                    negativos++;
                }
            }

            // Encontrar maior e menor valor
            int maior = valores[0];
            int menor = valores[0];
            for (int i = 1; i < N; i++) {
                if (valores[i] > maior) {
                    maior = valores[i];
                }
                if (valores[i] < menor) {
                    menor = valores[i];
                }
            }

            // Exibir resultados
            System.out.println("Maior valor: " + maior);
            System.out.println("Menor valor: " + menor);
            System.out.println("Soma dos valores: " + soma);
            System.out.println("Media aritmetica dos valores: " + (double) soma / N);
            System.out.println("Porcentagem de valores positivos: " + (double) positivos / N * 100 + "%");
            System.out.println("Porcentagem de valores negativos: " + (double) negativos / N * 100 + "%");

            // Verificar se o usuario deseja continuar
            System.out.println("Deseja executar o programa novamente? (S/N)");
            continuar = scanner.next().charAt(0);
        } while (continuar == 'S' || continuar == 's');

        scanner.close();
    }
}
