
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class CadastroAlunos extends JFrame {
    private JTextField nomeField;
    private JTextField sobrenomeField;
    private JTextField idadeField;
    private List<Aluno> listaAlunos;

    public CadastroAlunos() {
        listaAlunos = new ArrayList<>();
        setTitle("Cadastro de Alunos");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        nomeField = new JTextField(15);
        sobrenomeField = new JTextField(15);
        idadeField = new JTextField(5);

        add(new JLabel("Nome:"));
        add(nomeField);
        add(new JLabel("Sobrenome:"));
        add(sobrenomeField);
        add(new JLabel("Idade:"));
        add(idadeField);

        JButton okButton = new JButton("Ok");
        okButton.addActionListener(e -> cadastrarAluno());
        add(okButton);

        JButton limparButton = new JButton("Limpar");
        limparButton.addActionListener(e -> limparCampos());
        add(limparButton);

        JButton mostrarButton = new JButton("Mostrar");
        mostrarButton.addActionListener(e -> mostrarAlunos());
        add(mostrarButton);

        JButton sairButton = new JButton("Sair");
        sairButton.addActionListener(e -> System.exit(0));
        add(sairButton);
    }

    private void cadastrarAluno() {
        try {
            String nome = nomeField.getText();
            String sobrenome = sobrenomeField.getText();
            int idade = Integer.parseInt(idadeField.getText());
            listaAlunos.add(new Aluno(nome, sobrenome, idade));
            limparCampos();
            JOptionPane.showMessageDialog(this, "Aluno cadastrado com sucesso!");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor, insira uma idade válida.");
        }
    }

    private void limparCampos() {
        nomeField.setText("");
        sobrenomeField.setText("");
        idadeField.setText("");
    }

    private void mostrarAlunos() {
        StringBuilder mensagem = new StringBuilder("Alunos Cadastrados:\n");
        for (Aluno aluno : listaAlunos) {
            mensagem.append("ID: ").append(aluno.getId())
                    .append(", Nome: ").append(aluno.getNome())
                    .append(" ").append(aluno.getSobrenome())
                    .append(", Idade: ").append(aluno.getIdade()).append("\n");
        }
        JOptionPane.showMessageDialog(this, mensagem.toString());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CadastroAlunos frame = new CadastroAlunos();
            frame.setVisible(true);
        });
    }
}
