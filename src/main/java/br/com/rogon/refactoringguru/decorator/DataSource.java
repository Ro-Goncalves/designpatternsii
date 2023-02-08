package br.com.rogon.refactoringguru.decorator;

public interface DataSource {
    
    void writeData(String data);
    String readData();
}
