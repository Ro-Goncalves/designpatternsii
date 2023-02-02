package br.com.rogon.bethrobson.adapter;

import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Esse adaptador transforma um Turkey em Duck
 */
public class TurkeyAdapterTest {
    private Map<String, Object> beans;
    private static final String ADAPTER_BEAN = "fakeDuck";
    private static final String TURKEY_BEAN = "turkey";

    @BeforeEach
    void setup(){
        beans = new HashMap<>();

        var turkey = spy(new WildTurkey());
        beans.put(TURKEY_BEAN, turkey);

        var turkeyAdapter = spy(new TurkeyAdapter((Turkey) beans.get(TURKEY_BEAN)));
        beans.put(ADAPTER_BEAN, turkeyAdapter);
    }

    /**
     * O adaptador deveria transformar o Turkey em um Duck
     */
    @Test
    void testAdapter(){
        var fakeDuck = (Duck) beans.get(ADAPTER_BEAN);
        var turkey = (Turkey) beans.get(TURKEY_BEAN);

        //Verificando o quack()

        //Quando o fakeDuck faz Quake
        fakeDuck.quack();
        //O Turkey faz gobble        
        verify(turkey).gobble();

        //Verificando o fly()

        //Quando o fakeDuck Fly
        fakeDuck.fly();
        //O Turkey Fly 5 vezes
        verify(turkey, times(5)).fly();
    }
    
}
