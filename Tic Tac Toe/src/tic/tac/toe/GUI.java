package tic.tac.toe;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GUI implements Observer {

    private GameCore game;
    private State[][] BackendBoard = new State[3][3];
    private Flyweight flyweight = new Flyweight();

    private ImageIcon BImage = new ImageIcon("resources/grid.png");

    private JFrame frame = new JFrame("Tic Tac Toe");
    private JLabel label = new JLabel(BImage);
    private JPanel panel = new JPanel(null);

    private JButton[][] board = new JButton[3][3];

    private Dimension minimumSize = new Dimension(512, 550);

    public GUI(GameCore game) {
        this.game = game;
    }

    public void GameInitialize() {
        frame.setMinimumSize(minimumSize);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setResizable(false);
        frame.setVisible(true);

        label.setBounds(0, 0, 512, 512);

        panel.setBackground(Color.decode("#313866"));
        panel.setSize(minimumSize);
        panel.add(label);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                final int row = i;
                final int col = j;

                board[row][col] = new JButton();
                board[row][col].setBounds(30 + (row * 163), 30 + (col * 165), 120, 120);
                board[row][col].setBackground(Color.decode("#313866"));

                board[row][col].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        move(row, col);
                    }
                });

                panel.add(board[row][col]);
            }
        }

        frame.add(panel);

        BackendBoard = game.AIstarts();
        Display();

        game.attachObserver(this);
    }

    public void move(int row, int col) {
        game.Click(row, col);

        Display();
    }

    public void Display() {
        BackendBoard = game.getBoard();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (BackendBoard[i][j] == State.X) {
                    board[i][j].setIcon(flyweight.getImg(State.X));
                } else if (BackendBoard[i][j] == State.O) {
                    board[i][j].setIcon(flyweight.getImg(State.O));
                } else {
                    board[i][j].setIcon(null);
                }
            }
        }
    }

    @Override
    public void update(State win) {
        Display();
        if (win != State.empty) {
            JOptionPane.showMessageDialog(null, win + " won", "Game Over", JOptionPane.INFORMATION_MESSAGE);
        }

    }

}
