/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tic.tac.toe;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

/**
 *
 * @author Lenovo
 */
public class InitializeDifficulity {

    private static Font font = new Font("Serif", Font.PLAIN, 40);

    private static void initButton(JButton button) {
        button.setOpaque(false);
        button.setFont(font);
        button.setForeground(Color.white);
        button.setBackground(new Color(0, 125, 125));

    }

    public static void init() {
        JFrame frame = new JFrame("Tic Tac Toe");
        JButton buttonEasy = new JButton("Easy");
        JButton buttonMedium = new JButton("Medium");
        JButton buttonHard = new JButton("Hard");
        JPanel panel = new JPanel(new GridLayout(2, 1));
        panel.setBackground(Color.decode("#43766C"));
        JLabel label = new JLabel("Set difficulty", 0);
        label.setFont(font);
        label.setForeground(Color.WHITE);
        JPanel buttonPanel = new JPanel(new GridLayout(3, 1));
        buttonPanel.setBackground(Color.decode("#76453B"));
        buttonPanel.setFont(font);
        
        initButton(buttonEasy);
        initButton(buttonMedium);
        initButton(buttonHard);
        
        buttonPanel.add(buttonEasy);
        buttonPanel.add(buttonMedium);
        buttonPanel.add(buttonHard);
        
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
        
        buttonEasy.addActionListener((e) -> {
            frame.setVisible(false);
            GUI Game = new GUI(GameCore.getInstance(new Easy(),new RandomPlayer()));
            Game.GameInitialize();

        });
        buttonMedium.addActionListener((e) -> {
            frame.setVisible(false);
            GUI Game = new GUI(GameCore.getInstance(new Medium(),new RandomPlayer()));
            Game.GameInitialize();

        });
        buttonHard.addActionListener((e) -> {
            frame.setVisible(false);
            GUI Game = new GUI(GameCore.getInstance(new Hard(),new RandomPlayer()));
            Game.GameInitialize();
        });

    }

}
