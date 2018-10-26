
public class MyTask implements Runnable {

	private String taskName;
	
	public MyTask(String name){
		this.taskName = name;
	}
	
	@Override
	public void run() {
		
		for(int i=0;i<100;i++){
			String tname = Thread.currentThread().getName();
			System.out.println(taskName + i + "["+tname+"]");
			
			
		}
		
		
	}

}
