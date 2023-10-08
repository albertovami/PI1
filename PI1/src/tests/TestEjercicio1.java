package tests;

import java.util.List;
import java.util.function.Function;

import ejercicios.Ejercicio1;
import us.lsi.common.Files2;
import us.lsi.common.IntPair;

public class TestEjercicio1 {

	public static void main(String[] args) {
		
		Function<String, IntPair> parse = s -> {
			String [] s2 = s.split(",");
			Integer a = Integer.parseInt(s2[0]);
			Integer b = Integer.parseInt(s2[1]);
			return IntPair.of(a, b);
		};
		List<IntPair> ls = Files2.streamFromFile("ficherosEjercicios/PI1Ej1DatosEntrada.txt")
				.map(parse).toList();
		
		ls.forEach(e -> {
			System.out.println("1) Iterativo: "+ Ejercicio1.solucionIterativa(e.first(), e.second()));
			System.out.println("1) Recursivo: "+ Ejercicio1.solucionRecursiva(e.first(), e.second()));
		});

	}

}
