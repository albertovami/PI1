package testEjemplos;

import java.util.List;
import java.util.function.Function;

import ejemplos.Ejemplo1;
import us.lsi.common.Files2;
import us.lsi.geometria.Punto2D;

public class TestEjemplo1 {

	public static void main(String[] args) {
		
		Function<String, Punto2D> parse = s -> {
			String [] s2 = s.split(",");
			Double x = Double.parseDouble(s2[0]);
			Double y = Double.parseDouble(s2[1]);
			return Punto2D.of(x, y);
		};
		
		List<Punto2D> ls = Files2.streamFromFile("ficheros/Ejemplo1DatosEntrada.txt").map(parse).toList();	
		
		System.out.println("1) Funcional: "+Ejemplo1.solucionFuncional(ls));
		System.out.println("1) Iterativo: "+Ejemplo1.solucionIterativa(ls));
		System.out.println("1) RecursivoFinal: "+Ejemplo1.solucionRecursiva(ls));
	}
	

}
