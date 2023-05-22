package uniandes.dpoo.taller2.modelo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Ingrediente {
	private Map<String, Integer> ingredientes;
	private Set<String> keys;
	private Collection<Integer> values;
	private String nombre;
	private int costo;
	
	
	public Ingrediente(String nombre, int costoAdicional)
	{
		this.nombre=nombre;
		costo=costoAdicional;
	}
	public String getNombre()
	{
		return nombre;
	}
	public int getcostoAdicional()
	{
		return costo;
	}
	
	
	
	
	public Ingrediente(Map<String, Integer> ingredientes2) {
		// TODO Auto-generated constructor stub
		this.ingredientes=ingredientes2;
	}
	public Map<String, Integer> getIngredientes(){
		
		return ingredientes;
	}
	
	public String mostrarIngredientes()
	{
		for (int i=0; i<ingredientes.size(); i++)
		{
			keys=ingredientes.keySet();
			values=ingredientes.values();
			List<Integer>values1=new ArrayList(values);
			List<String>keys1=new ArrayList(keys);
	

			System.out.println(i+1+". "+keys1.get(i)+ " "+ values1.get(i));
			
		}
	return null;
	}
	
	public int añadirIngrediente(String eleccion) {
		// TODO Auto-generated method stub
		int valor = ingredientes.get(eleccion);
		return valor;
		
	}
	
	public List<String> keysIngredientes()
	{
		keys=ingredientes.keySet();
		List<String>keys1=new ArrayList(keys);
		return keys1;
	}

}
