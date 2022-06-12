package me.abdullah.game.objects.view;

import me.abdullah.game.Window;
import me.abdullah.game.handlers.Handler;
import me.abdullah.game.handlers.IView;
import me.abdullah.game.objects.RenderObject;
import me.abdullah.game.objects.UIObject;

import java.awt.*;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

public abstract class UIView implements IView {

    protected Handler<UIObject> handler;
    public UIView(){
        this.handler = new Handler<>();
    }

    @Override
    public void render(Graphics2D g) {
        handler.render(g);
    }

    @Override
    public void tick() {
        handler.tick();
    }

    public abstract void load(Window window);

    public void addObject(UIObject obj){
        handler.addObject(obj);
    }

    public void removeObject(UIObject obj){
        handler.removeObject(obj);
    }
}
