import java.util.concurrent.atomic.LongAdder;

public class AddingUsers implements Runnable {

	private LongAdder adder;
	
	
	public AddingUsers(LongAdder adder) {
		super();
		this.adder = adder;
	}


	@Override
	public void run() {

			for(int i=0;i<50;i++){
				String tname = Thread.currentThread().getName();
				adder.increment();
				System.out.println(tname+" : "+adder.intValue());
			}
	}

}
