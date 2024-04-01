import java.util.Scanner;

public class TP01Ex09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite a resistencia (em ohms): ");
        double resistencia = scanner.nextDouble();

        System.out.print("Digite a corrente eletrica (em amperes): ");
        double corrente = scanner.nextDouble();

        double tensao = resistencia * corrente;
        System.out.println("A tensao do circuito eletronico e: " + tensao + " volts");
    }
}
