import java.util.Scanner;

public class TP01Ex07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o primeiro valor: ");
        double valor1 = scanner.nextDouble();

        System.out.print("Digite o segundo valor: ");
        double valor2 = scanner.nextDouble();

        double media = Math.sqrt(valor1 * valor2);
        System.out.println("A media geometrica e: " + media);
    }
}
