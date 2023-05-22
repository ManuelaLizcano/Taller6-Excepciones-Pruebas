package uniandes.dpoo.taller2.consola;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

import Excepciones.PrecioTotalException;
import Excepciones.ProductoRepetidoException;

import java.util.Collection;
import java.util.Iterator;

import uniandes.dpoo.taller2.modelo.Combo;
import uniandes.dpoo.taller2.modelo.Pedido;
import uniandes.dpoo.taller2.modelo.ProductoMenu;
import uniandes.dpoo.taller2.modelo.Restaurante;
import uniandes.dpoo.taller2.procesamiento.LoaderInfo;


public class Aplicacion {
	
	private Restaurante restaurante;
	public double precioTotal;
	public int id;
	public ArrayList<String> pedidoTotal= new ArrayList<String>();
	public String nombre;
	public String direccion;
	public static Map<Integer, List<String>> resultado;
	public boolean existe;
	
	public static void main(String[] args)
	{
		
		Aplicacion consola= new Aplicacion();
		//consola.ejecutarAplicacion();
		consola.ejecutarCargar();
		consola.ejecutarAplicacion();


		//Restaurante.Menuprint();
		
		//consola.ejecutarCargar();
		//consola.ejecutarAplicacion();
	}
//Menu de entrada
	//muestra el menu
	//inicia pedido
	//consultar informacion de un pedido 
	public void ejecutarAplicacion()
	{
		//ejecutarCargar();
		System.out.println("Bienvenido a la Hamburgueseria: ");
		boolean continuar=true;
		while (continuar)
		{
			//mostrarMenu();
			System.out.println("1.Mostrar el menú");
			System.out.println("2.Iniciar un nuevo pedido");
			System.out.println("3.Consultar la informacion de un pedida dado su id");
			System.out.println("4. Ejecutar cierre de la aplicacion");
			int opcion=Integer.parseInt(input("Ingrese la opcion que desea"));
			if(opcion==1)
				ejecutarMostrarMenu();
			else if (opcion==2)
				ejecutarIniciarPedido();
			else if (opcion==3)
				ejecutarConsulta();
			else if (opcion==4)
				System.out.println("Saliendo de la aplicación ...");
				continuar = false;
		
		}
	}
	
    //opcion 1
	public void ejecutarMostrarMenu()
	{
		System.out.println("1. Productos de Menu");
		System.out.println("2. Productos en Combo");
		System.out.println("3. Productos de Bebidas");

		int opcion=Integer.parseInt(input("Ingrese la opcion que desea"));
		
		if (opcion==1)
		{
			Restaurante.Menuprint();
			ejecutarAplicacion();
		}
		else if (opcion==2)
		{
			Restaurante.Comboprint();
		    ejecutarAplicacion();
		}
		else if(opcion==3)
		{
			Restaurante.Bebidaprint();
			ejecutarAplicacion();
		}
	
   
	}
	//opcion 2
	public void ejecutarIniciarPedido()
	{
		File documentofactura=new File("data\\factura.txt");
		String rutafactura=documentofactura.getAbsolutePath();
		File factura = new File(rutafactura);
		factura.delete();
		System.out.println("Datos del usuario: ");
		String nombre=(input("Ingrese su nombre:"));
		String direccion=(input("Ingrese su direccion:"));
		id = Restaurante.ejecutarId(nombre, direccion);
		ejecutarAgregarElemento();
		
		
		
		
		 //Realizar consulta de pedido llamando a la clase de Restaurante
		 
		
	}
	//opcion 3
	public void ejecutarAgregarElemento() {
		String eleccionProducto;
		String eleccionIngre;
		String eleccionCombo;
		String eleccionBebida;
		String eleccionquitar;
		
		List<String> keysMenu=Restaurante.keysMenuPrint();
		
		List<String> keysIngredientes=Restaurante.keysIngredientesPrint();
		
		List<String> keysCombos=Restaurante.keysComboPrint();
		
		List<String> keysBebidas=Restaurante.keysBebidaPrint();
		
		//this.pedidoTotal=new ArrayList<String>();
		
		System.out.println("1. Añadir producto del menu");
		System.out.println("2. Añadir combo");
		System.out.println("3. Añadir bebida");
		System.out.println("4. Finalizar pedido");
		int op=Integer.parseInt(input("Ingrese la opcion que desea"));


		if (op==1)
		{
			Restaurante.Menuprint();
			int opcion1=Integer.parseInt(input("Ingrese la opcion que desea"));
			eleccionProducto=keysMenu.get(opcion1-1);
			pedidoTotal.add(eleccionProducto);
			precioTotal = precioTotal+ Restaurante.precioProductos(eleccionProducto);

			if (precioTotal>150000)
			{
				try {
					double precio = PrecioTotalException.Precio(precioTotal,eleccionProducto);
				}
				catch(Exception pT){
					System.out.println("ERROR:");
					System.out.println(pT.getMessage());
				}
				precioTotal=precioTotal-Restaurante.precioProductos(eleccionProducto);
				int cantidad = pedidoTotal.size();
				pedidoTotal.remove(cantidad-1);
			}
			int ingrediente=Integer.parseInt(input("Desea añadir un ingrediente \n 1. Sí \n 2. No"));
		
			if (ingrediente==1)
			{
				Restaurante.Ingredienteprint();
				int opcion12=Integer.parseInt(input("Ingrese la opcion que desea"));
				eleccionIngre= keysIngredientes.get(opcion12-1);
				pedidoTotal.add(eleccionIngre);
				precioTotal = precioTotal+ Restaurante.precioIngrediente(eleccionIngre);
				if (precioTotal>150000)
				{
					try {
						double precio = PrecioTotalException.Precio(precioTotal, eleccionIngre);
					}
					catch(Exception pT){
						System.out.println("ERROR:");
						System.out.println(pT.getMessage());
					}
					precioTotal=precioTotal-Restaurante.precioIngrediente(eleccionIngre);
					int cantidad = pedidoTotal.size();
					pedidoTotal.remove(cantidad-1);
				}
				int quitar=Integer.parseInt(input("Desea quitar un ingrediente \n 1. Sí \n 2. No"));
				if (quitar==1)
				{
					Restaurante.Ingredienteprint();
					int opcionquitar=Integer.parseInt(input("Ingrese la opcion que no desea"));
					eleccionquitar = keysIngredientes.get(opcionquitar-1);
					pedidoTotal.add("sin "+ eleccionquitar);
					ejecutarAgregarElemento();
				}
				else if(quitar==2)
				{
					ejecutarAgregarElemento();
				}
			
			}
			else if(ingrediente==2)
			{
				ejecutarAgregarElemento();
			}
			
		}
		else if(op==2)
		{
			Restaurante.Comboprint();
			int opcion2=Integer.parseInt(input("Ingrese la opcion que desea"));
			eleccionCombo=keysCombos.get(opcion2-1);	
			pedidoTotal.add(eleccionCombo);
			precioTotal = precioTotal+ Restaurante.precioCombos(eleccionCombo);
			if (precioTotal>150000)
			{
				try {
					double precio = PrecioTotalException.Precio(precioTotal, eleccionCombo);
				}
				catch(Exception pT){
					System.out.println("ERROR:");
					System.out.println(pT.getMessage());
				}
				precioTotal=precioTotal-Restaurante.precioCombos(eleccionCombo);
				int cantidad = pedidoTotal.size();
				pedidoTotal.remove(cantidad-1);
			}
			
			int quitar=Integer.parseInt(input("Desea quitar un ingrediente \n 1. Sí \n 2. No"));
			if (quitar==1)
			{
				Restaurante.Ingredienteprint();
				int opcionquitar=Integer.parseInt(input("Ingrese la opcion que no desea"));
				eleccionquitar= keysIngredientes.get(opcionquitar-1);
				pedidoTotal.add("sin "+ eleccionquitar);
				ejecutarAgregarElemento();
			}
			else if(quitar==2)
			{
				ejecutarAgregarElemento();
			}
		}
		else if(op==3)
		{
			Restaurante.Bebidaprint();
			int opcion3=Integer.parseInt(input("Ingrese la opcion que desea"));
			eleccionBebida=keysBebidas.get(opcion3-1);
			pedidoTotal.add(eleccionBebida);
			precioTotal=precioTotal+Restaurante.precioBebida(eleccionBebida);
			ejecutarAgregarElemento();
		}
		else if(op==4)
		{
			ejecutarCierre();
		}
		
	}
	//opcion 4
	public void ejecutarCierre() {
		System.out.println("Su pedido final es: ");
		Restaurante.pedidoCurso(id, nombre, direccion);
		
	    resultado = Restaurante.finalizarpedido(id,precioTotal, pedidoTotal);
	    
	  
		 ArrayList pedidoActual = new ArrayList<>();
		 String precioTotalString = Double.toString(precioTotal);
		 pedidoActual.add(precioTotalString);
		 pedidoActual.addAll(pedidoTotal);
		 Collection<List<String>> valores = resultado.values();
		 List<List<String>> lista;
		 for (int i=1; i<=valores.size()-1; i++)
		 {
			 lista=valores.stream().toList();
			 if (lista.size()>=2)
			 {
				 existe=lista.get(i).equals(pedidoActual);
			 }
			 
		 }
		 
		 if(existe==true)
		 {
			 System.out.println("Anteriomente ya se habia realizado un pedido como este.");
		 }
		 else if(existe==false)
		 {
		   System.out.println("No se habia realizado un pedido como este.");
		 }
		
		
		precioTotal=0;
		id=0;
		pedidoTotal.clear();;
		nombre="";
		direccion="";
		ejecutarAplicacion();
		
	    
		
		
	}
	
	//opcion 5
	public void ejecutarConsulta() {
		int id=Integer.parseInt(input("Ingrese el id del pedido que desea consultar"));
		List<String> consult = Restaurante.consulta(id, resultado);
		System.out.println(consult);
		 ejecutarAplicacion();
		
	}
	
	
	public String input(String mensaje)
	{
		try
		{
			System.out.print(mensaje + ": ");
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			return reader.readLine();
		}
		catch (IOException e)
		{
			System.out.println("Error leyendo de la consola");
			e.printStackTrace();
		}
		return null;
	}
	
	private void ejecutarCargar()
	{

		System.out.println("\n" + "Cargar datos" + "\n");

		try
		{
		   LoaderInfo.cargarArchivo();
		 
			
		}
		catch (FileNotFoundException e)
		{
			System.out.println("ERROR: el archivo indicado no se encontró.");
		}
		catch (IOException e)
		{
			System.out.println("ERROR: hubo un problema leyendo el archivo.");
			System.out.println(e.getMessage());
		}
		finally
		{
			
			System.out.print("");
		}
		
		//poner que la direccion sea en general para cualquier computador 
	
	}
}
