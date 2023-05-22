package Pruebas;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uniandes.dpoo.taller2.modelo.Combo;
import uniandes.dpoo.taller2.modelo.Pedido;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PedidoTest {
	
	private Pedido pedido1;
	private int idprueba;
	private double precioTotalprueba;
	private ArrayList<String> pedidoTotalprueba=new ArrayList<>();
	private String nombreprueba;
	private String direccionprueba;
	private int numeroPedidosprueba;
	public static Map<Integer, List<String>> factura=new HashMap<>();
	private String filepath;
	

    @BeforeEach
    public void setUp() throws Exception {
        idprueba=1;
        precioTotalprueba=100;
        pedidoTotalprueba.add("elemento1");
        pedidoTotalprueba.add("elemento2");
        pedidoTotalprueba.add("elemento3");
        
        factura.put(idprueba, pedidoTotalprueba);
        
        nombreprueba="nombre";
        direccionprueba="dirreccion";
        numeroPedidosprueba=100;
        
        filepath="data\\factura.txt";
  
    }

    
    @Test
    public void testPedido1() {
    	File documento=new File(filepath);
    	assertTrue(documento.exists());
    	
    }
}
