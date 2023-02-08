package br.com.rogon.refactoringguru.decorator;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.InflaterInputStream;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CompressionDecorator extends DataSourceDecorator{
    private Integer compLevel = 6;

    public CompressionDecorator(DataSource dataSource) {
        super(dataSource);
    }

    public Integer getCompLevel() {
        return compLevel;
    }

    public void setCompLevel(Integer compLevel) {
        this.compLevel = compLevel;
    }

    private String compress(String stringData){
        String compressed = null;
        byte[] data = stringData.getBytes();

        try {
            ByteArrayOutputStream bout = new ByteArrayOutputStream(512);
            DeflaterOutputStream dos = new DeflaterOutputStream(bout, new Deflater(compLevel));
            dos.write(data);
            dos.close();
            bout.close();

            compressed = Base64.getEncoder().encodeToString(bout.toByteArray());
        } catch (IOException e) {
            log.error(e.getMessage());
        }

        return compressed;
    }

    private String decompress(String stringData){
        String decompressed = null;
        byte[] data = Base64.getDecoder().decode(stringData);

        try {
            InputStream in = new ByteArrayInputStream(data);
            InflaterInputStream iin = new InflaterInputStream(in);
            ByteArrayOutputStream bout = new ByteArrayOutputStream(512);

            Integer b;
            while ((b = iin.read()) != -1) {
                bout.write(b);
            }

            in.close();
            iin.close();
            bout.close();

            decompressed = new String(bout.toByteArray());
        } catch (IOException e) {
            log.error(e.getMessage());
        }

        return decompressed;
    }

    @Override
    public void writeData(String data){
        super.writeData(compress(data));
    }

    @Override
    public String readData(){
        return decompress(super.readData());
    }

}
