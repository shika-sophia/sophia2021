package javaGoF.chap22Command.drawer;

import java.awt.Point;

import javaGoF.chap22Command.command.ICommand;

public class DrawCommand implements ICommand {
    protected IDrawable drawable; //描画対象
    private Point position;       //描画位置

    public DrawCommand(IDrawable drawable, Point position) {
        this.drawable = drawable;
        this.position = position;
    }

    @Override
    public void execute() {
        drawable.draw(position.x, position.y);
    }//execute()

}//class
