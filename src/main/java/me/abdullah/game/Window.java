package me.abdullah.game;

import javax.swing.*;
import javax.swing.text.html.StyleSheet;
import java.awt.*;

public class Window extends Canvas {

    private JFrame frame;
    private GridBagLayout layout;
    int width, height;

    /**
     * Creates the window
     * @param width Width of the window
     * @param height Height of the window
     * @param title Title of the window
     * @param game Main class (Canvas)
     */
    public Window(int width, int height, String title, Game game){
        this.width = width;
        this.height = height;
        this.frame = new JFrame(title);

        frame.setPreferredSize(getDimension());
        frame.setMaximumSize(getDimension());
        frame.setMinimumSize(getDimension());

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setFocusable(true);
        frame.setLocationRelativeTo(null);
        //frame.setUndecorated(true);
        frame.setBackground(new Color(1.0f, 1.0f, 1.0f));
        frame.getContentPane().setBackground(new Color(1.0f, 1.0f, 1.0f));

        layout = new GridBagLayout();
        frame.setLayout(layout);

        frame.add(game);
        frame.setVisible(true);

        game.start();
    }

    public JFrame getFrame(){
        return frame;
    }

    public GridBagLayout getGridBag(){
        return layout;
    }

    private Dimension getDimension(){
        return new Dimension(width, height);
    }
}
