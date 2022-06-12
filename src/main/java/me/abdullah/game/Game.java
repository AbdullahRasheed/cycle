package me.abdullah.game;

import me.abdullah.game.client.GameClient;
import me.abdullah.game.files.Fonts;
import me.abdullah.game.files.GameFiles;
import me.abdullah.game.files.ImageLoader;
import me.abdullah.game.handlers.ViewHandler;
import me.abdullah.game.input.Keybinds;
import me.abdullah.game.objects.view.GameView;
import me.abdullah.game.objects.view.ui.LoginView;
import me.abdullah.game.server.ServerInfo;
import me.abdullah.game.state.ProgramStateData;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.io.File;
import java.io.IOException;

public class Game extends Canvas implements Runnable {

    public static final int WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width,
                                HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height;

    public static final double UNIT = (WIDTH*HEIGHT)/(1920.0 * 1080.0);

    private boolean running = false;

    private Thread thread;
    private final ViewHandler handler;

    private final Window window;

    private Keybinds playerKeybinds;

    public static GameClient client;

    public Game() throws IOException, FontFormatException {
        ClassLoader loader = getClass().getClassLoader();

        Fonts.loadFonts();

        ImageLoader.loadAssets("graphics");

        this.handler = new ViewHandler(new GameView(), new LoginView());
        ProgramStateData.initialize(handler);

        this.window = new Window(WIDTH, HEIGHT, "Cycle", this);

        //GameFiles.load(new File(loader.getResource("player_keybinds.txt").getPath()), "player_keybinds");
        GameFiles.load(new File(loader.getResource("server_info.txt").getPath()), "server_info");

        GameFiles.processLines("server_info", s -> ServerInfo.INET_ADDRESS = s);

//        this.playerKeybinds = Keybinds.load(PlayerAction.class, "player_keybinds");

        //this.addKeyListener(new KeyboardListener(playerKeybinds, new ActionHandler()));

        handler.getUIView().load(window);
    }

    public synchronized void start(){
        thread = new Thread(this);
        thread.start();
        running = true;
    }

    public synchronized void stop(){
        try{
            thread.join();
            running = false;
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    /**
     * Thread loop
     */
    @Override
    public void run() {
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while(running){
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while (delta >= 1){
                tick();
                delta--;
            }
            if(running) render();
            frames++;

            if(System.currentTimeMillis() - timer > 1000){
                timer += 1000;
                System.out.println("FPS: " + frames);
                frames = 0;
            }
        }
        stop();
    }

    /**
     * Top level graphics
     */
    private void render(){
        BufferStrategy bs = this.getBufferStrategy();
        if(bs == null){
            this.createBufferStrategy(3);
            return;
        }

        Graphics2D g = (Graphics2D) bs.getDrawGraphics();
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        g.setColor(Color.white);
        g.fillRect(0, 0, WIDTH, HEIGHT);

        //window.getFrame().paintComponents(g);
        handler.render(g);

        g.dispose();
        bs.show();
    }

    private void tick(){
        handler.tick();
    }

    public static void main(String[] args) throws IOException, FontFormatException {
        new Game();
    }
}
