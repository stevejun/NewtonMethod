/**
 * 
 * NEWTON METHOD
 * @author Steve Jun
 *
 */
public class NewtonMethod {
	
	//NEWTON METHOD
	//i)	f(x) must be continuous
	//ii)	f(x)=0 on some interval [a,b]
	
	public static void main (String args[]){
		System.out.println("\nProgram START:");
		double i, n, TOL, p0, p;
		
		//step1
		p0=1;				//initial approximation		
					
		TOL=.00000001;		//tolerance
		i=0;				//current number of iterations
		n=100;				//number of iteration
		System.out.println( "\nInitial Value = "+p0+
							"\nTolerance = "+TOL+
							"\nMax Iterations = "+n+"\n");
		
		//step2
		System.out.println("Calculating ...");
		while (i<=n){
			//step3
			p = p0 - f(p0)/fprime(p0);
			
			//step4
			System.out.println(p);
			if (Math.abs(p-p0)<TOL){
				System.out.println("The procedure was successful after "+i+" iterations.\n" + "p = " + p);
				verifySolution(p);
				System.out.println("\nUsing the diode equation with V sub d = "+p+" V, we get ...\n"+
				diodeEquation(p) + " A");	//diode equation
				System.out.println("\nUsing Ohm's law with V sub d = "+p+" V, we get ...\n"+
				(10-p)/1000 + " A");		//ohm's law
				System.exit(1);
			}
			//step5
			++i;
			p0=p;
			
		}
		System.out.println("The procedure was unsuccesful after "+n+" iterations.");

	}
	
	/**
	 * Define function f(x).
	 * @param x
	 * @return
	 */
	public static double f(double x){
		double y;
		
		y= 1e-8*(Math.pow(Math.E, (1.6e-19*x)/(300*1.38e-23))-1) - ((10-x)/1000);
		
		return y;
	}
	
	/**
	 * Define the first derivative of f wrt x.
	 * @param x
	 * @return
	 */
	public static double fprime(double x){
		double y;
		
		y= ((1.6e-19*x)/(300*1.38e-23))*1e-8*(Math.pow(Math.E, (1.6e-19*x)/(300*1.38e-23)))+1;

		return y;
	}
	
	/**
	 * Ideal Diode Equation. y is current I.
	 * @param x
	 * @return
	 */
	public static double diodeEquation(double x){
		double y;
		
		y= 1e-8*(Math.pow(Math.E, (1.6e-19*x)/(300*1.38e-23))-1);
		
		return y;
	}
	
	/**
	 * Use to verify solution. Plugs x into original function f(x).
	 * @param p
	 */
	private static void verifySolution(double p){
		System.out.println("\n f("+p+") = "+f(p));
	}
}
