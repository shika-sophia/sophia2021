package javaGoF.chap22Command.drawer;

import java.awt.Color;

public interface IDrawable {
    public abstract void draw(int x, int y);
    public abstract void setColor(Color color);
}//interface
