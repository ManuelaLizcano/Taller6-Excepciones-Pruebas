package Pruebas;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import uniandes.dpoo.taller2.modelo.ProductoMenu;

public class ProductoMenuTest {
    private ProductoMenu productomenu;
    private Map<String, Integer> prueba;

    @BeforeEach
    public void setUp() throws Exception {
        prueba = new HashMap<>();
        prueba.put("producto1", 1);
        prueba.put("producto2", 2);
        prueba.put("producto3", 3);
        productomenu = new ProductoMenu(prueba);
    }

    @Test
    public void testProductoMenu1() {
    	assertEquals(prueba.keySet().toString(), productomenu.keysMenu().toString());
        
    }
    @Test
    public void testProductoMenu2() {
    	
        assertEquals(productomenu.añadirProducto("producto1"), 1);
    }
}
