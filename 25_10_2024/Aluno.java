import java.util.UUID;

public class Aluno {
    private UUID id;
    private String nome;
    private String sobrenome;
    private int idade;

    public Aluno(String nome, String sobrenome, int idade) {
        this.id = UUID.randomUUID();
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.idade = idade;
    }

    public UUID getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public int getIdade() {
        return idade;
    }
}
