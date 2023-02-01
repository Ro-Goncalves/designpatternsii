package br.com.rogon.iluwatar.adapter;

import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Teste para o padrão adapter
 */
public class AdapterPatternTest {
    private Map<String, Object> beans;
    private static final String FISHING_BEAN = "fisher";
    private static final String ROWING_BEAN = "captain";

    /**
     * Roda antes de cada teste definindo os objetos Bean
     * no Map beans
     */
    @BeforeEach
    void setup(){
        beans = new HashMap<>();

        var fishingBoatAdapter = spy(new FishingBoatAdapter());
        beans.put(FISHING_BEAN, fishingBoatAdapter);

        var captain = new Captain();
        captain.setRowingBoat((FishingBoatAdapter) beans.get(FISHING_BEAN));
        beans.put(ROWING_BEAN, captain);
    }

    /**
     * 
     */
    @Test
    void testAdapter(){
        var captain = (Captain) beans.get(ROWING_BEAN);

        //Quando o capitão se move
        captain.row();

        //Internamente o capitão chama o objeto BattleShip para se mover
        var adapter = (RowingBoat) beans.get(FISHING_BEAN);
        verify(adapter).row();
    }
    
}
