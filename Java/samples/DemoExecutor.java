import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DemoExecutor {

	public static void main(String[] args) {
		ExecutorService service = Executors.newCachedThreadPool();
		System.out.println("No of Threads: "+ Thread.activeCount());
		service.execute(new MyTask("Task 007"));
		System.out.println("No of Threads: "+ Thread.activeCount());
		service.shutdown();
	}

}
