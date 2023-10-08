package ejemplos;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import us.lsi.geometria.Cuadrante;
import us.lsi.geometria.Punto2D;

public class Ejemplo1 {
	public static Map<Cuadrante, Double> solucionFuncional (List<Punto2D> ls) {
		
		return ls.stream().collect(Collectors.groupingBy(Punto2D::cuadrante,
					Collectors.reducing(0., p->p.x(), (a,b) -> a+b)));
	}
	
	public static Map<Cuadrante, Double> solucionIterativa (List<Punto2D> ls) {
		
		Map<Cuadrante, Double> ac = new HashMap<>();
		Integer i = 0;
		
	    while (i < ls.size()) {
	        Punto2D punto = ls.get(i);
	        Cuadrante cuadrante = punto.cuadrante();
	      
	        if (ac.containsKey(cuadrante)) {
	        	ac.put(cuadrante, ac.get(cuadrante)+punto.x());
	        } else {
	        	ac.put(cuadrante, punto.x());
	        }
	        i++;
	    }

	    return ac;
	}
	
	public static Map<Cuadrante, Double> solucionRecursiva (List<Punto2D> ls) {
		Map<Cuadrante,Double> ac = new HashMap<>();
		Integer i = 0;
		return recFinal(ls, ac, i);
	}
	
	private static Map<Cuadrante, Double> recFinal (List<Punto2D> ls, Map<Cuadrante,Double> ac, Integer i) {
		Map<Cuadrante,Double> res = ac;
		if (i < ls.size()) {
			Punto2D punto = ls.get(i);
			Cuadrante cuadrante = punto.cuadrante();
			

			if (ac.containsKey(cuadrante)) {
				ac.put(cuadrante, ac.get(cuadrante)+punto.x());
			} else {
				ac.put(cuadrante, punto.x());
			}
			res = recFinal(ls, ac, i+1);			
	}
		return res;
}
}

