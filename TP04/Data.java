import java.text.DateFormat;
import java.util.Date;
import java.util.Scanner;

public class Data {
    private int dia;
    private int mes;
    private int ano;

    // Construtor padrão
    public Data() {
        Scanner scanner = new Scanner(System.in);
        this.dia = lerValor("Digite o dia (1-31):", 1, 31, scanner);
        this.mes = lerValor("Digite o mês (1-12):", 1, 12, scanner);
        this.ano = lerValor("Digite o ano:", 1, Integer.MAX_VALUE, scanner);
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

    public void entraDia(int d) { if (d >= 1 && d <= 31) this.dia = d; }
    public void entraMes(int m) { if (m >= 1 && m <= 12) this.mes = m; }
    public void entraAno(int a) { if (a > 0) this.ano = a; }

    public void entraDia() { this.dia = lerValor("Digite o dia (1-31):", 1, 31, new Scanner(System.in)); }
    public void entraMes() { this.mes = lerValor("Digite o mês (1-12):", 1, 12, new Scanner(System.in)); }
    public void entraAno() { this.ano = lerValor("Digite o ano:", 1, Integer.MAX_VALUE, new Scanner(System.in)); }

    public int retDia() { return this.dia; }
    public int retMes() { return this.mes; }
    public int retAno() { return this.ano; }

    public String mostra1() { return String.format("%02d/%02d/%04d", this.dia, this.mes, this.ano); }

    public String mostra2() {
        String[] meses = {"Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"};
        return String.format("%02d/%s/%04d", this.dia, meses[this.mes - 1], this.ano);
    }

    public boolean bissexto() {
        return (this.ano % 4 == 0 && this.ano % 100 != 0) || (this.ano % 400 == 0);
    }

    public int diasTranscorridos() {
        int[] diasPorMes = {31, (bissexto() ? 29 : 28), 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int dias = 0;
        for (int i = 0; i < this.mes - 1; i++) {
            dias += diasPorMes[i];
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
        Data data = new Data(); // Já solicita dia, mês e ano
        System.out.println("Data no formato dd/mm/aaaa: " + data.mostra1());
        System.out.println("Data no formato dd/mesPorExtenso/aaaa: " + data.mostra2());
        System.out.println("Ano bissexto: " + data.bissexto());
        System.out.println("Dias transcorridos no ano: " + data.diasTranscorridos());
        System.out.print("Data atual: ");
        data.apresentaDataAtual();
    }
}