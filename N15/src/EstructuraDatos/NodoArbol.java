package EstructuraDatos;

import java.util.Comparator;

public class NodoArbol<T>
{
	
	private T elemento;
	
	private NodoArbol<T> nodoDerecha;
	
	private NodoArbol<T> nodoIzquierda;
	
	private NodoArbol<T> padre;
	
	private int estado;
	
	public NodoArbol(T nElemento)
	{
		elemento = nElemento;
		nodoDerecha = null;
		padre = null;
		nodoIzquierda = null;
		estado = 0;
	}

	public T getElemento() {
		return elemento;
	}

	public void setElemento(T elemento) {
		this.elemento = elemento;
	}

	public NodoArbol<T> getNodoDerecha() {
		return nodoDerecha;
	}

	public void setNodoDerecha(NodoArbol<T> nodoDerecha) {
		this.nodoDerecha = nodoDerecha;
	}

	public NodoArbol<T> getNodoIzquierda() {
		return nodoIzquierda;
	}

	public void setNodoIzquierda(NodoArbol<T> nodoIzquierda) {
		this.nodoIzquierda = nodoIzquierda;
	}

	public NodoArbol<T> getPadre() {
		return padre;
	}

	public void setPadre(NodoArbol<T> padre) {
		this.padre = padre;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public void insertar(NodoArbol<T> p, NodoArbol<T> q, Comparator<NodoArbol<T>> comparador) 
	{
		// If compare node is smaller, continue with the left node
		// q menor que p
		if(comparador.compare(p, q)<0)
		{
			if(p.nodoIzquierda==null) 
			{
				p.setNodoIzquierda(q); 
				q.setPadre(p);

				// Node is inserted now, continue checking the balance
				//TODO recursiveBalance(p);
			} 
			else 
			{
				insertar(p.getNodoIzquierda(),q, comparador);
			}

		} 
		// q mayor que p
		else if(comparador.compare(p, q)>0)
		{
			if(p.nodoDerecha==null) 
			{
				p.setNodoDerecha(q);
				q.setPadre(p);

				// Node is inserted now, continue checking the balance
				//TODO recursiveBalance(p);
			} 
			else 
			{
				insertar(p.getNodoDerecha(),q,comparador);
			}
		} 
		else 
		{
			// do nothing: This node already exists
		}
	}
	
	public void recursiveBalance(NodoArbol<T> actual) {
		  
		  // we do not use the balance in this class, but the store it anyway
		  calcularBalance(actual);
		  int balance = actual.getEstado();

		  // check the balance
		  if(balance==-2) 
		  {

			  if(height(actual.getNodoIzquierda().getNodoIzquierda())>=height(actual.getNodoIzquierda().getNodoDerecha()))
			  {
				  actual = rotateRight(actual);
			  }
			  else 
			  {
				  actual = doubleRotateLeftRight(actual);
			  }
		  } 
		  else if(balance==2)
		  {
			  if(height(actual.getNodoDerecha().getNodoDerecha())>=height(actual.getNodoDerecha().getNodoIzquierda()))
			  {
				  actual = rotateLeft(actual);
			  } 
			  else
			  {
				  actual = doubleRotateRightLeft(actual);
			  }
		  }

		  // we did not reach the root yet
		  if(actual.getPadre()!=null) 
		  {
			  recursiveBalance(actual.getPadre());
		  }
		  else
		  {
			  this.root = actual;
			  System.out.println("------------ Balancing finished ----------------");
		  }
	}

	private void calcularBalance(NodoArbol<T> actual) 
	{
		// TODO Auto-generated method stub
		
	}



}
