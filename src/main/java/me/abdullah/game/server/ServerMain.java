package me.abdullah.game.server;

import java.io.IOException;

public class ServerMain {

    public static void main(String[] args) throws IOException {

        Server server = new Server(ServerInfo.PORT);
        server.begin();

    }
}