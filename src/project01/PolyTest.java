package project01;

import java.util.Arrays;

public class PolyTest {

	public static void main(String[]args) {
		double []array = {-1,2,-1};
		double []array2 = {2,3,4,5,6};
		
		Polynomial p = new Polynomial(array);
		Polynomial p2 = new Polynomial(array2);
		
		System.out.println(p);
		System.out.println(p2);
		double d = p.f(3);
		//System.out.println(d);
		
		
		Polynomial p3 = Polynomial.add(p, p2);
		
		System.out.println(p3);
		
		
	}

}
