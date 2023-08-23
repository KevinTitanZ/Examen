package grafo.aydacencia;

import java.util.Scanner;

public class Menu {

	public void menu() {
	        Scanner scanner = new Scanner(System.in);
	        GrafoAdcia grafo = new GrafoAdcia(20);

	        while (true) {
	            System.out.println("\n---------------Realizado Por ordoñez Kevin :------------------");
	            System.out.println("1. Introdusca el vértice");
	            System.out.println("2. Introdusca el arco");
	            System.out.println("3. Recorrido en profundidad");
	            System.out.println("4. Buscar en lista de adyacencia");
	            System.out.println("5. Salir");
	            System.out.print("Seleccione una opción: ");
	            System.out.println("\n-------------------------------------------------------------");
	            int opcion = scanner.nextInt();

	            switch (opcion) {
	                case 1:
	                    System.out.print("Ingrese el nombre de la ciudad: ");
	                    scanner.nextLine(); // Consume newline left by nextInt()
	                    String ciudad = scanner.nextLine();
	                    grafo.agregarVertice(ciudad);
	                    break;

	                case 2:
	                    System.out.print("Ingrese el nombre de la ciudad origen: ");
	                    scanner.nextLine(); // Consume newline left by previous nextInt()
	                    String origen = scanner.nextLine();
	                    System.out.print("Ingrese el nombre de la ciudad destino: ");
	                    String destino = scanner.nextLine();
	                    System.out.print("Ingrese el peso del arco: ");
	                    double peso = scanner.nextDouble();
	                    grafo.agregarArco(origen, destino, peso);
	                    break;

	                case 3:
	                	  System.out.print("Ingrese el nombre del vértice de inicio: ");
	                      scanner.nextLine(); // Consume newline left by previous nextInt()
	                      String ciudadInicio = scanner.nextLine();
	                      VerticeAdy verticeInicio = buscarVertice(ciudadInicio, grafo.tablAdc, grafo.numVerts);
	                      if (verticeInicio != null) {
	                          System.out.println("Recorrido en profundidad:");
	                          grafo.RecorridoProfundidad(verticeInicio); // Use the existing RecorridoP method
	                          System.out.println();
	                      } else {
	                          System.out.println("El vértice de inicio no existe en el grafo.");
	                      }
	                    break;

	                case 4:
	                    System.out.print("Ingrese el nombre de la ciudad origen: ");
	                    scanner.nextLine(); // Consume newline left by previous nextInt()
	                    String ciudadOrigen = scanner.nextLine();
	                    System.out.print("Ingrese el nombre de la ciudad destino: ");
	                    String ciudadDestino = scanner.nextLine();
	                    boolean adyacentes = grafo.sonAdyacentes(ciudadOrigen, ciudadDestino);
	                    if (adyacentes) {
	                        System.out.println("Las ciudades son adyacentes.");
	                    } else {
	                        System.out.println("Las ciudades no son adyacentes.");
	                    }
	                    break;

	                case 5:
	                    System.out.println("Saliendo del programa.");
	                    scanner.close();
	                    System.exit(0);

	                default:
	                    System.out.println("Opción no válida.");
	            }
	        }
	    }
	  private static VerticeAdy buscarVertice(String nombreCiudad, VerticeAdy[] tablAdc, int numVerts) {
	        for (int i = 0; i < numVerts; i++) {
	            if (tablAdc[i].nomVertice().equals(nombreCiudad)) {
	                return tablAdc[i];
	            }
	        }
	        return null;
	    }
	}