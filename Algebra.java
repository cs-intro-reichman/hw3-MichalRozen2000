// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
	    // Tests some of the operations
	    System.out.println(plus(2,3));   // 2 + 3
	    System.out.println(minus(7,2));  // 7 - 2
   		System.out.println(minus(2,7));  // 2 - 7
 		System.out.println(times(3,4));  // 3 * 4
   		System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2
   		System.out.println(pow(5,3));      // 5^3
   		System.out.println(pow(3,5));      // 3^5
   		System.out.println(div(12,3));   // 12 / 3    
   		System.out.println(div(5,5));    // 5 / 5  
   		System.out.println(div(25,7));   // 25 / 7
   		System.out.println(mod(25,7));   // 25 % 7
   		System.out.println(mod(120,6));  // 120 % 6    
   		System.out.println(sqrt(36));
		System.out.println(sqrt(263169));
   		System.out.println(sqrt(76123));
	}  

	// Returns x1 + x2
	public static int plus(int x1, int x2) {
		if (x2 >= 0) {
		for (int i = 0 ; i < x2 ; i++){
			x1++;
		}
	} else {
		for (int i = 0 ; i < -x2 ; i++){
			x1--;
		}
	}
		return x1;
	}

	// Returns x1 - x2
	public static int minus(int x1, int x2) {
		if (x2 < 0) {
		for (int i = 0 ; i < -x2 ; i++){
			x1++;
		 }
		} else {
			for (int i = 0 ; i < x2 ; i++){
				x1--;
		 }
	   }
		return x1;
	}

	// Returns x1 * x2
	public static int times(int x1, int x2) {

		if (x1 == 0 || x2 == 0) {
            return 0;  
        }
        int total = 0;

        if (x1 < 0) {
            x1 = minus(0, x1);
        }
        if (x2 < 0) {
            x2 = minus(0, x2);
        }
		for (int i = 0 ; i < x2 ; i++){
			total = plus(total, x1);		
		}
		if ((x1 < 0 && x2 >= 0) || (x2 < 0 && x1 >= 0)) {
			total = minus(0, total);
		}
		return total;
	}

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
		if (n == 0){
			return 1;
		}
		int total = 1;
		for (int i = 1 ; i <= n ; i++){
			total = times(total, x);

		}

		if (x < 0 && n % 2 != 0) {
            total = minus(0, total);
		}

		return total;
	}

	// Returns the integer part of x1 / x2 
	public static int div(int x1, int x2) {
		int result = 0;

		if (x1 == x2){
			return 1;
		}
		if (x2 == 0) {
			return 0;
		}

		 while (x1 >= x2) {
            x1 = minus(x1, x2);
            result = plus(result, 1);
        }

		if ((x1 < 0 && x2 >= 0) || (x2 < 0 && x1 >= 0)) {
            result = minus(0, result);
        }
		
		return result;
	
}

	// Returns x1 % x2
	public static int mod(int x1, int x2) {
		if (x2 == 0) {
			return 0;
		}
		int result = 0;

		if (x1 < 0) {
			x1 = minus (0, x1);
		}
		if (x2 < 0) {
			x2 = minus (0, x2);
		}
		while (result + x2 <= x1) {
            result = plus(result, x2);
        }						

	    int finalMod = minus(x1, result);

		if (x1 < 0 && x2 >= 0 || x2 < 0 && x1 >= 0) {
			finalMod = minus(0, finalMod);
		}
		return finalMod;
}


	// Returns the integer part of sqrt(x) 
	public static int sqrt(int x) {
		if (x < 0) {
			return 0;
		}
		int number = 0;
		int i;
		for (i = 1; number <= x; i++){
			number = times(i,i);
		}
		return minus(i, 2);
	}	
}  	  
