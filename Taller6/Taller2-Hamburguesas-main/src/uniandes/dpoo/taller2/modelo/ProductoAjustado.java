package uniandes.dpoo.taller2.modelo;

import java.util.ArrayList;
import java.util.List;

public class ProductoAjustado {
	private ArrayList<String> añadidos=new ArrayList<>();
	private ArrayList<String> eliminados=new ArrayList<>();
	private Producto producto;
	
	public ProductoAjustado() {
		this.producto=producto;
	}
	public List<String> Ingrediente_añadidos(String ingrediente) {
		añadidos.add(ingrediente);
		return añadidos;
	}
	public List<String> Ingrediente_eliminados(String ingrediente) {
		eliminados.add(ingrediente);
		return eliminados;
	}
}
