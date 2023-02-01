package br.com.rogon.iluwatar.adapter;

public class App {
    public static void main(String[] args) {
        var captain = new Captain(new FishingBoatAdapter());
        captain.row();        
    }    
}
