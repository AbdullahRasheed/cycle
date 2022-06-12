package me.abdullah.game.input.event;

import me.abdullah.game.objects.view.UIView;

public class KeyEvent {

    private final UIView view;
    private final java.awt.event.KeyEvent event;
    public KeyEvent(UIView view, java.awt.event.KeyEvent event) {
        this.view = view;
        this.event = event;
    }

    public UIView getView() {
        return view;
    }

    public java.awt.event.KeyEvent getEvent() {
        return event;
    }
}
