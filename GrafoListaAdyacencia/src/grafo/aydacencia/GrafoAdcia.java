package grafo.aydacencia;

public class GrafoAdcia{

	int numVerts;
	static int maxVerts = 20;
	VerticeAdy[] tablAdc;

	public GrafoAdcia(int mx) {
		tablAdc = new VerticeAdy[mx];
		numVerts = 0;
		maxVerts = mx;
	}



	// Agregar el  metodo que permite agregar un nuevo vertice
	/*
	 * Anade un nuevo vertice a la lista directorio. Si el vertice ya este en la tabla no hace nada, 
	 * devuelve control; si es nuevo, se asigna a continuacion del ultimo. 
	 */
	// Método para agregar un nuevo vértice
	public void agregarVertice(String nombreCiudad) {
		if (numVerts < maxVerts) {
			VerticeAdy nuevoVertice = new VerticeAdy(nombreCiudad);
			for (int i = 0; i < numVerts; i++) {
				if (tablAdc[i].equals(nuevoVertice)) {
					System.out.println("El vértice " + nombreCiudad + " ya existe en el grafo.");
					return;
				}
			}
			tablAdc[numVerts] = nuevoVertice;
			nuevoVertice.asigVert(numVerts);
			numVerts++;
		} else {
			System.out.println("El grafo ha alcanzado el límite máximo de vértices.");
		}
	}	

	//Agregar metodo que permite agregar un nuevo arco
	/*
	 * Esta operacion da entrada a un arco del grafo. El metodo tiene como entrada el vertice origen y el 
	 * vertice destino. El metodo adyacente() determina si la arista ya esta en la lista de adyacencia, 
	 * y, por ultimo, el Arco se inserta en la lista de adyacencia del nodo origen. 
	 * La insercion se hace como primer nodo para que el tiempo sea constante, O(1). 
	 * Otra version del metodo recibe, directamente, los numeros de vertices que forman los extremos del arco. 
	 * ara anadir una arista en un grafo valorado, se debe asignar el factor de peso al crear el Arco.
	 */
	public void agregarArco(String nombreCiudadOrigen, String nombreCiudadDestino, double pesoDKm) {
		VerticeAdy verticeOrigen = null;
		VerticeAdy verticeDestino = null;
		for (int i = 0; i < numVerts; i++) {
			if (tablAdc[i].nomVertice().equals(nombreCiudadOrigen)) {
				verticeOrigen = tablAdc[i];
			}
			if (tablAdc[i].nomVertice().equals(nombreCiudadDestino)) {
				verticeDestino = tablAdc[i];
			}
		}
		if (verticeOrigen == null || verticeDestino == null) {
			System.out.println("Uno o ambos vértices no existen en el grafo.");
			return;
		}

		Arco nuevoArco = new Arco(verticeDestino.getNumVertice(), pesoDKm);
		verticeOrigen.lad.add(nuevoArco);
	}


	//Agregar un m�todo que determina si dos v�rtices son adyacentes
	/*
	 * La operaci�n determina si dos v�rtices, v1 y v2, forman un arco. En definitiva, 
	 * si el v�rtice v2 est� en la lista de adyacencia de v1. 
	 * El m�todo buscarLista() devuelve la direcci�n del nodo que contiene al arco, si no est� devuelve null. 
	 */

	public boolean sonAdyacentes(String nombreCiudadOrigen, String nombreCiudadDestino) {
		VerticeAdy verticeOrigen = null;
		VerticeAdy verticeDestino = null;
		for (int i = 0; i < numVerts; i++) {
			if (tablAdc[i].nomVertice().equals(nombreCiudadOrigen)) {
				verticeOrigen = tablAdc[i];
			}
			if (tablAdc[i].nomVertice().equals(nombreCiudadDestino)) {
				verticeDestino = tablAdc[i];
			}
		}
		if (verticeOrigen == null || verticeDestino == null) {
			System.out.println("Uno o ambos vértices no existen en el grafo.");
			return false;
		}
		for (Object arco : verticeOrigen.lad) {
			if (((Arco) arco).getDestino() == verticeDestino.getNumVertice()) {
				return true;
			}
		}

		return false;
	}




	///recorrido en profundidad en profundidad 

	    public void RecorridoProfundidad(VerticeAdy inicio) {
	        boolean[] visitados = new boolean[GrafoAdcia.maxVerts];
	        RecorridoPR(inicio, visitados);
	    }

	    private void RecorridoPR(VerticeAdy vertice, boolean[] visitados) {
	        visitados[vertice.numVertice] = true;
	        System.out.print(vertice.nomVertice() + " ");

	        for (Arco arco : vertice.lad) {
	            int destino = arco.getDestino();
	            if (!visitados[destino]) {
	            	RecorridoPR(tablAdc[destino], visitados);
	            }
	        }
	    }
}





