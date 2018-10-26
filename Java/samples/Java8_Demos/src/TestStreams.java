import java.util.*;

public class TestStreams{

	public static void main(String []arg)
	{
		int[] nums = {1,2,3,4,5};
		
		int sum =  Arrays.stream(nums).sum();
		System.out.println(sum);
		//print only Even values
		Arrays.stream(nums).filter(e -> e%2==0)
			.forEach(System.out::println);


	}
}
