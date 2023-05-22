package uniandes.dpoo.taller2.modelo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Bebida {
	private Map<String, Integer> bebidas;
	private Set<String> keys;
	private Collection<Integer> values;
	public static List<String> keysfinal;

	public Bebida(Map<String, Integer> bebida)
	{
		this.bebidas=bebida;
	}
	
	public String mostrarBebida() {
		for (int i=0; i<bebidas.size(); i++)
		{
			keys=bebidas.keySet();
			values=bebidas.values();
			List<Integer>values1=new ArrayList(values);
			List<String>keys1=new ArrayList(keys);
			keysfinal=keys1;
			System.out.println((i+1)+". "+keys1.get(i)+ " "+ values1.get(i));
		}
	return null;
	}

	public List<String> keysBebida() {
		keys=bebidas.keySet();
		List<String>keys1=new ArrayList(keys);
		return keys1;
	}

	public int añadirBebida(String eleccion) {
		// TODO Auto-generated method stub
		int valor = bebidas.get(eleccion);
		return valor;
	}

}
