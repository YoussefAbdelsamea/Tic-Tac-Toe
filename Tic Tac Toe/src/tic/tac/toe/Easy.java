/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tic.tac.toe;

import java.awt.Dimension;

/**
 *
 * @author Lenovo
 */
public class Easy extends Player {
    
    @Override
    public Dimension AImove(State[][] board) {
        while (true) {
            if (board[randomHeight][randomWidth] == State.empty) {
                move.height = randomHeight;
                move.width = randomWidth;
                return move;
            } else {
                randomHeight = min + (int) (Math.random() * ((max - min) + 1));
                randomWidth = min + (int) (Math.random() * ((max - min) + 1));
            }
        }
    }

}
