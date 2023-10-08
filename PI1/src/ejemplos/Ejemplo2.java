package ejemplos;

public class Ejemplo2 {
	
	public static String recNoFinal (Integer a, Integer b) {
		String res;
		
		if(a<5 || b<5) {
//			Integer t = a*b;
//			res = "("+t+")";
			res = String.format("(%d)", a*b);
		
		} else {
//			Integer t = a*b;
//			res = t + recNoFinal(a/2, b-2);
			res = String.format("%d%s", a+b, recNoFinal(a/2, b-2));
		}
		return res;
	}
}
