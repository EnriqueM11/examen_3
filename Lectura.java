package examen_3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class Lectura {
	String archivoCSV = "/Users/sistelcomunica/eclipse-workspace/examen_3/src/examen_3/emails.csv";
	        String linea = "";
	        String separador = ",";
	        int filas_a_evaluar = 50;
	        int contador=1;
	        int digitos;
	        
	   
	
public void ejecutar (int ID){
	        
	
	digitos=ID%1000;
	digitos=digitos-1;

	        Map<String, Integer> columnas = new HashMap<>();

	        try (BufferedReader br = new BufferedReader(new FileReader(archivoCSV))) {
	            // Leer la primera línea del archivo
	            linea = br.readLine();
	            String[] titulos = linea.split(separador);

	            // Agregar las columnas al HashMap
	            for (int i = 1; i < titulos.length; i++) {
	                columnas.put(titulos[i].trim(), 0);
	            }

	            // Iterar a través de las filas y sumar los valores de las columnas
	            int cont = 0;
	            while ((linea = br.readLine()) != null && cont < filas_a_evaluar) {
	                String[] valores = linea.split(separador);
	                

	                if (contador == digitos) { // verificar si se ha alcanzado la fila deseada
	                    String[] datos = linea.split(separador);

	                    for (int i = 1; i < datos.length; i++) {
	                        String columna = titulos[i];
	                        int valor = Integer.parseInt(datos[i]);
	                        int sumaActual = columnas.get(columna);
	                        columnas.put(columna, sumaActual + valor);
	                    }
	                    cont++;
	                }
	                else {
	                	contador++;
	                }


	           
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	        // GUARDAR los resultados
	        
	        try {
	            FileWriter writer = new FileWriter("174798.txt");
	            for (Map.Entry<String, Integer> entry : columnas.entrySet()) {
	                writer.write(entry.getKey() + ": " + entry.getValue() + "\n");
	                
	            }
	            System.out.println("Documento creado con exito");
	            writer.close();
	        } catch (IOException e_2) {
	            e_2.printStackTrace();
	        }
}
}

	        
	        





