package src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class TP04 {
    private JFrame frame;
    private JTextField txtNome;
    private JLabel lblNome;
    private JLabel lblSalario;
    private JLabel lblCargo;
    private JTextField txtSalario;
    private JTextField txtCargo;
    private JTextField txtnomefind;
    private JButton btnPesquisar;
    private JButton btnAnterior;
    private JButton btnProximo;

    private Connection connection;
    private ResultSet resultSet;
    private int cod_funcAtual;  

    public TP04() {
        initialize();
        connectToDatabase();
    }

    private void initialize() {
        frame = new JFrame("TRABALHO PRATICO 04");
        frame.setSize(600, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(6, 2));

        frame.add(new JLabel("Nome Pesquisar:"));
        txtNome = new JTextField();
        frame.add(txtNome);

        btnPesquisar = new JButton("Pesquisar");
        frame.add(btnPesquisar);
        frame.add(new JLabel(""));

        lblNome = new JLabel("Nome:");
        frame.add(lblNome);
        txtnomefind = new JTextField();
        frame.add(txtnomefind);
        txtnomefind.setEditable(false);

        lblSalario = new JLabel("Salário:");
        frame.add(lblSalario);
        txtSalario = new JTextField();
        frame.add(txtSalario);
        txtSalario.setEditable(false);

        lblCargo = new JLabel("Cargo:");
        frame.add(lblCargo);
        txtCargo = new JTextField();
        txtCargo.setEditable(false);
        frame.add(txtCargo);

        btnAnterior = new JButton("Anterior");
        btnProximo = new JButton("Próximo");
        frame.add(btnAnterior);
        frame.add(btnProximo);

        btnPesquisar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchRecord(txtNome.getText());
            }
        });

        btnAnterior.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                navigateRecord(false);
            }
        });

        btnProximo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                navigateRecord(true);
            }
        });

        frame.setVisible(true);
    }

    private void connectToDatabase() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/aulajava", "root", "");
            System.out.println("Conexão bem-sucedida!");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(frame, "Erro ao conectar ao banco de dados!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void searchRecord(String nome) {
        try {
            String query = "SELECT f.cod_func, f.nom_func, f.sal_func, c.ds_cargo " +
                    "FROM tbfuncs f " +
                    "JOIN tbcargos c ON f.cod_cargo = c.cod_cargo " +
                    "WHERE f.nom_func LIKE ? LIMIT 1";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, "%" + nome + "%");
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                cod_funcAtual = resultSet.getInt("cod_func");  
                displayRecord();  
            } else {
                JOptionPane.showMessageDialog(frame, "Nenhum registro encontrado!", "Informação", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(frame, "Erro ao buscar o registro!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void navigateRecord(boolean next) {
        try {
           
            int novoCodFunc = next ? cod_funcAtual + 1 : cod_funcAtual - 1;

           
            String query = "SELECT f.cod_func, f.nom_func, f.sal_func, c.ds_cargo " +
                    "FROM tbfuncs f " +
                    "JOIN tbcargos c ON f.cod_cargo = c.cod_cargo " +
                    "WHERE f.cod_func = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, novoCodFunc);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                cod_funcAtual = novoCodFunc;  
                displayRecord();  
            } else {
                
                String direcao = next ? "próximos" : "anteriores";
                JOptionPane.showMessageDialog(frame, "Não há mais registros " + direcao + "!", "Informação", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(frame, "Erro ao navegar nos registros!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void displayRecord() {
        try {
            String nome = resultSet.getString("nom_func");
            String salario = resultSet.getString("sal_func");
            String cargo = resultSet.getString("ds_cargo");

            txtnomefind.setText(nome);
            txtSalario.setText(salario);
            txtCargo.setText(cargo);
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(frame, "Erro ao exibir o registro!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(TP04::new);
    }
}
