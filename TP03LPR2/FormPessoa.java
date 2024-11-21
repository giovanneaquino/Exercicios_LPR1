// Giovanne CB3026591 e Ricardo CB3025543

package TP03LPR2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormPessoa extends JFrame {
    private JTextField txtNumero, txtNome, txtSexo, txtIdade;
    private JButton btnOk, btnLimpar, btnMostrar, btnSair;
    private Pessoa umaPessoa;

    public FormPessoa() {
        setTitle("TP03 - Ex. 2 - Versão 1");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null); // Layout manual para obedecer ao design da imagem

        // Componentes do Formulário
        JLabel lblNumero = new JLabel("Numero:");
        lblNumero.setBounds(10, 10, 100, 25);
        txtNumero = new JTextField();
        txtNumero.setBounds(120, 10, 200, 25);
        txtNumero.setEditable(false); // Campo Número não editável

        JLabel lblNome = new JLabel("Nome:");
        lblNome.setBounds(10, 40, 100, 25);
        txtNome = new JTextField();
        txtNome.setBounds(120, 40, 200, 25);

        JLabel lblSexo = new JLabel("Sexo:");
        lblSexo.setBounds(10, 70, 100, 25);
        txtSexo = new JTextField();
        txtSexo.setBounds(120, 70, 200, 25);

        JLabel lblIdade = new JLabel("Idade:");
        lblIdade.setBounds(10, 100, 100, 25);
        txtIdade = new JTextField();
        txtIdade.setBounds(120, 100, 200, 25);

        btnOk = new JButton("OK");
        btnOk.setBounds(10, 140, 80, 30);

        btnLimpar = new JButton("Limpar");
        btnLimpar.setBounds(100, 140, 80, 30);

        btnMostrar = new JButton("Mostrar");
        btnMostrar.setBounds(190, 140, 80, 30);

        btnSair = new JButton("Sair");
        btnSair.setBounds(280, 140, 80, 30);

        // Adicionando componentes ao formulário
        add(lblNumero);
        add(txtNumero);
        add(lblNome);
        add(txtNome);
        add(lblSexo);
        add(txtSexo);
        add(lblIdade);
        add(txtIdade);
        add(btnOk);
        add(btnLimpar);
        add(btnMostrar);
        add(btnSair);

        // Eventos dos botões
        btnOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Validação dos campos obrigatórios
                    String nome = txtNome.getText().trim();
                    String sexoInput = txtSexo.getText().trim().toUpperCase();
                    String idadeInput = txtIdade.getText().trim();

                    if (nome.isEmpty() || sexoInput.isEmpty() || idadeInput.isEmpty()) {
                        throw new IllegalArgumentException("Todos os campos devem ser preenchidos!");
                    }

                    if (sexoInput.length() != 1 || (sexoInput.charAt(0) != 'M' && sexoInput.charAt(0) != 'F')) {
                        throw new IllegalArgumentException("O campo 'Sexo' deve ser preenchido com 'M' ou 'F'.");
                    }

                    // Verificar se o primeiro caractere do nome não é numérico
                    if (Character.isDigit(nome.charAt(0))) {
                        throw new IllegalArgumentException("O nome não pode começar com um número!");
                    }

                    char sexo = sexoInput.charAt(0);
                    int idade = Integer.parseInt(idadeInput);

                    // Criar a pessoa
                    umaPessoa = new Pessoa(nome, sexo, idade);
                    txtNumero.setText(String.valueOf(Pessoa.getKp()));
                    JOptionPane.showMessageDialog(null, "Dados registrados com sucesso!");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "O campo 'Idade' deve conter um valor numérico.");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Erro: " + ex.getMessage());
                } finally {
                    // Limpar apenas os campos preenchíveis
                    txtNome.requestFocus();
                }
            }
        });

        btnLimpar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtNumero.setText("");
                txtNome.setText("");
                txtSexo.setText("");
                txtIdade.setText("");
            }
        });

        btnMostrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (umaPessoa != null) {
                    JOptionPane.showMessageDialog(null,
                            "Número: " + Pessoa.getKp() + "\n" +
                                    "Nome: " + umaPessoa.getNome() + "\n" +
                                    "Sexo: " + umaPessoa.getSexo() + "\n" +
                                    "Idade: " + umaPessoa.getIdade());
                } else {
                    JOptionPane.showMessageDialog(null, "Nenhuma pessoa registrada.");
                }
            }
        });

        btnSair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new FormPessoa();
    }
}
