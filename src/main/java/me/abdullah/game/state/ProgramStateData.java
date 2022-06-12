package me.abdullah.game.state;

import me.abdullah.game.handlers.ViewHandler;

public class ProgramStateData {

    private static ViewHandler viewHandler;

    public static void initialize(ViewHandler handler){
        viewHandler = handler;
    }

    public static ViewHandler getViewHandler(){
        return viewHandler;
    }
}
