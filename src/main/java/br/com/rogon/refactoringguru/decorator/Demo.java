package br.com.rogon.refactoringguru.decorator;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Demo {
    public static void main(String[] args) {
        String salaryRecords = "Name,Salary\nJohn Smith,100000\nSteven Jobs,912000";
        String output = Demo.class.getResource("/").getPath() + "out/OutputDemo.txt";
        
        DataSourceDecorator encoded = new CompressionDecorator(
            new EncryptionDecorator(
                new FileDataSource(output)
            )
        );

        encoded.writeData(salaryRecords);
        DataSource plain = new FileDataSource(output);

        log.info("INPUT");
        log.info(salaryRecords + "\n");
        log.info("ENCODED");
        log.info(plain.readData() + "\n");
        log.info("DECODED");
        log.info(encoded.readData() + "\n");
    }
}
