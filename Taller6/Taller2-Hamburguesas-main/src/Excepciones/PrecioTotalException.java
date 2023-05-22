package Excepciones;

import java.util.ArrayList;

public class PrecioTotalException {

	public static double Precio(double precio,String ultimoelemento)throws Exception{
		
		if (precio>=150000)
		{
			
			throw new Exception("La suma total del pedido excede los $150,000, no puede agregar "+ultimoelemento+ " a su pedido");
			
		}
		
		return precio ;
		
	}
}
