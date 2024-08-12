import java.util.InputMismatchException;
import java.util.Scanner;

class Data {
    private int dia, mes, ano;

    // Construtor padrão
    public Data() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("Digite a data da consulta no formato (dd mm aa):");
                this.dia = scanner.nextInt();
                this.mes = scanner.nextInt();
                this.ano = scanner.nextInt();
                if (isValidDate(dia, mes, ano)) {
                    break;
                } else {
                    System.out.println("Data inválida. Por favor, insira uma data válida no formato (dd mm aa).");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, insira números inteiros no formato (dd mm aa).");
                scanner.next(); // Limpa a entrada inválida
            }
        }
    }

    // Construtor com parâmetros
    public Data(int dia, int mes, int ano) {
        if (isValidDate(dia, mes, ano)) {
            this.dia = dia;
            this.mes = mes;
            this.ano = ano;
        } else {
            throw new IllegalArgumentException("Data inválida.");
        }
    }

    // Método para validar a data
    private boolean isValidDate(int dia, int mes, int ano) {
        if (mes < 1 || mes > 12) return false;
        if (dia < 1 || dia > 31) return false;
        if ((mes == 4 || mes == 6 || mes == 9 || mes == 11) && dia > 30) return false;
        if (mes == 2) {
            if (isLeapYear(ano)) {
                return dia <= 29;
            } else {
                return dia <= 28;
            }
        }
        return true;
    }

    // Método para verificar se é ano bissexto
    private boolean isLeapYear(int ano) {
        return (ano % 4 == 0 && ano % 100 != 0) || (ano % 400 == 0);
    }

    // Método para mostrar a data
    public String mostra1() {
        return String.format("%02d/%02d/%02d", dia, mes, ano);
    }
}

class Hora {
    private int hora, minuto, segundo;

    // Construtor padrão
    public Hora() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("Digite a hora da consulta no formato (hh:mm:ss):");
                String horaStr = scanner.nextLine();
                String[] horaParts = horaStr.split(":");
                this.hora = Integer.parseInt(horaParts[0]);
                this.minuto = Integer.parseInt(horaParts[1]);
                this.segundo = Integer.parseInt(horaParts[2]);
                if (isValidTime(hora, minuto, segundo)) {
                    break;
                } else {
                    System.out.println("Hora inválida. Por favor, insira uma hora válida no formato (hh:mm:ss).");
                }
            } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                System.out.println("Entrada inválida. Por favor, insira a hora no formato (hh:mm:ss).");
            }
        }
    }

    // Construtor com parâmetros
    public Hora(int hora, int minuto, int segundo) {
        if (isValidTime(hora, minuto, segundo)) {
            this.hora = hora;
            this.minuto = minuto;
            this.segundo = segundo;
        } else {
            throw new IllegalArgumentException("Hora inválida.");
        }
    }

    // Método para validar a hora
    private boolean isValidTime(int hora, int minuto, int segundo) {
        return (hora >= 0 && hora < 24) && (minuto >= 0 && minuto < 60) && (segundo >= 0 && segundo < 60);
    }

    // Método para mostrar a hora
    public String mostra1() {
        return String.format("%02d:%02d:%02d", hora, minuto, segundo);
    }
}

public class ConsultaAgendada {
    private Data data;
    private Hora hora;
    private String nomePaciente;
    private String nomeMedico;
    private static int quantidade = 0;

    // Construtor padrão
    public ConsultaAgendada() {
        Scanner scanner = new Scanner(System.in);
        this.data = new Data();
        this.hora = new Hora();
        System.out.println("Digite o nome do paciente:");
        this.nomePaciente = scanner.nextLine();
        System.out.println("Digite o nome do médico:");
        this.nomeMedico = scanner.nextLine();
        quantidade++;
    }

    // Construtor com parâmetros
    public ConsultaAgendada(int h, int mi, int s, int d, int m, int a, String p, String med) {
        this.data = new Data(d, m, a);
        this.hora = new Hora(h, mi, s);
        this.nomePaciente = p;
        this.nomeMedico = med;
        quantidade++;
    }

    // Construtor com objetos Data e Hora
    public ConsultaAgendada(Data d, Hora h, String p, String m) {
        this.data = d;
        this.hora = h;
        this.nomePaciente = p;
        this.nomeMedico = m;
        quantidade++;
    }

    // Métodos set
    public void setData(int d, int m, int a) {
        this.data = new Data(d, m, a);
    }

    public void setData() {
        this.data = new Data();
    }

    public void setHora(int h, int mi, int s) {
        this.hora = new Hora(h, mi, s);
    }

    public void setHora() {
        this.hora = new Hora();
    }

    public void setNomePaciente(String p) {
        this.nomePaciente = p;
    }

    public void setNomePaciente() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o nome do paciente:");
        this.nomePaciente = scanner.nextLine();
    }

    public void setNomeMedico(String m) {
        this.nomeMedico = m;
    }

    public void setNomeMedico() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o nome do médico:");
        this.nomeMedico = scanner.nextLine();
    }

    // Métodos get
    public int getAmostra() {
        return quantidade;
    }

    public String getData() {
        return data.mostra1();
    }

    public String getHora() {
        return hora.mostra1();
    }

    public String getNomePaciente() {
        return nomePaciente;
    }

    public String getNomeMedico() {
        return nomeMedico;
    }

    // Método main para testar a classe
    public static void main(String[] args) {
        // Instanciando o objeto p1 com o construtor que recebe parâmetros
        ConsultaAgendada p1 = new ConsultaAgendada(10, 30, 0, 15, 8, 2023, "João Silva", "Dr. Pedro");
        System.out.println("Propriedades de p1:");
        System.out.println("Data: " + p1.getData());
        System.out.println("Hora: " + p1.getHora());
        System.out.println("Nome do Paciente: " + p1.getNomePaciente());
        System.out.println("Nome do Médico: " + p1.getNomeMedico());

        // Instanciando o objeto p2 com o construtor padrão
        ConsultaAgendada p2 = new ConsultaAgendada();
        System.out.println("Propriedades de p2:");
        System.out.println("Data: " + p2.getData());
        System.out.println("Hora: " + p2.getHora());
        System.out.println("Nome do Paciente: " + p2.getNomePaciente());
        System.out.println("Nome do Médico: " + p2.getNomeMedico());

        // Alterando as propriedades de p1
        p1.setData(20, 9, 2023);
        p1.setHora(14, 45, 0);
        p1.setNomePaciente("Maria Oliveira");
        p1.setNomeMedico("Dr. Ana");

        // Exibindo as propriedades de p1 novamente
        System.out.println("Propriedades de p1 após alterações:");
        System.out.println("Data: " + p1.getData());
        System.out.println("Hora: " + p1.getHora());
        System.out.println("Nome do Paciente: " + p1.getNomePaciente());
        System.out.println("Nome do Médico: " + p1.getNomeMedico());

        // Exibindo a quantidade final de consultas
        System.out.println("Quantidade final de consultas: " + ConsultaAgendada.quantidade);
    }
}