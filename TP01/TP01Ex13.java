import java.util.Scanner;

public class TP01Ex13 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite a velocidade inicial do automovel (em m/s): ");
        double velocidadeInicial = scanner.nextDouble();

        System.out.print("Digite a aceleracao do automovel (em m/s²): ");
        double aceleracao = scanner.nextDouble();

        System.out.print("Digite o tempo de percurso (em segundos): ");
        double tempo = scanner.nextDouble();

        double velocidadeFinal = velocidadeInicial + (aceleracao * tempo);
        System.out.println("A velocidade final do automovel e: " + velocidadeFinal + " m/s");
    }
}
