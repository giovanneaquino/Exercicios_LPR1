import java.util.Scanner;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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

    private int lerValor(String mensagem, int min, int max, Scanner scanner) {
        int valor;
        do {
            System.out.println(mensagem);
            valor = scanner.nextInt();
        } while (valor < min || valor > max);
        return valor;
    }

    private int getDiasNoMes(int mes, int ano) {
        switch (mes) {
            case 2:
                return (ano % 4 == 0 && (ano % 100 != 0 || ano % 400 == 0)) ? 29 : 28;
            case 4: case 6: case 9: case 11:
                return 30;
            default:
                return 31;
        }
    }

    public void entraDia(int d) {
        if (d >= 1 && d <= getDiasNoMes(this.mes, this.ano)) {
            this.dia = d;
        }
    }

    public void entraMes(int m) {
        if (m >= 1 && m <= 12) {
            this.mes = m;
        }
    }

    public void entraAno(int a) {
        if (a > 0) {
            this.ano = a;
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

    public int retDia() {
        return this.dia;
    }

    public int retMes() {
        return this.mes;
    }

    public int retAno() {
        return this.ano;
    }

    public String mostra1() {
        return String.format("%02d/%02d/%04d", this.dia, this.mes, this.ano);
    }

    public String mostra2() {
        String[] meses = {"Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"};
        return String.format("%02d/%s/%04d", this.dia, meses[this.mes - 1], this.ano);
    }

    public boolean bissexto() {
        return (this.ano % 4 == 0 && (this.ano % 100 != 0 || this.ano % 400 == 0));
    }

    public int diasTranscorridos() {
        int[] diasNoMes = {31, (bissexto() ? 29 : 28), 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int dias = 0;
        for (int i = 0; i < this.mes - 1; i++) {
            dias += diasNoMes[i];
        }
        dias += this.dia;
        return dias;
    }

    public void apresentaDataAtual() {
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.FULL);
        Date date = new Date();
        System.out.println(dateFormat.format(date));
    }

    public static void main(String[] args) {
        Data data = new Data();
        data.apresentaDataAtual();
        System.out.println("Data formatada 1: " + data.mostra1());
        System.out.println("Data formatada 2: " + data.mostra2());
        System.out.println("Ano bissexto: " + data.bissexto());
        System.out.println("Dias transcorridos: " + data.diasTranscorridos());
    }
}