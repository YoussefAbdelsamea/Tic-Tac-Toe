/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tic.tac.toe;

import java.awt.Image;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.swing.ImageIcon;

/**
 *
 * @author a7med
 */
public class Flyweight {

    private Map<State, ImageIcon> img = new HashMap<>();

    private ImageIcon accessImg(String imgPath) {
        return new ImageIcon(imgPath);
    }

    public ImageIcon getImg(State character) {
        if (img.containsKey(character)) {
            return img.get(character);
        } else {
            switch(character){
                case X -> {
                    ImageIcon xImgIcon = accessImg("resources/XX.png");
                    img.put(character, xImgIcon);
                    return xImgIcon;
                }
                case O -> {
                    ImageIcon oImgIcon = accessImg("resources/OO.png");
                    img.put(character, oImgIcon);
                    return oImgIcon;
                }
                default -> {
                    System.out.println("Wrong image name");
                    return null;
                }
            }
        }
    }
}
