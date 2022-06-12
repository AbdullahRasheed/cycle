package me.abdullah.game.handlers;

import me.abdullah.game.objects.view.GameView;
import me.abdullah.game.objects.view.UIView;

import java.awt.*;

public class ViewHandler {

    // TODO Make this a collection of IView's instead of just one gameview and one uiview

    private final GameView gameView;
    private final UIView uiView;
    public ViewHandler(GameView gameView, UIView uiView){
        this.gameView = gameView;
        this.uiView = uiView;
    }

    public void render(Graphics2D g){
        gameView.render(g);
        uiView.render(g);
    }

    public void tick() {
        gameView.tick();
        uiView.tick();
    }

    public GameView getGameView() {
        return gameView;
    }

    public UIView getUIView() {
        return uiView;
    }
}
