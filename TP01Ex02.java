import java.util.Scanner;

public class TP01Ex02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o valor da aresta do quadrado: ");
        double aresta = scanner.nextDouble();

        double area = aresta * aresta;
        System.out.println("A area do quadrado e: " + area);
    }
}
