package Excepciones;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class IngredienteRepetidoException extends HamburgesaException {

	public static ArrayList<String> IngredienteRepetido(ArrayList<String> ingredientes1)throws Exception{
		int cantidad = ingredientes1.size();
		int registro=0;
		for (int i=0; i<cantidad; i++)
		{
			for (int k=i+1; k<cantidad; k++)
			{
				if(ingredientes1.get(k).equals(ingredientes1.get(i)))
				{
	
					registro=registro+1;
				}
			}
			
		}
		if (registro>=1)
		{
			throw new Exception("Existen ingredientes repetidos");
		}
		
		return ingredientes1;
		
	}
}
