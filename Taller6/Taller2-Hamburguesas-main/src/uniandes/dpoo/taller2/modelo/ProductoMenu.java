package uniandes.dpoo.taller2.modelo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import uniandes.dpoo.taller2.modelo.ProductoAjustado;


public  class ProductoMenu {
	
	private Map<String, Integer> menu;
	private Set<String> keys;
	private Collection<Integer> values;
	private String nombre;
	private int precioBase;
	public static List<String> keysfinal;
	private ProductoAjustado cambio;
	
	public ProductoMenu(String nom, int precio) 
	{
		nombre=nom;
		precioBase=precio;
	}
	public String getNombre()
	{
		return nombre;
	}
	
	public int getPrecio()
	{
		return precioBase;
	}
	
	
	public ProductoMenu(Map<String, Integer> menu2)
	{
		this.menu=menu2;
	}
	
	public  Map<String, Integer> getMenu() {
		// TODO Auto-generated method stub
		
		return menu;
	}
	public String mostrarMenu()
	{
		for (int i=0; i<menu.size(); i++)
		{
			keys=menu.keySet();
			values=menu.values();
			List<Integer>values1=new ArrayList(values);
			List<String>keys1=new ArrayList(keys);
			keysfinal=keys1;
			System.out.println((i+1)+". "+keys1.get(i)+ " "+ values1.get(i));
		}	

	return null;
	
	}
	public int añadirProducto(String eleccion) {
		// TODO Auto-generated method stub
		int valor = menu.get(eleccion);
		return valor;
		
	}
	
	public List<String> keysMenu()
	{
		keys=menu.keySet();
		List<String>keys1=new ArrayList(keys);
		return keys1;
	}
	
	
	
	
}
