package me.abdullah.game.objects.ui.style;

import me.abdullah.game.util.Colors;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.font.TextAttribute;
import java.util.HashMap;
import java.util.Map;

public class BorderButton extends JButton {

    private Color defaultTextColor, clickTextColor;
    private Color textHover = Color.blue.brighter().brighter();

    public BorderButton(String text, Color color, int size) {
        super(text);

        defaultTextColor = color;
        clickTextColor = new Color(255 - color.getRed(), 255 - color.getGreen(), 255 - color.getBlue(), 255);

        setContentAreaFilled(false);
        setOpaque(false);
        setBackground(Colors.TRANSPARENT);
        setBorder(new CompoundBorder(new LineBorder(color), new EmptyBorder(size, size, size, size)));
        setFocusPainted(false);


        Map<TextAttribute, Object> attr = new HashMap<>();
        attr.put(TextAttribute.FAMILY, "Montserrat");
        attr.put(TextAttribute.WEIGHT, TextAttribute.WEIGHT_REGULAR);
        setFont(new Font(attr));

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                setOpaque(true);
                setBackground(color);
                setForeground(clickTextColor);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                setOpaque(false);
                setBackground(Colors.TRANSPARENT);
                setForeground(getModel().isRollover() ? textHover : defaultTextColor);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                if(getModel().isPressed()) return;
                setForeground(textHover);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if(getModel().isPressed()) return;
                setForeground(defaultTextColor);
            }
        });
    }
}
