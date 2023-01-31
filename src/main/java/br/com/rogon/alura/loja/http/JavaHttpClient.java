package br.com.rogon.alura.loja.http;

import java.net.URL;
import java.util.Map;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JavaHttpClient implements HttpAdapter{

    @Override
    public void post(String url, Map<String, Object> dados) {
        try {
            URL urlDaApi = new URL(url);
            log.info("Abrindo Conexao com -> " + urlDaApi.toString());
            /*
            URLConnection connection = urlDaApi.openConnection();
            connection.connect();
            */
            log.info("Enviando dado a API -> " + dados.toString());
        } catch (Exception e) {
            throw new RuntimeException("Erro ao enviar requisição http", e);
        }
        
    }
    
}
