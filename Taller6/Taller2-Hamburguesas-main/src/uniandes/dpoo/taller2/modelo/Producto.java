package uniandes.dpoo.taller2.modelo;

public interface Producto {
	
	public default int getPrecio()
	{
		return getPrecio();
	}
	
	public default String getNombre()
	{
		return getNombre();
	}
	public default String generarTextoFactura()
	{
		return generarTextoFactura();
	}
	
}
