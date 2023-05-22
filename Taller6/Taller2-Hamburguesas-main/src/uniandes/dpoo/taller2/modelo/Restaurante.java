package uniandes.dpoo.taller2.modelo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import uniandes.dpoo.taller2.procesamiento.LoaderInfo;

public class Restaurante {
	private static ProductoMenu menu;
	private static Ingrediente ingrediente;
	private static Combo combo;
	private static Bebida bebida;
	private List<String> pedido;
	public static Pedido factura;
	public String nombre;
	public String direccion;
	public int id;
	


	public Restaurante(ProductoMenu elMenu, Ingrediente elIngrediente, Combo elCombo, Bebida laBebida) {
		// TODO Auto-generated constructor stub
		menu=elMenu;
		ingrediente=elIngrediente;
		combo=elCombo;
		bebida=laBebida;
	}
//Muestras al usuario 
	//Muestra el menu con las opciones
	public static String Menuprint() {
		
	
		return menu.mostrarMenu();
	}
	//
	public static List<String> keysMenuPrint()
	{

		return menu.keysMenu();
	}
	
	//Muestra los ingredientes con las opciones 
	public static String Ingredienteprint()
	{
		return ingrediente.mostrarIngredientes();
	}
	public static List<String> keysIngredientesPrint()
	{
		return ingrediente.keysIngredientes();
	}
	//Muestra los combos que se pueden elegir
	public static String Comboprint()
	{
		 return combo.mostrarCombo();
	}
	public static List<String> keysComboPrint()
	{
		return combo.keysCombo();
	}
	
	public static String Bebidaprint()
	{
		return bebida.mostrarBebida();
	}
	public static List<String> keysBebidaPrint()
	{
		return bebida.keysBebida();
	}
	
//Calcula el precio 
	//Precio productos
	public static int precioProductos(String eleccion)
	{
		
		int preciopro=menu.añadirProducto(eleccion);
		ProductoMenu pro=new ProductoMenu(eleccion, preciopro);
		return preciopro;
	}
	public static double precioCombos(String eleccion)
	{
		String nombreProducto=combo.nombrePedido(eleccion);
		String papasProducto=combo.papasPedido(eleccion);
		String bebidaProducto=combo.bebidaPedido(eleccion);
		double descuento=combo.descuento(eleccion);
		int preciopro=menu.añadirProducto(nombreProducto);
		int preciopapas=menu.añadirProducto(papasProducto);
		int preciobebida=menu.añadirProducto(bebidaProducto);
		int precioT=preciopro+preciopapas+preciobebida;
		double preciofinal=(precioT*(1-descuento));
		Combo comb=new Combo(preciofinal, eleccion);
		return preciofinal;
	}
	
	public static int precioIngrediente(String eleccion)
	{
		int precioing = ingrediente.añadirIngrediente(eleccion);
		Ingrediente ing=new Ingrediente(eleccion, precioing);
		return precioing;
	}
	public static int precioBebida(String eleccion)
	{
		int preciobed=bebida.añadirBebida(eleccion);
		return preciobed;
	}
	
		
	
	
//Lista con productos del pedido 
	public List<String> pedidoTotal(String eleccion)
	{
		pedido.add(eleccion);
		return pedido;
	}
	

	public static int ejecutarId(String nombre, String direccion) {
	
		int id;
		id=(int) (((nombre.length()*30.5)-(direccion.length()*25.7))+12345);
		Pedido info=new Pedido(id, nombre, direccion);
		return id;
		
	}
	
	public static Map<Integer, List<String>> finalizarpedido(int id, double precioTotal, ArrayList<String> pedidoTotal) {
		
		return factura.pedido(id, precioTotal, pedidoTotal);
	
	}
	public static Pedido pedidoCurso(int id, String nombre, String direccion) {
		factura=new Pedido(id, nombre, direccion);
		return factura;
	}
	public static List<String> consulta(int id, Map<Integer, List<String>> resultado) {
		// TODO Auto-generated method stub
		return factura.consultar(id, resultado);
		
	}
	
	
	
	
	
	
	
}
