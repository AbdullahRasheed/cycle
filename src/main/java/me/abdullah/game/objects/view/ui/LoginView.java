package me.abdullah.game.objects.view.ui;

import me.abdullah.game.Game;
import me.abdullah.game.Window;
import me.abdullah.game.objects.ui.HintTextField;
import me.abdullah.game.objects.ui.style.BorderButton;
import me.abdullah.game.objects.ui.style.SlateHintTextField;
import me.abdullah.game.objects.view.UIView;

import javax.swing.*;
import java.awt.*;

public class LoginView extends UIView {

    private JTextField usernameField;
    private JTextField passwordField;

    private JButton login;
    private JButton forgotPassword;
    private JButton createAccount;

    public LoginView(){
        usernameField = new SlateHintTextField("Username", 16);
        passwordField = new SlateHintTextField("Password", 16);

        login = new BorderButton("Login", Color.black, 8);
        forgotPassword = new BorderButton("Forgot Password?", Color.black, 8);
        createAccount = new BorderButton("Create Account", Color.black, 8);
    }

    @Override
    public void load(Window window){
        JFrame frame = window.getFrame();
        GridBagConstraints constraints = new GridBagConstraints();

        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets.set(10, 10, 10, 10);

        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        frame.add(usernameField, constraints);

        constraints.gridy = 1;
        frame.add(passwordField, constraints);

        constraints.gridy = 2;
        constraints.gridwidth = 1;
        frame.add(login, constraints);

        constraints.gridx = 1;
        frame.add(forgotPassword, constraints);

        constraints.gridy = 3;
        constraints.gridx = 0;
        constraints.weightx = 0;
        constraints.gridwidth = 2;
        frame.add(createAccount, constraints);
    }
}
