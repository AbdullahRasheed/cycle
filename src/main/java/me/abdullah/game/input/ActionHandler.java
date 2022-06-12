package me.abdullah.game.input;

import me.abdullah.game.Game;
import me.abdullah.game.input.actions.PlayerAction;

import java.util.HashSet;
import java.util.Set;

public class ActionHandler {

    private final Set<Action> pressed;

    public ActionHandler(){
        this.pressed = new HashSet<>();
    }

    public void keyPressed(Action action){
        if(pressed.contains(action)) return;

        action.act();

        pressed.add(action);
    }

    public void keyReleased(Action action){
        action.release();

        pressed.remove(action);
    }
}
