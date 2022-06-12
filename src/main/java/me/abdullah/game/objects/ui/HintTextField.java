package me.abdullah.game.objects.ui;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class HintTextField extends JTextField implements FocusListener {

    private String hint;
    private boolean showingHint;
    private Color foreground, hintForeground;
    public HintTextField(String hint, int col){
        super(col);
        this.hint = hint;
        this.showingHint = true;
        this.foreground = getForeground();
        this.hintForeground = foreground.brighter();

        setText(hint);
        setForeground(hintForeground);

        addFocusListener(this);
    }

    @Override
    public void focusGained(FocusEvent e) {
        if(showingHint){
            setText("");
            setForeground(foreground);
            showingHint = false;
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        if(getText().isEmpty()){
            setText(hint);
            setForeground(Color.gray);
            showingHint = true;
        }
    }

    @Override
    public String getText() {
        return showingHint ? "" : super.getText();
    }

    @Override
    public String getText(int offs, int len) throws BadLocationException {
        return showingHint ? "" : super.getText(offs, len);
    }
}
