import java.util.Scanner;

public class Hora {
    private int hora;
    private int minutos;
    private int segundos;

    // Construtor padrão
    public Hora() {
        this.hora = 0;
        this.minutos = 0;
        this.segundos = 0;
    }

    // Construtor com parâmetros
    public Hora(int hora, int minutos, int segundos) {
        this.hora = hora;
        this.minutos = minutos;
        this.segundos = segundos;
    }

    public void setTime(int option, Scanner scanner) {
        switch (option) {
            case 1:
                do {
                    System.out.println("Digite a hora (0-23):");
                    this.hora = scanner.nextInt();
                } while (this.hora < 0 || this.hora > 23);
                System.out.println("Hora setada com sucesso!");
                break;
            case 2:
                do {
                    System.out.println("Digite os minutos (0-59):");
                    this.minutos = scanner.nextInt();
                } while (this.minutos < 0 || this.minutos > 59);
                System.out.println("Minuto setado com sucesso!");
                break;
            case 3:
                do {
                    System.out.println("Digite os segundos (0-59):");
                    this.segundos = scanner.nextInt();
                } while (this.segundos < 0 || this.segundos > 59);
                System.out.println("Segundo setado com sucesso!");
                break;
            default:
                System.out.println("Opção inválida.");
        }
    }

    public int getHora() {
        return this.hora;
    }

    public int getMin() {
        return this.minutos;
    }

    public int getSeg() {
        return this.segundos;
    }

    public String getHora1() {
        return String.format("%02d:%02d:%02d", this.hora, this.minutos, this.segundos);
    }

    public String getHora2() {
        int hour = this.hora;
        String ampm;
        if (hour >= 12) {
            ampm = "PM";
            if (hour > 12) {
                hour -= 12;
            }
        } else {
            ampm = "AM";
            if (hour == 0) {
                hour = 12;
            }
        }
        return String.format("%02d:%02d:%02d %s", hour, this.minutos, this.segundos, ampm);
    }

    public int getSegundos() {
        return this.hora * 3600 + this.minutos * 60 + this.segundos;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Hora hora = new Hora();

        while (true) {
            System.out.println("1. Seta hora");
            System.out.println("2. Seta minuto");
            System.out.println("3. Seta segundo");
            System.out.println("4. Pegar hora");
            System.out.println("5. Pegar minuto");
            System.out.println("6. Pegar segundo");
            System.out.println("7. Pegar hora no formato hh:mm:ss");
            System.out.println("8. Pegar hora no formato hh:mm:ss AM/PM");
            System.out.println("9. Pegar total de segundos");
            System.out.println("10. Sair");
            System.out.println("Escolha uma opção:");

            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                case 2:
                case 3:
                    System.out.println("------------------");
                    hora.setTime(opcao, scanner);
                    System.out.println("------------------");
                    break;
                case 4:
                    System.out.println("------------------");
                    System.out.println("Hora: " + hora.getHora());
                    System.out.println("------------------");
                    break;
                case 5:
                    System.out.println("------------------");
                    System.out.println("Minuto: " + hora.getMin());
                    System.out.println("------------------");
                    break;
                case 6:
                    System.out.println("------------------");
                    System.out.println("Segundo: " + hora.getSeg());
                    System.out.println("------------------");
                    break;
                case 7:
                    System.out.println("------------------");
                    System.out.println("Hora no formato hh:mm:ss: " + hora.getHora1());
                    System.out.println("------------------");
                    break;
                case 8:
                    System.out.println("------------------");
                    System.out.println("Hora no formato hh:mm:ss AM/PM: " + hora.getHora2());
                    System.out.println("------------------");
                    break;
                case 9:
                    System.out.println("------------------");
                    System.out.println("Total de segundos: " + hora.getSegundos());
                    System.out.println("------------------");
                    break;
                case 10:
                    System.out.println("Saindo...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}