package me.abdullah.game.server;

import me.abdullah.game.server.inputs.ServerActionHandler;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class PacketListener {

    private final ServerActionHandler actionHandler;

    private final Map<Class<?>, BiConsumer<Connection, Object>> handlers;

    public PacketListener(){
        this.actionHandler = new ServerActionHandler();

        this.handlers = new HashMap<>();

    }

    public void accept(Connection connection, Object o) {
        handlers.get(o.getClass()).accept(connection, o);
    }

}
