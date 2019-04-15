package RunTimeTerror;


import RunTimeTerror.Entities.KeyInput;

import javax.swing.*;
import java.awt.*;


public class Display extends Canvas {

    public static final long serialVersionUID = 2084050635770171081L;

    public Display(int width, int height, String title, Game game){
        JFrame frame = new JFrame(title);
        frame.setPreferredSize(new Dimension(width, height));
        frame.setMaximumSize(new Dimension(width, height));
        frame.setMinimumSize(new Dimension(width, height));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.add(game);
        frame.setVisible(true);

        game.start();
    }//constructor

}//class
