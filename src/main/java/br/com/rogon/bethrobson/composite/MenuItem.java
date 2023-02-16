package br.com.rogon.bethrobson.composite;

import java.math.BigDecimal;
import java.util.Iterator;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MenuItem extends MenuComponent {
    String name;
    String description;
    boolean vegetarian;
    BigDecimal price;

    public MenuItem(String name, String description, boolean vegetarian, BigDecimal price) {
        this.name = name;
        this.description = description;
        this.vegetarian = vegetarian;
        this.price = price;
    }

    @Override
    public String getName() {       
        return name;
    }

    @Override
    public String getDescription() {        
        return description;
    }

    @Override
    public BigDecimal getPrice() {        
        return price;
    }

    @Override
    public boolean isVegetarian() {        
        return vegetarian;
    }

    @Override
    Iterator<MenuComponent> createIterator() {        
        return new NullIterator();
    }

    @Override
    public void print() {
        log.info(getName());

        if(isVegetarian()){
            log.info("(v)");
        }

        log.info("U$ " + getPrice().toString());
        log.info(getDescription());

        log.info("------------------------------------------------------------------");
    }

    
}
