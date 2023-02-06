package br.com.rogon.bethrobson.adapter;

import static org.mockito.Mockito.never;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
/*
 * Essa adaptador transforma um Duck em Turkey
 */
public class DuckAdapterTest {
    private Map<String, Object> beans;
    private static final String ADAPTER_BEAN = "fakeTurkey";
    private static final String DUCK_BEAN = "duck";

    @BeforeEach
    void setup(){
        beans = new HashMap<>();

        var duck = spy(new MallarDuck());
        beans.put(DUCK_BEAN, duck);

        var duckAdapter = spy(new DuckAdapter((Duck) beans.get(DUCK_BEAN)));
        beans.put(ADAPTER_BEAN, duckAdapter);
    }

    /*
     * O adaptador deveria transformar o Duck em um Turkey
     */
    @Test
    void testAdapter(){
        var fakeTurkey = (Turkey) beans.get(ADAPTER_BEAN);
        var duck = (Duck) beans.get(DUCK_BEAN);

        //Verificando o gobble()
        //Quando o FakeTurkey faz Gobble
        fakeTurkey.gobble();
        //O Duck faz Quack
        verify(duck).quack();

        //Verificando o fly()
        //Quando o FakeTurkey fly()
        fakeTurkey.fly();
        //Duck pode ou não fly()
        if(fakeTurkey.isFly()){
            verify(duck).fly();
        } else {
            verify(duck, never()).fly();
        }
    }
    
}
