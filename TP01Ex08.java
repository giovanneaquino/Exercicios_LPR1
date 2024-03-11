import java.util.Scanner;

public class TP01Ex08{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite a quantidade de milhas maritimas: ");
        double milhasMaritimas = scanner.nextDouble();

        double quilometros = milhasMaritimas * 1.852;
        System.out.println("O valor em quilometros e: " + quilometros);
    }
}
