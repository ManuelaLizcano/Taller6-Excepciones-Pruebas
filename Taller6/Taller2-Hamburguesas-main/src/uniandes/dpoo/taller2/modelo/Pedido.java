package uniandes.dpoo.taller2.modelo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Pedido {
	
	private int id;
	private String nombre;
	private String direccion;
	private int numeroPedidos;
	public static Map<Integer, List<String>> factura=new HashMap<>();
	
	

	public Pedido(int idPedido, String nombreCliente, String direccionCliente)
	{
		id=idPedido;
		nombre=nombreCliente;
		direccion=direccionCliente;
	}
	public int cantidadPedidos()
	{
		numeroPedidos=numeroPedidos+1;
		return numeroPedidos;
	}
	
	public int getid()
	{
		return id;
	}
	public String getnombre()
	{
		return nombre;
	}
	public String getdireccion()
	{
		return direccion;
	}

	public Map<Integer, List<String>> pedido(int id, double precioTotal, ArrayList<String> pedidoTotal){
		ArrayList<String> pagoPedido=new ArrayList<>();
		String preciototal=Double.toString(precioTotal);
		pagoPedido.add(preciototal);
		pagoPedido.addAll(pedidoTotal);
		factura.put(id, pagoPedido);
		facturaDocumento(id, precioTotal, pedidoTotal);
		System.out.print("Numero de identificacion de factura:");
		System.out.println(id);
		System.out.print("El precio total del pedido es(sin IVA): ");
		System.out.println(precioTotal);
		System.out.print("El pedido final es: ");
		System.out.println(pedidoTotal);
		
		return factura;	
	}
	public static void facturaDocumento(int id, double precioTotal, ArrayList<String> pedidoTotal) 
	{
		try
		{
			
			///File documento=new File("C:\\Users\\manul\\OneDrive\\Bureau\\data\\factura.txt");
			
			File documentofactura=new File("data\\factura.txt");
			String rutafactura=documentofactura.getAbsolutePath();
			String caloriasdef;
			if (!documentofactura.exists())
			{
				documentofactura.createNewFile();
			}
			
			
			FileWriter escribir=new FileWriter(rutafactura);
			BufferedWriter buffer=new BufferedWriter(escribir);
			double iva=precioTotal*0.19;
			double precioiva=iva+precioTotal;
			String ivaString=Double.toString(iva);
			String precioivaString=Double.toString(precioiva);
			String idString = Integer.toString(id);
			buffer.write("Numero de identificacion de factura:");
			buffer.write(idString);
			buffer.write("\n");
			String precioTotalstring=Double.toString(precioTotal);
			buffer.write("El precio total del pedido (sin IVA): ");
			buffer.write(precioTotalstring);
			buffer.write("\n");
			buffer.write("Tarifa general del IVA (19%): ");
			buffer.write(ivaString);
			buffer.write("\n");
			buffer.write("El precio total del pedido (con IVA): ");
			buffer.write(precioivaString);
			buffer.write("\n");
			for (int i=0; i<pedidoTotal.size(); i++)
			{
				String linea = pedidoTotal.get(i);
				String numero=Integer.toString(i+1);
				buffer.write(numero+". ");
				buffer.write(linea);
				buffer.write("\n");
			}
			buffer.write("Calorias totales: ");
			double calorias = ((precioTotal/20)+25.75)/1.25;
			caloriasdef=Double.toString(calorias);
			buffer.write(caloriasdef);
			buffer.write("\n");
			buffer.close();	
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
	}
	public List<String> consultar(int id, Map<Integer, List<String>> resultado) {
		boolean incluye = resultado.containsKey(id);
		if (incluye==true)
		{
			List<String> listaPedido = resultado.get(id);
			return listaPedido;
		}
		return null;
		
	}
	
}
