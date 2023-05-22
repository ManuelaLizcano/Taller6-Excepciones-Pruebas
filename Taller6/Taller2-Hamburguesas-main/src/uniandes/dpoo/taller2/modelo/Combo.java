package uniandes.dpoo.taller2.modelo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

public class Combo {
	
	private Map<String, List<String>> combo;
	private Set<String> keys;
	public List<String>keys1;
	public Integer posicion;
	private double porcentaje;
	private String nombre;
	
	
	public Combo(double descuento, String nombre) 
	{
		porcentaje=descuento;
		this.nombre=nombre;
	}
	public String nombre()
	{
		return nombre;
	}
	
	public Combo(Map<String, List<String>> combos) {
		// TODO Auto-generated constructor stub
		this.combo=combos;
	}
	public List<String> getCombo(String nombreCombo){
		List<String> resultado = combo.get(nombreCombo);
		return resultado;
	}

	public String mostrarCombo()
	{
		Collection<List<String>> values =new ArrayList<>();
		for (int i=0; i<combo.size(); i++)
		{
			keys=combo.keySet();
			values = combo.values();
			List<String>keys1=new ArrayList(keys);
			//List<String>values1=new ArrayList(values);
			System.out.println((i+1)+ ". "+ keys1.get(i));
	
		}
		values.stream().distinct().forEach(System.out::println);
	return null;
	}
	
	
	
	public double descuento(String nombrecombo)
	{
		List<String> resultado = combo.get(nombrecombo);
		String resultado_string=resultado.get(0);
		posicion=resultado_string.lastIndexOf("%");
		String valor_string = resultado_string.substring(0, posicion);
		double valor_double = Double.parseDouble(valor_string);
		porcentaje=valor_double/100;
		
		
		return porcentaje;
	}
	public String nombrePedido(String eleccion) {
		// TODO Auto-generated method stub
		List<String> lista = getCombo(eleccion);
		String producto = lista.get(1);
		return producto;
	}
	public String papasPedido(String eleccion) {
		List<String> lista = getCombo(eleccion);
		String papas = lista.get(2);
		return papas;
	}
	public String bebidaPedido(String eleccion) {
		List<String> lista = getCombo(eleccion);
		String bebida = lista.get(3);
		return bebida;
	}
	
	
	public List<String> keysCombo()
	{
		keys=combo.keySet();
		List<String>keys1=new ArrayList(keys);
		return keys1;
	}
}

