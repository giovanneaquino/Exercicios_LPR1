import java.util.Scanner;

public class TP01Ex11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o diametro do circulo: ");
        double diametro = scanner.nextDouble();

        double raio = diametro / 2;
        double area = Math.PI * Math.pow(raio, 2);
        System.out.println("A area do circulo e: " + area);
    }
}
