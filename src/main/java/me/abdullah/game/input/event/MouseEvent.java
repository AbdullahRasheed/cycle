package me.abdullah.game.input.event;

import me.abdullah.game.objects.RenderObject;
import me.abdullah.game.objects.view.UIView;

public class MouseEvent {

    private final RenderObject obj;
    private final UIView context;
    private final java.awt.event.MouseEvent event;

    public MouseEvent(RenderObject obj, UIView context, java.awt.event.MouseEvent event) {
        this.obj = obj;
        this.context = context;
        this.event = event;
    }

    public RenderObject getObject() {
        return obj;
    }

    public UIView getContext() {
        return context;
    }

    public java.awt.event.MouseEvent getEvent() {
        return event;
    }
}
