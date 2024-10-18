/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pertemuan3;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TicTacToe extends JFrame implements ActionListener {
    private JButton buttonA;
    private JButton buttonB;
    private JButton buttonC;
    private JButton buttonD;
    private JButton buttonE;
    private JButton buttonF;
    private JButton buttonG;
    private JButton buttonH;
    private JButton buttonI;

    private JButton[] buttons;
    private boolean gameOver;
    private boolean isPlayerOneTurn;

    public TicTacToe() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        gameOver = false;
        isPlayerOneTurn = true; // Giliran pemain pertama

        buttonA = new JButton("");
        buttonB = new JButton("");
        buttonC = new JButton("");
        buttonD = new JButton("");
        buttonE = new JButton("");
        buttonF = new JButton("");
        buttonG = new JButton("");
        buttonH = new JButton("");
        buttonI = new JButton("");
        buttons = new JButton[9];
        buttons[0] = buttonA;
        buttons[1] = buttonB;
        buttons[2] = buttonC;
        buttons[3] = buttonD;
        buttons[4] = buttonE;
        buttons[5] = buttonF;
        buttons[6] = buttonG;
        buttons[7] = buttonH;
        buttons[8] = buttonI;

        for (JButton button : buttons) {
            button.addActionListener(this);
        }

        this.setLayout(new GridLayout(3, 3));

        for (JButton button : buttons) {
            this.add(button);
        }

        this.setSize(300, 300);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!gameOver) {
            JButton button = (JButton) e.getSource();
            if (button.getText().isEmpty()) {
                button.setText(isPlayerOneTurn ? "O" : "X");
                checkWinner();
                isPlayerOneTurn = !isPlayerOneTurn; // Berganti giliran pemain
            }
        }
    }

    private void checkWinner() {
        String winner = "";
        if (!buttonA.getText().isEmpty() && buttonA.getText().equals(buttonB.getText()) && buttonA.getText().equals(buttonC.getText())) {
            winner = buttonA.getText();
            buttonA.setForeground(Color.RED);
            buttonB.setForeground(Color.RED);
            buttonC.setForeground(Color.RED);
        } else if (!buttonD.getText().isEmpty() && buttonD.getText().equals(buttonE.getText()) && buttonD.getText().equals(buttonF.getText())) {
            winner = buttonD.getText();
            buttonD.setForeground(Color.RED);
            buttonE.setForeground(Color.RED);
            buttonF.setForeground(Color.RED);
        } else if (!buttonG.getText().isEmpty() && buttonG.getText().equals(buttonH.getText()) && buttonG.getText().equals(buttonI.getText())) {
            winner = buttonG.getText();
            buttonG.setForeground(Color.RED);
            buttonH.setForeground(Color.RED);
            buttonI.setForeground(Color.RED);
        } else if (!buttonA.getText().isEmpty() && buttonA.getText().equals(buttonD.getText()) && buttonA.getText().equals(buttonG.getText())) {
            winner = buttonA.getText();
            buttonA.setForeground(Color.RED);
            buttonD.setForeground(Color.RED);
            buttonG.setForeground(Color.RED);
        } else if (!buttonB.getText().isEmpty() && buttonB.getText().equals(buttonE.getText()) && buttonB.getText().equals(buttonH.getText())) {
            winner = buttonB.getText();
            buttonB.setForeground(Color.RED);
            buttonE.setForeground(Color.RED);
            buttonH.setForeground(Color.RED);
        } else if (!buttonC.getText().isEmpty() && buttonC.getText().equals(buttonF.getText()) && buttonC.getText().equals(buttonI.getText())) {
            winner = buttonC.getText();
            buttonC.setForeground(Color.RED);
            buttonF.setForeground(Color.RED);
            buttonI.setForeground(Color.RED);
        } else if (!buttonA.getText().isEmpty() && buttonA.getText().equals(buttonE.getText()) && buttonA.getText().equals(buttonI.getText())) {
            winner = buttonA.getText();
            buttonA.setForeground(Color.RED);
            buttonE.setForeground(Color.RED);
            buttonI.setForeground(Color.RED);
        } else if (!buttonC.getText().isEmpty() && buttonC.getText().equals(buttonE.getText()) && buttonC.getText().equals(buttonG.getText())) {
            winner = buttonC.getText();
            buttonC.setForeground(Color.RED);
            buttonE.setForeground(Color.RED);
            buttonG.setForeground(Color.RED);
        }

        if (!winner.isEmpty()) {
            gameOver = true;
            JOptionPane.showMessageDialog(this, "Pemain " + winner + " menang!");
        } else {
            boolean allFilled = true;
            for (JButton btn : buttons) {
                if (btn.getText().isEmpty()) {
                    allFilled = false;
                    break;
                }
            }
            if (allFilled) {
                gameOver = true;
                JOptionPane.showMessageDialog(this, "Permainan berakhir seri!");
            }
        }
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                TicTacToe h = new TicTacToe ();
                h.setVisible(true);
            }
        });
    }
}