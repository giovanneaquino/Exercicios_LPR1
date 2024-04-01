import java.util.Scanner;

public class TP01Ex15 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite a cotacao do dolar: ");
        double cotacaoDolar = scanner.nextDouble();

        System.out.print("Digite a quantidade de dolares: ");
        double quantidadeDolares = scanner.nextDouble();

        double valorEmReais = cotacaoDolar * quantidadeDolares;
        System.out.printf("O valor correspondente em reais e: R$ %.2f\n", valorEmReais);
    }
}
