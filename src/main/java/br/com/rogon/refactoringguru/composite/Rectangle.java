package br.com.rogon.refactoringguru.composite;

import java.awt.*;

/*
 * Um ret
 * retângulo
 */
public class Rectangle extends BaseShape{
    public int width;
    public int height;

    public Rectangle(int x, int y, int height, int width, Color color) {
        super(x, y, color);
        this.width = width;
        this.height = height;
    }

    @Override
    public int getWidth(){
        return width;
    }

    @Override
    public int getHeight(){
        return height;
    }

    @Override
    public void paint(Graphics graphics){
        super.paint(graphics);
        graphics.drawRect(x, y, getWidth() - 1, getHeight() - 1);
    }
    
}
