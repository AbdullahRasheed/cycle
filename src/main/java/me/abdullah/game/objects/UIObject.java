package me.abdullah.game.objects;

import me.abdullah.game.input.event.KeyEvent;
import me.abdullah.game.input.event.MouseEvent;

import java.awt.*;
import java.util.function.Consumer;

public abstract class UIObject extends RenderObject {

    private Consumer<MouseEvent> onClick;
    private Consumer<KeyEvent> onKeyPress;

    public abstract Shape getBounds();

    public void setOnClick(Consumer<MouseEvent> onClick){
        this.onClick = onClick;
    }

    public void setOnKeyPress(Consumer<KeyEvent> onKeyPress){
        this.onKeyPress = onKeyPress;
    }

    public Consumer<MouseEvent> getOnClick(){
        return onClick;
    }

    public Consumer<KeyEvent> getOnKeyPress() {
        return onKeyPress;
    }
}
