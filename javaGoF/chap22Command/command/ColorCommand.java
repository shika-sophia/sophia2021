package javaGoF.chap22Command.command;

import java.awt.Color;

import javaGoF.chap22Command.drawer.IDrawable;

public class ColorCommand implements ICommand {
    private Color color;
    private IDrawable drawable;

    public ColorCommand(Color color, IDrawable drawable) {
        this.color = color;
        this.drawable = drawable;
    }

    @Override
    public void execute() {
        drawable.setColor(color);
    }//execute()

}//class
