package challenges.interviews;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MatrizEspiral {
	
	public static void main(String[] args) {
		String vectores = "[1,2,3,4,6],[1,2,4,8,9,2],[1,2,3,7,8],[8,9,5,2,2,3],[7,8,9,2,3]";
		List<List<Integer>> filas = cargarVectores(vectores);
		matrizEspiral(filas);
		// 123462833298781124897225923
		// 123462833298781124897225923
	}
	
	private static void matrizEspiral(List<List<Integer>> filas) {
		imprimirEspiralEstandar(filas);
		if (filas.size() > 2) {
			List<List<Integer>> subFilas = extraerSubFilas(filas);
			matrizEspiral(subFilas);
		}	
	}
	
	private static List<List<Integer>> extraerSubFilas(List<List<Integer>> filas) {
		List<List<Integer>> subFilas = new ArrayList<>();
		for (int i = 1; i < filas.size() - 1; i++) {
			int tamanoFila = filas.get(i).size();
			List<Integer> subFila = filas.get(i).subList(1, tamanoFila - 1);
			subFilas.add(subFila);
		}
		return subFilas;
	}
	
	private static void imprimirEspiralEstandar(List<List<Integer>> vectores) {
		// primer fila secuencialmente
		imprimir(vectores.get(0));
		if(vectores.size()>1) {
			// ultima columna secuencialmente
			imprimir(extraerElementos(vectores, -1));
			
			// ultima fila inversamente
			Collections.reverse(vectores.get(vectores.size() - 1));
			imprimir(vectores.get(vectores.size() - 1));
			
			// primera columna inversamente
			List<Integer> columnaPrimeros = extraerElementos(vectores,0);
			Collections.reverse(columnaPrimeros);
			imprimir(columnaPrimeros);
		}
	}
	
	private static List<Integer> extraerElementos(List<List<Integer>> filas, int i) {
		List<Integer> vector = new ArrayList<>();
		for (int j = 1; j < filas.size() - 1; j++) {
			if(i == -1) {
				int tamanoFila = filas.get(j).size() - 1;
				vector.add(filas.get(j).get(tamanoFila));
			} else {
				vector.add(filas.get(j).get(i));
			}
		}
		
		return vector;
	}
	
	private static void imprimir(List<Integer> fila) {
		fila.forEach(System.out::print);
	}
	
	// cargar los datos de String a tipo lista de enteros
	private static List<List<Integer>> cargarVectores(String input) {
		List<List<Integer>> filas = new ArrayList<>();
		String[] vectores = input.split("]");
		
		List<String> fila1 = Arrays.asList(vectores[0].substring(1).split(","));
		List<Integer> fila1Converted = convertStringListToIntList(fila1, Integer::parseInt);
		filas.add(fila1Converted);

		for (int i = 1; i < vectores.length; i++) {
			List<String> filaI = Arrays.asList(vectores[i].substring(2).split(","));
			List<Integer> filaIConverted = convertStringListToIntList(filaI, Integer::parseInt);
			filas.add(filaIConverted);
		}
		return filas;
	}
	
	// Metodo generico para convertir un lista de tipo T a tipo U basado en lamda function
	private static <T, U> List<U> convertStringListToIntList(List<T> listOfString, Function<T, U> function){
		return listOfString.stream().map(function).collect(Collectors.toList());
	}
}
