package grafo.aydacencia;

import java.util.ArrayList;
import java.util.List;
import java.util.List;
public class VerticeAdy {
	//Grafo dirigido
	String nombreCiudad;
	int numVertice;
	 ArrayList<Arco> lad; // lista de adyacencia
	
	// constructor de la clase
	public VerticeAdy(String x) {
		nombreCiudad = x;
		numVertice = -1;
	     lad = new ArrayList<>();
	}
	
	public int getNumVertice() {
	    return numVertice;
	}
	
	public String nomVertice() { // devuelve identificador del vértice 
		return nombreCiudad;
	}

	public boolean equals(VerticeAdy n) { // true, si dos vértices son iguales
		return nombreCiudad.equals(n.nombreCiudad);
	}

	public void asigVert(int n) {
        numVertice = n;
    }
	
	public String toString() {// características del vértice
		return nombreCiudad + " (" + numVertice + ")";
	}
}
