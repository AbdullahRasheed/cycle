package me.abdullah.game.handlers;

import javafx.util.Pair;
import me.abdullah.game.objects.GameObject;
import me.abdullah.game.objects.RenderObject;

import java.awt.*;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.function.BiConsumer;

public class Handler<T extends IView> {

    private final LinkedList<T> objects;

    public Handler(){
        objects = new LinkedList<>();
    }

    public void render(Graphics2D g){
        for (T object : objects) {
            object.render(g);
        }
    }

    public void tick(){
        for (T object : objects) {
            object.tick();
        }
    }

    public void addObject(T object){
        objects.add(object);
    }

    public void removeObject(T object){
        objects.remove(object);
    }

    public List<T> getObjects(){
        return objects;
    }
}
