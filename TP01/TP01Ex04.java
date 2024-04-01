import java.util.Scanner;

public class TP01Ex04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite a base do triangulo: ");
        double base = scanner.nextDouble();

        System.out.print("Digite a altura do triangulo: ");
        double altura = scanner.nextDouble();

        double area = (base * altura) / 2;
        System.out.println("A area do triangulo e: " + area);
    }
}
