package Excepciones;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

public class ProductoRepetidoException extends HamburgesaException {

	
	public static ArrayList<String> ProductoRepetido(ArrayList<String> productos1)throws Exception{
		int cantidad = productos1.size();
		int registro=0;
		for (int i=0; i<cantidad; i++)
		{
			for (int k=i+1; k<cantidad; k++)
			{
				if(productos1.get(k).equals(productos1.get(i)))
				{
	
					registro=registro+1;
				}
			}
			
		}
		if (registro>=1)
		{
			
			throw new Exception("Existen productos repetidos");
		}
		
		return productos1;
		
	}
}
