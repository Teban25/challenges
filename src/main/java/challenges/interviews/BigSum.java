package challenges.interviews;

import java.math.BigInteger;

public class BigSum {

	public static void main(String[] args) {
		long [] n = new long[]{1000000001, 1000000002,1000000003,1000000004,1000000005};
		BigInteger sumaEnteros = BigInteger.valueOf(0);
	
		for (int i = 0; i < n.length; i++) {
			BigInteger elementoEntero = BigInteger.valueOf(n[i]);
			sumaEnteros = sumaEnteros.add(elementoEntero);
		}
		System.out.println(sumaEnteros);
	}
	
	public static long suma(long[] ar){
		long sumaEnteros = 0L;
	
		for (int i = 0; i < ar.length; i++) {
			sumaEnteros += ar[i];
		}
		return sumaEnteros;
	}
}
