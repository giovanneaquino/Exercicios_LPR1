import java.util.Scanner;

public class TP01Ex18 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o valor de cinco produtos: ");
        double valorTotal = 0;
        for (int i = 0; i < 5; i++) {
            System.out.print("Produto " + (i + 1) + ": ");
            valorTotal += scanner.nextDouble();
        }

        System.out.print("Digite o valor do pagamento: ");
        double valorPagamento = scanner.nextDouble();

        double troco = valorPagamento - valorTotal;
        System.out.printf("O troco a ser devolvido e: %.2f\n", troco);
    }
}
