package me.abdullah.game.client;

import me.abdullah.game.Game;
import me.abdullah.game.objects.GameObject;
import me.abdullah.game.handlers.Handler;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class ClientPacketListener implements Consumer<Object> {

    private final Map<Class<?>, Consumer<Object>> handlers;

    public ClientPacketListener(){
        handlers = new HashMap<>();
    }

    @Override
    public void accept(Object o) {
        handlers.get(o.getClass()).accept(o);
    }
}
