package me.abdullah.game.objects;

import me.abdullah.game.handlers.IView;

import java.awt.*;
import java.util.function.BiConsumer;

public abstract class RenderObject implements IView {

    public abstract void render(Graphics2D g);

    public abstract void tick();

    public void animate(BiConsumer<Graphics2D, Long> animation, long millis, boolean repeat){
        // TODO
    }
}
