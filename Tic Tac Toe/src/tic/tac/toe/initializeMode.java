/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tic.tac.toe;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Lenovo
 */
public class initializeMode {

    private static Font font = new Font("Serif", Font.PLAIN, 40);

    private static void initButton(JButton button) {
        button.setOpaque(false);
        button.setFont(font);
        button.setForeground(Color.white);
        button.setBackground(new Color(0, 125, 125));

    }

    private static void init(JButton buttonOnePlayer, JButton buttonTwoPlayer, JFrame frame) {
        JPanel panel = new JPanel(new GridLayout(2, 1));
        panel.setBackground(Color.decode("#43766C"));
        JLabel label = new JLabel("Set Game Mode", 0);
        label.setFont(font);
        label.setForeground(Color.WHITE);
        JPanel buttonPanel = new JPanel(new GridLayout(2, 1));
        buttonPanel.setBackground(Color.decode("#76453B"));
        buttonPanel.setFont(font);

        initButton(buttonOnePlayer);
        initButton(buttonTwoPlayer);

        buttonPanel.add(buttonOnePlayer);
        buttonPanel.add(buttonTwoPlayer);

        panel.add(label);
        panel.add(buttonPanel);

        frame.add(panel);
        Dimension minimumSize = new Dimension(800, 600);
        frame.setMinimumSize(minimumSize);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setResizable(false);
        frame.setVisible(true);

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Tic Tac Toe");
        JButton buttonOnePlayer = new JButton("Single Player");
        JButton buttonTwoPlayer = new JButton("Two players");
        init(buttonOnePlayer, buttonTwoPlayer, frame);
        buttonOnePlayer.addActionListener((e) -> {
            InitializeDifficulity.init();
            frame.setVisible(false);
        });
        buttonTwoPlayer.addActionListener((e) -> {
            frame.setVisible(false);
            GUI Game = new GUI(GameCore.getInstance(new RandomPlayer(), new RandomPlayer()));
            Game.GameInitialize();
        });
    }
}
