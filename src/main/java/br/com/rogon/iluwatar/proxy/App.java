package br.com.rogon.iluwatar.proxy;

public class App {
    public static void main(String[] args) {
        var proxy = new WizardTowerProxy(new IvoryTower());
        proxy.enter(new Wizard("Red Wizard"));
        proxy.enter(new Wizard("White Wizard"));
        proxy.enter(new Wizard("Black Wizard"));
        proxy.enter(new Wizard("Green Wizard"));
        proxy.enter(new Wizard("Brown Wizard"));
    }
}
