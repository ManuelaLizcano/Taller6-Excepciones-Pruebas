package Pruebas;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import uniandes.dpoo.taller2.modelo.Combo;
public class ComboTest {
	    private Combo combo;
	    private Map<String, List<String>> prueba;
	    private List<String> lista1=new ArrayList<>();
	    private List<String> lista2=new ArrayList<>();
	    @BeforeEach
	    public void setUp() throws Exception {
	        prueba = new HashMap<>();
	        lista1.add("1%");
	        lista1.add("nombre1");
	        lista1.add("papas1");
	        lista1.add("gaseosa1");
	        prueba.put("producto1", lista1);
	        
	        lista1.add("2%");
	        lista1.add("nombre2");
	        lista1.add("papas2");
	        lista1.add("gaseosa2");
	        prueba.put("producto2", lista2);
	       
	        combo = new Combo(prueba);
	    }

	    @Test
	    public void testCombo1() {
	    	assertEquals(combo.descuento("producto1"), 0.01);
	    	
	    }
	    @Test
	    public void testCombo2() {
	    	
	    	assertEquals(combo.nombrePedido("producto1"), "nombre1");
	    	
	    	
	    }
	    @Test
	    public void testCombo3() {
	    	
	    	assertEquals(combo.papasPedido("producto1"), "papas1");
	    	
	    	
	    }
	    @Test
	    public void testCombo4() {
	    	
	    	assertEquals(combo.bebidaPedido("producto1"), "gaseosa1");
	    	
	    }
	    @Test
	    public void testCombo5() {
	    	
	    	assertEquals(prueba.keySet().toString(), combo.keysCombo().toString());
	    	
	    }
}
