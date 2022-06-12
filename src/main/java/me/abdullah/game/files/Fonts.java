package me.abdullah.game.files;

import java.awt.*;
import java.io.*;

public class Fonts {

    public static Font MONTSERRAT;

    public static void loadFonts() throws IOException, FontFormatException {
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();

        File fonts = new File(Fonts.class.getClassLoader().getResource("assets/font").getPath());
        if(!fonts.isDirectory()) return;

        for (File file : fonts.listFiles()) {
            InputStream in = new BufferedInputStream(new FileInputStream(file));
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, in));
        }

        MONTSERRAT = new Font("Montserrat", Font.PLAIN, 24);
    }
}
