package Mundo;

import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import javafx.embed.swing.JFXPanel;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class Aplicacion extends JPanel
{
	
	private ArrayList listaPrueba;

	
	public Aplicacion(ICore core)
	{
		listaPrueba = new ArrayList();
		listaPrueba.add("New york");
		listaPrueba.add("Miami");
		listaPrueba.add("Panama");
		listaPrueba.add("Bogota");
		listaPrueba.add("Paris");
		try {
			construirMapaPosiciones();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JFXPanel pane = new JFXPanel();
		pane.setBorder(new TitledBorder("JFX"));
		 new Mapa(pane, "Mapa").start();
		this.setLayout(new BorderLayout());
		this.add(pane,BorderLayout.CENTER);
		revalidate();
		repaint();
	}
	
	public void construirMapaPorLatitudLongitud(String latitud, String longitud) throws Exception
	{
		if(longitud.equals("")||latitud.equals(""))
		{
			throw new Exception("Los datos no estan completos");
		}
		else
		{
			listaPrueba.add(latitud+","+longitud);
		} 
	}


	public void construirMapaPosiciones() throws Exception
	{
		int i = 0;
		boolean dirc = new File("./datos/").mkdir();
		File mapa = new File( "./datos/","busqueda.html");
		PrintWriter escritor = new PrintWriter(mapa);
		BufferedReader lector = new BufferedReader(new InputStreamReader(getClass().getResource("/Mundo/datos/baseBusquedas.html").openStream()));
		String linea = lector.readLine();
		while(linea!=null)
		{
			String texto = linea;
			if(linea.contains("var arreglo;"))
			{
				while(i<listaPrueba.size())
				{
					if(i == 0)
					{
						texto = "var arreglo = ['"+listaPrueba.get(i)+"'";
					}
					else
					{
						texto += ",'"+ listaPrueba.get(i)+"'";
					}
					if(i+1 == listaPrueba.size())
					{
						texto +="];";
					}
					i++;
				}
			}
			escritor.println(texto);
			linea = lector.readLine();
		}
		escritor.close();
		lector.close();
	}
}


