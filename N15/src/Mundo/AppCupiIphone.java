package Mundo;

import javax.swing.JPanel;

public class AppCupiIphone implements IAplicacion
{

	
	/**
	 * Referencia al core del cupiPhone, para localizar otros componentes y acceder al directorio de datos
	 */
	private ICore core;
	
	
	/**
	 * Panel principal del componente
	 */
	private Aplicacion panel;
	
	
	/**
	 * Clase principal del mundo del componente
	 */
	private Aplicacion mundo;
	
	/**
	 * Esta aplicación se implementa como un singleton
	 */
	private static AppCupiIphone instancia;
	
	/* (non-Javadoc)
	 * @see uniandes.cupi2.cupIphone.componentes.IAplicacion#darPanelPrincipal()
	 */
	public JPanel darPanelPrincipal() {
		return panel;
	}

	/* (non-Javadoc)
	 * @see uniandes.cupi2.cupIphone.componentes.IAplicacion#terminarEjecucion()
	 */
	public void terminarEjecucion() {
		//panel.terminar();
	}

	/* (non-Javadoc)
	 * @see uniandes.cupi2.cupIphone.componentes.IAplicacion#darInstanciaModelo()
	 */
	public Object darInstanciaModelo() {
		return mundo;
	}

	/* (non-Javadoc)
	 * @see uniandes.cupi2.cupIphone.componentes.IAplicacion#cambiarCore(uniandes.cupi2.cupIphone.core.ICore)
	 */
	public void cambiarCore(ICore c) {
		core = c;
		
	}

	/* (non-Javadoc)
	 * @see uniandes.cupi2.cupIphone.componentes.IAplicacion#iniciarEjecucion()
	 */
	public void iniciarEjecucion() {
	   panel = mundo = new Aplicacion(core);
	}

	/**
	 * Método necesario para interactuar con el core
	 * del teléfono
	 * @return La instancia de la clase
	 */
	public static IAplicacion darInstancia()
	{
		return instancia!=null? instancia: new AppCupiIphone();
	}

}
