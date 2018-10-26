import java.util.concurrent.Callable;

public class FactorialCalc implements Callable<Double> {

	private double num;
	
	public FactorialCalc(double num) {
		super();
		this.num = num;
	}

	@Override
	public Double call() throws Exception {
		double temp = num;
		for(int i = 1; i<=num ;i++){
			temp *= i;
		}
		return temp;
	}
	
}
