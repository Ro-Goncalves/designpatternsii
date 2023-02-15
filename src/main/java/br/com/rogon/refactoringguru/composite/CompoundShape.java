package br.com.rogon.refactoringguru.composite;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Forma composta, que consiste de outros objetos de forma
 */
public class CompoundShape extends BaseShape {
    protected List<Shape> children = new ArrayList<>();

    public CompoundShape(Shape... components){
        super(0, 0, Color.BLACK);
        add(components);
    }

    public void add(Shape component){
        children.add(component);
    }

    public void add(Shape... compoments){
        children.addAll(Arrays.asList(compoments));
    }

    public void remove(Shape child){
        children.remove(child);
    }

    public void remove(Shape... compoments){
        children.removeAll(Arrays.asList(compoments));
    }

    public void clear(){
        children.clear();
    }

    @Override
    public int getX(){
        if(children.size() == 0){
            return 0;
        }

        //Pegando o maior X, ver outra forma
        int x = children.get(0).getX();
        for (Shape child : children) {
            if (child.getX() < x) {
                x = child.getX();
            }
        }
        return x;
    }

    @Override
    public int getY(){
        if(children.size() == 0){
            return 0;
        }

        int y = children.get(0).getY();
        for (Shape child : children) {
            if (child.getY() < y) {
                y = child.getY();
            }
        }
        return y;
    }

    @Override
    public int getWidth(){
        int maxWidht = 0;
        int x = getX();
        for(Shape child : children){
            int childsRelativex = child.getX() - x;
            int childWidth = childsRelativex + child.getWidth();
            if(childWidth > maxWidht){
                maxWidht = childWidth;
            }
        }

        return maxWidht;
    }

    @Override
    public int getHeight() {
        int maxHeight = 0;
        int y = getY();
        for (Shape child : children) {
            int childsRelativeY = child.getY() - y;
            int childHeight = childsRelativeY + child.getHeight();
            if (childHeight > maxHeight) {
                maxHeight = childHeight;
            }
        }
        return maxHeight;
    }

    @Override
    public void move(int x, int y){
        children.forEach(child -> child.move(x, y));
    }

    @Override
    public boolean isInsideBounds(int x, int y){
        for(Shape child : children){
            if(child.isInsideBounds(x, y)){
                return true;
            }
        }

        return false;
    }

    @Override
    public void unSelect(){
        super.unSelect();
        children.forEach(child -> child.unSelect());
    }

    public boolean selectChildAt(int x, int y){
        for(Shape child : children){
            if(child.isInsideBounds(x, y)){
                child.select();
                return true;
            }
        }
        return false;
    }

    @Override
    public void paint(Graphics graphics){
        if(isSelected()){
            enableSelectionStyle(graphics);
            graphics.drawRect(getX() - 1, getY() - 1, getWidth() + 1, getHeight() +1);
            disableSelectionStyle(graphics);
        }

        children.forEach(child -> child.paint(graphics));
    }
    
}
