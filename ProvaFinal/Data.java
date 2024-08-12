//levei meio a serio a parte de manter a originalidade do codigo, então fiz os gets e sets e mantive a logica e maneira que o primeiro foi executado.
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Date;
import java.text.DateFormat;
import java.util.Calendar;

public class Data {
    private int dia;
    private int mes;
    private int ano;

    // Construtor padrão
    public Data() {
        Scanner scanner = new Scanner(System.in);
        this.ano = lerValor("Digite o ano:", 1, Integer.MAX_VALUE, scanner);
        this.mes = lerValor("Digite o mês (1-12):", 1, 12, scanner);
        this.dia = lerValor("Digite o dia (1-" + getDiasNoMes(this.mes, this.ano) + "):", 1, getDiasNoMes(this.mes, this.ano), scanner);
    }

    // Construtor com parâmetros
    public Data(int d, int m, int a) {
        this.dia = d;
        this.mes = m;
        this.ano = a;
    }

    // Métodos entraDia, entraMes e entraAno
    public void entraDia(int d) {
        if (d >= 1 && d <= getDiasNoMes(this.mes, this.ano)) {
            this.dia = d;
        } else {
            System.out.println("Dia inválido. Por favor, redigite.");
        }
    }

    public void entraMes(int m) {
        if (m >= 1 && m <= 12) {
            this.mes = m;
        } else {
            System.out.println("Mês inválido. Por favor, redigite.");
        }
    }

    public void entraAno(int a) {
        if (a > 0) {
            this.ano = a;
        } else {
            System.out.println("Ano inválido. Por favor, redigite.");
        }
    }

    public void entraDia() {
        Scanner scanner = new Scanner(System.in);
        this.dia = lerValor("Digite o dia (1-" + getDiasNoMes(this.mes, this.ano) + "):", 1, getDiasNoMes(this.mes, this.ano), scanner);
    }

    public void entraMes() {
        Scanner scanner = new Scanner(System.in);
        this.mes = lerValor("Digite o mês (1-12):", 1, 12, scanner);
    }

    public void entraAno() {
        Scanner scanner = new Scanner(System.in);
        this.ano = lerValor("Digite o ano:", 1, Integer.MAX_VALUE, scanner);
    }

    // Getters e Setters
    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        if (dia >= 1 && dia <= getDiasNoMes(this.mes, this.ano)) {
            this.dia = dia;
        }
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        if (mes >= 1 && mes <= 12) {
            this.mes = mes;
        }
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        if (ano > 0) {
            this.ano = ano;
        }
    }

    // Métodos retDia, retMes e retAno
    public int retDia() {
        return this.dia;
    }

    public int retMes() {
        return this.mes;
    }

    public int retAno() {
        return this.ano;
    }

    // Métodos de exibição
    public String mostra1() {
        return String.format("%02d/%02d/%04d", dia, mes, ano);
    }

    public String mostra2() {
        String[] meses = {"Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"};
        return String.format("%02d/%s/%04d", dia, meses[mes - 1], ano);
    }

    // Método para verificar se o ano é bissexto
    public boolean bissexto() {
        return (ano % 4 == 0 && (ano % 100 != 0 || ano % 400 == 0));
    }

    // Método para calcular os dias transcorridos no ano até a data
    public int diasTranscorridos() {
        int dias = dia;
        for (int i = 1; i < mes; i++) {
            dias += getDiasNoMes(i, ano);
        }
        return dias;
    }

    // Método para apresentar a data atual
    public void apresentaDataAtual() {
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.FULL);
        Date date = new Date();
        System.out.println("Data atual: " + dateFormat.format(date));
    }

    // Métodos auxiliares
    private int lerValor(String mensagem, int min, int max, Scanner scanner) {
        int valor;
        while (true) {
            try {
                System.out.println(mensagem);
                valor = scanner.nextInt();
                if (valor >= min && valor <= max) {
                    break;
                } else {
                    System.out.println("Valor fora do intervalo permitido. Por favor, redigite.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, digite um número inteiro.");
                scanner.next(); // Limpa a entrada inválida
            }
        }
        return valor;
    }

    private int getDiasNoMes(int mes, int ano) {
        switch (mes) {
            case 2:
                return (ano % 4 == 0 && (ano % 100 != 0 || ano % 400 == 0)) ? 29 : 28;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            default:
                return 31;
        }
    }

    // Método main para execução do programa
    public static void main(String[] args) {
        Data data = new Data();
        System.out.println("Data criada: " + data.mostra1());
        System.out.println("Data no formato por extenso: " + data.mostra2());
        System.out.println("Ano bissexto: " + data.bissexto());
        System.out.println("Dias transcorridos no ano: " + data.diasTranscorridos());
        data.apresentaDataAtual();
    }
}