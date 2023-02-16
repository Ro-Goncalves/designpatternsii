package br.com.rogon.bethrobson.composite;

import java.util.Iterator;

import lombok.extern.slf4j.Slf4j;

/*
 * Garçonete
 */
@Slf4j
public class Waitress {
    MenuComponent allMenus;

    public Waitress(MenuComponent allMenus){
        this.allMenus = allMenus;
    }

    public void printMenu(){        
        allMenus.print();
    }

    public void printVegetarianMenu(){
        Iterator<MenuComponent> iterator = allMenus.createIterator();

        log.info("VEGETARIAN MENU");
        while (iterator.hasNext()) {
            MenuComponent menuComponent = iterator.next();
            try{
                if (menuComponent.isVegetarian()){
                    menuComponent.print();
                }
            } catch (UnsupportedOperationException e){}
        }
    }
    
}
