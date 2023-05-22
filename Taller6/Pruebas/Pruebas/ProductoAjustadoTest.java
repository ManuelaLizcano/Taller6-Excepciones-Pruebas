package Pruebas;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uniandes.dpoo.taller2.modelo.ProductoAjustado;
import uniandes.dpoo.taller2.modelo.ProductoMenu;

public class ProductoAjustadoTest {
	private ProductoAjustado productoajustado;
	private List<String> añadidosprueba=new ArrayList<>();
	private List<String> elimiadosprueba=new ArrayList<>();
	
	@BeforeEach 
	public void setUp() throws Exception{
		this.añadidosprueba.add("elemento1");
		this.elimiadosprueba.add("elemento2");
		productoajustado=new ProductoAjustado();
	}
	@Test
	public void testProductoAjustado1() {
		assertEquals(productoajustado.Ingrediente_añadidos("elemento1").toString(), añadidosprueba.toString());
		
	}
	@Test
	public void testProductoAjustado2() {
		assertEquals(productoajustado.Ingrediente_eliminados("elemento2").toString(), elimiadosprueba.toString());
		
	}
	
}
