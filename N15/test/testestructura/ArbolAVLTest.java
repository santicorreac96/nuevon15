package testestructura;

import java.util.ArrayList;

import EstructuraDatos.ArbolAVL;
import junit.framework.TestCase;

public class ArbolAVLTest extends TestCase
{
	
	private ArbolAVL<String> arbol;
	private int numero1;
	private int numero2;
	
	
	private void setupEscenario1()
	{
		arbol = new ArbolAVL<String>();
		
	}
	
	public void testAgregarBuscar()
	{
		setupEscenario1();
		int agregado =0;
		while(agregado<10)
		{
			numero1= agregado;
			arbol.agregarElemento("a"+numero1, new comparadorEnteros());
			agregado++;
		}
		numero2=999;
		arbol.agregarElemento("a"+numero2, new comparadorEnteros());
		
		assertEquals("a"+numero1,arbol.buscarElemento("a"+numero1));
		assertEquals("a"+numero2,arbol.buscarElemento("a"+numero2));
	}
	
	public void testInorder()
	{
		testAgregarBuscar();
		ArrayList test = arbol.inorder();
		int i =0;
		String txt ="";
		while(i<test.size())
		{
			txt+=test.get(i)+",";
			i++;
		}
		System.out.println(txt);
	}
	

}
