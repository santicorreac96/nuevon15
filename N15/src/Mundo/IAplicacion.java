package Mundo;

import javax.swing.JPanel;



public interface IAplicacion
{/*
	
	public abstract void registrarUsuario(Usuario nuevo) throws Exception;
	
	public abstract boolean verificarUsuario( Usuario verificar);
	
	public abstract void cambiarSesionActual(Usuario cambiar);
	
	public abstract void definirNuevaUbicacion(Ubicacion nueva) throws Exception;
	
	public abstract IArbolAVL<Ubicacion> mostrarNUbicaciones(int numero);
	
	public abstract IArbolAVL<Hotel> consultarHotelesCercaUbicacion(Ubicacion buscar);
	
	public abstract Hotel buscarHotel(String id);
	
	public abstract void reservarHotel(Hotel buscado);
	
	public abstract IArbolAVL<Reserva> darReservasUsuario(Usuario actual);
	
	public abstract IArbolAVL<Reserva> darReservasHotel(Hotel actual);
	
	public abstract void eliminarHotel(String id);
	
	public abstract void modificarFecha(Date nuevaFecha);
	
	public abstract IArbolAVL<Hotel> darHotelesPorRegion(String region);
	
	public abstract void guardarHuffman();
	
*/
	/**
	 * Interfaz que define el punto de entrada de una aplicaci�n que se
	 * instala en el CupIphone
	 * @author Yeisson Oviedo
	 */


		/**
		 * Retorna el panel principal de la aplicaci�n
		 * @return Panel principal 
		 */
		public JPanel darPanelPrincipal();

		/**
		 * M�todo que es invocado al momento de inicializar la aplicaci�n
		 * @param c Referencia al n�cleo de la aplicaci�n
		 */
		public void cambiarCore(ICore c);
		
		/**
		 * Le indica a la aplicaci�n que su ejecuci�n ha comenzado
		 */
		public void iniciarEjecucion();
		
		/**
		 * M�todo invocado justo antes de cerrar el componente
		 */
		public void terminarEjecucion();
		
		/**
		 * Retorna la instancia del modelo de esta aplicaci�n
		 * @return La instancia del modelo. La clase a la que se debe 
		 * hacer cast depende de cada componente
		 */
		public Object darInstanciaModelo();
			
}
