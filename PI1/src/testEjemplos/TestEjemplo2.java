package testEjemplos;

import java.util.List;
import java.util.function.Function;

import ejemplos.Ejemplo2;
import us.lsi.common.Files2;
import us.lsi.common.IntPair;

public class TestEjemplo2 {

	public static void main(String[] args) {
		
		Function<String, IntPair> parse = s -> {
			String [] s2 = s.split(",");
			Integer a = Integer.parseInt(s2[0]);
			Integer b = Integer.parseInt(s2[1]);
			return IntPair.of(a, b);
		};
		
		List<IntPair> ls = Files2.streamFromFile("ficheros/Ejemplo2DatosEntrada.txt").map(parse).toList();
		
		ls.forEach(e -> {
			System.out.println("1) Recursiva NO FINAL: "+ Ejemplo2.recNoFinal(e.first(), e.second()));
		});
		
//		System.out.println("1) Funcional: "+Ejemplo2.solucionFuncional(ls));
//		System.out.println("1) Iterativo: "+Ejemplo2.solucionIterativa(ls));
//		System.out.println("1) RecursivoFinal: "+Ejemplo2.solucionRecursiva(ls));
	}
	

}