// Giovanne CB3026591 e Ricardo CB3025543

package TP03LPR2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormPessoaV3 extends JFrame {
    private JTextField txtNumero, txtNome, txtIdade;
    private JRadioButton rbMasculino, rbFeminino;
    private ButtonGroup bgSexo;
    private JButton btnOk, btnLimpar, btnMostrar, btnSair;
    private Pessoa umaPessoa;

    public FormPessoaV3() {
        setTitle("TP03 - Ex.2 - Versão 3");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // Componentes do Formulário
        JLabel lblNumero = new JLabel("Numero:");
        lblNumero.setBounds(10, 10, 100, 25);
        txtNumero = new JTextField();
        txtNumero.setBounds(120, 10, 200, 25);
        txtNumero.setEditable(false);

        JLabel lblNome = new JLabel("Nome:");
        lblNome.setBounds(10, 40, 100, 25);
        txtNome = new JTextField();
        txtNome.setBounds(120, 40, 200, 25);

        JLabel lblSexo = new JLabel("Sexo:");
        lblSexo.setBounds(10, 70, 100, 25);
        
        rbMasculino = new JRadioButton("Masculino");
        rbMasculino.setBounds(120, 70, 100, 25);
        
        rbFeminino = new JRadioButton("Feminino");
        rbFeminino.setBounds(220, 70, 100, 25);
        
        // Agrupar os botões de rádio
        bgSexo = new ButtonGroup();
        bgSexo.add(rbMasculino);
        bgSexo.add(rbFeminino);

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
        add(rbMasculino);
        add(rbFeminino);
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
                    String idadeInput = txtIdade.getText().trim();
                    char sexo;

                    if (nome.isEmpty() || idadeInput.isEmpty() || (!rbMasculino.isSelected() && !rbFeminino.isSelected())) {
                        throw new IllegalArgumentException("Todos os campos devem ser preenchidos!");
                    }

                    // Verificar se o primeiro caractere do nome não é numérico
                    if (Character.isDigit(nome.charAt(0))) {
                        throw new IllegalArgumentException("O nome não pode começar com um número!");
                    }

                    // Determinar o sexo
                    if (rbMasculino.isSelected()) {
                        sexo = 'M';
                    } else {
                        sexo = 'F';
                    }

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
                    txtNome.requestFocus();
                }
            }
        });

        btnLimpar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtNumero.setText("");
                txtNome.setText("");
                bgSexo.clearSelection();
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
        new FormPessoaV3();
    }
}
