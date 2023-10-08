package ejercicios;

public class Ejercicio1 {
	public static String solucionIterativa(Integer varA, Integer varB) {
		String res = "";
		EnteroCadena actual = EnteroCadena.of(varA, "A");
		boolean first = true;
		
		while (actual.a() < varB) {
			actual = EnteroCadena.of(actual.a() + 3, 
					actual.a()%2==0?actual.a()+"*":actual.a()+"!");
			
			if (actual.a()%10 != 0) {
				if(!first) {
					res += "-";
				} else {
					res += "A-";
					first = false;
				}
				res += actual.s();
			}
		}
		return res;
		
	}
	
	public static String solucionRecursiva(Integer varA, Integer varB) {
		return recFinal(EnteroCadena.of(varA, "A"), varB, "");
	}
	
	private static String recFinal(EnteroCadena actual, Integer varB, String res) {
		if (actual.a() >= varB) {
	        return res;
	    }

	    // Aplicar la función nx
		ESTO ES UN CAMBIO DE PRUEBAaa
	    actual = EnteroCadena.of(actual.a() + 3, actual.a() % 2 == 0 ? actual.a() + "*" : actual.a() + "!");

	    // Filtrar y mapear
	    if (actual.a() % 10 != 0) {
	        if (!res.isEmpty()) {
	            res += "-";
	        }
	        res += actual.s();
	    }
	    return recFinal(actual, varB, res);
	}
	
}
