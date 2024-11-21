package TP03LPR2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculadora extends JFrame {
    private JTextField display;
    private double result;
    private String operator;
    private boolean startNewNumber;

    public Calculadora() {
        // Configurar o frame principal
        setTitle("Calculadora");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 400);
        setLayout(new BorderLayout());

        // Campo de texto para exibir o resultado
        display = new JTextField("0");
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setFont(new Font("Arial", Font.BOLD, 24));
        display.setEditable(false);
        add(display, BorderLayout.NORTH);

        // Painel de botões
        JPanel panelButtons = new JPanel();
        panelButtons.setLayout(new GridLayout(4, 4));

        // Botões da calculadora
        String[] buttons = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", ".", "=", "+"
        };

        for (String text : buttons) {
            JButton button = new JButton(text);
            button.setFont(new Font("Arial", Font.BOLD, 24));
            button.addActionListener(new ButtonClickListener());
            panelButtons.add(button);
        }

        add(panelButtons, BorderLayout.CENTER);

        // Inicializar variáveis
        result = 0;
        operator = "=";
        startNewNumber = true;
    }

    private class ButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();

            if ("0123456789.".contains(command)) {
                if (startNewNumber) {
                    display.setText(command);
                    startNewNumber = false;
                } else {
                    display.setText(display.getText() + command);
                }
            } else {
                if (startNewNumber) {
                    if (command.equals("-")) {
                        display.setText(command);
                        startNewNumber = false;
                    } else {
                        operator = command;
                    }
                } else {
                    double x = Double.parseDouble(display.getText());
                    calculate(x);
                    operator = command;
                    startNewNumber = true;
                }
            }
        }

        private void calculate(double n) {
            switch (operator) {
                case "+":
                    result += n;
                    break;
                case "-":
                    result -= n;
                    break;
                case "*":
                    result *= n;
                    break;
                case "/":
                    result /= n;
                    break;
                case "=":
                    result = n;
                    break;
            }
            display.setText("" + result);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Calculadora frame = new Calculadora();
            frame.setVisible(true);
        });
    }
}