package br.com.rogon.bethrobson.composite;

import java.util.ArrayList;
import java.util.Iterator;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Menu extends MenuComponent {    
    private Iterator<MenuComponent> iterator = null;
    private ArrayList<MenuComponent> menuComponents = new ArrayList<>();
    private String name;
    private String description;

    public Menu(String name, String description) {
        this.name = name;
        this.description = description;
    }
    
    @Override
    public void add(MenuComponent menuComponent){
        menuComponents.add(menuComponent);
    }

    @Override
    public void remove(MenuComponent menuComponent){
        menuComponents.remove(menuComponent);
    }

    @Override
    public MenuComponent getChild(int i){
        return menuComponents.get(i);
    }

    @Override
    public String getName(){
        return name;
    }
    
    @Override
    public String getDescription() {
        return description;
    }

    @Override
    Iterator<MenuComponent> createIterator() {
        if(iterator == null){
            iterator = new CompositeIterator(menuComponents.iterator());
        }
        return iterator;
    }

    @Override
    public void print() {
        log.info(getName());
        log.info(getDescription());
        log.info("----------------------------------");

        Iterator<MenuComponent> iterator = menuComponents.iterator();
        while (iterator.hasNext()) {
            MenuComponent menuComponent = iterator.next();
            menuComponent.print();
        }       
    }

}
