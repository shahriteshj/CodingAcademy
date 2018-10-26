import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.LongAdder;

public class AtomicDemo {

	public static void main(String[] args) {
		LongAdder adder = new LongAdder();
		
		AddingUsers operation1 = new AddingUsers(adder);
		AddingUsers operation2 = new AddingUsers(adder);
		
		ExecutorService service = Executors.newCachedThreadPool();
		service.execute(operation2);
		service.execute(operation1);
			
		service.shutdown();
	}

}
