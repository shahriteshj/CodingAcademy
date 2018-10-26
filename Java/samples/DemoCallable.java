import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class DemoCallable {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
	
		ExecutorService service = Executors.newCachedThreadPool();
		Future<Double> future= 
				service.submit(new FactorialCalc(4));
		
		while(!future.isDone()){
			System.out.println("Waiting,,,,");
		}
		
		System.out.println("Answer : "+ future.get());
		service.shutdown();
	}

}
