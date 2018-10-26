import java.util.concurrent.ForkJoinTask;

public class CounterTask extends ForkJoinTask<Integer> {

	public CounterTask(Integer num) {
	super();
	this.num = num;
}

	@Override
	public Integer getRawResult() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void setRawResult(Integer value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected boolean exec() {
		while(num>0){
			num --;
			System.out.println("Numberr :"+ num);
		}
		return false;
	}

}
