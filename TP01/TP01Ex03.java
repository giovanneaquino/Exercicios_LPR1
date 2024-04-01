import java.util.Scanner;

public class TP01Ex03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o valor da diagonal do quadrado: ");
        double diagonal = scanner.nextDouble();

        double lado = Math.sqrt(Math.pow(diagonal, 2) / 2);
        double area = Math.pow(lado, 2);
        System.out.println("A area do quadrado e: " + area);
    }
}
