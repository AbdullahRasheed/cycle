package me.abdullah.game.objects.view;

import me.abdullah.game.handlers.Handler;
import me.abdullah.game.handlers.IView;
import me.abdullah.game.objects.GameObject;
import me.abdullah.game.objects.RenderObject;

import java.awt.*;

public class GameView extends RenderObject {

    protected Handler<GameObject> handler;
    public GameView(){
        this.handler = new Handler<>();
    }

    @Override
    public void render(Graphics2D g) {
        handler.render(g);
    }

    @Override
    public void tick(){
        handler.tick();
    }
}
