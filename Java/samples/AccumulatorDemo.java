import java.util.concurrent.atomic.LongAccumulator;

public class AccumulatorDemo {

	public static void main(String[] args) {
		
		LongAccumulator acc = new LongAccumulator((x,y)->x+ (y*10), 0L);
		
		acc.accumulate(12);// 0+ (12*10)
		acc.accumulate(6);//120+ (6*10)
		
		System.out.println(acc.get());
	}

}
