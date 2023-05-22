package uniandes.dpoo.taller2.procesamiento;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Excepciones.IngredienteRepetidoException;
import Excepciones.ProductoRepetidoException;
import uniandes.dpoo.taller2.consola.Aplicacion;
import uniandes.dpoo.taller2.modelo.Bebida;
import uniandes.dpoo.taller2.modelo.Combo;
import uniandes.dpoo.taller2.modelo.Ingrediente;
import uniandes.dpoo.taller2.modelo.ProductoMenu;
import uniandes.dpoo.taller2.modelo.Restaurante;

public class LoaderInfo {
	
	//public Map<String, String> menu;
	//public Map<String, String> ingredientes;
	//public Map<String, List<String>> combos;
	public static Restaurante restaurante;
	
	public static Restaurante cargarArchivo() throws FileNotFoundException, IOException
	{
		
		Map<String, Integer> menu = new HashMap<>();
	    Map<String, Integer> ingredientes = new HashMap<>();
		Map<String, List<String>> combos= new HashMap<>();
		Map<String, Integer> bebida=new HashMap<>();

		ArrayList<String> menu1=new ArrayList<>();
		ArrayList<String> ingredientes1=new ArrayList<>();
		
		
	
		//Map<String, String> menu = new HashMap<>();
		//Map<String, String> ingredientes = new HashMap<>();
		//Map<String, List<String>> combos= new HashMap<>();
		// Abrir el archivo y leerlo línea por línea usando un BufferedReader
		File documentomenu=new File("data\\menu.txt");
		String rutamenu=documentomenu.getAbsolutePath();
		//"C:\Users\manul\OneDrive\Documentos\DEPO-202122826\Taller2-Hamburguesas\data\menu.txt"
		//String rutamenufinal=rutamenu.replace("\\","\\\\");
		//(String rutamen=("\""+rutamenufinal+"\"");
		BufferedReader br_menu = new BufferedReader(new FileReader(rutamenu));
		
		String linea = br_menu.readLine();
		// La primera línea del archivo se ignora porque únicamente tiene los títulos de
										// las columnas
		
		while (linea != null) // Cuando se llegue al final del archivo, linea tendrá el valor null
		{
			// Separar los valores que estaban en una línea
			String[] partes = linea.split(";");
			String producto = partes[0];
			Integer precio = Integer.parseInt(partes[1]);
			menu.put(producto, precio);
			menu1.add(producto);
			
			linea = br_menu.readLine();
		
		}
		
		ProductoMenu elMenu = new ProductoMenu(menu);
		//elMenu.getMenu();
		br_menu.close();
		
		File documentoingredientes=new File("data\\ingredientes.txt");
		String rutaingredientes=documentoingredientes.getAbsolutePath();
		BufferedReader br_ingredientes = new BufferedReader(new FileReader(rutaingredientes));
		//BufferedReader br_ingredientes = new BufferedReader(new FileReader("C:\\Users\\manul\\OneDrive\\Bureau\\data\\ingredientes.txt"));
		String linea1 = br_ingredientes.readLine(); // La primera línea del archivo se ignora porque únicamente tiene los títulos de
										// las columnas
		
		while (linea1 != null) // Cuando se llegue al final del archivo, linea tendrá el valor null
		{
			// Separar los valores que estaban en una línea
			String[] partes = linea1.split(";");
			String ingrediente = partes[0];
			Integer precio = Integer.parseInt(partes[1]);
			ingredientes.put(ingrediente, precio);
			ingredientes1.add(ingrediente);
			linea1 = br_ingredientes.readLine();
		}

		Ingrediente elIngrediente=new Ingrediente(ingredientes);

		br_ingredientes.close();
		
		File documentocombos=new File("data\\combos.txt");
		String rutacombos=documentocombos.getAbsolutePath();
		BufferedReader br_combos = new BufferedReader(new FileReader(rutacombos));

		//BufferedReader br_combos = new BufferedReader(new FileReader("C:\\Users\\manul\\OneDrive\\Bureau\\data\\combos.txt"));
		String linea2 = br_combos.readLine(); // La primera línea del archivo se ignora porque únicamente tiene los títulos de
										// las columnas
		
		while (linea2 != null) // Cuando se llegue al final del archivo, linea tendrá el valor null
		{
			// Separar los valores que estaban en una línea
			ArrayList<String> listacombos=new ArrayList<>();
			String[] partes = linea2.split(";");
			String combo = partes[0];
			String descuento = partes[1];
			String producto = partes[2];
			String papas= partes[3];
			String gaseosa= partes[4];
			listacombos.add(descuento);
			listacombos.add(producto);
			listacombos.add(papas);
			listacombos.add(gaseosa);
			combos.put(combo, listacombos);
			linea2 = br_combos.readLine();
		}
		Combo elCombo=new Combo(combos);
		
	
		br_combos.close();
		
		
		
		
		
		
		
		
		File documentobebidas1=new File("data\\bebidas.txt");
		String rutabebidas1=documentobebidas1.getAbsolutePath();
		BufferedReader br_bebidas = new BufferedReader(new FileReader(rutabebidas1));
		
		String linea3 = br_bebidas.readLine(); // La primera línea del archivo se ignora porque únicamente tiene los títulos de
										// las columnas
		
		while (linea3 != null) // Cuando se llegue al final del archivo, linea tendrá el valor null
		{
			// Separar los valores que estaban en una línea
			String[] partes = linea3.split(";");
			String bebida1 = partes[0];
			Integer precio = Integer.parseInt(partes[1]);
			bebida.put(bebida1, precio);
			linea3 = br_bebidas.readLine();
		}
		Bebida laBebida=new Bebida(bebida);
		Restaurante restaurante=new Restaurante(elMenu, elIngrediente, elCombo, laBebida);
		
		//elMenu.getMenu();
		br_bebidas.close();
		try {
			ArrayList<String> errorIngredientes=IngredienteRepetidoException.IngredienteRepetido(ingredientes1);
		}
		catch(Exception i){
			System.out.println("ERROR:");
			System.out.println(i.getMessage());
		}
		try {
			ArrayList<String> errorProductos=ProductoRepetidoException.ProductoRepetido(menu1);
		}
		catch(Exception p) {
			System.out.println("ERROR:");
			System.out.println(p.getMessage());
		}
		

		
	return restaurante;
	} 

	
	



			
		
}
